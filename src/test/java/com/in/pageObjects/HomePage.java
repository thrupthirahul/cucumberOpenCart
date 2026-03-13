package com.in.pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	//Has-A
	private BasePage basePage;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		basePage= new BasePage(this.driver);
	}
	
	// Locators
	private By myAccount = By.xpath("//a[@title='My Account']");
	private By registerLink=By.xpath("//a[text() ='Register']");
	private By loginLink=By.xpath("//a[normalize-space()='Login']");
	private By myAccountOptions = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li");
	private By searchTextbox = By.xpath("//input[@placeholder='Search']");
	private By searchButton = By.xpath("//span[@class='input-group-btn']");	
	private By shoppingCartLink= By.xpath("//span[normalize-space()='Shopping Cart']");
	

	public void clickOnMyAccount(){
		basePage.click(myAccount);
	}
	
	public List<String> getMyAccountOptions(){
		return  basePage.waitForVisibilityAllElements(myAccountOptions)
				.stream()
				.map(element ->element.getText())
				.collect(Collectors.toList());
	}
	
	public boolean isAccountOptionAvaliable(String searchValue) {
		return getMyAccountOptions()
				.stream()
				.anyMatch(str -> str.equals(searchValue));
	}
	
	public void clickOnRegisterLink() {
		basePage.click(registerLink);
	}
	
	public void clickOnLoginLink() {
		basePage.click(loginLink);
	}
	
	public void enterSearchText(String productName) {
		basePage.type(searchTextbox, productName);
	}

	public void clickOnSearchButton() {
		basePage.click(searchButton);
	}
	
	public void clickOnShoppingCartLink() {
		basePage.click(shoppingCartLink);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}