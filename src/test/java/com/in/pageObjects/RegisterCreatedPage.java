package com.in.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterCreatedPage {
	
	private WebDriver driver;
	private BasePage basePage;
	
	public RegisterCreatedPage(WebDriver driver) {
		this.driver=driver;
		basePage= new BasePage(this.driver);
	}

	//Locator
	By succeedMessage=By.xpath("//p[contains(text(),'Congratulations!')]");
	
	public String getsucceedMessage() {
		return basePage.waitForVisibility(succeedMessage).getText();
	} 
	
}
