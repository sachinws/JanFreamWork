package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.SearchResultPage;

public class BaseTest {

	public DriverFactory df;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage; // LoginPage is class And loginPage is reffrence variable
	public AccountPage accPage;    //all reference stored in base test 
	
	public SearchResultPage searchResultPage;
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
