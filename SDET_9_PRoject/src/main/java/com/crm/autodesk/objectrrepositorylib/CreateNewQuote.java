package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;

public class CreateNewQuote extends WebDriverUtiles {
	WebDriver driver;
	public CreateNewQuote(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "subject")
	private WebElement subjNameEdt;
	
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	  private WebElement quotOrgLookUpImage;
	
	@FindBy(name = "assigned_user_id") //  (xpath="//select[@name='assigned_user_id']")
	private WebElement assignToEdt;
	
	@FindBy(xpath = "//select[@name='quotestage']//option[@value='Created']")
	private WebElement quoteStag;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	/**
	 * 
	 * @param subName
	 * @param orgName
	 * @param serachDropOtp
	 * @param assignTo
	 * @param quoteStage
	 */
	public  void createQuote(String subName , String orgName , String serachDropOtp, String assignTo, String quotestage) {
		waitforElementToBeClickable(driver, subjNameEdt);
		subjNameEdt.sendKeys(subName);		//sendkeys(subName) will be taken from CreateQuote Testcases from external datas 
		quotOrgLookUpImage.click();
		//switch to Child
		swicthToWindow(driver, "Accounts&action");
		Organizations quotOrgPage = new Organizations(driver);
		select(quotOrgPage.getInDropDown(),serachDropOtp);
		quotOrgPage.getSearchEdt().sendKeys(subName); 					//Where is the quoteName
		quotOrgPage.getSearchNow().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		//switch to Parent
		swicthToWindow(driver, "Products");
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


}
