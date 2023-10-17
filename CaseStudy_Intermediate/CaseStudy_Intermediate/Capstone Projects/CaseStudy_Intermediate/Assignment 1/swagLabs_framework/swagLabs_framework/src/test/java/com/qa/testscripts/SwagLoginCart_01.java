package com.qa.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

public class SwagLoginCart_01 extends SwagLogin_01 {
	@Test(priority=1)
	public void cart() throws IOException, InterruptedException {
		
		runner.getAddToCart().click();
		  captureScreenshot(driver,"Cart");
		Thread.sleep(2000);
		runner.getclickCartSymbol().click();
		  captureScreenshot(driver,"Cartpage");
		Thread.sleep(2000);
		runner.getclickCheckOut().click();
		  captureScreenshot(driver,"Checkout");
		Thread.sleep(2000);
		
		runner.getenterFname().sendKeys(prop.getProperty("Fname"));
		
		runner.getenterLname().sendKeys(prop.getProperty("Lname"));
		
		runner.getenterZipcode().sendKeys(prop.getProperty("Zip"));
		  captureScreenshot(driver,"DetailsEntry");
		Thread.sleep(3000);
		
		runner.getclickContinue().click();
		
		

}
}
