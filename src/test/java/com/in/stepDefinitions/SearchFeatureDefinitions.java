package com.in.stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.in.pageObjects.HomePage;
import com.in.pageObjects.SearchMobilePage;
import com.in.utilites.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class SearchFeatureDefinitions {

	WebDriver driver;
	HomePage homePage;
	SearchMobilePage searchMobilePage;

	public SearchFeatureDefinitions() {
		driver= new WebDriverManager().getLocalThreadDriver();
		
	}

	@When("search for Product {string}")
	public void search_for_product(String product) {
		homePage= new HomePage(driver);
		homePage.enterSearchText(product);

	}

	@And("click on home search button")
	public void click_on_home_search_button() {
		homePage.clickOnSearchButton();
	}

	@And("click and selected {string} from dropdown")
	public void select_from_dropdown(String option) {
		searchMobilePage = new SearchMobilePage(driver);
		
		if(!(option.isEmpty() || option.isBlank())) {
			searchMobilePage.searchIteamOnDropdown(option);
		}
		
	}

	@And("checked the check box")
	public void checked_the_check_box() {
		searchMobilePage.clickOnCheckBox();
	}

	@And("click on search button")
	public void click_on_search_button() {
		searchMobilePage.clickOnSearchButton();
	}

	@And("view the iphone")
	public void view_the_iphone() {
		assertTrue(searchMobilePage.viewProduct());
	}

	@And("verify the message {string}")
	public void verify_the_message(String expectedMeassage) {
		assertEquals(searchMobilePage.productNotFoundMessage(), expectedMeassage);

	}

}
