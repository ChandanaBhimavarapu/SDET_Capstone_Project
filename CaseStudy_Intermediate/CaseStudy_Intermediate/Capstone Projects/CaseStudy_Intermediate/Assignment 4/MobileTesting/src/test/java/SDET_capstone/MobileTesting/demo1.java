package SDET_capstone.MobileTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;



@Test
public class demo1 {
	
	public WebDriver driver;	
	public void AppiumApplcation() throws MalformedURLException{
		DesiredCapabilities cals=new DesiredCapabilities();
		cals.setCapability("platformName", "Android");
        cals.setCapability("deviceName", "MobileBharat"); // Replace with your Android version
        cals.setCapability("appPackage", "C:\\Users\\Rajesh\\Anil_workspace\\MobileTesting\\src\\test\\java\\Resource\\base.apk"); // Replace with your device name
        cals.setCapability("appActivity", "MainActivity"); // Replace with the path to your app's APK file
        cals.setCapability("automationName", "Uiautimator2");
        try {
        	UiAutomator2Options options=new UiAutomator2Options();
        	options.setDeviceName("MobileBharat");
        	options.setApp("C:\\\\Users\\\\Rajesh\\\\Anil_workspace\\\\MobileTesting\\\\src\\\\test\\\\java\\\\Resource\\\\base.apk");
        	AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
        	
        
        
		
		demo3 rb=new demo3(driver);
		
		rb.verifingnum9();
		rb.multipule();
		rb.verifingnum6();
		rb.Equals();
		
		
	} catch(Exception e) {
    	e.printStackTrace();
	}
        }
	}

		
		
				
		
	


	
	


		
		

