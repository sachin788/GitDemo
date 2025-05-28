package com.seltesting.myapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/SACHIN/AppData/Local/Google/Chrome/User Data");
		WebDriver driver= new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(2000);
		driver.findElement(By.name("name")).sendKeys("sachin");
		driver.findElement(By.name("email")).sendKeys("sahilkukreja667@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("sahilkukreja667");
		Thread.sleep(2000);
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(1);
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("04-05-2000");
        driver.findElement(By.className("btn")).click();
        driver.findElement(By.cssSelector(".alert-success"));
        String messageText = driver.findElement(By.cssSelector(".alert-success")).getText();
        System.out.println(messageText);
       
		
	}

}
