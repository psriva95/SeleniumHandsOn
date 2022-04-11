package LearnSelenium.LearnSelenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowIterators {
	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		//child window
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		while(itr.hasNext()) {
			String it = itr.next();
			driver.switchTo().window(it);
			System.out.println();
			driver.close();
		}
		
	}
}
