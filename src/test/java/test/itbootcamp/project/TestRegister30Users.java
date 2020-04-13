package test.itbootcamp.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import itbootcamp.project.RegisterUsers;
import itbootcamp.project.Select2DressesAndRegister;

public class TestRegister30Users {

	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void testRegisterUsers() throws IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream("src/test/resources/Users.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

		for (int i = 0; i < 30; i++) {

			driver.get(RegisterUsers.url);
			
					
			Row row = sheet.getRow(i);
			Cell cell;
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			RegisterUsers.emailToCreatUser(driver, row.getCell(0).getStringCellValue());			// email
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			RegisterUsers.enterData(driver, row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue(),
					row.getCell(3).getStringCellValue());							// name,lastName, password

			Thread.sleep(1000);
			
			RegisterUsers.enterBirthData(driver, row.getCell(4).getStringCellValue(), row.getCell(5).getStringCellValue(),
					row.getCell(6).getStringCellValue());							// days, months, year

			
			
			RegisterUsers.enterAddress(driver, row.getCell(7).getStringCellValue(), row.getCell(8).getStringCellValue(),
					row.getCell(9).getStringCellValue(), row.getCell(10).getStringCellValue(),
					row.getCell(11).getStringCellValue());							// street, city, state, postcode, phone

			RegisterUsers.clickButtonRegister(driver);

			SoftAssert as = new SoftAssert();
			as.assertNotEquals(Select2DressesAndRegister.getLogoutElements(driver).size(), 0);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			as.assertAll();

			RegisterUsers.logOutButton(driver);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}

	}

	@AfterClass
	public void off() {
		driver.quit();
	}

}
