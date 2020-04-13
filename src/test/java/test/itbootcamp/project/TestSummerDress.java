package test.itbootcamp.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import itbootcamp.project.DressesSummerDresses;
import itbootcamp.project.WomenSummerDresses;

public class TestSummerDress {

	WebDriver driver;

	@BeforeClass
	public void driverManage() {

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void testWomenToSummerDresses() {

		driver.get(WomenSummerDresses.url);

		WomenSummerDresses.women(driver);

		String x = "SUMMER DRESSES ";

		Assert.assertEquals(WomenSummerDresses.dressLoc(driver), x);
	}

	@Test(priority = 2)
	public void testDressesToSummerDresses() {
		
		driver.get(DressesSummerDresses.url2);

		DressesSummerDresses.women2(driver);

		String actualURL = "http://automationpractice.com/index.php?id_category=11&controller=category";

		String currentURL = DressesSummerDresses.urlLocation(driver);

		Assert.assertEquals(currentURL, actualURL);
		
	}

	@Test(priority = 3)
	public void testSamePageForFirtsTwoTests() {

		WomenSummerDresses.women(driver);
		String currentURL = driver.getCurrentUrl();

		DressesSummerDresses.women2(driver);
		
		Assert.assertEquals(DressesSummerDresses.urlLocation(driver), currentURL);

	}

	@AfterClass
	public void closeDriver() {
		driver.quit();
	}

}
