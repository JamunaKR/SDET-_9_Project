package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;

/**
 * 
 * @author RiChi
 *
 */

public class CreateNewVendor extends WebDriverUtiles {
	WebDriver driver;
	
	public CreateNewVendor(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "vendorname")
	private WebElement vendNameEdt;
	
	@FindBy(name = "glacct")
	private WebElement glAccountLst;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	
	public WebElement getVendNameEdt() {
		return vendNameEdt;
	}

	public WebElement getGlAccount() {
		return glAccountLst;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createVendor(String vendName , String glAccount) throws Throwable {
		vendNameEdt.sendKeys(vendName);
		select(glAccountLst, glAccount);
		saveBtn.click();
		
		 VendorsInfo vendinfo = new VendorsInfo(driver);
		 waitforElement(vendinfo.getSuccessFullMsg());
	}
	
	
	public void createVendor(String vendName) {
		vendNameEdt.sendKeys(vendName);
		saveBtn.click();
	}
}
