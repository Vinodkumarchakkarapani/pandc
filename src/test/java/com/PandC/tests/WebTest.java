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
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import com.PandC.tests.srNOSort;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.DynamicTest.dynamicTest;

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
	private static List<TestCaseGUI> guiTestCases = new ArrayList<>();
	private static List<TestCaseGUI> guiTestCases_performance_Tests = new ArrayList<>();
	private static List<TestCaseGUI> guiTestCases_UIValidation_Tests = new ArrayList<>();


	@BeforeSuite
	static void setUp() {
		// Specify the list of selected tests to execute and this is applicable only if app.gui.executeselectedTCs is set to true
		List<String> listOfTCstoExecute = Arrays.asList(

              "1. PS001 - To verify user navigates to Insurance Renewal List dashboard on clicking Request For Renewal Tile in home page"

                // Phase- 1 Start
                //General Information Page
//                "1. PS001 - To verify user navigates to Insurance Renewal List dashboard on clicking Request For Renewal Tile in home page",
//                "2. PS002 - To verify user is able to navigate back to Home page while clicking the Forms link in the breadcrumb",
//                "3. PS003 - Verify user is able to search the Renewal records for a particular Account Handler by selecting name of the handler in search",
//                "4. PS004 - Verify user is able to navigate to next page in the grid by clicking on page number in pagination",
//                "5. PS007 - Verify user is able to search a record by Name Insured",
//                "6. PS008 - Verify user is able to search a record by \"Policy From\"",
//                "7. PS009 - Verify user is able to search a record by \"Policy To\"",
//                "8. PS005 - Verify Delete option is displayed only for the records in “Draft” status in the grid",
//                "9. PS013 - Verify user is able to search a record by Status",
//                "10. PS006 - Verify user is displayed No records Found when no records are present for the searched criteria",
//                "11. PS010 - Verify user is able to search a record by Primary Contact",
//                "12. PS014 - Verify user is displayed General Information page along with - \"Cover Page” as default",
//                "13. PS024 - Verify user is navigated to Insurance Renewal List page on clicking cancel Button on Cover page",
//                "14. PS023 - Verify user is displayed the message - \"Please enter the fields marked as mandatory to continue further.” When user clicks on Continue button without entering the mandatory fields in Cover Page",
//                "15. PS192 - RFR->Cover Page Renewal Type Required field - validate error (Red border -Indicating error no field) is displayed in case of invalid date",
//                "16. In Cover Page, for Renewal Type - Verify Life Science checkbox is not displayed",
//                "17. PS189 - Validate error message is displayed for From Date on Cover Page",
//                "18. PS191 - Validate the Alert Pop Up is displayed properly for Blank Date in Cover Page",
//                "19. PS193 - RFR-> Cover page In case of Renewal Type not selected, user is not able to navigate to Named Insureds",
//                "20. PS015 - Verify user is able enter details in Cover Page and navigate to Insured Names tab",
//                "21. PS188 - Validate error message should display for invalid Date on Cover page",
//                "22. PS031 - Verify user is able to add details in Named Insured grid by clicking on Add Row",
//                "23. PS035 - Verify the status of the created record is Draft in Insurance Renewal List page on clicking Save and Close button in Insured Name Tab",
//                "24. PS032 - Verify user is able to add another row of details in Name Insured grid by clicking on add Row",
//                "25. PS034 - Verify user is directed back to Insurance Renewal List page on clicking Save and Close Button on Named Insured Tab",
//                "26. PS030 - Verify the proposed date displayed in Insured Name tab is same as the proposed date in the Cover page tab",
//				"27. Verify validation error messages on the Name Insured Tab",
//                "28. Verify new application changes on the Name Insured Tab",
//                "29. In General Information tab - Verify Premium & Loss History tab is marked as Not Applicable by default",
//                "30. PS036 - Verify User is able to enter details in Premium & Loss History Tab",
//                "31. PS037 - To verify user navigates to Property Exposure Tab and Property (Statement of Values) tab is displayed as default",

				// Property (SOV) Tab
//				"32. In Property (SOV), Verify \"Add Column\" button is removed from the Property Sov tab",
//                "33. In Property Sov, Verify user is able to see “Show/Hide Columns(s)” button at the top of the table in Property Sov tab",
//                "34. In Property (Sov) Verify user clicks on the Show/Hide Column(s) button, the system displays an overlay screen with the list of possible column are broadly grouped into 7 different groups based on business logic. The group names are a. Building Value b. Business Income c. Building Details d. Building Contents e. Additional Details f. Fire Protection g. Security",
//                "35. In Property (SOV) Verify user is displayed list of columns required under “Building Value”, the following columns are a. Murals b. Sheds c. Fencing Gates d. Building Replacement Value e. Tenant Improvements Replacement Values f. Other Building Value",
//                "36. In Property (SOV) for Building Value, Verify user is able to enable or disable the columns by clicking on the checkbox,the following columns are a. Murals b. Sheds c. Fencing Gates d. Other Building Value",
//                "37. In Property sov for “Building Value, Verify user is able to insert column in respective position on selecting the column name and clicking “apply” button for the following columns a. Murals b. Sheds c. Fencing Gates d. Other Building Value",
//                "38. In Property sov for Building Value,Verify validation error messages for the following columns are a. Murals b. Sheds c. Fencing Gates d. Other Building Value",
//                "39. In Property sov for “Building Value, Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted columns,the following columns are a. Murals b. Sheds c. Fencing Gates d. Other Building Value",
//                "40. In Property sov for “Building Value, Verify \"Building Replacement Value\" & Tenant \"Improvements Replacement Values\" column is pre-selected and disabled so that the column automatically appears on the table.",
//                "41. In Property Sov, Verify user is displayed list of columns required under \"Business Income\",the following columns are 1. Aggregate BI 2. Detailed BI a. R&D BI b. G&A BI c. Sales BI d. Other BI e. Manufacturing BI",
//                "42. In Property sov for Business Income, Verify by default, the “Aggregate BI” option box is selected and user is able to change it.",
//                "43. In Property sov for Business Income, Verify on Selecting the “Aggregate BI” option box is automatically select the only column name “Total BI Values” under this section and the user is not be allowed to deselect the checkbox.",
//                "44. In Property sov for Business Income, Verify user is able to insert column “Total BI Value” in respective position on selecting the “Aggregate BI” and clicking “apply” button",
//                "45. In Property sov for “Business Income”, Verify validation error messages for \"Total BI Value” column inserted on table",
//                "46. In Property sov for “Business Income, Verify user is able to enter correct given value (Numbers (0-9), $, Comma(,), Decimal(.)) in inserted currency formatted \"Total BI Value” column on table",
//                "47. In Property (SOV) for \"Business Income\", Verify the user selecting the \"Detailed BI\" option box is enable below columns for user selections: a. R&D BI b. G&A BI c. Sales BI d. Other BI e. Manufacturing BI",
//                "48. In Property (SOV) for \"Business Income\", Verify user is able to enable or disable the columns under \"Detailed BI\" by clicking on the checkbox, the following columns are a. R&DBI b. G&A BI c. Sales BI d. Other BI e. Manufacturing BI",
//                "49. In Property (SOV) for \"Business Income\", Verify user is able to insert column in respective position on selecting the column name under \"Detailed BI\" section and clicking \"apply\" button, the following columns are a. R&DBI b. G&A BI c. Sales BI d. Other BI e. Manufacturing BI",
//                "50. In Property sov for \"Business Income\", Verify validation error messages for column inserted on table, the following columns are a. R&D BI b. G&A BI c. Sales BI d. Other BI e. Manufacturing BI",
//                "51. In Property (SOV) for \"Business Income\",Verify user is able to enter correct given value (Numbers (0-9), $, Comma(,), Decimal(.)) in inserted currency formatted Columns. the following columns are a. R&D BI b. G&A BI c. Sales BI d. Other BI e. Manufacturing BI",
//                "52. In Property (SOV) for \"Business Income\", Verify user display an inline message \"Select at least one Business Income under Detailed BI\" on the top of the overlay on clicking the \"apply\" button without selecting any of the column under \"Detailed BI\" option",
//                "53. In Property (SOV) for \"Business Income\", Verify automatically add \"Total BI Value\" column along with selected column names on enabling at least one column from \"Detailed BI\"",
//                "54. In Property (SOV) for \"Business Income\", Verify added \"Total BI Value\" column is non-editable, auto computed, currency formatted, two decimal place round off",
//                "55. In Property sov for \"Business Income\", Verify Formula \"Total BI Value\" is Sum of all selected \"Detailed BI\" columns",
//                "56. In Property (SOV), Verify user is displayed list of columns required under \"Building Details\", the following columns are a. Building Use (i.e. office, warehouse, etc.) b. Total Area Sq. Ft c. Occupied Floor area Sq.Ft. d. % Occupied e. Owned/Leased f. Construction Type g. Year Built h. # of Stories",
//                "57. In Property (SOV) for \"Building Details\", Verify by default columns is pre-selected and disabled so that the column automatically appears on the table, the following columns are a. Building Use (i.e. office, warehouse, etc.) b. Total Area Sq. Ft c. % Occupied d. Owned/Leased e. Construction Type f. Year Built g. # of Stories",
//                "57.1. Property SOV - For the Drop down Building Use, Verify the following new values are displayed in the drop down list.: 1. Clean Rooms 2. Laboratories 3. Supply Chain / Contract Manufacturer 4. Vivarium",
//                "57.2. In Property (SOV) tab- verify user is able to view the newly added Columns in the Show / hide Overlay. 1. Building Use Detail - next to Building Use column",
//                "58. In Property (SOV) for \"Building Details\", Verify user is able to enable or disable the \"Occupied Floor area Sq.Ft.\" column by clicking on the checkbox",
//                "59. In Property (SOV) for \"Building Details\", Verify user is able to insert \"Occupied Floor area Sq.Ft\" column in respective position on selecting the column name and clicking \"apply\" button",
//                "60. In Property (SOV) for \"Building Details\", Verify validation error messages of \"Occupied Floor area Sq.Ft.\" column",
//                "61. In Property sov for “Building Details”, Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted \"Occupied Floor area Sq.Ft \" column",
//                "62. In Property sov , Verify user is able to see under “Building Contents”, the columns are further sub-categorized as Detailed Building Contents & Aggregate Building Contents",
//                "63. In Property sov for “Building Contents”, Verify user able to see the columns are grouped further as \"Contents Replacement Cost'' & ''Selling Price '' under Detailed Building Contents",
//                "64. In Property sov for “Building Contents”, Verify User is displayed list of columns required under “Replacement Cost”, columns are Cased Goods,Computer Hardware, Servers, Finished Stock Ready for Sale,Furniture & Fixtures,Irreplaceable Bulk Beverage, Irrigation Pipeline,Machinery/ Equipment /Molds,Mfg. or Lab Equipment,Perishable Property,Raw Materials & WIP (Not Spoilage/ Temperature Sensitive), Raw Materials & WIP,Replaceable Bulk Beverage,R&D Inventory,Spoilage",
//                "65. In Property sov for “Building Contents”, Verify user is able to enable or disable the columns under “Replacement Cost” by clicking on the checkbox,the following columns are (Cased Goods,Computer Hardware, Servers, Finished Stock Ready for Sale,Furniture & Fixtures,Irreplaceable Bulk Beverage, Irrigation Pipeline,Machinery/ Equipment /Molds,Mfg. or Lab Equipment,Perishable Property,Raw Materials & WIP (Not Spoilage/ Temperature Sensitive), Raw Materials & WIP,Replaceable Bulk Beverage,)",
//                "66. In Property sov for “Building Contents”, Verify user is able to insert column in respective position on selecting the column name under “Building Contents” and clicking “apply” button",
//                "67. In Property sov for “Building Contents”, Verify validation error messages for the columns under “Replacement Cost”",
//                "68. In Property sov for “Building Contents”, Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted columns under “Replacement Cost”",
//                "69. In Property sov for \"Building Contents\", Verify user is displayed list of columns required under \"Selling Price\",the following columns are 1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//                "70. In Property sov for “Building Contents”, Verify user is able to enable or disable the columns under “Selling Price” by clicking on the checkbox,the following columns are-1.Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//                "71. In Property sov for “Building Contents”, Verify user is able to insert column in respective position on selecting the column name under “Selling Price” and clicking apply” button, the following columns are-1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//                "72. In Property sov for \"Building Contents\", Verify validation error messages for the columns under \"Selling Price\", the following columns are 1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6.Temperature Sensitive Property 7. Other",
//                "73. In Property sov for \"Building Contents\", Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted columns under \"Selling Price\",the following columns are 1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//                "74. In Property sov for \"Building Contents\", Verify user is displayed list of columns required under \"Aggregate Building Contents\",the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//                "75. In Property sov for \"Building Contents\", Verify user is able to enable or disable the columns under \"Aggregate Building Contents\" by clicking on the checkbox,the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//                "76. In Property sov for \"Building Contents\", Verify user is able to insert column in respective position on selecting the column name under \"Aggregate Building Contents\" and clicking \"apply\" button, the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//                "77. In Property sov for \"Building Contents\", Verify validation error messages for the columns under \"Aggregate Building Contents\", the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//                "78. In Property sov for \"Building Contents\", Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted columns under \"Aggregate Building Contents\",the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//                "79. In Property sov , Verify user is displayed list of columns required under \"Additional Details\",the following columns are a.Clean Room (Class Code) b.Clean Room (Sq. Ft.) c.Payroll d.# of Students e.# of Employees f.# of Facult Members g.Other Occupants or Tenants h.Additional Information",
//                "80. In Property sov for “Additional Details, Verify user is able to enable or disable the columns by clicking on the checkbox, the following columns are a.Clean Room (Class Code) b.Clean Room (Sq. Ft.) c.Payroll d.# of Students e.# of Employees f.# of Facult Members g.Other Occupants or Tenants h.Additional Information",
//                "81. In Property sov for “Additional Details”, Verify user is able to insert column in respective position on selecting the column name and clicking “apply” button, the following columns are a.Clean Room (Class Code) b.Clean Room (Sq. Ft.) c.Payroll d.# of Students e.# of Employees f.# of Faculty Members g.Other Occupants or Tenants h.Additional Information",
//                "82. In Property sov for “Additional Details”, Verify validation error messages for the columns, the following columns are a.Clean Room (Class Code) b.Clean Room (Sq. Ft.) c.Payroll d.# of Students e.# of Employees f.# of Facult Members g.Other Occupants or Tenants h.Additional Information",
//                "83. In Property sov for “Additional Details”, Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted columns, the following columns are a.Clean Room (Class Code) b.Clean Room (Sq. Ft.) c.Payroll d.# of Students e.# of Employees f.# of Facult Members g.Other Occupants or Tenants h.Additional Information",
//                "84. In Property sov, Verify user is displayed list of columns required under “Fire Protection”, the following columns are a.Sprinkler System b.Smoke Detectors c.Fire Alarm d.Fire Extinguishers e.Thermal Barriers f.Hydrant g.Fire Department",
//                "85. In Property sov for “Fire Protection”, Verify by default, the user is not allowed to deselect the checkbox for Sprinkler System, Smoke Detectors & Fire Alarm.",
//                "86. In Property sov for “Fire Protection”, Verify user is able to enable or disable the columns by clicking on the checkbox, the following columns are 1. Fire Extinguishers 2. Thermal Barriers 3. Hydrant 4. Fire Department",
//                "87. In Property (SOV), Verify user is displayed list of columns required under \"Security\", the following columns are a.Alarm b.Guards c.Gated Campus d.CC TV e.Key Card Access",
//                "88. In Property (SOV) for \"Security\", Verify by default, the user is not allowed to deselect the checkbox of \"Alarm\" & \"Guards\"",
//                "89. In Property (SOV) for \"Security\", Verify user is able to enable or disable the columns by clicking on the checkbox, the following columns are a.Gated Campus b.CC TV c.Key Card Access",
//                "90. In property (SOV), Verify user is able to close the customize column overlay without saving any changes by clicking on \"cancel\" button",
//                "91. In Property (SOV), Verify user is able to reset the column selection to default by clicking on \"Revert\" button",
//                "92. In Property sov for “Building Contents”, Verify “Perishable Property”, “Raw Materials & WIP (Not Spoilage/ Temperature Sensitive)”, “Finished Stock Ready for Sale” columns should be selected by default ,if If P&C Practice is “Life Science”",
//                "93. In Property sov for Fire Protection, If P&C Practice is Life Science - Verify existing default fields is marked selected and disabled, the following fields are-Fire Extinguishers, Thermal Barriers, Hydrant, Fire Department",
//                "94. In Property (SOV) for \"Security\", If P&C Practice is \"Life Science\" - Verify existing default fields is marked selected and disabled, the following fields are \"Gated Campus\", \"CC TV\", \"Key Card Access\"",
//                "95. In Property (SOV), Verify user is able to enable selected columns in the Property(SOV) table by clicking on \"apply\" button and on clicking continue button it should navigate to Property SOV 3rd Party",

                // Property (SOV) 3rd party
//                "96. Verify add a new tab called Property (SOV) – 3rd Party next to Property (SOV) tab.",
//                "97. In Property (SOV) – 3rd Party, To verify user is able to mark tab as Not Applicable",
//                "98. In Property SOV - 3rd Party, Verify user is able to add row in Property SOV - 3rd Party by clicking on add Row",
//                "99. In Property SOV - 3rd Party, Verify user is able to Delete the added row in Property SOV - 3rd Party Tab by clicking Delete button",
//                "100. In Property (SOV) – 3rd Party, Verify user is display a grid with the following standard fields (columns). 1.Premises Number 2.Building Number 3.Location Name 4.Street Address 5.City 6.State or Province 7.Country 8.ZIP / Postal Code 9.Machinery/Equipment/Molds (Replacement Cost) 10.Raw materials & WIP (Replacement Cost) 11.R&D Inventory (Replacement Cost)",
//                "101. In Property (SOV) – 3rd Party, Verify user is able to see \"Show/Hide Columns(s)\" button at the top of the table in Property (SOV) – 3rd Party",
//                "102. Property SOV - 3rd Party, Verify user clicks on the Show/Hide Column(s) button, the system displays an overlay screen with list of possible columns under the group names are. Building Details, Building Contents, Additional Details(Other Occupants or Tenants, Additional Information), Fire Protection, Security",
//                "103. Property SOV - 3rd Party, Verify user is displayed list of columns required under \"Building Details\", the following columns are a. Building Use (i.e. office, warehouse, etc.) b. Total Area Sq. Ft c. Occupied Floor area Sq.Ft. d. % Occupied e. Owned/Leased f. Construction Type g. Year Built h. # of Stories",
//                "104. Property SOV - 3rd Party for \"Building Details\",Verify user is displayed list of columns required under \"Building Details\", the following columns are a. Building Use (i.e. office, warehouse, etc.) b. Total Area Sq. Ft c. Occupied Floor area Sq.Ft. d. % Occupied e. Owned/Leased f. Construction Type g. Year Built h. # of Stories",
//                "105. Property SOV - 3rd Party for \"Building Details\", Verify by default columns is pre-selected and disabled so that the column automatically appears on the table, the following columns are a. Building Use (i.e. office, warehouse, etc.) b. Total Area Sq. Ft c. % Occupied d. Owned/Leased e. Construction Type f. Year Built g. # of Stories",
//                "106. Property SOV - 3rd Party for \"Building Details\",Verify user is able to enable or disable the \"Occupied Floor area Sq.Ft.\" column by clicking on the checkbox",
//                "107. Property SOV - 3rd Party for \"Building Details\",Verify user is able to insert \"Occupied Floor area Sq.Ft\" column in respective position on selecting the column name and clicking \"apply\" button",
//                "108. Property SOV - 3rd Party for \"Building Details\", Verify validation error messages of \"Occupied Floor area Sq.Ft.\" column",
//                "109. Property SOV - 3rd Party for \"Building Details\", Verify user is able to enter correct value in \"Occupied Floor area Sq.Ft\" column",
//                "110. Property SOV - 3rd Party, Verify user is able to see under \"Building Contents\", the columns are further sub-categorized as Detailed Building Contents & Aggregate Building Contents",
//                "111. Property SOV - 3rd Party for \"Building Contents\", Verify user able to see the columns are grouped further as \"Contents Replacement Cost\" & \"Selling Price\" under Detailed Building Contents",
//                "112. Property SOV - 3rd Party for \"Building Contents\",Verify User is displayed list of columns required under \"Replacement Cost\", columns are Cased Goods, Computer Hardware, Servers, Finished Stock Ready for Sale, Furniture & Fixtures, Irreplaceable Bulk Beverage, Irrigation Pipeline, Machinery/ Equipment /Molds,Mfg. or Lab Equipment, Perishable Property,Raw Materials & WIP (Not Spoilage/Temperature Sensitive), Raw Materials & WIP,Replaceable Bulk Beverage,R&D Inventory,Spoilage",
//                "113. In Property SOV 3rd Party tab- verify user is able to view the newly added Columns in the Show / hide Overlay. 1. Samples/Demos/Free Units under Building Contents 2. Building Use Detail - next to Building Use column",
//                "114. In Property SOV - 3rd Party for \"Building Contents\", Verify user is able to enable or disable the columns under \"Replacement Cost\" by clicking on the checkbox,the following columns are (Cased Goods Values,Computer Hardware, Servers,Finished Stock Ready for Sale,Furniture & Fixtures,Irreplaceable Bulk Beverage,Irrigation Pipeline,Machinery/Equipment /Molds,Mfg. or Lab Equipment,Perishable Property,Raw Materials & WIP (Not Spoilage/ Temperature Sensitive), Raw Materials & WIP,Replaceable Bulk",
//                "115. In Property SOV - 3rd Party for \"Building Contents\", Verify user is able to insert column in respective position on selecting the column name under \"Building Contents\" and clicking \"apply\" button",
//                "116. In Property SOV - 3rd Party for \"Building Contents\", Verify validation error messages for the columns under \"Replacement Cost\"",
//                "117. In Property SOV - 3rd Party for \"Building Contents\", Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted columns under \"Replacement Cost\"",
//                "118. In Property SOV - 3rd Party for \"Building Contents\", Verify user is displayed list of columns required under \"Selling Price\",the following columns are 1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//                "119. In Property SOV - 3rd Party for \"Building Contents\", Verify user is able to enable or disable the columns under \"Selling Price\" by clicking on the checkbox,the following columns are 1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//                "120. In Property SOV - 3rd Party for \"Building Contents\", Verify user is able to insert column in respective position on selecting the column name under \"Selling Price\" and clicking \"apply\" button, the following columns are 1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//                "121. In Property SOV - 3rd Party for “Building Contents”, Verify validation error messages for the columns under “Selling Price”, the following columns are 1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//                "122. In Property SOV - 3rd Party for “Building Contents”, Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted columns under “Selling Price”,the following columns are 1. Cased Goods 2. Finished Stock Ready for Sale 3. Perishable Property 4. Replaceable Bulk Beverage 5. Spoilage 6. Temperature Sensitive Property 7. Other",
//                "123. In Property SOV - 3rd Party for \"Building Contents\", Verify user is displayed list of columns required under \"Aggregate Building Contents\",the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//                "124. In Property SOV - 3rd Party for \"Building Contents\", Verify user is able to enable or disable the columns under \"Aggregate Building Contents\" by clicking on the checkbox,the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//                "125. In Property SOV - 3rd Party for \"Building Contents\",Verify user is able to insert column in respective position on selecting the column name under \"Aggregate Building Contents\" and clicking \"apply\" button, the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//                "126. In Property SOV - 3rd Party for “Building Contents”,Verify validation error messages for the columns under “Aggregate Building Contents”, the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//                "127. In Property SOV - 3rd Party for “Building Contents”,Verify user is able to enter correct value (Numbers (0-9), $, Comma(,), Decimal(.)) in Inserted currency formatted columns under “Aggregate Building Contents”,the following columns are 1. Average Inventory Replacement Cost Value 2. Average Inventory Selling Price 3. Peak Inventory Replacement Cost Value 4. Peak Inventory Selling Price",
//                "129. In Property SOV - 3rd Party, Verify user is able to enable or disable the columns by clicking on the checkbox, the following columns are a.Other Occupants or Tenants b.Additional Information",
//                "130. In Property SOV - 3rd Party,Verify user is able to insert column in respective position on selecting the column name and clicking “apply” button, the following columns Other Occupants or Tenants & Additional Information",
//                "131. In Property SOV - 3rd Party,Verify user is able to enter correct value in Inserted test format columns, the following columns are Other Occupants or Tenants & Additional Information",
//                "132. In Property SOV - 3rd Party,Verify user is displayed list of columns required under “Fire Protection”, the following columns are a.Sprinkler System b.Smoke Detectors c.Fire Alarm d.Fire Extinguishers e.Thermal Barriers f.Hydrant g.Fire Department",
//                "133. In Property SOV - 3rd Party for “Fire Protection”, Verify by default, the user is not allowed to deselect the checkbox for Sprinkler System, Smoke Detectors & Fire Alarm.",
//                "134. In Property SOV - 3rd Party for “Fire Protection”, Verify user is able to enable or disable the columns by clicking on the checkbox, the following columns are 1. Fire Extinguishers 2. Thermal Barriers 3. Hydrant 4. Fire Department",
//                "135. In Property SOV - 3rd Party, Verify user is displayed list of columns required under \"Security\", the following columns are a.Alarm b.Guards c.Gated Campus d.CC TV e.Key Card Access",
//                "136. In Property SOV - 3rd Party for \"Security\", Verify by default, the user is not allowed to deselect the checkbox of \"Alarm\" & \"Guards\"",
//                "137. In Property SOV - 3rd Party for \"Security\",Verify user is able to enable or disable the columns by clicking on the checkbox, the following columns are a.Gated Campus b.CC TV c.Key Card Access",
//                "138. In Property SOV - 3rd Party, Verify user is able to close the customize column overlay without saving any changes by clicking on \"cancel\" button",
//                "139. In Property SOV - 3rd Party, Verify user is able to reset the column selection to default by clicking on \"Revert\" button",
//                "140. In Property SOV - 3rd Party,Verify user is able to enable selected columns in the Property(SOV) table by clicking on “apply” button",
//                "141. In Property SOV 3rd Party - For the Dropdown Building Use, Verify the following new values are displayed in the drop down list:1. Clean Rooms 2. Laboratories 3. Supply Chain / Contract Manufacturer 4. Vivarium",
//                "142. In Property SOV - 3rd Party,To verify user is able to enter the details For Coverage Notes and navigate to BI worksheet tab",

                 //BI-Worksheet
//                "143. In BI Worksheet tab - Verify 2 Check boxes are displayed below the Not Applicable checkbox : a. Standard BI Worksheet b. Continuing Expenses only Worksheet",
//                "144. In BI Worksheet - Verify user is displayed Standard BI Worksheet as pre-selected value if P&C Practice is selected as Commercial in the drop down in the Cover page",
//                "145. In BI Worksheet - Verify user is displayed Continuing Expenses only worksheet as pre-selected value if P&C Practice is selected as Life Science in the drop down in the Cover page",
//                "146. In BI Worksheet - Verify user is displayed Standard BI Worksheet as pre-selected value if P&C Practice is selected as Technology in the drop down in the Cover page",
//                "148. Verify user is displayed the field with Label - \"Annual Net Profit/(Net Loss) Before Tax (from operations other than R&D operations) Enter -ve value in case of net loss\" under Continuing Expenses only Worksheet",
//                "149. Verify user is displayed error validation message on entering invalid value for the currency field - \"Annual Net Profit/(Net Loss) Before Tax\" to \"Annual Net Profit/(Net Loss) Before Tax (from operations other than R&D operations) Enter -ve value in case of net loss\" - Error message 1. Max allowed value $9,999,999,999,999.99 2. Only currency Values allowed (0-9, $, ., ,)",
//                "150. Verify user is able to enter -ve currency value in case of net loss for field - \"Annual Net Profit/(Net Loss) Before Tax\" to \"Annual Net Profit/(Net Loss) Before Tax (from operations other than R&D operations) Enter -ve value in case of net loss\" - under Continuing Expenses only Worksheet",
//                "151. Verify user is displayed a new field - Net Profit from R&D Operations Before Tax If Net Profit, please note total grants, endowments, & other financial contributions that would be eliminated following a covered loss to tangible property here: R&D Income Sources & Expected Amounts If Net Loss, state \"None\" – (Insurer policy form automatically removes Net Loss from calculation for R&D Operations.)",
//                "152. Verify user is displayed error validation message on entering invalid value for the currency field - Net Profit from R&D Operations Before Tax Error message 1. Max allowed value $9,999,999,999,999.99 2. Only currency Values allowed (0-9, $, ., ,)",
//                "153. Verify user is able to enter a currency value with decimal in the field - Net Profit from R&D Operations Before Tax and also validate the value displayed is comma separated, in View mode value is displayed as rounded off value and in edit mode value is displayed with decimal.",
//                "154. Verify when the value entered in the Annual Net Profit/(Net Loss) Before Tax is lesser than 0, the Annual Business Income Total calculation formula is implemented properly",
//                "155. Verify when the value entered in the Annual Net Profit/(Net Loss) Before Tax is greater than 0, the Annual Business Income Total calculation formula is implemented properly",
//                "156. Verify user is displayed Add Location(s) from SOV button",
//                "157. Verify user is displayed a popup on clicking Add Location(s) from SOV button",
//                "158. Verify user can close the popup by clicking on close(x) icon or on Cancel button",
//                "159. Verify the address displayed in the Add location(s) from SOV popup are displayed in the following order with comma separation. Location Name, Building Number, Street Address, City, State ZIP / Postal Code, Country",
//                "160. Verify user is able to Select All or deselect All address location by clicking on the checkbox in the header of the popup",
//                "161. Verify inline error message is displayed, when user clicks on Add Selected button without selecting any location - Select at least one property to add",
//                "162. Verify user is not able to select same location multiple times",
//                "163. Verify user is able to select more than one location from the popup",
//                "164. Verify for the selected Address, new columns with selected location information displaying below the location header with the option to edit the linked Property (SOV) location",
//                "165. Verify user is displayed the Add Locations popup by clicking on the edit icon",
//                "166. Verify the select all checkbox in the header is not displayed when Edit icon is clicked",
//                "167. Verify all the other locations in the popup are disabled except for the location for which the edit icon is clicked.",
//                "168. Enter the details for all the field for Continuing Expenses only Worksheet",
//                "169. Verify user us displayed two option on clicking on Standard BI Worksheet option: 1. Single BI Worksheet (Default Selected) 2. Multi-Location BI worksheet",
//                "170. Verify user is displayed two option for Single BI Worksheet:1. Actual (Default Selected) 2. Projected",
//                "171. Actual Radio option - Verify the field validations and error messages for the following fields of Annual Net Sales:Add the same validations for Cost of Sales / Cost of Revenues / COGS and Operating Expenses fields",
//                "172. Validate the formula for calculating the Business Interruption BI Values, Formula = Annual Net Sales of Business Interruption BI Values = Annual Net Sales of Information from Income Statement * (% Variable/Non-Continuing of Information from Income Statement)/100",
//                "173. For Cost of Sales - Validate the formula for calculating the Business Interruption BI Values,Formula = Business Interruption BI Values of Cost of Revenues = Annual Net Sales of Cost of Revenues * (% Variable/Non-Continuing of Cost of Revenues)/100",
//                "174. Gross Profit / Gross Earnings (Information from Income Statement)- Validate the value is calculated as per the formula: Gross Profit / Gross Earnings of Information from Income Statement = Annual Net Sales of Information from Income Statement - Cost of Sales of Information from Income Statement",
//                "175. Gross Profit / Gross Earnings (Business Interruption BI Values)- Validate the value is calculated as per the formula: Gross Profit / Gross Earnings = Annual Net Sales of Business Interruption BI Values - Cost of Sales of Business Interruption BI Values",
//                "176. For Operating Expenses - Validate the formula for calculating the Business Interruption BI Values,Formula = Business Interruption BI Values = Annual Net Sales of Operating Expenses * (% Variable/Non-Continuing of Operating Expenses)/100",
//                "177. For Operating Income - Validate the formula for calculating the Business Interruption BI Values,Formula = Operating Income of Information from Income Statement = Gross Profit / Gross Earnings of Information from Income Statement - Operating Expense of Information from Income Statement",
//                "178. Annual BI Value w/o Ordinary Payroll - Verify the value calculated is as per the Formula and the value is currency formatted and rounded off to 2 decimal places Formula : Business Interruption BI Values = Gross Profit / Gross Earnings of Business Interruption BI Values + Operating Expense of Business Interruption BI Values",
//                "179. Ordinary Payroll (annual payroll and benefits for non-exempt workers) - Enter invalid value for currency field and validate the error message - Enter only currency value (0-9, $, ., ,)",
//                "180. # of Days Coverage of Ordinary Payroll Desired (0-365 days) - Verify the error message on entering invalid value",
//                "181. Total Ordinary Payroll (OP) - Verify the value calculated is as per the Formula and the value is currency formatted and rounded off to 2 decimal places Formula : Total Ordinary Payroll (OP) of Business Interruption BI Values = Ordinary Payroll of Business Interruption BI Values * # of Days Coverage of Ordinary Payroll Desired of Business Interruption BI Values / 365",
//                "182. Annual BI Value including Ordinary Payroll - Verify the value calculated is as per the Formula and the value is currency formatted and rounded off to 2 decimal places Formula Annual BI Value including Ordinary Payroll of Business Interruption BI Values = Annual BI Value w/o Ordinary Payroll of Business Interruption BI Values + Total Ordinary Payroll (OP) of Business Interruption BI Values",
//                "183. Number of Months to Move to another Location and Resume Operation - Verify the whole number",
//                "184. Exposed BI w/o OP of Business Interruption BI Values - Verify the value calculated is as per the Formula and the value is currency formatted and rounded off to 2 decimal places Formula: Exposed BI w/o OP of Business Interruption BI Values = Annual BI Value w/o Ordinary Payroll of Business Interruption BI Values *Number of Months to Move to another Location and Resume Operation of Business Interruption BI Values / 12",
//                "185. Exposed BI Including OP of Business Interruption BI Values - Verify the value calculated is as per the Formula and the value is currency formatted and rounded off to 2 decimal places Formula : Exposed BI Including OP of Business Interruption BI Values = Exposed BI w/o OP of Business Interruption BI Values + Total Ordinary Payroll (OP)",
//                "186. Enter valid values for all the fields for Actual option",
//                "187. Check the checkbox for Projected and enter valid values for all fields for projected form.",
//                "188. Check the radio option for Multi Location BI Worksheet and verify user is displayed Multi Location BI Worksheet",
//				"190. (Multi Location BI) Exposed BI Incl. OP - Verify the value calculated is as per the Formula and the value is currnecy formatted and rounded off to 2 decimal places Formula : Exposed BI Incl. OP = ((Exposed BI w/o OP sum(+) [(Ordinary Payroll - annual payroll and benefits for non-exempt workers ) TIMES(*) (Number of Days Coverage of Ordinary Payroll Desired (0-365 days) DIVIDED(/) 365))]",
//				"191. Verify the field validation for all the fields in the Multi Location BI Worksheet",
//				"192. Verify user is able to enter the details in the Multi Location BI Worksheet and on clicking Continue it should navigate to BI Dependent",

                //Contingent BI / Dependent
//                "193. BI Dependent - Verify user is able to enter alphanumeric values with special characters in the fields with format as Text",
//                "194. Verify United States is displayed as default country in the Country field",
//                "195. Verify the error message displayed when user tries to enter a new country in the Country field - Please select a valid country name",
//                "196. When country is United States - Verify user is displayed the error message if user enters invalid state - Please select valid State Name / Code",
//                "197. When country is United States - Verify user is able to add the states from the type ahead drop down values",
//                "198. When country is NON US - Verify user is able to enter alphanumeric with special characters for State field",
//                "199. Verify ZIP / Postal Code field can accept only 10 characters",
//                "200. When Country is United States - Verify user is displayed error message when ZIP / Postal code is entered more than 5 and less than 9 digits - Enter a valid ZIP / Postal Code",
//                "201. When Country is United States Verify user is able to enter ZIP of 5 digits only",
//                "202. When Country is United States Verify user is able to enter ZIP / Postal Code of Zip + 4 code with a dash(“-”) in between.of 5 digits only",
//                "203. When Country is United States Verify the ZIP / Postal Code gets formatted automatically if user enters ZIP and Postal code together",
//                "204. When country is non US - Verify user is able to enter ZIP / Postal Code with alphabets, numbers, and special characters of length 10 characters",
//                "205. Annual Revenue Exposure field - Verify user is displayed error validation message on entering invalid value for the currency field - Enter only currency value (0-9, $, ., ,)",
//                "206. Verify user is able to enter a currency value with decimal in the field - Annual Revenue Exposure field and also validate the value displayed is comma separated, in View mode value is displayed as rounded off value and in edit mode value is displayed with decimal.",
//                "207. % of Product Revenue - Verify the error message displayed when user enters invalid value for % of Product Revenue field",
//                "208. % of Product Revenue - verify user is able to enter decimal value",
//                "209. Verify the error message is displayed when user enters invalid values for Estimated time until listed Process or Supplier is fully restored (months) - Enter only whole number",
//                "210. Annual Revenue Loss - Annual Revenue Loss - Verify the value calculated is as per the Formula and the value is currency formatted and rounded off to 2 decimal places Formula : (Annual Revenue Exposure*% of Product Revenue impacted)*(Estimated time until listed Process or Supplier is fully restored (months)/12)",
//                "212. # of Months of Available Inventory - Verify the error message is displayed when user enters invalid - Enter only whole number",
//                "213. CBI exposure with available inventory - Verify IF “Estimated time until listed Process or Supplier is fully restored (months)” is Less than “No of months of Available Inventory” then the value is 0",
//                "214. CBI exposure with available inventory - Verify IF “Estimated time until listed Process or Supplier is fully restored (months)” is less than “No of months of Available Inventory” then the value is calculated as per the formula: (Estimated time until listed Process or Supplier is fully restored (months)<# of Months of Available Inventory,0,(Annual Revenue Loss*(1 - (# of Months of Available Inventory/12)))),0)",
//                "215. Verify user is displayed the Options to select the value from drop down for Construction Type in alphabetical order",
//                "216. Validate the error message displayed for invalid values entered in Year field - Please enter a valid year",
//                "217. Verify the Column options displayed under Fire Protection: Smoke Detectors, Fire Extinguishers, Fire Alarm, Sprinkler System, Thermal Barriers, Hydrant, Fire Department",
//                "218. Verify the Column options displayed under Security Information: Alarm, CC TV, Gated Campus, Guards, Key Card Access",
//                "219. Enter valid details in BI Dependent tab and on clicking Continue it should navigate to Crime tab",

                //Crime
//                "220. PS062 - To verify user is able to mark Crime Page as as Not Applicable",
//                "221. PS063 - To verify user is able to enter the details in Program structure in Crime Tab",
//                "222. PS064 - To verify user is able to enter the details in General Questions in Crime Tab",
//                "223. PS066 - To verify user is able to enter the details in Coverage requirements in Crime Tab and Navigate to Transit/Cargo/Stock throughput tab",

                // 	Transit - Shipment Exposure
//				"224. Shipment Exposure - Verify user is displayed Shipment Exposure Title below Not Applicable checkbox",
//				"225. Verify user is displayed a drop down - Valuation Information with the following options: 1. Standard 2. All Replacement Cost 3. Other With Standard as default value",
//				"226. When Valuation Information option is standard, Verify user is displayed the message next to the drop down",
//				"227. Verify user is able to select option Other for Valuation Information and a Text area field is displayed next to the Drop down",
//				"228. Verify user is displayed a table -Annual Sales Turnover. Also validate: (A) Column headers: 1. 12 Months Sales Turnover Details by Policy Period 2. Annual Sales Turnover (B)Labels in 12 Months Sales column: 1. Current Ending Policy Period (MM/DD/YYYY - MM/DD/YYYY) 2. Next Policy Period (MM/DD/YYYY - MM/DD/YYYY) (c)Current Ending Policy Period (MM/DD/YYYY - MM/DD/YYYY) displays RFR Current Term (D) Next Policy Period (MM/DD/YYYY - MM/DD/YYYY) displays RFR Proposed Term",
//				"229. Verify the error message is displayed when invalid value is entered for currency field column Annual Sales Turnover",
//				"230. Verify user is displayed the table Basic Transit Questionnaire (Applies to All Industries Except Life Sciences) with two columns: 1)Questions 2)Response",
//				"231. Verify the drop down options for the question - How is Product Packaged? And also verify user is displayed a text area when Other option is selected form the drop down and the default value for the drop down is displayed as N/A",
//				"232. Verify user is displayed N/A as default value for question - FDA Approved? And also verify the options for the drop down - Yes | N/A",
//				"233. Verify user is dispalyed the following: 1. No as default value for question - Is your Product temperature sensitive? 2. Options for the drop down - Yes|No are displayed on clicking the drop down 3. If Yes is selected then Provide Storage Temperature Range (If Product Temperature Sensitivity is 'Yes', provide storage temperature range) text area is enable",
//				"234. Verify user is displayed a table Shipment / Transit Exposures with following 5 columns: 1. Shipment Exposures 2. Incoming 3. Outgoing 4. Intercompany 5. Total",
//				"235. Verify the table rows should be grouped as: 1. Shipment Exposures 2. Shipment Insurance Responsibility 3. Principal Countries Shipped(Indicate % involved) 4. Conveyance Used (% used of total annual value shipped)",
//				"236. Verify user is displayed - replacement cost as default for incoming and intra-company column and Selling Price as default for Outgoing column for row heading basic valuation and also validate the drop down option for each other 3 column drop down for the same row.",
//				"237. Verify the following for Shipment terms row:1. Row Shipment terms is displayed only for Incoming and Outgoing columns 2. validate the option of the drop down for both the columns 3. N/A is displayed as default value 4. Total field should be disabled",
//				"238. Total Annual Value Shipped - Verify the total column is the sum of the currency fields entered for Incoming, Outgoing and Intercompany",
//				"239. Verify user is able to enter currency values for the rows: Average Value per Conveyance Maximum Value per Conveyance under columns Incoming, Outgoing and Inter-company and also verify the total field under total column is disabled for these 2 rows.",
//				"240. Shipment Insurance Responsibility - Verify user is able to enter Percentage values for the rows At Insured Risk, At Vendor/Customer Risk, At Other's risk for the columns Incoming, Outgoing and Intercompany",
//				"241. Shipment Insurance Responsibility - Total % - Verify the error message when the total of Incoming column for the 3 rows - At Insured Risk, At Vendor/Customer Risk, At Other's risk - is more than 100 % Total Incoming Shipments should not be greater than 100%",
//				"242. Shipment Insurance Responsibility - Total % - Verify the error message when the total of Incoming column for the 3 rows - At Insured Risk, At Vendor/Customer Risk, At Other's risk - is less than 100 % Total Incoming Shipments should not be greater than 100%",
//				"243. Shipment Insurance Responsibility - Total % - Verify the error message when the total of Outgoing column for the 3 rows - At Insured Risk, At Vendor/Customer Risk, At Other's risk - is more than 100 % Total Outgoing Shipments should not be greater than 100%",
//				"244. Shipment Insurance Responsibility - Total % - Verify the error message when the total of Outgoing column for the 3 rows - At Insured Risk, At Vendor/Customer Risk, At Other's risk - is less than 100 % Total Outgoing Shipments should not be less than 100%",
//				"245. Shipment Insurance Responsibility - Total % - Verify the error message when the total of Intercompany column for the 3 rows - At Insured Risk, At Vendor/Customer Risk, At Other's risk - is more than 100 % - Total Intercompany Shipments should not be less than 100%",
//				"246. Shipment Insurance Responsibility - Total % - Verify the error message when the total of Intercompany column for the 3 rows - At Insured Risk, At Vendor/Customer Risk, At Other's risk - is less than 100 % - Total Intercompany Shipments should not be less than 100%",
//				"247. Principal Countries Shipped (Indicate % involved) - Verify user is displayed label - What is the level of information required for International Shipments, with the option By Continents, By Countries, Rest of World and also verify Continents option is selected as default.",
//				"248. Verify user is displayed a new row Foreign below the Domestic U.S. row checking the Rest of World radio option.",
//				"249. Verify user is displayed the error message when invalid values are entered in Column (Incoming, Outgoing and Intercompany) for row Foreign - Error message: a. Only percentage value is allowed (0-9, decimal) b. The value should be between 0% to 100%",
//				"250. Verify on Selecting Continent radio option - 1. Delete Continent from list 2. A new row with a list of continents drop down is displayed 3. User is able to select the Continent from the drop down 4. After selecting the Continent, the drop down shifts to next row. 5. In the next row, In drop down User is not displayed the already selected Continent",
//				"251. Verify user is able to delete the Continent rows by clicking on the delete icon next to the Continent name",
//				"252. Verify user is displayed the error message when invalid values are entered in Column (Incoming, Outgoing and Intercompany) for row Continent - Error message: a. Only percentage value is allowed (0-9, decimal) b. The value should be between 0% to 100%",
//				"253. Verify on Selecting Country radio option - 1. A new row with a list of Countries drop down is displayed 2. User is able to select the Country from the drop down 3. After selecting the Country, the drop down shifts to next row. 4. In the next row, In drop down User is not displayed the already selected Country",
//				"254. Verify user is able to delete the Country row by clicking on the delete icon next to the country name",
//				"255. Verify user is displayed the error message when invalid values are entered in Column (Incoming, Outgoing and Intercompany) for row Country - Error message: a. Only percentage value is allowed (0-9, decimal) b. The value should be between 0% to 100%",
//				"256. Rest of World or Continent or Country - Total % - Verify the error message when the total of Incoming column for the Rest of World or Continent or Country - is more than or less than 100 %. Error message - Total Incoming Shipments should not be greater than 100% Error message - Total Incoming Shipments should not be less than 100%",
//				"257. Rest of World, Continent, Country - Total % - Verify the error message when the total of Outgoing column for the Rest of World or Continent or Country - is more than or less than 100 %. Error message -Total Outgoing Shipments should not be greater than 100% Error message -Total Outgoing Shipments should not be less than 100%",
//				"258. Rest of World, Continent, Country - Total % - Verify the error message when the total of Intercompany column for the Rest of World or Continent or Country - is more than or less than 100 %. Error message -Total Intercompany Shipments should not be greater than 100% Error message -Total Intercompany Shipments should not be less than 100%",
//				"259. Verify user is displayed error message on entering invalid values for percentage field for each field under Conveyance Used (% used of total annual value shipped) header rows and under Incoming, Outgoing and Inter company Columns. Error message: a. Only percentage value is allowed (0-9, decimal) b. The value should be between 0% to 10",
//				"260. Verify the message displayed below the table with the title - RULES FOR ANY MODE OR MODES OF TRANSPORT and also below the title RULES FOR SEA AND INLAND WATERWAY TRANSPORT'",
//				"261. Verify user is able to enter the details in transit tab - Shipments sub tab and on clicking continue it should redirected to Product Transit tab",

				// Transit- Product
//				"262. Verify user is displayed the title Product Transit Below the Not applicable Check box.",
//				"263. Verify user is displayed the Valuation information field with following options in the drop down label \"Valuation Information\" and also validate Standard is displayed as default value: 1. Standard 2. Life Science - Default 3. Life Science - Commercial 4. Other",
//				"264. Verify User is displayed the following messages on the side of the Valuation drop down on selecting Standard option from Valuation drop down",
//				"265. Verify User is displayed the messages on the side of the Valuation drop down on selecting Life Science - Default option from Valuation drop down",
//				"266. Verify User is displayed the messages on the side of the Valuation drop down on selecting Life Science - Commercial option from Valuation drop down",
//				"267. Verify user is displayed a text area when Other option is selected from the Valuation Information drop d0wn",
//				"268. Verify user is displayed the error message for fields Product Name and Sub-Components(Parts or Processes) when these fields are left empty and a value is entered in some other field.Error message : For Product Name : Product Name is Required For Sub-Components(Parts or Processes) : Sub-Components (Parts or Processes) is Required",
//				"270. Verify the error message is displayed for field Package Protection Duration(hrs) when invalid value is entered. Error Message - Enter only whole number",
//				"271. Verify the Drop down values for the following fields: 1. FDA Approved for Sale? 2. Product Temperature Sensitivity 3. Product Packaged 4. Conveyance",
//				"272. Verify user is able to add a new row by clicking on add button.",
//				"273. Verify user is able to delete one of the added row",
//				"274. Verify If “Life Science” is selected for “P&C Practice” from Cover Page then “Life Science - Default” should be pre-selected in the “Valuation Information” drop down",
//				"275. Verify user is able to enter details for all the fields in Product Transit tab.",
//				"276. Verify user is directed to List page on clicking save and close and directed back to Product Transit tab on clicking the RFR in the List page",
//				"277. Verify user is directed to Product Flow tab on clicking Continue button",

                // Transit - Product Flow
//				"278. Verify user is displayed the title Product Flow Below the Not applicable Check box.",
//				"279. Verify user is displayed the error message for fields Product Name and Sub-Components(Parts or Processes) when these fields are left empty and a value is entered in some other field. Error message : For Product Name : Product Name is Required For Sub-Components(Parts or Processes) : Sub-Components (Parts or Processes) is Required",
//				"280. Verify the error message for invalid value for Country field under Shipment From and Shipment To Columns. Error message : Please select a valid country name",
//				"281. Verify the error message for invalid value for State or Province field when Country is United States under Shipment From and Shipment To Columns. Error message : Please select valid State Name/Code",
//				"282. Verify the error message when invalid value for currency Field Average Value Shipped per Shipment is entered. Error message: 1. Max allowed value $9,999,999,999,999.99 2. Only currency values allowed(0-9, $, ., ,)",
//				"283. Verify the error message when invalid value for Field Frequency of Average Shipment Per Year is entered. Error message: a. Enter only whole number",
//				"284. Verify the error message when invalid value for currency Field Maximum Value Shipped per shipment is entered. Error message: 1. Max allowed value $9,999,999,999,999.99 2. Only currency values allowed(0-9, $, ., ,)",
//				"285. Verify the error message when invalid value for Field Frequency of Max Shipment Per Year is entered. Error message:a. Enter only whole number",
//				"286. Verify the value displayed for field Annual value Shipped is calculated as per the formula : (Average Value Shipped per Shipment x Frequency of Average Shipment Per Year) + ( Maximum Value Shipped per shipment x Frequency of Max Shipment Per Year)",
//				"287. Verify user is displayed the Total at the end of column Annual value Shipped. The value should be Sum of Annual value shipped ( all rows)",
//				"289. Verify The error message is displayed for field Package Protection Duration(hrs) when invalid value is entered. Error Message - Enter only whole number",
//				"290. Verify user is able to enter the details in Product Flow tab",
//				"291. Verify the error message when user clicks on Add Selected button without selecting any Product in Add Products popup. Error message : Select at least one product to add",
//				"292. Verify the error message when user selects the product but does not enter value for No of segments in the popup Error message : Enter \"No of Segments\" for selected products",
//				"293. Verify the error message when user selects the product but does not enter value for No of segments in the popup Error message : Enter \"No of Segments\" for selected products",
//				"294. Verify user is able to add the rows for the products from Add Products popup",
//                "295. Verify user is able to enter the details in the newly added rows",
//				"296. Verify user is able to add a row buy clicking on Add row button",
//				"297. Verify user is able to delete the newly added row",
//				"298. Verify user is able to enter the details in Coverage Notes",
//				"299. Verify User is directed back to Renewal List page on clicking save and close button",
//				"300. Verify user is navigated to Transit Loc. Inv tab by clicking on Continue button",

                // Transit- Location Inventory
//				"301. Verify user is displayed the title Transit Location Inventory Below the Not applicable Check box.",
//				"302. Verify user is displayed the mentioned columns as default which will not be configurable from Customize columns",
//				"303. Verify User is displayed Show/Hide Column(s) label, Clicking on which should display an overlay screen with the list of possible column names",
//				"304. In Show / Hide Columns - Building Details - Verify following Columns are Checked as default and user is not able to uncheck them.",
//				"305. In Show / Hide Columns - Building Details - Verify user is able to check and uncheck the column name Occupied Floor area Sq.Ft.",
//				"306. In Show / Hide Columns overlay - Verify under Building Contents - 3 sub sections are displayed: 1. REPLACEMENT COST 2. SELLING PRICE 3. Aggregate Building Contents",
//				"307. In Show / Hide Columns overlay - Building Contents - Verify the Columns labels under Replacement Sub section",
//				"308. In Show / Hide Columns overlay - Building Contents - Verify the Columns labels under Selling Price Sub section",
//				"309. In Show / Hide Columns overlay - Building Contents -Verify the Columns labels under Aggregate Building Contents Sub section",
//				"310. Verify user is able to check / uncheck the following columns under Additional Details:1. Other Occupants or Tenants 2. Additional Information",
//				"311. In Show / Hide Columns overlay - Verify the Labels under Fire Protection",
//				"312. In Show / Hide Columns overlay - Fire Protection - Verify the following columns are preselected and cannot be unchecked : 1. Sprinkler System 2. Smoke Detectors 3. Fire Alarm",
//				"313. In Show / Hide Columns overlay - Fire Protection - Verify user is able to check and uncheck the following columns: 1. Fire Extinguishers 2. Thermal Barriers 3. Hydrant 4. Fire Department",
//				"314. In Show / Hide Columns overlay -Security - Verify the following columns are pre selected and cannot be unchecked : 1. Alarm 2. Guards",
//				"315. In Show / Hide Columns overlay - Security - Verify user is able to check and uncheck the following columns: 1. Gated Campus 2. CC TV 3. Key Card Access",
//				"316. In Show / Hide Columns overlay - Very user is displayed 3 buttons : 1. Cancel 2. Revert 3. Apply",
//				"317. In Show / Hide Columns overlay - Verify user is able to cancel the selections and exit the show / hide overlay by clicking on the Cancel button",
//				"318. In Show / Hide Columns overlay - Verify user is able to revert back to default selections in the overlay on clicking the revert button",
//				"319. In Show / Hide Columns overlay - Verify user is able to add the columns from the overlay in the table by checking the check boxes for the columns and clicking on Apply button",
//				"320. Verify the columns under the Replacement heading in the Show / Hide overlay are displayed with column name with Replacement Cost heading in parenthesis in the table",
//				"321. Verify the columns under the Selling Price heading in the Show / Hide overlay are displayed with column name with Selling Price heading in parenthesis in the table",
//				"322. Verify user is able to select the state / Province value from the drop down by typing first 2 letters of state from the drop down if the country is US.",
//				"323. When country is United States - Verify user is displayed the error message if user enters invalid state - Please select valid State Name / Code",
//				"324. Verify the error message displayed when user tries to enter a new country in the Country field - Please select a valid country name",
//				"325. Verify ZIP / Postal Code field can accept maximum of 10 character",
//				"326. Verify the error message displayed when incorrect value is entered for Currency fields- Enter only currency value (0-9, $, ., ,)",
//				"327. Verify the error message on entering invalid value for field Total Area Sq. Ft. : 1. Max 25 characters 2. Only numeric and decimal values are allowed",
//				"328. Verify the error message on entering invalid value for field Occupied Floor area Sq.Ft. : a. Enter only whole number",
//				"329. Verify the error message on entering invalid value for field % Occupied : a. Only percentage value is allowed (0-9, decimal) b. The value should be between 0% to 100%",
//				"330. Verify the error message displayed for Year Built field on entering alphabets : Enter only number",
//				"331. Verify the error message for Year field on entering a year value of less than 4 digits: a. Please enter a valid year",
//				"332. Verify the error message for # of Stories field on entering invalid value other than numeric value : 1. Max 4 characters 2. Only numeric values allowed (0-9999)",
//				"333. Verify user is able to add a new row by clicking on add button.",
//				"334. Verify user is able to delete a row.",
//				"335. Transit Location Inventory - For the Drop down Building Use, Verify the following new values are displayed in the drop down list.: 1. Clean Rooms 2. Laboratories 3. Supply Chain / Contract Manufacturer 4. Vivarium",
//				"336. In Transit Location inventory tab- verify user is able to view the newly added Columns in the Show / hide Overlay. 1. Samples/Demos/Free Units under Building Contents 2. Building Use Detail - next to Building Use column",
//				"337. Verify user is able to enter the details in Transit Loc Inv and navigate to Casualty tab",

                //Revenue & Liability Limits
//				"338. PS125 - To verify user is able to mark Casualty Exposure - Revenue & Liability Limits tab as Not Applicable",
//				"339. PS126 - Verify user is able to add another row of details in Casualty Exposure Tab, Revenue & Liability Limits grid by clicking on add Row under Program Structure",
//				"340. PS127 - Verify user is able to Delete the added row of details in Casualty Exposure Tab, Revenue & Liability Limits grid by clicking on Delete under Program Structure",
//				"341. PS078 - To verify user is able to enter the details For Estimated Exposure for General Liability for the Policy Period Noted Below in Revenue & Liability Limits tab",
//				"342. PS079 - To verify user is able to enter the details For Program Structure in Revenue & Liability Limits tab",
//				"343. PS080 - To verify user is able to enter the details For Coverage Notes in Revenue & Liability Limits tab",
//				"344. PS081 - To verify user is able to enter the details For General Information in Revenue & Liability Limits tab",
//				"345. Verify validation error messages on the Revenue & Liability Limits Tab",
//				"346. Verify new application changes on Revenue & Liability Limits Tab",
//				"347. Verify user is displayed Show/Hide Column overlay and validate the fields",
//				"348. Revenue & Liability Limits - Verify the country column is pre-selected and disabled in the Show/hide column overlay",
//				"349. Verify when P&C Practice is commercial - in the show/hide overlay, only Products and Sales/service options should be displayed as pre-selected",
//				"350. Revenue & Liability Limits Verify when P&C Practice is Life Science - in the show/hide overlay, only Lab Payroll and Square Footage options should be displayed as pre-selected",
//				"351. PS082 - To verify user is able to enter the details For Coverage Requirements in Revenue & Liability Limits tab and navigate to Product Liability Tab",

				//Product Liability
//				"352. Verify the error message displayed for invalid values for currency field Revenue.Error Message : Enter only currency value (0-9, $, ., ,)",
//				"353. Verify user is able to add a new row by clicking on Add row button",
//				"354. Verify user is able to delete a row",
//				"355. When P&C Practice is Life Science - Verify the changes for Product Liability tab under Casualty Exposure",
//				"356. Verify user is bale to enter valid details in Product Liability - Product Revenue table and navigate to Product Liability Excess tab",

				//Casuality Exposure-Product liability Excess
//				"357. PS131 - To verify user is able to mark Casualty Exposure - Product Liability Excess Tab as Not Applicable",
//				"358. PS132 - Verify user is able to add another row of details in Casualty Exposure Tab, Product Liability Excess Tab by clicking on add Row under Program Structure",
//				"359. Verify user is able to Delete the added row of details in Casualty Exposure Tab, Product Liability Excess Tab by clicking on Delete under Program Structure and click on continue button to navigate on Auto tab",

				// Auto
//				"360. Verify the field zip code is updated to new label - ZIP / Postal Code",
//				"361. Verify ZIP / Postal Code field can accept maximum of 10 character",
//				"362. Verify the error message is displayed when invalid values for ZIP /Postal Code is entered when country is United states - Enter a valid ZIP / Postal Code",
//				"363. When Country is United States Verify user is able to enter ZIP of 5 digits only",
//				"364. When Country is United States Verify user is able to enter ZIP / Postal Code of Zip + 4 code with a dash(“-”) in between.of 5 digits only",
//				"365. When Country is United States Verify the ZIP / Postal Code gets formatted automatically if user enters ZIP and Postal code together",
//				"366. When country is non US - Verify user is able to enter ZIP / Postal Code with alphabets, numbers, and special characters of length 10 characters",
//				"367. Verify the Name of the State column is renamed to State or Province and navigate to Auto Rental & Travel tab",

				// Auto, Auto rental & Travel Tab
//				"368. Verify Total # of Employees grid from the Auto tab is removed from the Auto tab",
//				"369. Verify Total # of Employees grid is added to the new tab Auto Rental / Travel",
//				"370. Verify Auto Rental grid from the Auto tab is removed from the Auto tab",
//				"371. Verify Auto Rental grid is added to the new tab Auto Rental / Travel",
//				"372. Verify International Travel grid is not displayed in Foreign Tab - International Revenue & Payroll Tab",
//				"373. Verify International Travel grid is added to the new tab Auto Rental / Travel",
//				"374. Verify user is displayed a new tab Auto Rental / Travel next to Auto tab under Casualty Exposure",
//				"375. Verify user is able to mark the Auto Rental / Travel Tab as Not Applicable.",
//				"376. Verify User is displayed the Following Grids in Auto Rental/Travel Tab: International Travel,Total # of Employees,Auto Rentals",
//				"377. Verify User is able to add row under International Travel grid by clicking on Add Row Button",
//				"378. Verify user is able to cancel the deletion of the row by clicking on the Cancel button in the delete popup",
//				"379. Verify user is able to delete the row",
//				"380. Validate the Field validation for the all the fields under the 3 grids",
//				"381. Enter the details in the grids for Auto Rental/ Travel tab",
//				"382. Verify user is navigated to RFR list page on clicking save and Close button in Auto Rental / travel tab",
//				"383. Verify user is navigated to the E&O/Cyber Liability tab on clicking Continue button on Auto Rental/ Travel Tab",

				//E&O Cyber Liability
//				"384. PS137 - Verify user is able to add another row of details in Casualty Exposure Tab, E&O/Cyber Liability tab by clicking on add Row under Program Structure",
//				"385. PS138 - Verify user is able to Delete the added row of details in Casualty Exposure Tab, E&O/Cyber Liability tab by clicking on Delete under Program Structure",
//				"386. PS098 - To verify user is able to enter the details for Program Structure in E&O/Cyber Liability tab",
//				"387. PS100 - To verify user is able to enter the details for Schedule of Underlying in E&O/Cyber Liability tab and navigate to E&O/Cyber Liability - Excess tab",

				//Cyber Liability Excess
//				"388. PS139 - To verify user is able to mark Casualty Exposure - E&O/Cyber Liability - Excess tab as Not Applicable",
//				"389. PS140 - Verify user is able to add another row of details in Casualty Exposure Tab, E&O/Cyber Liability - Excess tab by clicking on add Row under Program Structure",
//				"389.1. PS141 - Verify user is able to Delete the added row of details in Casualty Exposure Tab, E&O/Cyber Liability - Excess tab by clicking on Delete under Program Structure",
//				"389.2. PS102 - To verify user is able to enter the details for Program Structure in E&O/Cyber Liability - Excess tab",
//				"389.3. PS103 - To verify user is able to enter the details for Schedule of Underlying in E&O/Cyber Liability - Excess tab and navigate to WC-Exposures",

                //U.S. Workers' Compensation Remuneration Worksheet
//                "390. PS156 - To verify user is able to mark WC Exposure - U.S. Workers' Compensation Remuneration Worksheet tab as Not Applicable",
//                "391. PS157 - Verify user is able to add another row of details in WC Exposure Tab,U.S. Workers' Compensation Remuneration Worksheet tab by clicking on add Row under Limits",
//                "392. PS158 - Verify user is able to Delete the added row of details in WC Exposure Tab, U.S. Workers' Compensation Remuneration Worksheet tab by clicking on Delete under Limits",
//                "393. Verify new application changes on U.S. Workers' Compensation Remuneration Worksheet tab",
//                "394. Verify new application changes on U.S. Workers' Compensation Remuneration Worksheet tab with Positive Test Cases",
//                "395. PS105 - To verify user is able to enter the details in U.S. Workers' Compensation Remuneration Worksheet tab and navigate to Supplementary Application Tab",

                //Supplementary Application
//				"396. PS159 - To verify user is able to mark WC Exposure - Supplementary Application tab as Not Applicable",
//				"397. PS107 - To verify user is able to enter the details in Supplementary Application Tab and navigate to Foreign Tab",

				// International Revenue & Payroll Tab
//				"398. Verify user is not displayed the old grid in foreign tab for International Revenue & Payroll tab grid",
//				"399. Verify the new table and headers are displayed under International Revenue & Payroll tab grid",
//				"400. Verify User is able to enter Text value for Local Legal Entity Name",
//				"401. Verify user is able to enter Alphanumeric values for Street Address",
//				"402. Verify user is able to enter only Alphabet values with special characters (. , ;) for city field",
//				"403. Verify user is able to select the state / Province value from the dropdown by typing first 2 letters of state from the dropdown if the country is US.",
//				"404. Verify user is able to enter the State or Province value as a text if the country is not US.",
//				"405. Verify user is able select the country from the list of countries displayed when user types in type a head field.",
//				"406. Verify user is able to enter Text values without special character in Comments (Please Enter the Currency Code if Currency is not USD) field",
//				"407. Verify user is able to enter currency value for the field Estimated Annual Gross Revenue (USD) – Currency and also validate the (,) formatting of the entered value",
//				"408. Verify user is able to enter a currency value with comma in Estimated Annual Gross Revenue (USD) field",
//				"409. Verify User is able to enter a currency value with decimal in Estimated Annual Gross Revenue (USD) field",
//				"410. Verify user is able to view the option for the dropdown field Job Function: All Sales Service Clerical R&D",
//				"411. Verify the default value for the Job Function is 'All'",
//				"412. Verify user is able to select the values from the Job Function drop down",
//				"413. Verify user is displayed error message on entering value other than numeric / numeric with decimal for # of Employees Field - Only numeric values allowed (0-9, ., ,)",
//				"414. Verify user is able to enter numeric / numeric with decimal value in # of Employees Field. Also validate the format is comma separated",
//				"415. Verify the decimal value is displayed as it is in both edit and view mode for # of Employees Field",
//				"416. Verify user is displayed error message on entering values other than currency for Payroll (USD) - Only currency values allowed (0-9, $, ., ,)",
//				"417. Verify the currency values entered in Payroll (USD) field are displayed with comma formatting",
//				"418. Verify user is able to enter currency value with decimals in Payroll (USD) field",
//				"419. Verify in edit mode the decimal values are displayed for Payroll (USD)",
//				"420. Verify in view mode the currency value entered in Payroll (USD) is displayed in rounded off format",
//				"421. Verify user is displayed error message on entering value other than numeric / numeric with decimal for # of Employees Field under Local National header - Only numeric values allowed (0-9, ., ,)",
//				"422. Verify user is able to enter numeric / numeric with decimal value in # of Employees Field under Local National header. Also validate the format is comma separated",
//				"423. Verify the decimal value is displayed as it is in both edit and view mode for # of Employees Field under Local National header",
//				"424. Verify user is displayed error message on entering values other than currency for Payroll (USD) under Local National header- Only currency values allowed (0-9, $, ., ,)",
//				"425. Verify the currency values entered in Payroll (USD) field under Local National header are displayed with comma formatting.",
//				"426. Verify user is able to enter currency value with decimals in Payroll (USD) field",
//				"427. Verify in edit mode the decimal values are displayed for Payroll (USD) under Local National header",
//				"428. Verify in view mode the currency value entered in Payroll (USD) under Local National header is displayed rounded off format",
//				"429. Verify user is displayed error message on entering value other than numeric / numeric with decimal for # of Employees Field under 3rd Country National header - Only numeric values allowed (0-9, ., ,)",
//				"430. Verify user is able to enter numeric / numeric with decimal value in # of Employees Field under 3rd Country National header. Also validate the format is comma separated",
//				"431. Verify the decimal value is displayed as it is in both edit and view mode for # of Employees Field under 3rd Country National header",
//				"432. Verify user is displayed error message on entering values other than currency for Payroll (USD) under 3rd Country National header- Only currency values allowed (0-9, $, ., ,)",
//				"433. Verify the currency values entered in Payroll (USD) field under 3rd Country National header are displayed with comma formatting.",
//				"434. Verify user is able to enter currency value with decimals in Payroll (USD) field under 3rd Country National",
//				"435. Verify in edit mode the decimal values are displayed for Payroll (USD) under 3rd Country National header",
//				"436. Verify in view mode the currency value entered in Payroll (USD) under 3rd Country National header is displayed rounded off format",
//				"437. Verify User is able to add row in International Revenue & Payroll grid by clicking on Add Row Button",
//				"438. Verify user is able to cancel the deletion of the row by clicking on the Cancel button in the delete popup in International Revenue & Payroll grid",
//				"439. Verify user is able to delete the row from International Revenue & Payroll grid",
//				"440. On Preview tab - Verify the foreign tab is updated with the new table and details.",
//				"441. Verify the order of the columns in foreign tab for International Revenue & Payroll sub tab and on continue it should be navigated to UMB excess",

                //Umbrella Liability
//				"442. PS165 - To verify user is able to mark UMB/Excess tab - Umbrella Liability tab as Not Applicable",
//				"443. PS166 - Verify user is able to add another row of details in UMB/Excess Tab - Umbrella Liability tab by clicking on add Row under Program Structure",
//				"444. PS167 - Verify user is able to Delete the added row of details in UMB/Excess Tab -Umbrella Liability tab by clicking on Delete under Program Structure",
//				"445. PS168 - Verify user is able to add another row of details in UMB/Excess Tab - Umbrella Liability tab by clicking on add Row under Schedule of Underlying",
//				"446. PS169 - Verify user is able to Delete the added row of details in UMB/Excess Tab - Umbrella Liability tab by clicking on Delete under Schedule of Underlying",
//				"447. PS113 - To verify user is able to enter the details for Program Structure in Umbrella Liability Tab",
//				"448. PS114 - To verify user is able to enter the details for Schedule of Underlying in Umbrella Liability Tab and navigate to Excess Liability tab",

                //Excess Liability
//				"449. PS116 - To verify user is able to enter the details for Program Structure in Excess Liability tab",
//				"450. PS117 - To verify user is able to enter the details for Schedule of Underlying in Excess Liability tab and navigate to Review and Generate Workbook tab",

				// Review Tab
//				"451. Verify user is able to Preview the details entered by user for General Information tab by clicking on General Information in Preview tab",
//				"452. Verify user is able to Preview the details entered by user for Property(SOV) by clicking on Property in Preview tab",
//				"453. Verify user is able to Preview the details entered by user for Property 3rd party by clicking on Property in Preview tab",
//				"454. Verify user is able to Preview the details entered by user for BI Dependent by clicking on Property in Preview tab",
//				"455. Verify user is able to Preview the details entered by user for Revenue & Liability Limits by clicking on Casualty in Preview tab",
//				"456. Verify user is able to Preview the details entered by user for Product Liability by clicking on Casualty in Preview tab",
//				"457. Verify user is able to Preview the details entered by user for Auto by clicking on Casualty in Preview tab",
//				"458. Verify user is able to Preview the details entered by user for Auto Rental & Travel by clicking on Casualty in Preview tab",
//				"459. Verify user is able to Preview the details entered by user for International Revenue & Payroll by clicking on Foreign in Preview tab",
//				"460. Verify user is able to Preview the details entered by user for UMB/Excess by clicking on UMB/Excess in Preview tab",
//				"461. Verify user is able to Preview the details entered by user for Transit Shipment by clicking on Property in Preview tab",
//				"462. Verify user is able to Preview the details entered by user for Product Transit by clicking on Property in Preview tab",
//				"463. Verify user is able to Preview the details entered by user for Product Flow by clicking on Property in Preview tab",
//				"464. Verify user is able to Preview the details entered by user for Transit Location Inventory by clicking on Property in Preview tab",

				//Export
//				"465. Verify user is able to enter the details in all the tabs and export the RFR",
//				"466. PS256 - Validate Error Message in Named Insured Tab of Exported excel sheet",
//				"467. PS257 - Validate Formula in Named Insured Tab of Exported excel sheet",
//				"468. PS258 - Validate data in Named Insured sheet of Exported excel sheet",
//				"469. Validate data in Property (SOV) sheet of Exported excel sheet",
//				"470. Validate Error Message in Property SOV Tab of Exported excel sheet",
//				"471. Validate Formula in Property SOV Tab of Exported excel sheet",
//				"472. Validate data in Property (SOV) 3rd Party sheet of Exported excel sheet",
//				"473. Validate Error Message in Property SOV 3rd Party Tab of Exported excel sheet",
//				"474. Validate Formula in Property SOV 3rd Party Tab of Exported excel sheet",
//				"475. Validate Error Message in BI Worksheet (Single) sheet of Exported excel sheet",
//				"476. Validate Formula in BI Worksheet sheet of Exported excel sheet",
//				"477. Validate data in BI Worksheet sheet of Exported excel sheet",
//				"478. Validate Error Message in BI Dependent sheet of Exported excel sheet",
//				"479. Validate Formula in BI Dependent sheet of Exported excel sheet",
//				"480. Validate data in BI Dependent sheet of Exported excel sheet",
//				"481. Validate Error Message in Transit Shipment sheet of Exported excel sheet",
//				"482. Validate Formula in Export/ transit Shipments Tab of Exported excel sheet",
//				"483. Validate data in Export/ transit Shipments sheet of Exported excel sheet",
//				"484. Validate Error Message in Product Transit sheet of Exported excel sheet",
//				"485. Validate Formula in Product Transit sheet of Exported excel sheet",
//				"486. Validate data in Product Transit sheet of Exported excel sheet",
//				"487. Validate Error Message in Product Flow sheet of Exported excel sheet",
//				"488. Validate Formula in Product Flow sheet of Exported excel sheet",
//				"489. Validate data in Product Flow sheet of Exported excel sheet",
//				"490. Validate Error Message in Transit Loc. Inv. sheet of Exported excel sheet",
//				"491. Validate Formula in Transit Loc. Inv. sheet of Exported excel sheet",
//				"492. Validate data in Transit Loc. Inv. sheet of Exported excel sheet",
//				"493. PS259 - Validate Error Message in Revenue & Liability Limits Tab of Exported excel sheet",
//				"494. PS260 - Validate Formula in Revenue & Liability Limits Tab of Exported excel sheet",
//				"495. PS261 - Validate data in Revenue & Liability Limits sheet of Exported excel sheet",
//				"496. Validate Formula in Product Liability Tab of Exported excel sheet",
//				"497. Validate Error Message in Product Liability Tab of Exported excel sheet",
//				"498. Validate data in Product Liability Tab of Exported excel sheet",
//				"499. PS274 - Validate Error Message in Auto Rental & Travel Exposure Tab of Exported excel sheet",
//				"500. PS275 - Validate Formula in Auto Rental & Travel Exposure Tab of Exported excel sheet",
//				"501. PS276 - Validate data in Auto Rental & Travel Exposure sheet of Exported excel sheet",
//				"502. PS277 - Validate Error Message in Driver & Auto List Tab of Exported excel sheet",
//				"503. PS278 - Validate Formula in Driver & Auto List Tab of Exported excel sheet",
//				"504. PS279 - Validate data in Driver & Auto List sheet of Exported excel sheet",
//				"505. PS280 - Validate Error Message in Non-Owned Quest. Tab of Exported excel sheet",
//				"506. PS281 - Validate Formula in Non-Owned Quest. Tab of Exported excel sheet",
//				"507. PS282 - Validate data in Non-Owned Quest. sheet of Exported excel sheet",
//				"508. PS286 - Validate Error Message in Workers Comp Tab of Exported excel sheet",
//				"509. PS287 - Validate Formula in Workers Comp Tab of Exported excel sheet",
//				"510. PS288 - Validate data in Workers Comp sheet of Exported excel sheet",
//				"511. PS289 - Validate Error Message in WC Supplemental Tab of Exported excel sheet",
//				"512. PS290 - Validate Formula in WC Supplemental Tab of Exported excel sheet",
//				"513. PS291 - Validate data in WC Supplemental sheet of Exported excel sheet",
//				"514. Validate Error Message in International Revenue & Payroll sheet of Exported excel sheet",
//				"515. Validate Formula in International Revenue & Payroll sheet of Exported excel sheet",
//				"516. Validate data in International Revenue & Payroll sheet of Exported excel sheet",
//				"517. Verify user is able to enter the details in the tabs related to life science P&C Practice and export the RFR",
//				"518. Validate Error Message in B.I. Worksheet - CE sheet of Exported excel sheet",
//				"519. Validate Formula in B.I. Worksheet - CE sheet of Exported excel sheet",
//				"520. Validate data in B.I. Worksheet - CE sheet of Exported excel sheet",
//				"521. Verify user is able to enter the details in the BI Worksheet - Standard BI - Multi Location BI Worksheet and export the RFR",
//				"522. Validate Error Message in BI (Multi-Location) sheet of Exported excel sheet",
//				"523. Validate Formula in BI (Multi-Location) sheet of Exported excel sheet",
//				"524. Validate data in BI (Multi-Location) sheet of Exported excel sheet",

                // Import
//				"525. Write valid data in all sheets of Exported excel file using Auto It",
//				"526. Validate imported file valid data in each tabs",
//				"527. Write invalid data in all sheets of Exported excel file using Auto It",
//				"528. Verify error message in import tab",
//				"529. Verify the RFR to be uploaded is validated by the system for the Client Name and and error message \"The client name in the uploaded document does not match with RFR client name\" is displayed",
//				"530. Verify the RFR to be uploaded is validated by the system for the Policy Period and and error message is displayed when incorrect Policy Period is mentioned in the RFR excel",
//				"531. Write valid data when P&C is Life Science in all sheets of Exported excel file using Auto It",
//				"532. Write invalid data when P&C is Life Science in all sheets of Exported excel file using Auto It and import it",
//              	"533. Verify the system performs the validation for all the active sheets in RFR excel and highlights the missing sheets and display an Alert “<<SHEET NAME>> is missing from the workbook.” should be displayed next to progress bar",
//              	"534. Verify on importing the file, workbook  label and status is not displayed when the tab is marked as not applicable"
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

			logger.info("Getting all the GUI Test Cases for the Project (" + project1.projectName + ") from QIF...");
			guiTestCases = qifClient.getGUITestCases(project1.projectId,false,null);

            logger.info("Getting all the GUI Test Cases for the Project (" + project2.projectName + ") from QIF...");
            guiTestCases.addAll(qifClient.getGUITestCases(project2.projectId,false,null));

            List<TestCaseGUI> obsolted_GuiTestCases = new ArrayList<>();
			for (TestCaseGUI testCase : guiTestCases) {
			    if (testCase.description.startsWith("[Obsolete]")){
                    obsolted_GuiTestCases.add(testCase);
                    continue;
                }
				String sNo=testCase.description.split(" ")[0];
				if (sNo.matches(".*[a-zA-Z]+.*")) {
					if (sNo.contains(".P."))
						guiTestCases_performance_Tests.add(testCase);
					else if (sNo.contains(".U."))
						guiTestCases_UIValidation_Tests.add(testCase);
					//guiTestCases.remove(testCase);
				}
			}
			if(obsolted_GuiTestCases.size()>0)
			    guiTestCases.removeAll(obsolted_GuiTestCases);
			for (TestCaseGUI testCase : guiTestCases_performance_Tests)
				guiTestCases.remove(testCase);
			for (TestCaseGUI testCase : guiTestCases_UIValidation_Tests)
				guiTestCases.remove(testCase);
			//Execute selected tests only as mentioned in listOfTCstoExecute
			if(config.app.getProperty("app.gui.executeselectedTCs").toUpperCase().startsWith("T")) {
				List<TestCaseGUI> guiTestCases_new = new ArrayList<>();
				for (TestCaseGUI testCase : guiTestCases) {
				    System.out.println("Desc:"+testCase.description);
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

			logger.info("Initializing the Browser on (" + browserName + ") Web Driver...");
			Browser.initialize(browserName);
			logger.info("Setting the Browser Window Size to (" +
				browserWidth + "x" + browserHeight + ") Resolution...");
			Browser.webDriver.manage().window().setPosition(new Point(0, 0));
			//Browser.webDriver.manage().window().setSize(new Dimension(browserWidth, browserHeight));
			Browser.webDriver.manage().window().maximize();
			//Browser.webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Browser.webDriver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);

			logger.info("Opening the Application URL in the Browser...");
			Browser.webDriver.get(config.app.getProperty("app.gui.url"));
			if(browserName.equalsIgnoreCase("edge")) {
				WebDriverWait wait = new WebDriverWait(Browser.webDriver, 10);
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".renewal-button")));
					Browser.webDriver.findElement(By.cssSelector(".menu-blk .dropdown-toggle")).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menu-blk .dropdown-menu .log-blk")));
					Browser.webDriver.findElement(By.cssSelector(".menu-blk .dropdown-menu .log-blk")).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cUsername")));
				} catch (TimeoutException| NoSuchElementException e) {

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
		int i=0;
		for (TestCaseGUI testCase : guiTestCases)
			TestDesc[i++][0]=testCase.description;
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
        TestCaseGUI testCase =null;

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
            if (guiTestCases_performance_Tests.stream()
                    .filter(x -> x.description.startsWith(sNo + "P.")).findFirst().orElse(null) != null)
                gui_Perf_TC = guiTestCases_performance_Tests.stream()
                        .filter(x -> x.description.startsWith(sNo + "P.")).findFirst().get();
            if (guiTestCases_UIValidation_Tests.stream()
                    .filter(x -> x.description.startsWith(sNo + "U.")).findFirst().orElse(null) != null)
                gui_UIVal_TC = guiTestCases_UIValidation_Tests.stream()
                        .filter(x -> x.description.startsWith(sNo + "U.")).findFirst().get();
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
                String sheetName="";
                Map<String,String> autoItData=new HashMap<String, String>();
                XSSFWorkbook currentExcelWorkbook = new XSSFWorkbook();
                String sCurrentExcelSheetName = "";
                String typeData="";
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
                            WebDriverWait wait = new WebDriverWait(Browser.webDriver, 30);
                            wait.until(pageLoadCondition);
                            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
                            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("dx-loadindicator-content")));
                            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("homeLoaderBG")));
                            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ag-overlay-loading-center")));
                            // Initialize the Objects required to perform actions

                            logger.info("Test Action Name: " + testAction.action.fieldName + " (" + testAction.action.fieldValue + ")." + testAction.action.actionType);

                            int integerValue;
                            int waitTime=30;
                            Actions actions = new Actions(Browser.webDriver);
                            // Execute the Test Step Action
                            switch (testAction.action.actionType.toLowerCase()) {
                                case "browse":
                                    // Browser opening action
                                    Browser.webDriver.get(testAction.action.fieldValue);
                                    break;
                               case "click":
                                   try {
                                       new WebDriverWait(Browser.webDriver, waitTime)
                                               .until(ExpectedConditions.elementToBeClickable(
                                                       By.cssSelector(testAction.action.fieldName)
                                               ));

                                        // Field clicking action
                                       if(Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).getAttribute("type").equals("checkbox")) {
                                           if (testAction.action.fieldValue.equals("true") &&
                                                   !Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).isSelected()) {
                                               Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).click();
                                           } else if (testAction.action.fieldValue.equals("false") &&
                                                   Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).isSelected()) {
                                               Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).click();
                                           }
                                       }
                                       else{
                                           Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).click();
                                       }
                                   }
                                   catch(Exception ex) {
                                   }

                                    break;
                                case "mouse-hover":
                                    // Field Mouse Hover action
                                    actions.moveToElement(Browser.webDriver.findElement(
                                            By.cssSelector(testAction.action.fieldName)
                                    )).perform();
                                    break;
                                case "clear":
                                    // Field clearing action
                                    Browser.webDriver.findElement(
                                            By.cssSelector(testAction.action.fieldName)
                                    ).clear();
                                    break;
                                case "replace":
                                    typeData=testAction.action.fieldValue;
                                    if(testAction.action.fieldValue.contains("readDataFile"))
                                    {
                                        typeData=excelOperation.readDataFromExcel(testAction.action.fieldValue);
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
//                                    excelOperation exc=new excelOperation();
                                    typeData=testAction.action.fieldValue;
                                    if(testAction.action.fieldValue.contains("readDataFile"))
                                    {
                                        typeData=excelOperation.readDataFromExcel(testAction.action.fieldValue);
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
                                    String sText = "";
                                    String sValue = "";
                                    String sinnerHTML = "";

                                    if(testAction.action.fieldValue.contains("readDataFile")) {
                                        typeData=excelOperation.readDataFromExcel(testAction.action.fieldValue);
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
                                            || sText.equals(typeData))){
                                        stepResult.status = "Fail";
                                        stepResult.actualResult = "Field (" + testAction.action.fieldName + ")" +
                                                "does not match the value given (" + testAction.action.fieldValue +
                                                ") , Got [" + sText + sValue + sinnerHTML + "]";
                                        logger.error(stepResult.actualResult);
                                    }
                                    break;
                                case "match-selectedtext":
                                    String selectedOption="";
                                    try{
                                        Select drpText = new Select(Browser.webDriver.findElement(
                                                By.cssSelector(testAction.action.fieldName)
                                        ));

                                        selectedOption = drpText.getFirstSelectedOption().getText();
                                    } catch (NullPointerException ex) {
                                    }
                                    if (!selectedOption.equals(testAction.action.fieldValue.trim())){
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
                                    typeData=testAction.action.fieldValue;
                                    if(testAction.action.fieldValue.contains("readDataFile"))
                                    {
                                        typeData=excelOperation.readDataFromExcel(testAction.action.fieldValue);
                                    }
                                    // Field selecting by index action
//                                    String visibleText = testAction.action.fieldValue;
                                    Select dropDownText = new Select(Browser.webDriver.findElement(
                                            By.cssSelector(testAction.action.fieldName)
                                    ));
                                    dropDownText.selectByVisibleText(typeData);
                                    break;

                                case "select-value-inputdropdown":
                                    typeData=testAction.action.fieldValue;
                                    if(testAction.action.fieldValue.contains("readDataFile")) {
                                        typeData=excelOperation.readDataFromExcel(testAction.action.fieldValue);
                                    }
                                    Browser.webDriver.findElement(
                                            By.cssSelector(testAction.action.fieldName)
                                    ).sendKeys(Keys.chord(Keys.CONTROL, "a"),typeData);
                                    Thread.sleep(500);

                                    Browser.webDriver.findElement(
                                            By.cssSelector(testAction.action.fieldName)
                                    ).sendKeys(Keys.ENTER);
                                    break;

                                case "wait-display":
                                    // Waiting for Field to be   visible action
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

                                    if(testAction.action.fieldValue.trim().contains(".")){
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
                                    String DownloadDir = System.getProperty("user.home") + "\\Downloads\\";
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
                                    } while (true);
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
									int LoadTime=Integer.parseInt(config.app.getProperty("app.gui.defaultloadtime"));
									long TransactionTime = ((new Date()).getTime() - iTransactionStartTime);
									if(!testAction.action.fieldValue.equals(""))
										LoadTime = Integer.parseInt(testAction.action.fieldValue);
									if(TransactionTime > LoadTime) {
										sPerfActualResult = "Time take for this transaction is [" + TransactionTime
												+ "] milliseconds But expected to be less than [" + LoadTime + "] milliseconds"
										+ " on Browser: " + config.app.getProperty("selenium.webdriver.name");
									}
									else
									{
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
									robot.delay(2000);
									robot.keyPress(KeyEvent.VK_DOWN);
									robot.keyRelease(KeyEvent.VK_DOWN);
									robot.keyPress(KeyEvent.VK_ENTER);
									robot.keyRelease(KeyEvent.VK_ENTER);
									robot.delay(2000);
									break;
                                case "ignore":
                                    break;
								case "uivalidation":
									LayoutReport layoutReport = Galen.checkLayout(Browser.webDriver, "./src/test/java/com/PandC/uispec/"+testAction.action.fieldValue,
											new SectionFilter(Arrays.asList("desktop"),null),new Properties(), new HashMap<String, Object>());
									List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();
									GalenTestInfo test = GalenTestInfo.fromString(
											gui_UIVal_TC.description
												+ config.app.getProperty("selenium.webdriver.name"));
									test.getReport().layout(layoutReport,
											gui_UIVal_TC.description.substring(0,20).replace(" ","_")
												+config.app.getProperty("selenium.webdriver.name"));
									tests.add(test);
									HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
									String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
									//Create a report
									htmlReportBuilder.build(tests, "UIValidation/"+ gui_UIVal_TC.description.substring(0,20).replace(" ","_")
											+config.app.getProperty("selenium.webdriver.name")+"_"+ timeStamp);
									String folderToZip = "UIValidation/"+ gui_UIVal_TC.description.substring(0,20).replace(" ","_")
											+config.app.getProperty("selenium.webdriver.name")+"_"+ timeStamp;
									String zipName = "UIValidation/"+ gui_UIVal_TC.description.substring(0,20).replace(" ","_")
											+config.app.getProperty("selenium.webdriver.name")+"_"+ timeStamp+".zip";
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
									UIValidationZipPath =  qifClient.uploadScreenShot(
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
                                    currentExcelWorkbook = new XSSFWorkbook(new FileInputStream(
                                            System.getProperty("user.home")
                                                    + "\\Downloads\\" + testAction.action.fieldValue));
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
                                                    sActualValue= dateFormat.format(currentExcelWorkbook.getSheet(sCurrentExcelSheetName)
                                                            .getRow(iRow).getCell(iColumn).getDateCellValue());
                                                }
                                                else if (currentExcelWorkbook.getSheet(sCurrentExcelSheetName)
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
                                                        .getRow(iRow).getCell(iColumn).getStringCellValue();
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
                                    WebActions ac=new WebActions();
                                    ac.waitForElementClickable(Browser.webDriver,3000,".aRFRClone");
                                    ac.clickAction(Browser.webDriver,".aRFRClone");
                                    ac.waitForElement(Browser.webDriver,3000,"#buttonOkClone");
                                    ac.clickAction(Browser.webDriver,"#buttonOkClone");
                                    ac.replaceText(Browser.webDriver,"#InsuranceDateFrom","03/13/2018");
                                    ac.clickAction(Browser.webDriver,"#btnContinue");
                                    ac.waitForElement(Browser.webDriver,3000,"#UmbrellaEx");
                                    ac.clickAction(Browser.webDriver,"#UmbrellaEx");
                                    ac.waitForElementClickable(Browser.webDriver,3000,"button#btnUmbrellaSave");
                                    ac.clickAction(Browser.webDriver,"button#btnUmbrellaSave");
                                    ac.waitForElement(Browser.webDriver,3000,"#PopUpOKUmbrella");
                                    ac.clickAction(Browser.webDriver,"#PopUpOKUmbrella");
                                    ac.waitForElement(Browser.webDriver,3000,".aRFRClone");

                                    break;

                                case "validateerrormessage":
                                    String errorValue=com.PandC.lib.excelOperation.getErrorMessage(testAction.action.fieldName);

                                    try {
                                        Assert.assertTrue(
                                                errorValue.equals(testAction.action.fieldValue),
                                                "Validation in Field (" + testAction.action.fieldName + ") should contain [" +
                                                        testAction.action.fieldValue + "] and Got [" + errorValue + "]"

                                        );
                                    } catch (AssertionError e) {
                                        throw new Exception("Validation in Field (" + testAction.action.fieldValue + ") should contain [" +
                                                testAction.action.fieldValue + "] but Got [" + errorValue + "]");
                                    }

                                    break;

                                case "validateformula":
                                    String formulaValue=com.PandC.lib.excelOperation.getFormula(testAction.action.fieldName);

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

                                case "autoitfiledata":
                                    if(testAction.action.fieldValue.contains("readDataFile")){
                                        String writeData= excelOperation.readDataFromExcel(testAction.action.fieldValue);
                                        autoItData.put(testAction.action.fieldName,writeData);
                                    }
                                    else{
                                        sheetName=testAction.action.fieldValue;
                                    }

                                    break;

                                case "generateautoitfile":
                                    try{
                                        excelOperation.createAutoItScript(sheetName,autoItData,testAction.action.fieldValue);
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }
                                    if(!autoItData.isEmpty()){
                                        autoItData.clear();
                                    }
                                    break;

                                case "executeautoitscript":
                                    try{
                                        String autoItScriptName=Paths.get(System.getProperty("user.dir"), "testdata/AutoItFiles/",testAction.action.fieldValue+".au3").toString();
                                        ProcessBuilder pb= new ProcessBuilder("C:\\Program Files (x86)\\AutoIt3\\AutoIt3.exe",autoItScriptName);
                                        Process p=pb.start();
                                        //Waiting for the process to complete
                                        while (p.isAlive()){
                                        }
                                        logger.info("Run the "+autoItScriptName+" and Data has been written into the "+testAction.action.fieldValue+ " sheet");

                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }
                                    break;

                                case "uploadexportedfile":
                                    //   String lstofFil= testAction.action.fieldValue;
                                    String fileName = System.getProperty("user.home") + "\\Downloads\\" + testAction.action.fieldValue;
                                    Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).sendKeys(fileName);

                                    break;

                                case "validateselected-checkbox":
                                    Thread.sleep(2000);
                                    boolean isTrue = false;
                                    try {
                                        if(testAction.action.fieldValue.equals("true")) {
                                            isTrue = Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).isSelected();
                                            Assert.assertTrue(isTrue,"Checkbox should be selected");
                                        }
                                        else{
                                            isTrue = !Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).isSelected();
                                            Assert.assertTrue(isTrue,"Checkbox should not be selected");
                                        }
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }
                                    break;

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
