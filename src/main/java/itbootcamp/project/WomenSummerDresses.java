package itbootcamp.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomenSummerDresses {

	
	public static WebDriverWait wait;
	
	public static String url = "http://automationpractice.com/index.php";
	
	public static void women(WebDriver driver) {
	
	wait = new WebDriverWait(driver, 3);
	Actions a = new Actions(driver);
	
	WebElement womenDrs = driver.findElement(By.xpath("//a[@title='Women']"));
	
	a.moveToElement(womenDrs).perform();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Summer Dresses']")));
	
	driver.findElement(By.xpath("//a[@title='Summer Dresses']")).click();
	
	}
	
	
	public static String dressLoc(WebDriver driver) {
	
	WebElement summerDress = driver.findElement(By.cssSelector("span.cat-name"));
	String text = summerDress.getText();
	return text;
	
	}
	
	
	
	
	
}
