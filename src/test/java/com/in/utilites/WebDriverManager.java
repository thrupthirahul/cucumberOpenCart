package com.in.utilites;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class WebDriverManager {

	private static ThreadLocal<WebDriver> localThreadDriver = new ThreadLocal<>();
	private  Properties props= LoadPropertiesFile.loadFile();

	public WebDriverManager() {	
	
		System.out.println("WebDriverManager.WebDriverManager()" + Thread.currentThread().getName());

	}

	public void setLocalThreadDriver(String browserName) {
		
		 if (localThreadDriver.get() != null) {
		        return; // Driver already created for this thread
		    }
		
		switch(browserName.toLowerCase()) {

		case "chrome" -> {

			if(localThreadDriver.get() == null && Boolean.parseBoolean(props.getProperty("headlessMode"))) {
				ChromeOptions options= new ChromeOptions();
				options.addArguments("--headless=new");     // Enable headless
				options.addArguments("--disable-gpu");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--start-maximized");
				localThreadDriver.set(new ChromeDriver(options));

			}else if(localThreadDriver.get() == null && !(Boolean.parseBoolean(props.getProperty("headlessMode")))) {
				localThreadDriver.set(new ChromeDriver());
				
			}
		}
		case "edge" -> {
			
			if(localThreadDriver.get() == null && Boolean.parseBoolean(props.getProperty("headlessMode"))) {
				EdgeOptions options= new EdgeOptions();
				options.addArguments("--headless=new");     // Enable headless
				options.addArguments("--disable-gpu");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				localThreadDriver.set(new EdgeDriver(options));

			}else if(localThreadDriver.get() == null && !(Boolean.parseBoolean(props.getProperty("headlessMode")))) {
				localThreadDriver.set(new EdgeDriver());
			}	
		} 

		default -> throw new RuntimeException("invalid browswer name passed");
		}

	}

	public  WebDriver getLocalThreadDriver() {
		return localThreadDriver.get();
	}

	public void removeBroswer() {
		this.getLocalThreadDriver().quit();
		localThreadDriver.remove();
	}
}
