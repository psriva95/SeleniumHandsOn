package LearnSelenium.LearnSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethods {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.co.in");
		System.out.println(driver.getTitle());
		
//		driver.navigate().to("https://www.amazon.com/");
//		System.out.println(driver.getTitle());
//		
//		driver.navigate().back();
//		System.out.println(driver.getTitle());
//		
//		driver.navigate().forward();
//		System.out.println(driver.getTitle());
//		
//		driver.navigate().back();
//		System.out.println(driver.getTitle());
		
		driver.get("https://www.amazon.com/");
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh();
		System.out.println(driver.getTitle());
		
		
		driver.quit();
		
	}

}
