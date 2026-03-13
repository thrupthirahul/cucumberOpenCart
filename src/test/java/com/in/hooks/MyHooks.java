package com.in.hooks;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.in.utilites.LoadPropertiesFile;
import com.in.utilites.WebDriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {

	public Properties props;
	public WebDriver driver;
	public WebDriverManager webDriverManager;

	public MyHooks() {
		System.out.println("MyHooks.MyHooks()");
		webDriverManager = new WebDriverManager();
		props=LoadPropertiesFile.loadFile();
	}

	@Before
	public void setup() throws Exception {	
		System.out.println("start...");
		webDriverManager.setLocalThreadDriver(props.getProperty("browserName"));
		driver=webDriverManager.getLocalThreadDriver();	
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		webDriverManager.removeBroswer();
		System.out.println("closed...");
	}

}

