package com.in.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.in.pageObjects.LoginPage;
import com.in.utilites.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class CommonSteps {
	
	WebDriver driver;
	WebDriverWait wait;
	LoginPage loginPage;
	

	public CommonSteps() {
		driver=WebDriverManager.getLocalThreadDriver();
		wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@Then("verify navigate back to home page")
	public void verify_navigate_back_to_home_page() {
		System.out.println("CommonSteps.verify_navigate_back_to_home_page()");
		wait.until(ExpectedConditions.titleIs("Your Store"));
		Assert.assertEquals(driver.getTitle(), "Your Store");
	}
	
	@And("click on home page button")
	public void click_on_home_page_button() {
		loginPage = new LoginPage(driver);
		WebElement homeIcon = wait.until(ExpectedConditions.elementToBeClickable(loginPage.homepageIcon()));
		homeIcon.click();		
	}
	
}
