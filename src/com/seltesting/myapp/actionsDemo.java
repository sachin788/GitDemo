package com.seltesting.myapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/SACHIN/AppData/Local/Google/Chrome/User Data");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
//		driver.findElement(By.cssSelector("div[id='nav-link-accountList']"));
		Actions a= new Actions(driver);
		WebElement move= driver.findElement(By.cssSelector("div[id='nav-link-accountList']"));
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().perform();
		a.moveToElement(move).contextClick().build().perform();
		System.out.println("Git file updated code 1");
		System.out.println("Git file updated code 2");
		System.out.println("Git file updated code 3");
		System.out.println("Git file updated code 4");
		System.out.println("Git file updated code 5");
		
		
		System.out.println("Git file updated code 6");
		System.out.println("Git file updated code 7");
	}

}
