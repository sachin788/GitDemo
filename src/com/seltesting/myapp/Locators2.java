package com.seltesting.myapp;

import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Locators2 {

	public static void main(String[] args) throws InterruptedException{
		String name="sachin";
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SACHIN\\Documents\\chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SACHIN\\Documents\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SACHIN\\Documents\\msedgedriver.exe");

//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("user-data-dir=C:/Users/SACHIN/AppData/Local/Google/Chrome/User Data/");
//		options.addArguments("profile-directory=Default"); 
		
		WebDriver driver = new EdgeDriver();
		String password=getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
//		Thread.sleep(5000);
	    driver.findElement(By.id("inputUsername")).sendKeys(name);
	    driver.findElement(By.name("inputPassword")).sendKeys(password);

	    driver.findElement(By.className("signInBtn")).click();
	    Thread.sleep(2000);
	    System.out.println(driver.findElement(By.tagName("p")).getText());
	    Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
	    Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+ name + ",");
	    driver.findElement(By.xpath("//button[text()='Log Out']")).click();
	    
	    driver.close();
	    }
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
	    String passwordText= driver.findElement(By.cssSelector("form p")).getText();
	    String[] passwordArray= passwordText.split("'");
	    String password=passwordArray[1].split("'")[0];
	    return password;
	}

}
