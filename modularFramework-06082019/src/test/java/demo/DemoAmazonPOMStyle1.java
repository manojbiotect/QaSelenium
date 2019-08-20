package demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonLibs.implementations.CommonDriver;
import designPackage.AmazonHomePageStyle1;

public class DemoAmazonPOMStyle1 {
	CommonDriver cmnDriver;
	AmazonHomePageStyle1 homepage;

	WebDriver driver;

	@BeforeClass
	public void setup() throws Exception {

		cmnDriver = new CommonDriver("Chrome");

		cmnDriver.setPageloadTimeout(20);

		cmnDriver.setElementDetectionTimeout(10);

		cmnDriver.navigateToFirstUrl("https://amazon.com");

		driver = cmnDriver.getDriver();

	}

	@Test
	public void verifyProduct() throws Exception {
		homepage = new AmazonHomePageStyle1(driver);

		homepage.searchProduct("Apple Watch", "Electronics");
	}

}
