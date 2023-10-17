package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagLogout_02_page {
	WebDriver driver;
	By button = By.id("react-burger-menu-btn");
	By button1 = By.id("logout_sidebar_link");
	
	public SwagLogout_02_page (WebDriver r)
	{
		driver=r;
	}
	
	public void clickmorebutton() 
	{
		driver.findElement(button).click();
	}
	
	public void clicklogoutbutton2() 
	{
		driver.findElement(button1).click();
	}



}
