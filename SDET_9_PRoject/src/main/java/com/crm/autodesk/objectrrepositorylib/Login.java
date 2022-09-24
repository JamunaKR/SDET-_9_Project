package com.crm.autodesk.objectrrepositorylib;
/**
 * 
 * @author Deepak
 *
 */

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Login {   //rule -1
	
	public Login(WebDriver driver) {             //Rule -4
		PageFactory.initElements(driver, this);
		//PageFactory is a extended design of POM and its job is when we create obj. to the Login class, 
		//all the annotation will be executed and then intialized 
	}
	
	
	@FindBy (xpath = "//input[@name='user_name']")
	WebElement usernameEdt1;
	
    @FindBy(name="user_name")                   //Rule -2 
    private WebElement usernameEdt;
    //@FindBy is preffered becz it identifies the element based on the address of the user_name of the element 
    //and not by the reference/element locators
    
    @FindBy(name="user_password")
    private WebElement passwordEdt;
    
    @FindBy(id="submitButton")
    private WebElement loginButon;
   //Traditional way of identifying the POM(Public) 

	    
    
//Getters are used in order to provide read access and no setters are used here.
//Getters can be reusable but cannot be modified
	public WebElement getUsernameEdt() {        //rule-3
		return usernameEdt1;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginButon() {
		return loginButon;
	}
    
	public void loginToApp(String username , String password) {             //Rule -5
		usernameEdt1.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginButon.click();
	}
	//Its is a Business Library/WorkFlow Library
	public void loginToApp() {             //Rule -5
		usernameEdt1.sendKeys("admin");
		passwordEdt.sendKeys("admin");
		loginButon.click();
	}
    
    //Hence this process is called encapsulation in Java
}
