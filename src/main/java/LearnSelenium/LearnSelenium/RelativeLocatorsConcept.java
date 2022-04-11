package LearnSelenium.LearnSelenium;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorsConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://aqi.in/dashboard/canada");
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.linkText("Saint-John, Canada"));
		String aqisu = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(aqisu);
		
		String rank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(rank);
		
		String below = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(below);
		
		String above = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(above);
	
		String near =  driver.findElement(with(By.tagName("a")).near(ele)).getText();
		System.out.println(near);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		List<WebElement> aboveList = driver.findElements(with(By.tagName("a")).above(ele));
		for(WebElement e : aboveList)
		{
			System.out.println(e.getText());
		}
	}

}
