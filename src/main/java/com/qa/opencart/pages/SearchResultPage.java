package com.qa.opencart.pages;




import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.Constant;
import com.qa.opencart.util.ElementUtil;

public class SearchResultPage {
	
	private WebDriver driver;
	private ElementUtil eleutil;
	
	private By searchHeader = By.cssSelector("div#content h1");
	private By products = By.cssSelector("caption");
	
	//constructor and object of elementUtil class
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}
//for searching the on header means on search macbook
	public String getResultPageHeaderValue() {
		if(eleutil.doIsDisplayed(searchHeader)) {
			return eleutil.doElementGetText(searchHeader);
		}
		return null;
	}
	
	
	//Count of search product same a macbook
	
	public int getProductSearchCount() {
		return eleutil.waitForElementsToBeVisible(products, Constant.DEFAULT_TIME_OUT).size();
	}
	
	//list of searching product
	public List<String> getProductResultList() {
		List<WebElement> productList = eleutil.waitForElementsToBeVisible(products, Constant.DEFAULT_TIME_OUT);
		List<String> productValList = new ArrayList<String>();  //maintaining blank arraylist
	    for(WebElement e : productList ) {
	    	String text = e.getText();
	    	productValList.add(text);
	}
	    return productValList;
	}
}
