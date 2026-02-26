package com.in.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}
	
	private By listGroup=By.xpath("//div[@class='list-group']//a");
	
	private WebElement getElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	private List<WebElement> getElements(By locator) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	private WebElement getClickableElement(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
		
	public List<String> getListGroups(){
		return getElements(listGroup).stream()
				.map(listGroup -> listGroup.getText())
				.collect(Collectors.toList());
	}
	
	public void clickOnListOfValue(String value) {
		
		getElements(listGroup).stream()
			.filter(element -> element.getText().equals(value))
			.forEach(element -> element.click());
	}
	
}
