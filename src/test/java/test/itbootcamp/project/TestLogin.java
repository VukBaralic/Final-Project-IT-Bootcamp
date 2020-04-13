package test.itbootcamp.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import itbootcamp.project.LogIn;
import itbootcamp.project.Select2DressesAndRegister;

public class TestLogin {

	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void testLogin() {

		driver.get(LogIn.url);
		LogIn.clickSignInAndLogIn(driver, "vuk@email.com", "aaaaa");

		Select2DressesAndRegister.getLogoutElements(driver);

		Assert.assertNotEquals(Select2DressesAndRegister.getLogoutElements(driver).size(), 0);

	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}

}
