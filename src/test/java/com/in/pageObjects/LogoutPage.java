package com.in.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	private WebDriver driver;

	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[contains(@class,'btn btn-primary')]")
	private WebElement continueButton;
	
	public WebElement searchContinueButton(){
		return continueButton;
	}
	
	public void clickOnElement(WebElement element) {
		element.click();
	}

}
