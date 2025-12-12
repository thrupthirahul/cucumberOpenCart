package com.in.utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
	
	private static ThreadLocal<WebDriver> localThreadDriver = new ThreadLocal<>();
	
	public WebDriverManager() {
		System.out.println("WebDriverManager.WebDriverManager()");
	}
	
	public static void setLocalThreadDriver(String broswerName) {
		
		if(broswerName.toLowerCase().equals("chrome")) {
			localThreadDriver.set(new ChromeDriver());
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
