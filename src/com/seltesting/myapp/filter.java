package com.seltesting.myapp;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class filter {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/SACHIN/AppData/Local/Google/Chrome/User Data");
		WebDriver driver= new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		//5 result
		List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));
		//1 result
		List<WebElement> filteredList=veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());
	    Assert.assertEquals(veggies.size(), filteredList.size());
	    
	}

}
