package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;
/**
 * 
 * @author Deepak , Nithish
 *
 */


public class Home  extends WebDriverUtiles{
	WebDriver driver;
	public Home(WebDriver driver) {     
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[contains(@src,'user.PNG')]")
	private WebElement adminstrationImg;
	
	@FindBy(linkText = "Sign Out")
    private WebElement signOutLnk;
	
	
	@FindBy(linkText = "Contacts")
    private WebElement contactLnk;
	
	@FindBy(linkText = "Organizations")
    private WebElement orgLnk;
	
	@FindBy(linkText = "Leads")
    private WebElement leadsLnk;
	
	@FindBy(linkText = "Vendors")
    private WebElement vendorLnk;
	
	@FindBy(linkText = "Products")
    private WebElement productLnk;

	@FindBy(linkText = "Quotes")
    private WebElement quoteLnk;
	
	@FindBy(linkText = "Invoice")
    private WebElement invLnk;

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getOrgLnk() {
		return orgLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}
	
	public WebElement getVendLnk() {
		return vendorLnk;
	}
	
	public WebElement getProdLnk() {
		return productLnk;
	}

	public WebElement getQuoteLnk() {
		return quoteLnk;
	}

	public WebElement getInvoiceLnk() {
		return invLnk;
	}
	
	public void logout() {
		moveToExpectedElemnet(driver, adminstrationImg);
		signOutLnk.click();
	}
	
	
	
	
	}
