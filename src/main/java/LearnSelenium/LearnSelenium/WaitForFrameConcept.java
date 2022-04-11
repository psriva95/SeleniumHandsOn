package LearnSelenium.LearnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForFrameConcept {

	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		driver.manage().window().maximize();
		By frameLocator = By.name("main");
		driver = waitForFrame(5, frameLocator);
		String header = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(header);
		
	}
	public static WebDriver waitForFrame(int timeout, By frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

	}
	public static WebDriver waitForFrameByIndex(int timeout, int frameIndex) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));

	}
	public static WebDriver waitForFrameByString(int timeout, String frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

	}
	public static WebDriver waitForFrameByElement(int timeout, WebElement frameElement) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));

	}
}
