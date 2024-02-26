package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LoginPage;

public class TestLoginPage extends DriverScript {
	
	HomePage homepage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp()
	{
		initApplication();
		homepage = new HomePage();
	    loginPage = new LoginPage();
	}
	@AfterMethod
	public void tearDown()
	{
		quitDriver();
	}
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
