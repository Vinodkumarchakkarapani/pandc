package com.PandC.lib;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.File;
import java.nio.file.Paths;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

//import net.

/**
 * Library Class for Browser Interactions using Selenium WebDriver
 */
public class Browser {

	public static WebDriver webDriver;
	//public BrowserMobProxyServer proxy;

	/**
	 * Initialize the Web Driver for the Browser
	 *
	 * @param driver Browser to be used as the Web Driver
	 */
	public static void initialize(String driver) throws Exception {
		switch (driver.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				//webDriver = new ChromeDriver();
				//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe");


				/*proxy = new BrowserMobProxyServer();
				proxy.start();

				Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
				try {
					String hostIp = Inet4Address.getLocalHost().getHostAddress();
					seleniumProxy.setHttpProxy(hostIp + ":" + proxy.getPort());
					seleniumProxy.setSslProxy(hostIp + ":" + proxy.getPort());
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}

				DesiredCapabilities seleniumCapabilities = new DesiredCapabilities();
				seleniumCapabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
				ChromeOptions options = new ChromeOptions();
				options.merge(seleniumCapabilities);
				webDriver = new ChromeDriver(options);

				proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);*/


				webDriver = new ChromeDriver();
				break;
			case "chrome-headless":
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");
				WebDriverManager.chromedriver().setup();
				webDriver = new ChromeDriver(chromeOptions);
				break;
			case "firefox":

				WebDriverManager.firefoxdriver().setup();
				webDriver = new FirefoxDriver();
				break;
			case "firefox-headless":
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addArguments("--headless");
				WebDriverManager.firefoxdriver().setup();
				webDriver = new FirefoxDriver(firefoxOptions);
				break;
			case "edge":
				//WebDriverManager.edgedriver().version("5.16299").forceDownload();
				WebDriverManager.edgedriver().setup();

				//webDriver = new EdgeDriver();
				//System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\src\\drivers\\MicrosoftWebDriver.exe");
				//System.out.println("edge path:" + System.getProperty("webdriver.ie.driver"));
				webDriver = new EdgeDriver();
				break;
			case "headless":
				WebDriverManager.phantomjs().setup();
				webDriver = new PhantomJSDriver();
				break;
			default:
				throw new Exception("Unsupported Browser (" + driver + ") has been provided.");
		}
	}

	/**
	 * Take a Screen Shot from the Browser
	 *
	 * @param name Name of the Screen Shot File
	 * @param path Path of the Screen Shots Folder
	 * @return Full Path of the Screen Shot File
	 */
	public static File takeScreenShot(String name, String path) {
		try {
			String rootPath = System.getProperty("user.dir");
			File screenShot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
			File targetFile = Paths.get(rootPath, path, name + ".png").toFile();
			FileUtils.copyFile(screenShot, targetFile);
			return targetFile;
		} catch (Exception error) {
			return null;
		}
	}

	/**
	 * Shut down the Web Driver for the Browser
	 */
	public static void shutDown() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}

}
