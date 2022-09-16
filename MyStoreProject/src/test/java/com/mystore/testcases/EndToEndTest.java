/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

/**
 * @author harshak
 *
 */
public class EndToEndTest extends Baseclass {
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
	
	@Test(groups = "Regression")
	public void endToEndTest() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnMoreBtn();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage= addToCartPage.clickOnCheckout();
		loginPage=orderPage.clickOnCheckout();
		addressPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage= addressPage.clickOnCheckout();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnCheckout();
		orderSummaryPage=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage = orderSummaryPage.clickOnConfirm();
		String actMessage = orderConfirmationPage.validateConfirmMessage();
		String expectedMessage = "Your order on My Store is complete.";
		Assert.assertEquals(actMessage, expectedMessage);
		 	
	}

}
