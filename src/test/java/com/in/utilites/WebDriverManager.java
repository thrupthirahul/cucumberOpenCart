package com.in.utilites;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {

	private static ThreadLocal<WebDriver> localThreadDriver = new ThreadLocal<>();
	private static Properties props;
	
	static {
		props=LoadPropertiesFile.loadFile();
	}

	public WebDriverManager() {
		System.out.println("WebDriverManager.WebDriverManager()");
	}

	public static void setLocalThreadDriver(String broswerName) {

		if(broswerName.toLowerCase().equals("chrome")) {

			if(props.getProperty("parallel").equals("true")) {
				ChromeOptions chromeOptions= new ChromeOptions();
				chromeOptions.addArguments("--headless=new");   
				chromeOptions.addArguments("--disable-gpu");
				chromeOptions.addArguments("--no-sandbox");
				localThreadDriver.set(new ChromeDriver(chromeOptions));
			}else {
				localThreadDriver.set(new ChromeDriver());
			}
		}

	}

	public static WebDriver getLocalThreadDriver() {
		return localThreadDriver.get();
	}

	public static void removeBroswer() {

		WebDriverManager.getLocalThreadDriver().quit();
		localThreadDriver.remove();
	}

}
