package com.seltesting.myapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("user-data-dir=C:/Users/SACHIN/AppData/Local/Google/Chrome/User Data");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));

		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
			System.out.println("its disabled");
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);

		}
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        getResult(driver);
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for (int j = 0; j < 4; j++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByValue("USD");
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}
	public static void getResult(WebDriver driver) {
		System.out.println("Passed");
	}

}


//driver.findElement(By.cssSelector(".react-date-picker__inputGroup__input.react-date-picker__inputGroup__month")).sendKeys(monthNumber);
//driver.findElement(By.cssSelector(".react-date-picker__inputGroup__input.react-date-picker__inputGroup__day")).sendKeys(day);
//driver.findElement(By.cssSelector(".react-date-picker__inputGroup__input.react-date-picker__inputGroup__year")).sendKeys(year);
//Thread.sleep(3000);
//Assert.assertEquals(driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getText(), "15/6/2027");
