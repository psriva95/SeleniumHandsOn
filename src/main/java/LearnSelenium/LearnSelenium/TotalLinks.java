package LearnSelenium.LearnSelenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Assignment.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	static WebDriver driver ;
	public static void main(String[] args) {

		//1.total links on the page
		//2.Print Text of each link
		//3.exclude blank text
		//4.capture the text in list and return
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.amazon.com");//		
////		List<WebElement> lst = driver.findElements(By.tagName("a"));
////		System.out.println("Links " + lst.size());
////		
////		for(WebElement we : lst){
////			String text = we.getText();
////			if(!text.isEmpty())
////				System.out.println(text);
////		}
		
		By links = By.tagName("a");
		System.out.println("total number of links: " + getElements(links).size());
	
	}
	public static void getLinksTextList(By locator) {
		List<String> linkText = new ArrayList<String>();
		List<WebElement> element = getElements(locator);
		for(WebElement e : element) {
			String text = e.getText();
				if(!text.isEmpty())
					linkText.add(text);
		}
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	

}
