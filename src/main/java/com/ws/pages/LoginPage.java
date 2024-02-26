package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

public class LoginPage extends DriverScript {

	// ****************Page Elements******************************************//

	@FindBy(id = "Email") WebElement emailTextField;
	@FindBy(name = "Password") WebElement PasswordTextField;
	@FindBy(xpath = "//input[@class ='button-1 login-button']")WebElement loginButton;
	@FindBy(linkText = "Forgot password?")WebElement forgotPasswordLink;

	// ***************Page Initialization****************************************//

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//**************************Page Actions/Method********************************//
	
	public void enterEmail(String email) {
		emailTextField.clear();
		emailTextField.sendKeys(email);
		
	}
	public void enterPassword(String Password)
	{
		PasswordTextField.sendKeys(Password);
		
	}
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public boolean isForgotPasswordLinkPresent() {
		return forgotPasswordLink.isDisplayed();
		
	}
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
}
