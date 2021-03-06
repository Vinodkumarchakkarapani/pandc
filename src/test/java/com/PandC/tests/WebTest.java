package com.PandC.tests;

import com.PandC.lib.WebActions;
import com.PandC.lib.excelOperation;
import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import com.galenframework.speclang2.pagespec.SectionFilter;
import com.galenframework.validation.ValidationResult;
import com.periscope.qviz.client.QVizClient;
import com.periscope.qviz.json.*;
import com.PandC.lib.Browser;
import com.PandC.lib.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;

import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DynamicTest;
//import org.junit.jupiter.api.TestFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.expression.StandardBeanExpressionResolver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import com.PandC.tests.srNOSort;
/**/
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.zip.ZipOutputStream;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;

/**
 * Testing Class for GUI Tests (Front-end Testing)
 */
public class WebTest {

    private static Logger logger;
    private static Logger logger_performance;
    private static SimpleDateFormat fileFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
    private static Configuration config;
    private static boolean isSetUp = true;
    private static QVizClient qifClient;
    private static Project project1;
    private static Project project2;
    private static Project project3;
    private static Project project4;
    private static List<TestCaseGUI> guiTestCases = new ArrayList<>();
    private static List<TestCaseGUI> guiTestCases_performance_Tests = new ArrayList<>();
    private static List<TestCaseGUI> guiTestCases_UIValidation_Tests = new ArrayList<>();
    String Exportdatetime= "";
    String Importdatetime= "";

