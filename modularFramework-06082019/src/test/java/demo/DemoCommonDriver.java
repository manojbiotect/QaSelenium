package demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import commonLibs.implementations.CommonDriver;
import commonLibs.implementations.ScreenshotControl;

public class DemoCommonDriver {
	ScreenshotControl screenshot;
	
	WebDriver driver;
	String filename;
	
	
	@Test
	public void verifyCommonDriver() throws Exception {
		CommonDriver cmnDriver = new CommonDriver("chrome");
		cmnDriver.navigateToFirstUrl("https://qatechhub.com");
		String title = cmnDriver.getTitle();
		System.out.println("Title -"+ title);
		
		driver = cmnDriver.getDriver();
		
		screenshot = new ScreenshotControl(driver);
		
		filename = System.getProperty("user dir") + "/Screenshot/test.jpeg";
		screenshot.captureAndSaveScreenshot(filename);
		
		
		
		cmnDriver.closeAllBrowsers();
		
	}
}
