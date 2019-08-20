package com.guru99.tests;

import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.guru99Project.HomePage;
import com.guru99Project.LoginPage;
import com.guru99Project.ManagerPage;

import commonLibs.implementations.CommonDriver;
import commonLibs.implementations.ScreenshotControl;
import utils.ConfigFileReader;


class BaseTest {
	
	CommonDriver cmnDriver;
	LoginPage loginPage;
	HomePage homePage;
	ManagerPage managerPage;
	
	
	ScreenshotControl screenshotControl;
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extentReport;
	ExtentTest extentTest;
	
	String executionStartTime;
	String currentWorkingDirectory;
	String reportFilename;
	
	Properties configProperty;
	String configFilename;
	

	String baseUrl; 
	String browserType;
	WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite() throws Exception {
		
		intializeExecutionStartTime();
		
		intializeCurrentWorkingDirectory();
		
		intializeConfigProperty();
		
		
		
		initializeExtentReport();

	}

	private void intializeConfigProperty() throws Exception {
		configFilename = String.format("%s/config/config.properties", currentWorkingDirectory);
		configProperty = ConfigFileReader.readConfigProperties(configFilename);
		
	}

	private void initializeExtentReport() {
		reportFilename = String.format("%s/reports/Guru99TestReport_%s.html",currentWorkingDirectory, 
				executionStartTime);
		
		htmlReporter = new ExtentHtmlReporter(reportFilename);
		extentReport = new ExtentReports();
		
		extentReport.attachReporter(htmlReporter);
		
		
	}

	private void intializeCurrentWorkingDirectory() {
		currentWorkingDirectory = System.getProperty("user.dir");

		
	}

	private void intializeExecutionStartTime() {
		Date date = new Date(); 
		executionStartTime = String.valueOf(date.getTime());
		
	}

	@BeforeClass
	public void setup() throws Exception {
		
		extentTest = extentReport.createTest("TC - Setting up the tests");
		
		invokeBrowser();
        
		
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		managerPage= new ManagerPage(driver);
		
		
		initializeScreenshotVariable();
		
		

	}

	private void initializeScreenshotVariable() {
		screenshotControl = new ScreenshotControl(driver);
		
		
	}

	private void invokeBrowser() throws Exception  {
		
		browserType = "chrome";
		
		
		extentTest.log(Status.INFO, "Initializing Browser: "+ browserType);

		cmnDriver = new CommonDriver("Chrome"); 
		
		int pageloadtimeout = 20;
		
		extentTest.log(Status.INFO, "Pageload Timeout: "+ pageloadtimeout);
		cmnDriver.setPageloadTimeout(pageloadtimeout);
		
		int implicitWait = 10;
		
		extentTest.log(Status.INFO, "Pageload Timeout: " + implicitWait);
		cmnDriver.setElementDetectionTimeout(implicitWait);
		


		baseUrl = "http://demo.guru99.com/v4";
        
		extentTest.log(Status.INFO, "URL :" + baseUrl);
        cmnDriver.navigateToFirstUrl(baseUrl);
        
        driver = cmnDriver.getDriver();
		
		
	}

	@AfterClass
	public void cleanUp() throws Exception {
		extentTest = extentReport.createTest("Tc");
		cmnDriver.closeAllBrowsers();
	}
	
	@AfterMethod 
	public void afterATestcase(ITestResult result) throws Exception {
		
		String testcaseName = result.getName();
		
		String filename = String.format("%s/screenshots/%s_%s.jpeg", currentWorkingDirectory, testcaseName,
				executionStartTime);
		
		if (result.getStatus() == ITestResult.FAILURE) {
			screenshotControl.captureAndSaveScreenshot(filename);
			
			extentTest.log(Status.FAIL, "Failed testcase: " + testcaseName);
			
			extentTest.addScreenCaptureFromPath(filename);
		}else if (result.getStatus()== ITestResult.SKIP) {
			
			extentTest.log(Status.SKIP, "Skipped testcase : " + testcaseName);
		}
			
		
	}
	@AfterSuite
	public void postCleanup() {
		extentReport.flush();
	}
	



}
