package com.guru99Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementations.ElementControl;
import commonPages.BasePage;

public class LoginPage extends BasePage {

	@CacheLookup
	@FindBy(name = "uid")
	private WebElement UserID;

	@CacheLookup
	@FindBy(name = "password")
	private WebElement Password;

	@FindBy(xpath = "//input[@name='btnLogin']")
	private WebElement loginButton;

	@FindBy(xpath = "//input[@name='btnReset']")
	private WebElement resetButton;

	private ElementControl elementControl;

	public LoginPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);

		elementControl = new ElementControl();

	}

	public void userLogin(String sUsername, String sPassword) throws Exception {


		elementControl.setText(UserID, sUsername);
		elementControl.setText(Password, sPassword);
		elementControl.clickElement(loginButton);

	}

}
