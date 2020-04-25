package com.report;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;



import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


public class allurereports {
	
	public WebDriver driver;
	
	@BeforeTest
	public void setup() throws InterruptedException {
		
	System.setProperty("webdriver.gecko.driver", "E:/geckodriver-v0.26.0-win64/geckodriver.exe");
	
	FirefoxOptions options = new FirefoxOptions();
	options.addArguments("--headless");
	
    driver = new FirefoxDriver(options);
    driver.get("https://qa.jaleshcruises.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(75, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    Thread.sleep(25000);
    driver.manage().deleteAllCookies();
   
}
	
	@Test(priority=1,groups="title",description="check the Title ")
	@Severity(SeverityLevel.NORMAL)
	@Epic("Ep001")
	@Feature("Title")
	@Description("Test Case Description: To Verify Title is displaying")
	@Story("Story Name: To check user is able enter the password")
	@Step("Title is Displaying")
	public void jaleshTitleTest() {
		String title = driver.getTitle();
		System.out.println("Tile for jalesh is " + title);
		Assert.assertEquals(title, "Jalesh Cruises | Best Premium Cruises in India");
		
	}
	
	@Test(priority=2,groups="Logo",description="To verify the Logo")
	@Severity(SeverityLevel.NORMAL)
	@Epic("Ep002")
	@Feature("Logo")
	@Description("Test Case Description: To Verify logo is displaying")
	@Story("Story Name: Logo is displaying")
	@Step("Verify Logo")
	public void jaleshLogoTest() {
		boolean logo = driver.findElement(By.xpath("//a[@class=\"brand_logo\"]")).isDisplayed();
		Assert.assertEquals(logo, true);
		
	}
	
	@Test(priority=3,groups="search",description="Click on the Search Button")
	@Severity(SeverityLevel.NORMAL)
	@Epic("Ep003")
	@Feature("Search Button")
	@Description("Test Case Description: To Verify Search button")
	@Story("Story Name: To check user is able to click on the search button")
	@Step("Clicking on the Search button")
	public void clickSearchTest() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class=\"custom-btn dark filter-search-btn\"]")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=4,groups="book",description="Click on the Book Button")
	@Severity(SeverityLevel.MINOR)
	@Epic("Ep004")
	@Feature("Search Button")
	@Description("Test Case Description: To Verify Book button")
	@Story("Story Name: To check user is able to click on the Book button")
	@Step("Clicking on the Book button")
	public void clickBookTest() {
		driver.findElement(By.xpath("//div[@onclick=\"bookNow('316')\"]")).click();
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}

	
	
}
