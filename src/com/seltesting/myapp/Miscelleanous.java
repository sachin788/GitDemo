package com.seltesting.myapp;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Miscelleanous {

	public static void main(String[] args) throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/SACHIN/AppData/Local/Google/Chrome/User Data");
		WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().deleteCookieNamed("sessionKey");
        //click on any link
        // login page- verify login url
//        driver.manage().addCookie(null);
//        driver.get("http://google.com");
//        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(src, new File("D://screenshot.png"));
        //broken url handling
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
       
//        String url= driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
//        HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
//        conn.setRequestMethod("HEAD");
//        conn.connect();
//        int rcode=conn.getResponseCode();
//        System.out.println(rcode);
        List<WebElement> links= driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a=new SoftAssert();
        for(WebElement link:links) {
        	 String url=link.getAttribute("href");
             HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
             conn.setRequestMethod("HEAD");
             conn.connect();
             int rcode=conn.getResponseCode();
             System.out.println(rcode);
             a.assertTrue(rcode<400, "The link with text "+link.getText()+" is broken with code: "+ rcode);        	
        }
        a.assertAll();
	}

}
