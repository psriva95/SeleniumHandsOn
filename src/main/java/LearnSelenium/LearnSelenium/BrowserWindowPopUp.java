package LearnSelenium.LearnSelenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowPopUp {
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
		String parentWindowID = itr.next();
		System.out.println("Parent window id is : "+ parentWindowID);
		
		String childWindowID =itr.next();
		System.out.println("Child window id is : "+ childWindowID);
		
		driver.switchTo().window(childWindowID);
		System.out.println("Child window Title : "+ driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindowID);
		System.out.println("Parent window Title : "+ driver.getTitle());
		
		
	
	}
}
