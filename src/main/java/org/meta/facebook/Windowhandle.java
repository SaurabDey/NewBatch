package org.meta.facebook;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Windowhandle {

	WebDriver driver;
	public static void main(String[] args) {
		Windowhandle ref= new Windowhandle();
		ref.setup();
		ref.checkWindows();
		ref.teardown();

	}
	
	public void setup()
	{
		System.setProperty("webdriver.edge.driver", "Resource/msedgedriver.exe");
		driver= new EdgeDriver();
		driver.get("https://www.freshersworld.com/");
		driver.manage().window().maximize();
	
	}

	public void checkWindows() 
	{
		
		WebElement remoteLink=driver.findElement(By.xpath("//a[text()='Employer']"));
		remoteLink.click();
		
		String parentWindow= driver.getWindowHandle();//jobs
		
		Set<String>allWindows= driver.getWindowHandles();//jobs,entry
		
		for (String win : allWindows) {
			
			driver.switchTo().window(win);
		}
		
		
		WebElement postJob=driver.findElement(By.xpath("//span[text()='Employer Registration']"));
		postJob.click();
		
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
