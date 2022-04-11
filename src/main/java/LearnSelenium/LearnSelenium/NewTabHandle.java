package LearnSelenium.LearnSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTabHandle {
	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		String pr = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB); //for cross origin policy
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
		driver.close();
		driver.switchTo().window(pr);
		System.out.println(driver.getTitle());
		
	}
	
}
