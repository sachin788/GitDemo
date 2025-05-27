package com.seltesting.myapp;

import java.util.Arrays;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/SACHIN/AppData/Local/Google/Chrome/User Data");
		WebDriver driver= new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		int c=0;
		String[] itemsNeeded= {"Cucumber", "Brocolli", "Beetroot"};
		List<WebElement> products= driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++) {
			String[] name=products.get(i).getText().split("-");
			//name[0]=Brocoli + space
			//remove space
			String formattedName=name[0].trim();
			//format to actual vegitabe name
			
			//check whether name you extracted is present in array or not-
			//convert array into arraylist for easy search(memory saving 
			//to convert String array into arrayList at runtime
			List itemsNeededList= Arrays.asList(itemsNeeded);
			
			if(itemsNeededList.contains(formattedName)) {
				c++;
               //click on add to cart			
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(c==3) {
					break;
				}
			}
		}
	}

}
