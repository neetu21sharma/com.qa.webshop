package com.ws.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LoginPage;

public class BaseTest extends DriverScript {
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

}
