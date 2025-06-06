package com.seltesting.myapp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class fluentWaitTest {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/SACHIN/AppData/Local/Google/Chrome/User Data");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		Wait<WebDriver> wait= new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		  WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
			    	   return driver.findElement(By.cssSelector("[id='finish'] h4"));
			       }
			       else
			    	   return null;
			     }
			     });
		  System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
	}
}
