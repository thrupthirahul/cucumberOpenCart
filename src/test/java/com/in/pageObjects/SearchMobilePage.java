package com.in.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchMobilePage {
	
	WebDriver driver;

	public SearchMobilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@name='category_id']")
	private WebElement categoriesDropdown;
	
	@FindBy(xpath="//input[@id='description']")
	private WebElement checkBox;
	
	
	@FindBy(xpath="//input[@id='button-search']")
	private WebElement searchButton;
	
	
	@FindBy(xpath="//img[@title='iPhone']")
	private WebElement iphone;

	@FindBy(xpath="//p[starts-with(text(),'There')]")
	private WebElement productNotFoundMeassage;

	public WebElement searchcategoriesDropdown() {
		return categoriesDropdown;
	}
	
	public WebElement searchCheckBox() {
		return checkBox;
	}
	public WebElement searchIphone() {
		return iphone;
	}
	
	public WebElement searchButton() {
		return searchButton;
	}
	
	public WebElement productNotFoundMessage() {
		return productNotFoundMeassage;
	}
	
}
