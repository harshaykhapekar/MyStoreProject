package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class ShippingPage extends Baseclass {

	@FindBy(id = "cgv")
	WebElement terms;
	
	@FindBy(xpath = "//button/span[contains(text(), 'Proceed to checkout')]")
	WebElement proceedToCheckout;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkTheTerms() {
		Action.click(driver, terms);
	}
	
	public PaymentPage clickOnCheckout() {
		Action.click(driver, proceedToCheckout);
		return new PaymentPage();
	}
}
