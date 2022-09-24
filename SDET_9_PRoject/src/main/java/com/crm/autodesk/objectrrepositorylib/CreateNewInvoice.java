package com.crm.autodesk.objectrrepositorylib;
import org.openqa.selenium.By;
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

	public class CreateNewInvoice extends WebDriverUtiles {
		WebDriver driver;
		
		public CreateNewInvoice(WebDriver driver) { 
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(name = "subject")
		private WebElement subNameEdt;
		
		@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
		private WebElement organizationLookUpImage;
		
		@FindBy(name = "bill_street")
		private WebElement billAddEdt;
		
		@FindBy(name = "ship_street")
		private WebElement shipAddEdt;
		
		@FindBy(xpath = "//input[@name='productName1']/following-sibling::img[@id='searchIcon1']")
		private WebElement prodLookUpImage;
		
		
		
		//@FindBy(xpath = "//input[@name="Submit")
		//private WebElement prodLookUpImage;

		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
			
			/**
			 * 
			 * @param subName
			 * @param orgName
			 * @param billAdd
			 * @param shipAdd
			 * @param prodName
			 * @param searchDropOtp
			 */
public  void createInvoice(String subName , String invOrgName, String billAdd, String shippAdd, String serachDropOtp) {
				waitforElementToBeClickable(driver, subNameEdt);
				subNameEdt.sendKeys(subName);
				organizationLookUpImage.click();
				//switch to Child
				swicthToWindow(driver, "Accounts&action");
				Organizations invOrgPage = new Organizations(driver);
				select(invOrgPage.getInDropDown(),serachDropOtp);
				invOrgPage.getSearchEdt().sendKeys(invOrgName);
				invOrgPage.getSearchNow().click();
				driver.findElement(By.xpath("//a[text()='"+invOrgName+"']")).click();
				//switch to Parent
				swicthToWindow(driver, "Invoice");
				saveBtn.click();
			}
			
			private void waitforElementToBeClickable(WebDriver driver2, String subName) {
				// TODO Auto-generated method stub
				
			}

			public  void createInvoice(String subName , String invOrgName, String billAdd, String shipAdd) {
				subNameEdt.sendKeys(subName);
				organizationLookUpImage.click();
				//switch to Child
				swicthToWindow(driver, "Accounts&action");
				Organizations invOrgPage = new Organizations(driver);
				invOrgPage.getSearchEdt().sendKeys(invOrgName);
				invOrgPage.getSearchNow().click();
				driver.findElement(By.xpath("//a[text()='"+invOrgName+"']")).click();
				//switch to Parent
				swicthToWindow(driver, "Invoice");
				saveBtn.click();
				billAddEdt.sendKeys(billAdd);
				shipAddEdt.sendKeys(shipAdd);
				saveBtn.click();
			}
			
			public void createInvoice1(String invProdName) {
				prodLookUpImage.click();
				//switch to Child
				swicthToWindow(driver, "Products&action");
				Products invProdPage = new Products(driver);
				invProdPage.getSearchEdt().sendKeys(invProdName);
				invProdPage.getSearchNow().click();
				driver.findElement(By.xpath("//a[text()='"+invProdName+"']")).click();//maybe should use the link text
				//switch to Parent
				swicthToWindow(driver, "Invoice");
				saveBtn.click();
			}
			//
			//public void createInvoice(String invServName) {
				//prodLookUpImage.click();
				//switch to Child
				//swicthToWindow(driver, "Products&action");
				//Products invProdPage = new Products(driver);
				//invProdPage.getSearchEdt().sendKeys(invProdName);
				//invProdPage.getSearchNow().click();
				//driver.findElement(By.xpath("//a[text()='"+invProdName+"']")).click();//maybe should use the link text
				//switch to Parent
				//swicthToWindow(driver, "Invoice");
				//saveBtn.click();
			//}
				
				
		}
	
