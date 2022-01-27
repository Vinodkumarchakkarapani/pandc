#include <Excel.au3>
Local $oExcel_1=_Excel_Open()
Local $sWorkbook="C:\Users\asvit\Downloads\RFR - JRSK Inc DBA Away.xlsx"
Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)
Local $sheetName="Property (SOV)"
WinActivate($oWorkbook)
_Excel_RangeWrite($oWorkbook,$sheetName,"123456789123","I9")
_Excel_RangeWrite($oWorkbook,$sheetName,"123456789123","S9")
_Excel_RangeWrite($oWorkbook,$sheetName,"123456789123","M9")
_Excel_RangeWrite($oWorkbook,$sheetName,"123456789123","L9")
_Excel_RangeWrite($oWorkbook,$sheetName,"123456789123","K9")
_Excel_RangeWrite($oWorkbook,$sheetName,"123456789123","J9")
_Excel_BookSave($oWorkbook)
_Excel_Close($oExcel_1,True,True)
