package com.qa.opencart.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.util.Constant;

public class LoginPageTest extends BaseTest { // Loginpage Class is extending Basetest class inheritance

	@Test
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		System.out.println("page title : " + actTitle);
		Assert.assertEquals(actTitle, Constant.LOGIN_PAGE_TITLE);
	}

	@Test
	public void loginPageUrlTest() {
		String url = loginPage.getLoginpageUrl();
		System.out.println("login page url :" +url);
		Assert.assertTrue(url.contains(Constant.LOGIN_PAGE_FRACTION_URL));
	}
	
	@Test
	public void forgotPwdlikTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkexist());
	}
	

	
	
	@Test
	public void loginTest() {
		accPage =loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertTrue(accPage.isAccountPageHeaderexist());
	}
	
	
	@Test
	public void isRegisterLinkExist() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());;
	}

}
