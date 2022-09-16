package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class OrderConfirmationPage extends Baseclass {
	
	@FindBy(xpath = "//p[@class='cheque-indent']")
	WebElement confirmMessage;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateConfirmMessage() {
		String confirmMsg=confirmMessage.getText();
		return confirmMsg;
	}

}
