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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author harshak
 *
 */
public class HomePageTest extends Baseclass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
	
	@Test(groups = "Smoke")
	public void wishlistTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignin();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateMyWishlist();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "Smoke")
	public void orderHistoryAndDetailsTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignin();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateOrderHistory();
		Assert.assertTrue(result);
	}
	
	

}
