package com.seltesting.myapp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelIntroduction  {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SACHIN\\Documents\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/SACHIN/AppData/Local/Google/Chrome/User Data/");
		options.addArguments("profile-directory=Default"); 
 
		WebDriver driver = new ChromeDriver(options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
	    driver.findElement(By.id("inputUsername")).sendKeys("sachin");
	    driver.findElement(By.name("inputPassword")).sendKeys("sadass");
	    
	    driver.findElement(By.className("signInBtn")).click();
	    System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
	    driver.findElement(By.linkText("Forgot your password?")).click();
	    driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
	    driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("monti@gmail.com");
	    driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
	    driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("johnmac@rsa.com");
	    driver.findElement(By.xpath("//form/input[3]")).sendKeys("9188959965");
	    driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

	    System.out.println(driver.findElement(By.cssSelector("form p")).getText());
	    driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("#inputUsername")).sendKeys("sachin");
	    driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
	    driver.findElement(By.id("chkboxOne")).click();
	    driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.className("logout-btn")).click();
	   
//	    System.out.println(driver.findElement(By.tagName("p")).getText());
	    
	}
}
