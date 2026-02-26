package com.in.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver,Duration.ofSeconds(10));
	}
	
	// Locators
	private By myAccount = By.xpath("//a[@title='My Account']");
	private By loginLink=By.xpath("//a[normalize-space()='Login']");
	private By myAccountOptions = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li");
	private By searchTextbox = By.xpath("//input[@placeholder='Search']");
	private By searchButton = By.xpath("//span[@class='input-group-btn']");	
	

	private WebElement getElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	private List<WebElement> getElements(By locator) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	private WebElement getClickableElement(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void clickOnMyAccount(){
		getClickableElement(myAccount).click();
	}
	

	public List<String> getMyAccountOptions(){
		return  getElements(myAccountOptions)
				.stream()
				.map(element ->element.getText())
				.collect(Collectors.toList());
	}
	
	public boolean isAccountOptionAvaliable(String searchValue) {
		return getMyAccountOptions()
				.stream()
				.anyMatch(str -> str.equals(searchValue));
	}
	
	public void clickOnLoginLink() {
		getClickableElement(loginLink).click();
	}
	
	public void enterSearchText(String productName) {
		getElement(searchTextbox).sendKeys(productName);
	}

	public void clickOnSearchButton() {
		getClickableElement(searchButton).click();
	}
}