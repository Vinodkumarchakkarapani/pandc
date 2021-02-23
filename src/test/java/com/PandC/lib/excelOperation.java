package com.PandC.lib;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import com.google.i18n.phonenumbers.internal.MatcherApi;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.lang3.StringUtils;


import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map;
import java.util.Properties;

public class excelOperation {

    private static Configuration config;

    /**
     * Convert given excel column name to column Index, ex 'A=0', 'AA=26'
     *
     * @param columnName
     * @return 0 based index of the column
     */
    public static int convertName2ColumnIndex(String columnName) {
        columnName = columnName.toUpperCase();
        int value = 0;
        for (int i = 0, k = columnName.length() - 1; i < columnName.length(); i++, k--) {
            int alpabetIndex = ((short) columnName.charAt(i)) - 64;
            int delta = 0;
            // last column simply add it
            if (k == 0) {
                delta = alpabetIndex - 1;
            } else { // aggregate
                if (alpabetIndex == 0)
                    delta = (26 * k);
                else
                    delta = (alpabetIndex * 26 * k);
            }
            value += delta;
        }
        return value;
    }

    public static String getColumn(String sLocation) {
        StringBuffer alpha = new StringBuffer();
        for (int i = 0; i < sLocation.length(); i++)
            if (Character.isAlphabetic(sLocation.charAt(i)))
                alpha.append(sLocation.charAt(i));
        return alpha.toString();
    }

    public static int getRow(String sLocation) {
        StringBuffer num = new StringBuffer();
        for (int i = 0; i < sLocation.length(); i++)
            if (Character.isDigit(sLocation.charAt(i)))
                num.append(sLocation.charAt(i));
        return Integer.parseInt(num.toString());
    }

    /**
     * Read data from excel file
     *
     * @param fieldValue
     * @return cell value of excel sheet
     * @throws IOException
     */
    public static String readDataFromExcel(String fieldValue) throws IOException{

        config = new Configuration();
        String excelFileName = config.app.getProperty("testDataFile");

        XSSFWorkbook testDataExcelWorkbook = new XSSFWorkbook(new FileInputStream(Paths.get(System.getProperty("user.dir"), "testdata/ExcelTestData/", excelFileName).toString()));
        String tabName = StringUtils.substringBetween(fieldValue, "(", ",").trim();
        String cell = StringUtils.substringBetween(fieldValue, ",", ")").trim();

        int iRow = getRow(cell) - 1;
        int iColumn = convertName2ColumnIndex(getColumn(cell));
        String sActualValue = "";
        try {
            switch (testDataExcelWorkbook.getSheet(tabName)
                    .getRow(iRow).getCell(iColumn).getCellType()) {
                case XSSFCell.CELL_TYPE_NUMERIC:

                        if (DateUtil.isCellDateFormatted(testDataExcelWorkbook.getSheet(tabName)
                                .getRow(iRow).getCell(iColumn))) {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                            sActualValue= dateFormat.format(testDataExcelWorkbook.getSheet(tabName)
                                    .getRow(iRow).getCell(iColumn).getDateCellValue());
                        }
                        else if (testDataExcelWorkbook.getSheet(tabName)
                                .getRow(iRow).getCell(iColumn).getCellStyle().getDataFormatString().contains("%")) {
                            sActualValue = String.valueOf(testDataExcelWorkbook.getSheet(tabName)
                                    .getRow(iRow).getCell(iColumn).getNumericCellValue() * 100);
                        } else {
                            double d=testDataExcelWorkbook.getSheet(tabName)
                                    .getRow(iRow).getCell(iColumn).getNumericCellValue();

                            if(String.valueOf(d).contains("E")){
                                sActualValue=String.format("%.0f",d);
                            }
                            else {
                                sActualValue=String.valueOf(d).replace(".0", "");
                            }
                        }

                    break;

                case XSSFCell.CELL_TYPE_STRING:

                    sActualValue = testDataExcelWorkbook.getSheet(tabName)
                            .getRow(iRow).getCell(iColumn).getStringCellValue();
                    break;
                default:
                    break;
            }
        } catch (NullPointerException ex) {
            throw ex;
        }
        return sActualValue;
    }

