package com.in.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebElement driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement usernametextfield;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordtextfield;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	
	@FindBy(xpath="//div[ contains(@class,'alert')]")
	private WebElement normalAlertMessage;
	
	@FindBy(css="a[href*='route=common/home']")
	private WebElement homepageIcon;
	
	public WebElement searchUsernameTextField() {
		return usernametextfield;
	}
	public WebElement searchPasswordTextField() {
		return passwordtextfield;
	}
	public WebElement searchLoginButton() {
		return loginButton;
	}

	public WebElement searchNormalAlertMessage() {
		return normalAlertMessage;
	}
	
	public WebElement homepageIcon() {
		return homepageIcon;
	}
	
}
