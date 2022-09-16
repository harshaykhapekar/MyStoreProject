package com.mystore.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class AccountCreationPage extends Baseclass {
	
	@FindBy(xpath = "//h1[text()='Create an account']")
	WebElement formTitle;
	
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateFormTitle() {
		return Action.isDisplayed(driver, formTitle);
	}
	
	
}