    /**
     * Read error message from excel file
     *
     * @param fieldName
     * @return
     * @throws IOException
     */
    public static String getErrorMessage(String fieldName) throws IOException {

        String excelName;
        String sheetName;
        String cell;

        String newField=StringUtils.substringBetween(fieldName,"(",")");

        if(newField.contains("(")){
            excelName=StringUtils.substringBetween(fieldName,"(",",");
            sheetName=StringUtils.substringBetween(fieldName,",",",");
            String[] values=StringUtils.substringBetween(fieldName,")",")").split(",");
            cell=values[1];
        }else{
            String str[] = newField.split(",");
            excelName=str[0];
            sheetName= str[1];
            cell=str[2];
        }
        String fileName=System.getProperty("user.home")
                + "\\Downloads\\" + excelName;

        int iRow = getRow(cell) - 1;
        int iColumn = convertName2ColumnIndex(getColumn(cell));

        String errorMessage = null;

        try {
            FileInputStream fsIP = new FileInputStream(new File(fileName));
            XSSFWorkbook wb = new XSSFWorkbook(fsIP);
            XSSFSheet worksheet = wb.getSheet(sheetName);

            List<XSSFDataValidation> lstValidation = worksheet.getDataValidations();

            boolean isfound=false;
            for (XSSFDataValidation validation : lstValidation) {
                if(isfound)
                    break;
                for (CellRangeAddress rangeAddress : validation.getRegions().getCellRangeAddresses()) {
                    if(isfound)
                        break;
                    for (int r = 0; r < worksheet.getLastRowNum() && !isfound; r++)
                        for (int k = 0; k < worksheet.getRow(r).getLastCellNum() && !isfound; k++) {
                            if (rangeAddress.isInRange(r, k) && k==iColumn && r==iRow) {
                                DataValidationConstraint constraint = validation.getValidationConstraint();
                                errorMessage=validation.getErrorBoxText().replace("\n"," ").trim();
                                isfound=true;
                            }
                        }
                }
            }
        }catch (Exception e){
            throw  e;
        }
        return errorMessage;
    }

    /**
     * Read formula from excel sheet
     *
     * @param fieldName
     * @return cell formula from excel tab
     * @throws IOException
     */
    public static String getFormula(String fieldName) throws IOException {
        String excelName;
        String sheetName;
        String cell;

        String newField=StringUtils.substringBetween(fieldName,"(",")");


        if(newField.contains("(")){
            excelName=StringUtils.substringBetween(fieldName,"(",",");
            sheetName=StringUtils.substringBetween(fieldName,",",",");
            String[] values=StringUtils.substringBetween(fieldName,")",")").split(",");
            cell=values[1];
        }else{
            String str[] = newField.split(",");
            excelName=str[0];
            sheetName= str[1];
            cell=str[2];
        }
        String fileName=System.getProperty("user.home")
                + "\\Downloads\\" + excelName;

        int iRow = getRow(cell) - 1;
        int iColumn = convertName2ColumnIndex(getColumn(cell));

        String formula = null;

        try {
            FileInputStream fsIP = new FileInputStream(new File(fileName));
            XSSFWorkbook wb = new XSSFWorkbook(fsIP);
            XSSFSheet worksheet = wb.getSheet(sheetName);

            List<XSSFDataValidation> lstValidation = worksheet.getDataValidations();

            boolean isfound=false;
            for (XSSFDataValidation validation : lstValidation) {
                if(isfound)
                    break;
                for (CellRangeAddress rangeAddress : validation.getRegions().getCellRangeAddresses()) {
                    if(isfound)
                        break;
                    for (int r = 0; r < worksheet.getLastRowNum()  && !isfound; r++)
                        for (int k = 0; k < worksheet.getRow(r).getLastCellNum() && !isfound; k++) {
                            if (rangeAddress.isInRange(r, k) && k==iColumn && r==iRow ) {
                                DataValidationConstraint constraint = validation.getValidationConstraint();
                                formula=((XSSFDataValidationConstraint) constraint).prettyPrint().trim();
                                isfound=true;
                            }
                        }
                }
            }
        }catch (Exception e){
            throw  e;
        }
        return formula;
    }

