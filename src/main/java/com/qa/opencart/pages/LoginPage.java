package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constant;
import com.qa.opencart.util.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleutil;

	// 1. private By Locator:
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//button[normalize-space()='Login']");
	private By forgotPwd = By.linkText("Forgotten Password");

	private By registerLink = By.linkText("Register");

	// 2. public page class constructor : because our driver is inittilise in other
	// package
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}

	// 3. public page Actions: is behave like public for me to access private by
	// locatior

	public String getLoginPageTitle() {
		return eleutil.waitForTitleIs(Constant.DEFAULT_TIME_OUT, Constant.LOGIN_PAGE_TITLE);
	}

	public String getLoginpageUrl() {
		return eleutil.waitForUrl(Constant.DEFAULT_TIME_OUT, Constant.LOGIN_PAGE_FRACTION_URL);
	}

	public boolean isForgotPwdLinkexist() {
		return eleutil.doIsDisplayed(forgotPwd);
	}

	public AccountPage doLogin(String un, String pwd) {
		eleutil.waitForElementToBeVisible(emailId, Constant.DEFAULT_TIME_OUT).sendKeys(un);
		eleutil.doSendKeys(password, pwd);
		eleutil.doClick(loginBtn);
		return new AccountPage(driver);
	}

	public boolean isRegisterLinkExist() {
		return eleutil.waitForElementToBeVisible(registerLink, Constant.DEFAULT_TIME_OUT).isDisplayed();
	}
	
	public void navigateToregistePage() {
		if(isRegisterLinkExist()) {
			eleutil.doClick(registerLink);
		}
	}
	
	
	
	
	
}