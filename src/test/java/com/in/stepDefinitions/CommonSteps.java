package com.in.stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.in.pageObjects.HomePage;
import com.in.pageObjects.LoginPage;
import com.in.utilites.LoadPropertiesFile;
import com.in.utilites.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonSteps {
	
	WebDriver driver;
	Properties props;
	
	public CommonSteps() {
		driver= new WebDriverManager().getLocalThreadDriver();
		props=LoadPropertiesFile.loadFile();
	}
	
	@Given("open broswer with url")
	public void open_broswer_with_url() throws Exception{
		System.out.println("StepDefinations.openBroswer()");
		driver.get(props.getProperty("url"));
	}
	
	
	
	@Then("verify navigate back to home page")
	public void verify_navigate_back_to_home_page() {
		System.out.println("CommonSteps.verify_navigate_back_to_home_page()");
		assertTrue(new HomePage(driver).getTitle().contains("Your Store"));
	
	}
	
	@And("click on home page button")
	public void click_on_home_page_button() {
		new LoginPage(driver).clickHomeIcon();		
	}
	
}