    @BeforeSuite
    static void
    setUp() {

        // Specify the list of selected tests to execute and this is applicable only if app.gui.executeselectedTCs is set to true

        List<String> listOfTCstoExecute = Arrays.asList(

//            "1. PS001 - To verify user navigates to Insurance Renewal List dashboard on clicking Request For Renewal Tile in home page"

//                //General Information Page - P&C
//            "1. PS001 - To verify user navigates to Insurance Renewal List dashboard on clicking Request For Renewal Tile in home page",
//            "2. PS002 - To verify user is able to navigate back to Home page while clicking the Forms link in the breadcrumb",
//            "3. PS003 - Verify user is able to search the Renewal records for a particular Account Handler by selecting name of the handler in search",
//            "4. PS004 - Verify user is able to navigate to next page in the grid by clicking on page number in pagination",
//            "5. PS007 - Verify user is able to search a record by Name Insured",
//            "6. PS008 - Verify user is able to search a record by \"Policy From\"",
//            "7. PS009 - Verify user is able to search a record by \"Policy To\"",
//            "8. PS005 - Verify Delete option is displayed only for the records in ???Draft??? status in the grid",
//            "9. PS013 - Verify user is able to search a record by Status",
//            "10. PS006 - Verify user is displayed No records Found when no records are present for the searched criteria",
//            "11. PS010 - Verify user is able to search a record by Primary Contact",
//            "12. PS014 - Verify user is displayed General Information page along with - \"Cover Page??? as default",
//            "13. PS024 - Verify user is navigated to Insurance Renewal List page on clicking cancel Button on Cover page",
//            "14. PS023 - Verify user is displayed the message - \"Please enter the fields marked as mandatory to continue further.??? When user clicks on Continue button without entering the mandatory fields in Cover Page",
//            "15. PS192 - RFR->Cover Page Renewal Type Required field - validate error (Red border -Indicating error no field) is displayed in case of invalid date",
//            "16. In Cover Page, for Renewal Type - Verify Life Science checkbox is not displayed",
//            "17. PS189 - Validate error message is displayed for From Date on Cover Page",
//            "18. PS191 - Validate the Alert Pop Up is displayed properly for Blank Date in Cover Page",
//            "19. PS193 - RFR-> Cover page In case of Renewal Type not selected, user is not able to navigate to Named Insureds",
//            "20. PS015 - Verify user is able enter details in Cover Page and navigate to Insured Names tab",
//            "21. PS188 - Validate error message should display for invalid Date on Cover page",
//            "22. PS031 - Verify user is able to add details in Named Insured grid by clicking on Add Row",
//            "23. PS035 - Verify the status of the created record is Draft in Insurance Renewal List page on clicking Save and Close button in Insured Name Tab",
//            "24. PS032 - Verify user is able to add another row of details in Name Insured grid by clicking on add Row",
//            "25. PS034 - Verify user is directed back to Insurance Renewal List page on clicking Save and Close Button on Named Insured Tab",
//            "26. PS030 - Verify the proposed date displayed in Insured Name tab is same as the proposed date in the Cover page tab",
//            "27. Verify validation error messages on the Name Insured Tab",
//            "28. Verify new application changes on the Name Insured Tab",
//            "29. In General Information tab - Verify Premium & Loss History tab is marked as Not Applicable by default",
//            "30. PS036 - Verify User is able to enter details in Premium & Loss History Tab",
//            "31. PS037 - To verify user navigates to Property Exposure Tab and Property (Statement of Values) tab is displayed as default",
//
//            //Property (SOV) Tab
//            "32. In Property (SOV), Verify \"Add Column\" button is removed from the Property Sov tab",
//            "33. In Property Sov, Verify user is able to see ???Show/Hide Columns(s)??? button at the top of the table in Property Sov tab",
//            "34. In Property (Sov) Verify user clicks on the Show/Hide Column(s) button, the system displays an overlay screen with the list of possible column are broadly grouped into 7 different groups based on business logic. The group names are a. Building Value b. Business Income c. Building Details d. Building Contents e. Additional Details f. Fire Protection g. Security",
//            "35. In Property (SOV) Verify user is displayed list of columns required under ???Building Value???, the following columns are a. Murals b. Sheds c. Fencing Gates d. Building Replacement Value e. Tenant Improvements Replacement Values f. Other Building Value",
//            "36. In Property (SOV) for Building Value, Verify user is able to enable or disable the columns by clicking on the checkbox,the following columns are a. Murals b. Sheds c. Fencing Gates d. Other Building Value",
//            "37. In Property sov for ???Building Value, Verify user is able to insert column in respective position on selecting the column name and clicking ???apply??? button for the following columns a. Murals b. Sheds c. Fencing Gates d. Other Building Value",
//            "38. In Property sov for Building Value,Verify validation error messages for the following columns are a. Murals b. Sheds c. Fencing Gates d. Other Building Value",
//            "39. In Property sov for ???Building Value, Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted columns,the following columns are a. Murals b. Sheds c. Fencing Gates d. Other Building Value",
//            "40. In Property sov for ???Building Value, Verify \"Building Replacement Value\" & Tenant \"Improvements Replacement Values\" column is pre-selected and disabled so that the column automatically appears on the table.",
//            "41. In Property Sov, Verify user is displayed list of columns required under \"Business Income\",the following columns are 1. Aggregate BI 2. Detailed BI a. R&D BI b. G&A BI c. Sales BI d. Other BI e. Manufacturing BI",
//            "42. In Property sov for Business Income, Verify by default, the ???Aggregate BI??? option box is selected and user is able to change it.",
//            "43. In Property sov for Business Income, Verify on Selecting the ???Aggregate BI??? option box is automatically select the only column name ???Total BI Values??? under this section and the user is not be allowed to deselect the checkbox.",
//            "44. In Property sov for Business Income, Verify user is able to insert column ???Total BI Value??? in respective position on selecting the ???Aggregate BI??? and clicking ???apply??? button",
//            "45. In Property sov for ???Business Income???, Verify validation error messages for \"Total BI Value??? column inserted on table",
//            "46. In Property sov for ???Business Income, Verify user is able to enter correct given value (Numbers (0-9), $, Comma(,), Decimal(.)) in inserted currency formatted \"Total BI Value??? column on table",
//            "47. In Property (SOV) for \"Business Income\", Verify the user selecting the \"Detailed BI\" option box is enable below columns for user selections: a. R&D BI b. G&A BI c. Sales BI d. Other BI e. Manufacturing BI",
//            "48. In Property (SOV) for \"Business Income\", Verify user is able to enable or disable the columns under \"Detailed BI\" by clicking on the checkbox, the following columns are a. R&DBI b. G&A BI c. Sales BI d. Other BI e. Manufacturing BI",
//            "49. In Property (SOV) for \"Business Income\", Verify user is able to insert column in respective position on selecting the column name under \"Detailed BI\" section and clicking \"apply\" button, the following columns are a. R&DBI b. G&A BI c. Sales BI d. Other BI e. Manufacturing BI",
//            "50. In Property sov for \"Business Income\", Verify validation error messages for column inserted on table, the following columns are a. R&D BI b. G&A BI c. Sales BI d. Other BI e. Manufacturing BI",
//            "51. In Property (SOV) for \"Business Income\",Verify user is able to enter correct given value (Numbers (0-9), $, Comma(,), Decimal(.)) in inserted currency formatted Columns. the following columns are a. R&D BI b. G&A BI c. Sales BI d. Other BI e. Manufacturing BI",
//            "52. In Property (SOV) for \"Business Income\", Verify user display an inline message \"Select at least one Business Income under Detailed BI\" on the top of the overlay on clicking the \"apply\" button without selecting any of the column under \"Detailed BI\" option",
//            "53. In Property (SOV) for \"Business Income\", Verify automatically add \"Total BI Value\" column along with selected column names on enabling at least one column from \"Detailed BI\"",
//            "54. In Property (SOV) for \"Business Income\", Verify added \"Total BI Value\" column is non-editable, auto computed, currency formatted, two decimal place round off",
//            "55. In Property sov for \"Business Income\", Verify Formula \"Total BI Value\" is Sum of all selected \"Detailed BI\" columns",
//            "56. In Property (SOV), Verify user is displayed list of columns required under \"Building Details\", the following columns are a. Building Use (i.e. office, warehouse, etc.) b. Total Area Sq. Ft c. Occupied Floor area Sq.Ft. d. % Occupied e. Owned/Leased f. Construction Type g. Year Built h. # of Stories",
//            "57. In Property (SOV) for \"Building Details\", Verify by default columns is pre-selected and disabled so that the column automatically appears on the table, the following columns are a. Building Use (i.e. office, warehouse, etc.) b. Total Area Sq. Ft c. % Occupied d. Owned/Leased e. Construction Type f. Year Built g. # of Stories",
//            "57.1. Property SOV - For the Drop down Building Use, Verify the following new values are displayed in the drop down list.: 1. Clean Rooms 2. Laboratories 3. Supply Chain / Contract Manufacturer 4. Vivarium",
//            "57.2. In Property (SOV) tab- verify user is able to view the newly added Columns in the Show / hide Overlay. 1. Building Use Detail - next to Building Use column",
//            "58. In Property (SOV) for \"Building Details\", Verify user is able to enable or disable the \"Occupied Floor area Sq.Ft.\" column by clicking on the checkbox",
//            "59. In Property (SOV) for \"Building Details\", Verify user is able to insert \"Occupied Floor area Sq.Ft\" column in respective position on selecting the column name and clicking \"apply\" button",
//            "60. In Property (SOV) for \"Building Details\", Verify validation error messages of \"Occupied Floor area Sq.Ft.\" column",
//            "61. In Property sov for ???Building Details???, Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted \"Occupied Floor area Sq.Ft \" column",
//            "62. In Property sov , Verify user is able to see under ???Building Contents???, the columns are further sub-categorized as Detailed Building Contents & Aggregate Building Contents",
//            "63. In Property sov for ???Building Contents???, Verify user able to see the columns are grouped further as \"Contents Replacement Cost'' & ''Selling Price '' under Detailed Building Contents",
//            "64. In Property sov for ???Building Contents???, Verify User is displayed list of columns required under ???Replacement Cost???, columns are Cased Goods,Computer Hardware, Servers, Finished Stock Ready for Sale,Furniture & Fixtures,Irreplaceable Bulk Beverage, Irrigation Pipeline,Machinery/ Equipment /Molds,Mfg. or Lab Equipment,Perishable Property,Raw Materials & WIP (Not Spoilage/ Temperature Sensitive), Raw Materials & WIP,Replaceable Bulk Beverage,R&D Inventory,Spoilage",
//            "65. In Property sov for ???Building Contents???, Verify user is able to enable or disable the columns under ???Replacement Cost??? by clicking on the checkbox,the following columns are (Cased Goods,Computer Hardware, Servers, Finished Stock Ready for Sale,Furniture & Fixtures,Irreplaceable Bulk Beverage, Irrigation Pipeline,Machinery/ Equipment /Molds,Mfg. or Lab Equipment,Perishable Property,Raw Materials & WIP (Not Spoilage/ Temperature Sensitive), Raw Materials & WIP,Replaceable Bulk Beverage,)",
//            "66. In Property sov for ???Building Contents???, Verify user is able to insert column in respective position on selecting the column name under ???Building Contents??? and clicking ???apply??? button",
//            "67. In Property sov for ???Building Contents???, Verify validation error messages for the columns under ???Replacement Cost???",
//            "68. In Property sov for ???Building Contents???, Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted columns under ???Replacement Cost???",
//            "69. In Property sov for \"Building Contents\", Verify user is displayed list of columns required under \"Selling Price\",the following columns are 1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//            "70. In Property sov for ???Building Contents???, Verify user is able to enable or disable the columns under ???Selling Price??? by clicking on the checkbox,the following columns are-1.Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//            "71. In Property sov for ???Building Contents???, Verify user is able to insert column in respective position on selecting the column name under ???Selling Price??? and clicking apply??? button, the following columns are-1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//            "72. In Property sov for \"Building Contents\", Verify validation error messages for the columns under \"Selling Price\", the following columns are 1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6.Temperature Sensitive Property 7. Other",
//            "73. In Property sov for \"Building Contents\", Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted columns under \"Selling Price\",the following columns are 1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//            "74. In Property sov for \"Building Contents\", Verify user is displayed list of columns required under \"Aggregate Building Contents\",the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//            "75. In Property sov for \"Building Contents\", Verify user is able to enable or disable the columns under \"Aggregate Building Contents\" by clicking on the checkbox,the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//            "76. In Property sov for \"Building Contents\", Verify user is able to insert column in respective position on selecting the column name under \"Aggregate Building Contents\" and clicking \"apply\" button, the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//            "77. In Property sov for \"Building Contents\", Verify validation error messages for the columns under \"Aggregate Building Contents\", the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//            "78. In Property sov for \"Building Contents\", Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted columns under \"Aggregate Building Contents\",the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//            "79. In Property sov , Verify user is displayed list of columns required under \"Additional Details\",the following columns are a.Clean Room (Class Code) b.Clean Room (Sq. Ft.) c.Payroll d.# of Students e.# of Employees f.# of Facult Members g.Other Occupants or Tenants h.Additional Information",
//            "80. In Property sov for ???Additional Details, Verify user is able to enable or disable the columns by clicking on the checkbox, the following columns are a.Clean Room (Class Code) b.Clean Room (Sq. Ft.) c.Payroll d.# of Students e.# of Employees f.# of Facult Members g.Other Occupants or Tenants h.Additional Information",
//            "81. In Property sov for ???Additional Details???, Verify user is able to insert column in respective position on selecting the column name and clicking ???apply??? button, the following columns are a.Clean Room (Class Code) b.Clean Room (Sq. Ft.) c.Payroll d.# of Students e.# of Employees f.# of Faculty Members g.Other Occupants or Tenants h.Additional Information",
//            "82. In Property sov for ???Additional Details???, Verify validation error messages for the columns, the following columns are a.Clean Room (Class Code) b.Clean Room (Sq. Ft.) c.Payroll d.# of Students e.# of Employees f.# of Facult Members g.Other Occupants or Tenants h.Additional Information",
//            "83. In Property sov for ???Additional Details???, Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted columns, the following columns are a.Clean Room (Class Code) b.Clean Room (Sq. Ft.) c.Payroll d.# of Students e.# of Employees f.# of Facult Members g.Other Occupants or Tenants h.Additional Information",
//            "84. In Property sov, Verify user is displayed list of columns required under ???Fire Protection???, the following columns are a.Sprinkler System b.Smoke Detectors c.Fire Alarm d.Fire Extinguishers e.Thermal Barriers f.Hydrant g.Fire Department",
//            "85. In Property sov for ???Fire Protection???, Verify by default, the user is not allowed to deselect the checkbox for Sprinkler System, Smoke Detectors & Fire Alarm.",
//            "86. In Property sov for ???Fire Protection???, Verify user is able to enable or disable the columns by clicking on the checkbox, the following columns are 1. Fire Extinguishers 2. Thermal Barriers 3. Hydrant 4. Fire Department",
//            "87. In Property (SOV), Verify user is displayed list of columns required under \"Security\", the following columns are a.Alarm b.Guards c.Gated Campus d.CC TV e.Key Card Access",
//            "88. In Property (SOV) for \"Security\", Verify by default, the user is not allowed to deselect the checkbox of \"Alarm\" & \"Guards\"",
//            "89. In Property (SOV) for \"Security\", Verify user is able to enable or disable the columns by clicking on the checkbox, the following columns are a.Gated Campus b.CC TV c.Key Card Access",
//            "90. In property (SOV), Verify user is able to close the customize column overlay without saving any changes by clicking on \"cancel\" button",
//            "91. In Property (SOV), Verify user is able to reset the column selection to default by clicking on \"Revert\" button",
//            "92. In Property sov for ???Building Contents???, Verify ???Perishable Property???, ???Raw Materials & WIP (Not Spoilage/ Temperature Sensitive)???, ???Finished Stock Ready for Sale??? columns should be selected by default ,if If P&C Practice is ???Life Science???",
//            "93. In Property sov for Fire Protection, If P&C Practice is Life Science - Verify existing default fields is marked selected and disabled, the following fields are-Fire Extinguishers, Thermal Barriers, Hydrant, Fire Department",
//            "94. In Property (SOV) for \"Security\", If P&C Practice is \"Life Science\" - Verify existing default fields is marked selected and disabled, the following fields are \"Gated Campus\", \"CC TV\", \"Key Card Access\"",
//            "95. In Property (SOV), Verify user is able to enable selected columns in the Property(SOV) table by clicking on \"apply\" button and on clicking continue button it should navigate to Property SOV 3rd Party",
////
////            //Property (SOV) 3rd party
//            "96. Verify add a new tab called Property (SOV) ??? 3rd Party next to Property (SOV) tab.",
//            "97. In Property (SOV) ??? 3rd Party, To verify user is able to mark tab as Not Applicable",
//            "98. In Property SOV - 3rd Party, Verify user is able to add row in Property SOV - 3rd Party by clicking on add Row",
//            "99. In Property SOV - 3rd Party, Verify user is able to Delete the added row in Property SOV - 3rd Party Tab by clicking Delete button",
//            "100. In Property (SOV) ??? 3rd Party, Verify user is display a grid with the following standard fields (columns). 1.Premises Number 2.Building Number 3.Location Name 4.Street Address 5.City 6.State or Province 7.Country 8.ZIP / Postal Code 9.Machinery/Equipment/Molds (Replacement Cost) 10.Raw materials & WIP (Replacement Cost) 11.R&D Inventory (Replacement Cost)",
//            "101. In Property (SOV) ??? 3rd Party, Verify user is able to see \"Show/Hide Columns(s)\" button at the top of the table in Property (SOV) ??? 3rd Party",
//            "102. Property SOV - 3rd Party, Verify user clicks on the Show/Hide Column(s) button, the system displays an overlay screen with list of possible columns under the group names are. Building Details, Building Contents, Additional Details(Other Occupants or Tenants, Additional Information), Fire Protection, Security",
//            "103. Property SOV - 3rd Party, Verify user is displayed list of columns required under \"Building Details\", the following columns are a. Building Use (i.e. office, warehouse, etc.) b. Total Area Sq. Ft c. Occupied Floor area Sq.Ft. d. % Occupied e. Owned/Leased f. Construction Type g. Year Built h. # of Stories",
//            "105. Property SOV - 3rd Party for \"Building Details\", Verify by default columns is pre-selected and disabled so that the column automatically appears on the table, the following columns are a. Building Use (i.e. office, warehouse, etc.) b. Total Area Sq. Ft c. % Occupied d. Owned/Leased e. Construction Type f. Year Built g. # of Stories",
//            "106. Property SOV - 3rd Party for \"Building Details\",Verify user is able to enable or disable the \"Occupied Floor area Sq.Ft.\" column by clicking on the checkbox",
//            "107. Property SOV - 3rd Party for \"Building Details\",Verify user is able to insert \"Occupied Floor area Sq.Ft\" column in respective position on selecting the column name and clicking \"apply\" button",
//            "108. Property SOV - 3rd Party for \"Building Details\", Verify validation error messages of \"Occupied Floor area Sq.Ft.\" column",
//            "109. Property SOV - 3rd Party for \"Building Details\", Verify user is able to enter correct value in \"Occupied Floor area Sq.Ft\" column",
//            "110. Property SOV - 3rd Party, Verify user is able to see under \"Building Contents\", the columns are further sub-categorized as Detailed Building Contents & Aggregate Building Contents",
//            "111. Property SOV - 3rd Party for \"Building Contents\", Verify user able to see the columns are grouped further as \"Contents Replacement Cost\" & \"Selling Price\" under Detailed Building Contents",
//            "112. Property SOV - 3rd Party for \"Building Contents\",Verify User is displayed list of columns required under \"Replacement Cost\", columns are Cased Goods, Computer Hardware, Servers, Finished Stock Ready for Sale, Furniture & Fixtures, Irreplaceable Bulk Beverage, Irrigation Pipeline, Machinery/ Equipment /Molds,Mfg. or Lab Equipment, Perishable Property,Raw Materials & WIP (Not Spoilage/Temperature Sensitive), Raw Materials & WIP,Replaceable Bulk Beverage,R&D Inventory,Spoilage",
//            "113. In Property SOV 3rd Party tab- verify user is able to view the newly added Columns in the Show / hide Overlay. 1. Samples/Demos/Free Units under Building Contents 2. Building Use Detail - next to Building Use column",
//            "114. In Property SOV - 3rd Party for \"Building Contents\", Verify user is able to enable or disable the columns under \"Replacement Cost\" by clicking on the checkbox,the following columns are (Cased Goods Values,Computer Hardware, Servers,Finished Stock Ready for Sale,Furniture & Fixtures,Irreplaceable Bulk Beverage,Irrigation Pipeline,Machinery/Equipment /Molds,Mfg. or Lab Equipment,Perishable Property,Raw Materials & WIP (Not Spoilage/ Temperature Sensitive), Raw Materials & WIP,Replaceable Bulk",
//            "115. In Property SOV - 3rd Party for \"Building Contents\", Verify user is able to insert column in respective position on selecting the column name under \"Building Contents\" and clicking \"apply\" button",
//            "116. In Property SOV - 3rd Party for \"Building Contents\", Verify validation error messages for the columns under \"Replacement Cost\"",
//            "117. In Property SOV - 3rd Party for \"Building Contents\", Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted columns under \"Replacement Cost\"",
//            "118. In Property SOV - 3rd Party for \"Building Contents\", Verify user is displayed list of columns required under \"Selling Price\",the following columns are 1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//            "119. In Property SOV - 3rd Party for \"Building Contents\", Verify user is able to enable or disable the columns under \"Selling Price\" by clicking on the checkbox,the following columns are 1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//            "120. In Property SOV - 3rd Party for \"Building Contents\", Verify user is able to insert column in respective position on selecting the column name under \"Selling Price\" and clicking \"apply\" button, the following columns are 1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//            "121. In Property SOV - 3rd Party for ???Building Contents???, Verify validation error messages for the columns under ???Selling Price???, the following columns are 1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//            "122. In Property SOV - 3rd Party for ???Building Contents???, Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted columns under ???Selling Price???,the following columns are 1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//            "123. In Property SOV - 3rd Party for \"Building Contents\", Verify user is displayed list of columns required under \"Aggregate Building Contents\",the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//            "124. In Property SOV - 3rd Party for \"Building Contents\", Verify user is able to enable or disable the columns under \"Aggregate Building Contents\" by clicking on the checkbox,the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//            "125. In Property SOV - 3rd Party for \"Building Contents\",Verify user is able to insert column in respective position on selecting the column name under \"Aggregate Building Contents\" and clicking \"apply\" button, the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//            "126. In Property SOV - 3rd Party for ???Building Contents???,Verify validation error messages for the columns under ???Aggregate Building Contents???, the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//            "127. In Property SOV - 3rd Party for ???Building Contents???,Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted columns under ???Aggregate Building Contents???,the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//            "129. In Property SOV - 3rd Party, Verify user is able to enable or disable the columns by clicking on the checkbox, the following columns are a.Other Occupants or Tenants b.Additional Information",
//            "130. In Property SOV - 3rd Party,Verify user is able to insert column in respective position on selecting the column name and clicking ???apply??? button, the following columns Other Occupants or Tenants & Additional Information",
//            "131. In Property SOV - 3rd Party,Verify user is able to enter correct value in Inserted test format columns, the following columns are Other Occupants or Tenants & Additional Information",
//            "132. In Property SOV - 3rd Party,Verify user is displayed list of columns required under ???Fire Protection???, the following columns are a.Sprinkler System b.Smoke Detectors c.Fire Alarm d.Fire Extinguishers e.Thermal Barriers f.Hydrant g.Fire Department",
//            "133. In Property SOV - 3rd Party for ???Fire Protection???, Verify by default, the user is not allowed to deselect the checkbox for Sprinkler System, Smoke Detectors & Fire Alarm.",
//            "134. In Property SOV - 3rd Party for ???Fire Protection???, Verify user is able to enable or disable the columns by clicking on the checkbox, the following columns are 1. Fire Extinguishers 2. Thermal Barriers 3. Hydrant 4. Fire Department",
//            "135. In Property SOV - 3rd Party, Verify user is displayed list of columns required under \"Security\", the following columns are a.Alarm b.Guards c.Gated Campus d.CC TV e.Key Card Access",
//            "136. In Property SOV - 3rd Party for \"Security\", Verify by default, the user is not allowed to deselect the checkbox of \"Alarm\" & \"Guards\"",
//            "137. In Property SOV - 3rd Party for \"Security\",Verify user is able to enable or disable the columns by clicking on the checkbox, the following columns are a.Gated Campus b.CC TV c.Key Card Access",
//            "138. In Property SOV - 3rd Party, Verify user is able to close the customize column overlay without saving any changes by clicking on \"cancel\" button",
//            "139. In Property SOV - 3rd Party, Verify user is able to reset the column selection to default by clicking on \"Revert\" button",
//            "140. In Property SOV - 3rd Party,Verify user is able to enable selected columns in the Property(SOV) table by clicking on ???apply??? button",
//            "141. In Property SOV 3rd Party - For the Dropdown Building Use, Verify the following new values are displayed in the drop down list:1. Clean Rooms 2. Laboratories 3. Supply Chain / Contract Manufacturer 4. Vivarium",
//            "142. In Property SOV - 3rd Party,To verify user is able to enter the details For Coverage Notes and navigate to BI worksheet tab",
//
//            //BI-Worksheet
//            "143. In BI Worksheet tab - Verify 2 Check boxes are displayed below the Not Applicable checkbox : a. Standard BI Worksheet b. Continuing Expenses only Worksheet",
//            "144. In BI Worksheet - Verify user is displayed Standard BI Worksheet as pre-selected value if P&C Practice is selected as Commercial in the drop down in the Cover page",
//            "145. In BI Worksheet - Verify user is displayed Continuing Expenses only worksheet as pre-selected value if P&C Practice is selected as Life Science in the drop down in the Cover page",
//            "146. In BI Worksheet - Verify user is displayed Standard BI Worksheet as pre-selected value if P&C Practice is selected as Technology in the drop down in the Cover page",
//            "148. Verify user is displayed the field with Label - \"Annual Net Profit/(Net Loss) Before Tax (from operations other than R&D operations) Enter -ve value in case of net loss\" under Continuing Expenses only Worksheet",
//            "149. Verify user is displayed error validation message on entering invalid value for the currency field - \"Annual Net Profit/(Net Loss) Before Tax\" to \"Annual Net Profit/(Net Loss) Before Tax (from operations other than R&D operations) Enter -ve value in case of net loss\" - Error message 1. Max allowed value $9,999,999,999,999.99 2. Only currency Values allowed (0-9, $, ., ,)",
//            "150. Verify user is able to enter -ve currency value in case of net loss for field - \"Annual Net Profit/(Net Loss) Before Tax\" to \"Annual Net Profit/(Net Loss) Before Tax (from operations other than R&D operations) Enter -ve value in case of net loss\" - under Continuing Expenses only Worksheet",
//            "151. Verify user is displayed a new field - Net Profit from R&D Operations Before Tax If Net Profit, please note total grants, endowments, & other financial contributions that would be eliminated following a covered loss to tangible property here: R&D Income Sources & Expected Amounts If Net Loss, state \"None\" ??? (Insurer policy form automatically removes Net Loss from calculation for R&D Operations.)",
//            "152. Verify user is displayed error validation message on entering invalid value for the currency field - Net Profit from R&D Operations Before Tax Error message 1. Max allowed value $9,999,999,999,999.99 2. Only currency Values allowed (0-9, $, ., ,)",
//            "153. Verify user is able to enter a currency value with decimal in the field - Net Profit from R&D Operations Before Tax and also validate the value displayed is comma separated, in View mode value is displayed as rounded off value and in edit mode value is displayed with decimal.",
//            "154. Verify when the value entered in the Annual Net Profit/(Net Loss) Before Tax is lesser than 0, the Annual Business Income Total calculation formula is implemented properly",
//            "155. Verify when the value entered in the Annual Net Profit/(Net Loss) Before Tax is greater than 0, the Annual Business Income Total calculation formula is implemented properly",
//            "156. Verify user is displayed Add Location(s) from SOV button",
//            "156.1. BI Worksheet - CE - Handle empty records for \"Add Location(s) from SOV \" button",
//            "157. Verify user is displayed a popup on clicking Add Location(s) from SOV button",
//            "158. Verify user can close the popup by clicking on close(x) icon or on Cancel button",
//            "159. Verify the address displayed in the Add location(s) from SOV popup are displayed in the following order with comma separation. Location Name, Building Number, Street Address, City, State ZIP / Postal Code, Country",
//            "160. Verify user is able to Select All or deselect All address location by clicking on the checkbox in the header of the popup",
//            "161. Verify inline error message is displayed, when user clicks on Add Selected button without selecting any location - Select at least one property to add",
//            "162. Verify user is not able to select same location multiple times",
//            "163. Verify user is able to select more than one location from the popup",
//            "164. Verify for the selected Address, new columns with selected location information displaying below the location header with the option to edit the linked Property (SOV) location",
//            "165. Verify user is displayed the Add Locations popup by clicking on the edit icon",
//            "166. Verify the select all checkbox in the header is not displayed when Edit icon is clicked",
//            "167. Verify all the other locations in the popup are disabled except for the location for which the edit icon is clicked.",
//            "168. Enter the details for all the field for Continuing Expenses only Worksheet",
//            "169. Verify user us displayed two option on clicking on Standard BI Worksheet option: 1. Single BI Worksheet (Default Selected) 2. Multi-Location BI worksheet",
//            "170. Verify user is displayed two option for Single BI Worksheet:1. Actual (Default Selected) 2. Projected",
//            "171. Actual Radio option - Verify the field validations and error messages for the following fields of Annual Net Sales:Add the same validations for Cost of Sales / Cost of Revenues / COGS and Operating Expenses fields",
//            "172. Validate the formula for calculating the Business Interruption BI Values, Formula = Annual Net Sales of Business Interruption BI Values = Annual Net Sales of Information from Income Statement * (% Variable/Non-Continuing of Information from Income Statement)/100",
//            "173. For Cost of Sales - Validate the formula for calculating the Business Interruption BI Values,Formula = Business Interruption BI Values of Cost of Revenues = Annual Net Sales of Cost of Revenues * (% Variable/Non-Continuing of Cost of Revenues)/100",
//            "174. Gross Profit / Gross Earnings (Information from Income Statement)- Validate the value is calculated as per the formula: Gross Profit / Gross Earnings of Information from Income Statement = Annual Net Sales of Information from Income Statement - Cost of Sales of Information from Income Statement",
//            "175. Gross Profit / Gross Earnings (Business Interruption BI Values)- Validate the value is calculated as per the formula: Gross Profit / Gross Earnings = Annual Net Sales of Business Interruption BI Values - Cost of Sales of Business Interruption BI Values",
//            "176. For Operating Expenses - Validate the formula for calculating the Business Interruption BI Values,Formula = Business Interruption BI Values = Annual Net Sales of Operating Expenses * (% Variable/Non-Continuing of Operating Expenses)/100",
//            "177. For Operating Income - Validate the formula for calculating the Business Interruption BI Values,Formula = Operating Income of Information from Income Statement = Gross Profit / Gross Earnings of Information from Income Statement - Operating Expense of Information from Income Statement",
//            "178. Annual BI Value w/o Ordinary Payroll - Verify the value calculated is as per the Formula and the value is currency formatted and rounded off to 2 decimal places Formula : Business Interruption BI Values = Gross Profit / Gross Earnings of Business Interruption BI Values + Operating Expense of Business Interruption BI Values",
//            "179. Ordinary Payroll (annual payroll and benefits for non-exempt workers) - Enter invalid value for currency field and validate the error message - Enter only currency value (0-9, $, ., ,)",
//            "180. # of Days Coverage of Ordinary Payroll Desired (0-365 days) - Verify the error message on entering invalid value",
//            "181. Total Ordinary Payroll (OP) - Verify the value calculated is as per the Formula and the value is currency formatted and rounded off to 2 decimal places Formula : Total Ordinary Payroll (OP) of Business Interruption BI Values = Ordinary Payroll of Business Interruption BI Values * # of Days Coverage of Ordinary Payroll Desired of Business Interruption BI Values / 365",
//            "182. Annual BI Value including Ordinary Payroll - Verify the value calculated is as per the Formula and the value is currency formatted and rounded off to 2 decimal places Formula Annual BI Value including Ordinary Payroll of Business Interruption BI Values = Annual BI Value w/o Ordinary Payroll of Business Interruption BI Values + Total Ordinary Payroll (OP) of Business Interruption BI Values",
//            "183. Number of Months to Move to another Location and Resume Operation - Verify the whole number",
//            "184. Exposed BI w/o OP of Business Interruption BI Values - Verify the value calculated is as per the Formula and the value is currency formatted and rounded off to 2 decimal places Formula: Exposed BI w/o OP of Business Interruption BI Values = Annual BI Value w/o Ordinary Payroll of Business Interruption BI Values *Number of Months to Move to another Location and Resume Operation of Business Interruption BI Values / 12",
//            "185. Exposed BI Including OP of Business Interruption BI Values - Verify the value calculated is as per the Formula and the value is currency formatted and rounded off to 2 decimal places Formula : Exposed BI Including OP of Business Interruption BI Values = Exposed BI w/o OP of Business Interruption BI Values + Total Ordinary Payroll (OP)",
//            "186. Enter valid values for all the fields for Actual option",
//            "187. Check the checkbox for Projected and enter valid values for all fields for projected form.",
//            "188. Check the radio option for Multi Location BI Worksheet and verify user is displayed Multi Location BI Worksheet",
//            "190. (Multi Location BI) Exposed BI Incl. OP - Verify the value calculated is as per the Formula and the value is currnecy formatted and rounded off to 2 decimal places Formula : Exposed BI Incl. OP = ((Exposed BI w/o OP sum(+) [(Ordinary Payroll - annual payroll and benefits for non-exempt workers ) TIMES(*) (Number of Days Coverage of Ordinary Payroll Desired (0-365 days) DIVIDED(/) 365))]",
//            "191. Verify the field validation for all the fields in the Multi Location BI Worksheet",
//            "192. Verify user is able to enter the details in the Multi Location BI Worksheet and on clicking Continue it should navigate to BI Dependent"
//
//            //Contingent BI / Dependent
//            "193. BI Dependent: Verify \"Exposed CBI Value??? column name if \"Estimated time until listed Process or Supplier is fully restored (months)\" filed value is less than and grater then 12",
//            "193.1 BI Dependent - Verify user is able to enter alphanumeric values with special characters in the fields with format as Text",
//            "194. Verify United States is displayed as default country in the Country field",
//            "195. Verify the error message displayed when user tries to enter a new country in the Country field - Please select a valid country name",
//            "196. When country is United States - Verify user is displayed the error message if user enters invalid state - Please select valid State Name / Code",
//            "197. When country is United States - Verify user is able to add the states from the type ahead drop down values",
//            "198. When country is NON US - Verify user is able to enter alphanumeric with special characters for State field",
//            "199. Verify ZIP / Postal Code field can accept only 10 characters",
//            "200. When Country is United States - Verify user is displayed error message when ZIP / Postal code is entered more than 5 and less than 9 digits - Enter a valid ZIP / Postal Code",
//            "201. When Country is United States Verify user is able to enter ZIP of 5 digits only",
//            "202. When Country is United States Verify user is able to enter ZIP / Postal Code of Zip + 4 code with a dash(???-???) in between.of 5 digits only",
//            "203. When Country is United States Verify the ZIP / Postal Code gets formatted automatically if user enters ZIP and Postal code together",
//            "204. When country is non US - Verify user is able to enter ZIP / Postal Code with alphabets, numbers, and special characters of length 10 characters",
//            "205. Annual Revenue Exposure field - Verify user is displayed error validation message on entering invalid value for the currency field - Enter only currency value (0-9, $, ., ,)",
//            "206. Verify user is able to enter a currency value with decimal in the field - Annual Revenue Exposure field and also validate the value displayed is comma separated, in View mode value is displayed as rounded off value and in edit mode value is displayed with decimal.",
//            "207. % of Product Revenue - Verify the error message displayed when user enters invalid value for % of Product Revenue field",
//            "208. % of Product Revenue - verify user is able to enter decimal value",
//            "209. Verify the error message is displayed when user enters invalid values for Estimated time until listed Process or Supplier is fully restored (months) - Enter only whole number",
//            "210. Annual Revenue Loss - Annual Revenue Loss - Verify the value calculated is as per the Formula and the value is currency formatted and rounded off to 2 decimal places Formula : (Annual Revenue Exposure*% of Product Revenue impacted)*(Estimated time until listed Process or Supplier is fully restored (months)/12)",
//            "212. # of Months of Available Inventory - Verify the error message is displayed when user enters invalid - Enter only whole number",
//            "213. CBI exposure with available inventory - Verify IF ???Estimated time until listed Process or Supplier is fully restored (months)??? is Less than ???No of months of Available Inventory??? then the value is 0",
//            "214. CBI exposure with available inventory - Verify IF ???Estimated time until listed Process or Supplier is fully restored (months)??? is less than ???No of months of Available Inventory??? then the value is calculated as per the formula: (Estimated time until listed Process or Supplier is fully restored (months)<# of Months of Available Inventory,0,(Annual Revenue Loss*(1 - (# of Months of Available Inventory/12)))),0)",
//            "215. Verify user is displayed the Options to select the value from drop down for Construction Type in alphabetical order",
//            "216. Validate the error message displayed for invalid values entered in Year field - Please enter a valid year",
//            "217. Verify the Column options displayed under Fire Protection: Smoke Detectors, Fire Extinguishers, Fire Alarm, Sprinkler System, Thermal Barriers, Hydrant, Fire Department",
//            "218. Verify the Column options displayed under Security Information: Alarm, CC TV, Gated Campus, Guards, Key Card Access",
//            "219. Enter valid details in BI Dependent tab and on clicking Continue it should navigate to Crime tab",
//
//            //Crime
//            "220. PS062 - To verify user is able to mark Crime Page as as Not Applicable",
//            "221. PS063 - To verify user is able to enter the details in Program structure in Crime Tab",
//            "222. PS066 - To verify user is able to enter the details in Coverage requirements in Crime Tab and Navigate to ERISA / 401(K) Plan tab",
//
//            // ERISA / 401(K) Plan
//            "223. Verify user is displayed a new Tab ERISA / 401(k) plan",
//            "223.1 Verify user is able to mark the ERISA / 401(k) plan tab as not applicable",
//            "223.2. Verify the error messages for the invalid values",
//            "223.3. Verify user is able to enter the data in ERISA tab",
//            "223.4. Verify user is able to export the RFR and validate data for ERISA / 401(k) Plan Sheet",
//            "223.5. Validate the error message for invalid values in the exported RFR for ERISA / 401(k) plan sheet",
//            "223.6. Verify the error message on the import page for ERISA tab",
//            "223.7. Verify the data after importing in ERISA / 401(k) plan tab and navigate to Transit / Cargo / Stock Throughput tab",
//
//            //Transit - Shipment Exposure
//            "224. Shipment Exposure - Verify user is displayed Shipment Exposure Title below Not Applicable checkbox",
//            "225. Verify user is displayed a drop down - Valuation Information with the following options: 1. Standard 2. All Replacement Cost 3. Other With Standard as default value",
//            "226. When Valuation Information option is standard, Verify user is displayed the message next to the drop down",
//            "227. Verify user is able to select option Other for Valuation Information and a Text area field is displayed next to the Drop down",
//            "228. Verify user is displayed a table -Annual Sales Turnover. Also validate: (A) Column headers: 1. 12 Months Sales Turnover Details by Policy Period 2. Annual Sales Turnover (B)Labels in 12 Months Sales column: 1. Current Ending Policy Period (MM/DD/YYYY - MM/DD/YYYY) 2. Next Policy Period (MM/DD/YYYY - MM/DD/YYYY) (c)Current Ending Policy Period (MM/DD/YYYY - MM/DD/YYYY) displays RFR Current Term (D) Next Policy Period (MM/DD/YYYY - MM/DD/YYYY) displays RFR Proposed Term",
//            "229. Verify the error message is displayed when invalid value is entered for currency field column Annual Sales Turnover",
//            "230. Verify user is displayed the table Basic Transit Questionnaire (Applies to All Industries Except Life Sciences) with two columns: 1)Questions 2)Response",
//            "231. Verify the drop down options for the question - How is Product Packaged? And also verify user is displayed a text area when Other option is selected form the drop down and the default value for the drop down is displayed as N/A",
//            "232. Verify user is displayed N/A as default value for question - FDA Approved? And also verify the options for the drop down - Yes | N/A",
//            "233. Verify user is dispalyed the following: 1. No as default value for question - Is your Product temperature sensitive? 2. Options for the drop down - Yes|No are displayed on clicking the drop down 3. If Yes is selected then Provide Storage Temperature Range (If Product Temperature Sensitivity is 'Yes', provide storage temperature range) text area is enable",
//            "234. Verify user is displayed a table Shipment / Transit Exposures with following 5 columns: 1. Shipment Exposures 2. Incoming 3. Outgoing 4. Intercompany 5. Total",
//            "235. Verify the table rows should be grouped as: 1. Shipment Exposures 2. Shipment Insurance Responsibility 3. Principal Countries Shipped(Indicate % involved) 4. Conveyance Used (% used of total annual value shipped)",
//            "236. Verify user is displayed - replacement cost as default for incoming and intra-company column and Selling Price as default for Outgoing column for row heading basic valuation and also validate the drop down option for each other 3 column drop down for the same row.",
//            "237. Verify the following for Shipment terms row:1. Row Shipment terms is displayed only for Incoming and Outgoing columns 2. validate the option of the drop down for both the columns 3. N/A is displayed as default value 4. Total field should be disabled",
//            "238. Total Annual Value Shipped - Verify the total column is the sum of the currency fields entered for Incoming, Outgoing and Intercompany",
//            "239. Verify user is able to enter currency values for the rows: Average Value per Conveyance Maximum Value per Conveyance under columns Incoming, Outgoing and Inter-company and also verify the total field under total column is disabled for these 2 rows.",
//            "240. Shipment Insurance Responsibility - Verify user is able to enter Percentage values for the rows At Insured Risk, At Vendor/Customer Risk, At Other's risk for the columns Incoming, Outgoing and Intercompany",
//            "241. Shipment Insurance Responsibility - Total % - Verify the error message when the total of Incoming column for the 3 rows - At Insured Risk, At Vendor/Customer Risk, At Other's risk - is more than 100 % Total Incoming Shipments should not be greater than 100%",
//            "242. Shipment Insurance Responsibility - Total % - Verify the error message when the total of Incoming column for the 3 rows - At Insured Risk, At Vendor/Customer Risk, At Other's risk - is less than 100 % Total Incoming Shipments should not be greater than 100%",
//            "243. Shipment Insurance Responsibility - Total % - Verify the error message when the total of Outgoing column for the 3 rows - At Insured Risk, At Vendor/Customer Risk, At Other's risk - is more than 100 % Total Outgoing Shipments should not be greater than 100%",
//            "244. Shipment Insurance Responsibility - Total % - Verify the error message when the total of Outgoing column for the 3 rows - At Insured Risk, At Vendor/Customer Risk, At Other's risk - is less than 100 % Total Outgoing Shipments should not be less than 100%",
//            "245. Shipment Insurance Responsibility - Total % - Verify the error message when the total of Intercompany column for the 3 rows - At Insured Risk, At Vendor/Customer Risk, At Other's risk - is more than 100 % - Total Intercompany Shipments should not be less than 100%",
//            "246. Shipment Insurance Responsibility - Total % - Verify the error message when the total of Intercompany column for the 3 rows - At Insured Risk, At Vendor/Customer Risk, At Other's risk - is less than 100 % - Total Intercompany Shipments should not be less than 100%",
//            "247. Principal Countries Shipped (Indicate % involved) - Verify user is displayed label - What is the level of information required for International Shipments, with the option By Continents, By Countries, Rest of World and also verify Continents option is selected as default.",
//            "248. Verify user is displayed a new row Foreign below the Domestic U.S. row checking the Rest of World radio option.",
//            "249. Verify user is displayed the error message when invalid values are entered in Column (Incoming, Outgoing and Intercompany) for row Foreign - Error message: a. Only percentage value is allowed (0-9, decimal) b. The value should be between 0% to 100%",
//            "250. Verify on Selecting Continent radio option - 1. Delete Continent from list 2. A new row with a list of continents drop down is displayed 3. User is able to select the Continent from the drop down 4. After selecting the Continent, the drop down shifts to next row. 5. In the next row, In drop down User is not displayed the already selected Continent",
//            "251. Verify user is able to delete the Continent rows by clicking on the delete icon next to the Continent name",
//            "252. Verify user is displayed the error message when invalid values are entered in Column (Incoming, Outgoing and Intercompany) for row Continent - Error message: a. Only percentage value is allowed (0-9, decimal) b. The value should be between 0% to 100%",
//            "253. Verify on Selecting Country radio option - 1. A new row with a list of Countries drop down is displayed 2. User is able to select the Country from the drop down 3. After selecting the Country, the drop down shifts to next row. 4. In the next row, In drop down User is not displayed the already selected Country",
//            "254. Verify user is able to delete the Country row by clicking on the delete icon next to the country name",
//            "255. Verify user is displayed the error message when invalid values are entered in Column (Incoming, Outgoing and Intercompany) for row Country - Error message: a. Only percentage value is allowed (0-9, decimal) b. The value should be between 0% to 100%",
//            "256. Rest of World or Continent or Country - Total % - Verify the error message when the total of Incoming column for the Rest of World or Continent or Country - is more than or less than 100 %. Error message - Total Incoming Shipments should not be greater than 100% Error message - Total Incoming Shipments should not be less than 100%",
//            "257. Rest of World, Continent, Country - Total % - Verify the error message when the total of Outgoing column for the Rest of World or Continent or Country - is more than or less than 100 %. Error message -Total Outgoing Shipments should not be greater than 100% Error message -Total Outgoing Shipments should not be less than 100%",
//            "258. Rest of World, Continent, Country - Total % - Verify the error message when the total of Intercompany column for the Rest of World or Continent or Country - is more than or less than 100 %. Error message -Total Intercompany Shipments should not be greater than 100% Error message -Total Intercompany Shipments should not be less than 100%",
//            "259. Verify user is displayed error message on entering invalid values for percentage field for each field under Conveyance Used (% used of total annual value shipped) header rows and under Incoming, Outgoing and Inter company Columns. Error message: a. Only percentage value is allowed (0-9, decimal) b. The value should be between 0% to 10",
//            "260. Verify the message displayed below the table with the title - RULES FOR ANY MODE OR MODES OF TRANSPORT and also below the title RULES FOR SEA AND INLAND WATERWAY TRANSPORT'",
//            "261. Verify user is able to enter the details in transit tab - Shipments sub tab and on clicking continue it should redirected to Product Transit tab",
//
//            //Transit- Product
//            "262. Verify user is displayed the title Product Transit Below the Not applicable Check box.",
//            "263. Verify user is displayed the Valuation information field with following options in the drop down label \"Valuation Information\" and also validate Standard is displayed as default value: 1. Standard 2. Life Science - Default 3. Life Science - Commercial 4. Other",
//            "264. Verify User is displayed the following messages on the side of the Valuation drop down on selecting Standard option from Valuation drop down",
//            "265. Verify User is displayed the messages on the side of the Valuation drop down on selecting Life Science - Default option from Valuation drop down",
//            "266. Verify User is displayed the messages on the side of the Valuation drop down on selecting Life Science - Commercial option from Valuation drop down",
//            "267. Verify user is displayed a text area when Other option is selected from the Valuation Information drop d0wn",
//            "268. Verify user is displayed the error message for fields Product Name and Sub-Components(Parts or Processes) when these fields are left empty and a value is entered in some other field.Error message : For Product Name : Product Name is Required For Sub-Components(Parts or Processes) : Sub-Components (Parts or Processes) is Required",
//            "270. Verify the error message is displayed for field Package Protection Duration(hrs) when invalid value is entered. Error Message - Enter only whole number",
//            "271. Verify the Drop down values for the following fields: 1. FDA Approved for Sale? 2. Product Temperature Sensitivity 3. Product Packaged 4. Conveyance",
//            "272. Verify user is able to add a new row by clicking on add button.",
//            "273. Verify user is able to delete one of the added row",
//            "274. Verify If ???Life Science??? is selected for ???P&C Practice??? from Cover Page then ???Life Science - Default??? should be pre-selected in the ???Valuation Information??? drop down",
//            "275. Verify user is able to enter details for all the fields in Product Transit tab.",
//            "276. Verify user is directed to List page on clicking save and close and directed back to Product Transit tab on clicking the RFR in the List page",
//            "277. Verify user is directed to Product Flow tab on clicking Continue button",
//
//            //Transit - Product Flow
//            "278. Verify user is displayed the title Product Flow Below the Not applicable Check box.",
//            "279. Verify user is displayed the error message for fields Product Name and Sub-Components(Parts or Processes) when these fields are left empty and a value is entered in some other field. Error message : For Product Name : Product Name is Required For Sub-Components(Parts or Processes) : Sub-Components (Parts or Processes) is Required",
//            "280. Verify the error message for invalid value for Country field under Shipment From and Shipment To Columns. Error message : Please select a valid country name",
//            "281. Verify the error message for invalid value for State or Province field when Country is United States under Shipment From and Shipment To Columns. Error message : Please select valid State Name/Code",
//            "282. Verify the error message when invalid value for currency Field Average Value Shipped per Shipment is entered. Error message: 1. Max allowed value $9,999,999,999,999.99 2. Only currency values allowed(0-9, $, ., ,)",
//            "283. Verify the error message when invalid value for Field Frequency of Average Shipment Per Year is entered. Error message: a. Enter only whole number",
//            "284. Verify the error message when invalid value for currency Field Maximum Value Shipped per shipment is entered. Error message: 1. Max allowed value $9,999,999,999,999.99 2. Only currency values allowed(0-9, $, ., ,)",
//            "285. Verify the error message when invalid value for Field Frequency of Max Shipment Per Year is entered. Error message:a. Enter only whole number",
//            "286. Verify the value displayed for field Annual value Shipped is calculated as per the formula : (Average Value Shipped per Shipment x Frequency of Average Shipment Per Year) + ( Maximum Value Shipped per shipment x Frequency of Max Shipment Per Year)",
//            "287. Verify user is displayed the Total at the end of column Annual value Shipped. The value should be Sum of Annual value shipped ( all rows)",
//            "289. Verify The error message is displayed for field Package Protection Duration(hrs) when invalid value is entered. Error Message - Enter only whole number",
//            "290. Verify user is able to enter the details in Product Flow tab",
//            "290.1. Product Flow - Handle empty records for \"Add Products\" button",
//            "291. Verify the error message when user clicks on Add Selected button without selecting any Product in Add Products popup. Error message : Select at least one product to add",
//            "292. Verify the error message when user selects the product but does not enter value for No of segments in the popup Error message : Enter \"No of Segments\" for selected products",
//            "293. Verify the error message when user selects the product but does not enter value for No of segments in the popup Error message : Enter \"No of Segments\" for selected products",
//            "294. Verify user is able to add the rows for the products from Add Products popup",
//            "295. Verify user is able to enter the details in the newly added rows",
//            "296. Verify user is able to add a row buy clicking on Add row button",
//            "297. Verify user is able to delete the newly added row",
//            "298. Verify user is able to enter the details in Coverage Notes",
//            "299. Verify User is directed back to Renewal List page on clicking save and close button",
//            "300. Verify user is navigated to Transit Loc. Inv tab by clicking on Continue button",
//
////          //  Transit- Location Inventory
//            "301. Verify user is displayed the title Transit Location Inventory Below the Not applicable Check box.",
//            "302. Verify user is displayed the mentioned columns as default which will not be configurable from Customize columns",
//            "303. Verify User is displayed Show/Hide Column(s) label, Clicking on which should display an overlay screen with the list of possible column names",
//            "304. In Show / Hide Columns - Building Details - Verify following Columns are Checked as default and user is not able to uncheck them.",
//            "305. In Show / Hide Columns - Building Details - Verify user is able to check and uncheck the column name Occupied Floor area Sq.Ft.",
//            "306. In Show / Hide Columns overlay - Verify under Building Contents - 3 sub sections are displayed: 1. REPLACEMENT COST 2. SELLING PRICE 3. Aggregate Building Contents",
//            "307. In Show / Hide Columns overlay - Building Contents - Verify the Columns labels under Replacement Sub section",
//            "308. In Show / Hide Columns overlay - Building Contents - Verify the Columns labels under Selling Price Sub section",
//            "309. In Show / Hide Columns overlay - Building Contents -Verify the Columns labels under Aggregate Building Contents Sub section",
//            "310. Verify user is able to check / uncheck the following columns under Additional Details:1. Other Occupants or Tenants 2. Additional Information",
//            "311. In Show / Hide Columns overlay - Verify the Labels under Fire Protection",
//            "312. In Show / Hide Columns overlay - Fire Protection - Verify the following columns are preselected and cannot be unchecked : 1. Sprinkler System 2. Smoke Detectors 3. Fire Alarm",
//            "313. In Show / Hide Columns overlay - Fire Protection - Verify user is able to check and uncheck the following columns: 1. Fire Extinguishers 2. Thermal Barriers 3. Hydrant 4. Fire Department",
//            "314. In Show / Hide Columns overlay -Security - Verify the following columns are pre selected and cannot be unchecked : 1. Alarm 2. Guards",
//            "315. In Show / Hide Columns overlay - Security - Verify user is able to check and uncheck the following columns: 1. Gated Campus 2. CC TV 3. Key Card Access",
//            "316. In Show / Hide Columns overlay - Very user is displayed 3 buttons : 1. Cancel 2. Revert 3. Apply",
//            "317. In Show / Hide Columns overlay - Verify user is able to cancel the selections and exit the show / hide overlay by clicking on the Cancel button",
//            "318. In Show / Hide Columns overlay - Verify user is able to revert back to default selections in the overlay on clicking the revert button",
//            "319. In Show / Hide Columns overlay - Verify user is able to add the columns from the overlay in the table by checking the check boxes for the columns and clicking on Apply button",
//            "320. Verify the columns under the Replacement heading in the Show / Hide overlay are displayed with column name with Replacement Cost heading in parenthesis in the table",
//            "321. Verify the columns under the Selling Price heading in the Show / Hide overlay are displayed with column name with Selling Price heading in parenthesis in the table",
//            "322. Verify user is able to select the state / Province value from the drop down by typing first 2 letters of state from the drop down if the country is US.",
//            "323. When country is United States - Verify user is displayed the error message if user enters invalid state - Please select valid State Name / Code",
//            "324. Verify the error message displayed when user tries to enter a new country in the Country field - Please select a valid country name",
//            "325. Verify ZIP / Postal Code field can accept maximum of 10 character",
//            "326. Verify the error message displayed when incorrect value is entered for Currency fields- Enter only currency value (0-9, $, ., ,)",
//            "327. Verify the error message on entering invalid value for field Total Area Sq. Ft. : 1. Max 25 characters 2. Only numeric and decimal values are allowed",
//            "328. Verify the error message on entering invalid value for field Occupied Floor area Sq.Ft. : a. Enter only whole number",
//            "329. Verify the error message on entering invalid value for field % Occupied : a. Only percentage value is allowed (0-9, decimal) b. The value should be between 0% to 100%",
//            "330. Verify the error message displayed for Year Built field on entering alphabets : Enter only number",
//            "331. Verify the error message for Year field on entering a year value of less than 4 digits: a. Please enter a valid year",
//            "332. Verify the error message for # of Stories field on entering invalid value other than numeric value : 1. Max 4 characters 2. Only numeric values allowed (0-9999)",
//            "333. Verify user is able to add a new row by clicking on add button.",
//            "334. Verify user is able to delete a row.",
//            "335. Transit Location Inventory - For the Drop down Building Use, Verify the following new values are displayed in the drop down list.: 1. Clean Rooms 2. Laboratories 3. Supply Chain / Contract Manufacturer 4. Vivarium",
//            "336. In Transit Location inventory tab- verify user is able to view the newly added Columns in the Show / hide Overlay. 1. Samples/Demos/Free Units under Building Contents 2. Building Use Detail - next to Building Use column",
//            "336.1. Verify user is able to enter the details in Transit Loc Inv and navigate to Casualty tab",
//
//            //Equipment
//            "337. Verify user is able to see new Exposure - under Property Tab - Equipment Exposure",
//            "337.1. Verify user is able to mark Equipment tab as not applicable.",
//            "337.2. Verify the Name of the Grid in Equipment Exposure is displayed as Mobile Equipment Exposure",
//            "337.3. Verify user is able to add a new row by clicking on Add Row and able to enter data in that row",
//            "337.4. Export the RFR and validate the data in the Exported RFR for Equipment Exposure sheet",
//            "337.5. Enter Valid Data in Exported RFR for Equipment Exposure sheet",
//            "337.6. Validate imported file valid data in Equipment Exposure tab in application and navigate to Causality Exposure tab"
//
//            //Revenue & Liability Limits
//            "338. PS125 - To verify user is able to mark Casualty Exposure - Revenue & Liability Limits tab as Not Applicable",
//            "339. PS126 - Verify user is able to add another row of details in Casualty Exposure Tab, Revenue & Liability Limits grid by clicking on add Row under Program Structure",
//            "340. PS127 - Verify user is able to Delete the added row of details in Casualty Exposure Tab, Revenue & Liability Limits grid by clicking on Delete under Program Structure",
//            "341. PS078 - To verify user is able to enter the details For Estimated Exposure for General Liability for the Policy Period Noted Below in Revenue & Liability Limits tab",
//            "342. PS079 - To verify user is able to enter the details For Program Structure in Revenue & Liability Limits tab",
//            "343. PS080 - To verify user is able to enter the details For Coverage Notes in Revenue & Liability Limits tab",
//            "344. PS081 - To verify user is able to enter the details For General Information in Revenue & Liability Limits tab",
//            "345. Verify validation error messages on the Revenue & Liability Limits Tab",
//            "346. Verify new application changes on Revenue & Liability Limits Tab",
//            "347. Verify user is displayed Show/Hide Column overlay and validate the fields",
//            "348. Revenue & Liability Limits - Verify the country column is pre-selected and disabled in the Show/hide column overlay",
//            "349. Verify when P&C Practice is commercial - in the show/hide overlay, only Products and Sales/service options should be displayed as pre-selected",
//            "350. Revenue & Liability Limits Verify when P&C Practice is Life Science - in the show/hide overlay, only Lab Payroll and Square Footage options should be displayed as pre-selected",
//            "351. PS082 - To verify user is able to enter the details For Coverage Requirements in Revenue & Liability Limits tab and navigate to Product Liability Tab",
//
//            //Product Liability
//            "352. Verify the error message displayed for invalid values for currency field Revenue.Error Message : Enter only currency value (0-9, $, ., ,)",
//            "353. Verify user is able to add a new row by clicking on Add row button",
//            "354. Verify user is able to delete a row",
//            "354.1. Verify the column Product is renamed to Product Name and Revenue is renamed to Total Annual Revenue",
//            "354.2. Verify user is displayed the Show/Hide Columns button",
//            "354.3. Verify the Options present in the Show/Hide Table and select all the options",
//            "354.4. Verify the Error messages on entering invalid values in the fields",
//            "354.5. Enter the details in Product Liability tab",
//            "354.6. Export the RFR and validate data is exported properly",
//            "354.7. Verify the error messages for incorrect values in the exported RFR",
//            "354.8. Enter Valid Data in Exported RFR for Revenue by Products sheet",
//            "354.9. Validate imported file valid data in Product Liability tab in application",
//            "355. Write invalid data in revenue by product of Exported excel file using Auto It",
//            "355.1. Verify error message in import tab for Revenue by products sheet",
//            "355.2. When P&C Practice is Life Science - Verify the changes for Product Liability tab under Casualty Exposure",
//            "356. Verify user is bale to enter valid details in Product Liability - Product Revenue table and navigate to Product Liability Excess tab",
//
//            //Casuality Exposure-Product liability Excess
//            "357. PS131 - To verify user is able to mark Casualty Exposure - Product Liability Excess Tab as Not Applicable",
//            "358. PS132 - Verify user is able to add another row of details in Casualty Exposure Tab, Product Liability Excess Tab by clicking on add Row under Program Structure",
//            "359. Verify user is able to Delete the added row of details in Casualty Exposure Tab, Product Liability Excess Tab by clicking on Delete under Program Structure and click on continue button to navigate on Auto tab",
//
//            //Auto
//            "360. Verify the field zip code is updated to new label - ZIP / Postal Code",
//            "361. Verify ZIP / Postal Code field can accept maximum of 10 character",
//            "362. Verify the error message is displayed when invalid values for ZIP /Postal Code is entered when country is United states - Enter a valid ZIP / Postal Code",
//            "363. When Country is United States Verify user is able to enter ZIP of 5 digits only",
//            "364. When Country is United States Verify user is able to enter ZIP / Postal Code of Zip + 4 code with a dash(???-???) in between.of 5 digits only",
//            "365. When Country is United States Verify the ZIP / Postal Code gets formatted automatically if user enters ZIP and Postal code together",
//            "366. When country is non US - Verify user is able to enter ZIP / Postal Code with alphabets, numbers, and special characters of length 10 characters",
//            "367. Verify the Name of the State column is renamed to State or Province and navigate to Auto Rental & Travel tab",
//
//            //Auto, Auto rental & Travel Tab
//            "368. Verify Total # of Employees grid from the Auto tab is removed from the Auto tab",
//            "369. Verify Total # of Employees grid is added to the new tab Auto Rental / Travel",
//            "370. Verify Auto Rental grid from the Auto tab is removed from the Auto tab",
//            "371. Verify Auto Rental grid is added to the new tab Auto Rental / Travel",
//            "372. Verify International Travel grid is not displayed in Foreign Tab - International Revenue & Payroll Tab",
//            "373. Verify International Travel grid is added to the new tab Auto Rental / Travel",
//            "374. Verify user is displayed a new tab Auto Rental / Travel next to Auto tab under Casualty Exposure",
//            "375. Verify user is able to mark the Auto Rental / Travel Tab as Not Applicable.",
//            "376. Verify User is displayed the Following Grids in Auto Rental/Travel Tab: International Travel,Total # of Employees,Auto Rentals",
//            "377. Verify User is able to add row under International Travel grid by clicking on Add Row Button",
//            "378. Verify user is able to cancel the deletion of the row by clicking on the Cancel button in the delete popup",
//            "379. Verify user is able to delete the row",
//            "380. Validate the Field validation for the all the fields under the 3 grids",
//            "381. Enter the details in the grids for Auto Rental/ Travel tab",
//            "382. Verify user is navigated to RFR list page on clicking save and Close button in Auto Rental / travel tab",
//            "383. Verify user is navigated to the E&O/Cyber Liability tab on clicking Continue button on Auto Rental/ Travel Tab",
//
//            //E&O Cyber Liability
//            "384. PS137 - Verify user is able to add another row of details in Casualty Exposure Tab, E&O/Cyber Liability tab by clicking on add Row under Program Structure",
//            "385. PS138 - Verify user is able to Delete the added row of details in Casualty Exposure Tab, E&O/Cyber Liability tab by clicking on Delete under Program Structure",
//            "386. PS098 - To verify user is able to enter the details for Program Structure in E&O/Cyber Liability tab",
//            "387. PS100 - To verify user is able to enter the details for Schedule of Underlying in E&O/Cyber Liability tab and navigate to E&O/Cyber Liability - Excess tab",
//
//            //Cyber Liability Excess
//            "388. PS139 - To verify user is able to mark Casualty Exposure - E&O/Cyber Liability - Excess tab as Not Applicable",
//            "389. PS140 - Verify user is able to add another row of details in Casualty Exposure Tab, E&O/Cyber Liability - Excess tab by clicking on add Row under Program Structure",
//            "389.1. PS141 - Verify user is able to Delete the added row of details in Casualty Exposure Tab, E&O/Cyber Liability - Excess tab by clicking on Delete under Program Structure",
//            "389.2. PS102 - To verify user is able to enter the details for Program Structure in E&O/Cyber Liability - Excess tab",
//            "389.3. PS103 - To verify user is able to enter the details for Schedule of Underlying in E&O/Cyber Liability - Excess tab and navigate to WC-Exposures",
//
//            //U.S. Workers' Compensation Remuneration Worksheet
//            "390. PS156 - To verify user is able to mark WC Exposure - U.S. Workers' Compensation Remuneration Worksheet tab as Not Applicable",
//            "391. PS157 - Verify user is able to add another row of details in WC Exposure Tab,U.S. Workers' Compensation Remuneration Worksheet tab by clicking on add Row under Limits",
//            "392. PS158 - Verify user is able to Delete the added row of details in WC Exposure Tab, U.S. Workers' Compensation Remuneration Worksheet tab by clicking on Delete under Limits",
//            "393. Verify new application changes on U.S. Workers' Compensation Remuneration Worksheet tab",
//            "394. Verify new application changes on U.S. Workers' Compensation Remuneration Worksheet tab with Positive Test Cases",
//            "395. PS105 - To verify user is able to enter the details in U.S. Workers' Compensation Remuneration Worksheet tab and navigate to Supplementary Application Tab",
//
//            //Supplementary Application
//            "396. PS159 - To verify user is able to mark WC Exposure - Supplementary Application tab as Not Applicable",
//            "397. PS107 - To verify user is able to enter the details in Supplementary Application Tab and navigate to Foreign Tab",
//
//            //International Revenue & Payroll Tab
//            "398. Verify user is not displayed the old grid in foreign tab for International Revenue & Payroll tab grid",
//            "399. Verify the new table and headers are displayed under International Revenue & Payroll tab grid",
//            "400. Verify User is able to enter Text value for Local Legal Entity Name",
//            "401. Verify user is able to enter Alphanumeric values for Street Address",
//            "402. Verify user is able to enter only Alphabet values with special characters (. , ;) for city field",
//            "403. Verify user is able to select the state / Province value from the dropdown by typing first 2 letters of state from the dropdown if the country is US.",
//            "404. Verify user is able to enter the State or Province value as a text if the country is not US.",
//            "405. Verify user is able select the country from the list of countries displayed when user types in type a head field.",
//            "406. Verify user is able to enter Text values without special character in Comments (Please Enter the Currency Code if Currency is not USD) field",
//            "407. Verify user is able to enter currency value for the field Estimated Annual Gross Revenue (USD) ??? Currency and also validate the (,) formatting of the entered value",
//            "408. Verify user is able to enter a currency value with comma in Estimated Annual Gross Revenue (USD) field",
//            "409. Verify User is able to enter a currency value with decimal in Estimated Annual Gross Revenue (USD) field",
//            "410. Verify user is able to view the option for the dropdown field Job Function: All Sales Service Clerical R&D",
//            "411. Verify the default value for the Job Function is 'All'",
//            "412. Verify user is able to select the values from the Job Function drop down",
//            "413. Verify user is displayed error message on entering value other than numeric / numeric with decimal for # of Employees Field - Only numeric values allowed (0-9, ., ,)",
//            "414. Verify user is able to enter numeric / numeric with decimal value in # of Employees Field. Also validate the format is comma separated",
//            "416. Verify user is displayed error message on entering values other than currency for Payroll (USD) - Only currency values allowed (0-9, $, ., ,)",
//            "417. Verify the currency values entered in Payroll (USD) field are displayed with comma formatting",
//            "418. Verify user is able to enter currency value with decimals in Payroll (USD) field",
//            "419. Verify in edit mode the decimal values are displayed for Payroll (USD)",
//            "420. Verify in view mode the currency value entered in Payroll (USD) is displayed in rounded off format",
//            "421. Verify user is displayed error message on entering value other than numeric / numeric with decimal for # of Employees Field under Local National header - Only numeric values allowed (0-9, ., ,)",
//            "422. Verify user is able to enter numeric value in # of Employees Field under Local National header. Also validate the format is comma separated",
//            "424. Verify user is displayed error message on entering values other than currency for Payroll (USD) under Local National header- Only currency values allowed (0-9, $, ., ,)",
//            "425. Verify the currency values entered in Payroll (USD) field under Local National header are displayed with comma formatting.",
//            "426. Verify user is able to enter currency value with decimals in Payroll (USD) field",
//            "427. Verify in edit mode the decimal values are displayed for Payroll (USD) under Local National header",
//            "428. Verify in view mode the currency value entered in Payroll (USD) under Local National header is displayed rounded off format",
//            "429. Verify user is displayed error message on entering value other than numeric / numeric with decimal for # of Employees Field under 3rd Country National header - Only numeric values allowed (0-9, ., ,)",
//            "430. Verify user is able to enter numeric / numeric with decimal value in # of Employees Field under 3rd Country National header. Also validate the format is comma separated",
//            "432. Verify user is displayed error message on entering values other than currency for Payroll (USD) under 3rd Country National header- Only currency values allowed (0-9, $, ., ,)",
//            "433. Verify the currency values entered in Payroll (USD) field under 3rd Country National header are displayed with comma formatting.",
//            "434. Verify user is able to enter currency value with decimals in Payroll (USD) field under 3rd Country National",
//            "435. Verify in edit mode the decimal values are displayed for Payroll (USD) under 3rd Country National header",
//            "436. Verify in view mode the currency value entered in Payroll (USD) under 3rd Country National header is displayed rounded off format",
//            "437. Verify User is able to add row in International Revenue & Payroll grid by clicking on Add Row Button",
//            "438. Verify user is able to cancel the deletion of the row by clicking on the Cancel button in the delete popup in International Revenue & Payroll grid",
//            "439. Verify user is able to delete the row from International Revenue & Payroll grid",
//            "440. On Preview tab - Verify the foreign tab is updated with the new table and details.",
//            "441. Verify the order of the columns in foreign tab for International Revenue & Payroll sub tab and on continue it should be navigated to UMB excess",
//
//            //Umbrella Liability
//            "442. PS165 - To verify user is able to mark UMB/Excess tab - Umbrella Liability tab as Not Applicable",
//            "443. PS166 - Verify user is able to add another row of details in UMB/Excess Tab - Umbrella Liability tab by clicking on add Row under Program Structure",
//            "444. PS167 - Verify user is able to Delete the added row of details in UMB/Excess Tab -Umbrella Liability tab by clicking on Delete under Program Structure",
//            "445. PS168 - Verify user is able to add another row of details in UMB/Excess Tab - Umbrella Liability tab by clicking on add Row under Schedule of Underlying",
//            "446. PS169 - Verify user is able to Delete the added row of details in UMB/Excess Tab - Umbrella Liability tab by clicking on Delete under Schedule of Underlying",
//            "447. PS113 - To verify user is able to enter the details for Program Structure in Umbrella Liability Tab",
//            "448. PS114 - To verify user is able to enter the details for Schedule of Underlying in Umbrella Liability Tab and navigate to Excess Liability tab",
//
//            //Excess Liability
//            "449. PS116 - To verify user is able to enter the details for Program Structure in Excess Liability tab",
//            "450. PS117 - To verify user is able to enter the details for Schedule of Underlying in Excess Liability tab and navigate to Review and Generate Workbook tab",
//
//            //Review Tab
//            "451. Verify user is able to Preview the details entered by user for General Information tab by clicking on General Information in Preview tab",
//            "452. Verify user is able to Preview the details entered by user for Property(SOV) by clicking on Property in Preview tab",
//            "453. Verify user is able to Preview the details entered by user for Property 3rd party by clicking on Property in Preview tab",
//            "454. Verify user is able to Preview the details entered by user for BI Dependent by clicking on Property in Preview tab",
//            "455. Verify user is able to Preview the details entered by user for Revenue & Liability Limits by clicking on Casualty in Preview tab",
//            "456. Verify user is able to Preview the details entered by user for Product Liability by clicking on Casualty in Preview tab",
//            "457. Verify user is able to Preview the details entered by user for Auto by clicking on Casualty in Preview tab",
//            "458. Verify user is able to Preview the details entered by user for Auto Rental & Travel by clicking on Casualty in Preview tab",
//            "459. Verify user is able to Preview the details entered by user for International Revenue & Payroll by clicking on Foreign in Preview tab",
//            "460. Verify user is able to Preview the details entered by user for UMB/Excess by clicking on UMB/Excess in Preview tab",
//            "461. Verify user is able to Preview the details entered by user for Transit Shipment by clicking on Property in Preview tab",
//            "462. Verify user is able to Preview the details entered by user for Product Transit by clicking on Property in Preview tab",
//            "463. Verify user is able to Preview the details entered by user for Product Flow by clicking on Property in Preview tab",
//            "464. Verify user is able to Preview the details entered by user for Transit Location Inventory by clicking on Property in Preview tab"
//
//            //Export
//            "465. Verify user is able to enter the details in the tabs related to life science P&C Practice and export the RFR",
//            "466. Validate Error Message in B.I. Worksheet - CE sheet of Exported excel sheet",
//            "467. Validate Formula in B.I. Worksheet - CE sheet of Exported excel sheet",
//            "468. Validate data in B.I. Worksheet - CE sheet of Exported excel sheet",
//            "469. Verify user is able to enter the details in the BI Worksheet - Standard BI - Multi Location BI Worksheet and export the RFR",
//            "470. Validate Error Message in BI (Multi-Location) sheet of Exported excel sheet",
//            "471. Validate Formula in BI (Multi-Location) sheet of Exported excel sheet",
//            "472. Validate data in BI (Multi-Location) sheet of Exported excel sheet",
//            "473. Verify user is able to enter the details in all the tabs and export the RFR",
//            "474. PS256 - Validate Error Message in Named Insured Tab of Exported excel sheet",
//            "475. PS257 - Validate Formula in Named Insured Tab of Exported excel sheet",
//            "476. PS258 - Validate data in Named Insured sheet of Exported excel sheet",
//            "477. Validate data in Property (SOV) sheet of Exported excel sheet",
//            "478. Validate Error Message in Property SOV Tab of Exported excel sheet",
//            "479. Validate Formula in Property SOV Tab of Exported excel sheet",
//            "480. Validate data in Property (SOV) 3rd Party sheet of Exported excel sheet",
//            "481. Validate Error Message in Property SOV 3rd Party Tab of Exported excel sheet",
//            "482. Validate Formula in Property SOV 3rd Party Tab of Exported excel sheet",
//            "483. Validate Error Message in BI Worksheet (Single) sheet of Exported excel sheet",
//            "484. Validate Formula in BI Worksheet sheet of Exported excel sheet",
//            "485. Validate data in BI Worksheet sheet of Exported excel sheet",
//            "486. Validate Error Message in BI Dependent sheet of Exported excel sheet",
//            "487. Validate Formula in BI Dependent sheet of Exported excel sheet",
//            "488. Validate data in BI Dependent sheet of Exported excel sheet",
//            "489. Validate Formula in Export/ transit Shipments Tab of Exported excel sheet",
//            "490. Validate Error Message in Export/ transit Shipments Tab of Exported excel sheet",
//            "491. Validate data in Export/ transit Shipments sheet of Exported excel sheet",
//            "492. Validate Error Message in Product Transit sheet of Exported excel sheet",
//            "493. Validate Formula in Product Transit sheet of Exported excel sheet",
//            "494. Validate data in Product Transit sheet of Exported excel sheet",
//            "495. Validate Formula in Product Flow sheet of Exported excel sheet",
//            "496. Validate Error Message in Product Flow sheet of Exported excel sheet",
//            "497. Validate data in Product Flow sheet of Exported excel sheet",
//            "498. Validate Error Message in Transit Loc. Inv. sheet of Exported excel sheet",
//            "499. Validate Formula in Transit Loc. Inv. sheet of Exported excel sheet",
//            "500. Validate data in Transit Loc. Inv. sheet of Exported excel sheet",
//            "501. PS259 - Validate Error Message in Revenue & Liability Limits Tab of Exported excel sheet",
//            "502. PS260 - Validate Formula in Revenue & Liability Limits Tab of Exported excel sheet",
//            "503. PS261 - Validate data in Revenue & Liability Limits sheet of Exported excel sheet",
//            "504. Validate Formula in Product Liability Tab of Exported excel sheet",
//            "505. Validate Error Message in Product Liability Tab of Exported excel sheet",
//            "506. Validate data in Product Liability Tab of Exported excel sheet",
//            "507. PS274 - Validate Error Message in Auto Rental & Travel Exposure Tab of Exported excel sheet",
//            "508. PS275 - Validate Formula in Auto Rental & Travel Exposure Tab of Exported excel sheet",
//            "509. PS276 - Validate data in Auto Rental & Travel Exposure sheet of Exported excel sheet",
//            "510. PS277 - Validate Error Message in Driver & Auto List Tab of Exported excel sheet",
//            "511. PS278 - Validate Formula in Driver & Auto List Tab of Exported excel sheet",
//            "512. PS279 - Validate data in Driver & Auto List sheet of Exported excel sheet",
//            "513. PS280 - Validate Error Message in Non-Owned Quest. Tab of Exported excel sheet",
//            "514. PS281 - Validate Formula in Non-Owned Quest. Tab of Exported excel sheet",
//            "515. PS282 - Validate data in Non-Owned Quest. sheet of Exported excel sheet",
//            "516. PS286 - Validate Error Message in Workers Comp Tab of Exported excel sheet",
//            "517. PS287 - Validate Formula in Workers Comp Tab of Exported excel sheet",
//            "518. PS288 - Validate data in Workers Comp sheet of Exported excel sheet",
//            "519. PS289 - Validate Error Message in WC Supplemental Tab of Exported excel sheet",
//            "520. PS290 - Validate Formula in WC Supplemental Tab of Exported excel sheet",
//            "521. PS291 - Validate data in WC Supplemental sheet of Exported excel sheet",
//            "522. Validate Error Message in International Revenue & Payroll sheet of Exported excel sheet",
//            "523. Validate Formula in International Revenue & Payroll sheet of Exported excel sheet",
//            "524. Validate data in International Revenue & Payroll sheet of Exported excel sheet"
//
//            //Import
//            "525. Write valid data in all sheets of Exported excel file using Auto It",
//            "526. Validate imported file valid data in each tabs",
//            "527. Write invalid data in all sheets of Exported excel file using Auto It",
//            "528. Verify error message in import tab",
//            "529. Verify the RFR to be uploaded is validated by the system for the Client Name and and error message \"The client name in the uploaded document does not match with RFR client name\" is displayed",
//            "530. Verify the RFR to be uploaded is validated by the system for the Policy Period and and error message is displayed when incorrect Policy Period is mentioned in the RFR excel",
//            "531. Write valid data when P&C is Life Science in all sheets of Exported excel file using Auto It",
//            "532. Write invalid data when P&C is Life Science in all sheets of Exported excel file using Auto It and import it",
//            "533. Verify the system performs the validation for all the active sheets in RFR excel and highlights the missing sheets and display an Alert ???<<SHEET NAME>> is missing from the workbook.??? should be displayed next to progress bar",
//            "534. Verify on importing the file, workbook label and status is not displayed when the tab is marked as not applicable",
//            "535. On Imported workbook then the status is \"Workbook Imported\" and display the imported workbook date in ???Status Updated on??? column"
//
//            //Phase-1 [Defects]
//            "536. AP-690 WC Exposures Tab-Corporate Officers Listing -Classification Code field-Error tooltip appears on mouse hover even on changing incorrect value to correct one",
//            "537. AP-688 WC Exposures Tab-Corporate Officers Listing - Annual Remuneration field is not accepting special characters",
//            "539. AP-1309 State drop down -On removing the \"US\" country and changing to other country, State drop down presents with respect country",
//            "540. AP-1178 RFR Listing Grid- Export and Import icon tool tip message is not matching with user story",
//            "541. AP-1319 RFR - User is not able to search & select United Kingdom by \"GB\", \"Great Britain\", & \"United Kingdom\"",
//            "542. AP-1164 On entering invalid data in any validation field across the app, it is allowing to continue to next page",
//            "543. AP-1137 Foreign tab - International travel column displaying red border for alphanumeric value when coming back to the page from other tabs",
//            "544. AP-1381 UAT Feedback || Auto - VIN Number - Duplication is allowed in the application. Suppose the user enters with caps. Eg: Row1: ac001 & Row2:AC001",
//            "545. AP-1380 UAT Feedback || In Auto Coverage - Driver Grid -Enter the name as \"D'ore\" and click save , while editing the values after the special character is getting truncated and showing only \"D\"",
//            "546. AP-661 Casualty Exposure - Auto - In Year field, User should enter only 4 digit numeric value",
//            "547. AP-659 Casualty Exposure - Auto - No validation for future DOB, when user manually enter future date in correct format",
//            "548. AP-658 Casualty Exposures Tab-Auto - User is able to enter \"_\" in City, State, Country, Make, Name field.",
//            "549. AP-667 Foreign Tab-International Revenue & Payroll- # of People and # of Trips & Frequency field should not accept decimal values for US Employees, Rest of the World Rows",
//            "550. AP-1081 Property exposures tab - BI worksheet - \"What is (in number of months) the amount of time needed to operate at 100% in the event of a total loss? \" field should not accept decimal values",
//            "551. AP-1080 Property Exposures tab - BI worksheet -\"Extra Expense'' field -Error tool tip appears on mouse hover even on changing incorrect value to correct one",
//            "552. AP-1562 Transit-Incoming Shipment - Not accepting 13 whole numbers & 2 decimal places",
//            "553. AP-885 Property(Sov) Tab -Header name of building number field in which number \"N\" should be capital in both application and exported RFR file",
//            "554. AP-1724 In Exported Excel - For Total Area Sq. Ft. - getting error message on entering decimal value",
//            "555. AP-982 Export RFR- Property (SOV) sheet- Fields are getting hidden by \"#\" on entering values more than 11 characters",
//            "556. AP-973 Export - Workers Comp - The values are not totaling up for Current and Projected columns",
//            "557. AP-1725 Different spelling causing validation message to be displayed for WC-Exposure - Supplementary sheet - for field - Frequency of Safety Inspections for - value Quarterly during import",
//            "558. AP-1608 Import RFR - Workbook - Issue in Editing space in column name",
//            "559. AP-1093 Import - Not Displaying Validation for New Added Sheet",
//            "560. AP-656 Property exposures tab- Transit/Cargo/Stock Throughput-In every percentage field, the field is accepting more than 2 decimal value till the maximum length of the field",
//            "561. AP-1574 Workbook - Contingent BI - Empty Rows are getting inserted into the portal from Workbook",
//            "562. AP-1573 Property(SOV) - If a space is entered before the start of the value in State field, the US states are not recognized.",
//            "563. AP-1550 No Validation message and values getting truncated - Numeric values only - values getting truncated on adding special characters / alphabets between numeric values",
//            "565. AP-1397 The users expecting the application to auto-select the country \"United States\" on entering \"USA\" into the field. (same input received in previous UAT session as well)",
//            "566. AP-1083 Not able to delete a row from the downloaded excel RFR",
//            "567. AP-1262 Export RFR - Workers Comp- After inserting new row on entering value in Estimated Annual Remuneration Projection/Restricted Stock Units (RSUs) sum of values is not appearing under Total Payroll (including RSUs) column",
//            "568. AP-1107 Export RFR- Total column values are appearing in location 2 column when location 2 column is left",
//            "569. AP-1099 Export RFR- Validations are not present for draft status downloaded RFR",
//            "570. AP-1321 Export RFR- Wokers Comp- \"Total Payroll (Including RSUs)for Current Policy Year\" and \"Total Payroll (Including RSUs) Projected for Policy Year\" is editable fields in excel workbook",
//            "571. AP-1334 Clone Feature- Incorrect alert message is displaying for expired policy",
//            "571.1. AP-3056 User had not selected Workers Comp as coverage, while importing back system is throwing an error saying WC and Supplemental app is missing.",
//            "571.2. AP-3063 In Worker comp, for Annual remuneration field formatting properly for currency value while binding first time",
//            "571.3. AP-2687 P&C || RFR Listing Page : Two records are getting created.",
//
//            //Phase-2 [Defects]
//            "572. AP-3013 RFR- Single BI Worksheet- User is not able to Navigate to other tab from Single BI worksheet",
//            "573. AP-2603 Transit Loc - The Values for total field in the exported RFR for Selling price is not same as the value in the application",
//            "574. AP-2303 RFR - Property SOV-3rd party- Values of all inserted columns on table is disappeared, after clicking on continue button",
//            "575. AP-2302 RFR - Property SOV- Values of all inserted columns on table is disappeared, after clicking on continue button",
//            "576. AP-3062 RFR-Workers Comp- In Corporate Officers Listing table - Annual Remuneration column is not accepting alphabets and special characters",
//            "577. AP-3059 RFR-Multi BI worksheet- The field \"Exposed BI w/o OP and with Continuing Value\" is displaying value zero on editing any values after navigated back to tab",
//            "578. AP-3027 Revenue & Liability Limits - Square Footage should be Decimal Number formatted field as per the user the story",
//            "579. AP-3007 RFR-BI Continuing Expenses only worksheet- Expiring limit is mandatory field but no mandatory alert is displayed",
//            "580. AP-2936 Import - Transit Location inv - After Importing the Total Values(Selling Price) is not displaying the correct value",
//            "581. AP-2811 Export - B.I.(Multi-location) - STD - on entering data in 3 rows, only for first row the value for \"Exposed BI w/o OP and with Continuing\" getting calculated and displayed. For the other rows the value is not calculated and displayed",
//            "582. AP-2810 Dependent BI- \"% of Product Revenue impacted\"- on entering value for first time the value \"Annual Revenue Loss field\" is calculating properly, but on changing the \"% of Product Revenue impacted\" value the calculated field is not getting updated",
//            "583. AP-2800 Property(SOV) 3rd Party -\"Not Applicable\\\" checkbox is not preselected When \"Practice Type\" as \"Life Science\" is selected from Cover Page",
//            "584. AP-2775 Application - User is able to add duplicate values for continents / countries after deleting and adding again the same continent / country",
//            "585. AP-2753 Export- International Liab Locations-Total field values are not populated for Empty excel file is exported",
//            "586. AP-2742 Import - Shipment - User is able to import duplicate Continent and Country values and no validation is displayed on importing",
//            "587. AP-2738 Export -Property (SOV) - 3rd Party- Total value is not displayed for selling price in excel sheet",
//            "588. AP-2737 RFR- Shipment Exposures- Total value is missing in review tab under Shipment / Transit Exposures section",
//            "589. AP-2724 RFR- Property (SOV)/Property (SOV) - 3rd Party table is editable on review page",
//            "590. AP-2708 Export - Transit Location Inventory - The values are not calculating correctly in Excel for Total Values (Selling Price), But on import displaying correct total in application",
//            "591. AP-2707 Transit - Product Flow - The Rows Position are getting changed, on clicking add row and then navigating to other tab and back to product flow",
//            "592. AP-2683 Import - BI Worksheet - Single BI sheet - Actual - When Actual option is selected and exported and then same RFR is imported, Projected form is getting displayed along with Actual Form",
//            "593. AP-2680 Additional total rows are getting added for Property(SOV) and property 3rd Party after import",
//            "594. AP-2676 Import - Unwanted validation message displayed during Import",
//            "595. AP-2673 Dependent BI - Zip / Postal Code for the Last row is not retaining after entering value and clicking on continue and revisiting the page / Exporting it",
//            "596. AP-2653 Import-B.I. Worksheet - CE- No validation displayed during import when header name order is incorrect and header name is removed from the sheet",
//            "597. AP-2557 Import -Driver & Auto List - No validations are displayed during import for duplicate values in VIN Number /Driver's License # field",
//            "598. AP-2458 RFR-BI Worksheet-P&C practice is changed to \"Commercial / technology\" from \"Life Science\" then \"Standard BI Worksheet\" option box is not getting preselected, it remains on \"Continuing Expenses only Worksheet\"",
//            "599. AP-2457 Transit tab - Not applicable selection is not retained when travesing back to transit tab (Shipment tab and Transit Loc tab)from Casualty tab",
//            "600. AP-2453 RFR- BI Worksheet- Continuing Expenses only worksheet-Select All checkbox is not getting removed, Clicking on \"Edit\" icon from Property(SOV) location",
//            "601. AP-2446 RFR-BI Worksheet-Standard BI Worksheet-Multi Location BI Worksheet-\"Exposed BI w/o OP\" field calculated value is displayed incorrect",
//            "602. AP-2438 RFR-BI Worksheet-Standard BI Worksheet-Single BI Worksheet- \"Business Interruption BI Values\" column Value should be rounded off to 2 decimal places",
//            "603. AP-2437 RFR-BI Worksheet-Standard BI Worksheet-Single BI Worksheet- \"% Variable/ Non-Continuing\" column is not displayed Correct validation error message",
//            "604. AP-2421 RFR-BI Worksheet-Continuing Expenses only Worksheet- Currency value is not added auto $ symbol in \"Extra Expense (i.e. extraordinary expenses, rent and utilities at temporary locations, moving, installation of equipment)\"field",
//            "605. AP-2418 Export - Product Flow - Annual Value Shipped is not auto calculating and is not displaying the total for the row",
//            "606. AP-2412 RFR-BI Worksheet- \"Continuing Expenses only Worksheet\"-Duplicate Location column getting added after clicking on continue button",
//            "607. AP-2368 Export-Shipment Exposure- Unable to export Country Dropdown, when in application Country option is selected but no country is selected from the dropdown",
//            "608. AP-2357 RFR-BI Worksheet-\"Continuing Expenses only Worksheet\"- The Currency value is not added auto $ symbol in \"Annual Continuing Expenses(i.e. payroll, non-abated rent, utilities, maintenance, etc.)\" field",
//            "609. AP-2222 RFR- Property Sov- \"Total Insured Value\" column should be non editable",
//            "610. AP-2221 RFR- Property Sov- \"Total Values (SOV)\" is editable and values is not appearing in column as per the formula mentioned in user story",
//            "611. AP-1856 Auto Rental/ Travel Tab - International Travel Grid - Number of Foreign hires working or training in U.S. for more than a brief visit (Reverse Trip Travel) field - Not allowing alphabets , and not displaying validation message",
//            "612. AP-1855 Across all Application - State Field - For Non US country, getting error message on entering alphanumeric value for state field.",
//            "613. AP-1854 Foreign - International Liab Locations- City Field displaying error validations in application but in exported excel accepting Alphabets, Numbers and special characters",
//            "614. AP-3078 Import-Property/3rdParty/BI Dependent/Transit-when \"ISO 4 ???Masonry Non Combustible Masonry/concrete walls with steel roof ???Tilt-up with metal roof ??? IBC Type IIA\" Value is selected in Construction Type dropdown column, user get validation on importing page.",
//            "615. AP-2921 Export-Revenue & Liability- Total value is not getting displayed for newly added country row",
//            "616. AP-3049 RFR- BI Dependent- In view mode Construction Type value get changed and not displayed as other tab",
//            "617. AP-2920 Revenue & Liability- When user enter values greater than mentioned length then no validation is displayed for Square Footage field",
//            "618. AP-2802 B.I. Worksheet - CE- Location details getting displayed in BI worksheet CE sheet when there is no location data in property sov",
//            "619. AP-2788 RFR-WC Exposures- The value entered in Total Payroll (Including RSUs) for Current Policy Year/Total Payroll (Including RSUs) Projected for Policy Year field is missing in review tab",
//            "620. AP-2739 Inconsistent - Shipment and Product Transit tab - On exporting the Valuation Information field is not retaining the value.",
//            "621. AP-3180 Causality Exposure: In Revenue & Liability Limits tab, Selected Rest of World from Country dropdown but still displayed the Validation message",
//            "622. AP-2743 Import - Product Transit sheet - Getting validation message for field Product Packaged when value BreakBulk/bulk is selected",
//            "623. AP-2706 Transit Flow - Add Products - The red border for No of Segments field does not disappear on entering the value after the inline message to add the No of segments is displayed",
//            "624. AP-2682 Application - Incorrect validation for year field in Property and 3rd party",
//            "625. AP-2416 Export - Product Flow - State Header should be State or Province",
//            "626. AP-2370 Transit-Shipment-Shipment Terms- Information icon for Shipment Terms row is missing",
//            "627. AP-2367 Export - Shipment Exposure - Total % - No validations are displayed when Total % is more than or less than 100 %",
//            "628. AP-2549 Import - Revenue & Liability Limits - Incorrect Column order displayed in the validation message during import",
//            "629. AP-2455 Export - Transit Loc - Numbers are displayed along with Header names",
//            "630. AP-2443 Export - BI Dependent - Zip Code / Postal Code should be ZIP / Postal Code",
//            "631. AP-2440 Export - BI Dependent - $ symbol not diplsyaed for currency fields Annual Revenue Loss and CBI exposure with available inventory",
//            "632. AP-2435 BI Depedent - United States is not displayed as defualt country",
//            "633. AP-3050 Import- Multi Location BI Worksheet- Formula Values are not getting imported in application",
//            "634. AP-2663 Export - Shipment Exposure - Continents list is not exporting when empty shipment Exposure tab is exported",
//            "635. AP-2541 Transit - Product Flow - On Adding Product by clicking on Add product(s) button, For these rows the Annual Value Shipped field for each individual row is not getting updated.",
//            "636. AP-2365 Export-Transit-Shipment tab - Questionaire - Question 1 -Response - Other - the Text displayed for other option is not displayed properly"

////                // To be run
//            "637. AP-3054 RFR- Property/Property 3rd party/Transit loc -Clone record RFR data is not getting displayed for some columns",
//            "638. AP-2935 Import Version 1 - Revenue & Liability Limits - data not importing, getting Import DataValidation Failed message on import",
//            "639. AP-2693 Version 1 - Import - Non-Owned Quest. - The data of Version 1 for Non-Owned Quest. sheet is not importing",
//            "640. AP-2691 Version 1 - Import -Few values in Property(SOV) are not importing and the total value is not matching the total in the excel for property(SOV).",
//            "641. AP-2542 Export- On exported file BI worksheet sheets displayed even property is not selected in Renewal type field on general information page in application",
//            "642. AP-2431 Export - Transit Loc - The order of columns in the exported sheet is not as per the excel sheet in supporting docs",
//            "643. AP-2423 Export - Transit Loc - % occupied field displaying 10000% as default value instead of 100%",
//            "644. PC-3688 Export - Not able to export RFR from Crime tab",
//            "645. PC-3130 Summary of changes - WC - The total is not getting calculated on updating the value of the existing record in exported RFR",
//            "646. PC-3180: Causality Exposure: In Revenue & Liability Limits tab, Selected Rest of World from Country dropdown but still displayed the Validation message",
//            "647. PC-3372: RFR- Property SOV- deletion is not working fine",
//            "648. PC-3407: Summary Of Changes - Import - Getting header Validation message for Revenue & Liability Limits and Dependent BI Sheets",
//            "649. PC-3160: Summary of Exposure Changes: Exposure Topic - In Named Insured Tab Exported excel sheet doesn???t showing updated data",
//            "650. PC-3718 Clone RFR: Import button is not displayed once select Expired date from Current Term filed",
//            "651. PC-3719 Revenue & Liability Limits || 0 value replace with N/A for Product Revenue and Sales/Service Revenues fields when navigated back to Revenue & Liability Limits tab from Product Liability tab",
//            "652. AP-2656 Export- Property (SOV)/Property (SOV) - 3rd Party/Shipment Terms/Transit Location Inventory- Note is not displayed on column header of \"Year Built\",\"# of Stories\" and \"Shipment Terms\" in excel file sheet",
//            "653. AP-1848 Foreign tab - International Revenue & Payroll - Table not displayed in mentioned order",
//            "654. AP-2363 Transit-Shipment tab - Coverage Notes Accepting more than 1000 characters",
//            "655. AP-3059 RFR-Multi BI worksheet- The field \"Exposed BI w/o OP and with Continuing Value\" is displaying value zero on editing any values after navigated back to tab",
//            "656. AP-2609 Export- B.I.(Multi-location) - STD- Exposed BI w/o OP-Header name is incorrect displayed in excel file",
//            "657. AP-2700 P&C || Export RFR || Shipment : When Val. Information = Other is selected. Please explain text is not populating on the excel. The same issue is occurring on the Product Transit sheet as well.",
//            "658. AP-3035 RFR-Property 3rd Party SOV was not set to default to Not Applicable when record is cloned and selected Life Science as P&C Practice",
//            "659. AP-3057 Property was not selected, during the import system is throwing all the sheets pertain to Property tab as missing.",
//            "700. AP-2729 P&C || RFR :User selected Other in the Valuation Information in Shipment Exposure and enter text for other. And later user changed it to Standard and Exported. In the exported document, the value entered for Other and Standard text both appeared",
//            "701. AP-2731 P&C || RFR : In the Shipment Exposure, user was entering information for By Continents and click on Continue, the data got saved, but when they came back to the screen and select By Countries and clicked continue, the user got an error message",
//            "702. AP-3060 Nevro - Property SOV, CBI/Dependent SOV",
//            "703. AP-2714 Product Liability - The Total label is overriding as a line value",
//            "704. AP-2713 Transit Location Inventory - Data is overriding ???????? The value total from the excel is getting stored as a value on the line item.",
//            "705. AP-3066 RFR- Multi BI worksheet - Multi BI worksheet data is not getting displayed on clone RFR",
//            "706. AP-3067 RFR- Product Flow- On entering correct country in country name column, user getting validation error but after clear and re entering last word validation error is not display",
//            "707. AP-3068 RFR- Transit/Cargo/Stock Throughput- \"Transit Location Inventory\" header is not displayed properly after updating any fields and navigate back to tab",
//            "708. AP-2717 Property (sov) the columns which are added on the property sov are mismatched when reviewed from the Review tab.",
//            "709. AP-2677 P&C || RFR : On the BI worksheet, when user tried to link the location from SOV. Initially, it got mapped. But when user toggled to the other tab and came. The data is missing.",
//            "710. AP-2679 P&C || RFR || Property Sov : Continue button and Save & close buttons are missing when revisiting the tab after Save & close the tab, But user found the buttons appearing when navigate from different tab to SOV tab.",
//            "711. AP-2709 Import RFR - Property SOV, system expecting values to be present in the workbook in the Owned/Leased column during import.",
//            "712. AP-2699 P&C || RFR || Shipment: Total label should be removed from the \"Principal Countries Shipped\" and \"Conveyance Used\" sections",
//            "713. AP-2721 P&C || Import RFR : System is reading Row 0 and throws validation error for Shipment Exposure sheet ???????? Need to be fixed.",
//            "714. AP-2711 RFR - BI Worksheet data is not shown for review",
//            "715. AP-2730 P&C || RFR : Today the user were testing only the Shipment Exposure, when they exported the document and imported back, user got an error for property SOV"
//

//            //Demo
//            "1. PS001 - To verify user navigates to Insurance Renewal List dashboard on clicking Request For Renewal Tile in home page",
//            "2. PS002 - To verify user is able to navigate back to Home page while clicking the Forms link in the breadcrumb",
//            "3. PS003 - Verify user is able to search the Renewal records for a particular Account Handler by selecting name of the handler in search",
//            "4. PS004 - Verify user is able to navigate to next page in the grid by clicking on page number in pagination",
//            "5. PS007 - Verify user is able to search a record by Name Insured",
//            "6. PS008 - Verify user is able to search a record by \"Policy From\"",
//            "7. PS009 - Verify user is able to search a record by \"Policy To\"",
//            "8. PS005 - Verify Delete option is displayed only for the records in ???Draft??? status in the grid",
//            "9. PS013 - Verify user is able to search a record by Status",
//            "10. PS006 - Verify user is displayed No records Found when no records are present for the searched criteria"

//                SOC - Test cases
//                "1. Verify user is able to Login Summary of changes",
//                "2. Verify user is displayed a new tab Summary of Exposure Changes under Review & Generate Workbook next to Import button",
//                "3. Verify the Summary of Exposure Changes tab is disabled by default till the RFR is imported",
//                "4. Verify in Summary of changes the system displays the most recent version of the prior renewal record in the left drop-down and the latest version of the current renewal record in the right drop-down.",
//                "5. Verify If there is no change occurred while comparing the two versions. The system should still show the exposure topic on the list and a message - No key attribute value changes detected.",
//                "6. Verify exposure change statistical panel is displayed on the top-left side in Summary of Exposure Changes with the following exposures: Gross Sale/ Revenue Property TIV Employee Count Total Payroll Vehicle count Driver count Annual Value shipped",
//                "7. Verify in exposure change statistical panel - 3 different information should be displayed: 1. The label of exposure 2. The value difference in the selected versions of the exposure 3. The percentage difference in selected versions of the exposure"
//                "8. Verify for Gross Sale / Revenue - If ???Total Values??? from the version selected in the right drop down, is as same as the ???Total Values??? from the version selected in the left drop down then display ???No Change??? a dash (-) should be displayed",
//                "9. Verify for Gross Sale / Revenue - If the percentage difference is 0 then ???No Change??? should be displayed in grey color",
//                "10. Verify for Property TIV - If the sum of all ???Total Values(SOV)??? from the version selected in right dropdown, is as same as the the sum of all ???Total Values(SOV)??? from the version selected in left dropdown then display ???-??? hypen alone",
//                "11. Verify for Property TIV - If the percentage difference is 0 then ???No Change??? should be displayed in grey color",
//                "12. Verify for Employee Count - If the ???sum of all Total # of Employees (Projected)??? from the version selected in right dropdown, is as same as the the ???sum of all Total # of Employees (Projected)??? from the version selected in left dropdown then display ???-??? hypen alone",
//                "13. Verify for Employee Count - If the percentage difference is 0 then ???No Change??? should be displayed in grey color",
//                "14. Verify for Total Payroll - If the ???sum of all Total Payroll (Projected)??? from the version selected in right dropdown, is as same as the ???sum of all Total Payroll (Projected)??? from the version selected in left dropdown then display ???-??? hypen alone",
//                "15. Verify for Total Payroll - If the ???sum of all Total Payroll (Projected) - If the percentage difference is 0 then ???No Change??? should be displayed in grey color",
//                "16. Verify for Vehicle Count - If the ???Total Count of Vehicle??? from the version selected in right dropdown, is as same as the the ???Total Count of Vehicle??? from the version selected in the left dropdown then display ???-??? hypen alone",
//                "17. Verify for Vehicle Count - If the percentage difference is 0 then ???No Change??? should be displayed in grey color",
//                "18. Verify for Driver Count - If the ???Total Count of Driver??? from the version selected in right dropdown, is as same as the the ???Total Count of Driver??? from the version selected in the left dropdown then display ???-??? hypen alone",
//                "19. Verify for Driver Count - If the percentage difference is 0 then ???0%??? should be displayed",
//                "20. Verify for Annual Value Shipped - If the ???Total (Total Annual Value Shipped)??? from the version selected in right dropdown, is as same as the ???Total (Total Annual Value Shipped)??? from the version selected in left dropdown then display ???-??? hypen alone",
//                "21. Verify for Annual Value Shipped - If the percentage difference is 0 then ???No Change??? should be displayed in grey color",
//                "22. Verify for Gross Sale / Revenue - If ???Total Values??? from the version selected in right dropdown, is greater than the ???Total Values??? from the version selected in the left dropdown then display ???+??? plus symbol and value difference",
//                "23. Verify for Gross Sale / Revenue - If the percentage difference is positive then ???+??? plus symbol should be displayed",
//                "24. Verify for Property TIV - If the sum of all ???Total Values(SOV)??? from the version selected in right dropdown, is greater than the sum of all ???Total Values(SOV)??? from the version selected in left dropdown then display ???+??? plus symbol and value difference",
//                "25. Verify for Property TIV - If the percentage difference is positive then ???+??? plus symbol should be displayed",
//                "26. Verify for Employee Count - If the ???sum of all Total # of Employees (Projected)??? from the version selected in right dropdown, is greater than the ???sum of all Total # of Employees (Projected)??? from the version selected in left dropdown then display ???+??? plus symbol and value difference",
//                "27. Verify for Employee Count - If the percentage difference is positive then ???+??? plus symbol should be displayed",
//                "28. Verify for Total Payroll - If the ???sum of all Total Payroll (Projected)??? from the version selected in right dropdown, is greater than the ???sum of all Total Payroll (Projected)??? from the version selected in left dropdown then display ???+??? plus symbol and value difference",
//                "29. Verify for Total Payroll - If the ???sum of all Total Payroll (Projected)??? - If the percentage difference is positive then ???+??? plus symbol should be displayed",
//                "30. If the ???Total Count of Vehicle??? from the version selected in right dropdown, is greater than the ???Total Count of Vehicle??? from the version selected in the left dropdown then display ???+??? plus symbol and value difference",
//                "31. Verify for Vehicle Count - If the percentage difference is positive then ???+??? plus symbol should be displayed",
//                "32. Verify for Driver Count - If the ???Total Count of Driver??? from the version selected in right dropdown, is greater than the ???Total Count of Driver??? from the version selected in the left dropdown then display ???+??? plus symbol and value difference",
//                "33. Verify for Driver Count -If the percentage difference is positive then ???+??? plus symbol should be displayed",
//                "34. Verify for Annual Value Shipped - If the ???Total (Total Annual Value Shipped)??? from the version selected in right dropdown, is greater than the ???Total (Total Annual Value Shipped)??? from the version selected in left dropdown then display ???+??? plus symbol and value difference",
//                "35. Verify for Annual Value Shipped - If the percentage difference is positive then ???+??? plus symbol should be displayed",
//                "36. Verify user is displayed 2 drop downs for comparing the previous and the latest versions, with labels as Old and New",
//                "37. Verify user is displayed the following details below the drop won on selecting any version from drop down version details displayed in the syntax <<VERSION# - MODIFIED BY - MODIFIED DATE - VERSION TYPE>>",
//                "38. Verify User is not able to select same versions in both the drop downs",
//                "39. Verify user is able to view the Export icon for PDF and Excel",
//                "40. Verify user is displayed a popup allowing the users to select the exposure topic as required also verify all the exposures are selected by default",
//                "41. Verify user is displayed 2 options in popup - Summary Level and Detailed Level",
//                "42. Verify user is able to select only Summary level and uncheck Detailed Level and export the PDF",
//                "43. Verify the name of the downloaded PDF is in the format - ???<<CLIENT_NAME>> - Summary of Changes - View All Changes - <<DATE OF NEW UPLOADED VERSION OF FORMAT MMDDYYYY>>.pdf???",
//                "44. When Summary Level option is selected and downloaded - verify in the downloaded PDF - view all changes' details should be consolidated into a single PDF for the user",
//                "45. Verify user is able to select only Detailed level and uncheck Summary Level and export the PDF",
//                "46. Verify the name of the downloaded PDF is in the format -???<<CLIENT_NAME>> - Summary of Changes - Detailed Level - <<DATE OF NEW UPLOADED VERSION OF FORMAT MMDDYYYY>>.pdf???",
//                "47. When Detailed Level option is selected and downloaded - verify in the downloaded PDF - all Details' Content should be consolidated into a single PDF for the user",
//                "48. When both Summary Level and Detailed Level check boxes are selected - On Clicking Export Button - Zip file should be downloaded in following format - <<CLIENT_NAME>> - Summary of Changes - <<DATE OF NEW UPLOADED VERSION OF FORMAT MMDDYYYY>>",
//                "49. IN Main Summary Area - Verify user is displayed all the Exposure Topics Headers in order in which they appear in the application",
//                "50. Verify user is able to expand / Collapse the exposure and verify the following information is displayed in collapsed mode: 1. The exposure name 2. The change counts. 3. hyperlink ???View All changes??? to view all the exposure changes in the pop up",
//                "51. IN SOC Page - Expand the Named Insureds and verify the following Key Attributes are displayed: 1. New Named Insured Added 2. Named Insured Removed 3. Named Insured Status Changed to Inactive 4. Named Insured Description Of Operations Changed 5. Missing and Duplication of FEIN, Named Insureds Values",
//                "52. Verify User is displayed the count of new records added in Front of New Named Insured Added along with View Details Link",
//                "53. Click on View Details for New Named Insureds Added and verify the data",
//                "54. Verify User is displayed the count of records removed in Front of Named Insured Removed along with View Details Link",
//                "55. Click on View Details for Named Insureds Removed and verify the data",
//                "56. Verify the Details of the Named Insured Description Of Operations Changed by clicking on View Details",
//                "57. Verify if FEIN or Named Insured value is missing or duplicated",
//                "58. Verify in collapsed mode following information is displayed for Named Insureds: 1. Label Name: Named Insured 2. Counts: i. Display the count of all newly added named insured records ii. Display the count of all named insured records removed iii. Display the sum of both Status change and Description of Operation changes 3. View All Changes",
//                "59. Click on View All Changes Link and verify user is displayed all the information mentioned in the Details screen clubbed together in one",
//                "60. Verify user is able to check Total square footage changed",
//                "61. Verify user is able to click on hyperlink View Details to check Total square footage changed",
//                "62. Verify user is able to check Totalling value and Percentage of newly added locations",
//                "63. Verify user is able to click on hyperlink View Details to check Totalling value and Percentage of newly added locations",
//                "64. Verify user is able to view Totaling and Percentage of Locations Removed.",
//                "65. Verify user is able to click View Details and check Totaling and Percentage of Locations Removed.",
//                "66. Verify user is able to check Total Value changed",
//                "67. Verify user is able to click on hyperlink View Details to check Total Value changed",
//                "68. Verify User is able to see Missing or Duplicate Locations",
//                "69. Verify user if user is able to check View Details for Location missing or duplication",
//                "70. Verify user is able to check the Overall Value changed",
//                "71. Verify user is able to click on hyperlink View Details to check Overall Value changed",
//                "72. Verify user is able to click and check View All Changes",
//                "73. Verify User is able to check New location added in Revenue and Liability tab",
//                "74. Verify User is able to click on View Details hyperlink and verify data for newly added location",
//                "75. Verify User is able to check Location Removed in Revenue and Liability tab",
//                "76. Verify User is able to click on View Details hyperlink and verify data for Location removed",
//                "77. Verify User is able to check Product revenue value change and percentage for Revenue and Liability tab",
//                "78. Verify User is able to click on View Details hyperlink to check Product revenue value changes",
//                "79. Verify User is able to check Sales/Service revenue value for Revenue and Liability tab",
//                "80. Verify User is able to click on View Details hyperlink to check Sales/Service revenue value changes",
//                "81. Verify user is able to check U.S Revenue Value Changed.",
//                "82. Verify User is able to click on View Details hyperlink to check U.S Revenue Value Changed.",
//                "83. Verify User is able to check International Revenue Value Changed and Percentage",
//                "84. Verify User is able to click on View Details hyperlink to check International Revenue Value Changed",
//                "85. Verify user is able to click View all Changes link and check details"
//                "86. Verify user is able to check Missing or Duplication location in Revenue",
//                "87. Verify user is able to view Total Annual Value Shipped changed",
//                "88. Verify user is able to click on View Details hyperlink to view Total Annual Value Shipped Changed",
//                "89. Verify user is able to view Average Value per Conveyance",
//                "90. Verify user is able to click on View Details hyperlink to view Average Value per Conveyance",
//                "91. Verify user is able to view Maximum Value per Conveyance Changed",
//                "92. Verify user is able to click on View Details hyperlink to view Maximum Value per Conveyance Changed",
//                "93. Verify User is able to check Vessel Conveyance Used Changed",
//                "94. Verify user is able to click on View Details hyperlink to view Vessel Conveyance Used Changed",
//                "95. Verify User is able to check View all Changes in Shipment Exposure tab",
//                "96. Verify User is able to view newly added location in Transit Location Inv",
//                "97. Verify User is able to click on View Details hyperlink and verify data for newly added location in Transit Inv",
//                "98. Verify User is able to remove location in Transit Location Inv",
//                "99. Verify User is able to click on View Details hyperlink and verify data for removed location in Transit Inv",
//                "100. Verify user is able to check Total Values(Selling Price) Changed and Percentage",
//                "101. Verify User is able to click on View Details hyperlink and verify data for Total Values(Selling Price) in Transit Inv",
//                "102. Verify user is able to check Total Values(Replacement Cost) Changed and Percentage",
//                "103. Verify User is able to click on View Details hyperlink and verify data for Total Values(Replacement Cost) in Transit Inv",
//                "104. Verify User is able to see Missing or Duplicate Locations in Transit Loc Inv",
//                "105. Verify User is able to click on View Details hyperlink and verify missing or duplicated data in Transit Inv",
//                "106. Verify User is able to check View all Changes in Transit Location Inv Tab",
//                "107. Verify User is able to check Maximum value shipped per shipment has changed",
//                "108. Verify User is able to click on View Details hyperlink and verify data for Maximum value shipped per shipment has changed",
//                "109. Verify User is able to check Overall total (Annual Value Shipped) changed",
//                "110. Verify User is able to click on View Details hyperlink and verify data for Overall total (Annual Value Shipped) changed",
//                "111. Verify User is able to check Missing or Duplication data in Product flow tab",
//                "112. Verify User is able to click on View Details hyperlink and verify data for Missing or Duplication data in Product flow tab",
//                "113. Verify User is able to check View all Changes in Product Flow Tab"
//                "114. Verify User is able to check New Driver added in Driver & Auto List tab",
//                "115. Verify User is able to click on View Details hyperlink and verify data for a newly added driver",
//                "116. Verify User is able to check removed driver in Driver & Auto List tab",
//                "117. Verify User is able to click on View Details hyperlink and verify data for a removed driver",
//                "118. Verify User is able to check Driver(s) Location Changed in Driver & Auto List tab",
//                "119. Verify User is able to click on View Details hyperlink and verify data for a Driver(s) Location Changed",
//                "120. Verify User is able to check New Auto added in Driver & Auto List tab",
//                "121. Verify User is able to click on View Details hyperlink and verify data for a newly added Auto",
//                "122. Verify User is able to check removed Auto in Driver & Auto List tab",
//                "123. Verify User is able to click on View Details hyperlink and verify data for a removed Auto",
//                "124. Verify User is able to check Auto Garage Location Changed in Driver & Auto List tab",
//                "125. Verify User is able to click on View Details hyperlink and verify data for a Auto(s) garaging Location Changed",
//                "126. Verify User is able to get records for Missing VIN number or Missing Driver's License",
//                "127. Verify User is able to click on View Details hyperlink and verify data for Missing or Duplication VIN Number in Autos & Drivers tab",
//                "128. Verify User is able to click on View Details hyperlink and verify data for Missing or Duplication Driving License in Autos & Drivers tab",
//                "129. Verify User is able to check View all Changes for Autos & Drivers tab",
//                "130. Verify User is able to check New Country Added in International Liab Locations tab",
//                "131. Verify User is able to click on View Details hyperlink and verify data for a newly added location in International Liab Locations",
//                "132. Verify User is able to check removed country in International Liab Locations tab",
//                "133. Verify User is able to click on View Details hyperlink and verify data for location removed in International Liab Locations",
//                "134. Verify User is able to check Payroll value changed for US Nationals",
//                "135, Verify User is able to click on View Details hyperlink and verify data for Payroll value changed for US Nationals in International Liab Locations",
//                "136. Verify User is able to check Payroll value changed for Local Nationals",
//                "137. Verify User is able to click on View Details hyperlink and verify data for Payroll value changed for local Nationals in International Liab Locations",
//                "138. Verify User is able to check Payroll value changed for 3rd Country Nationals",
//                "139. Verify User is able to click on View Details hyperlink and verify data for Payroll value changed for 3rd Country Nationals in International Liab Locations",
//                "140. Verify User is able to check the number of employees changed for US Nationals, Local and 3rd country",
//                "141. Verify User is able to click on View Details hyperlink and verify data for no of employees value changed for US nationals in International Liab Locations",
//                "142. Verify User is able to click on View Details hyperlink and verify data for no of employees value changed for Local nationals in International Liab Locations",
//                "143. Verify User is able to click on View Details hyperlink and verify data for no of employees value changed for 3rd country nationals in International Liab Locations",
//                "144. Verify User is able to check Duplicate or Missing data in International Liab Locations tab",
//                "145. Verify User is able to click on View Details hyperlink and verify missing or duplicate data in International Liab Locations",
//                "146. Verify User is able to check View all Changes for International Liab Locations tab",
//                "147. Verify User is able to add new location in Dependent BI worksheet",
//                "148. Verify User is able to click on View Details hyperlink and verify data for a newly added location in Dependent BI",
//                "149. Verify User is able to remove location in Dependent BI worksheet",
//                "150. Verify User is able to click on View Details hyperlink and verify data for removed location in Dependent BI",
//                "151. Verify User is able to check changed location in Dependent BI worksheet",
//                "152. Verify User is able to click on View Details hyperlink and verify data for changed location in Dependent BI",
//                "153. Verify User is able to check Duplicate or Missing data in Dependent BI tab",
//                "154. Verify User is able to click on View Details hyperlink and verify data for missing or duplicate in Dependent BI",
//                "155. Verify User is able to check View all Changes for Dependent BI tab",
//                "156. Verify User is able to check BI Value Changed in BI Worksheet - CE",
//                "157. Verify User is able to click on View Details hyperlink and verify data BI Value Changed in BI Worksheet",
//                "158. Verify User is able to check Overall BI Value Changed in BI Worksheet - CE",
//                "159. Verify User is able to click on View Details hyperlink and verify data Overall BI Value Changed in BI Worksheet",
//                "160. Verify User is able to check Negative value detected for Annual Net Profit/(Net Loss) Before Tax in BI Worksheet - CE",
//                "161. Verify User is able to click on View Details hyperlink and verify data Negative value detected for Annual Net Profit/(Net Loss) Before Tax in BI Worksheet",
//                "162. Verify User is able to check View All Changes in BI Worksheet - CE",
//                "163. Verify User is able to check Overall BI Value Changed in B.I.(Single-location) - STD worksheet",
//                "164. Verify User is able to check BI Value(Actual) Changed in B.I. (Single location) - STD",
//                "165. Verify User is able to click on View Details hyperlink and verify data for BI Value(Actual) Changed in B.I. (Single location) - STD",
//                "166. Verify User is able to check BI Value(Projected) Changed in B.I. (Single location) - STD",
//                "167. Verify User is able to click on View Details hyperlink and verify data for BI Value(Projected) Changed in B.I. (Single location) - STD",
//                "168. Verify User is able to check View All Changes in B.I. (Single location) - STD",
//                "169. Verify User is able to check Overall BI Value Changed in B.I.(Multi-location) - STD worksheet",
//                "170. Verify User is able to click on View Details hyperlink and verify data Overall BI Value Changed in B.I.(Multi-location) - STD worksheet",
//                "171. Verify User is able to add new location and check Totalling in B.I.(Multi-location) - STD",
//                "172. Verify User is able to click on View Details hyperlink and verify data for a newly added location in B.I.(Multi-location) - STD",
//                "173. Verify User is able to check removed location and check Totalling in B.I.(Multi-location) - STD",
//                "174. Verify User is able to click on View Details hyperlink and verify data for remove location in B.I.(Multi-location) - STD",
//                "175. Verify User is able to check BI Value Changed in B.I.(Multi-location) - STD",
//                "176. Verify User is able to click on View Details hyperlink and verify data for BI value changed in B.I.(Multi-location) - STD",
//                "177. Verify User is able to check View All Changes in B.I.(Multi-location) - STD worksheet",
//                "178. Verify User is able to check Newly added State(s)/ Class Code in Workers Comp Tab",
//                "179. Verify User is able to click on View Details hyperlink and verify data for Newly added State(s)/ Class Code in Workers Comp Tab",
//                "180. Verify User is able to check removed State(s)/ Class Code in Workers Comp Tab",
//                "181. Verify User is able to click on View Details hyperlink and verify data for Removed State(s)/ Class Code in Workers Comp Tab",
//                "182. Verify User is able to check Total Payroll (Including RSUs) Value Changed in Workers Comp Tab",
//                "183. Verify User is able to check Employee count (Current) changed in Workers Comp Tab",
//                "184. Verify User is able to check Employee count (Projected) changed in Workers Comp Tab",
//                "185. Verify User is able to RSU Values(Projected) Changed in Workers Comp Tab",
//                "186. Verify User is able to RSU Values(Current) Changed in Workers Comp Tab",
//                "187. Verify User is able to check Total Payroll (Including RSUs) Value (Projected) Changed in Workers Comp Tab",
//                "188. Verify User is able to check Total Payroll (Including RSUs) Value (Current) Changed in Workers Comp Tab",
//                "189. Verify User is able to check Duplicate or Missing data in Workers Comp tab",
//                "190. Verify User is able to click on View Details hyperlink and verify data for missing or duplicate in Workers Comp Tab",
//                "191. Verify User is able to check View all Changes for Workers Comp tab",
//                "192. Verify User is able to check Estimated Annual Gross value changed",
//                "193. Verify User is able to click on View Details hyperlink and verify data for Estimated Annual Gross value changed",
//                "194. Verify User is able to check New location added without adding values in Product or Sales/Service revenue in Revenue and Liability tab",
//                "195. Verify user is able to check Total square footage changed for Cloned RFR",
//                "196. Verify user is able to see In Revenue & Liability Tab, Replacements and Deleted messages are being displayed even after adding and deleted new Content",
//                "197. Verify User is able to able to compare Different BI Worksheet in BI Worksheet",
//                "198. Verify the SOC information for each tab should be displayed in Seperate sheets in the Exported excel.",
//                "199. Verify The Location Linked with SOV can be Displayed in the the SOC page"


//   ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//                //  CLAIMS - Done
//                "11. Verify user is able to view the Review Tab in Claim detail screen"
//                "300.1. Verify The ???Review??? tab is visible for all Claim Practices - Managing Liability, Property and Casualty, Workers Compensation"
//
//                 //Claim File Review - Done
//                "12. Verify On selecting the ???Review??? tab, the ???Claim File Review??? details in XXXX should be displayed",
//                "13. Verify Review tab displayed in autoselected on submitting at least one Review or any detail was added to the Review Report section (Parties, Allegation, Policies, or Recommendation).",
//                "14. ???Claim File Review??? section, Verify user is displayed \"Assigned To ''Multiselect Dropdown field with dropdrown values (list of all Claim Consultants, Claims Intake Coordinator (CICs ), Claim Coverage Manager(CCM) and Claim Admin)",
//                "18. Verify email address of selected users should be included in the ???To??? field while sending the email post clicking on \"Submit Review\".",
//                "19. Verify user is displayed error alert message in the popup and filed get highlighted in red- \"Assigned To value is mandatory. Select at least one value from the dropdown\". When user clicks on \"Submit Review\" button without selecting the value in mandatory field",
//                "22. Verify user is displayed \"Review Description\" Text Editor field",
//                "23. Verify user is able to enter 2500 characters Alphanumeric (includes Special Characters) in Review Description Field.",
//                "24. Verify user is displayed \"Severity'' drop down field with values: (Normal, Urgent)",
//                "25. Verify user is displayed \"Severity\" dropdown field with default value of Normal",
//                "26. Verify user is able to select dropdown values of Severity field.",
//                "27. Verify user is displayed \"Review Status\" dropdown field with default value of Open",
//                "28. Verify user is displayed \"Review Status'' drop down field with values: (Open, Completed)",
//                "29. Verify user is able to select dropdown values of Review Status field.",
//                "30. Verify user is displayed checkbox field label as \"Attach Review\"",
//                "31. Verify On selecting the Attach Review checkbox, the pdf downloadable review report should get attached",
//                "32. Verify Attach Review checkbox field should be in the unselected mode by default",
//                "33. Verify user is able to submit the Claim file Review by clicking on the Submit Review Button and an email should be sent to the configured user.",
//                "34. On successfull email sent, validate the Alert popup displayed with title - Success",
//                "35. Verify user is able to close successful email sent alert pop up on clicking \"OK\" button",
//                "38. Verify user is able to view all claim reviews on the right side of the window under Section Title: Review History",
//                "39. Verify user is able to view top 3 recent review logs with details",
//                "40. Validate Review history details (Date Section,Review Status,Review History Title, Review Message, Attachment)",
//                "41. Verify if multiple users are selected then display the first user name followed by the count of remaining ) Eg: Jesse Attix assigned to Darren Cartwright+2 (refer image in left)",
//                "42. Verify on hovering ???plus count icon??? display other names in comma separated format in the tooltip. (Eg: Darren White, Alex Attis) for Review History Title",
//                "43. Verify user should display two lines of message entered in the ???Review Description??? field for Review Message",
//                "44. Verify If the message goes beyond two lines user is displayed a ???more??? hyperlink for review message",
//                "45. Verify user open the full message and display in the same section on clicking ???more??? hyperlink For Review message",
//                "46. Verify If ???Review Report??? is attached while submitting the claim then submitted report should be displayed below the review message",
//                "47. Verify user is able to download the review report submitted by clicking on the document name hyperlink"
//
//                //  -------------- 9.0 Preview All Tab Changes ------------------
//                "268. Verify if the \"Preview\" tab is available in the left tab of the create claim",
//                "269. Verify the various sections in the \"Preview\" tab",
//                "294. Verify if data is displayed in the \"Review History\" section"
//
//                    Download Review Report - Done
//                "48. Verify User is redirect to new tab by clicking on \"view all\" button and view all the review history",
//                "49. Verify Header grid should display Client Name, Claimant/Matter, Claim Type, Claim Number, DOL, Diary Date on new tab of review history",
//                "52. Verify User is displayed log title as timestamp, from user, to users, review status & Severity for all review history (Eg: 04/14/2020 12.32 pm [ Jesse Attix assigned to Darren Wright, Darren White, Alex Attis] Normal & Open)",
//                "53. Verify user is displayed log message as complete review description followed by attachment (if any) for all Review history details",
//                "54. Verify user is able to download the reviews one by one by clicking on the document name hyperlink"

////
//                //Claim Adjustor --
//
//                "180. CR-Claim Adjustor grid- Verify is able to see the Layer and Carrier columns in the existing Claims grid.",
//                "181. CR-Claim Adjustor grid- Verify user is displayed the columns in the following order (Follow up,Layer, Adjustor Name, Carrier, Job Position, Phone Number, Email, Action).",
//                "182. CR-Claim Adjustor grid- Verify Layer and Carrier column should have sort filter and column search option",
//                "183. CR-Claim Adjustor grid - Verify user is able to sort filter and search record by Layer",
//                "184. CR-Claim Adjustor grid -Verify user is able to sort filter and search record by Carrier",
//                "185. CR-Claim Adjustor grid -Verify User is display the list of adjustor based on the order in which the policies where selected.",
//                "186. CR-Claim Adjustor grid - Verify If there are more than one adjustor of the same layer then the names is listed on alphabetical"
//
//
//////                 //Parties - Done
//                "55. In Review Report - Parties, Verify user is display the ???Parties??? table with the header ???PARTIES???",
//                "56. In Review Report - Parties, Verify Below ???Review Report??? header display ???Claimant/Matter??? name of the selected claims with the label ???Claimant/Matter:???",
//                "57. In Review Report - Parties, Verify user is able to add parties information in the review report section",
//                "58. In Review Report - Parties, Verify user is displayed field label as \"Parties Named or Referenced in Compliant''",
//                "59. In Review Report - Parties, Verify user is able to enter 255 characters Alphanumeric (Includes Special characters) in Parties Named or Referenced in Compliant field",
//                "60. In Review Report - Parties, Verify user is restrict from entering values greater than specified field length of 255 characters in Parties Named or Referenced in Compliant",
//                "61. In Review Report - Parties, Verify user is displayed alert message on entering already existing values(duplicate value) in Parties Named or Referenced in Compliant field and validate alert message \"Duplicate Entry: The Party name is already exist\"",
//                "62. In Review Report - Parties, Verify user is display mandatory alert and field get highlighted on leaving mandatory Parties Named or Referenced in Compliant field blank.",
//                "63. In Review Report - Parties, Validate mandatory alert for Parties Named or Referenced in Compliant field",
//                "64. In Review Report - Parties, Verify user is displayed \"Client /N(Y)\" as label name of dropdown field with default value of \"N\"",
//                "65. In Review Report - Parties, Verify user is displayed values \"Y, N\"in Client (Y/N) dropdown field",
//                "66. In Review Report - Parties, Verify user is able to select dropdown values in Client (Y/N) field.",
//                "67. In Review Report - Parties, Verify user is displayed \"Contacted WS re Claim (Y/N)\" as label name of dropdown field with default value of \"N\"",
//                "68. In Review Report - Parties, Verify user is displayed values \"Y, N\"in Contacted WS re Claim (Y/N)) dropdown field",
//                "69. In Review Report - Parties, Verify user is able to select dropdown values in Contacted WS re Claim (Y/N) .field",
//                "70. In Review Report - Parties, Verify user is displayed \"Details\" as label name of Text field",
//                "70.1. In Review Report - Parties, Verify user is able to change the existing values on clicking any cell in a row on edit mode",
//                "71. In Review Report - Parties, Verify user is able to enter 1000 characters Alphanumeric (Includes Special characters) in Details field",
//                "72. In Review Report - Parties, Verify user is restrict from entering values greater than specified field length of 1000 characters in details field",
//                "73. In Review Report - Parties, Verify user is displayed delete icon under Action column",
//                "74. In Review Report - Parties, Verify on clicking the delete icon, display the alert message in a pop-up screen and validate alert pop up message",
//                "75. In Review Report - Parties, Verify on clicking ???No??? button in Alert pop up of delete action it should close the alert popup without further actions",
//                "76. In Review Report - Parties, Verify on clicking ???Yes??? button in Alert pop up of delete action it remove selected record from Parties",
//                "79. Review Report - In Parties table, Verify new row insert into the table on clicking ???Add Row??? button.",
//                "77. In Review Report - Parties, Verify until the user selects a row, the values should be displayed as labels in the table on view mode",
//                "80. Review Report -In Parties table, Verify the first row is pre-added into the table by default",
//                "81. Review Report - In Parties table, Verify user is able to only edit & update the pre-added record"
////
//
//                 //Allegation - Done
//                "83. Review Report - In Allegation, Verify user is display ???Allegation??? accordion with the header ???ALLEGATIONS???",
//                "84. Review Report - In Allegation table , Verify user is displayed \"Allegations\" as label name of Text field",
//                "85. In Review Report - In Allegation table, Verify user is able to enter 1000 characters Alphanumeric (Includes Special characters) in Allegations field",
//                "86. Review Report - In Allegation table, Verify user is restrict from entering values greater than specified field length of 1000 characters in Allegations field",
//                "87. Review Report - In Allegation table, Verify user is displayed \"Parties Involved\" as label name of Multi-select checkbox dropdown field",
//                "88. Review Report - In Allegation table, Verify user is displayed \"party name which is added in the ???Parties??? table should be listed with checkbox \"in the Parties Involved dropdown field",
//                "89. Review Report - In Allegation table, Verify in view mode, selected parties is displayed in the syntax <<PARTY 1>>; <<PARTY 2>>; <<PARTY #>>. Eg: Care Zone, Inc; Provengo LLC; USMC(Claimant) for Parties Involved field",
//                "91. Review Report - In Allegation table, Verify user is display mandatory alert and field get highlighted on leaving mandatory Parties Involved field blank",
//                "92. Review Report - In Allegation Parties, Validate mandatory pop up alert for Parties Involved field",
//                "93. Review Report - In Allegation table , Verify user is displayed delete icon under Action column",
//                "94. In Review Report - In allegations table, Verify on clicking the delete icon, display the alert message in a pop-up screen and validate alert pop up",
//                "95. Review Report - In Allegations table, Verify on clicking ???No??? button in Alert pop up of delete action it should close the alert popup without further actions",
//                "96. Review Report -In Allegation table , Verify on clicking ???Yes??? button in Alert pop up of delete action it remove selected record from Allegation",
//                "88.1. In Review Report - In Allegation table, Verify until the user selects a row, the values should be displayed as labels in the table on view mode",
//                "88.2. In Review Report - In Allegation table, Verify user is able to change the existing values on clicking any cell in a row on edit mode",
//                "84.1. Review Report - In Allegation table, Verify new row insert into the table on clicking ???Add Row??? button."
////
//
//                  //Policies and Notice Recommendations - Done
//                "81.1. Verify if user is able to add new parties in the tab",
//                "100. Review Report - In Policies table, Verify user is able to see see policies table already available in the ???General/Policies/Dairy??? should be replicated with ???Show??? dropdown, & ???policy table???",
//                "102. Review Report - Policies, Verify user is able to filter and view policies based on ???show??? dropdown for existing policy table",
//                "103. Review Report - In Policies, Verifiy user is able to select a policy and update values for sort order, SIR/ Ded, Claim# & upload a document for Policy Documents, ACK, ROR for existing policy table",
//                "104. Review Report - In Policies, Verify user is able to download an existing document from the policies",
//                "106. Review Report - In Policies table, Verify user is displayed \"The party name which is marked as ???Y??? for Client(Y/N) in the ???Parties??? table should be listed in the Party Name dropdown field",
//                "107. Review Report - In policies table, Verify in view mode, selected parties should be displayed as a label for Party Name field",
//                "108. Review Report - In Policies table, Verify in Edit mode, dropdown should be displayed for Party Name field",
//                "109. Review Report - In policies table, Verify user is display mandatory alert and field get highlighted on leaving mandatory Party Name field is blank",
//                "110. Review Report - In Policies Parties, Validate mandatory pop up alert for Party Name field",
//                "111. Review Report - In Policies table , Verify user is displayed \"Policies Placed\" as label name of Text field",
//                "112. Review Report - In Policies table, Verify user is able to enter 255 characters Alphanumeric (Includes Special characters) in Policies Placed field",
//                "113. Review Report - In Policies table, Verify user is restrict from entering values greater than specified field length of 255 characters in Policies Placed field",
//                "117. Review Report - In Policies table , Verify user is displayed delete icon under Action column",
//                "118. In Review Report - In Policies table, Verify on clicking the delete icon, display the alert message in a pop-up screen and validate alert pop up",
//                "119. Review Report - In Policies table, Verify on clicking ???No??? button in Alert pop up of delete action it should close the alert popup without further actions",
//                "120. Review Report -In Policies table , Verify on clicking ???Yes??? button in Alert pop up of delete action it remove selected record from Policies",
//                "121. In Review Report - In Policies table, Verify until the user selects a row, the values should be displayed as labels in the table on view mode",
//                "122. In Review Report - In Policies table, Verify user is able to change the existing values on clicking any cell in a row on edit mode",
//                "123. Review Report - In Policies table, Verify add each row for the number of policies selected in the policy table. i.e Suppose 3 policies are selected then 3 rows should be auto-inserted into the table for the party (selected claim client) by default",
//                "124. Review Report - In Policies table, Verify newly added row",
//                "125. Review Report - In Policies table, Verify user is able to only edit & update the pre-added record",
//                "187. Verify Policies header is rename to Policies & Notice Recommendation",
//                "188. Verify User is displayed \"Notice Recommendation\" as Dropdown field",
//                "189. Verify user displayed following values in ???Notice Recommendation??? dropdown column options",
//                "190. Verify user is displayed new Colum ???Recommendation Detail??? in ???Policies & Notice Recommendation??? section",
//                "192. Verify ???Details of Notice Recommendation:??? is visible only on adding a new row, double click to edit & single click to expand and show the detail",
//                "193. Verify user is able to edit the values directly in the table column for ???Details of Notice Recommendation:???"
//
//
//                //Other Recommendations - Done
//                "81.1. Verify if user is able to add new parties in the tab",
//                "127. Review Report - In Recommended Action , Verify user is display the header ???Other Recommendationsn??? below ???POLICIES??? section,",
//                "194. Verify ???RECOMMENDED ACTION??? header is rename to ???OTHER RECOMMENDATION???",
//                "128. Review Report - In Recommended Action table, Verify user is displayed \"Party Name\" as label name of dropdown field",
//                "129. Review Report - In Recommended Action table, Verify user is displayed \"The parties which are in the ???Parties??? table should be listed in the Party Name\" dropdown field",
//                "130. Review Report - In Recommended Action table, Verify user is able to select only one party name from the Party name dropdown field",
//                "131. Review Report - In Recommended Action table, Verify user is display mandatory alert and field get highlighted on leaving mandatory Party Name field is blank",
//                "132. Review Report - In Recommended Action, Validate mandatory pop up alert for Party Name field",
//                "133. Review Report - In Recommended Action table, Verify user is displayed \"Action\" as label name of Text field",
//                "134. Review Report - In Recommended Action table, Verify user is able to enter 1000 characters Alphanumeric (Includes Special characters) in Action field",
//                "135. Review Report - In Recommended Action table, Verify user is restrict from entering values greater than specified field length of 1000 characters in Action field",
//                "136. Review Report - In Recommended Action table , Verify user is displayed \"Details\" as label name of Text field",
//                "136.1. Review Report - In Recommended Action table, Verify user is able to change the existing values on clicking any cell in a row on edit mode",
//                "136.2. In Review Report - Verify a record with the entered party name should be auto-inserted into ???Recommended Action??? table, when a party name is created in the ???Parties??? table by default",
//                "137. In Review Report - In Recommended Action table, Verify user is able to enter 1000 characters Alphanumeric (Includes Special characters) in Details field",
//                "138. Review Report - In Recommended Action table, Verify user is restrict from entering values greater than specified field length of 1000 characters in Details field",
//                "139. Review Report - In Recommended Action table , Verify user is displayed delete icon under Action column",
//                "140. In Review Report - In Recommended Action table, Verify on clicking the delete icon, display the alert message in a pop-up screen and validate alert pop up",
//                "141. Review Report - In Recommended Action table, Verify on clicking ???No??? button in Alert pop up of delete action it should close the alert popup without further actions",
//                "142. Review Report - In Recommended Action table, Verify on clicking ???Yes??? button in Alert pop up of delete action it remove selected record from Policies",
//                "143. Review Report - In Recommended Action, Verify until the user selects a row, the values should be displayed as labels in the table on view mode",
//                "147. Review Report - In Recommended Action table, Verify User is able to edit & delete the default added rows as well"

////                 //Download Report - Done
//                "148. Download Review Report, Verify user is able to download the Review Report contain parties, allegations, policies & recommended action in the pdf file",
//                "149. Download Review Report, Verify downloaded pdf file name",
//                "150. Download Review Report, Validate claim Review Report.pdf"
//
////                ------------ Claims Listing Page ---------- Done
//
//                "151. Management Liability - Claim Summary Report, Verify user is displayed ???Claims Summary Report??? button in in ???Basic Search??? section on claims listing page",
//                "152. Management Liability - Claim Summary Report, Verify user is able to download the Report of Claims Summary in the excel file on clicking ???Claims Summary Report???",
//                "153. Management Liability - Claim Summary Report, Verify exported excel file name format-<<MMDDYYYY>>.xlsx. Eg: Claim Summary Report - 05272020.xlsx",
//                "154. Management Liability - Claim Summary Report, Validate downloaded excel report"

//          -----------------------------------------------------------------------------------------------------------------------
//                //Claim Detail Screen - Done
//                "155. Claim Detail Screen, Verify user is display button ???Link Claim File(s)??? for claim is not linked or new claim or converting pending claim",
//                "156. Claim Detail Screen - Claim Link, Verify user is display the link icon next to the ???Claimant/Matter??? column in the header table for the selected claim is already linked",
//                "157. Claim Link Popup, Verify Claim Visibility Dropdown contain below values: (All Claims of Selected Client/Linked Claims of Selected Client/Unlinked Claims of Selected Client) and by default, ???Linked Claims of Selected Client??? is selected",
//                "158. Claim Link Popup, Verify If ???All Claims of Selected Client??? is selected in Claim Visibility Dropdown then both claims which are linked already and claims which are not in the link should be listed in the Client Claim table",
//                "160. Claim Link Popup, Verify if ???Linked Claims of Selected Client??? is selected in Claim Visibility Dropdown then only claims which are already linked should be listed in the Client Claim table",
//                "161. Claim Link Popup, Verify If ???Unlinked Claims of Selected Client??? is selected in Claim Visibility Dropdown then claims which are not linked to the selected claim should be listed in the Client Claim Table",
//                "163. Claim Link Popup- If the ???Enable Link Edit Access??? privilege is enabled, Verify Checkboxes is selected mode for claims which are already linked together & for the other claims the checkboxes is unselected.",
//                "164. Claim Link Popup -If the ???Enable Link Edit Access??? privilege is enabled, Verify User is able to select or unselect all checkboxes in the table with the help of a checkbox available in the Client Claim Table header.",
//                "165. Claim Link Popup, Verify popup is displayed by clicking on the ???Linked Claim File(s)??? button then the Linked Claim popup should have ???Link Selected Claim Files??? button"
//
//
//
//                //Claim Listing Page Pop-up - Done
//                "155.1. Claim Listing Screen, Verify user is display button ???Link Claim File(s)??? for claim is not linked or new claim or converting pending claim",
//                "157.1. Claim Link Popup, Verify Claim Visibility Dropdown contain below values: (All Claims of Selected Client/Linked Claims of Selected Client/Unlinked Claims of Selected Client) and by default, ???Linked Claims of Selected Client??? is selected",
//                "158.1. Claim Link Popup, Verify If ???All Claims of Selected Client??? is selected in Claim Visibility Dropdown then both claims which are linked already and claims which are not in the link should be listed in the Client Claim table",
//                "160.1. Claim Link Popup, Verify if ???Linked Claims of Selected Client??? is selected in Claim Visibility Dropdown then only claims which are already linked should be listed in the Client Claim table",
//                "166. Claim Link Popup, Verify If the popup is displayed by clicking on ???Link Icon??? then the Linked Claim popup should have ???Save Changes??? button",
//                "166.1. Claim Link Popup- Verify on clicking ???Save Changes??? button or ??? Link Selected Claim Files??? button,if one claim is selected then claims group is saved to the database",
//                "166.2. Claim Link Popup- Verify user is displayed alert message ,If no claim is selected on clicking ???Save Changes??? button or ??? Link Selected Claim Files??? button",
//                "166.3. Claim Link Popup- Listing Grouped Claims, Verify In ???Enable View Link??? privileges,the claims which are directly linked together alone is displayed in the ???Linked Claims??? table Eg: Suppose ???Claim005??? linked to ???Claim002???, ???Claim003??? and ???Claim003??? linked to ???Claim002???, ???Claim004???",
//                "166.4. Claim Link Popup-In ???Enable Link Edit Acces???, for Listing Grouped Claims, Verify If ???All Claims of Selected Client??? is selected in Claim Visibility dropdown Claims which are directly linked to the selected claim should be listed at the top of the grid and checkbox should be in the selected mode",
//                "166.5. Claim Link Popup - Listing Grouped Claims - In ???Enable Link Edit Acces???, Verify If ???All Claims of Selected Client??? is selected in Claim Visibility dropdown Claims which are not linked but matching to the selected claim client should be listed below and checkbox should be open to select",
//                "166.6. Claim Link Popup- Listing Grouped Claims- In ???Enable Link Edit Acces???, Verify If ???Linked Claims of Selected Client??? is selected in Claim Visibility dropdown then Claims which are directly linked to the selected claim should be listed at the top of the grid and checkbox should be in the selected mode",
//                "166.7. Claim Link Popup - Listing Grouped Claims, Verify If ???Unlinked Claims of Selected Client??? is selected in Claim Visibility dropdown then Claims which are not linked but matching to the selected claim client should be listed below and checkbox should be open to select"

//                // Claim Listing Page - Done
//                "167. Claim Link Popup - If ???Enable View Link??? privilege is enabled, Verify dropdown is prefilled with ???Linked Claims of Selected Client??? value and in non-editable mode",
//                "176. Claim Listing - In the Claims listing table, Verify user is able to see ???Link??? icon in the ???Claimant/Matter??? column next the Claimant name.",
//                "177. In the Claims listing - Verify icon is displayed only if multiple claims are already linked in the application else the icon is not be displayed",
//                "178. In Claims listing - Verify user is able to click visible ???Link??? icon in the application",
//                "179. In Claims listing - Verify user is displayed popup screen on clicking the ???Link??? icon"
//
//
//                  // Validation in Listing Page -
//                "200.1. Claim Link Popup, Verify user is able to see the linked claim popup on clicking Claim link icon available in claim listing and validate Claim Link Popup",
//                "201. Verify privileged users are able to see the 2 tabs : Claim Dashboard and Claim Listing",
//                "202. Verify By default, the ???Tab View??? should be enabled only for below listed users Claims Intake Co-Ordinator (CIC), Claims Coverage Manager (CCM), Claims Executives (CE)",
//                "204. Verify By default, ???Claim Listing??? should be displayed as landing screen for Claims Executives (CE)"
//
//                  // Download from Listing Page -
//                "195. Download Review Report- Verify user is Display ???CONFIDENTIAL AND FOR INTERNAL USE ONLY??? text in red below the title CLAIM REVIEW REPORT.",
//                "195.1. Download Review Report- Verify user is Display ???CONFIDENTIAL AND FOR INTERNAL USE ONLY??? text in red below the title CLAIM REVIEW REPORT",
//                "196. Verify user is display Client Name and Matter name in Report",
//                "197. Verify user display order sections as follows: Summary of Policies and other sections"
//
//                // Claim Detail Page ------
//                "197.1. Verify the Field NCC is renamed to Complex / Non-Critical in General??? section of ???General/Policies/Diary??? tab",
//                "198. Verify the dropdown values for the field Complex / Non-Critical",
//                "199. Verify If ???Non-Complex??? & ???Non-Critical Claim??? is selected for ???NCC???(renamed as ???Complex / Non- Critical???) then the ???Review??? tab should not be displayed",
//                "200. Verify If the ???Complex??? is selected as value for ???NCC???(renamed as ???Complex / Non- Critical???) then following changes should be applied The ???Review??? tab of the Claim should be enabled only if user selected ???Complex???"
////
////                // Claim Dashboard Page ---
//                "206. In Claims Dashboard screen Verify user is displayed the Search Section with the following : WS Practice, Review Status, File Assigned To, Display Auto Claims checkbox, Reset Button, Search Button",
//                "207. Verify in Search Section for WS Practice dropdown - default value is ALL and the following options are displayed : All, Property & Casualty, Management Liability",
//                "208. In Dashboard Search section, Verify for Review Status - All is displayed as default value and following options are displayed in the drop down : All, Open, Completed",
//                "209. In Dashboard Search section - File Assigned to - Verify user is able to search the user by typing the name of the User",
//                "210. Verify user is displayed the checkbox \"Set as default??? below the Claim Dashboard tab",
//                "213. Verify By default, all ???WS Practice??? and all ???Review Status??? of Claims should be listed in the table grid in Dashboard tab",
//                "214. Verify following Columns are displayed in the Dashboard grid : Client Name, Claimant / Matter, Claim Code, WS Consultant, DOL, Complex, Date Created",
//                "215. Verify user is displayed the following columns for the workflow process in the dashboard: File Assigned, CCM Review, Noticed, ACK"
//
//                // Assignment of claim ---
//                "218. Verify user is able to assign the Claim to the consultant from the dashboard if a claim file was not assigned to any consultant"
//
//
//                // Dashboard  ---
//                "218.1. Verify user is able to assign the Claim to the consultant from the dashboard if a claim file was not assigned to any consultant",
//                "219. Verify if the Claim file is already assigned to Consultant from ???Claim Detail Screen??? but communication email was not send then selected Claim Consultant name should be pre-selected in the dropdown",
//                "220. Verify user is displayed the message with field in Red color \"Mandatory Field\" when a mandatory field is left blank in Claim File Assignment popup",
//                "224. Verify the email Template",
//                "257. Download Dashboard Report, Verify user is display button ???Claim Dashboard Report??? before ???Reset??? button.",
//                "258. Download Dashboard Report, Verify clicking on the ???Claim Dashboard Report??? button is download excel report containing the clients and their stages status available in the dashboard screen.",
//                "259. Download Dashboard Report, Verify the format of download excel file name",
//                "260. Download Dashboard Report, Validated the downloaded excel file details"
//
//                //Claim Listing  -----
//                "229. Adjustor Duplication - Verify user is display alert popup if the same duplicating claim adjustor name is entered but not chosen from the suggesting dropdown",
//                "230. Adjustor Duplication- Validate the alert popup",
//                "231. Adjustor Duplication - Verify clicking on ???No??? the popup is close and highlight the ???Adjustor Name??? field and the dropdown with corresponding values should be opened for users selection.",
//                "232. Adjustor Duplication - Verify clicking on ???Yes??? button the popup is close and create a new adjustor name with the same value again and move to the next field",
//                "233. Send Email - Notify Email - In the ???Send Email??? tab, Verify if ???Notify Email??? is selected and the user entered an email address with the following domain",
//                "234. Send Email - Notify Email - In the ???Send Email??? tab, Verify the imported email address is prefilled in ???To??? filled while selecting the ???Notify Email??? option."
//
//                // Temporary Claim File ---
//
//                "235. Temporary Claim File Name - Verify user is display checkbox ???Temporary Claim File??? at the top of the ???Client??? field in the ???General / Policies/ Diary??? tab",
//                "236. Temporary Claim File Name - Verify selecting the ???Temporary Claim File??? checkbox, replace the existing ???Client??? field by \"Temporary Client Name *\"",
//                "237. Temporary Claim File Name - Verify Temporary Client Name * is mandatory Text??? formatted field"

//                // Claim Listing Page ----
//                "239. Verify user is display a note message ???* Temporary Claim File??? to the left of ???Claim Summary Report??? button in search section in the ???Claim Listing Screen???.",
//                "240. Verify user is display a note message ???* Temporary Claim File??? to the left of ???Claim Summary Report??? button in search section in the ???Claim Dashboard Screen???.",
//                "241. Verify user is display a note message ???* Temporary Claim File??? in the ???Report Mode??? listing screen.",
//                "242. In all the search section, Verify the user is able to see both EPIC Client name and Temporary Client name in typeahead suggestion in Client Name column",
//                "243. Verify the temporary client is differentiated with a ???*??? symbol in the suggestion listing",
//                "246. Edit Temporary Claim File- Verify user is display ???Map to EPIC Client??? button next to ???Temporary Client Name??? field",
//                "247. Edit Temporary Claim File - Verify user display pop up on clicking Map to EPIC Client??? button",
//                "248. Edit Temporary Claim File - Validate the pop up details",
//                "249. Edit Temporary Claim File- Verify Clicking on ???Cancel??? button should close the popup without any further changes",
//                "250. Edit Temporary Claim File- Verify Clicking on ???Update??? button should close the popup and display confirmation popup",
//                "251. Edit Temporary Claim File - Validate the confirmation pop up details",
//                "252. Edit Temporary Claim File - Verify Clicking on ???No??? is close the popup",
//                "253. Edit Temporary Claim File - Verify Clicking on ???Yes??? is close the popup and convert the temporary claim file to epic client claim file.",
//                "254. Edit Temporary Claim File - Verify the tag <<SELECTED EPIC CLIENT NAME>> is replaced with epic client name selected in the previous popup",
//                "256. Edit Temporary Claim File - Verify the temporary claim edit changes is enabled also for new claims after clicking on ???Update??? button or returning to the ???General / Policies/Diary??? tab."
////
//                -------- To be Fixed --------
//                "261. Verify if a user is able to link the new claim to the existing claims using the \"Link Claim Files\" button",
//                "262. Verify if the claim link is present in the header for the claims that are already linked",
//                "263. Verify if claim pop-up is displayed on click of \"Claim link\" icon in the claim listing page"
//
//
//
//
//
//                --------- 7.0 Review Request Email ---------
//                "283. Verify if the From email ID matches the logged in user name"
//
//                 ---------- 8.0 Manage Review Servicing Team --------------
//                "284. Verify if \"Manage Review Servicing\" option is available in the \"Home\" menu",
//                "285. Verify if the \"Group Name\" is available in the \"Manage Review Group\" screen",
//                "286. Verify if \"Update Members\" and \"Cancel\" buttons are available in the page",
//                "287. Verify if a pop-up is displayed on clicking on \"Add new group name\"",
//                "288. Verify error message is displayed on click of \"Create\" without filling mandatory field",
//                "289. Verify \"Duplicate\" error message is displayed when the existing group name is entered",
//                "290. Verify if a new group name is given then a new group is created",
//                "291. Verify if clicking on \"Cancel\" closes the pop-up",
//                "292. Verify if the newly added group is present in the drop down list of the group name",
//                "293. Verify if clicking on \"Update Members??? button save the changes made in ???Group Member Table??? related to the selected group"
////
//                // Claim Assignment Notification -
//                "226. Claim Assignment Notification - Verify user is display the claim assignment notification popup only for the claims which are created from the first of the 2021 year alone.",
//                "227. Claim Assignment Notification - Verify user is not display the claim assignment notification popup only for the claims which are created before Jan 01, 2021 year",
//                "228. Noticed Status - Verify user is able to see click for notes hyperlink in noticed status should be available all time after claim assignment"

//                // Defects
//                "11.1. CLAIM-728 Verify user is able to view all tab names in manage liability",
//                "274.1. CLAIM-740 Verify user is able to view Review history details under the review tab",
//                "275.1. CLAIM-944 Verify user is able to view *Temporary claim file in exported pdf document",
//                "275.2. CLAIM-614 Verify user is able to view Claimant in Review report",
//                "276. CLAIM-930 Verify user is able to view temporary client in policies after saving",
//                "277. CLAIM-947 Verify the user is able to view the changed client name in the review tab on converting the temporary file to epic client.",
//                "278. CLAIM-931 Verify user is able to view complete name of temporary clients",
//                "279. CLAIM-943 Verify user is able to view Epic client converted from temporary client in claims dashboard",
//                "280. CLAIM-739 Verify Claims Dashboard spelling on the listing page",
//                "281. CLAIM-730 Verify alert pop up message upon setting default check box on listing page",
//                "282. CLAIM-932 Verify user is navigated to the right page on clicking \"Generate Acord Form\" side menu",
//                "296. CLAIM-911 Verify if user is able to submit notes only post entering the mandatory fields in the \"Click For Notes\" pop-up",
//                "297. CLAIM-926 Verify if the temporary claim file* note message is displayed in the exported review report",
//                "298. CLAIM-897 Verify if the dashboard report is exported with the applied filter"
//                "299. CLAIM-785 Verify if inline message is displayed for \"Click For Notes\" in claim dashboard screen"
//
//
//
//                ------ To be added-------
//
//
//

                "300. CLAIM-784 Verify if username is displayed in the notes pop-up in claim dashboard screen",
                "301. CLAIM-749 Verify if the filters are all cleared once navigated back from \"Pending Claim\" pop-up",
                "302. Verify if user is able to select all the options from \"Assigned To\" drop down list and the count is matched with the actual count",
                "303. CLAIM-397 Verify validation error message for telephone number entered in Claimant/Matter tab"


        );


        // Get the Logger and Configuration details
        logger = LogManager.getLogger("WebTest");
        logger_performance = LogManager.getLogger("com.PandC._perftests");
        logger.info(new String(new char[80]).replace("\0", "="));
        logger.info("Reading the Application Configuration...");
        config = new Configuration();

        String browserName = config.app.getProperty("selenium.webdriver.name");
        int browserWidth = Integer.parseInt(config.app.getProperty("selenium.webdriver.width"));
        int browserHeight = Integer.parseInt(config.app.getProperty("selenium.webdriver.height"));


        // Try to do the QIF activities and Browser initialization
        try {
            logger.info("Initializing the QIF Client...");
            qifClient = new QVizClient(config.qif.getProperty("qif.url.api"));

            logger.info("Authenticating with QIF...");
            qifClient.authenticate(
                    config.qif.getProperty("qif.user.name"),
                    config.qif.getProperty("qif.user.password")
            );

            logger.info("Getting the Project Details from QIF...");
            project1 = qifClient.getProject(config.qif.getProperty("qif.project.gui"));
            project2 = qifClient.getProject(config.qif.getProperty("qif.project2.gui"));
            project3 = qifClient.getProject(config.qif.getProperty("qif.project3.gui"));
            //project3 = qifClient.getProject(config.qif.getProperty("qif.project3.gui"));
            project4 = qifClient.getProject(config.qif.getProperty("qif.project4.gui"));

            logger.info("Getting all the GUI Test Cases for the Project (" + project1.projectName + ") from QIF...");
            guiTestCases = qifClient.getGUITestCases(project1.projectId, false, null);

            logger.info("Getting all the GUI Test Cases for the Project (" + project2.projectName + ") from QIF...");
            guiTestCases.addAll(qifClient.getGUITestCases(project2.projectId, false, null));

            logger.info("Getting all the GUI Test Cases for the Project (" + project3.projectName + ") from QIF...");
            guiTestCases.addAll(qifClient.getGUITestCases(project3.projectId, false, null));

            logger.info("Getting all the GUI Test Cases for the Project (" + project4.projectName + ") from QIF...");
            guiTestCases.addAll(qifClient.getGUITestCases(project4.projectId, false, null));

            List<TestCaseGUI> obsolted_GuiTestCases = new ArrayList<>();
            for (TestCaseGUI testCase : guiTestCases) {
                if (testCase.description.startsWith("[Obsolete]")) {
                    obsolted_GuiTestCases.add(testCase);
                    continue;
                }
                String sNo = testCase.description.split(" ")[0];
                if (config.app.getProperty("app.gui.run.functionalAndUI").equals("True")) {
                    if (sNo.matches(".*[a-zA-Z]+.*")) {
                        if (sNo.contains(".P."))
                            guiTestCases_performance_Tests.add(testCase);
                        else if (sNo.contains(".U."))
                            guiTestCases_UIValidation_Tests.add(testCase);
                        //guiTestCases.remove(testCase);
                    }
                }
            }
            if (obsolted_GuiTestCases.size() > 0)
                guiTestCases.removeAll(obsolted_GuiTestCases);
            for (TestCaseGUI testCase : guiTestCases_performance_Tests)
                guiTestCases.remove(testCase);
            for (TestCaseGUI testCase : guiTestCases_UIValidation_Tests)
                guiTestCases.remove(testCase);
            //Execute selected tests only as mentioned in listOfTCstoExecute
            if (config.app.getProperty("app.gui.executeselectedTCs").toUpperCase().startsWith("T")) {
                List<TestCaseGUI> guiTestCases_new = new ArrayList<>();
                for (TestCaseGUI testCase : guiTestCases) {
                    System.out.println("Desc:" + testCase.description);
                    if (listOfTCstoExecute.contains(testCase.description.replace("  ", " ")))
                        guiTestCases_new.add(testCase);
                }
                guiTestCases = guiTestCases_new;
            }

            guiTestCases.sort((leftCase, rightCase) -> {
                // Get the Serial Numbers from the Test Case Description
				/*Integer leftSerial = Integer.parseInt(
					leftCase.description.substring(0, leftCase.description.indexOf(".")));
				Integer rightSerial = Integer.parseInt(
					rightCase.description.substring(0, rightCase.description.indexOf(".")));*/
                String lftdigit = leftCase.description.split(" ")[0]
                        .substring(0, leftCase.description.split(" ")[0].length() - 1);
                //Pattern.compile("(\\d+(?:\\.\\d+)?)").matcher(leftCase.description).group(1);
                Double leftSerial = Double.parseDouble(lftdigit);
                String rightdigit = rightCase.description.split(" ")[0]
                        .substring(0, rightCase.description.split(" ")[0].length() - 1);
                //Pattern.compile("(\\d+(?:\\.\\d+)?)").matcher(rightCase.description).group(1);
                Double rightSerial = Double.parseDouble(rightdigit);
                // Compare the Serial Numbers for Sorting
                return leftSerial.compareTo(rightSerial);
            });
            logger.info("Total GUI Test Cases fetched for Project (" +
                    project1.projectName + ") from QIF: " + guiTestCases.size());

            logger.info("Total GUI Test Cases fetched for Project (" +
                    project2.projectName + ") from QIF: " + guiTestCases.size());

            logger.info("Total GUI Test Cases fetched for Project (" +
                    project3.projectName + ") from QIF: " + guiTestCases.size());

            logger.info("Total GUI Test Cases fetched for Project (" +
                    project4.projectName + ") from QIF: " + guiTestCases.size());

            logger.info("Initializing the Browser on (" + browserName + ") Web Driver...");
            Browser.initialize(browserName);
            logger.info("Setting the Browser Window Size to (" +
                    browserWidth + "x" + browserHeight + ") Resolution...");
            Browser.webDriver.manage().window().setPosition(new Point(
                    0, 0));
            //Browser.webDriver.manage().window().setSize(new Dimension(browserWidth, browserHeight));
            Browser.webDriver.manage().window().maximize();
            //Browser.webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Browser.webDriver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);

            logger.info("Opening the Application URL in the Browser...");
            Browser.webDriver.get(config.app.getProperty("app.gui.url"));
            if (browserName.equalsIgnoreCase("edge")) {
                WebDriverWait wait = new WebDriverWait(Browser.webDriver, 10);
                try {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".renewal-button")));
                    Browser.webDriver.findElement(By.cssSelector(".menu-blk .dropdown-toggle")).click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menu-blk .dropdown-menu .log-blk")));
                    Browser.webDriver.findElement(By.cssSelector(".menu-blk .dropdown-menu .log-blk")).click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cUsername")));
                } catch (TimeoutException | NoSuchElementException e) {
                }
            }
            isSetUp = true;
        } catch (Exception error) {
            logger.error(error);
            logger.info("Last API Response from QIF:\n" + qifClient.getLastResponse());
            isSetUp = false;
        }
    }

    @DataProvider(name = "QIFDP")
    public Object[][] QIFDP() {
        // Data proovider for the tests to execute
        String[][] TestDesc = new String[guiTestCases.size()][1];
        int i = 0;
        for (TestCaseGUI testCase : guiTestCases)
            TestDesc[i++][0] = testCase.description;
        return TestDesc;
    }

    //@TestFactory
    @Test(dataProvider = "QIFDP")
    //Iterable<DynamicTest> executeTests() {
    public void QIFTests(String sTestDescrition) throws IOException, ParseException, InterruptedException {
        /*List<DynamicTest> guiTests = new ArrayList<>();
		// Make sure the Setup is completed correctly
		if (!isSetUp) {
			// Do a generic Test if the Setup failed
			logger.info("The Test Setup was not successful.");
			guiTests.add(
				dynamicTest("Verify that the Setup was not successful",
					() -> assertFalse(isSetUp))
			);
			return guiTests;
		}
		// Make sure there are GUI Test Cases available from QIF
		if (guiTestCases == null || guiTestCases.size() < 1) {
			// Do a generic Test if there are no Test Cases from QIF
			logger.info("There were no available GUI Test Cases from QIF to execute.");
			guiTests.add(
				dynamicTest("Verify that there are no GUI Test Cases available",
					() -> assertFalse(guiTestCases.size() > 0))
			);
			return guiTests;
		}*/
        // Loop through the GUI Test Cases to add them as Dynamic Tests
        //for (TestCaseGUI testCase : guiTestCases) {
        //TestCaseGUI testCase = guiTestCases.
        TestCaseGUI testCase = null;

        for (TestCaseGUI testCaseTemp : guiTestCases)
            if (testCaseTemp.description.equals(sTestDescrition))
                testCase = testCaseTemp;

        if (testCase == null)
            return;
        Thread.sleep(3000);
        //guiTests.add(dynamicTest(testCase.description, () -> {
        logger.info("EXECUTE: " + testCase.description);
        // Set all the Properties for Test Results
        boolean allPassed = true;
        String lastError = "";
        String lastErrorScreen = "";
        GUITestResult gui = new GUITestResult();
        GUITestResult gui_Perf_Result = new GUITestResult();
        GUITestResult gui_UIVal_Result = new GUITestResult();
        TestCaseGUI gui_Perf_TC = new TestCaseGUI();
        TestCaseGUI gui_UIVal_TC = new TestCaseGUI();
        String UIValidationZipPath = "";
        gui_Perf_TC.description = "";
        gui_UIVal_TC.description = "";
        gui_Perf_Result.testResult.testCaseId = "";
        gui_UIVal_Result.testResult.testCaseId = "";
        String sNo = testCase.description.split(" ")[0];

        if (config.app.getProperty("app.gui.run.functionalAndUI").equals("True")) {
            if (guiTestCases_performance_Tests.stream()
                    .filter(x -> x.description.startsWith(sNo + "P.")).findFirst().orElse(null) != null)
                gui_Perf_TC = guiTestCases_performance_Tests.stream()
                        .filter(x -> x.description.startsWith(sNo + "P.")).findFirst().get();
            if (guiTestCases_UIValidation_Tests.stream()
                    .filter(x -> x.description.startsWith(sNo + "U.")).findFirst().orElse(null) != null)
                gui_UIVal_TC = guiTestCases_UIValidation_Tests.stream()
                        .filter(x -> x.description.startsWith(sNo + "U.")).findFirst().get();
        }
        String sPerfActualResult = "";
        String sUIActualResult = "";
        long iTransactionStartTime = 0;
        boolean PerfromanceTest_pass = false;
        boolean UIValidationTest_pass = false;
        if (!gui_Perf_TC.description.isEmpty()) {
            gui_Perf_Result.testResult.testCaseId = gui_Perf_TC.testCaseId;
            gui_Perf_Result.testResult.moduleId = testCase.moduleId;
            gui_Perf_Result.testResult.subModuleId = testCase.subModuleId;
            gui_Perf_Result.testResult.status = "Broken";
            gui_Perf_Result.testResult.sUT = testCase.project.projectName; //project.projectName;
            gui_Perf_Result.testResult.releaseName = config.app.getProperty("app.gui.releaseName");
            gui_Perf_Result.testResult.releaseNo = config.app.getProperty("app.gui.releaseNo");
            gui_Perf_Result.testResult.sprintName = config.app.getProperty("app.gui.sprintName");
            gui_Perf_Result.testResult.sprintNo = config.app.getProperty("app.gui.sprintNo");
            gui_Perf_Result.testResult.buildVersion = config.app.getProperty("app.gui.buildVersion");
            gui_Perf_Result.testResult.browserName = config.app.getProperty("app.gui.browserName");
            gui_Perf_Result.testResult.browserVersion = config.app.getProperty("app.gui.browserVersion");
            gui_Perf_Result.testResult.resolution = config.app.getProperty("app.gui.resolution");
            gui_Perf_Result.testResult.oSName = config.app.getProperty("app.gui.osName");
            gui_Perf_Result.testResult.oSVersion = config.app.getProperty("app.gui.osVersion");
            gui_Perf_Result.testResult.appType = config.app.getProperty("app.gui.appType");
            gui_Perf_Result.testResult.appVersion = config.app.getProperty("app.gui.appVersion");
            gui_Perf_Result.testResult.executionStartTime = new Date();
            gui_Perf_Result.testResult.projectId = testCase.projectId;
            gui_Perf_Result.testResult.environment = config.app.getProperty("app.gui.environment");
            gui_Perf_Result.testResult.runID = config.app.getProperty("app.gui.runID");
            gui_Perf_TC.testCaseSteps.sort(new srNOSort());
        }
        if (!gui_UIVal_TC.description.isEmpty()) {
            gui_UIVal_Result.testResult.testCaseId = gui_UIVal_TC.testCaseId;
            gui_UIVal_Result.testResult.moduleId = testCase.moduleId;
            gui_UIVal_Result.testResult.subModuleId = testCase.subModuleId;
            gui_UIVal_Result.testResult.status = "Broken";
            gui_UIVal_Result.testResult.sUT = testCase.project.projectName;
            gui_UIVal_Result.testResult.releaseName = config.app.getProperty("app.gui.releaseName");
            gui_UIVal_Result.testResult.releaseNo = config.app.getProperty("app.gui.releaseNo");
            gui_UIVal_Result.testResult.sprintName = config.app.getProperty("app.gui.sprintName");
            gui_UIVal_Result.testResult.sprintNo = config.app.getProperty("app.gui.sprintNo");
            gui_UIVal_Result.testResult.buildVersion = config.app.getProperty("app.gui.buildVersion");
            gui_UIVal_Result.testResult.browserName = config.app.getProperty("app.gui.browserName");
            gui_UIVal_Result.testResult.browserVersion = config.app.getProperty("app.gui.browserVersion");
            gui_UIVal_Result.testResult.resolution = config.app.getProperty("app.gui.resolution");
            gui_UIVal_Result.testResult.oSName = config.app.getProperty("app.gui.osName");
            gui_UIVal_Result.testResult.oSVersion = config.app.getProperty("app.gui.osVersion");
            gui_UIVal_Result.testResult.appType = config.app.getProperty("app.gui.appType");
            gui_UIVal_Result.testResult.appVersion = config.app.getProperty("app.gui.appVersion");
            gui_UIVal_Result.testResult.executionStartTime = new Date();
            gui_UIVal_Result.testResult.projectId = testCase.projectId;
            gui_UIVal_Result.testResult.environment = config.app.getProperty("app.gui.environment");
            gui_UIVal_Result.testResult.runID = config.app.getProperty("app.gui.runID");
            gui_UIVal_TC.testCaseSteps.sort(new srNOSort());
        }
        gui.testResult.testCaseId = testCase.testCaseId;
        gui.testResult.moduleId = testCase.moduleId;
        gui.testResult.subModuleId = testCase.subModuleId;
        gui.testResult.status = "Broken";
        gui.testResult.sUT = testCase.project.projectName;
        gui.testResult.releaseName = config.app.getProperty("app.gui.releaseName");
        gui.testResult.releaseNo = config.app.getProperty("app.gui.releaseNo");
        gui.testResult.sprintName = config.app.getProperty("app.gui.sprintName");
        gui.testResult.sprintNo = config.app.getProperty("app.gui.sprintNo");
        gui.testResult.buildVersion = config.app.getProperty("app.gui.buildVersion");
        gui.testResult.browserName = config.app.getProperty("app.gui.browserName");
        gui.testResult.browserVersion = config.app.getProperty("app.gui.browserVersion");
        gui.testResult.resolution = config.app.getProperty("app.gui.resolution");
        gui.testResult.oSName = config.app.getProperty("app.gui.osName");
        gui.testResult.oSVersion = config.app.getProperty("app.gui.osVersion");
        gui.testResult.appType = config.app.getProperty("app.gui.appType");
        gui.testResult.appVersion = config.app.getProperty("app.gui.appVersion");
        gui.testResult.executionStartTime = new Date();
        gui.testResult.projectId = testCase.projectId;
        gui.testResult.environment = config.app.getProperty("app.gui.environment");
        gui.testResult.runID = config.app.getProperty("app.gui.runID");

        try {
            // Loop through the Test Steps
            int iStepNum = 1;
            String sheetName = "";
            String sText = "";
            String sValue = "";
            String sinnerHTML = "";
            Map<String, String> autoItData = new HashMap<String, String>();
            XSSFWorkbook currentExcelWorkbook = new XSSFWorkbook();
            String sCurrentExcelSheetName = "";
            String typeData = "";
            String Exportdatetime= "";
            String Importdatetime= "";
            for (TestCaseStep testStep : testCase.testCaseSteps) {
                Thread.sleep(2000);

                logger.info("ACTION: Performing the Step Action (" + testStep.stepDescription + ")...");
                TestStepResult stepResult = new TestStepResult();
                // Set all the Properties for Test Step Result
                stepResult.testCaseStepId = testStep.testCaseStepId;
                stepResult.status = "Broken";
                stepResult.executionStartTime = new Date();
                try {
                    // Loop through the Test Step Actions
                    for (TestStepAction testAction : testStep.testStepActions) {
                        ExpectedCondition<Boolean> pageLoadCondition = new
                                ExpectedCondition<Boolean>() {
                                    public Boolean apply(WebDriver driver) {
                                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                                    }
                                };
                        WebDriverWait wait = new WebDriverWait(Browser.webDriver, 60);
                        wait.until(pageLoadCondition);
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
//                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("dx-loadindicator-content")));
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("homeLoaderBG")));
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ag-overlay-loading-center")));
                        // Initialize the Objects required to perform actions

                        logger.info("Test Action Name: " + testAction.action.fieldName + " (" + testAction.action.fieldValue + ")." + testAction.action.actionType);

                        int integerValue;
                        int waitTime = 30;
                        Actions actions = new Actions(Browser.webDriver);

                        // Execute the Test Step Action
                        switch (testAction.action.actionType.toLowerCase()) {
                            case "browse":
                                // Browser opening action
                                Browser.webDriver.get(testAction.action.fieldValue);
                                break;

                            case "click":
//                             [id^="lb_General_"] %2%
                                WebElement elementToClick ;
                                String css = testAction.action.fieldName;
                                if(testAction.action.fieldName.contains(" %"))
                                {
                                     css = testAction.action.fieldName.split(" %")[0];
                                    int index = Integer.parseInt(testAction.action.fieldName.split(" %")[1].split("%")[0]);
                                    elementToClick = Browser.webDriver.findElements(By.cssSelector(css)).get(index);
                                }
                                else
                                {
                                    elementToClick = Browser.webDriver.findElement(By.cssSelector(css));
                                }
                                try {
                                    new WebDriverWait(Browser.webDriver, waitTime)

                                    .until(ExpectedConditions.elementToBeClickable(

                                    By.cssSelector(css)

                                            ));
                                    // Field clicking action
                                    if (elementToClick.getAttribute("type").equals("checkbox")) {
                                        if (testAction.action.fieldValue.equals("true") &&
                                                !elementToClick.isSelected()) {
                                            elementToClick.click();
                                        } else if (testAction.action.fieldValue.equals("false") &&
                                                elementToClick.isSelected()) {
                                            elementToClick.click();
                                        }
                                    } else {
                                        elementToClick.click();
                                    }
                                } catch (Exception ex) {
                                    System.out.println("Errorrrrrrrrr");
                                }
                                break;

                            case "mouse-hover":
                                // Field Mouse Hover action
                                actions.moveToElement(Browser.webDriver.findElement(
                                        By.cssSelector(testAction.action.fieldName)
                                )).perform();
                                break;

                            case "mouse-hover-javascript":
                                WebElement element = Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName));
                                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
                                ((JavascriptExecutor) Browser.webDriver).executeScript(mouseOverScript, element);
                                break;

                            case "clear":
                                // Field clearing action
                                Browser.webDriver.findElement(
                                        By.cssSelector(testAction.action.fieldName)
                                ).clear();
                                break;

                            case "replace":
                                typeData = testAction.action.fieldValue;


                                if (testAction.action.fieldValue.contains("readDataFile")) {
                                    typeData = excelOperation.readDataFromExcel(testAction.action.fieldValue);
                                }
                                // Field value replacing action
                                Browser.webDriver.findElement(
                                        By.cssSelector(testAction.action.fieldName)
                                ).sendKeys(
                                        Keys.chord(Keys.CONTROL, "a"),
                                        typeData
                                );
                                break;

                            case "type":
//                              excelOperation exc=new excelOperation();
                                typeData = testAction.action.fieldValue;
                                if (testAction.action.fieldValue.contains("readDataFile")) {
                                    typeData = excelOperation.readDataFromExcel(testAction.action.fieldValue);
                                }
                                // Field typing action
                                Browser.webDriver.findElement(
                                        By.cssSelector(testAction.action.fieldName)
                                ).sendKeys(typeData);
                                Thread.sleep(500);
                                break;

                            case "match-text":
                                // Field match-test action
                                Thread.sleep(2000);
                                if (testAction.action.fieldValue.contains("readDataFile")) {
                                    typeData = excelOperation.readDataFromExcel(testAction.action.fieldValue);
                                }
                                try {
                                    sText = Browser.webDriver.findElement(
                                            By.cssSelector(testAction.action.fieldName)
                                    ).getText().trim();
                                } catch (NullPointerException ex) {
                                }
                                try {
                                    sValue = Browser.webDriver.findElement(
                                            By.cssSelector(testAction.action.fieldName)
                                    ).getAttribute("value").trim();
                                } catch (NullPointerException ex) {
                                }
                                try {
                                    sinnerHTML = Browser.webDriver.findElement(
                                            By.cssSelector(testAction.action.fieldName)
                                    ).getAttribute("innerhtml").trim();
                                } catch (NullPointerException ex) {
                                }
                                if (!(sText.equals(testAction.action.fieldValue.trim())
                                        || sValue.equals(testAction.action.fieldValue.trim())
                                        || sinnerHTML.equals(testAction.action.fieldValue.trim())
                                        || sText.equals(typeData))) {
                                    stepResult.status = "Fail";
                                    stepResult.actualResult = "Field (" + testAction.action.fieldName + ")" +
                                            "does not match the value given (" + testAction.action.fieldValue +
                                            ") , Got [" + sText + sValue + sinnerHTML + "]";
                                    logger.error(stepResult.actualResult);
                                }
                                break;

                            case "no-match-text":
                                // Field match-test action
                                Thread.sleep(2000);
                                if (testAction.action.fieldValue.contains("readDataFile")) {
                                    typeData = excelOperation.readDataFromExcel(testAction.action.fieldValue);
                                }
                                try {
                                    sText = Browser.webDriver.findElement(
                                            By.cssSelector(testAction.action.fieldName)
                                    ).getText().trim();
                                } catch (NullPointerException ex) {
                                }
                                try {
                                    sValue = Browser.webDriver.findElement(
                                            By.cssSelector(testAction.action.fieldName)
                                    ).getAttribute("value").trim();
                                } catch (NullPointerException ex) {
                                }
                                try {
                                    sinnerHTML = Browser.webDriver.findElement(
                                            By.cssSelector(testAction.action.fieldName)
                                    ).getAttribute("innerhtml").trim();
                                } catch (NullPointerException ex) {
                                }
                                if ((sText.equals(testAction.action.fieldValue.trim())
                                        || sValue.equals(testAction.action.fieldValue.trim())
                                        || sinnerHTML.equals(testAction.action.fieldValue.trim())
                                        || sText.equals(typeData))) {
                                    stepResult.status = "Fail";
                                    stepResult.actualResult = "Field (" + testAction.action.fieldName + ")" +
                                            "match the value given (" + testAction.action.fieldValue +
                                            ") , Got [" + sText + sValue + sinnerHTML + "]";
                                    logger.error(stepResult.actualResult);
                                }
                                break;

                            case "match-selectedtext":
                                String selectedOption = "";
                                try {
                                    Select drpText = new Select(Browser.webDriver.findElement(
                                            By.cssSelector(testAction.action.fieldName)
                                    ));

                                    selectedOption = drpText.getFirstSelectedOption().getText();
                                } catch (NullPointerException ex) {
                                }
                                if (!selectedOption.equals(testAction.action.fieldValue.trim())) {
                                    stepResult.status = "Fail";
                                    stepResult.actualResult = "Field (" + testAction.action.fieldName + ")" +
                                            "does not match the value given (" + testAction.action.fieldValue +
                                            ") , Got [" + selectedOption + "]";
                                    logger.error(stepResult.actualResult);
                                }
                                break;

                            case "contains-text":
                                // Validate Test in filed contains specific text
                                String sTextValue = Browser.webDriver.findElement(
                                        By.cssSelector(testAction.action.fieldName)
                                ).getText();
                                try {
                                    Assert.assertTrue(
                                            sTextValue.contains(testAction.action.fieldValue),
                                            "Text in Field (" + testAction.action.fieldName + ") should contain [" +
                                                    testAction.action.fieldValue + "] and Got [" + sTextValue + "]"
                                    );
                                } catch (AssertionError e) {
                                    throw new Exception("Text in Field (" + testAction.action.fieldName + ") should contain [" +
                                            testAction.action.fieldValue + "] but Got [" + sTextValue + "]");
                                }
                                break;

                            case "select-index":
                                // Field selecting by index action
                                integerValue = Integer.parseInt(testAction.action.fieldValue);
                                Select dropDown = new Select(Browser.webDriver.findElement(
                                        By.cssSelector(testAction.action.fieldName)
                                ));
                                dropDown.selectByIndex(integerValue);
                                break;

                            case "select-visibletext":
                                typeData = testAction.action.fieldValue;
                                if (testAction.action.fieldValue.contains("readDataFile")) {
                                    typeData = excelOperation.readDataFromExcel(testAction.action.fieldValue);
                                }
                                // Field selecting by index action
//                                    String visibleText = testAction.action.fieldValue;
                                Select dropDownText = new Select(Browser.webDriver.findElement(
                                        By.cssSelector(testAction.action.fieldName)
                                ));
                                dropDownText.selectByVisibleText(typeData);
                                break;

                            case "select-value-inputdropdown":
                                typeData = testAction.action.fieldValue;
                                if (testAction.action.fieldValue.contains("readDataFile")) {
                                    typeData = excelOperation.readDataFromExcel(testAction.action.fieldValue);
                                }
                                Browser.webDriver.findElement(
                                        By.cssSelector(testAction.action.fieldName)
                                ).sendKeys(Keys.chord(Keys.CONTROL, "a"), typeData);
                                Thread.sleep(500);

                                Browser.webDriver.findElement(
                                        By.cssSelector(testAction.action.fieldName)
                                ).sendKeys(Keys.ENTER);
                                break;

                            case "wait-display":
                                // Waiting for Field to be visible action
                                integerValue = Integer.parseInt(testAction.action.fieldValue) / 1000;




                                (new WebDriverWait(Browser.webDriver, integerValue))
                                        .until(ExpectedConditions.visibilityOfElementLocated(
                                                By.cssSelector(testAction.action.fieldName)
                                        ));
                                break;

                            case "wait-enable":
                                // Waiting for Field to be enabled action
                                integerValue = Integer.parseInt(testAction.action.fieldValue) / 1000;

                                (new WebDriverWait(Browser.webDriver, integerValue))
                                        .until(ExpectedConditions.elementToBeClickable(
                                                By.cssSelector(testAction.action.fieldName)
                                        ));
                                break;

                            case "javascriptclick":
                                // Waiting for Field to be enabled action
                                    JavascriptExecutor js = (JavascriptExecutor) Browser.webDriver;

                                js.executeScript("arguments[0].click();", Browser.webDriver.findElement(
                                        By.cssSelector(testAction.action.fieldName)));
                                break;


                            case "scrolldown":
                                // Waiting for Field to be enabled action
                                JavascriptExecutor j = (JavascriptExecutor) Browser.webDriver;
                                j.executeScript("window.scrollTo(0, 9999)");
                                Thread.sleep(1000);
                                break;


                            case "scrollup":
                                // Waiting for Field to be enabled action
                                JavascriptExecutor jse = (JavascriptExecutor) Browser.webDriver;
                                jse.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
                                break;
                            case "element-invisible":
                                // Waiting for Field to be invisible action
                                integerValue = Integer.parseInt(testAction.action.fieldValue) / 1000;
                                (new WebDriverWait(Browser.webDriver, integerValue))
                                        .until(ExpectedConditions.invisibilityOfElementLocated(
                                                By.cssSelector(testAction.action.fieldName)
                                        ));
                                break;

                            case "isdisplay":
                                Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).isDisplayed();
                                break;

                            case "wait-alert":
                                integerValue = Integer.parseInt(testAction.action.fieldValue) / 1000;
                                Boolean AlertFound = false;
                                int i = 0;
                                while (i++ < integerValue) {
                                    try {
                                        Alert alert = Browser.webDriver.switchTo().alert();
                                        AlertFound = true;
                                        break;
                                    } catch (NoAlertPresentException e) {
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                }
                                Assert.assertTrue(AlertFound, "Alert/File dialog should be displayed");
                                break;

                            case "uploadfile":
                                if (testAction.action.fieldValue.trim().contains(".")) {
                                    String fileName = System.getProperty("user.dir") + "\\testdata\\filesUpload\\" + testAction.action.fieldValue;
                                    Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).sendKeys(fileName);

                                    break;
                                }

                                if (!testAction.action.fieldName.trim().contains(" ")) {
                                    StringSelection stringSelection = new StringSelection
                                            (Paths.get(System.getProperty("user.dir"), "testdata/filesUpload/", testAction.action.fieldName).toString());
                                    //(System.getProperty("user.dir") + "fautoitfiledatailesUpload/"+testAction.action.fieldName);
                                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                                    clipboard.setContents(stringSelection, null);
                                } else {
                                    String lstofFile = "";
                                    for (String echFile : testAction.action.fieldName.trim().split(" ")) {
                                        lstofFile += "\""
                                                + Paths.get(System.getProperty("user.dir"), "testdata/filesUpload/", echFile).toString()
                                                + "\"";
                                    }
                                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                                    StringSelection stringSelection = new StringSelection(lstofFile);
                                    clipboard.setContents(stringSelection, null);
                                }
                                Robot robot = null;
                                try {
                                    robot = new Robot();
                                } catch (AWTException e) {
                                    e.printStackTrace();
                                }
                                robot.delay(250);
                                robot.keyPress(KeyEvent.VK_CONTROL);
                                robot.keyPress(KeyEvent.VK_V);
                                robot.keyRelease(KeyEvent.VK_V);
                                robot.keyRelease(KeyEvent.VK_CONTROL);
                                robot.delay(1000);
                                robot.keyPress(KeyEvent.VK_ENTER);
                                break;

                            case "sleep":
                                Thread.sleep(Integer.parseInt(testAction.action.fieldValue));
                                break;

                            case "clickaction":
                                WebElement ele = Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName));
                                Actions ob = new Actions(Browser.webDriver);
                                ob.click(ele);
                                org.openqa.selenium.interactions.Action action1 = ob.build();
                                action1.perform();
                                break;

                            case "checkdownladedfile":
