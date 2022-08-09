package org.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail_Account_Creation {
	static String value;

	
	public String sending_data_to_google_acc() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mohammad\\eclipse-workspace\\SeleniumSample\\Driver\\chromedriver.exe");

		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.google.com/intl/en-GB/gmail/about/");
		d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("is opened");
		d.findElement(By.partialLinkText("Sign")).click();
		d.findElement(By.xpath("//span[contains(text(),'Create account')]")).click();
		d.findElement(By.xpath("//span[contains(text(),'For myself')]")).click();

		String pathofexcel = "C:\\Users\\Mohammad\\eclipse-workspace\\SeleniumSample\\Excel_Sheet\\DataDriven_Gmail.xlsx";
		File F = new File(pathofexcel);
		FileInputStream fis = new FileInputStream(F);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);

		for (int i = 1; i < sheetAt.getPhysicalNumberOfRows(); i++) {
			Row allrows = sheetAt.getRow(i);
			for (int j = 0; j < allrows.getPhysicalNumberOfCells(); j++) {
				Cell cell = allrows.getCell(j);
				CellType cellType = cell.getCellType();
				if (cellType.equals(CellType.STRING)) {
					value = cell.getStringCellValue();
				} else if (cellType.equals(CellType.NUMERIC)) {
					double numericcell = cell.getNumericCellValue();
					int data = (int) numericcell;
					value = String.valueOf(data);
				}
				

				if (j == 0) {
					WebElement firstname = d.findElement(By.id("firstName"));
					firstname.clear();
					firstname.sendKeys(value);

				}
				if (j == 1) {
					WebElement lastname = d.findElement(By.id("lastName"));
					lastname.clear();
					lastname.sendKeys(value);
				}
				if (j == 2) {
					WebElement username = d.findElement(By.id("username"));
					username.clear();
					username.sendKeys(value);
				}
				if (j == 3) {
					WebElement password = d.findElement(By.name("Passwd"));
					password.sendKeys(value);
				}
				if (j == 4) {
					WebElement confirmpassword = d.findElement(By.name("ConfirmPasswd"));
					confirmpassword.sendKeys(value);
					WebElement next = d.findElement(By.xpath("//span[contains(text(),'Next')]"));
					next.click();
				}
				if (j == 5) {
					WebElement phn = d.findElement(By.xpath("//input[@id='phoneNumberId']"));
					phn.click();
					phn.sendKeys(value);
				}
				
			}
			d.navigate().back();
		}
		d.close();
		wb.close();
		return pathofexcel;

	}

	public static void main(String[] args) throws IOException {

		Gmail_Account_Creation gmail = new Gmail_Account_Creation();

		gmail.sending_data_to_google_acc();
	}

}
