package com.PandC.lib;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.lang3.StringUtils;


import java.awt.datatransfer.StringSelection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public static String readDataFromExcel(String fieldValue) throws IOException {

        XSSFWorkbook testDataExcelWorkbook = new XSSFWorkbook();
        config = new Configuration();
        String excelFileName= config.app.getProperty("TestDataFile");

        testDataExcelWorkbook = new XSSFWorkbook(new FileInputStream(Paths.get(System.getProperty("user.dir"), "testdata/ExcelTestData/",excelFileName ).toString()));
        String tabname=StringUtils.substringBetween(fieldValue, "(", ",");
        String cell=StringUtils.substringBetween(fieldValue, ",", ")");

        int iRow = getRow(cell) - 1;
        int iColumn = convertName2ColumnIndex(getColumn(cell));
        String sActualValue = "";
        try {
            switch (testDataExcelWorkbook.getSheet(tabname)
                    .getRow(iRow).getCell(iColumn).getCellType()) {
                case XSSFCell.CELL_TYPE_NUMERIC:

                    sActualValue = String.valueOf(testDataExcelWorkbook.getSheet(tabname)
                            .getRow(iRow).getCell(iColumn).getNumericCellValue());
                    break;
                case XSSFCell.CELL_TYPE_STRING:

                    sActualValue = testDataExcelWorkbook.getSheet(tabname)
                            .getRow(iRow).getCell(iColumn).getStringCellValue();
                    break;
                default:
                    break;
            }
        } catch (NullPointerException ex) {
        }
        String valueToType = sActualValue.replaceAll("[\\t\\n\\r]+", " ")
                .replaceAll("[^\\x00-\\x7F]", " ").trim();

        return  valueToType;
    }
}
