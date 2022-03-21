package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

	WebDriver driver;
	 
	By locator_gender= By.id("uniform-id_gender1");
	By locator_FirstName=By.id("customer_firstname");
	By locator_lastName=By.name("customer_lastname");
	By locator_pass=By.xpath("//input[@type='password']");
	
	public RegistrationPage(WebDriver driver2) {
		driver = driver2;
	}
	
	public void registration()
	{
		WebElement gender= driver.findElement(locator_gender);
		gender.click();
		
		WebElement firstname= driver.findElement(locator_FirstName);
		firstname.sendKeys("Saurab");
		
		WebElement lastname= driver.findElement(locator_lastName);
		lastname.sendKeys("Dey");
		
		WebElement pass= driver.findElement(locator_pass);
		pass.sendKeys("MyassppDey");
		
	}
}
