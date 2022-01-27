#include <Excel.au3>
Local $oExcel_1=_Excel_Open()
Local $sWorkbook="C:\Users\asvit\Downloads\RFR - JRSK Inc DBA Away.xlsx"
Local $oWorkbook=_Excel_BookOpen($oExcel_1,$sWorkbook)
Local $sheetName="Transit Location Inventory"
$oWorkbook.Sheets("Transit Location Inventory").Activate
$cmt = $oWorkbook.ActiveSheet.Range("AQ8:AQ8").Comment.text
ConsoleWrite(@crlf&"This is a comment: " &$cmt&@crlf)
FileDelete("D:\pandc\testdata\AutoItFiles\AutoItGeneratedFile.txt")
FileWrite("D:\pandc\testdata\AutoItFiles\AutoItGeneratedFile.txt",$cmt)
_Excel_Close($oExcel_1,True,True)