    /**
     * Generate AutoIt script for write data in excel sheet
     *
     * @param sheetName
     * @param data
     * @param excelFileName
     */
    public static void writeDataUsingAutoItScript(String sheetName,Map<String,String> data,String excelFileName) {
        try {
            String autoItScriptName = Paths.get(System.getProperty("user.dir"), "testdata/AutoItFiles/", sheetName + ".au3").toString();
            String excelFile = System.getProperty("user.home")
                    + "\\Downloads\\" + excelFileName;

            File file = new File(excelFile);
            if (file.exists()) {
                System.out.println("File not exist in " + excelFile + " directory");
            } else {
                excelFile = Paths.get(System.getProperty("user.dir"), "testdata/ExcelTestData/", sheetName).toString();
                System.out.println("File exist in " + excelFile + " directory");
            }

            PrintWriter writer = new PrintWriter(autoItScriptName, "UTF-8");
            writer.println("#include <Excel.au3>");
            writer.println("Local $oExcel_1=_Excel_Open()");
            writer.println("Local $sWorkbook=\"" + excelFile + "\"");
            writer.println("Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)");
            writer.println("Local $sheetName=\"" + sheetName + "\"");
            writer.println("WinActivate($oWorkbook)");
            for (Map.Entry m : data.entrySet()) {
                writer.println("_Excel_RangeWrite($oWorkbook,$sheetName,\"" + m.getValue() + "\",\"" + m.getKey() + "\")");
            }
            writer.println("_Excel_BookSave($oWorkbook)");
            writer.println("_Excel_Close($oExcel_1,True,True)");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate AutoIt script for remove sheet(tab) from excel file
     *
     * @param sheetName
     * @param excelFileName
     */
    public static void removeExcelSheetUsingAutoItScript(String sheetName,String excelFileName){
        try {
            String autoItScriptName=Paths.get(System.getProperty("user.dir"), "testdata/AutoItFiles/",sheetName+".au3").toString();
            String excelFile=System.getProperty("user.home")
                    + "\\Downloads\\" + excelFileName;

            PrintWriter writer = new PrintWriter(autoItScriptName, "UTF-8");
            writer.println("#include <Excel.au3>");
            writer.println("Local $oExcel_1=_Excel_Open()");
            writer.println("Local $sWorkbook=\""+excelFile+"\"");
            writer.println("Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)");
            writer.println("Local $sheetName=\""+sheetName+"\"");
            writer.println("_Excel_SheetDelete($oWorkbook,$sheetName)");
            writer.println("_Excel_BookSave($oWorkbook)");
            writer.println("_Excel_Close($oExcel_1,True,True)");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Generate AutoIt script for add sheet(tab) in excel file
     *
     * @param sheetName
     * @param excelFileName
     */
    public static void addExcelSheetUsingAutoItScript(String sheetName,String excelFileName){
        try {
            String autoItScriptName=Paths.get(System.getProperty("user.dir"), "testdata/AutoItFiles/",sheetName+".au3").toString();
            String excelFile=System.getProperty("user.home")
                    + "\\Downloads\\" + excelFileName;

            PrintWriter writer = new PrintWriter(autoItScriptName, "UTF-8");
            writer.println("#include <Excel.au3>");
            writer.println("Local $oExcel_1=_Excel_Open()");
            writer.println("Local $sWorkbook=\""+excelFile+"\"");
            writer.println("Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)");
            writer.println("Local $sheetName=\""+sheetName+"\"");
            writer.println("_Excel_SheetAdd($oWorkbook,-1, False, 1, $sheetName)");
            writer.println("_Excel_BookSave($oWorkbook)");
            writer.println("_Excel_Close($oExcel_1,True,True)");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Generate AutoIt script for add row in sheet(tab) into excel file
     *
     * @param sheetName
     * @param excelFileName
     * @param rownumber
     */
    public static void addRowInSheetUsingAutoItScript(String sheetName,String excelFileName, int rownumber) {
        try {
            String autoItScriptName=Paths.get(System.getProperty("user.dir"), "testdata/AutoItFiles/",sheetName+".au3").toString();
            String excelFile=System.getProperty("user.home")
                    + "\\Downloads\\" + excelFileName;

            PrintWriter writer = new PrintWriter(autoItScriptName, "UTF-8");
            writer.println("#include <Excel.au3>");
            writer.println("Local $oExcel_1=_Excel_Open()");
            writer.println("Local $sWorkbook=\""+excelFile+"\"");
            writer.println("Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)");
            writer.println("Local $sheetName=\""+sheetName+"\"");
            writer.println("$oWorkbook.Sheets($sheetName).Activate");
            writer.println("_Excel_RangeInsert($oWorkbook.Activesheet,\""+rownumber+":"+rownumber+"\")");
            writer.println("_Excel_BookSave($oWorkbook)");
            writer.println("_Excel_Close($oExcel_1,True,True)");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *  Generate AutoIt script for remove row from sheet(tab) into excel file
     *
     * @param sheetName
     * @param excelFileName
     * @param rownumber
     */
    public static void removeRowInSheetFromAutoItScript(String sheetName,String excelFileName, int rownumber) {
        try {
            String autoItScriptName=Paths.get(System.getProperty("user.dir"), "testdata/AutoItFiles/",sheetName+".au3").toString();
            String excelFile=System.getProperty("user.home")
                    + "\\Downloads\\" + excelFileName;

            PrintWriter writer = new PrintWriter(autoItScriptName, "UTF-8");
            writer.println("#include <Excel.au3>");
            writer.println("Local $oExcel_1=_Excel_Open()");
            writer.println("Local $sWorkbook=\""+excelFile+"\"");
            writer.println("Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)");
            writer.println("Local $sheetName=\""+sheetName+"\"");
            writer.println("$oWorkbook.Sheets($sheetName).Activate");
            writer.println("_Excel_RangeDelete($oWorkbook.Activesheet,\""+rownumber+":"+rownumber+"\")");
            writer.println("_Excel_BookSave($oWorkbook)");
            writer.println("_Excel_Close($oExcel_1,True,True)");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *  Generate AutoIt script for find sheetname from excel file
     *
     * @param excelFileName
     * @param sheetName
     */
    public static void findSheetNameUsingAutoItScript(String excelFileName,String sheetName) {
        try {
            String autoItScriptName=Paths.get(System.getProperty("user.dir"), "testdata/AutoItFiles/",sheetName+".au3").toString();
            String excelFile=System.getProperty("user.home")
                    + "\\Downloads\\" + excelFileName;

            String generatedFilePath=Paths.get(System.getProperty("user.dir"), "testdata/AutoItFiles/AutoItGeneratedFile.txt").toString();

            PrintWriter writer = new PrintWriter(autoItScriptName, "UTF-8");
            writer.println("#include <Excel.au3>");
            writer.println("Local $oExcel_1=_Excel_Open()");
            writer.println("Local $sWorkbook=\""+excelFile+"\"");
            writer.println("Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)");
            writer.println("Local $sheetName=\""+sheetName+"\"");
            writer.println("Local $aWorkSheets = _Excel_SheetList($oWorkbook)");
            writer.println("FileDelete(\""+generatedFilePath+"\")");
            writer.println("Local $sSearch = $sheetName");
            writer.println("Local $sColumn = 0");
            writer.println("$sColumn = Int($sColumn)");
            writer.println("Local $iIndex = _ArraySearch($aWorkSheets, $sSearch, 0, 0, 0, 1, 1, $sColumn)");
            writer.println("If @error Then");
            writer.println("FileWrite(\""+generatedFilePath+"\",'\"' & $sSearch & '\" was not found')");
            writer.println("Else");
            writer.println("FileWrite(\""+generatedFilePath+"\",'\"' & $sSearch & '\" was not found')");
            writer.println("EndIf");
            writer.println("_Excel_Close($oExcel_1,True,True)");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Read cell comments from excel file
     *
     * @param excelFileName
     * @param sheetName
     * @param cell
     */
    public static  void readCommentsExcel(String excelFileName,String sheetName,String cell){
        try {
            String autoItScriptName=Paths.get(System.getProperty("user.dir"), "testdata/AutoItFiles/",sheetName+".au3").toString();
            String excelFile=System.getProperty("user.home")
                    + "\\Downloads\\" + excelFileName;

            String generatedFilePath=Paths.get(System.getProperty("user.dir"), "testdata/AutoItFiles/AutoItGeneratedFile.txt").toString();

            PrintWriter writer = new PrintWriter(autoItScriptName, "UTF-8");
            writer.println("#include <Excel.au3>");
            writer.println("Local $oExcel_1=_Excel_Open()");
            writer.println("Local $sWorkbook=\""+excelFile+"\"");
            writer.println("Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)");
            writer.println("Local $sheetName=\""+sheetName+"\"");
            writer.println("$oWorkbook.Sheets(\""+sheetName+"\").Activate");
            writer.println("$cmt = $oWorkbook.ActiveSheet.Range(\""+cell+":"+cell+"\").Comment.text");
            writer.println("ConsoleWrite(@crlf&\"This is a comment: \" &$cmt&@crlf)");
            writer.println("FileDelete(\""+generatedFilePath+"\")");
            writer.println("FileWrite(\""+generatedFilePath+"\",$cmt)");
            writer.println("_Excel_Close($oExcel_1,True,True)");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}