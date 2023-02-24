package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static WebDriver driver;

	public static JavascriptExecutor js;

	public static Actions act;

	public static void browserLaunch() {

		WebDriverManager.edgedriver().setup();

		driver = new EdgeDriver();

	}

	public static void urlLaunch() throws InterruptedException {

		// driver.get("http://130.78.62.52:107/#/Login?IPADDRESS=172.22.80.1&MACHINE=DUC-xedvHCLAsTW");
		driver.get("https://130.78.62.52:444/#/Login");
		// Thread.sleep(2000);
		WebElement advanceOption = driver.findElement(By.id("details-button"));
		advanceOption.click();

		Thread.sleep(2000);
		driver.findElement(By.id("proceed-link")).click();

	}

	public static void maxWindow() {

		driver.manage().window().maximize();

	}

	public static void toPassInput(WebElement txtUser, String value) {

		txtUser.sendKeys(value);

	}

	public static void clickBtn(WebElement txtPass) {

		txtPass.click();

	}

	public static void impWait() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public static String excelRead(int rownum, int cellnum) throws IOException {

		File f = new File("C:\\Users\\ar287\\eclipse-workspace\\LIMS\\TestDatas\\Login - Copy.xlsx");

		FileInputStream fi = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fi);

		Sheet sheet = w.getSheet("credintials");

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);

		int cellType = cell.getCellType();

		String string = "";

		if (cellType == 1) {

			string = cell.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(cell)) {

			Date date = cell.getDateCellValue();

			SimpleDateFormat sim = new SimpleDateFormat("dd-mmm-yyyy");

			string = sim.format(date);

		} else {

			double numericCellValue = cell.getNumericCellValue();

			long l = (long) numericCellValue;

			string = String.valueOf(l);
		}

		return string;

	}

	public static void expWait(WebElement locator) {

		WebDriverWait we = new WebDriverWait(driver, Duration.ofSeconds(50));

		we.until(ExpectedConditions.visibilityOf(locator));

	}

}
