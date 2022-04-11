package LearnSelenium.LearnSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuggestionListHanfle {

	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://automationpractice.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("search_query_top")).sendKeys("Dress");

		Thread.sleep(3000);
	//	driver.findElement(By.xpath("//div[@class='ac_results']//li[contains(text(),"
			//	+ "'Summer Dresses > Printed Summer')]")).click();
		
		List<WebElement> suggestList = 
				driver.findElements(By.xpath("//div[@class='ac_results']//li"));
		
		Thread.sleep(2000);
		for(WebElement e : suggestList) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains("Summer Dresses > Printed Summer"))
				break;
			}
		
		driver.quit();
		//google search -- single xpath
		//automation practice -- list and break;
		///specific search
		
		
	}

}
