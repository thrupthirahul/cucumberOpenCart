package com.in.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private WebDriver driver;
	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public WebElement waitForVisibility(By locator) {

		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		catch (RuntimeException e) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", driver.findElement(locator));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
	}

	public void click(By locator) {
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		}catch(RuntimeException e) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(locator));
		}
	}

	public void type(By locator, String text) {
		WebElement element = waitForVisibility(locator);
		element.clear();
		element.sendKeys(text);
	}

	public List<WebElement> waitForVisibilityAllElements(By locator) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
}
