package com.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoPract {

	static WebDriver driver;
	
	public static void main(String[] args) {
		AutoPract ref= new AutoPract();
		ref.setup();
		SignInPage si= new SignInPage(driver);
		si.signIn();
		RegistrationPage rg= new RegistrationPage(driver);
		rg.registration();
		ref.teardown();
	}
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
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
