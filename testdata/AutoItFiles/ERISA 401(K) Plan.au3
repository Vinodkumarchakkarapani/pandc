#include <Excel.au3>
Local $oExcel_1=_Excel_Open()
Local $sWorkbook="C:\Users\asvit\Downloads\RFR - JRSK Inc DBA Away.xlsx"
Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)
Local $sheetName="ERISA 401(K) Plan"
WinActivate($oWorkbook)
_Excel_RangeWrite($oWorkbook,$sheetName,"Plan1","A11")
_Excel_RangeWrite($oWorkbook,$sheetName,"Avenue","B11")
_Excel_RangeWrite($oWorkbook,$sheetName,"Los Angeles","C11")
_Excel_RangeWrite($oWorkbook,$sheetName,"CA","D11")
_Excel_RangeWrite($oWorkbook,$sheetName,"12","G11")
_Excel_RangeWrite($oWorkbook,$sheetName,"123456789","F11")
_Excel_RangeWrite($oWorkbook,$sheetName,"500000","I11")
_Excel_RangeWrite($oWorkbook,$sheetName,"12","H11")
_Excel_RangeWrite($oWorkbook,$sheetName,"20000","J11")
_Excel_BookSave($oWorkbook)
_Excel_Close($oExcel_1,True,True)
