package com.crm.autodesk.quotetest;

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
import com.crm.autodesk.objectrrepositorylib.CreateNewQuote;
import com.crm.autodesk.objectrrepositorylib.CreateNewVendor;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Login;
import com.crm.autodesk.objectrrepositorylib.Products;
import com.crm.autodesk.objectrrepositorylib.Quotes;
import com.crm.autodesk.objectrrepositorylib.Vendors;
import com.crm.autodesk.objectrrepositorylib.VendorsInfo;
/**
 * 
 * @author RiChi
 *
 */

public class CreateQuote {
	/* object  Creation*/
	JavaUtils jLib = new JavaUtils();
	WebDriverUtiles wLib = new WebDriverUtiles();
	FileUtility flib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	
	@Test
	public void createQuote() throws Throwable {

		/* Common Data */
		int randomNum = jLib.generateRandomNum();
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		String URL = flib.getPropertyKeyValue("url");
		String BROWSER = flib.getPropertyKeyValue("browser");

		/* test Data */
		String subName = eLib.getExcelData("Quote", "tc_05", "SubName")+ randomNum;
		String carrier = eLib.getExcelData("Quote", "tc_05", "Carrier");
		String assigned = eLib.getExcelData("Quote", "tc_05", "AssignedTo");
		String quoteStage = eLib.getExcelData("Quote", "tc_05", "QuoteStage");

		//String contLastNAme = eLib.getExcelData("Quote", "tc_05", "contactName") + randomNum;

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
		        
		/*Step 2 : navigate to Quote page */
		  Home hp = new Home(driver);
			   hp.getQuoteLnk().click();    
			   
		/* step 3 : navigate to create Quote Page */
			   Quotes quoPage = new Quotes(driver);
			   quoPage.getCreateQuoteImg().click();
			
			   
		/* step 4 : create new Vendor with Subject name, QuoteStage, AssignedTo, OrgName */
			    CreateNewQuote createQuotePage = new CreateNewQuote(driver);
			    createQuotePage.create(vendorName, gl_Vend_Account);//Taken from this class test data 
			    
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
