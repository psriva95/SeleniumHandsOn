package LearnSelenium.LearnSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	static WebDriver driver ;
	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://demo.opencart.com/index.php?route=account/login");
			By email = By.xpath("//input[@id='input-email']");
			By pwd = By.xpath("//input[@id='input-password']");
			By loginBtn = By.xpath("//input[@value='Login']");
			
			
			/*
			 * WebDriverWait(c) is extending Fluent Wait
			 * Fluent(c) implements Wait Interface(I)
			 * 
			 */
			
			//Parent  Ref --- 
			waitForElementPresentUsingFluentWait(email, 10,2).sendKeys("123@345.com");
			waitForElementVisibleUsingFluentWait(pwd, 10, 1).sendKeys("yes");
			
			//We can do everything we do witht flient wait using webdriver wait
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.pollingEvery(Duration.ofSeconds(2));
			wait.ignoring(NoSuchElementException.class,ElementNotInteractableException.class);
			
			
			
	}
	public static WebDriver waitForFramePresentUsingFluentWait(By locator, int timeout,int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchFrameException.class);	
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	public static Alert waitForAlertPresentUsingFluentWait(By locator, int timeout,int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoAlertPresentException.class);	
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	public static WebElement waitForElementPresentUsingFluentWait(By locator, int timeout,int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class,
						ElementNotInteractableException.class);
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static WebElement waitForElementVisibleUsingFluentWait(By locator, int timeout,int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class);
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}


}
