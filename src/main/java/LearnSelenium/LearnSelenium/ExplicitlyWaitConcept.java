package LearnSelenium.LearnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * applicable for all the elements - will be applied for all driver.findElement statements , alerts:url:title
 * 
 */
public class ExplicitlyWaitConcept {
	static WebDriver driver ;
	public static void main(String[] args) {
		
		/*
		 * Explicit Wait
		 * 		> WebDriverWait
		 * 		> Fluent Wait
		 * 
		 * WebDriverWait(c) is extending Fluent Wait
		 * Fluent(c) implements Wait Interface(I)
		 */
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://demo.opencart.com/index.php?route=account/login");
			By email = By.xpath("//input[@id='input-email']");
			By pwd = By.xpath("//input[@id='input-password']");
			By loginBtn = By.xpath("//input[@value='Login']");
			
			//duration introduced in selenium
			//before that timeout existed
			
			waitForElementPresent(email, 10).sendKeys("test@gmail.com");
			getElement(pwd).sendKeys("abc");
			getElement(loginBtn).click();
			
			//Exception in thread "main" org.openqa.selenium.TimeoutException:
			//Expected condition failed: waiting for presence of element located by: 
			//By.xpath: //input[@id='input-email11'] (tried for 10 second(s) with 500 milliseconds interval)	
			
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement waitForElementPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	/*
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed 
	 * but also has a height and width that is greater than 0.
	 */
	public static WebElement waitForElementVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
