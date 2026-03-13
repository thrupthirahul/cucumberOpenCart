package com.in.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.in.pageObjects.HomePage;
import com.in.pageObjects.LoginPage;
import com.in.pageObjects.LogoutPage;
import com.in.pageObjects.MyAccountPage;
import com.in.utilites.WebDriverManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeatureStepDefinitions {

	private  WebDriver driver;
	private  HomePage homePage;
	private  LoginPage loginPage;
	private  MyAccountPage myAccountPage;
	private  LogoutPage logoutPage;
	
	{
		
		driver= new WebDriverManager().getLocalThreadDriver();
	}
	

	@When("click on My Account option")
	public void click_on_my_account_option() {
		System.out.println("StepDefinitions.click_on_my_account_option()");
		homePage= new HomePage(driver);	
		System.out.println("click on myAccount");
		homePage.clickOnMyAccount();
		System.out.println("click on myAccount Successfully");
		System.out.println("MyAccountOptions:" +homePage.getMyAccountOptions());
		
	}

	@When("click on {string} option")
	public void click_on_LoginOption_option(String option) {
	   System.out.println("StepDefinitions.click_on_login_option()");
	   System.out.println("click on login");
	   homePage.clickOnLoginLink();
	   System.out.println("click on login successfully");
	   	   
	}

	@When("enter {string} and {string}")
	public void enter_username_and_password(String username, String password) {
		System.out.println("StepDefinitions.enter_username_and_password()");
		loginPage=new LoginPage(driver);
		
		System.out.println("enter username");
		loginPage.enterUsername(username);
		
		System.out.println("enter password");
		loginPage.enterPassword(password);
		
	}

	@When("click on login button")
	public void click_on_login_button() {
		System.out.println("StepDefinitions.click_on_login_button()");
		System.out.println("click on login button");
		loginPage.clickLogin();
		System.out.println("login button clicked sucessfully");
	}

	@When("click on logout button")
	public void click_on_logout_button() {
		System.out.println("StepDefinitions.click_on_logout_button()");
		myAccountPage= new MyAccountPage(driver);
		System.out.println("List Group: "+myAccountPage.getListGroups());
		
		System.out.println("click on logout button");
		myAccountPage.clickOnListOfValue("Logout");
		System.out.println("logout button clicked sucessfully");
	}

	@When("click on continue button")
	public void click_on_continue_button() {
		System.out.println("StepDefinitions.click_on_continue_button()");
		logoutPage= new LogoutPage(driver);
		logoutPage.clickOnContinueButton();
		
	}

	@Then("verify message {string}")
	public void verify_message(String expectedMessage) {		
		String alertMessage = loginPage.getAlertMessage();
		System.out.println("Alert Message: "+alertMessage);
	}
}
