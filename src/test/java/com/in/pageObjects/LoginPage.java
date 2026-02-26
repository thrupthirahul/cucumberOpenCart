package com.in.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// Locators
	private By usernameTextField = By.id("input-email");
	private By passwordTextField = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By validAlertMessage = By.cssSelector("div.alert");
	private By homepageIcon = By.cssSelector("a[href*='route=common/home']");
	
	// Private Reusable Methods
	private WebElement getElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	private WebElement getClickableElement(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	// Action Methods
	public void enterUsername(String username) {
		WebElement element = getElement(usernameTextField);
		element.clear();
		element.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		WebElement element = getElement(passwordTextField);
		element.clear();
		element.sendKeys(password);
	}
	
	public void clickLogin() {
		getClickableElement(loginButton).click();
	}
	
	public String getAlertMessage() {
		return getElement(validAlertMessage).getText();
	}
	
	public void clickHomeIcon() {
		getClickableElement(homepageIcon).click();
	}
}