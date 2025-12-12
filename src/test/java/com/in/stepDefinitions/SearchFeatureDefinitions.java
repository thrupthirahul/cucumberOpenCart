package com.in.stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.in.pageObjects.HomePage;
import com.in.pageObjects.SearchMobilePage;
import com.in.utilites.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class SearchFeatureDefinitions {
	
	WebDriver driver;
	WebDriverWait wait;
	HomePage homePage;
	SearchMobilePage searchMobilePage;
	
	public SearchFeatureDefinitions() {
		driver= WebDriverManager.getLocalThreadDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
    @When("search for Product {string}")
    public void search_for_product(String product) {
    	homePage= new HomePage(driver);
    	wait.until(ExpectedConditions.visibilityOf(homePage.seachTextbox())).sendKeys(product);

    }

    @And("click on home search button")
    public void click_on_home_search_button() {
    	wait.until(ExpectedConditions.elementToBeClickable(homePage.seachButton())).click();
    }

    @And("click and selected {string} from dropdown")
    public void select_from_dropdown(String category) {
    	
    	searchMobilePage = new SearchMobilePage(driver);
        WebElement searchcategoriesDropdown =wait.until(ExpectedConditions.elementToBeClickable(searchMobilePage.searchcategoriesDropdown()));        
        Select dropdown= new Select(searchcategoriesDropdown);
        
        
        List<WebElement> options = dropdown.getOptions();
        for(WebElement opt:options) {
        	if(opt.getText().trim().equals(category)){
        		opt.click();
        		break;
        	}
        }
        if(!category.isBlank()) {
        	Assert.assertEquals(category, dropdown.getFirstSelectedOption().getText().trim());
        }
        else {
        	Assert.assertEquals(dropdown.getFirstSelectedOption().getText().trim(), "All Categories");
        	
        }
        // dropdown.selectByVisibleText(category);
        //dropdown.selectByValue("24");
    }

    @And("checked the check box")
    public void checked_the_check_box() {
    	wait.until(ExpectedConditions.elementToBeClickable(searchMobilePage.searchCheckBox())).click();
    }
    
    @And("click on search button")
    public void click_on_search_button() {
    	wait.until(ExpectedConditions.elementToBeClickable(searchMobilePage.searchButton())).click();
    	
    }
    
    @And("view the iphone")
    public void view_the_iphone() {
    	boolean flag = wait.until(ExpectedConditions.visibilityOf(searchMobilePage.searchIphone())).isDisplayed();
        Assert.assertTrue(flag);
    }
    
    @And("verify the message {string}")
	public void verify_the_message(String expectedMeassage) {
    	wait.until(ExpectedConditions.textToBePresentInElement(searchMobilePage.productNotFoundMessage(),expectedMeassage));
		//Assert.assertEquals(expectedMeassage, text);
    	
	}

}
