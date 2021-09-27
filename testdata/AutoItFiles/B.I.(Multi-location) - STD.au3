#include <Excel.au3>
Local $oExcel_1=_Excel_Open()
Local $sWorkbook="C:\Users\asvit\Downloads\RFR - JRSK Inc DBA Away.xlsx"
Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)
Local $sheetName="B.I.(Multi-location) - STD"
_Excel_SheetAdd($oWorkbook,-1, False, 1, $sheetName)
_Excel_BookSave($oWorkbook)
_Excel_Close($oExcel_1,True,True)
