package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class PaymentPage extends Baseclass {
	
	@FindBy(xpath = "//a[@class='bankwire']")
	WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[@class='cheque']")
	WebElement payByCheckMethod;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage clickOnPaymentMethod() {
		Action.click(driver, bankWireMethod);
		return new OrderSummaryPage();
		
	}

}
