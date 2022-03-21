package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelData {
	WebDriver driver;
	public static void main(String[] args) throws IOException {

		ExcelData ex= new ExcelData();
		ex.setup();
		ex.excel();
		ex.teardown();
	}

	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	public void excel() throws IOException
	{
		
		File f= new File("Resource/OrangeData.xlsx");
		
		FileInputStream fis= new FileInputStream(f);//converts to byte, so that java can understand the file
		
		XSSFWorkbook exc= new XSSFWorkbook(fis);//entire Excel
		XSSFSheet sheet= exc.getSheet("Sheet1");//entire sheet
		
		String gotUserName = null;
		String gotPassword = null;
		
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) 
		{
			
		gotUserName= sheet.getRow(i).getCell(0).getStringCellValue();
		gotPassword=sheet.getRow(i).getCell(1).getStringCellValue();
		
		System.out.println(gotUserName +" ===== "+gotPassword);
		}
		
		
		WebElement user= driver.findElement(By.xpath("//input[@name='txtUsername'][@type='text']"));
		user.sendKeys(gotUserName);

		WebElement pass= driver.findElement(By.cssSelector("input[name='txtPassword'][type='password']"));
		pass.sendKeys(gotPassword);

		WebElement but= driver.findElement(By.className("button"));
		but.click();

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
