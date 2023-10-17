package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SwagLogout_02 extends SwagLoginCart_01{
	WebDriver driver;
	@Test(priority=2)
	public void logout() throws InterruptedException, IOException {
		

	    logout1.clickmorebutton();
	  /*  WebElement strn = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
	    Boolean TF= strn.getText().equalsIgnoreCase("Checkout: Overview"); 
	    if(TF) {
	    	System.out.println("Everything is on right path");
	    }else {
	    	System.out.println("Not in a correct path");
	    }
	    */
	    Thread.sleep(2000);
	    logout1.clicklogoutbutton2();
	


}
}