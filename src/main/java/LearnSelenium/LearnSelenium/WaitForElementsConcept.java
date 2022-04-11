package LearnSelenium.LearnSelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementsConcept {
/*
 * doucment.readyState = complete
 */
	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		driver.manage().window().maximize();
		
		By footer = By.xpath("//ul[@class='footer-nav']//a");
		printAllElements(5, footer);
		
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void printAllElements(int timeout, By locator) {
		for(WebElement e : waitForElementsToBeVisible(5, locator)) {
			System.out.println(e.getText());
		}
	}
	
	public static List<String> getElementsWithWait(int timeout, By locator) {
		List<String> list = new ArrayList<String>();
		for(WebElement e : waitForElementsToBeVisible(5, locator)) {
			list.add(e.getText());
		}
		return list;
	}
	public static List<WebElement> waitForElementsToBeVisible (int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
}
