package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;

	public class Invoices extends WebDriverUtiles {
		
		public Invoices(WebDriver driver) { 
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//img[@alt='Create Invoice...']")
		private WebElement createInvImg;


		@FindBy(name="search_field")
		private WebElement inDropDown;

		@FindBy(name="search_text")
		private WebElement searchEdt;

		@FindBy(name="submit")	//search
		private WebElement searchNow;	
		
		@FindBy(xpath ="//td[contains(text(),'INV6')]/preceding-sibling::input[@name='selected_id']")
		private WebElement checkBox;
		
		@FindBy(xpath="//input[@class='crmbutton small delete']") //Delete
		private WebElement deleteBtn;
		
		@FindBy(xpath="//td[text()='M']")
		private WebElement searchAlp;


		public WebElement getInDropDown() {
			return inDropDown;
		}

		public WebElement getSearchEdt() {
			return searchEdt;
		}

		public WebElement getSearchNow() {
			return searchNow;
		}
		
		public WebElement getCheckBox() {
			return checkBox;
		}
		
		public WebElement getDeleteBtn() {
			return deleteBtn;
		}
		
		public WebElement getSearchAlp() {
			return searchAlp;
		}

		public WebElement getCreateInvImg() {
			return createInvImg;
		}
		
		/**
		 * 
		 */
		public void serachInvoice(String dropDwonValue , String actualValue) {
			select(inDropDown, dropDwonValue);
			searchEdt.sendKeys(actualValue);
			searchNow.click();
		}
		
		
		}
