package com.qa.testscripts;

import org.testng.annotations.AfterClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.SwagLoginCart_01_page;
import com.qa.pages.SwagLogin_01_page;
import com.qa.pages.SwagLogout_02_page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	WebDriver driver;
    SwagLogin_01_page details;
    SwagLoginCart_01_page runner;
    SwagLogout_02_page logout1;
    FileInputStream fileLoc;
    Properties prop;
   
    
	
	
	@Parameters({"Browser"})
	@BeforeClass
	public void setUp(String Browser) throws InterruptedException, IOException 
	{
		fileLoc= new FileInputStream("C:\Users\MC2021\Downloads\CaseStudy_Intermediate\CaseStudy_Intermediate\Capstone Projects\CaseStudy_Intermediate\Assignment 1\swagLabs_framework\swagLabs_framework\src\test\java\com\qa\testdata\AddressDetails.properties");
		prop= new Properties();
		prop.load(fileLoc);
		if(Browser.equalsIgnoreCase("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();
		    driver= new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
	
		
		driver.manage().window().maximize();
	    driver.get("https://www.saucedemo.com/");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	
	   details = new SwagLogin_01_page(driver);
	   Thread.sleep(3000);
	   runner= new SwagLoginCart_01_page(driver);
	   Thread.sleep(3000);
	   
	   logout1= new SwagLogout_02_page(driver);
	}
			
			
        
	@AfterClass
	public void teardown() {
		driver.close();
	}
	
    	public void captureScreenshot(WebDriver driver,String tname)throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png");
		FileUtils.copyFile(source, target);
 		
	}
}

