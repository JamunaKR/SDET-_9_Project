package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vendors {
	
	public Vendors(WebDriver driver) { 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Vendor...']")
	private WebElement createVendImg;


	@FindBy(name="search_field")
	private WebElement inDropDown;

	@FindBy(name="search_text")
	private WebElement searchEdt;

	@FindBy(name="submit")
	private WebElement searchNow;	


	public WebElement getInDropDown() {
		return inDropDown;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getSearchNow() {
		return searchNow;
	}

	public WebElement getCreateVendImg() {
		return createVendImg;
	}
	
	}
