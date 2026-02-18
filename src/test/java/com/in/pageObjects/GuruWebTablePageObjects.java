package com.in.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GuruWebTablePageObjects {
	
	private WebDriver driver;

	public GuruWebTablePageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class='dataTable']//thead//tr//th")
	private List<WebElement> tableColumnsize;

	@FindBy(xpath="//table[@class='dataTable']//tbody//tr")
	private List<WebElement> tableRowsize;
	
	
	public int getColumnSize() {
		return tableColumnsize.size();
	}
	public int getRowSize() {
		return tableRowsize.size();
	}
	
	public String locateColumnValue(int columValue) {
		//driver.findElement(By.xpath("//table[@class='dataTable']//thead//tr//th["+columValue+"]")).getText();
		
		return tableColumnsize.get(columValue-1).getText();
	}
	
	public String locateFieldValue(int rowValue, int columnValue) {
		//driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+rowValue+"]//td["+columnValue+"]")).getText();
		
		return tableRowsize.get(rowValue-1).findElement(By.tagName("td")).getText();
	}
	
	
	
	

}
