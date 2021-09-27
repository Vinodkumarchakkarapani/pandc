#include <Excel.au3>
Local $oExcel_1=_Excel_Open()
Local $sWorkbook="C:\Users\asvit\Downloads\RFR - JRSK Inc DBA Away.xlsx"
Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)
Local $sheetName="Driver & Auto List"
WinActivate($oWorkbook)
_Excel_RangeWrite($oWorkbook,$sheetName,"Hyundai","B9")
_Excel_RangeWrite($oWorkbook,$sheetName,"2015","A9")
_Excel_BookSave($oWorkbook)
_Excel_Close($oExcel_1,True,True)
