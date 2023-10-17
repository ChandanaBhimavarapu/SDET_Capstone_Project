package com.qa.pages;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagLogin_01_page {
	WebDriver driver;
	
	By Username = By.id("user-name");
	By Password= By.id("password");
	By button = By.id("login-button");
	
	public SwagLogin_01_page (WebDriver d)
	{
		driver=d;
	}
	
	
			
				public void enterUsername(String name) 
			{
				driver.findElement(Username).sendKeys(name);
			}
			public void enterPassword(String pass) 
			{
				driver.findElement(Password).sendKeys(pass);
			}
			public void clickbutton() 
			{
				driver.findElement(button).click();
			}
	

	
	


}

