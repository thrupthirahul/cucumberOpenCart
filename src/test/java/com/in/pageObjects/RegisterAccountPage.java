package com.in.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAccountPage {
	
	private WebDriver driver;
	private BasePage basePage;

	public RegisterAccountPage(WebDriver driver) {
		this.driver=driver;
		basePage= new BasePage(this.driver);
	}

	//Locator
	By firstNameField=By.id("input-firstname");
	By lastNameField=By.id("input-lastname");
	By emailField=By.id("input-email");
	By telephoneField=By.id("input-telephone");
	By passwordField=By.id("input-password");
	By confirmPasswordField=By.id("input-confirm");
	By subcrible=By.xpath("//label[normalize-space()='Yes']");
	By policyCheckBox=By.xpath("//input[@type='checkbox' and @name='agree']");
	By continueBtn=By.xpath("//input[@value='Continue']");
	By warningMessage=By.xpath("//div[contains(@class,'alert alert-danger')]");

	
	public void enterFirstName(String firstname) {
		basePage.type(firstNameField, firstname);
	}
	
	public void enterLastName(String Lastname) {
		basePage.type(lastNameField, Lastname);
	}
	
	public void enterEmail(String email) {
		basePage.type(emailField, email);
	}
	
	public void enterTelephone(String telephoneNumber) {
		basePage.type(telephoneField, telephoneNumber);
	}
	
	public void enterPassword(String password) {
		basePage.type(passwordField, password);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		basePage.type(confirmPasswordField,confirmPassword);
	}
	
	public void clickSubcribleYes() {
		basePage.click(subcrible);
	}
	
	public void clickOnPolicyCheckBox() {
		basePage.click(policyCheckBox);
	}
		
	public void clickOnContinueBtn() {
		basePage.click(continueBtn);
	}
	
	public String  getWaringMessage() {
		return basePage.waitForVisibility(warningMessage).getText();
	}

}
