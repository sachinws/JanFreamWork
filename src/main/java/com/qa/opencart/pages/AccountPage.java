package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.Constant;
import com.qa.opencart.util.ElementUtil;

public class AccountPage {
	private WebDriver driver;
	private ElementUtil eleutil; 

	private By search = By.name("Search");
	private By header = By.cssSelector("div#logo a");
	private By accSeclist = By.cssSelector("div#content h2");
	
	private By Searchbtn = By.cssSelector("div#logo a");   //search button searching product
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}
	
	//pPgae Layer
	
	public String getAccountPageTitle() {
		return eleutil.waitForTitleIs(Constant.DEFAULT_TIME_OUT,Constant.ACCOUNT_PAGE_TITLE);
	}
	
	public boolean isAccountPageHeaderexist() {
		return eleutil.doIsDisplayed(header);
	}
	
	public boolean isSearchExist() {
		return eleutil.doIsDisplayed(search);
	}
	
	public SearchResultPage dosearch(String productName) {
	if(isSearchExist()) {
		eleutil.doSendKeys(search, productName);
		eleutil.doClick(Searchbtn);
		return new SearchResultPage(driver);
	}
	return null;
		
	}
	
	public List<String> getAccountPageSectionList() {
		List<WebElement> secList =eleutil.getElements(accSeclist);
	List<String> accseccValList = new ArrayList<String>();
	for(WebElement e : secList) {
		String text = e.getText();
		accseccValList.add(text);
	}
	return accseccValList;
	
	}
	
	
	
}
