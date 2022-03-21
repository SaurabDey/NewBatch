package org.meta.facebook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameClass {

	WebDriver driver;
	public static void main(String[] args) {
		FrameClass ref= new FrameClass();
		ref.setup();
		ref.checkFrames();
		ref.teardown();

	}
	
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
	}

	public void checkFrames() 
	{
		WebElement frame1= driver.findElement(By.xpath("//iframe[@name='packageListFrame']"));
		
		driver.switchTo().frame(frame1);

		WebElement firtsLink= driver.findElement(By.xpath("//a[text()='org.openqa.selenium.chrome']"));
		firtsLink.click();
		
		driver.switchTo().defaultContent();
		
		WebElement frame2= driver.findElement(By.xpath("//iframe[@name='packageFrame']"));
		
		driver.switchTo().frame(frame2);
		
		WebElement secondlink= driver.findElement(By.xpath("//a[text()='ChromeDriverInfo']"));
		secondlink.click();
		
		
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
