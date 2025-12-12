package com.in.stepDefinitions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.in.pageObjects.GuruWebTablePageObjects;
import com.in.utilites.WebDriverManager;

import io.cucumber.java.en.When;

public class GuruWebTableDefination {
	WebDriver driver;
	GuruWebTablePageObjects tableObject;
	
	
	@When("print the data to console")
	public void print_the_data_to_console() {
		driver = WebDriverManager.getLocalThreadDriver();
		tableObject= new GuruWebTablePageObjects(driver);
		int c=tableObject.getColumnSize();
		int r=tableObject.getRowSize();
		System.out.println(c);
		System.out.println(r);
		
		List<Map<String,String>> list=new ArrayList<>();
		for(int i=1; i<=r; i++) {	
			Map<String,String> map= new LinkedHashMap<String,String>();
			for(int j=1; j<=c; j++) {
				map.put(tableObject.locateColumnValue(j), tableObject.locateFieldValue(i, j));
			}
			list.add(map);
		}
		
		list.stream()
			.forEach(data -> System.out.println(data));
		
	}

}
