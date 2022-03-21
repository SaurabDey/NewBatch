package org.meta.facebook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassSelenium {

	WebDriver driver;
	public static void main(String[] args) {
		ActionClassSelenium ref= new ActionClassSelenium();
		ref.setup();
		ref.checkDragNDrop();
		ref.teardown();

	}
	
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
	}

	public void checkDragNDrop() 
	{
		WebElement frame1=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(frame1);
		
		WebElement xzy= driver.findElement(By.id("draggable"));
		
		WebElement lmn= driver.findElement(By.id("droppable"));
		
		Actions act= new Actions(driver);
		
		act.dragAndDrop(xzy, lmn).perform();
	
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
