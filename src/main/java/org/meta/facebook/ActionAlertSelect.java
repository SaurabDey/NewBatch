package org.meta.facebook;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionAlertSelect {

	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		ActionAlertSelect ref= new ActionAlertSelect();
		ref.setup();
		ref.mousehoverAndSelect();
		ref.teardown();

	}
	
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://court.mah.nic.in/courtweb/index_eng.php#");
	}

	public void mousehoverAndSelect() throws InterruptedException 
	{
		WebElement caseS= driver.findElement(By.xpath("//a[text()='Case Status']"));
		WebElement filingNum= driver.findElement(By.xpath("//a[text()='Filing Number']"));
		
		Actions act= new Actions(driver);
		act.moveToElement(caseS).pause(Duration.ofSeconds(2)).moveToElement(filingNum).click().build().perform();

		
		Alert art= driver.switchTo().alert();
		art.accept();
		
		Thread.sleep(5000);
		
		WebElement dist= driver.findElement(By.id("sess_dist_code"));
		
		Select sel = new Select(dist);
		//sel.selectByIndex(3);
		//sel.selectByValue("34");
		sel.selectByVisibleText("Nashik-नाशिक");
		
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
