package com.in.stepDefinitions;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.in.pageObjects.HomePage;
import com.in.pageObjects.LoginPage;
import com.in.pageObjects.LogoutPage;
import com.in.pageObjects.MyAccountPage;
import com.in.utilites.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinitions {
	
	private  WebDriver driver;
	private  Properties props;
	private  HomePage homePage;
	private  LoginPage loginPage;
	private  MyAccountPage myAccountPage;
	private  LogoutPage logoutPage;
	private  WebDriverWait wait;
	
	{
		System.out.println("StepDefinitions.enclosing_method()");
		try(FileInputStream fis= new FileInputStream("src/test/java/com/in/properties/properties.properties");
				){
				props= new Properties();
				props.load(fis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
			
	}
	@Given("open broswer with url")
	public void open_broswer_with_url() throws Exception{
		System.out.println("StepDefinations.openBroswer()");
		driver=WebDriverManager.getLocalThreadDriver();	
		driver.manage().window().maximize();
		driver.get(props.getProperty("url"));
		wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@When("click on My Account option")
	public void click_on_my_account_option() {
		System.out.println("StepDefinitions.click_on_my_account_option()");
		homePage= new HomePage(driver);		
		WebElement searchMyAccountOption = wait.until(ExpectedConditions.elementToBeClickable(homePage.searchMyAccountDropDown()));	
		homePage.clickOnElement(searchMyAccountOption);
	  
	}

	@When("click on {string} option")
	public void click_on_LoginOption_option(String login) {
	   System.out.println("StepDefinitions.click_on_login_option()");
	   List<WebElement> myAccountOptions = homePage.seachMyAccountOptions();
	   
	   for(WebElement option:myAccountOptions) {
		   if(option.getText().equals(login)) {
			   option.click();
			   break;
		   }
	   }
	   
	}

	@When("enter {string} and {string}")
	public void enter_username_and_password(String username, String password) {
		System.out.println("StepDefinitions.enter_username_and_password()");
		loginPage=new LoginPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.searchUsernameTextField())).sendKeys(username);
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.searchPasswordTextField())).sendKeys(password);
		
	}

	@When("click on login button")
	public void click_on_login_button() {
		System.out.println("StepDefinitions.click_on_login_button()");
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.searchLoginButton())).click();
	}

	@When("click on logout button")
	public void click_on_logout_button() {
		System.out.println("StepDefinitions.click_on_logout_button()");
		myAccountPage= new MyAccountPage(driver);
		boolean clicked=false;
		
		for(WebElement list:wait.until(ExpectedConditions.visibilityOfAllElements(myAccountPage.getListGroup()))) {
			wait.until(ExpectedConditions.elementToBeClickable(list));
			if(list.getText().equals("Logout")) {
				list.click();
				clicked=true;
				break;
			}
			
		}
		
		if(clicked) {
			System.out.println("Logout button clicked");
		}
	}

	@When("click on continue button")
	public void click_on_continue_button() {
		System.out.println("StepDefinitions.click_on_continue_button()");
		logoutPage= new LogoutPage(driver);
		WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(logoutPage.searchContinueButton()));
	    logoutPage.clickOnElement(continueButton);
	}

	
	@Then("verify message {string}")
	public void verify_message(String expectedMessage) {
		
		String actualMessage = wait.until(ExpectedConditions.elementToBeClickable(loginPage.searchNormalAlertMessage())).getText();
		Assert.assertEquals(expectedMessage, actualMessage);
	}
	
}
