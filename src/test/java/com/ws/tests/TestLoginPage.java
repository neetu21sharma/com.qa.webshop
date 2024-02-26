package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest {
	
	
	@Test(priority = 1)
	public void testHomePageTitle() {
		
		String title =homepage.getHomePageTitle();
		Assert.assertTrue(title.contains("Demo Web Shop"));
		
	}
	@Test(priority = 2)
	public void testLoginFunction() {
		
		homepage.clickLogin();
		
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertTrue(loginPageTitle.contains("Login"));
		loginPage.enterEmail("selauto1@test.com");
		loginPage.enterPassword("Pass@123");
		loginPage.clickLoginButton();
		String title = homepage.getHomePageTitle();
		Assert.assertTrue(title.contains("Demo Web Shop"));
		homepage.clickLogout();
		
	}
	@Test(priority = 3)
	public void testIsForgotPasswordLinkPresent() {
		homepage.clickLogin();
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertTrue(loginPageTitle.contains("Login"));
		boolean flag = loginPage.isForgotPasswordLinkPresent();
		Assert.assertTrue(flag);
		
		
		
	}


}
