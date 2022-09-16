package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends Baseclass {
	
	IndexPage indexPage; 
	
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
	public void verifyLogo() {
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		String actTitle = indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store");
	}

}
