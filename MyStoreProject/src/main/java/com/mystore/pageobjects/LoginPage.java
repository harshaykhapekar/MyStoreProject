package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class LoginPage extends Baseclass {
	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(name="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uname, String pwd) {
		Action.type(userName, uname);
		Action.type(password, pwd);
		Action.click(driver, signInBtn);
		return new HomePage();
	}
	
	public AddressPage login1(String uname, String pwd) {
		Action.type(userName, uname);
		Action.type(password, pwd);
		Action.click(driver, signInBtn);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) {
		Action.type(emailForNewAccount, newEmail);
		Action.click(driver, createNewAccountBtn);
		//Action.implicitWait(driver, 50);
		return new AccountCreationPage();
	}

}
