
package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.util.Constant;

public class AccountPageTest extends BaseTest {
	
	@BeforeClass  //precondition  is login page should be login
	public void accPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void accountsPagrTitleTest() {
		String actAccountPageTitle = accPage.getAccountPageTitle();
		System.out.println("Acc page title : "+ actAccountPageTitle);
		Assert.assertEquals(actAccountPageTitle, Constant.ACCOUNT_PAGE_TITLE);
	}
	
	@Test
	public void accPageHeaderTest() {
		Assert.assertTrue(accPage.isAccountPageHeaderexist());
	}
	
	@Test
	public void searchExistTest() {
		Assert.assertTrue(accPage.isSearchExist());
	}

	@Test
	public void accSectionsTest() {
		
		List<String> actSecList = accPage.getAccountPageSectionList();
		System.out.println("Account section list : "+ actSecList);
		Assert.assertEquals(actSecList, Constant.ACCOUNTS_SECTIONS_LIST);
		
	}
	
	//these test case unser searchPeroductPage
	
	@Test
	public void searchHeaderTest() {
		searchResultPage = accPage.dosearch("Macbook");
		String actSearchHeader = searchResultPage.getResultPageHeaderValue();
		Assert.assertTrue(actSearchHeader.contains("Macbook"));
	}
	
	@Test
	public void searchProductcountTest() {
		searchResultPage = accPage.dosearch("Macbook");
		int actProductCount = searchResultPage.getProductSearchCount();
		Assert.assertEquals(actProductCount, Constant.MACBOOK_PRODUCT_COUNT);
	}
	
	@Test
	public void getsearchProductListTest() {
		searchResultPage = accPage.dosearch("Macbook");
		List<String> actProductList = searchResultPage.getProductResultList();
		System.out.println(actProductList);
	}
	
}
