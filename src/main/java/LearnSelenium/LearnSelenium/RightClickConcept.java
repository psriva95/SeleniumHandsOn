package LearnSelenium.LearnSelenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
			driver.manage().window().maximize();
			
			By rightClick = By.xpath("//span[text()='right click me']");
			By rightClickOptions =  By.xpath("//ul[@class=context-menu-list context-menu-root]//span");
						
			selectRightClickMenu(rightClick, rightClickOptions, "Copy");
	}
	
	public static void selectRightClickMenu(By rightClick, By rightClickOptions, String value) {
		WebElement rightClickEle = driver.findElement(rightClick);
		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).perform();
		List<WebElement> list = driver.findElements(rightClickOptions);
		for(WebElement e : list) {
			String text = e.getText();
			System.out.println(text);
			if(text.equalsIgnoreCase(value)) {
				e.click();
			break;
		}
		}
	}
	
	public static List<String> getRightClickOptions(By rightClick, By rightClickOptions) {
		WebElement rightClickEle = driver.findElement(rightClick);
		List<String> rightClickItems = new ArrayList<String>();
		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).perform();
		List<WebElement> list = driver.findElements(rightClickOptions);
		for(WebElement e : list) {
			String text = e.getText();
			rightClickItems.add(text);
		}
		return rightClickItems;	
	}
	
	public static int getRightClickOptionsCount(By rightClick, By rightClickOptions) {
		return getRightClickOptions(rightClick,rightClickOptions).size();
	}
	
	public static void doContextClick(By locator) {
		Actions act = new Actions(driver);
		act.contextClick(driver.findElement(locator)).perform();
	}
	
}
