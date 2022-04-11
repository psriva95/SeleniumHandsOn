package LearnSelenium.LearnSelenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAttribute {

	static WebDriver driver ;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		String href = driver.findElement(By.linkText("Sell")).getAttribute("href");
		System.out.println(href);
		By hre = By.tagName("a");
		//getElementAttributeList(hre, "href");
		
		By images = By.tagName("img");
		System.out.println("Total Images : "+ getElements(images).size());
		List<String> srcList = getElementAttributeList(images, "src");
		List<String> altList = getElementAttributeList(images, "alt");
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static List<String> getElementAttributeList(By locator,String attrName) {
		List<WebElement> list = getElements(locator);
		List<String> eleme = new ArrayList<String>();
		for(WebElement e : list) {
			String att = e.getAttribute(attrName);
			eleme.add(att);
			System.out.println(att);
		}
		return eleme;
	}

}
