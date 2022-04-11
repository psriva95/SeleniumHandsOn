package LearnSelenium.LearnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	/*
	 * applicable for all the elements - will be applied for all driver.findElement statements
	 * global wait
	 * works only for web elements
	 * doesn't work for non web elements -- alerts:url:title
	 * 
	 */
		static WebDriver driver ;
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://demo.opencart.com/index.php?route=account/login");
			
			driver.findElement(By.xpath("//input[@id='input-email11']")).sendKeys("HI");
			
			//we can over ride implicitly wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			//nullify implicitly wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
	}

}
