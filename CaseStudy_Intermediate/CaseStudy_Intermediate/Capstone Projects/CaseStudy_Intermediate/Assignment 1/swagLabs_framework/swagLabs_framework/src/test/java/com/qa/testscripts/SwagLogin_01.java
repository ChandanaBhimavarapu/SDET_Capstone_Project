package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;



public class SwagLogin_01 extends TestBase{
	
	@Test(priority=0)
	public void login() throws IOException, InterruptedException {
		

		
	
	    
	    details.enterUsername("standard_user");
	    details.enterPassword("secret_sauce");
	    Thread.sleep(2000);
	    details.clickbutton();
	    Thread.sleep(2000);
	    
	    
	    String title = driver.getCurrentUrl();
	    
	    if(title.contains("saucedemo")) {
	    	Assert.assertTrue(title.contains("saucedemo"));
	    	System.out.println("successfully login");
	    	captureScreenshot(driver,"SwagLogin");
	    }
	    else 
	    {
	    	captureScreenshot(driver,"SwagLoginError");
	    	System.out.println("Not successfully login");
	    	Assert.assertTrue(title.contains("saucedemo"));
	    	
	    }
	    
		}
		
	}
	
	
	


