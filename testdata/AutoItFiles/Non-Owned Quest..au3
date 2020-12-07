#include <Excel.au3>
Local $oExcel_1=_Excel_Open()
Local $sWorkbook="C:\Users\monica.dayal\Downloads\RFR - JRSK Inc DBA Away.xlsx"
Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)
Local $sheetName="Non-Owned Quest."
WinActivate($oWorkbook)
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","C11")
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","C10")
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","B8")
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","B9")
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","C8")
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","C9")
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","B10")
_Excel_RangeWrite($oWorkbook,$sheetName,"abcd@","B11")
_Excel_BookSave($oWorkbook)
_Excel_Close($oExcel_1,True,True)
