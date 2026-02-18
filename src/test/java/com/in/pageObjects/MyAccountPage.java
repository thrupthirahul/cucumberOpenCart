package com.in.pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	private WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@class='list-group']//a")
	private List<WebElement> listGroup;
	
	public List<WebElement> getListGroup(){
		return listGroup;
	}

}
