package LearnSelenium.LearnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitWithPoling {
	static WebDriver driver ;
	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://demo.opencart.com/index.php?route=account/login");
			By email = By.xpath("//input[@id='input-email']");
			By pwd = By.xpath("//input[@id='input-password']");
			By loginBtn = By.xpath("//input[@value='Login']");

	}
	public static WebElement waitForElementPresent(By locator, int timeout, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout),
				Duration.ofMillis(pollingTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement waitForElementVisible(By locator, int timeout,int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout),
				Duration.ofMillis(pollingTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
