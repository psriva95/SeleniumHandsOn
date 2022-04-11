package LearnSelenium.LearnSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterList {


	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		driver.manage().window().maximize();
		
		//ul.footer-nav li a --------- css selector ---- giving more choices
		//div//ul[@class='footer-nav'][position()=2]//a
		List<WebElement> list = driver.findElements(By.xpath("//div//ul[@class='footer-nav']//a"));
		for(WebElement e : list) {
			String text = e.getText();
				System.out.println(text);
           }	

	}

}
