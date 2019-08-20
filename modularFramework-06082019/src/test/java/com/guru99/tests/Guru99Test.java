package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Guru99Test extends BaseTest {

	@Test(priority = 0)
	public void verifyTitleOfThePage() throws Exception {

		extentTest = extentReport.createTest("TC- Verify Title of the page");

		String actualTitle = cmnDriver.getTitle();

		extentTest.log(Status.INFO, "Actual Title : " + actualTitle);
		String expectedTitle = "Guru99 Bank Home Page";

		extentTest.log(Status.INFO, "Expected Title : " + expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Parameters({"username", "password"})
	
	@Test(priority = 2000)
	public void verifyUserLogin(String sUsername, String sPassword) throws Exception {
		extentTest = extentReport.createTest("TC- Verify User login");

		loginPage.userLogin(sUsername, sPassword);

		String expectedWelcomeText = "Welcome To Manager's Page of Guru99 Bank";
		String actualWelcomeText = homePage.getWelcomeText();

		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);

	}
	
	@Test(priority = 1000)
	public void verifyManagerId() throws Exception {

		extentTest = extentReport.createTest("TC- Verify Manager id of the page");

		String actualMgrTitle  = cmnDriver.getTitle();

//		extentTest.log(Status.INFO, "Actual Title : " + actualmgrTitle);
//		String expectedmgrTitle = "Manger Id : mngr216340";
//		extentTest.log(Status.INFO, "Expected Title : " + expectedmgrTitle);
		
		
		String expectedMgrTitle = "Welcome To Manager's Page of Guru99 Bank";
		String actualMgrTitle1 = homePage.getWelcomeText();
		
		
		Assert.assertEquals(actualMgrTitle1, expectedMgrTitle);

	}


	}
