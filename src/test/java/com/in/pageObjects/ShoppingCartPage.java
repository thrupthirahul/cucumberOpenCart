package com.in.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
	
	private WebDriver driver;
	private BasePage basePage;
	
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		basePage = new BasePage(this.driver);
	}
	
	//Locator
	By continueButton= By.xpath("//a[normalize-space()='Continue']");
	By total=By.xpath("//div[@class='col-sm-4 col-sm-offset-8']//table[@class='table table-bordered']//tr[4]//td[1]");
	By amount=By.xpath("//div[@class='col-sm-4 col-sm-offset-8']//table[@class='table table-bordered']//tr[4]//td[2]");
	
	public void clickOnContinueButton() {
		basePage.click(continueButton);
	}
	
	public String getTotalAmount() {
		return basePage.waitForVisibility(amount).getText();
	}
	

}
