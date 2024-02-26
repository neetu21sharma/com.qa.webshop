package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LoginPage;

public class TestLoginPage extends DriverScript {
	
	@Test(priority = 1)
	public void testHomePageTitle() {
		initApplication();
		HomePage homepage = new HomePage();
		String title =homepage.getHomePageTitle();
		Assert.assertTrue(title.contains("Demo Web Shop"));
		quitDriver();
	}
	@Test(priority = 2)
	public void testLoginFunction() {
		initApplication();
		HomePage homepage = new HomePage();
		homepage.clickLogin();
		LoginPage loginPage = new LoginPage();
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertTrue(loginPageTitle.contains("Login"));
		loginPage.enterEmail("selauto1@test.com");
		loginPage.enterPassword("Pass@123");
		loginPage.clickLoginButton();
		String title = homepage.getHomePageTitle();
		Assert.assertTrue(title.contains("Demo Web Shop"));
		homepage.clickLogout();
		quitDriver();
	}


}
