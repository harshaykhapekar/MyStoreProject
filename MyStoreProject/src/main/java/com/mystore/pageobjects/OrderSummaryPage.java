package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class OrderSummaryPage extends Baseclass {

	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement confirmOrderBtn;
	
	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmationPage clickOnConfirm() {
		Action.click(driver, confirmOrderBtn);
		return new OrderConfirmationPage();
	}
}
