package com.seltesting.myapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GmailAutomation {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/SACHIN/AppData/Local/Google/Chrome/User Data");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox");
		Thread.sleep(5000);
        driver.findElement(By.cssSelector("div[jscontroller='eIu7Db']")).click();
        driver.findElement(By.id(":u0")).sendKeys("radhaanu11401@gmail.com");
	}

}
