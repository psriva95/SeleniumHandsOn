package LearnSelenium.LearnSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultpleBrowsers {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		/// wrongg......................
		
		// use as used in NewTabHandle
		
		WebDriver driver1 = new ChromeDriver();
		driver1.get("https://www.amazon.com");
		driver1.manage().window().maximize();
	}
}
