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
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author harshak
 *
 */
public class AccountCreationPageTest extends Baseclass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
	
	@Test(groups = "Sanity")
	public void verifyCreateAccountPageTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignin();
		accountCreationPage= loginPage.createNewAccount("harshak@gmail.com");		
		boolean result = accountCreationPage.validateFormTitle();
		Assert.assertTrue(result);
		
		
	}

}
