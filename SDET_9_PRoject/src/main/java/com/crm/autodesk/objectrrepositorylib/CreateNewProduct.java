package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;

public class CreateNewProduct extends WebDriverUtiles {
	WebDriver driver;
	public CreateNewProduct(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "productname")
	private WebElement prodNameEdt;
	

	@FindBy(name = "qty_per_unit")
	private WebElement qtyAddEdt;
	
	
	//@FindBy(xpath = "//input[@name='vendor_name']/following-sibling::img[@alt='Select']")
	  //private WebElement vendorLookUpImage;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	/**
	 * 
	 * @param prodName
	 * @param vendorName
	 * @param serachDropOtp
	 */
	public  void createProduct(String prodName , String qty , String serachDropOtp) {
		waitforElementToBeClickable(driver, prodNameEdt);
		prodNameEdt.sendKeys(prodName);
		waitforElementToBeClickable(driver, qtyAddEdt);
		prodNameEdt.sendKeys(qty);
		//vendorLookUpImage.click();
		//switch to Child
		//swicthToWindow(driver, "Vendors&action");
		//Vendors vendPage = new Vendors(driver);
		//select(vendPage.getInDropDown(),serachDropOtp);
		//vendPage.getSearchEdt().sendKeys(vendorName); 					//Where is the vendName
		//vendPage.getSearchNow().click();
		//driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
		//switch to Parent
		//swicthToWindow(driver, "Products");
		saveBtn.click();
	}
	
	public  void createProduct(String prodName , String vendorName ) {
		prodNameEdt.sendKeys(prodName);
		vendorLookUpImage.click();
		//switch to Child
		swicthToWindow(driver, "Vendors&action");
		Vendors vendPage = new Vendors(driver);

		vendPage.getSearchEdt().sendKeys(vendorName);
		vendPage.getSearchNow().click();
		driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
		//switch to Parent
		swicthToWindow(driver, "Products");
		saveBtn.click();
	}
	
	public void createProduct(String prodName) {
		prodNameEdt.sendKeys(prodName);
		saveBtn.click();
	}
}
