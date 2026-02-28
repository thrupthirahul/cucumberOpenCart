package com.in.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchMobilePage {
	
	private WebDriver driver;
	private BasePage basePage;

	public SearchMobilePage(WebDriver driver) {
		this.driver=driver;
		basePage=new BasePage(this.driver);
	
	}
	
	By categoriesDropdown=By.xpath("//select[@name='category_id']");
	By checkBox=By.xpath("//input[@id='description']");
	By searchButton=By.xpath("//input[@id='button-search']");
	By iphone=By.xpath("//img[@title='iPhone']");
	By productNotFoundMeassage=By.xpath("//p[starts-with(text(),'There')]");

	
	private Select getDropDownElement() {
		return new Select(basePage.waitForVisibility(categoriesDropdown));
	}
	
	public void searchIteamOnDropdown(String product) {
		getDropDownElement().selectByVisibleText(product);
	}
	
	public void searchProductItem(String value) {
		basePage.type(checkBox, value);
		
	}
	public void clickOnCheckBox() {
		basePage.click(checkBox);
	}
	
	public void clickOnSearchButton() {
		basePage.click(searchButton);
	}
	
	public boolean viewProduct() {
		return basePage.waitForVisibility(iphone).isDisplayed();
	}
	
	public String productNotFoundMessage() {
		return basePage.waitForVisibility(productNotFoundMeassage).getText();
	}
	
}
