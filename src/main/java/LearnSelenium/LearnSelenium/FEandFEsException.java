package LearnSelenium.LearnSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FEandFEsException {

	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		driver.manage().window().maximize();

		//driver.findElement(By.linkText("Customer1111")).click();
		//NoSuchElementException
		
		List<WebElement> list = driver.findElements(By.xpath("//div//ul[@class='footer-nav11']//a"));
		//On passing wrong locator -- we get empty list -- no exception
		System.out.println(list.size());
		
	}

}