//
//                                    Date date = new Date();
//                                    DateFormat df = new SimpleDateFormat("MMddyyyy");
//                                    // Use Madrid's time zone to format the date in
//                                    df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
//                                    String currectDate = df.format(date);
//                                    String tabName = StringUtils.substringBetween(testAction.action.fieldName, "(", ",").trim();


                                String DownloadDir = System.getProperty("user.home") + "\\Downloads\\";
                                //String DownloadDir =tabName+" "+currectDate+".pdf";
                                File dir = new File(DownloadDir);
                                File[] files = dir.listFiles();

                                File lastModifiedFile = files[0];

                                long length1 = 0;
                                long length2 = 0;

                                do {
                                    files = dir.listFiles();

                                    lastModifiedFile = files[0];
                                    for (int l = 1; l < files.length; l++) {
                                        if (lastModifiedFile.lastModified() < files[l].lastModified()) {
                                            lastModifiedFile = files[l];
                                        }
                                    }
                                    System.out.println("in While File Name:" + lastModifiedFile.getName());
                                    if (lastModifiedFile.getName().endsWith("crdownload")) {
                                        Thread.sleep(10000);
                                    } else
                                        break;
                                }
                                while (true);
                                dir = new File(DownloadDir);
                                files = dir.listFiles();

                                lastModifiedFile = files[0];
                                for (int m = 1; m < files.length; m++) {
                                    if (lastModifiedFile.lastModified() < files[m].lastModified()) {
                                        lastModifiedFile = files[m];
                                    }
                                }
                                try {
                                    Thread.sleep(5000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                files = dir.listFiles();

                                lastModifiedFile = files[0];
                                for (int n = 1; n < files.length; n++) {
                                    if (lastModifiedFile.lastModified() < files[n].lastModified()) {
                                        lastModifiedFile = files[n];
                                    }
                                }
                                String filename = lastModifiedFile.getName();
                                String filenameDate = "";

                                if (testAction.action.fieldName.contains("Date")) {
                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy");
                                    LocalDateTime now = LocalDateTime.now();
                                    String currentDate = dtf.format(now);
//                                    String version = StringUtils.substringBetween(filename, "ERRORLOG_VIL.", "_").trim();
//                                    filenameDate = testAction.action.fieldValue.concat(version).concat("_").concat(currentDate).concat(".txt");
                                    filenameDate = testAction.action.fieldValue.concat(" "+currentDate).concat(".xlsx");

                                    testAction.action.fieldValue = filenameDate;
                                }


                                if (!(filename.equalsIgnoreCase(testAction.action.fieldValue))) {
                                    stepResult.status = "Fail";
                                    stepResult.actualResult = "File Name" +
                                            " does not match the value given (" + testAction.action.fieldValue +
                                            ") , Got [" + filename + "]";
                                    logger.error(stepResult.actualResult);
                                }
                                break;

                            case "deletedowloadedfile":
                                File file = new File(System.getProperty("user.home") + "\\Downloads\\" + testAction.action.fieldValue);
                                if (file.delete()) {
                                    System.out.println("File deleted successfully");
                                } else {
                                    System.out.println("Failed to delete the file");
                                }
                                break;

                            case "matchcssvalue":
                                String cssBGValue = "";
                                String cssBGCValue = "";
                                String cssBGImage = "";

                                try {
                                    cssBGCValue = Browser.webDriver.findElement(
                                            By.cssSelector(testAction.action.fieldName)
                                    ).getCssValue("background-color");
                                } catch (NullPointerException ex) {
                                }
                                try {
                                    cssBGValue = Browser.webDriver.findElement(
                                            By.cssSelector(testAction.action.fieldName)
                                    ).getCssValue("background");
                                } catch (NullPointerException ex) {

                                }

                                try {
                                    cssBGImage = Browser.webDriver.findElement(
                                            By.cssSelector(testAction.action.fieldName)
                                    ).getCssValue("background-image");
                                } catch (NullPointerException ex) {
                                }
                                if (!(cssBGValue.equals(testAction.action.fieldValue.trim())
                                        || cssBGCValue.equals(testAction.action.fieldValue.trim()) ||
                                        cssBGImage.equals(testAction.action.fieldValue.trim()))) {
                                    stepResult.status = "Fail";
                                    stepResult.actualResult = "Field (" + testAction.action.fieldName + ")" +
                                            "does not match the value given (" + testAction.action.fieldValue +
                                            ") , Got [" + cssBGValue + cssBGCValue + "]";
                                    logger.error(stepResult.actualResult);
                                }
                                break;

                            case "transactionstart":
                                iTransactionStartTime = (new Date()).getTime();
                                break;

                            case "validatetransactiontime":
                                int LoadTime = Integer.parseInt(config.app.getProperty("app.gui.defaultloadtime"));
                                long TransactionTime = ((new Date()).getTime() - iTransactionStartTime);
                                if (!testAction.action.fieldValue.equals(""))
                                    LoadTime = Integer.parseInt(testAction.action.fieldValue);
                                if (TransactionTime > LoadTime) {
                                    sPerfActualResult = "Time take for this transaction is [" + TransactionTime
                                            + "] milliseconds But expected to be less than [" + LoadTime + "] milliseconds"
                                            + " on Browser: " + config.app.getProperty("selenium.webdriver.name");
                                } else {
                                    sPerfActualResult = "Time take for this transaction is [" + TransactionTime
                                            + "] milliseconds"
                                            + " on Browser: " + config.app.getProperty("selenium.webdriver.name");
                                    PerfromanceTest_pass = true;
                                }
                                break;

                            case "selectfirstelement":
                                robot = null;
                                try {
                                    robot = new Robot();
                                } catch (AWTException e) {
                                    e.printStackTrace();
                                }
                                robot.delay(3000);
                                robot.keyPress(KeyEvent.VK_DOWN);
                                robot.keyRelease(KeyEvent.VK_DOWN);
                                robot.keyPress(KeyEvent.VK_ENTER);
                                robot.keyRelease(KeyEvent.VK_ENTER);
                                robot.delay(3000);
                                break;

                            case "ignore":
                                break;

                            case "uivalidation":
                                LayoutReport layoutReport = Galen.checkLayout(Browser.webDriver, "./src/test/java/com/PandC/uispec/" + testAction.action.fieldValue,
                                        new SectionFilter(Arrays.asList("desktop"), null), new Properties(), new HashMap<String, Object>());
                                List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();
                                GalenTestInfo test = GalenTestInfo.fromString(
                                        gui_UIVal_TC.description
                                                + config.app.getProperty("selenium.webdriver.name"));
                                test.getReport().layout(layoutReport,
                                        gui_UIVal_TC.description.substring(0, 20).replace(" ", "_")
                                                + config.app.getProperty("selenium.webdriver.name"));
                                tests.add(test);
                                HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
                                String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
                                //Create a report
                                htmlReportBuilder.build(tests, "UIValidation/" + gui_UIVal_TC.description.substring(0, 20).replace(" ", "_")
                                        + config.app.getProperty("selenium.webdriver.name") + "_" + timeStamp);
                                String folderToZip = "UIValidation/" + gui_UIVal_TC.description.substring(0, 20).replace(" ", "_")
                                        + config.app.getProperty("selenium.webdriver.name") + "_" + timeStamp;
                                String zipName = "UIValidation/" + gui_UIVal_TC.description.substring(0, 20).replace(" ", "_")
                                        + config.app.getProperty("selenium.webdriver.name") + "_" + timeStamp + ".zip";
                                Path sourceFolderPath = Paths.get(folderToZip);
                                Path zipPath = Paths.get(zipName);
                                ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath.toFile()));
                                Files.walkFileTree(sourceFolderPath, new SimpleFileVisitor<Path>() {
                                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                                        zos.putNextEntry(new ZipEntry(sourceFolderPath.relativize(file).toString()));
                                        Files.copy(file, zos);
                                        zos.closeEntry();
                                        return FileVisitResult.CONTINUE;
                                    }
                                });
                                zos.close();
                                File zipFile = new File(zipName);
                                UIValidationZipPath = qifClient.uploadScreenShot(
                                        config.qif.getProperty("qif.azure.connection"),
                                        config.qif.getProperty("qif.azure.container"),
                                        zipFile);

                                List<ValidationResult> validationErrorResults = layoutReport.getValidationErrorResults();
                                String UIErrors = "";
                                for (ValidationResult validationError : validationErrorResults) {
                                    if (!validationError.getError().isOnlyWarn()) {
                                        List<String> listofMsgs = validationError.getError().getMessages();
                                        for (String eachError : listofMsgs)
                                            UIErrors = UIErrors + eachError + "\n";
                                    }
                                }

                                if (layoutReport.errors() > 0) {
                                    logger.info("Error Count:" + layoutReport.errors());
                                    //Assertions.SoftassertEquals(softAssertion, layoutReport.errors(),0,"UI Validation For:" + sTestName + "  - " +  layoutReport.getScreenshot() + "\nError Messages:" + UIErrors);
                                    sUIActualResult = "Failed with few mismatches On Browser: " + config.app.getProperty("selenium.webdriver.name") + ". Heatmap Attached: " + UIValidationZipPath + "" +
                                            "                 Error Messages:" + UIErrors;
                                } else {
                                    sUIActualResult = "All elements displayed as expected On Browser: " + config.app.getProperty("selenium.webdriver.name") + ". Heatmap attached: " + UIValidationZipPath;
                                    UIValidationTest_pass = true;
                                }
                                break;

                            case "setcurrentexcel":
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy");
                                LocalDateTime now = LocalDateTime.now();
                                String currentDate = dtf.format(now);
                                currentExcelWorkbook = new XSSFWorkbook(new FileInputStream(
                                        System.getProperty("user.home")
                                                + "\\Downloads\\" + testAction.action.fieldValue.concat(" "+currentDate).concat(".xlsx")));
                                break;

                            case "setcurrentexcelsheet":
                                sCurrentExcelSheetName = testAction.action.fieldValue;
                                break;

                            case "matchexcelcellvalue":
                                int iRow = com.PandC.lib.excelOperation.getRow(testAction.action.fieldName) - 1;
                                //Integer.parseInt(testAction.action.fieldName.split(",")[0].trim())-1;
                                int iColumn = com.PandC.lib.excelOperation.convertName2ColumnIndex(
                                        com.PandC.lib.excelOperation.getColumn(testAction.action.fieldName)
                                        //testAction.action.fieldName.split(",")[1].trim()
                                );
                                String sActualValue = "";
                                try {
                                    switch (currentExcelWorkbook.getSheet(sCurrentExcelSheetName)
                                            .getRow(iRow).getCell(iColumn).getCellType()) {
                                        case XSSFCell.CELL_TYPE_NUMERIC:

                                            if (DateUtil.isCellDateFormatted(currentExcelWorkbook.getSheet(sCurrentExcelSheetName)
                                                    .getRow(iRow).getCell(iColumn))) {
                                                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                                                sActualValue = dateFormat.format(currentExcelWorkbook.getSheet(sCurrentExcelSheetName)
                                                        .getRow(iRow).getCell(iColumn).getDateCellValue());
                                            } else if (currentExcelWorkbook.getSheet(sCurrentExcelSheetName)
                                                    .getRow(iRow).getCell(iColumn).getCellStyle().getDataFormatString().contains("%")) {
                                                sActualValue = String.valueOf(currentExcelWorkbook.getSheet(sCurrentExcelSheetName)
                                                        .getRow(iRow).getCell(iColumn).getNumericCellValue() * 100);
                                            } else {
                                                double d = currentExcelWorkbook.getSheet(sCurrentExcelSheetName)
                                                        .getRow(iRow).getCell(iColumn).getNumericCellValue();

                                                if (String.valueOf(d).contains("E")) {
                                                    sActualValue = String.format("%.0f", d);
                                                } else {
                                                    sActualValue = String.valueOf(d).replace(".0", "");
                                                }
                                            }

                                            break;
                                        case XSSFCell.CELL_TYPE_STRING:

                                            sActualValue = currentExcelWorkbook.getSheet(sCurrentExcelSheetName)
                                                    .getRow(iRow).getCell(iColumn).getStringCellValue().trim();
                                            break;

                                        case XSSFCell.CELL_TYPE_FORMULA:
                                            try {
                                                double formaulavalue = currentExcelWorkbook.getSheet(sCurrentExcelSheetName)
                                                        .getRow(iRow).getCell(iColumn).getNumericCellValue();

                                                if (String.valueOf(formaulavalue).contains("E")) {
                                                    sActualValue = String.format("%.0f", formaulavalue);
                                                } else {
                                                    sActualValue = String.valueOf(formaulavalue).replace(".0", "");
                                                }
                                            } catch (IllegalStateException e) {
                                                sActualValue = currentExcelWorkbook.getSheet(sCurrentExcelSheetName)
                                                        .getRow(iRow).getCell(iColumn).getStringCellValue();
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                } catch (NullPointerException ex) {
                                }
                                sActualValue = sActualValue.replaceAll("[\\t\\n\\r]+", " ")
                                        .replaceAll("[^\\x00-\\x7F]", " ");
                                if (!(sActualValue.equals(
                                        testAction.action.fieldValue.replaceAll("[^\\x00-\\x7F]", " ").trim()))) {
                                    stepResult.status = "Fail";
                                    stepResult.actualResult = "Value in Excel Cell (" + testAction.action.fieldName + ")" +
                                            "does not match the value given (" + testAction.action.fieldValue.replaceAll("[^\\x00-\\x7F]", " ").trim() +
                                            ") , Got [" + sActualValue + "]";
                                    logger.error(stepResult.actualResult);

                                }
                                break;

                            case "matchexcelcellformat":

                                int iRowNo = com.PandC.lib.excelOperation.getRow(testAction.action.fieldName) - 1;
											/*Integer
											.parseInt(testAction.action.fieldName.split(",")[0].trim())-1*/
                                ;
                                int iColumnNo = com.PandC.lib.excelOperation.convertName2ColumnIndex(
                                        com.PandC.lib.excelOperation.getColumn(testAction.action.fieldName)
                                        //testAction.action.fieldName.split(",")[1].trim()
                                );
                                String sActualFormat = currentExcelWorkbook.getSheet(sCurrentExcelSheetName)
                                        .getRow(iRowNo).getCell(iColumnNo).getCellStyle().getDataFormatString();

                                if (!(sActualFormat.equals(testAction.action.fieldValue.trim()))) {
                                    stepResult.status = "Fail";
                                    stepResult.actualResult = "Value in Excel Cell (" + testAction.action.fieldName + ")" +
                                            "does not match the value given (" + testAction.action.fieldValue +
                                            ") , Got [" + sActualFormat + "]";
                                    logger.error(stepResult.actualResult);
                                }
                                break;

                            case "clonerfr":
                                WebActions ac = new WebActions();
                                ac.waitForElementClickable(Browser.webDriver, 3000, ".aRFRClone");
                                ac.clickAction(Browser.webDriver, ".aRFRClone");
                                ac.waitForElement(Browser.webDriver, 3000, "#buttonOkClone");
                                ac.clickAction(Browser.webDriver, "#buttonOkClone");
                                ac.replaceText(Browser.webDriver, "#InsuranceDateFrom", "03/13/2018");
                                ac.clickAction(Browser.webDriver, "#btnContinue");
                                ac.waitForElement(Browser.webDriver, 3000, "#UmbrellaEx");
                                ac.clickAction(Browser.webDriver, "#UmbrellaEx");
                                ac.waitForElementClickable(Browser.webDriver, 3000, "button#btnUmbrellaSave");
                                ac.clickAction(Browser.webDriver, "button#btnUmbrellaSave");
                                ac.waitForElement(Browser.webDriver, 3000, "#PopUpOKUmbrella");
                                ac.clickAction(Browser.webDriver, "#PopUpOKUmbrella");
                                ac.waitForElement(Browser.webDriver, 3000, ".aRFRClone");
                                break;

                            case "validateerrormessage":
                                String errorValue = excelOperation.getErrorMessage(testAction.action.fieldName);
                                try {
                                    Assert.assertTrue(
                                            errorValue.equals(testAction.action.fieldValue),
                                            "Validation in Field (" + testAction.action.fieldName + ") should contain [" +
                                                    testAction.action.fieldValue + "] and Got [" + errorValue + "]");
                                } catch (AssertionError e) {
                                    throw new Exception("Validation in Field (" + testAction.action.fieldValue + ") should contain [" +
                                            testAction.action.fieldValue + "] but Got [" + errorValue + "]");
                                }
                                break;

                            case "validateformula":
                                String formulaValue = excelOperation.getFormula(testAction.action.fieldName);

                                try {
                                    Assert.assertTrue(
                                            formulaValue.equals(testAction.action.fieldValue),
                                            "Validation in Field (" + testAction.action.fieldName + ") should contain [" +
                                                    testAction.action.fieldValue + "] and Got [" + formulaValue + "]"

                                    );
                                } catch (AssertionError e) {
                                    throw new Exception("Validation in Field (" + testAction.action.fieldName + ") should contain [" +
                                            testAction.action.fieldValue + "] but Got [" + formulaValue + "]");
                                }
                                break;

                            case "generateautoitfile":
                                try {
                                    excelOperation.writeDataUsingAutoItScript(sheetName, autoItData, testAction.action.fieldValue);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                if (!autoItData.isEmpty()) {
                                    autoItData.clear();
                                }
                                break;

                            case "executeautoitscript":
                                try {
                                    String autoItScriptName = Paths.get(System.getProperty("user.dir"), "testdata/AutoItFiles/", testAction.action.fieldValue + ".au3").toString();
                                    ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\AutoIt3\\AutoIt3.exe", autoItScriptName);
                                    Process p = pb.start();
                                    //Waiting for the process to complete
                                    while (p.isAlive()) {
                                    }
                                    logger.info("Run the " + autoItScriptName + " and Data has been written into the " + testAction.action.fieldValue + " sheet");

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;

                            case "uploadexportedfile":
                                //   String lstofFil= testAction.action.fieldValue;
                                String fileName = System.getProperty("user.home") + "\\Downloads\\" + testAction.action.fieldValue;
                                File uplodafile = new File(fileName);
                                if (uplodafile.exists()) {
                                    System.out.println("File not exist in " + fileName + " directory");
                                } else {
                                    fileName = Paths.get(System.getProperty("user.dir"), "testdata/ExcelTestData/", sheetName).toString();
                                    System.out.println("File exist in " + fileName + " directory");
                                }
                                Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).sendKeys(fileName);
                                break;

                            case "validateselected-checkbox":
                                Thread.sleep(2000);
                                boolean isTrue = false;
                                try {
                                    if (testAction.action.fieldValue.equals("true")) {
                                        isTrue = Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).isSelected();
                                        Assert.assertTrue(isTrue, "Checkbox should be selected");
                                    } else {
                                        isTrue = !Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).isSelected();
                                        Assert.assertTrue(isTrue, "Checkbox should not be selected");
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;

                            case "autoitfiledata":
                                if (testAction.action.fieldValue.contains("readDataFile")) {
                                    String writeData = excelOperation.readDataFromExcel(testAction.action.fieldValue);
                                    autoItData.put(testAction.action.fieldName, writeData);

                                } else {
                                    sheetName = testAction.action.fieldValue;
                                }
                                break;

                            case "deletesheetautoitfile":
                                try {
                                    excelOperation.removeExcelSheetUsingAutoItScript(sheetName, testAction.action.fieldValue);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;

                            case "addsheetautoitfile":
                                try {
                                    excelOperation.addExcelSheetUsingAutoItScript(sheetName, testAction.action.fieldValue);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;

                            case "addrowinsheetautoit":
                                try {
                                    String excelSheetName = null;
                                    int rowNumberOfSheet = 0;
                                    if (testAction.action.fieldValue.contains("readvalues")) {
                                        excelSheetName = StringUtils.substringBetween(testAction.action.fieldValue, "(", ",").trim();
                                        rowNumberOfSheet = Integer.parseInt(StringUtils.substringBetween(testAction.action.fieldValue, ",", ")").trim());
                                    }
                                    excelOperation.addRowInSheetUsingAutoItScript(sheetName, excelSheetName, rowNumberOfSheet);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;

                            case "removerowinsheetautoit":
                                try {
                                    String excelSheetName = null;
                                    int rowNumberOfSheet = 0;
                                    if (testAction.action.fieldValue.contains("readvalues")) {
                                        excelSheetName = StringUtils.substringBetween(testAction.action.fieldValue, "(", ",").trim();
                                        rowNumberOfSheet = Integer.parseInt(StringUtils.substringBetween(testAction.action.fieldValue, ",", ")").trim());
                                    }
                                    excelOperation.removeRowInSheetFromAutoItScript(sheetName, excelSheetName, rowNumberOfSheet);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;

                            case "currentdatetime":
                                try {
                                    Date date = new Date();
                                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                                    // Use Madrid's time zone to format the date in
                                    df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
                                    String currectDateTime = df.format(date);
                                    System.out.println("Date and time in Madrid: " + df.format(date));

                                    sText = Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).getText().trim();
                                    if (!sText.contains(currectDateTime)) {
                                        stepResult.status = "Fail";
                                        stepResult.actualResult = "Field (" + testAction.action.fieldName + ")" +
                                                "does not match the value given (" + currectDateTime +
                                                ") , Got [" + sText + "]";
                                        logger.error(stepResult.actualResult);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;

                            case "findsheetnameinexcel":
                                try {
                                    excelOperation.findSheetNameUsingAutoItScript(testAction.action.fieldValue, sCurrentExcelSheetName);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;

                            case "readexcelcellcomment":
                                try {
                                    excelOperation.readCommentsExcel(testAction.action.fieldValue, sCurrentExcelSheetName, testAction.action.fieldName);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;

                            case "readdatafromtextfile":
                                try {
                                    String generatedFilePath = Paths.get(System.getProperty("user.dir"), "testdata/AutoItFiles/" + testAction.action.fieldName).toString();
                                    sText = new String(Files.readAllBytes(Paths.get(generatedFilePath))).trim();
                                    if (!sText.equals(testAction.action.fieldValue)) {
                                        stepResult.status = "Fail";
                                        stepResult.actualResult = "Data (" + sText + ")" +
                                                "does not match the value given (" + testAction.action.fieldValue +
                                                ") , Got [" + sText + "]";
                                        logger.error(stepResult.actualResult);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;

                            case "verifyversion":
                                try {
                                    Date date = new Date();
                                    DateFormat df = new SimpleDateFormat("MMddyyyy");
                                    // Use Madrid's time zone to format the date in
                                    df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
                                    String currectDateTime =df.format(date);
                                    System.out.println("Date and time in Madrid: " + df.format(date));
                                    try {
                                        sText = Browser.webDriver.findElement(
                                                By.cssSelector(testAction.action.fieldName)
                                        ).getText().trim();
                                    }catch (NullPointerException ex) {
                                    }
                                    try {
                                        sValue = Browser.webDriver.findElement(
                                                By.cssSelector(testAction.action.fieldName)
                                        ).getAttribute("value").trim();
                                    } catch (NullPointerException ex) {
                                    }
                                    try {
                                        sinnerHTML = Browser.webDriver.findElement(
                                                By.cssSelector(testAction.action.fieldName)
                                        ).getAttribute("innerhtml").trim();
                                    } catch (NullPointerException ex) {
                                    }
                                    if (!(sText.equals(testAction.action.fieldValue + "_" + currectDateTime.trim())
                                            || sValue.equals(testAction.action.fieldValue + "_" + currectDateTime.trim())
                                            || sinnerHTML.equals(testAction.action.fieldValue + "_" + currectDateTime.trim())
                                            || sText.equals(typeData))){
                                        stepResult.status = "Fail";
                                        stepResult.actualResult = "Field (" + testAction.action.fieldName + ")" +
                                                "does not match the value given (" + testAction.action.fieldValue +
                                                ") , Got [" + sText + sValue + sinnerHTML + "]";
                                        logger.error(stepResult.actualResult);
                                    }
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                break;

                            case "newtab" :
                                try {
                                    String mainWindowHandle = Browser.webDriver.getWindowHandle();
                                    Set<String> allWindowHandles = Browser.webDriver.getWindowHandles();
                                    Iterator<String> iterator = allWindowHandles.iterator();

                                    // Here we will check if child window has other child windows and will fetch the heading of the child window
                                    while (iterator.hasNext()) {
                                        String ChildWindow = iterator.next();
                                            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                                            Browser.webDriver.switchTo().window(ChildWindow);
                                            //WebElement text = WebDriver.findElement(By.id("sampleHeading"));
                                            //System.out.println("Heading of child window is " + text.getText());
                                        }
                                        else
                                        {
                                            Browser.webDriver.switchTo().window(mainWindowHandle);
                                        }
                                    }
                                }

                                catch(Exception e){
                                    e.printStackTrace();
                                }
                                break;

                            case "oldtab":
                                try {
                                    String mainWindowHandle = Browser.webDriver.getWindowHandle();
                                    Browser.webDriver.switchTo().window(mainWindowHandle);
                                    Browser.webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
                                    Browser.webDriver.switchTo().defaultContent();
                                }

                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                            break;

                            case "iframe" :
                             try {
                                 WebElement iFrameElement = Browser.webDriver
                                         .findElement(By.cssSelector(testAction.action.fieldName));
                                 //Browser.webDriver.switchTo().frame(0);
                                 Browser.webDriver.switchTo().frame(iFrameElement);
                                 //Browser.webDriver.switchTo().defaultContent();
                             }
                             catch (Exception e)
                             {
                                 e.printStackTrace();
                             }
                             break;

                            case "outofiframe" :
                                try{
                                    Browser.webDriver.switchTo().defaultContent();
                                }
                                catch (Exception e) {
                                    e.printStackTrace();
                                }

                            case "exportcurrentdatetime":
                                try {
                                    Date date = new Date();
                                    DateFormat df = new SimpleDateFormat("M/d/yyyy | h:mm");

                                    // Use Madrid's time zone to format the date in
                                    df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
                                    Exportdatetime =df.format(date);
                                    System.out.println("Date and time in Madrid: " + Exportdatetime);
//                                    sText=Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).getText().trim();
//                                    if(!sText.contains(currectDateTime)) {
//                                        stepResult.status = "Fail";
//                                        stepResult.actualResult = "Field (" + testAction.action.fieldName + ")" +
//                                                "does not match the value given (" + currectDateTime +
//                                                ") , Got [" + sText + "]";
//                                        logger.error(stepResult.actualResult);
//                                    }
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                break;

                            case "importcurrentdatetime":

                                try {
                                    Date date = new Date();
                                    DateFormat df = new SimpleDateFormat("M/d/yyyy | h:mm");

                                    // Use Madrid's time zone to format the date in
                                    df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
                                    Importdatetime =df.format(date);
                                    System.out.println("Date and time in Madrid: " + Importdatetime);
//                                    sText=Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).getText().trim();
//                                    if(!sText.contains(currectDateTime)) {
//                                        stepResult.status = "Fail";
//                                        stepResult.actualResult = "Field (" + testAction.action.fieldName + ")" +
//                                                "does not match the value given (" + currectDateTime +
//                                                ") , Got [" + sText + "]";
//                                        logger.error(stepResult.actualResult);
//                                    }
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                break;

                            case "match-exportdatetime":

                                // Validate Test in filed contains specific text
                                String stextValue = Browser.webDriver.findElement(
                                        By.cssSelector(testAction.action.fieldName)
                                ).getText();
                                System.out.println("Date and time in Madrid: " + Exportdatetime);
                                try {

                                    Assert.assertTrue(

                                            stextValue.contains(Exportdatetime),
                                            "Text in Field (" + testAction.action.fieldName + ") should contain [" +
                                                    Exportdatetime + "] and Got [" + stextValue + "]"

                                    );
                                } catch (AssertionError e) {
                                    throw new Exception("Text in Field (" + testAction.action.fieldName + ") should contain [" +
                                            Exportdatetime + "] but Got [" + stextValue + "]");
                                }
                                break;

                            case "match-importdatetime":
                                // Validate Test in filed contains specific text
                                String stextvalue = Browser.webDriver.findElement(
                                        By.cssSelector(testAction.action.fieldName)
                                ).getText();
                                System.out.println("Date and time in Madrid: " + Importdatetime);
                                try {
                                    Assert.assertTrue(

                                            stextvalue.contains(Importdatetime),
                                            "Text in Field (" + testAction.action.fieldName + ") should contain [" +
                                                    Importdatetime + "] and Got [" + stextvalue + "]"

                                    );
                                } catch (AssertionError e) {
                                    throw new Exception("Text in Field (" + testAction.action.fieldName + ") should contain [" +
                                            Importdatetime + "] but Got [" + stextvalue + "]");
                                }
                                break;

                            case "checkpdfcontent":
                                try{
//                                    Date date = new Date();
//                                    DateFormat df = new SimpleDateFormat("MMddyyyy");
//                                    // Use Madrid's time zone to format the date in
//                                    df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
//                                    String currectDate =df.format(date);


//                                    Values(JRSK, Inc. (DBA Away) - Summary of Changes - View All Changes -,True)

                                    String tabName = StringUtils.substringBetween(testAction.action.fieldName, "(", ",").trim();
                                    String action = StringUtils.substringBetween(testAction.action.fieldName, ",", ")").trim();

                                    //String pdfFileName=tabName+" "+currectDate+".pdf";
                                    String pdfFileName=tabName+".pdf";
                                    //System.out.println("Date and time in Madrid: " + df.format(date));

                                    URL TestURL = new URL("file:////" + System.getProperty("user.home") + "\\Downloads\\"+pdfFileName);
                                    InputStream in = TestURL.openStream();
                                    BufferedInputStream bf = new BufferedInputStream(in);
                                    PDDocument doc = PDDocument.load(bf);
                                    PDFTextStripper pdfStrip = new PDFTextStripper();
                                    String content = pdfStrip.getText(doc);
                                    System.out.println(content);
                                    if(action.equals("true") && !testAction.action.fieldValue.contains(content)){
                                        stepResult.status = "Fail";
                                        stepResult.actualResult = "Value (" + testAction.action.fieldValue + ")" +
                                                "does not match in pdf file";
                                        logger.error(stepResult.actualResult);

                                    }
                                    else if(action.equals("false") && testAction.action.fieldValue.contains(content)){
                                        stepResult.status = "Fail";
                                        stepResult.actualResult = "Value (" + testAction.action.fieldValue + ")" +
                                                "does match in pdf file";
                                        logger.error(stepResult.actualResult);

                                    }else{
                                        stepResult.status = "Fail";
                                        stepResult.actualResult = "Value (" + testAction.action.fieldValue + ")" +
                                                "please check your test case";
                                        logger.error(stepResult.actualResult);
                                    }

                                    doc.close();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }


                                break;

                                case "checkpdfcontentforclaims":
                                try{
//                                    Date date = new Date();
//                                    DateFormat df = new SimpleDateFormat("MMddyyyy");
//                                    // Use Madrid's time zone to format the date in
//                                    df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
//                                    String currectDate =df.format(date);


//                                    Values(JRSK, Inc. (DBA Away) - Summary of Changes - View All Changes -,True)

                                    String tabName = StringUtils.substringBetween(testAction.action.fieldName, "(", ",").trim();
                                    String action = StringUtils.substringBetween(testAction.action.fieldName, ",", ")").trim();

                                    //String pdfFileName=tabName+" "+currectDate+".pdf";
                                    String pdfFileName=tabName+".pdf";
                                    //System.out.println("Date and time in Madrid: " + df.format(date));

                                    URL TestURL = new URL("file:////" + System.getProperty("user.home") + "\\Downloads\\"+pdfFileName);
                                    InputStream in = TestURL.openStream();
                                    BufferedInputStream bf = new BufferedInputStream(in);
                                    PDDocument doc = PDDocument.load(bf);
                                    PDFTextStripper pdfStrip = new PDFTextStripper();
                                    String content = pdfStrip.getText(doc);
                                    System.out.println(content);
//                                    if(action.equals("true") && !content.contains(testAction.action.fieldValue)){
//                                        stepResult.status = "Fail";
//                                        stepResult.actualResult = "Value (" + testAction.action.fieldValue + ")" +
//                                                "does not match in pdf file";
//                                        logger.error(stepResult.actualResult);
//
//                                    }
                                    if(!content.contains(testAction.action.fieldValue)) {
                                        stepResult.status = "Fail";
                                        stepResult.actualResult = "Value (" + testAction.action.fieldValue + ")" +
                                                "does match in pdf file";
                                        logger.error(stepResult.actualResult);
                                    }

//                                    }else{
//                                        stepResult.status = "Fail";
//                                        stepResult.actualResult = "Value (" + testAction.action.fieldValue + ")" +
//                                                "please check your test case";
//                                        logger.error(stepResult.actualResult);
//                                    }

                                    doc.close();
                                }
                                    catch (Exception e){
                                    e.printStackTrace();
                                }


                                break;


//                            case "checkdownladedfileforclaims":
//                                String DownloadDir = System.getProperty("user.home") + "\\Downloads\\";
//                                File dir = new File(DownloadDir);
//                                File[] files = dir.listFiles();
//                                File lastModifiedFile = files[0];
//                                long length1 = 0;
//                                long length2 = 0;
//                                do {
//                                    files = dir.listFiles();
//                                    lastModifiedFile = files[0];
//                                    for (int l = 1; l < files.length; l++) {
//                                        if (lastModifiedFile.lastModified() < files[l].lastModified()) {
//                                            lastModifiedFile = files[l];
//                                        }
//                                    }
//                                    System.out.println("in While File Name:" + lastModifiedFile.getName());
//                                    if (lastModifiedFile.getName().endsWith("crdownload")) {
//                                        Thread.sleep(10000);
//                                    }
//                                    else
//                                        break;
//                                }
//                                while (true);
//                                dir = new File(DownloadDir);
//                                files = dir.listFiles();
//                                lastModifiedFile = files[0];
//                                for (int m = 1; m < files.length; m++) {
//                                    if (lastModifiedFile.lastModified() < files[m].lastModified()) {
//                                        lastModifiedFile = files[m];
//                                    }
//                                }
//                                try {
//                                    Thread.sleep(5000);
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                                files = dir.listFiles();
//                                lastModifiedFile = files[0];
//                                for (int n = 1; n < files.length; n++) {
//                                    if (lastModifiedFile.lastModified() < files[n].lastModified()) {
//                                        lastModifiedFile = files[n];
//                                    }
//                                }
//                                String filename = lastModifiedFile.getName();
//                                String filenameDate="";
//                                String fileExtension="";
//                                if(filename.lastIndexOf(".") != -1 && filename.lastIndexOf(".") != 0)
//                                    fileExtension = filename.substring(filename.lastIndexOf(".")+1);
//                                if(testAction.action.fieldName.equals("pdf")){
//                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy");
//                                    LocalDateTime now = LocalDateTime.now();
//                                    String currentDate = dtf.format(now);
////                                        String version = StringUtils.substringBetween(filename, "ERRORLOG_VIL.","_").trim();
//                                    filenameDate = testAction.action.fieldValue + " " + currentDate + ".pdf";
//                                    testAction.action.fieldValue=filenameDate;
//                                }
//                                if(testAction.action.fieldName.equals("zip")){
//                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy");
//                                    LocalDateTime now = LocalDateTime.now();
//                                    String currentDate = dtf.format(now);
////                                        String version = StringUtils.substringBetween(filename, "ERRORLOG_VIL.","_").trim();
//                                    filenameDate = testAction.action.fieldValue + currentDate + ".zip";
//                                    testAction.action.fieldValue=filenameDate;
//                                }
//                                if(testAction.action.fieldName.equals("Date")){
//                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy");
//                                    LocalDateTime now = LocalDateTime.now();
//                                    String currentDate = dtf.format(now);
//                                    String version = StringUtils.substringBetween(filename, "ERRORLOG_VIL.","_").trim();
//                                    filenameDate = testAction.action.fieldValue.concat(version).concat("_").concat(currentDate).concat(".txt");
//                                    testAction.action.fieldValue=filenameDate;
//                                }
//
//                                if (!(filename.equalsIgnoreCase(testAction.action.fieldValue))) {
//                                    stepResult.status = "Fail";
//                                    stepResult.actualResult = "File Name" +
//                                            " does not match the value given (" + testAction.action.fieldValue +
//                                            ") , Got [" + filename + "]";
//                                    logger.error(stepResult.actualResult);
//                                }
//                                break;
//



                            default:
                                // Unknown action type
                                throw new Exception("Unknown Action Type (" +
                                        testAction.action.actionType + ") provided.");
                        }
                    }
                    // Make the Step Result as Pass only if it was not modified by any executions above
                    if (stepResult.status.equals("Broken")) {
                        stepResult.status = "Pass";
                    }
                    if (!stepResult.actualResult.equalsIgnoreCase("")) {
                        allPassed = false;
                        //stepResult.actualResult = testStep.expectedResult;

                        // Take the Screen Shot from the Browser Instance
                        File screenShot = Browser.takeScreenShot(
                                testStep.testCaseStepId + "_" +
                                        fileFormat.format(stepResult.executionStartTime),
                                config.app.getProperty("selenium.webdriver.screenshots")
                        );
                        // Upload the Screen Shot to Azure BLOB Storage and set the URL
                        stepResult.screenshotURL = qifClient.uploadScreenShot(
                                config.qif.getProperty("qif.azure.connection"),
                                config.qif.getProperty("qif.azure.container"),
                                screenShot
                        );
                        // Set the Test Step Result Properties
                        stepResult.status = "Fail";
                        stepResult.error = stepResult.actualResult;
                        ;
                        //stepResult.actualResult = testStep.expectedResult;;
                        allPassed = false;
                        lastError = stepResult.error;
                        lastErrorScreen = stepResult.screenshotURL;
                    } else {
                        stepResult.actualResult = testStep.expectedResult;
                    }
                } catch (Exception error) {
                    logger.error(error);
                    // Take the Screen Shot from the Browser Instance
                    File screenShot = Browser.takeScreenShot(
                            testStep.testCaseStepId + "_" +
                                    fileFormat.format(stepResult.executionStartTime),
                            config.app.getProperty("selenium.webdriver.screenshots")
                    );
                    // Upload the Screen Shot to Azure BLOB Storage and set the URL
                    stepResult.screenshotURL = qifClient.uploadScreenShot(
                            config.qif.getProperty("qif.azure.connection"),
                            config.qif.getProperty("qif.azure.container"),
                            screenShot
                    );
                    // Set the Test Step Result Properties
                    stepResult.status = "Fail";
                    stepResult.error = error.getMessage();
                    stepResult.actualResult = error.toString();
                    allPassed = false;
                    lastError = stepResult.error;
                    lastErrorScreen = stepResult.screenshotURL;
                }
                // Add the Test Step Result to Test Steps
                stepResult.executionEndTime = new Date();
                gui.testResult.testStepResults.add(stepResult);
                logger.info("RESULT: " + stepResult.status + " (" + stepResult.actualResult + ")");
            }

            // Determine the Test Results
            if (allPassed) {
                gui.testResult.status = "Pass";
                gui.testResult.actualResult = testCase.expectedResult;
            } else {
                gui.testResult.status = "Fail";
                gui.testResult.actualResult = lastError;
                gui.testResult.error = lastError;
                gui.testResult.errorScreen = lastErrorScreen;
            }
            // Send the Test Results to QIF
            logger.info("Sending the Test Results to QIF...");
            gui.testResult.executionEndTime = new Date();
            qifClient.postGUITestResults(gui);

            // Post results for Performance test case
            if (!gui_Perf_TC.description.isEmpty()) {
                TestStepResult prefStepResult = new TestStepResult();
                prefStepResult.actualResult = sPerfActualResult.isEmpty() ?
                        "Test Step Not executed due to issue while executing:" + testCase.description : sPerfActualResult;
                gui_Perf_Result.testResult.actualResult = prefStepResult.actualResult;
                prefStepResult.error = PerfromanceTest_pass ? "" : gui_Perf_Result.testResult.actualResult;
                prefStepResult.executionStartTime = gui.testResult.executionStartTime;
                gui_Perf_Result.testResult.executionStartTime = prefStepResult.executionStartTime;
                prefStepResult.executionEndTime = gui.testResult.executionEndTime;
                gui_Perf_Result.testResult.executionEndTime = prefStepResult.executionEndTime;
                prefStepResult.status = PerfromanceTest_pass ? "Pass" : "Fail";
                gui_Perf_Result.testResult.status = prefStepResult.status;
                prefStepResult.testCaseStepId = gui_Perf_TC.testCaseSteps.get(0).testCaseStepId;
                gui_Perf_Result.testResult.projectId = gui_Perf_TC.projectId;
                gui_Perf_Result.testResult.moduleId = gui_Perf_TC.moduleId;
                gui_Perf_Result.testResult.subModuleId = gui_Perf_TC.subModuleId;
                gui_Perf_Result.testResult.testStepResults.add(prefStepResult);
                logger_performance.info("Step: " + gui_Perf_TC.testCaseSteps.get(0).stepDescription + "\n\t\t\t\t\t\t  "
                        + "Result: " + gui_Perf_Result.testResult.actualResult);
                qifClient.postGUITestResults(gui_Perf_Result);
            }
            // Post results for UI Validation test case
            if (!gui_UIVal_TC.description.isEmpty()) {
                TestStepResult UIValStepResult = new TestStepResult();
                UIValStepResult.actualResult = sUIActualResult.isEmpty() ?
                        "Test Step Not executed due to issue while executing:" + testCase.description : sUIActualResult;
                gui_UIVal_Result.testResult.actualResult = UIValStepResult.actualResult;
                UIValStepResult.error = UIValidationTest_pass ? "" : gui_UIVal_Result.testResult.actualResult;
                UIValStepResult.executionStartTime = gui.testResult.executionStartTime;
                gui_UIVal_Result.testResult.executionStartTime = UIValStepResult.executionStartTime;
                UIValStepResult.executionEndTime = gui.testResult.executionEndTime;
                gui_UIVal_Result.testResult.executionEndTime = UIValStepResult.executionEndTime;
                UIValStepResult.status = UIValidationTest_pass ? "Pass" : "Fail";
                gui_UIVal_Result.testResult.status = UIValStepResult.status;
                UIValStepResult.testCaseStepId = gui_UIVal_TC.testCaseSteps.get(0).testCaseStepId;
                UIValStepResult.screenshotURL = UIValidationZipPath;
                gui_UIVal_Result.testResult.projectId = gui_UIVal_TC.projectId;
                gui_UIVal_Result.testResult.moduleId = gui_UIVal_TC.moduleId;
                gui_UIVal_Result.testResult.subModuleId = gui_UIVal_TC.subModuleId;

                gui_UIVal_Result.testResult.testStepResults.add(UIValStepResult);
                gui_UIVal_Result.testResult.errorScreen = UIValStepResult.screenshotURL;
                qifClient.postGUITestResults(gui_UIVal_Result);
            }
            // Assert the Test Status
            Assert.assertEquals(gui.testResult.status, "Pass", "Got Error: " + gui.testResult.error);

        } catch (Exception error) {
            logger.error(error);
            Assert.assertEquals(error.getMessage().length(), 0);
        }
    }
    //}));
    //}
    //return guiTests;


    @AfterSuite
    static void tearDown() {
        logger.info("Finishing all the Tests...");
        logger.info(new String(new char[80]).replace("\0", "="));
        Browser.shutDown();
    }


}
