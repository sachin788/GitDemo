package com.seltesting.myapp;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/SACHIN/AppData/Local/Google/Chrome/User Data");
		WebDriver driver= new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        //windows switching and tab openings
//        driver.switchTo().newWindow(WindowType.WINDOW);
//        driver.get("https://rahulshettyacademy.com/angularpractice/");
//        Set<String> handles=driver.getWindowHandles();
//        Iterator<String> it=handles.iterator();
//        String parentWindowId=it.next();
//        String childWindowId=it.next();
//        driver.switchTo().window(childWindowId);
//        driver.get("https://rahulshettyacademy.com/");
//        String courseName= driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
//        driver.switchTo().window(parentWindowId);
        //screenshot particular element
        WebElement name=driver.findElement(By.cssSelector("input[name='name']"));
//        name.sendKeys(courseName);  
//        File file=name.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(file,new File("D://logo.png"));
        
        //Get Height and Width of web element
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
	}

}
