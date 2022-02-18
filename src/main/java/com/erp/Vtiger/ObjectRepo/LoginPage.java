package com.erp.Vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	@FindBy(name="user_name") private WebElement username;
	@FindBy(name="user_password") private WebElement password;
	@FindBy(id="submitButton") private WebElement loginbtn;


	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
		
		PageFactory.initElements(driver, this);
	}
}
