#include <Excel.au3>
Local $oExcel_1=_Excel_Open()
Local $sWorkbook="C:\Users\asvit\Downloads\RFR - JRSK Inc DBA Away.xlsx"
Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)
Local $sheetName="Equipment Exposure"
WinActivate($oWorkbook)
_Excel_RangeWrite($oWorkbook,$sheetName,"102-B","A10")
_Excel_RangeWrite($oWorkbook,$sheetName,"Avenue","B10")
_Excel_RangeWrite($oWorkbook,$sheetName,"Los Angeles","D10")
_Excel_RangeWrite($oWorkbook,$sheetName,"Street 11","C10")
_Excel_RangeWrite($oWorkbook,$sheetName,"United States","F10")
_Excel_RangeWrite($oWorkbook,$sheetName,"California","E10")
_Excel_RangeWrite($oWorkbook,$sheetName,"Test Equipment 1","H10")
_Excel_RangeWrite($oWorkbook,$sheetName,"98765-4321","G10")
_Excel_RangeWrite($oWorkbook,$sheetName,"MOD-988","J10")
_Excel_RangeWrite($oWorkbook,$sheetName,"MK24","I10")
_Excel_RangeWrite($oWorkbook,$sheetName,"Leased","L10")
_Excel_RangeWrite($oWorkbook,$sheetName,"ASE-2345#22","K10")
_Excel_RangeWrite($oWorkbook,$sheetName,"10000","M10")
_Excel_BookSave($oWorkbook)
_Excel_Close($oExcel_1,True,True)
