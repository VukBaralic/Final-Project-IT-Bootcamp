package itbootcamp.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterUsers {

	static WebDriverWait wait;
	public static String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

	public static void emailToCreatUser(WebDriver driver, String email) {
		wait = new WebDriverWait(driver, 2);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
		driver.findElement(By.id("email_create")).sendKeys(email);

		driver.findElement(By.cssSelector("i.icon-user.left")).click();

	}

	public static void enterData(WebDriver driver, String name, String lastname, String password) {
		wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer_firstname")));
		driver.findElement(By.name("customer_firstname")).sendKeys(name);

		driver.findElement(By.name("customer_lastname")).sendKeys(lastname);

		driver.findElement(By.id("passwd")).sendKeys(password);

	}

	public static void enterBirthData(WebDriver driver, String days, String months, String years) {

		wait = new WebDriverWait(driver, 2);
		
		
		driver.findElement(By.id("days")).sendKeys(days);

		driver.findElement(By.id("months")).sendKeys(months);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("option[value='3']")));
		driver.findElement(By.cssSelector("option[value='3']")).click();

		driver.findElement(By.id("years")).sendKeys(years);

		driver.findElement(By.cssSelector("option[value='1991']")).click();
	}

	public static void enterAddress(WebDriver driver, String street, String city, String state, String postalCode,
			String phone) {

		wait = new WebDriverWait(driver, 2);

		driver.findElement(By.id("address1")).sendKeys(street);

		driver.findElement(By.id("city")).sendKeys(city);

		driver.findElement(By.id("id_state")).sendKeys("ii");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("option[value='13']")));
		driver.findElement(By.cssSelector("option[value='13']")).click();

		driver.findElement(By.id("postcode")).sendKeys(postalCode);

		driver.findElement(By.id("phone_mobile")).sendKeys(phone);
	}

	public static void clickButtonRegister(WebDriver driver) {

		driver.findElement(By.cssSelector("button#submitAccount.btn.btn-default.button.button-medium")).click();

	}

	public static void logOutButton(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.findElement(By.className("logout")).click();
	}

}