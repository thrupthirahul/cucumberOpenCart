package com.in.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourStorePage {
	
	private WebDriver driver;
	private BasePage basePage;
	
	
	public YourStorePage(WebDriver driver) {
		this.driver = driver;
		basePage = new BasePage(this.driver);
	}
	
	//Locator
	By addToCart= By.xpath("//div[@id='content']//div[1]//div[1]//div[3]//button[1]//span[1]");
	By amountAddToCart=By.xpath("//div//button[@aria-expanded='false']");
	By amountAddToCartText= By.xpath("//span[@id='cart-total']");
	By viewCart=By.xpath("//strong[normalize-space()='View Cart']");
	
	public void clickAddToCart() {
		basePage.click(addToCart);
	}
	
	public void clickOnAddAmounToTheCart() {
		basePage.click(amountAddToCartText);
	}
	
	public void clickOnViewCart() {
		basePage.click(viewCart);
	}
	
	
	

}
