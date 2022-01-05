package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class readExcel {

	public static String getCellValue(String actual) throws IOException {

		FileInputStream reader = null;
		XSSFWorkbook wb = null;
		XSSFSheet sheet = null;
		String elementStr = " ";
		String finalStr = "";
		try {
			File excelFile = new File(
					"C://Users//Rahul Zagade//eclipse-workspace1//seleniumFrameworkTestNG//src//Elements.xlsx");
			reader = new FileInputStream(excelFile);
			wb = new XSSFWorkbook(reader);
			sheet = wb.getSheet("webElements");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			e.getCause();
			reader.close();
		}
		int rows = sheet.getLastRowNum();

		try {
			for (int i = 0; i <= rows; i++) {
				Row row = sheet.getRow(i);
				String expected = row.getCell(0).getStringCellValue();
				if (actual.equalsIgnoreCase(expected)) {
					for (int j = 1; j < row.getLastCellNum(); j++) {
						Cell c = row.getCell(j);
						if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK)
							continue;
						elementStr = row.getCell(j).getStringCellValue();
						if (elementStr != null) {
							// System.out.println("correspong value is " + elementStr);
							Row row1 = sheet.getRow(0);
							String elementType = row1.getCell(j).getStringCellValue();
							finalStr = elementStr.concat("__");
							finalStr = finalStr.concat(elementType);
							return finalStr;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
			reader.close();
		}
		reader.close();
		return finalStr;

	}

	public static WebElement getElement(WebDriver driver,String elementName) throws IOException {
		
		WebElement element = null;
		String value = getCellValue(elementName);
		if (value == " ") {
			System.out.println("Specified element is not found in the excel elements");
		} else {
			System.out.println("The Element is " + value);
		}
		String[] elements = value.split("__");
		
		
		if (elements[1].equalsIgnoreCase("Name")) {
			element = driver.findElement(By.name(elements[0]));
			element.click();
		} else if (elements[1].equalsIgnoreCase("Id")) {
			element = driver.findElement(By.id(elements[0]));
			element.click();
		} else if (elements[1].equalsIgnoreCase("Xpath")) {
			element = driver.findElement(By.xpath(elements[0]));
			//element.click();
		} else if (elements[1].equalsIgnoreCase("Cssselector")) {
			element = driver.findElement(By.cssSelector(elements[0]));
			element.click();
		} else if (elements[1].equalsIgnoreCase("Class")) {
			element = driver.findElement(By.className(elements[0]));
			element.click();
		} else {
			System.out.println("Not matching locator found in excel for element");
		}
		return element;

	}

	
}
