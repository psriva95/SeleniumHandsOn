package LearnSelenium.LearnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementToBeClickableConcept {

	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		By registry = By.linkText("Registry");
		clickWhenReady(5, registry);

	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void clickWhenReady (int timeout, By frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(frameLocator)).click();
	}
	public static void clickElementWhenReady (int timeout, By frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(getElement(frameLocator))).click();
	}
}
