package LearnSelenium.LearnSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlertConcept {

	static WebDriver driver ;
	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
			By login = By.name("proceed");
			driver.findElement(login).click();
			
			WebDriverWait driverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
			Alert alert = driverWait.until(ExpectedConditions.alertIsPresent()); // dont need to switch to alert..
			alert.accept();
			
			
	}
	
	public static Alert waitFotAlert(int timeOut) {
		WebDriverWait driverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		return driverWait.until(ExpectedConditions.alertIsPresent()); // dont need to switch to alert..

	}
	public static void acceptAlert(int timeOut) {
		waitFotAlert(timeOut).accept();
	}
	public static void dismissAlert(int timeOut) {
		waitFotAlert(timeOut).dismiss();
	}
	public static String getAlertText(int timeOut) {
		return waitFotAlert(timeOut).getText();
	}

}
