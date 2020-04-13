package itbootcamp.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogIn {

	
	public static WebDriverWait wait;

	public static String url = "http://automationpractice.com/index.php";

	public static void clickSignInAndLogIn(WebDriver driver, String email, String password) {
		wait = new WebDriverWait(driver, 3);
		
		driver.findElement(By.className("login")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

		driver.findElement(By.id("email")).sendKeys(email);

		driver.findElement(By.id("passwd")).sendKeys(password);

		driver.findElement(By.id("SubmitLogin")).click();
	}

}
