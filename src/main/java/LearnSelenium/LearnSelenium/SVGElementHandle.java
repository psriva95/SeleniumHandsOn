package LearnSelenium.LearnSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementHandle {
///Scalar Vector Graph

	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map/#/");
		Thread.sleep(5000);
		
		List<WebElement> list = driver.findElements(
				By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']//*[name()='g']//*[name()='path']"));
		//local name for svg
		//name for child of svg element
		
		
		Actions act = new Actions(driver);
		for(WebElement e : list) {
			act.moveToElement(e).perform();
			System.out.println(e.getAttribute("name"));
			
		}
	}

}
