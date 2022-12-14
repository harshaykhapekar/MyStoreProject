package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class AddressPage extends Baseclass {
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToCheckout;
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ShippingPage clickOnCheckout() {
		Action.click(driver, proceedToCheckout);
		return new ShippingPage();
	}

}
