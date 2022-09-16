package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class SearchResultPage extends Baseclass {
	
	@FindBy(xpath = "//*[@id=\"center_column\"]//img")
	WebElement productResult;
	
	@FindBy(xpath = "//span[text()='More']")
	WebElement moreBtn;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable() {
		return Action.isDisplayed(driver, productResult);
		
	}
	
	public AddToCartPage clickOnProduct() {
		Action.click(driver, productResult);
		return new AddToCartPage();
	}
	
	public AddToCartPage clickOnMoreBtn() {
		Action.mouseHoverByJavaScript(productResult);
		Action.click(driver, moreBtn);
		return new AddToCartPage();
	}

}
