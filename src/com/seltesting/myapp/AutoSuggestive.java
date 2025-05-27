package com.seltesting.myapp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
//		ChromeOptions options= new ChromeOptions();
//		options.addArguments("user-data-dir=C:/Users/SACHIN/AppData/Local/Google/Chrome/User Data");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> optionss=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option :optionss) {
			if(option.getText().equalsIgnoreCase("India")){
				option.click();
				break;
			}
		}
	}

}
