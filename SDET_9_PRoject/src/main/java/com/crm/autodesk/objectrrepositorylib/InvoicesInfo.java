package com.crm.autodesk.objectrrepositorylib;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class InvoicesInfo {
		public InvoicesInfo(WebDriver driver) {             
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//span[@class='lvtHeaderText']")
		  private WebElement successFullMsg;


		public WebElement getSuccessFullMsg() {
			return successFullMsg;
		}
		
		
	}


}
