package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class OrderPage extends Baseclass {
	
	@FindBy(xpath = "//td[@class='cart_unit']/span/span")
	WebElement unitPrice;
	
	@FindBy(id = "total_price")
	WebElement totalPrice;
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToCheckout;
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
//	public double getUnitPrice() {
//	//	Action.fluentWait(driver, unitPrice, 10);
//		String unitPrice1=unitPrice.getText();
//		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
//		double finalUnitPrice=Double.parseDouble(unit);
//		return finalUnitPrice/100;
//	}
	
	public double getUnitPrice() {
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
	//	Action.fluentWait(driver, totalPrice, 10);
		String totalPrice1=totalPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice=Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckout() {
		Action.click(driver, proceedToCheckout);
		return new LoginPage();
	}

}
