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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
			guiTestCases = qifClient.getGUITestCases(project.projectId);
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
			Browser.webDriver.manage().window().setSize(new Dimension(browserWidth, browserHeight));
			Browser.webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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

	//@TestFactory
	@Test
	//Iterable<DynamicTest> executeTests() {
	public void QIFTests() throws IOException, ParseException, InterruptedException {

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
		for (TestCaseGUI testCase : guiTestCases) {

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

                               /* ExpectedCondition<Boolean> pageLoadCondition = new
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
                                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ag-overlay-loading-center")));*/
								// Initialize the Objects required to perform actions

                                logger.info("Test Action Name: " + testAction.action.fieldName+ " (" + testAction.action.fieldValue + ")");
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
										Browser.webDriver.findElement(
											By.cssSelector(testAction.action.fieldName)
										).click();
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
										break;
									case "match-text":
										if (!Browser.webDriver.findElement(
											By.cssSelector(testAction.action.fieldName)
										).getText().trim().equals(testAction.action.fieldValue.trim())) {
											stepResult.status = "Fail";
											stepResult.actualResult = "Field (" + testAction.action.fieldName + ")" +
												"does not match the value given (" + testAction.action.fieldValue +
												")";
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
                                        break;
                                    case "scrollup":
                                        // Waiting for Field to be enabled action
                                        JavascriptExecutor jse =(JavascriptExecutor)Browser.webDriver;
                                        jse.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
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
		}
		//return guiTests;
	}

	@AfterSuite
	static void tearDown() {
		logger.info("Finishing all the Tests...");
		logger.info(new String(new char[80]).replace("\0", "="));
		//Browser.shutDown();
	}

}
