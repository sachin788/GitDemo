package com.seltesting.myapp;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("user-data-dir=C:/Users/SACHIN/AppData/Local/Google/Chrome/User Data");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qaclickacademy.com/practice.php");
//1. Give counts of link in the page.
		//a
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerdriver= driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
        WebElement columndriver= footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columndriver.findElements(By.tagName("a")).size());
        
       // click on each link in the column and check if the pages are opening;
        for(int i=0;i<columndriver.findElements(By.tagName("a")).size();i++){
        	String clickonlink= Keys.chord(Keys.CONTROL,Keys.ENTER);
        	columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
        	Thread.sleep(5000);
        	
        	
        }
        Set<String> st= driver.getWindowHandles();
    	Iterator<String> it= st.iterator();
        while(it.hasNext()){
    		driver.switchTo().window(it.next());
    		System.out.println(driver.getTitle());
    	}
}
}
 