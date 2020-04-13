package itbootcamp.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class DressesSummerDresses {

	public static final String url2 = "http://automationpractice.com/index.php";

	public static void women2(WebDriver driver) {

		Actions p = new Actions(driver);

		WebElement drsWomen = driver
				.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a"));

		p.moveToElement(drsWomen).perform();

		driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[3]/a")).click();

	}
	public static String urlLocation(WebDriver driver) {
		
		String currentLocation = driver.getCurrentUrl();
		
		return currentLocation;
	}

}
