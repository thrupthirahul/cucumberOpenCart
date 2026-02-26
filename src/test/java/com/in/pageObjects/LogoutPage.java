package com.in.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
	
	private WebDriver driver;
	private WebDriverWait wait;

	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}
	
	private By continueButton=By.xpath("//a[contains(@class,'btn btn-primary')]");
	
	private WebElement getElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	private WebElement getClickableElement(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void clickOnContinueButton() {
		getClickableElement(continueButton).click();
	}
}
