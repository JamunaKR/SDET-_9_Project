package com.pratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.crm.autodesk.objectrrepositorylib.Login;

import sun.util.logging.resources.logging;

public class SampleTest_WithOut_POM {


	@Test
	public void createOrgTest() throws InterruptedException {
	
	WebDriver driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.MICROSECONDS);
	
	driver.get("http://localhost:8888");
	
	Login lp = new Login(driver);  

	//Login lp=new Login(driver);				//Getters()
	//lp.getUsernameEdt.sendKeys("admin");
	//lp.getPasswordEdt.sendKeys("admin");	
	//lp.getLoginBtn().click();		//OR
 lp.loginToApp();//loginToApp() is present in Login class(objectrepository package)		//Business()
	  
	}
	  

}
