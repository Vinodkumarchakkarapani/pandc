#include <Excel.au3>
Local $oExcel_1=_Excel_Open()
Local $sWorkbook="C:\Users\asvit\Downloads\RFR - JRSK Inc DBA Away.xlsx"
Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)
Local $sheetName="Revenue & Liability Limits"
WinActivate($oWorkbook)
_Excel_RangeWrite($oWorkbook,$sheetName,"15000","B10")
_Excel_RangeWrite($oWorkbook,$sheetName,"2000000","C10")
_Excel_BookSave($oWorkbook)
_Excel_Close($oExcel_1,True,True)
