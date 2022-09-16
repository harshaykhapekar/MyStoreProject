package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class AddToCartPage extends Baseclass{

	@FindBy(id = "quantity_wanted")
	WebElement quantity;
	
	@FindBy(name = "group_1")
	WebElement size;
	
	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//i[@class='icon-ok']")
	WebElement addToCartMessage;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterQuantity(String quantity1) {
		Action.type(quantity, quantity1);
	}
	
	public void selectSize(String size1) {
		Action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() {
		Action.click(driver, addToCartBtn);
	}
	
	public boolean validateAddToCart() {
		Action.fluentWait(driver, addToCartMessage, 10);
		return Action.isDisplayed(driver, addToCartMessage);
	}
	
	public OrderPage clickOnCheckout() {
		Action.fluentWait(driver, proceedToCheckoutBtn, 10);
		Action.JSClick(driver, proceedToCheckoutBtn);
		return new OrderPage();
	}
}
