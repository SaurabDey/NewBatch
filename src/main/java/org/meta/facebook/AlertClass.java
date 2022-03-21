package org.meta.facebook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertClass {

	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		AlertClass ref= new AlertClass();
		ref.setup();
		ref.clickAlert();
		ref.teardown();

	}
	
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://output.jsbin.com/usidix/1");
	}

	public void clickAlert() throws InterruptedException
	{

		driver.findElement(By.xpath("//input[@type='button']")).click();
		
		Alert xyz= driver.switchTo().alert();
		
		System.out.println(xyz.getText());
		
		
		xyz.accept();
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
