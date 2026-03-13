package com.in.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	private BasePage basePage;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		basePage= new BasePage(this.driver);
	}
	
	// Locators
	private By usernameTextField = By.id("input-email");
	private By passwordTextField = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By validAlertMessage = By.cssSelector("div.alert");
	private By homepageIcon = By.cssSelector("a[href*='route=common/home']");
	
	
	
	public void enterUsername(String username) {
		
		WebElement webElement = basePage.waitForVisibility(usernameTextField);
		webElement.clear();
		webElement.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		WebElement webElement = basePage.waitForVisibility(passwordTextField);
		webElement.clear();
		webElement.sendKeys(password);
	}
	
	public void clickLogin() {
		basePage.click(loginButton);
	}
	
	public String getAlertMessage() {
		return basePage.waitForVisibility(validAlertMessage).getText();
	}
	
	public void clickHomeIcon() {
		basePage.click(homepageIcon);
	}
}