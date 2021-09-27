#include <Excel.au3>
Local $oExcel_1=_Excel_Open()
Local $sWorkbook="C:\Users\asvit\Downloads\RFR - JRSK Inc DBA Away.xlsx"
Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)
Local $sheetName="B.I.(Single-Location) - STD"
WinActivate($oWorkbook)
_Excel_RangeWrite($oWorkbook,$sheetName,"400","B10")
_Excel_RangeWrite($oWorkbook,$sheetName,"0.95","C10")
_Excel_BookSave($oWorkbook)
_Excel_Close($oExcel_1,True,True)
