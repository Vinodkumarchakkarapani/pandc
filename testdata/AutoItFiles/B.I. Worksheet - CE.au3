#include <Excel.au3>
Local $oExcel_1=_Excel_Open()
Local $sWorkbook="C:\Users\monica.dayal\Downloads\RFR - JRSK Inc DBA Away.xlsx"
Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)
Local $sheetName="B.I. Worksheet - CE"
WinActivate($oWorkbook)
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","C22")
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","C23")
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","B11")
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","B12")
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","B13")
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","B15")
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","B17")
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","B18")
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","B19")
_Excel_BookSave($oWorkbook)
_Excel_Close($oExcel_1,True,True)
