package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		
		try {
			prop=new Properties();
			System.out.println("Super constructor invoked");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/Configuration/config.properties");
			
				prop.load(ip);
				System.out.println("driver: "+driver);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
	
	/*
	 * @BeforeTest(groups = {"Smoke","Sanity","Regression"}) public void
	 * loadConfig() { try { prop=new Properties();
	 * System.out.println("Super constructor invoked"); FileInputStream ip = new
	 * FileInputStream(System.getProperty("user.dir")+
	 * "/Configuration/config.properties");
	 * 
	 * prop.load(ip); System.out.println("driver: "+driver); } catch
	 * (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }catch (IOException e) { // TODO: handle exception
	 * e.printStackTrace(); } }
	 */

	
	public static void launchApp(String browserName) {
		WebDriverManager.chromedriver().setup();
		//String browserName = prop.getProperty("browser");
		
		if(browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.contains("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		Action.implicitWait(driver,10);
		Action.pageLoadTimeOut(driver, 30);
		driver.get(prop.getProperty("url"));
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
	
}
