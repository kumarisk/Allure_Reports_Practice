package com.report;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public WebDriver intialize_driver(){
		//System.setProperty("webdriver.gecko.driver", "E:/geckodriver-v0.26.0-win64/geckodriver.exe");
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
//		 driver.manage().window().maximize();
//		   // driver.manage().timeouts().implicitlyWait(75, TimeUnit.SECONDS);
//		    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		   // driver.manage().deleteAllCookies();
		    tdriver.set(driver);
		    return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

}
