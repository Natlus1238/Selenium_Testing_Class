package org.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Sample {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mohammad\\eclipse-workspace\\SeleniumSample\\Driver\\chromedriver.exe");
		
		WebDriver d = new ChromeDriver();
		
		d.manage().window().maximize();
		
		d.get("https://app.bullhornstaffing.com");
		System.out.println("is opened");
		
		String u1 = d.getTitle();
		System.out.println(u1);
		
		String u = d.getCurrentUrl();
		System.out.println(u);
		
		d.navigate().to("https://twitter.com/i/flow/login");
		d.navigate().forward();
		d.navigate().back();
		Thread.sleep(4000);
		d.navigate().refresh();
		
	}

}
