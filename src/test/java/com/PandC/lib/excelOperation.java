package com.PandC.lib;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.apache.commons.lang3.StringUtils;


import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

public class excelOperation {

    private static Configuration config;
    /**
     * Convert given excel column name to column Index, ex 'A=0', 'AA=26'
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

    public static String getColumn(String sLocation){
        StringBuffer alpha = new StringBuffer();
        for (int i=0; i<sLocation.length(); i++)
            if(Character.isAlphabetic(sLocation.charAt(i)))
                alpha.append(sLocation.charAt(i));
        return alpha.toString();
    }

    public static int getRow(String sLocation){
        StringBuffer num = new StringBuffer();
        for (int i=0; i<sLocation.length(); i++)
            if(Character.isDigit(sLocation.charAt(i)))
                num.append(sLocation.charAt(i));
        return Integer.parseInt(num.toString());
    }

    public static String readDataFromExcel(String fieldValue) throws IOException{

        config = new Configuration();
        String excelFileName= config.app.getProperty("testDataFile");

        XSSFWorkbook testDataExcelWorkbook = new XSSFWorkbook(new FileInputStream(Paths.get(System.getProperty("user.dir"), "testdata/ExcelTestData/",excelFileName ).toString()));
        String tabName=StringUtils.substringBetween(fieldValue, "(", ",").trim();
        String cell=StringUtils.substringBetween(fieldValue, ",", ")").trim();

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
            throw  ex;
        }
        return  sActualValue;
    }

    public static String getErrorMessage(String fieldName) throws IOException {

        String excelName;
        String sheetName;
        String cell;

        String newField=StringUtils.substringBetween(fieldName,"(",")");

        if(newField.contains("(")){
            excelName=StringUtils.substringBetween(fieldName,"(",",");
            sheetName=StringUtils.substringBetween(fieldName,",",",");
            cell=StringUtils.substringBetween(fieldName,")",")").replace(",","");
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

    public static String getFormula(String fieldName) throws IOException {
        String excelName;
        String sheetName;
        String cell;

        String newField=StringUtils.substringBetween(fieldName,"(",")");

        if(newField.contains("(")){
            excelName=StringUtils.substringBetween(fieldName,"(",",");
            sheetName=StringUtils.substringBetween(fieldName,",",",");
            cell=StringUtils.substringBetween(fieldName,")",")").replace(",","");
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
}
