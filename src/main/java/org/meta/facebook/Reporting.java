package org.meta.facebook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting {

	public static void main(String[] args) throws InterruptedException {
		
		ExtentReports extent = new ExtentReports();
		
		ExtentSparkReporter spark = new ExtentSparkReporter("Resource/Selenium.html");
		//spark.config().setTheme(Theme.DARK);
		
		extent.attachReporter(spark);
		
		ExtentTest test = extent.createTest("Saurab Selenium");
					
		
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		test.log(Status.INFO, "My Chrome browser is opening successfully!!");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		test.log(Status.INFO, "I am opening automation practice site!!");
		
		WebElement emailText= driver.findElement(By.id("email_create"));
		emailText.sendKeys("sau123@gmail.com");
		test.log(Status.PASS, "I have successfully entered email for registration");
		
		WebElement creatAccount= driver.findElement(By.id("SubmitCreate"));
		creatAccount.click();
		test.log(Status.PASS, "I click on create account buttton successfully");
		
		WebElement gender= driver.findElement(By.id("uniform-id_gender1"));
		gender.click();
		test.log(Status.PASS, "I click on Gender");
		
		WebElement firstname= driver.findElement(By.id("customer_firstname"));
		firstname.sendKeys("Saurab");
		test.log(Status.PASS, "I enetred first name successfully");
		
		WebElement lastname= driver.findElement(By.name("customer_lastname"));
		lastname.sendKeys("Dey");
		test.log(Status.PASS, "I enetred last name successfully");
		
		WebElement pass= driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys("MyassppDey");
		test.log(Status.PASS, "I enetred password successfully");
		
		test.log(Status.PASS, "My Resitration was successfully!!!");
		
		
		Thread.sleep(5000);
		driver.quit();
		test.log(Status.INFO, "I am closing the browser!!!");
		
		extent.flush();
	}

}
