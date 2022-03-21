package org.meta.facebook;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Hello world!
 *
 */
public class App 
{

    	WebDriver driver;
    	public static void main( String[] args ) throws MalformedURLException
    	{
    		App ref= new App();
    		ref.gridsetup();
    		ref.login();
    		ref.teardown();
    	}

    	public void gridsetup() throws MalformedURLException
    	{
    		DesiredCapabilities cap= new DesiredCapabilities();
    		cap.setCapability("browserName", "MicrosoftEdge");
    		cap.setCapability("platformName", "WIN10");
    		
    		driver= new RemoteWebDriver(new URL("http://192.168.0.95:4444/wd/hub"), cap);
    		driver.get("https://opensource-demo.orangehrmlive.com/");
    	}
    	
    	public void login()
    	{
    		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    		
    		
    		WebElement pass= driver.findElement(By.id("txtPassword"));
    		pass.sendKeys("admin123");
    		
    		WebElement logbut=	driver.findElement(By.id("btnLogin"));
    		logbut.click();
    	}
    	public void teardown()
    	{
    		try {
    			Thread.sleep(5000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    		driver.quit();
    	}

}
