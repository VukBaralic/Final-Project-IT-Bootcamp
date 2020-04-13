package test.itbootcamp.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import itbootcamp.project.Select2DressesAndRegister;

public class TestCartAndRegistration {

	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void testDressesInCart() {
		driver.get(Select2DressesAndRegister.url);

		Select2DressesAndRegister.clikOnSummerDresses(driver);
		Select2DressesAndRegister.clickOnFirstDresses(driver);
		Select2DressesAndRegister.choose2DressesSizeColorAndBy(driver);
		
		String checkDressesName = "Printed Summer Dress";
		String checkSizeAndColor = "Color : Blue, Size : M";
		String numberOfDresses = "2 Products";

		SoftAssert sa = new SoftAssert();

		sa.assertEquals(Select2DressesAndRegister.checkCartItemsByName(driver), checkDressesName);
		sa.assertEquals(Select2DressesAndRegister.checkCartItemsBySizeColor(driver), checkSizeAndColor);
		sa.assertEquals(Select2DressesAndRegister.checkCartItemsByNumber(driver), numberOfDresses);

		sa.assertAll();

	}

	@Test(priority = 2)
	public void testRegistrationAndLogIn() {

		Select2DressesAndRegister.proceedToReg(driver);

		Select2DressesAndRegister.registration(driver, "neko@email.com");

		Select2DressesAndRegister.getLogoutElements(driver);

		Assert.assertNotEquals(Select2DressesAndRegister.getLogoutElements(driver).size(), 0);

	}

	@AfterClass
	public void close() {
		driver.quit();
	}
}
