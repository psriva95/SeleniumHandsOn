package LearnSelenium.LearnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		// 1. No returning of web element, performing actions only
		driver.findElement(By.id("")).sendKeys("Pooja");
		// 2. return web element and use later
		WebElement email = driver.findElement(By.id(""));
		email.sendKeys("pooja");
		// 3.By locator
		By byemail = By.id("input-email");
		By pass = By.id("input-password");
		driver.findElement(byemail).sendKeys(" ");

		// 4.By locator generic function

		By byemail1 = By.id("input-email");
		By pass1 = By.id("input-password");

		getElement(byemail1).sendKeys("abc");

		// 5.By locator generic function +actions
		doSendKeys(byemail, "abc");

		// 6.By locator generic function +actions in element Util class
		ElementUtil elementUtil = new ElementUtil(driver);
		elementUtil.doSendKeys(byemail1, "abc");
		elementUtil.doSendKeys(pass1, "avx");

		// 7.browser Util+e elemtnt util

		// 8.String locator --> By Locator
		String email_id = "input-email";

		getElement(getBy("id", email_id));
		doSendKeys(getBy("id", email_id), "abc");

	}

	public static By getBy(String locatorType, String locatorValue) {

		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		default:
			break;
		}
		return locator;
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSendKeys(By locator, String Value) {
		getElement(locator).sendKeys(Value);
	}
}
