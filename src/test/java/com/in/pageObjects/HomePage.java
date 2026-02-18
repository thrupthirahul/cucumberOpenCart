package com.in.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//li")
	private List<WebElement> MyAccountOptions;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchTextbox;
	
	@FindBy(xpath="//span[@class='input-group-btn']")
	private WebElement searchButton;
	
	
	public WebElement searchMyAccountDropDown() {
		return myAccount;
	}
	
	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	public List<WebElement> seachMyAccountOptions(){
		return MyAccountOptions;
	}
	
	public WebElement seachTextbox(){
		return searchTextbox;
	}
	public WebElement seachButton(){
		return searchButton;
	}
	
}
