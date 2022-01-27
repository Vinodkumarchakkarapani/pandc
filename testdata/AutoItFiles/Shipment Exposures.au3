#include <Excel.au3>
Local $oExcel_1=_Excel_Open()
Local $sWorkbook="D:\pandc\testdata\ExcelTestData\Shipment Exposures"
Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)
Local $sheetName="Shipment Exposures"
WinActivate($oWorkbook)
_Excel_RangeWrite($oWorkbook,$sheetName,"10000","D52")
_Excel_RangeWrite($oWorkbook,$sheetName,"15000","D51")
_Excel_RangeWrite($oWorkbook,$sheetName,"10000","D54")
_Excel_RangeWrite($oWorkbook,$sheetName,"10000","D53")
_Excel_RangeWrite($oWorkbook,$sheetName,"10000","D56")
_Excel_RangeWrite($oWorkbook,$sheetName,"10000","D55")
_Excel_RangeWrite($oWorkbook,$sheetName,"10000","B37")
_Excel_RangeWrite($oWorkbook,$sheetName,"10000","D57")
_Excel_RangeWrite($oWorkbook,$sheetName,"10000","B38")
_Excel_RangeWrite($oWorkbook,$sheetName,"10000","B39")
_Excel_BookSave($oWorkbook)
_Excel_Close($oExcel_1,True,True)
