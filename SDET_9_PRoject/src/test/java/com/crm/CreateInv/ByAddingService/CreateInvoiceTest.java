package com.crm.CreateInv.ByAddingService;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.genericlib.FileUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.genericlib.WebDriverUtiles;
import com.crm.autodesk.objectrrepositorylib.CreateNewInvoice;
import com.crm.autodesk.objectrrepositorylib.CreateNewProduct;
import com.crm.autodesk.objectrrepositorylib.CreateNewVendor;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Invoices;
import com.crm.autodesk.objectrrepositorylib.InvoicesInfo;
import com.crm.autodesk.objectrrepositorylib.Login;
import com.crm.autodesk.objectrrepositorylib.Products;

public class CreateInvoiceTest extends BaseClass {
	/* object  Creation*/
	JavaUtils jLib = new JavaUtils();
	WebDriverUtiles wLib = new WebDriverUtiles();
	FileUtility flib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	
	@Test
	public void createInvoicesTest() throws Throwable {
			/* test Script data*/
			int randomNum = javaLib.generateRandomNum();
		/* test Data */
		String subName = eLib.getExcelData("contact", "tc_05", "SubjName")+ randomNum;
		String orgName = eLib.getExcelData("contact", "tc_05", "OrgName")+ randomNum;
		String billAdd = eLib.getExcelData("contact", "tc_05", "BillingAdd")+ randomNum;
		String shipAdd = eLib.getExcelData("contact", "tc_05", "ShippingAdd")+ randomNum;
		String prodName = eLib.getExcelData("contact", "tc_05", "ProdName")+ randomNum;
		String qty = eLib.getExcelData("contact", "tc_05", "Qty");
		
		        
		/*Step 2 : navigate to Invoice page */
		     Home hp = new Home(driver);
		     hp.getInvoiceLnk().click();     
		        
		/* step 3 : navigate to create Invoice Page */
			Invoices invPage = new Invoices(driver);
			invPage.getCreateInvImg().click();
			
		/* step 4 : create new Invoice with subject name, OrgName, Billing address and shipping address, ProdName */
		    CreateNewInvoice createInvPage = new CreateNewInvoice(driver);
		    createInvPage.createInvoice(subName, orgName, billAdd, shipAdd);
		    createInvPage.createInvoice1(prodName); //Taken from this class test data 
		    
		    /*verify */
		    InvoicesInfo info = new InvoicesInfo(driver);
		    String actSuccessfullMsg = info.getSuccessFullMsg().getText();
		    Assert.assertTrue(actSuccessfullMsg.contains(subName));	    
		    
		 /*step 6 : navigate to invoice Page */
			hp.getInvoiceLnk().click();
			
		/*step 7 :  search by invoice name and verify*/
			invPage.serachInvoice("Subject Name", subName);

			driver.findElement(By.linkText(subName)).click();
		       
}

	
		@Test
		public void createDeleteInv() throws Throwable {
			/* test Script data*/
			int randomNum = javaLib.generateRandomNum();
			/* test Data */
			String subName = eLib.getExcelData("contact", "tc_05", "SubjName")+ randomNum;
			//String productNAme = excelLib.getExcelData("product", 4, 2)+ randomNum;
			//String unitPRice = excelLib.getExcelData("product", 4, 3);
			
			/* step 2 : navigate to Invoice Page*/
			Home hp = new Home(driver);
			hp.getInvoiceLnk().click();
			
			/* Step 3: search by invoice name and verify*/
			Invoices invPage = new Invoices(driver);
			invPage.serachInvoice("Subject Name", subName);

			driver.findElement(By.linkText(subName)).click();
		       
			/* Step 4: Select a record and click on delete */
			invPage.getCheckBox().click();
			invPage.getDeleteBtn().click();
			Alert a =driver.switchTo().alert();
			Thread.sleep(1000);
			//To click on ok
			a.accept();
}
		@Test 
		public void createSearchAlp() throws Throwable {
			/* test Script data*/
			int randomNum = javaLib.generateRandomNum();
			/* test Data */
			//String subName = eLib.getExcelData("contact", "tc_05", "SubjName")+ randomNum;
			
			/* step 2 : navigate to Invoice Page*/
			Home hp = new Home(driver);
			hp.getInvoiceLnk().click();
			
			/* Step 3: search by invoice name and verify*/
			Invoices invPage = new Invoices(driver);
			invPage.getSearchEdt().click();

			invPage.getSearchAlp().click();
	}
	}
