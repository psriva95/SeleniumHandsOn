package LearnSelenium.LearnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableStaticTraverse {

	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		
		int rowCOunt = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		
		String befor_xpath = "//*[@id='customers']/tbody/tr[";
		String after_path = "]/td[1]";
		for(int i = 2; i<=rowCOunt ; i++) {
			String xpath = befor_xpath+i+after_path;
			String text = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(text);
		}
		driver.quit();
	}

}
