package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Quotes {
	
	public Quotes(WebDriver driver) { 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Quote...']")
	private WebElement createQuoteImg;


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

	public WebElement getCreateQuoteImg() {
		return createQuoteImg;
	}
	
	}


}
