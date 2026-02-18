package com.in.hooks;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.in.utilites.WebDriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {

	public WebDriver driver;

	public MyHooks() {
		System.out.println("MyHooks.MyHooks()");
	}

	@Before
	public void setup() throws Exception {

		try(FileInputStream fis
				= new FileInputStream("src/test/java/com/in/properties/properties.properties");
				){

			Properties props= new Properties();
			props.load(fis);
			WebDriverManager.setLocalThreadDriver(props.getProperty("broswerName"));
			driver=WebDriverManager.getLocalThreadDriver();	
		}		
	}

	@After
	public void tearDown() {
		WebDriverManager.removeBroswer();
		System.out.println("closed...");
	}

}

