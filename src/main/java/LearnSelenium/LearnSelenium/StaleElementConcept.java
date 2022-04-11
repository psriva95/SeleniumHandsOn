package LearnSelenium.LearnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementConcept {

		/*
		 * Page -- dom -- v1
		 * elem1
		 * refresh
		 * Page -- dom --- v2
		 * elem1.click -- will it work? 
		 * 
		 */
		static WebDriver driver ;
		public static void main(String[] args) throws InterruptedException {
			
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get("https://demo.opencart.com/index.php?route=account/login");
				By email = By.xpath("//input[@id='input-email']");
				By pwd = By.xpath("//input[@id='input-password']");
				By loginBtn = By.xpath("//input[@value='Login']");
				
		WebElement login = driver.findElement(email);		 //dom v1
		login.sendKeys("tom@123.com");  //dom v1
		Thread.sleep(4000);
		driver.navigate().refresh(); //dom v2  // navigate forward backward operation
		login = driver.findElement(email); //solving the problem
		login.sendKeys("123@tim.com");
		
	}

}
