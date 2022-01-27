#include <Excel.au3>
Local $oExcel_1=_Excel_Open()
Local $sWorkbook="C:\Users\asvit\Downloads\RFR - JRSK Inc DBA Away.xlsx"
Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)
Local $sheetName="Product Transit Info"
WinActivate($oWorkbook)
_Excel_RangeWrite($oWorkbook,$sheetName,"Test Product 1","A15")
_Excel_RangeWrite($oWorkbook,$sheetName,"Sub Component Test Product 1","B15")
_Excel_BookSave($oWorkbook)
_Excel_Close($oExcel_1,True,True)
