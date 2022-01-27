#include <Excel.au3>
Local $oExcel_1=_Excel_Open()
Local $sWorkbook="C:\Users\asvit\Downloads\RFR - JRSK Inc DBA Away.xlsx"
Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)
Local $sheetName="Product Flow"
WinActivate($oWorkbook)
_Excel_RangeWrite($oWorkbook,$sheetName,"Test Product 4","A10")
_Excel_RangeWrite($oWorkbook,$sheetName,"Sub Components 4","B10")
_Excel_BookSave($oWorkbook)
_Excel_Close($oExcel_1,True,True)
