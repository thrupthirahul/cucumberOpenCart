
package com.in.stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.in.pageObjects.HomePage;
import com.in.pageObjects.RegisterAccountPage;
import com.in.pageObjects.RegisterCreatedPage;
import com.in.utilites.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class RegisterFeatureStepDefinations {

	WebDriver driver;
	HomePage homePage;
	RegisterAccountPage registerPage;
	RegisterCreatedPage registerCreatedPage;

	public RegisterFeatureStepDefinations() {
		driver= new WebDriverManager().getLocalThreadDriver();
	}

	@And("click Register option")
	public void click_Register_option() {
		homePage= new HomePage(driver);
		homePage.clickOnRegisterLink();
	}

	@And("enter firstname {string}")
	public void enter_firstname(String firstname) {
		registerPage= new RegisterAccountPage(driver);
		registerPage.enterFirstName(firstname);
	}

	@And("enter lastname {string}")
	public void enter_lastname(String lastname) {
		registerPage.enterLastName(lastname);
	}

	@And("enter email {string}")
	public void enter_email(String email) {

		String finalEmail = email;

		if(email.contains("user")) {
			finalEmail = email.substring(0, email.indexOf("@"))
					+ System.currentTimeMillis() + "@"
					+ email.substring(email.indexOf("@") + 1);
		}

		registerPage.enterEmail(finalEmail);

	}

	@And("enter telephone {string}")
	public void enter_telephone(String telephone) {
		registerPage.enterTelephone(telephone);
	}

	@And("enter password {string}")
	public void enter_password(String password) {
		registerPage.enterPassword(password);
	}

	@And("enter confirmPassword {string}")
	public void enter_confirmPassword(String confirmPassword) {
		registerPage.enterConfirmPassword(confirmPassword);
	}

	@And("click Subscribe")
	public void click_subscribe() {
		registerPage.clickSubcribleYes();
	}

	@And("click PolicyOption")
	public void click_policyOption() {
		registerPage.clickOnPolicyCheckBox();
	}

	@And("click continue button1")
	public void click_continue_button1() {
		registerPage.clickOnContinueBtn();
	}

	@Then("Verify Message {string}")
	public void verify_message(String expectedMessage) {

		if(expectedMessage.contains("Warning:")) {
			assertEquals(registerPage.getWaringMessage(), expectedMessage);
		}
		registerCreatedPage= new RegisterCreatedPage(driver);

		if(expectedMessage.contains("Congratulations!")) {
			Assert.assertEquals(registerCreatedPage.getsucceedMessage(), expectedMessage);
		}
	}
}