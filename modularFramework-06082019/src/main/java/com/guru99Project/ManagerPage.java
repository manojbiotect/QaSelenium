package com.guru99Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonPages.BasePage;

public class ManagerPage extends BasePage {
	
	
	@FindBy(xpath="//td[contains(text(),'Manger Id')]")
	
	WebElement MgrText;

	public ManagerPage(WebDriver driver) {
		super(driver);
		
	}
	
	
}



