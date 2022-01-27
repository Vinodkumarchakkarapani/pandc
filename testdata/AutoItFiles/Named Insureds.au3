#include <Excel.au3>
Local $oExcel_1=_Excel_Open()
Local $sWorkbook="C:\Users\asvit\Downloads\RFR - JRSK Inc DBA Away.xlsx"
Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)
Local $sheetName="Named Insureds"
WinActivate($oWorkbook)
_Excel_RangeWrite($oWorkbook,$sheetName,"123456789","C10")
_Excel_BookSave($oWorkbook)
_Excel_Close($oExcel_1,True,True)
