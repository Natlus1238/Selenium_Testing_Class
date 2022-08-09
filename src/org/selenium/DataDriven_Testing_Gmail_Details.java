package org.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven_Testing_Gmail_Details {

	public static void main(String[] args) throws IOException {
//		String pathofexcel = "C:\\Users\\Mohammad\\eclipse-workspace\\SeleniumSample\\Excel_Sheet\\DataDriven_Gmail.xlsx";
		File F = new File("C:\\Users\\Mohammad\\eclipse-workspace\\SeleniumSample\\Excel_Sheet\\DataDriven_Gmail.xlsx");
		FileInputStream fis = new FileInputStream(F);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);

		for (int i = 1; i < sheetAt.getPhysicalNumberOfRows(); i++) {
			Row allrows = sheetAt.getRow(i);
			for (int j = 0; j < allrows.getPhysicalNumberOfCells(); j++) {
				Cell cell = allrows.getCell(j);
				CellType cellType = cell.getCellType();
				if (cellType.equals(CellType.STRING)) {
					System.out.println(cell.getStringCellValue());
				} else if (cellType.equals(CellType.NUMERIC)) {
					double numericcell = cell.getNumericCellValue();
					int data = (int) numericcell;
					System.out.println(String.valueOf(data));
				}

	}
		}
		
	}
}
