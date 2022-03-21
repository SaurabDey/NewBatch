package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

	WebDriver driver;
	By locator_emailID=By.id("email_create");
	By locator_CreateButton=By.id("SubmitCreate");
	
	public SignInPage(WebDriver driver2) 
	{
		driver=driver2;
	}
	
	public void signIn()
	{
		WebElement emailText= driver.findElement(locator_emailID);
		emailText.sendKeys("sau123@gmail.com");
		
		WebElement creatAccount= driver.findElement(locator_CreateButton);
		creatAccount.click();
		
	}

}
