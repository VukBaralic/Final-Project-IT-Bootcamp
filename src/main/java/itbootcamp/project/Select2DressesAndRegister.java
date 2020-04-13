package itbootcamp.project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Select2DressesAndRegister {

	public static WebDriverWait wait;

	public static String url = "http://automationpractice.com/index.php";

	public static void clikOnSummerDresses(WebDriver driver) {

		Actions p = new Actions(driver);
		wait = new WebDriverWait(driver, 3);
		WebElement womenDrs = driver.findElement(By.xpath("//a[@title='Women']"));

		p.moveToElement(womenDrs).perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Summer Dresses']")));

		driver.findElement(By.xpath("//a[@title='Summer Dresses']")).click();
	}

	public static void clickOnFirstDresses(WebDriver driver) {
	
		WebElement productListElement = driver.findElement(By.className("product_list"));

		List<WebElement> dressList = productListElement.findElements(By.tagName("li"));

		WebElement firstDress = dressList.get(0);

		Actions p = new Actions(driver);
		p.moveToElement(firstDress).perform();

		WebElement buttonContainer = firstDress.findElement(By.className("button-container"));
		System.out.println(buttonContainer != null);

		WebElement moreButton = buttonContainer.findElement(By.xpath("//a[@title='View']"));

		moreButton.click();
	}

	public static void choose2DressesSizeColorAndBy(WebDriver driver) {

		driver.findElement(By.name("Blue")).click();

		driver.findElement(By.name("group_1")).click();

		driver.findElement(By.xpath(
				"/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/div/fieldset[1]/div/div/select/option[2]"))
				.click();

		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/p[1]/a[2]"))
				.click();

		driver.findElement(By.cssSelector("button.exclusive")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']")));
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();

	}

	public static String checkCartItemsByName(WebDriver driver) {

		WebElement txt = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[2]/p/a"));

		String text = txt.getText();

		return text;
	}

	public static String checkCartItemsBySizeColor(WebDriver driver) {

		WebElement size_color = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[2]/small[2]/a"));

		String cart_check = size_color.getText();

		return cart_check;
	}

	public static String checkCartItemsByNumber(WebDriver driver) {

		String numberOfDresses = driver.findElement(By.id("summary_products_quantity")).getText();

		return numberOfDresses;
	}

	public static void proceedToReg(WebDriver driver) {
		driver.findElement(By.linkText("Proceed to checkout")).click();
	}

	public static void registration(WebDriver driver, String email) {

		driver.findElement(By.id("email_create")).sendKeys(email);

		driver.findElement(By.cssSelector("i.icon-user.left")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));

		driver.findElement(By.name("id_gender")).click();

		driver.findElement(By.name("customer_firstname")).sendKeys("vuk");

		driver.findElement(By.name("customer_lastname")).sendKeys("bara");

		driver.findElement(By.id("passwd")).sendKeys("bbbbb");

		driver.findElement(By.id("days")).sendKeys("5");

		driver.findElement(By.id("months")).sendKeys("m");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("option[value='3']")));
		driver.findElement(By.cssSelector("option[value='3']")).click();

		driver.findElement(By.id("years")).sendKeys("1991");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("option[value='1991']")));
		driver.findElement(By.cssSelector("option[value='1991']")).click();

		driver.findElement(By.id("address1")).sendKeys("484 ulica");

		driver.findElement(By.id("city")).sendKeys("Chicago");

		driver.findElement(By.id("id_state")).sendKeys("ii");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("option[value='13']")));
		driver.findElement(By.cssSelector("option[value='13']")).click();

		driver.findElement(By.id("postcode")).sendKeys("60000");

		driver.findElement(By.id("phone_mobile")).sendKeys("333-555");

		driver.findElement(By.cssSelector("button#submitAccount.btn.btn-default.button.button-medium")).click();

	}

	public static List<WebElement> getLogoutElements(WebDriver driver) {

		List<WebElement> listLogout = driver.findElements(By.className("logout"));

		return listLogout;
	}

}
