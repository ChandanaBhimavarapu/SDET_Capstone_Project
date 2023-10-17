package SDET_capstone.MobileTesting;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Caluculator {
	@Test
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
        	
        	driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        	Thread.sleep(3000);
        	driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
        	Thread.sleep(3000);
        	driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
        	Thread.sleep(3000);
        	driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        	
        } catch(Exception e) {
        	e.printStackTrace();
        	
        	
        }}
        
        public void captureScreenshot(WebDriver driver,String tname)throws IOException {
    		TakesScreenshot ts=(TakesScreenshot)driver;
    		File source=ts.getScreenshotAs(OutputType.FILE);
    		File target=new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png");
    		FileUtils.copyFile(source, target);
	}

}
