#include <Excel.au3>
Local $oExcel_1=_Excel_Open()
Local $sWorkbook="C:\Users\asvit\Downloads\RFR - JRSK Inc DBA Away.xlsx"
Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)
Local $sheetName="Workers Comp"
WinActivate($oWorkbook)
_Excel_RangeWrite($oWorkbook,$sheetName,"3000000","O13")
_Excel_RangeWrite($oWorkbook,$sheetName,"3000000","O12")
_Excel_RangeWrite($oWorkbook,$sheetName,"1500000","N13")
_Excel_RangeWrite($oWorkbook,$sheetName,"2000000","J12")
_Excel_RangeWrite($oWorkbook,$sheetName,"1000","I13")
_Excel_RangeWrite($oWorkbook,$sheetName,"1000","I12")
_Excel_RangeWrite($oWorkbook,$sheetName,"4000000","K13")
_Excel_RangeWrite($oWorkbook,$sheetName,"4000000","K12")
_Excel_RangeWrite($oWorkbook,$sheetName,"2000000","J13")
_Excel_RangeWrite($oWorkbook,$sheetName,"1500000","N12")
_Excel_RangeWrite($oWorkbook,$sheetName,"1000","M13")
_Excel_RangeWrite($oWorkbook,$sheetName,"1000","M12")
_Excel_BookSave($oWorkbook)
_Excel_Close($oExcel_1,True,True)
