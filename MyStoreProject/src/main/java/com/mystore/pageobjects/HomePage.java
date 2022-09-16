package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class HomePage extends Baseclass {
	
	@FindBy(xpath="//span[text() = 'My wishlists']")
	WebElement myWishlist;
	
	@FindBy(xpath="//span[text() = 'Order history and details']")
	WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMyWishlist() {
		return Action.isDisplayed(driver, myWishlist);
	}
	
	public boolean validateOrderHistory() {
		return Action.isDisplayed(driver, orderHistory);
	}
	
	public String getCurrentUrl() {
		String homePageUrl=driver.getCurrentUrl();
		return homePageUrl;
	}

}
