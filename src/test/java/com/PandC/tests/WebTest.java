package com.PandC.tests;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import com.galenframework.speclang2.pagespec.SectionFilter;
import com.galenframework.validation.ValidationResult;
import com.periscope.qif.client.QIFClient;
import com.periscope.qif.json.*;
import com.PandC.lib.Browser;
import com.PandC.lib.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DynamicTest;
//import org.junit.jupiter.api.TestFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	private static QIFClient qifClient;
	private static Project project;
	private static List<TestCaseGUI> guiTestCases = new ArrayList<>();
	private static List<TestCaseGUI> guiTestCases_performance_Tests = new ArrayList<>();
	private static List<TestCaseGUI> guiTestCases_UIValidation_Tests = new ArrayList<>();



	@BeforeSuite
	static void setUp() {
		// Specify the list of selected tests to execute and this is applicable only if app.gui.executeselectedTCs is set to true
		List<String> listOfTCstoExecute = Arrays.asList(
//				"1. PS001 - To verify user navigates to Insurance Renewal List dashboard on clicking Request For Renewal Tile in home page",
//				"2. PS002 - To verify user is able to navigate back to Home page while clicking the Forms link in the breadcrumb",
//				"3. PS003 - Verify user is able to search the Renewal records for a particular Account Handler by selecting name of the handler in search.",
//				"4. PS004 - Verify user is able to navigate to next page in the grid by clicking on page number in pagination",
//				"5. PS007 - Verify user is able to search a record by Name Insured",
//				"6. PS008 - Verify user is able to search a record by \"Policy From\"",
//				"7. PS009 - Verify user is able to search a record by \"Policy To\"",
//				"8. PS005 - Verify Delete option is displayed only for the records in “Draft” status in the grid",
//				"9. PS013 - Verify user is able to search a record by Status",
//				"10. PS006 - Verify user is displayed No records Found when no records are present for the searched criteria",
//				"11. PS010 - Verify user is able to search a record by Primary Contact",
//				"12. PS014 - Verify user is displayed General Information page along with - \"Cover Page” as default",
//				"13. PS024 - Verify user is navigated to Insurance Renewal List page on clicking cancel Button on Cover page",
//				"14. PS023 - Verify user is displayed the message - \"Please enter the fields marked as mandatory to continue further.” When user clicks on Continue button without entering the mandatory fields in Cover Page",
//				"14.1. PS192 - RFR->Cover Page Renewal Type Required field - validate error (Red border -Indicating error no field) is displayed in case of invalid date",
//				"15.1. PS189 - Validate error message is displayed for From Date on Cover Page",
//				"15.2. PS190 - Validate the error message on entering Alpha Characters in Years in Business field on Cover Page",
//				"15.3. PS191 - Validate the Alert Pop Up is displayed properly for Blank Date in Cover Page",
//				"15.4. PS193 - RFR-> Cover page In case of Renewal Type not selected, user is not able to navigate to Named Insureds",
//				"15.5. PS194 - RFR-> Request for Quotation Message field displays an error in case of left blank",
//				"15.6. PS015 - Verify user is able enter details in Cover Page and navigate to Insured Names tab",
//				"15.7. PS188 - Validate error message should display for invalid Date on Cover page",
//				"16. PS016 - Verify the user is not able to attach multiple files same time in Cover Page",
//				"17. PS034 - Verify user is directed back to Insurance Renewal List page on clicking Save and Close Button on Named Insured Tab",
//				"18.1. PS035 - Verify the status of the created record is Draft in Insurance Renewal List page on clicking Save and Close button in Insured Name Tab",
//				"18.2. PS029 - Verify user is displayed error message- Please make sure that imported file is as per the standard template. upload files which is not as per the template in Named Insured page in General Information Tab",
//				"18.3. PS033 - Verify user is displayed error message -Click on Browse to upload file with.xls / .xlsx extension, when user clicks on Import button without browsing the files to upload on Named Insured Page",
//				"18.4. PS027 - Verify user is able to Import a file in \".xls or .xlsx format\" by clicking browse button and then clicking on import button in the downloaded Template format",
//				"19. PS032 - Verify user is able to add another row of details in Name Insured grid by clicking on add Row",
//				"20. PS031 - Verify user is able to add details in Named Insured grid by clicking on Add Row",
//				"21. PS026 - Verify user is able to download the template, by clicking on Template button",
//				"22. PS028 - Verify user is displayed error message Please upload file in .xls or .xlsx format only when user tries to upload file of other extension",
//				"23. PS018 -  Verify user is not able to upload more than 10 files and displayed the message - Maximum 10 files can be uploaded",
//				"24. PS017 -  Verify user is able to uncheck and delete the uploaded document",
//				"25. PS019 - Verify user is displayed the message - \"Invalid file name. File name should not contain special characters like ~ ` ! @ # $ % ^ & * ( ) + = { } | [ ] : \" ; < > ? , /\" when user uploads a file with special characters",
//				"26. PS020 - Verify user is displayed the message - \"File Size Exceeds the maximum size (5 MB)\" when user uploads a file more than 5 mb",
//				"27. PS021 - Verify user is displayed the message - \"Duplicate files are not allowed. A file with same name exists!\" when user uploads a duplicate file",
//				"28. PS022 - Verify user is displayed the message - \"Invalid file extension. Only “.pdf”, “.xls, “.xlsx” ,“ .doc .docx” file extensions are supported.\" when user uploads a file other than supported extensions",
//				"29. PS030 -  Verify the proposed date displayed in Insured Name tab is same as the proposed date in the Cover page tab",
//				"29.1. PS043 - To verify user is able to edit the Program Structure in Property (Statement of Values) tab",
//				"30. PS036 - Verify User is able to enter details in Premium & Loss History Tab",
//				"31.1. PS037 - To verify user navigates to Property Exposure Tab and Property (Statement of Values) tab is displayed as default",
//				"31.2. PS039 - To verify user is able to mark Property (Statement of Values) tab as Not Applicable",
//				"31.3. PS045 - To verify user is able to add rows under Program Structure in Property (Statement of Values) tab",
//				"31.4. PS044 - To verify user is able to Delete a row from the Program Structure Property (Statement of Values) tab",
//				"32.1. PS039 - To verify the error message Please upload file in .xls or .xlsx format only on uploading a file with incorrect format in Property (Statement of Values) tab",
//				"32.2. PS040 - To verify the error message Please make sure that imported file is as per the standard template. on uploading a with incorrect details in template",
//				"32.3. PS041 - To verify user is able to download the Template in Property (Statement of Values) tab",
//				"32.4. PS038 - To verify user is able to Import the file and fill the details with the imported file in Property (Statement of Values) tab",
//				"33. PS046 - To verify user is able to add comment under Coverage Requirement in Property (Statement of Values) tab", "34.1. PS042 - To verify user is able to enter the details in Property (Statement of Values) tab and navigate to BI Worksheet tab",
//				"34.2. PS053 - Verify the Error Message \"Please enter the fields marked as mandatory to continue further.\" by Clicking on Continue Button without Entering Mandatory Fields in BI Worksheet Tab",
//				"34.3. PS048 - To verify user is able to mark BI Worksheet page as Not Applicable",
//				"34.5. PS051 - To verify user is able to Delete the other Location by clicking on Delete Icon in BI Worksheet Tab",
//				"35. PS049 - To verify user is able to enter the details in BI Worksheet page",
//				"36.1. PS050 - To verify user is able to add another Location by clicking on Add Location Button in BI Worksheet Tab and navigate to Contingent BI/ Dependent tab",
//				"36.2. PS056 - To verify the error message \"Click on Browse to upload file with .xls / .xlsx extension\" on uploading a file with incorrect Extn in Contingent BI/ Dependent tab",
//				"36.3. PS054 - To verify user is able to mark Contingent BI/ Dependent tab tab as Not Applicable",
//				"36.4. PS057 - To verify user is able to download the Template in Contingent BI/ Dependent tab",
//				"36.5. PS059 - To verify user is able to add a Row in Contingent BI/ Dependent tab",
//				"37. PS055 - To verify user is able to Import the file and fill the details with the imported file in Contingent BI/ Dependent tab",
//				"37.1. PS061 - Verify the error message \"Please enter the fields marked as mandatory to continue further.\" in Contingent BI/ Dependent tab on clicking continue button without entering mandatory fields",
//				"38.1. PS058 - To verify user is able to enter the details in Contingent BI/ Dependent tab and Navigate to Crime Tab",
//				"38.2. PS062 - To verify user is able to mark Crime Page as as Not Applicable",
//				"39. PS063 - To verify user is able to enter the details in Program structure in Crime Tab",
//				"40. PS064 - To verify user is able to enter the details in General Questions in Crime Tab",
//				"41. PS065 - To verify user is able to enter the details in Crime-Controls & Underwriting question in Crime Tab",
//				"42. PS066 - To verify user is able to enter the details in Coverage requirements in Crime Tab and Navigate to Transit/Cargo/Stock throughput tab",
//				"43. PS068 - To verify user is able to enter the details For ription of Products, Sales, ription of how Products are Packaged, Annual Values Shipped in Transit/Cargo/Stock Throughput tab",
//				"44. PS069 - To verify user is able to enter the details For Incoming shipment in Transit/Cargo/Stock Throughput tab",
//				"45. PS070 - To verify user is able to enter the details For Outgoing shipment in Transit/Cargo/Stock Throughput tab",
//				"46. PS071 - To verify user is able to enter the details For Program structure in Transit/Cargo/Stock Throughput tab",
//				"47. PS072 - To verify user is able to enter the details For Coverage notes in Transit/Cargo/Stock Throughput tab and navigate to Spoilage",
//				"48. PS075 - To verify user is able to enter the details For Chubb Group in Spoilage tab",
//				"49. PS076 - To verify user is able to enter the details For Travelers Lloyds Insurance Company in Spoilage tab and navigate to Casualty Exposures",
//				"49.1. PS125 - To verify user is able to mark Casualty Exposure - Revenue & Liability Limits tab as Not Applicable",
//				"49.2. PS126 - Verify user is able to add another row of details in Casualty Exposure Tab, Revenue & Liability Limits grid by clicking on add Row under Program Structure",
//				"49.3. PS127 - Verify user is able to Delete the added row of details in Casualty Exposure Tab, Revenue & Liability Limits grid by clicking on Delete under Program Structure",
//				"50. PS078 - To verify user is able to enter the details For Estimated Exposure for General Liability for the Policy Period Noted Below in Revenue & Liability Limits tab",
//				"50.1. PS079 - To verify user is able to enter the details For Program Structure in Revenue & Liability Limits tab",
//				"50.2. PS080 - To verify user is able to enter the details For Coverage Notes in Revenue & Liability Limits tab",
//				"50.3. PS081 - To verify user is able to enter the details For General Information in Revenue & Liability Limits tab",
//				"54. PS082 - To verify user is able to enter the details For Coverage Requirements in Revenue & Liability Limits tab and navigate to Product Liability Tab",
//				"54.1. PS128 - To verify user is able to mark Casualty Exposure - Product Liability Tab as Not Applicable",
//				"54.2. PS129 - Verify user is able to add another row of details in Casualty Exposure Tab, Product Liability Tab by clicking on add Row under Program Structure",
//				"54.3. PS130- Verify user is able to Delete the added row of details in Casualty Exposure Tab, Product Liability Tab by clicking on Delete under Program Structure",
//				"55. PS084 - To verify user is able to enter the details For Program Structure in Product Liability tab",
//				"56. PS085 - To verify user is able to enter the details For Coverage Notes in Product Liability tab and navigate to Product Liability - Excess  tab",
//				"56.1. PS131 - To verify user is able to mark Casualty Exposure - Product Liability Excess Tab as Not Applicable",
//				"56.2. PS132 - Verify user is able to add another row of details in Casualty Exposure Tab, Product Liability Excess Tab by clicking on add Row under Program Structure",
//				"56.3. PS133 - Verify user is able to Delete the added row of details in Casualty Exposure Tab, Product Liability Excess Tab by clicking on Delete under Program Structure",
//				"57. PS086 - To verify user is able to enter the details For Program Structure in Product Liability - Excess  tab",
//				"58. PS087 - To verify user is able to enter the details For Coverage Notes in Product Liability - Excess  tab and navigate to Auto Tab",
//				"58.1 PS134 - To verify user is able to mark Casualty Exposure - Auto Tab as Not Applicable",
//				"59. PS089 - To verify user is able to Import the file and fill the details with the imported file Auto tab",
//				"60. PS090 - To verify user is able to enter the details in Vehicle & Driver Schedule",
//				"61. PS091 - To verify user is able to enter the details for How Many Total Employees and Auto table in Auto tab",
//				"62. PS092 - To verify user is able to enter the details for Program Structure in Auto tab",
//				"63. PS093 - To verify user is able to enter the details for Auto Non-Owned / Hired Questionnaire in Auto tab",
//				"64. PS094 - To verify user is able to enter the details for Coverage Requirements in Auto tab and navigate to Life Science tab",
//				"64.1. PS135 - To verify user is able to mark Casualty Exposure - Life Science Tab as Not Applicable",
//				"65. PS096 - Verify user is able to upload the file with details in Life Science Tab and navigate to E&O/Cyber Liability tab",
//				"65.1. PS136 - To verify user is able to mark Casualty Exposure - E&O/Cyber Liability tab as Not Applicable",
//				"65.2. PS137 - Verify user is able to add another row of details in Casualty Exposure Tab, E&O/Cyber Liability tab by clicking on add Row under Program Structure",
//				"65.3. PS138 - Verify user is able to Delete the added row of details in Casualty Exposure Tab, E&O/Cyber Liability tab by clicking on Delete under Program Structure",
//				"66. PS098 - To verify user is able to enter the details for Program Structure in E&O/Cyber Liability tab",
//				"67. PS100 - To verify user is able to enter the details for Schedule of Underlying in E&O/Cyber Liability tab and navigate to E&O/Cyber Liability - Excess tab",
//				"68.1. PS139 - To verify user is able to mark Casualty Exposure - E&O/Cyber Liability - Excess tab as Not Applicable",
//				"68.2. PS140 - Verify user is able to add another row of details in Casualty Exposure Tab, E&O/Cyber Liability - Excess tab by clicking on add Row under Program Structure",
//				"68.3. PS141 - Verify user is able to Delete the added row of details in Casualty Exposure Tab, E&O/Cyber Liability - Excess tab by clicking on Delete under Program Structure",
//				"68.4. PS102 - To verify user is able to enter the details for Program Structure in E&O/Cyber Liability - Excess tab",
//				"69. PS103 - To verify user is able to enter the details for Schedule of Underlying in E&O/Cyber Liability - Excess tab and navigate to WC-Exposures",
//				"70.1. PS156 - To verify user is able to mark WC Exposure - U.S. Workers' Compensation Remuneration Worksheet tab as Not Applicable",
//				"70.2. PS157 - Verify user is able to add another row of details in WC Exposure Tab,U.S. Workers' Compensation Remuneration Worksheet tab by clicking on add Row under Limits",
//				"70.3. PS158 - Verify user is able to Delete the added row of details in WC Exposure Tab, U.S. Workers' Compensation Remuneration Worksheet tab by clicking on Delete under Limits",
//				"70.4. PS105 - To verify user is able to enter the details in U.S. Workers' Compensation Remuneration Worksheet tab and navigate to Supplementary Application Tab",
//				"71.1. PS159 - To verify user is able to mark WC Exposure - Supplementary Application tab as Not Applicable",
//				"71.2. PS107 - To verify user is able to enter the details in Supplementary Application Tab and navigate to Foreign Tab",
//				"72.1. PS160 - To verify user is able to mark Foreign - International Revenue & Payroll tab as Not Applicable",
//				"72.2. PS161 - Verify user is able to add another row of details in Foreign Tab, International Revenue & Payroll tab by clicking on add Row under International Column grid",
//				"72.3. PS162 - Verify user is able to Delete the added row of details in Foreign Tab,International Revenue & Payroll tab by clicking on Delete under International Travel column grid",
//				"72.4. PS109 - To verify user is able to enter the details for US Employees, Rest of the World in Foreign Tab",
//				"73. PS110 - To verify user is able to Import the file and fill the details with the imported file in Foreign Tab",
//				"74.1. PS163 - Verify user is able to add another row of details in Foreign Tab, International Revenue & Payroll tab by clicking on add Row under Program Structure",
//				"74.2. PS164 - Verify user is able to Delete the added row of details in Foreign Tab,International Revenue & Payroll tab by clicking on Delete under Program Structure",
//				"74.3. PS111 - To verify user is able to enter the details in Program Structure in Foreign Tab and navigate to UMB/Excess Tab",
//				"74.4. PS165 - To verify user is able to mark UMB/Excess tab - Umbrella Liability tab as Not Applicable",
//				"74.5. PS166 - Verify user is able to add another row of details in UMB/Excess Tab - Umbrella Liability tab by clicking on add Row under Program Structure",
//				"74.6. PS167 - Verify user is able to Delete the added row of details in UMB/Excess Tab -Umbrella Liability tab by clicking on Delete under Program Structure",
//				"74.7. PS168 - Verify user is able to add another row of details in UMB/Excess Tab - Umbrella Liability tab by clicking on add Row under Schedule of Underlying",
//				"74.8. PS169 - Verify user is able to Delete the added row of details in UMB/Excess Tab - Umbrella Liability tab by clicking on Delete under Schedule of Underlying",
//				"75. PS113 - To verify user is able to enter the details for Program Structure in Umbrella Liability Tab",
//				"76. PS114 - To verify user is able to enter the details for Schedule of Underlying in Umbrella Liability Tab and navigate to Excess Liability tab",
//				"77. PS116 - To verify user is able to enter the details for Program Structure in Excess Liability tab",
//				"78. PS117 - To verify user is able to enter the details for Schedule of Underlying in Excess Liability tab and navigate to Review and Submit to Carrier tab",
//				"79. PS119 - Verify user is able to Preview the details entered by user for General Information by clicking on General Information in Preview tab",
//				"79.1. Review Tab - Verify the contents of the Named Insured Tab in the Exported Excel by clicking on Export button",
//				"80. PS120 - Verify user is able to Preview the details entered by user for Property Exposures by clicking on Property Exposures in Preview tab",
//				"81. PS121 - Verify user is able to Preview the details entered by user for Casualty Exposures by clicking on Casualty Exposures in Preview tab",
//				"82. PS122 - Verify user is able to Preview the details entered by user for WC Exposures by clicking on WC Exposures in Preview tab",
//				"83. PS123 - Verify user is able to Preview the details entered by user for Foreign by clicking on Foreign in Preview tab",
//				"84. PS124 - Verify user is able to Preview the details entered by user for UMB/Excess by clicking on UMB/Excess in Preview tab",
//				"85. PS118 - Verify user is able to add the details in Request For Quotation tab and submit the request for Quotation",
//				"86. Review Tab - Verify the contents of the Revenue & Liability Tab (Casualty Tab) in the Exported Excel by clicking on Export button",
//				"87. Review Tab - Verify the contents of the Property SOV Tab (Property Tab) in the Exported Excel by clicking on Export button",
//				"88. Review Tab - Verify the contents of the BI Worksheet Tab (Property Tab) in the Exported Excel by clicking on Export button",
//				"89. Review Tab - Verify the contents of the Contingent BI/ Dependent Tab (Property Tab) in the Exported Excel by clicking on Export button",
//				"90. Review Tab - Verify the contents of the Transit / Cargo / Stock Throughput (Property Tab) in the Exported Excel by clicking on Export button",
//				"91. Review Tab - Verify the contents of the U.S. Workers' Compensation Remuneration Worksheet (WC Exposure Tab) in the Exported Excel by clicking on Export button",
//				"92. Review Tab - Verify the contents of the Auto Tab (Casualty Exposure Tab) in the Exported Excel by clicking on Export button",
//				"93. Review Tab - Verify the contents of the Supplementary Application tab (WC Exposure Tab) in the Exported Excel by clicking on Export button",
//				"94. Review Tab - Verify the contents of the Auto Tab - Driver & Auto list (Casualty Exposure Tab) in the Exported Excel by clicking on Export button",
//				"95. Review Tab - Verify the contents of the Auto tab - Non-Owned Quest. (Casualty Exposure Tab) in the Exported Excel by clicking on Export button",
//				"96. Review Tab - Verify the contents of the International Liab Locations (Foreign Tab) in the Exported Excel by clicking on Export button",
				"97. CP001 - To verify user navigates to Client Proposal dashboard on clicking Client Proposal Tile in home page",
//				"98. CP002 - To verify user is able to navigate back to Home page while clicking the Forms link in the breadcrumb"
//				"99. CP006 - Verify user is able to search a record by Modified Date in Client Proposal List Page",
//				"100. CP007 - Verify user is able to search a record by Status - Draft in Client Proposal List Page",
//				"101. CP009 - Verify user is able to search the Renewal records for a particular Account Handler by selecting name of the handler in search in Create New Proposal List page",
//				"102. CP005 - Verify user is able to search a record by Primary Contact in Client Proposal List Page",
//                "103. CP003 - Verify user is able to search a record by Client Name in Client Proposal List Page",
//				"104. CP004 - Verify user is able to search a record by Policy Term in Client Proposal List Page",
				"105. CP008 - Verify user is able to Navigate to Create New Proposal page dashboard by clicking on Create New Proposal button in Client Proposal List Page",
//				"106. CP010 - Verify user is able to search a record by Client Name in Create New Proposal List Page",
//                "107. CP011 - Verify user is able to search a record by Policy Term in Create New Proposal List Page",
//                "108. CP012 - Verify user is able to search a record by Primary Contact in Create New Proposal List Page",
//				"109. CP013 - Verify user is able to search a record by Submit Date in Create New Proposal List Page",
//				"110. CP014 - Verify user is able to search a record by Status - Draft in Create New Proposal List Page",
				"111. CP015 - Verify user is able to serch a record by Status - Sent For Quotation in Create New Proposal List Page"
//				"112. CP016 - Verify user is able to navigate to Proposal Home page by clicking on edit icon for client in Create New Proposal List Page"
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
			qifClient = new QIFClient(config.qif.getProperty("qif.url.api"));

			logger.info("Authenticating with QIF...");
			qifClient.authenticate(
				config.qif.getProperty("qif.user.name"),
				config.qif.getProperty("qif.user.password"));

			logger.info("Getting the Project Details from QIF...");
			project = qifClient.getProject(config.qif.getProperty("qif.project.gui"));

			logger.info("Getting all the GUI Test Cases for the Project (" + project.projectName + ") from QIF...");
			guiTestCases = qifClient.getGUITestCases(project.projectId,false,null);
			for (TestCaseGUI testCase : guiTestCases) {
				String sNo=testCase.description.split(" ")[0];
				if (sNo.matches(".*[a-zA-Z]+.*")) {
					if (sNo.contains(".P."))
						guiTestCases_performance_Tests.add(testCase);
					else if (sNo.contains(".U."))
						guiTestCases_UIValidation_Tests.add(testCase);
					//guiTestCases.remove(testCase);
				}
			}
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
				project.projectName + ") from QIF: " + guiTestCases.size());

			logger.info("Initializing the Browser on (" + browserName + ") Web Driver...");
			Browser.initialize(browserName);
			logger.info("Setting the Browser Window Size to (" +
				browserWidth + "x" + browserHeight + ") Resolution...");
			Browser.webDriver.manage().window().setPosition(new Point(0, 0));
			//Browser.webDriver.manage().window().setSize(new Dimension(browserWidth, browserHeight));
			Browser.webDriver.manage().window().maximize();
			//Browser.webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Browser.webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

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
			if(testCaseTemp.description.equals(sTestDescrition))
				testCase=testCaseTemp;
		if(testCase==null)
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
			String UIValidationZipPath= "";
			gui_Perf_TC.description="";
			gui_UIVal_TC.description="";
			gui_Perf_Result.testResult.testCaseId = "";
			gui_UIVal_Result.testResult.testCaseId = "";
			String sNo=testCase.description.split(" ")[0];
			if(guiTestCases_performance_Tests.stream()
					.filter(x->x.description.startsWith(sNo+"P.")).findFirst().orElse(null)!=null)
				gui_Perf_TC = guiTestCases_performance_Tests.stream()
						.filter(x->x.description.startsWith(sNo+"P.")).findFirst().get();
			if(guiTestCases_UIValidation_Tests.stream()
					.filter(x->x.description.startsWith(sNo+"U.")).findFirst().orElse(null)!=null)
				gui_UIVal_TC = guiTestCases_UIValidation_Tests.stream()
						.filter(x->x.description.startsWith(sNo+"U.")).findFirst().get();
		String sPerfActualResult="";
		String sUIActualResult="";
		long iTransactionStartTime = 0;
		boolean PerfromanceTest_pass = false;
		boolean UIValidationTest_pass = false;
		if(!gui_Perf_TC.description.isEmpty()){
			gui_Perf_Result.testResult.testCaseId = gui_Perf_TC.testCaseId;
			gui_Perf_Result.testResult.moduleId = testCase.moduleId;
			gui_Perf_Result.testResult.subModuleId = testCase.subModuleId;
			gui_Perf_Result.testResult.status = "Broken";
			gui_Perf_Result.testResult.sUT = project.projectName;
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
			gui_Perf_Result.testResult.projectId = project.projectId;
			gui_Perf_Result.testResult.environment = config.app.getProperty("app.gui.environment");
			gui_Perf_Result.testResult.runID = config.app.getProperty("app.gui.runID");
			gui_Perf_TC.testCaseSteps.sort(new srNOSort());
		}
		if(!gui_UIVal_TC.description.isEmpty()){
			gui_UIVal_Result.testResult.testCaseId = gui_UIVal_TC.testCaseId;
			gui_UIVal_Result.testResult.moduleId = testCase.moduleId;
			gui_UIVal_Result.testResult.subModuleId = testCase.subModuleId;
			gui_UIVal_Result.testResult.status = "Broken";
			gui_UIVal_Result.testResult.sUT = project.projectName;
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
			gui_UIVal_Result.testResult.projectId = project.projectId;
			gui_UIVal_Result.testResult.environment = config.app.getProperty("app.gui.environment");
			gui_UIVal_Result.testResult.runID = config.app.getProperty("app.gui.runID");
			gui_UIVal_TC.testCaseSteps.sort(new srNOSort());
		}
			gui.testResult.testCaseId = testCase.testCaseId;
			gui.testResult.moduleId = testCase.moduleId;
			gui.testResult.subModuleId = testCase.subModuleId;
			gui.testResult.status = "Broken";
			gui.testResult.sUT = project.projectName;
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
			gui.testResult.projectId = project.projectId;
			gui.testResult.environment = config.app.getProperty("app.gui.environment");
			gui.testResult.runID = config.app.getProperty("app.gui.runID");

			try {
				// Loop through the Test Steps
				int iStepNum = 1;

				XSSFWorkbook currentExcelWorkbook = new XSSFWorkbook();
				String sCurrentExcelSheetName = "";
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
											return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
										}
									};
							WebDriverWait wait = new WebDriverWait(Browser.webDriver, 30);
							wait.until(pageLoadCondition);
							wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading'")));
							wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("dx-loadindicator-content")));
							wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("homeLoaderBG")));
							wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ag-overlay-loading-center")));
							wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay-loading")));
							// Initialize the Objects required to perform actions

							logger.info("Test Action Name: " + testAction.action.fieldName+ " (" + testAction.action.fieldValue + ")."+ testAction.action.actionType);

							int integerValue;
							Actions actions = new Actions(Browser.webDriver);
							// Execute the Test Step Action
							switch (testAction.action.actionType.toLowerCase()) {
								case "browse":
									// Browser opening action
									Browser.webDriver.get(testAction.action.fieldValue);
									break;
								case "click":
									// Field clicking action
									Browser.webDriver.findElement(By.cssSelector(testAction.action.fieldName)).click();
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
									// Field value replacing action
									Browser.webDriver.findElement(
											By.cssSelector(testAction.action.fieldName)
									).sendKeys(
											Keys.chord(Keys.CONTROL, "a"),
											testAction.action.fieldValue
									);
									break;
								case "type":
									// Field typing action
									Browser.webDriver.findElement(
											By.cssSelector(testAction.action.fieldName)
									).sendKeys(testAction.action.fieldValue);
									Thread.sleep(500);
									break;
								case "match-text":
									// Field match-test action
									Thread.sleep(2000);
									String sText ="";
									String sValue ="";
									String sinnerHTML = "";
									try {
										sText = Browser.webDriver.findElement(
												By.cssSelector(testAction.action.fieldName)
										).getText().trim();
									}catch (NullPointerException ex){}
									try {
										sValue = Browser.webDriver.findElement(
												By.cssSelector(testAction.action.fieldName)
										).getAttribute("value").trim();
                                    }catch (NullPointerException ex){}
									try {
										sinnerHTML = Browser.webDriver.findElement(
												By.cssSelector(testAction.action.fieldName)
										).getAttribute("innerhtml").trim();
                                    }catch (NullPointerException ex){}
									if (!(sText.equals(testAction.action.fieldValue.trim())
											||sValue.equals(testAction.action.fieldValue.trim())
											|| sinnerHTML.equals(testAction.action.fieldValue.trim()))) {
										stepResult.status = "Fail";
										stepResult.actualResult = "Field (" + testAction.action.fieldName + ")" +
												"does not match the value given (" + testAction.action.fieldValue +
												") , Got [" + sText + sValue + sinnerHTML+ "]";
										logger.error(stepResult.actualResult);

									}
									break;
								case "contains-text":
									// Validate Test in filed contains specific text
									String sTextValue = Browser.webDriver.findElement(
											By.cssSelector(testAction.action.fieldName)
									).getText();
									try{
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
									// Field selecting by index action
									String visibleText = testAction.action.fieldValue;
									Select dropDownText = new Select(Browser.webDriver.findElement(
											By.cssSelector(testAction.action.fieldName)
									));
									dropDownText.selectByVisibleText(visibleText);
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
									JavascriptExecutor js =(JavascriptExecutor)Browser.webDriver;
									js.executeScript("arguments[0].click();",Browser.webDriver.findElement(
											By.cssSelector(testAction.action.fieldName)));
									break;
								case "scrolldown":
									// Waiting for Field to be enabled action
									JavascriptExecutor j =(JavascriptExecutor)Browser.webDriver;
									j.executeScript("window.scrollTo(0, 9999)");
									Thread.sleep(1000);
									break;
								case "scrollup":
									// Waiting for Field to be enabled action
									JavascriptExecutor jse =(JavascriptExecutor)Browser.webDriver;
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
								case "wait-alert":
									integerValue = Integer.parseInt(testAction.action.fieldValue) / 1000;
									Boolean AlertFound = false;
									int i=0;
									while(i++<integerValue)
									{
										try
										{
											Alert alert = Browser.webDriver.switchTo().alert();
											AlertFound = true;
											break;
										}
										catch(NoAlertPresentException e)
										{
											Thread.sleep(1000);
											continue;
										}
									}
									Assert.assertTrue(AlertFound,"Alert/File dialog should be displayed");
									break;
								case "uploadfile":
								    if(!testAction.action.fieldName.trim().contains(" ")) {
                                        StringSelection stringSelection = new StringSelection
                                                (Paths.get(System.getProperty("user.dir"), "testdata/filesUpload/", testAction.action.fieldName).toString());
                                        //(System.getProperty("user.dir") + "filesUpload/"+testAction.action.fieldName);
                                        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                                        clipboard.setContents(stringSelection, null);
                                    }
                                    else
                                    {
                                        String lstofFile="";
                                        for (String echFile: testAction.action.fieldName.trim().split(" ")) {
                                            lstofFile += "\""
                                                    +Paths.get(System.getProperty("user.dir"), "testdata/filesUpload/", echFile).toString()
                                                    +"\"";
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
                                    org.openqa.selenium.interactions.Action action1  = ob.build();
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
										if(lastModifiedFile.getName().endsWith("crdownload"))
										{
											Thread.sleep(10000);
										}
										else
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
									String filename=lastModifiedFile.getName();
									if (!(filename.equalsIgnoreCase(testAction.action.fieldValue))) {
										stepResult.status = "Fail";
										stepResult.actualResult = "File Name" +
												" does not match the value given (" + testAction.action.fieldValue +
												") , Got [" + filename + "]";
										logger.error(stepResult.actualResult);
									}
									break;
								case "deletedowloadedfile":
									File file = new File(System.getProperty("user.home") + "\\Downloads\\"+ testAction.action.fieldValue);
									if(file.delete())
									{
										System.out.println("File deleted successfully");
									}
									else
									{
										System.out.println("Failed to delete the file");
									}
									break;
								case  "matchcssvalue":
									String cssBGValue ="";
									String cssBGCValue ="";
                                    String cssBGImage ="";

                                    try {
										cssBGCValue = Browser.webDriver.findElement(
												By.cssSelector(testAction.action.fieldName)
										).getCssValue("background-color");
									}catch (NullPointerException ex){}
									try {
										cssBGValue = Browser.webDriver.findElement(
												By.cssSelector(testAction.action.fieldName)
										).getCssValue("background");
									}catch (NullPointerException ex){}
                                    try {
                                        cssBGImage = Browser.webDriver.findElement(
                                                By.cssSelector(testAction.action.fieldName)
                                        ).getCssValue("background-image");
                                    }catch (NullPointerException ex){}
									if (!(cssBGValue.equals(testAction.action.fieldValue.trim())
											||cssBGCValue.equals(testAction.action.fieldValue.trim())||
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
									String UIErrors="";
									for (ValidationResult validationError : validationErrorResults) {
										if (!validationError.getError().isOnlyWarn()) {
											List<String> listofMsgs = validationError.getError().getMessages();
											for(String eachError:listofMsgs)
												UIErrors=UIErrors+eachError+"\n";
										}
									}

									if (layoutReport.errors() > 0)
									{
										logger.info("Error Count:" + layoutReport.errors());
										//Assertions.SoftassertEquals(softAssertion, layoutReport.errors(),0,"UI Validation For:" + sTestName + "  - " +  layoutReport.getScreenshot() + "\nError Messages:" + UIErrors);
										sUIActualResult="Failed with few mismatches On Browser: "+config.app.getProperty("selenium.webdriver.name")+". Heatmap Attached: " + UIValidationZipPath + "" +
												"                 Error Messages:" + UIErrors;
									}
									else {
										sUIActualResult = "All elements displayed as expected On Browser: "+config.app.getProperty("selenium.webdriver.name")+". Heatmap attached: " + UIValidationZipPath ;
										UIValidationTest_pass=true;
									}
									break;
								case "setcurrentexcel":
									currentExcelWorkbook = new XSSFWorkbook(new FileInputStream(
											System.getProperty("user.home")
											+ "\\Downloads\\"+ testAction.action.fieldValue));
									break;
								case "setcurrentexcelsheet":
									sCurrentExcelSheetName =testAction.action.fieldValue;
									break;
								case "matchexcelcellvalue":
									int iRow = com.PandC.lib.excelOperation.getRow(testAction.action.fieldName)-1;
											//Integer.parseInt(testAction.action.fieldName.split(",")[0].trim())-1;
									int iColumn = com.PandC.lib.excelOperation.convertName2ColumnIndex(
											com.PandC.lib.excelOperation.getColumn(testAction.action.fieldName)
											//testAction.action.fieldName.split(",")[1].trim()
									);
									String sActualValue="";
									try{
										switch (currentExcelWorkbook.getSheet(sCurrentExcelSheetName)
												.getRow(iRow).getCell(iColumn).getCellType()) {
											case XSSFCell.CELL_TYPE_NUMERIC:

												sActualValue =String.valueOf(currentExcelWorkbook.getSheet(sCurrentExcelSheetName)
														.getRow(iRow).getCell(iColumn).getNumericCellValue());
												break;
											case XSSFCell.CELL_TYPE_STRING:

												sActualValue = currentExcelWorkbook.getSheet(sCurrentExcelSheetName)
														.getRow(iRow).getCell(iColumn).getStringCellValue();
												break;
											default:
												break;
										}
									}
									catch(NullPointerException ex){
									}
									 sActualValue = sActualValue.replaceAll("[\\t\\n\\r]+", " ")
											.replaceAll("[^\\x00-\\x7F]", " ").trim();
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
									int iRowNo =  com.PandC.lib.excelOperation.getRow(testAction.action.fieldName)-1;
											/*Integer
											.parseInt(testAction.action.fieldName.split(",")[0].trim())-1*/;
									int iColumnNo = com.PandC.lib.excelOperation.convertName2ColumnIndex(
											com.PandC.lib.excelOperation.getColumn(testAction.action.fieldName)
											//testAction.action.fieldName.split(",")[1].trim()
									);
									String sActualFormat=currentExcelWorkbook.getSheet(sCurrentExcelSheetName)
											.getRow(iRowNo).getCell(iColumnNo).getCellStyle().getDataFormatString();

									if (!(sActualFormat.equals(testAction.action.fieldValue.trim()))) {
										stepResult.status = "Fail";
										stepResult.actualResult = "Value in Excel Cell (" + testAction.action.fieldName + ")" +
												"does not match the value given (" + testAction.action.fieldValue +
												") , Got [" + sActualFormat + "]";
										logger.error(stepResult.actualResult);
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
						if(!stepResult.actualResult.equalsIgnoreCase("")) {
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
							stepResult.error = stepResult.actualResult;;
							//stepResult.actualResult = testStep.expectedResult;;
							allPassed = false;
							lastError = stepResult.error;
							lastErrorScreen = stepResult.screenshotURL;
						}
						else {
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
				if(!gui_Perf_TC.description.isEmpty())
				{
					TestStepResult prefStepResult = new TestStepResult();
					prefStepResult.actualResult=sPerfActualResult.isEmpty()?
							"Test Step Not executed due to issue while executing:"+testCase.description : sPerfActualResult;
					gui_Perf_Result.testResult.actualResult = prefStepResult.actualResult;
					prefStepResult.error = PerfromanceTest_pass?"":gui_Perf_Result.testResult.actualResult;
					prefStepResult.executionStartTime = gui.testResult.executionStartTime;
					gui_Perf_Result.testResult.executionStartTime = prefStepResult.executionStartTime;
					prefStepResult.executionEndTime = gui.testResult.executionEndTime;
					gui_Perf_Result.testResult.executionEndTime = prefStepResult.executionEndTime;
					prefStepResult.status = PerfromanceTest_pass?"Pass":"Fail";
					gui_Perf_Result.testResult.status = prefStepResult.status;
					prefStepResult.testCaseStepId = gui_Perf_TC.testCaseSteps.get(0).testCaseStepId;
					gui_Perf_Result.testResult.testStepResults.add(prefStepResult);
					logger_performance.info("Step: " + gui_Perf_TC.testCaseSteps.get(0).stepDescription + "\n\t\t\t\t\t\t  "
							+ "Result: " + gui_Perf_Result.testResult.actualResult);
					qifClient.postGUITestResults(gui_Perf_Result);
				}
				// Post results for UI Validation test case
				if(!gui_UIVal_TC.description.isEmpty())
				{
					TestStepResult UIValStepResult = new TestStepResult();
					UIValStepResult.actualResult=sUIActualResult.isEmpty()?
							"Test Step Not executed due to issue while executing:"+testCase.description : sUIActualResult;
					gui_UIVal_Result.testResult.actualResult = UIValStepResult.actualResult;
					UIValStepResult.error = UIValidationTest_pass?"":gui_UIVal_Result.testResult.actualResult;
					UIValStepResult.executionStartTime = gui.testResult.executionStartTime;
					gui_UIVal_Result.testResult.executionStartTime = UIValStepResult.executionStartTime;
					UIValStepResult.executionEndTime = gui.testResult.executionEndTime;
					gui_UIVal_Result.testResult.executionEndTime = UIValStepResult.executionEndTime;
					UIValStepResult.status = UIValidationTest_pass?"Pass":"Fail";
					gui_UIVal_Result.testResult.status = UIValStepResult.status;
					UIValStepResult.testCaseStepId = gui_UIVal_TC.testCaseSteps.get(0).testCaseStepId;
					UIValStepResult.screenshotURL = UIValidationZipPath;
					gui_UIVal_Result.testResult.testStepResults.add(UIValStepResult);
					gui_UIVal_Result.testResult.errorScreen = UIValStepResult.screenshotURL;
					qifClient.postGUITestResults(gui_UIVal_Result);
				}
				// Assert the Test Status
				Assert.assertEquals(gui.testResult.status,"Pass","Got Error: " + gui.testResult.error);

			} catch (Exception error) {
				logger.error(error);
				Assert.assertEquals(error.getMessage().length(),0);
			}
			//}));
		//}
		//return guiTests;
	}

	@AfterSuite
	static void tearDown() {
		logger.info("Finishing all the Tests...");
		logger.info(new String(new char[80]).replace("\0", "="));
		//Browser.shutDown();
	}

}
