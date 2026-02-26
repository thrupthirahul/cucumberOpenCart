package com.in.hooks;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.in.utilites.LoadPropertiesFile;
import com.in.utilites.WebDriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {

	public WebDriver driver;
	public Properties props;

	public MyHooks() {
		System.out.println("MyHooks.MyHooks()");
	}

	@Before
	public void setup() throws Exception {	
		props=LoadPropertiesFile.loadFile();
		WebDriverManager.setLocalThreadDriver(props.getProperty("browserName"));
		driver=WebDriverManager.getLocalThreadDriver();	
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		WebDriverManager.removeBroswer();
		System.out.println("closed...");
	}

}

