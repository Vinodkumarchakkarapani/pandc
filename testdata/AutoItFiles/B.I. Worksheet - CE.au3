#include <Excel.au3>
Local $oExcel_1=_Excel_Open()
Local $sWorkbook="C:\Users\asvit\Downloads\RFR - JRSK Inc DBA Away.xlsx"
Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)
Local $sheetName="B.I. Worksheet - CE"
Local $aWorkSheets = _Excel_SheetList($oWorkbook)
FileDelete("D:\pandc\testdata\AutoItFiles\AutoItGeneratedFile.txt")
Local $sSearch = $sheetName
Local $sColumn = 0
$sColumn = Int($sColumn)
Local $iIndex = _ArraySearch($aWorkSheets, $sSearch, 0, 0, 0, 1, 1, $sColumn)
If @error Then
FileWrite("D:\pandc\testdata\AutoItFiles\AutoItGeneratedFile.txt",'"' & $sSearch & '" was not found')
Else
FileWrite("D:\pandc\testdata\AutoItFiles\AutoItGeneratedFile.txt",'"' & $sSearch & '" was not found')
EndIf
_Excel_Close($oExcel_1,True,True)
