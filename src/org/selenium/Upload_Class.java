package org.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Upload_Class {

	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mohammad\\eclipse-workspace\\SeleniumSample\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.ilovepdf.com/pdf_to_word");
		
		driver.findElement(By.id("pickfiles")).click();
		
		StringSelection str = new StringSelection("C:\\Users\\Mohammad\\Downloads\\IOS\\Naukri_AnoopGupta[10y_0m].pdf");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		
		Robot r = new Robot();
		
	    // press Contol+V for pasting the path
	     r.keyPress(KeyEvent.VK_CONTROL);
	     r.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting 
	    r.keyRelease(KeyEvent.VK_CONTROL);
	    r.keyRelease(KeyEvent.VK_V);
	 
	    // for pressing and releasing Enter 
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	   }

	}


