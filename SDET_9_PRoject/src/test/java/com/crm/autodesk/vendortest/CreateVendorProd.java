package com.crm.autodesk.vendortest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.genericlib.FileUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.genericlib.WebDriverUtiles;
import com.crm.autodesk.objectrrepositorylib.CreateNewProduct;
import com.crm.autodesk.objectrrepositorylib.CreateNewVendor;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Login;
import com.crm.autodesk.objectrrepositorylib.Products;
import com.crm.autodesk.objectrrepositorylib.Vendors;
import com.crm.autodesk.objectrrepositorylib.VendorsInfo;

public class CreateVendorProd {
	/* object  Creation*/
	JavaUtils jLib = new JavaUtils();
	WebDriverUtiles wLib = new WebDriverUtiles();
	FileUtility flib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	
	@Test
	public void createVendorTest() throws Throwable {

		/* Common Data */
		int randomNum = jLib.generateRandomNum();
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		String URL = flib.getPropertyKeyValue("url");
		String BROWSER = flib.getPropertyKeyValue("browser");
		
		/* test Data */
		row
		String prodName = eLib.getExcelData("contact", "tc_03", "ProdName")+ randomNum;
		String prodCategory = eLib.getExcelData("contact", "tc_03", "ProdCategory");
		String gl_Prod_Account = eLib.getExcelData("contact", "tc_03", "GLAccount");
		String manuf = eLib.getExcelData("contact", "tc_03", "Manufacturer") + randomNum;
		
		String vendorName = eLib.getExcelData("contact", "tc_03", "VendorName")+ randomNum;
		String gl_Vend_Account = eLib.getExcelData("contact", "tc_03", "GLAccount");

		/* step 1 : login to APP */
		WebDriver driver = null;
		 if(BROWSER.equalsIgnoreCase("firefox")) {
		    driver= new FirefoxDriver();  
		 }else if(BROWSER.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		 }else if(BROWSER.equalsIgnoreCase("ie")) {
			 driver = new InternetExplorerDriver();
		 }
		
		wLib.waitForHTMLDOM(driver);
		driver.get(URL);

		/* step 1 : login to APP */
		  Login lp = new Login(driver);
		  lp.loginToApp(USERNAME, PASSWORD);
		        
		/*Step 2 : navigate to Vendor page */
		     Home hp = new Home(driver);
		     hp.getVendLnk().click();     
		        
		/* step 3 : navigate to create Vendor Page */
			Vendors vendPage = new Vendors(driver);
			vendPage.getCreateVendImg().click();
			
		/* step 4 : create new Vendor with Vendor name and GL Account*/
		    CreateNewVendor createVendPage = new CreateNewVendor(driver);
		    createVendPage.createVendor(vendorName, gl_Vend_Account);//Taken from this class test data 
		    
		    /*verify */
		    VendorsInfo info = new VendorsInfo(driver);
		    String actSuccessfullMsg = info.getSuccessFullMsg().getText();
		    Assert.assertTrue(actSuccessfullMsg.contains(vendorName));	    
		    
		/* step 5 :  navigate to Product page */
		    hp.getProdLnk().click();

		/* step 6 : navigate to create Product page */
		    Products cp = new Products(driver);
		    cp.getCreateProdImg().click();

		/* step 7 : create new Product with Vendor */
            CreateNewProduct cnp = new CreateNewProduct(driver);
            cnp.createProduct(prodName, vendorName);

		 /* step 8 : verify */
		
		 /* step 9 : logout & close */
            hp.logout();
            driver.close();    
		    
		        

}


}
