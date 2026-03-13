package com.in.stepDefinitions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.in.pageObjects.HomePage;
import com.in.pageObjects.ShoppingCartPage;
import com.in.pageObjects.YourStorePage;
import com.in.utilites.WebDriverManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCartStepDefinations {

	
	private  WebDriver driver;
	private  HomePage homePage;
	private  ShoppingCartPage shoppingCartPage;
	private  YourStorePage yourStorePage;
    
	public ShoppingCartStepDefinations() {
		driver= new WebDriverManager().getLocalThreadDriver();
	}

    @When("click on shopping cart")
    public void click_on_shopping_cart() {
    	homePage= new HomePage(driver);
        homePage.clickOnShoppingCartLink();
    }

    @When("click continue button")
    public void click_continue_button() {
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickOnContinueButton();
    }

    @When("click on Add To Cart Iteams \\(Mac Book\\)")
    public void click_on_add_to_cart_items_mac_book() {
    	yourStorePage= new YourStorePage(driver);
    	yourStorePage.clickAddToCart();
    }

    @When("click on ItemsCart")
    public void click_on_items_cart() {
    	yourStorePage.clickOnAddAmounToTheCart();
    }

    @When("click on viewcart")
    public void click_on_viewcart() {
        yourStorePage.clickOnViewCart();
    }

    @Then("verify {string}")
    public void verify_total(String expectedTotal) {
        String actualTotal = shoppingCartPage.getTotalAmount();
        Assert.assertEquals(expectedTotal, actualTotal);
    }
}