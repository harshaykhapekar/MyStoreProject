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
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author harshak
 *
 */
public class AddToCartPageTest extends Baseclass {
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void addToCartTest() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnMoreBtn();
		//Action.implicitWait(driver, 10);
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		boolean result = addToCartPage.validateAddToCart();
		Assert.assertTrue(result);
		
	}
	

}
