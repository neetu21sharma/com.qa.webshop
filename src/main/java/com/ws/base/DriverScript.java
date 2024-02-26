package com.ws.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverScript {
	// public driver reference which can be accessed across the project
	public static WebDriver driver;
	Properties prop;// use this in our entire project. I don't need to create an object we can
					// directly call so we can give static
	/* This constructor is responsible for loading the property file */

	public DriverScript() {

		try {

			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fs = new FileInputStream(file);
			prop = new Properties();
			prop.load(fs);

		} catch (Exception e) {
			System.out.println("unable to load the properties file");
			e.printStackTrace();
		}

	}

	/*
	 * this method is used to launch the browser and apply all the wait setting and
	 * also navigate the application
	 */
	
	public void initApplication() {
		String browser = prop.getProperty("browser");

		if (browser.trim().equalsIgnoreCase("chrome")) {
			System.out.println("Browser in use: " + browser);
			driver = new ChromeDriver();
		} else if (browser.trim().equalsIgnoreCase("firefox")) {
			System.out.println("Browser in use: " + browser);
			driver = new FirefoxDriver();
		} else if (browser.trim().equalsIgnoreCase("edge")) {
			System.out.println("Browser in use: " + browser);
			driver = new EdgeDriver();
		} else {
			System.out.println("Unsupported Browser type! please check the config file");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getUrl();
		

	}
 //this method is to get the application url from the properties file
	public void getUrl() {
		String url = prop.getProperty("url");
		driver.get(url);
	}
	//this method is used to quit the driver instance
	public static void quitDriver()
	{
		driver.quit();
	}

}