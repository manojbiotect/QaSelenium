package com.guru99Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonPages.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(xpath="//marquee[@class='heading3']")
				
	WebElement welcomeText;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getWelcomeText() throws Exception {
		
		return elementControl.getText(welcomeText);
	}
	


}
