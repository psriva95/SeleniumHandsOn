package LearnSelenium.LearnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForURLConcept {

	static WebDriver driver ;
	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://demo.opencart.com/index.php?route=account/login");
			By email = By.xpath("//input[@id='input-email']");
			By pwd = By.xpath("//input[@id='input-password']");
			By loginBtn = By.xpath("//input[@value='Login']");
			
			waitForElementVisible(email, 10).sendKeys("test123@gmail.com");
			getElement(pwd).sendKeys("123");
			getElement(loginBtn).click();
			
			System.out.println(waitForUrl(10, "route=account/account"));
	}
	public static String waitForTitleContains(int timeout, String titleFraction) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.titleContains(titleFraction))) {
			return driver.getTitle();
		}
		return null;
	}
	public static String waitForTitle(int timeout, String title) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.titleIs(title))) {
			return driver.getTitle();
		}
		return null;
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static WebElement waitForElementVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static String waitForUrl(int timeout,String urlFraction) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
	public static String waitForUrlToOBe(int timeout,String url) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.urlToBe(url))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
}
