package com.PandC.tests;

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

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * Testing Class for GUI Tests (Front-end Testing)
 */
public class WebTest {

	private static Logger logger;
	private static SimpleDateFormat fileFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
	private static Configuration config;
	private static boolean isSetUp = true;
	private static QIFClient qifClient;
	private static Project project;
	private static List<TestCaseGUI> guiTestCases = new ArrayList<>();

	@BeforeSuite
	static void setUp() {
		// Specify the list of selected tests to execute and this is applicable only if app.gui.executeselectedTCs is set to true
	    List<String> listOfTCstoExecute = Arrays.asList(
	            "1. PS001 - To verify user navigates to Insurance Renewal List dashboard on clicking Request For Renewal Tile in home page",
                //"15. PS015 - Verify user is able enter details in Cover Page and navigate to Insured Names tab"
                //"30. PS026 - Verify user is able to download the template, by clicking on Template button"
				//"29. PS030 - Verify the proposed date displayed in Insured Name tab is same as the proposed date in the Cover page tab"
				//"31. PS028 - Verify user is displayed error message Please upload file in .xls or .xlsx format only when user tries to upload file of other extension"
                //"12. PS014 - Verify user is displayed General Information page along with - \"Cover Page” as default",
                //"13. PS024 - Verify user is navigated to Insurance Renewal List page on clicking cancel Button on Cover page"
				//"14. PS023 - Verify user is displayed the message - \"Please enter the fields marked as mandatory to continue further.” When user clicks on Continue button without entering the mandatory fields in Cover Page"
				//"16. PS016 - Verify the user is not able to attach multiple files same time in Cover Page",
				//"17. PS034 - Verify user is directed back to Insurance Renewal List page on clicking Save and Close Button on Named Insured Tab",
				//"18. PS027 - Verify user is able to Import a file in \".xls or .xlsx format\" by clicking browse button and then clicking on import button in the downloaded Template format",
				//"19. PS032 - Verify user is able to add another row of details in Name Insured grid by clicking on add Row"
				//"20. PS031 - Verify user is able to add details in Named Insured grid by clicking on Add Row"
				//"22. PS018 - Verify user is not able to upload more than 10 files and displayed the message - Maximum 10 files can be uploaded",
				//"21. PS036 - Verify User is able to enter details in Premium & Loss History Tab",
				//"23. PS037 - To verify user navigates to Property Exposure Tab and Property (Statement of Values) tab is displayed as default"
//				"24. PS017 - Verify user is able to uncheck and delete the uploaded document",
//				"25. PS019 - Verify user is displayed the message - \"Invalid file name. File name should not contain special characters like ~ ` ! @ # $ % ^ & * ( ) + = { } | [ ] : \" ; < > ? , /\" when user uploads a file with special characters",
//				"26. PS020 - Verify user is displayed the message - \"File Size Exceeds the maximum size (5 MB)\" when user uploads a file more than 5 mb",
//				"27. PS021 - Verify user is displayed the message - \"Duplicate files are not allowed. A file with same name exists!\" when user uploads a duplicate file",
//				"28. PS022 - Verify user is displayed the message - \"Invalid file extension. Only “.pdf”, “.xls, “.xlsx” ,“ .doc .docx” file extensions are supported.\" when user uploads a file other than supported extensions",
				//"29. PS030 - Verify the proposed date displayed in Insured Name tab is same as the proposed date in the Cover page tab"
				//"30. PS026 - Verify user is able to download the template, by clicking on Template button"
//				"31. PS028 - Verify user is displayed error message Please upload file in .xls or .xlsx format only when user tries to upload file of other extension",
//				"32. PS038 - To verify user is able to Import the file and fill the details with the imported file in Property (Statement of Values) tab",
//				"33. PS046 - To verify user is able to add comment under Coverage Requirement in Property (Statement of Values) tab",
//				"34. PS042 - PS042To verify user is able to enter the details in Property (Statement of Values) tab and navigate to BI Worksheet tab"
//				"8. PS005 - Verify Delete option is displayed only for the records in “Draft” status in the grid",
//				"9. PS013 - Verify user is able to search a record by Status",
				"21. PS026 - Verify user is able to download the template, by clicking on Template button",
				//"22. PS028 - Verify user is displayed error message Please upload file in .xls or .xlsx format only when user tries to upload file of other extension"
				"50. PS078 - To verify user is able to enter the details For Estimated Exposure for General Liability for the Policy Period Noted Below in Revenue & Liability Limits tab",

				"30. PS036 - Verify User is able to enter details in Premium & Loss History Tab",
				"32. PS038 - To verify user is able to Import the file and fill the details with the imported file in Property (Statement of Values) tab",
				"33. PS046 - To verify user is able to add comment under Coverage Requirement in Property (Statement of Values) tab",
				"34. PS042 - To verify user is able to enter the details in Property (Statement of Values) tab and navigate to BI Worksheet tab",
				"35. PS049 - To verify user is able to enter the details in BI Worksheet page",
				"36. PS050 - To verify user is able to add another Location by clicking on Add Location Button in BI Worksheet Tab and navigate to Contingent BI/ Dependent tab",
				"37. PS055 - To verify user is able to Import the file and fill the details with the imported file in Contingent BI/ Dependent tab",
				"38. PS058 - To verify user is able to enter the details in Contingent BI/ Dependent tab and Navigate to Crime Tab",
				"39. PS063 - To verify user is able to enter the details in Program structure in Crime Tab",
				"40. PS064 - To verify user is able to enter the details in General Questions in Crime Tab",
				"41. PS065 - To verify user is able to enter the details in Crime-Controls & Underwriting question in Crime Tab",
				"42. PS066 - To verify user is able to enter the details in Coverage requirements in Crime Tab and Navigate to Transit/Cargo/Stock throughput tab",
				"43. PS068 - To verify user is able to enter the details For Description of Products, Sales, Description of how Products are Packaged, Annual Values Shipped in Transit/Cargo/Stock Throughput tab",
				"44. PS069 - To verify user is able to enter the details For Incoming shipment in Transit/Cargo/Stock Throughput tab",
				"45. PS070 - To verify user is able to enter the details For Outgoing shipment in Transit/Cargo/Stock Throughput tab",
				"46. PS071 - To verify user is able to enter the details For Program structure in Transit/Cargo/Stock Throughput tab",
				"47. PS072 - To verify user is able to enter the details For Coverage notes in Transit/Cargo/Stock Throughput tab and navigate to Spoilage",
				"48. PS075 - To verify user is able to enter the details For Chubb Group in Spoilage tab",
				"49. PS076 - To verify user is able to enter the details For Travelers Lloyds Insurance Company in Spoilage tab and navigate to Casualty Exposures"

        );
		// Get the Logger and Configuration details
		logger = LogManager.getLogger("WebTest");
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
				config.qif.getProperty("qif.user.password")
			);

			logger.info("Getting the Project Details from QIF...");
			project = qifClient.getProject(config.qif.getProperty("qif.project.gui"));

			logger.info("Getting all the GUI Test Cases for the Project (" + project.projectName + ") from QIF...");
			guiTestCases = qifClient.getGUITestCases(project.projectId,false,null);
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
				Integer leftSerial = Integer.parseInt(
					leftCase.description.substring(0, leftCase.description.indexOf(".")));
				Integer rightSerial = Integer.parseInt(
					rightCase.description.substring(0, rightCase.description.indexOf(".")));
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
							// Initialize the Objects required to perform actions

							logger.info("Test Action Name: " + testAction.action.fieldName+ " (" + testAction.action.fieldValue + ")."+testAction.action.actionType);
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
                                        for (String echFile:testAction.action.fieldName.trim().split(" ")) {
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
									File file = new File(System.getProperty("user.home") + "\\Downloads\\"+testAction.action.fieldValue);
									if(file.delete())
									{
										System.out.println("File deleted successfully");
									}
									else
									{
										System.out.println("Failed to delete the file");
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
						stepResult.actualResult = testStep.expectedResult;
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
