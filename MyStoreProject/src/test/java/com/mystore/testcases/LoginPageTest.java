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
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author harshak
 *
 */
public class LoginPageTest extends Baseclass {
	
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
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Smoke","Sanity"})
	public void loginTest(String uname, String password) {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("user is going to click on sign in");
		loginPage = indexPage.clickOnSignin();
		Log.info("enter username and password");
		//homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.login(uname, password);
		String actualUrl = homePage.getCurrentUrl();
		String expectedUrl="http://automationpractice.com/index.php?controller=my-account";
		Log.info("verify that user is able to login");
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.info("Login is successful");
		Log.endTestCase("LoginTest--end--");
	}
}
