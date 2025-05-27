package com.seltesting.myapp;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LiveDemo {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/SACHIN/AppData/Local/Google/Chrome/User Data");
		WebDriver driver= new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        //click on column then it gets sorted
        //capture all web elements in to list (original list)
        // for each element , use getText into new list
        //sort in the original list of step3 ->sorted list
        //compare original list vs sorted list
        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> ls= driver.findElements(By.xpath("//tr/td[1]"));
        List<String> originalList= ls.stream().map(s->s.getText()).collect(Collectors.toList());
        List<String> sortedList=originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(originalList.equals(sortedList));
        
        List<String> price;
        //scan the name column with getText -> Beans -> print(price)
        do {
        	List<WebElement> rows= driver.findElements(By.xpath("//tr/td[1]"));
        price= rows.stream().filter(s-> s.getText().contains("Orange")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
        price.forEach(a->System.out.println(a));
        if(price.size()<1) {
            driver.findElement(By.cssSelector("[aria-label='Next']")).click();
        }
        }while(price.size()<1);
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		//tr/td[1]/following-sibling::td[1]
		String pricevalue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
 	}

}
	
