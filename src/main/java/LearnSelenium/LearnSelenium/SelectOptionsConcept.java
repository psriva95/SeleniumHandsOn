package LearnSelenium.LearnSelenium;

import java.awt.image.ConvolveOp;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectOptionsConcept {

	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.manage().window().maximize();
		
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
		
		doSelectByDropDownValue(country, "India");
		Thread.sleep(5000);
		doSelectByDropDownValue(state, "Goa");
//		System.out.println(doGetDropDownOptions(country));
//		doSelectByVisibleText(country, "India");
//		Thread.sleep(5000);
//		System.out.println(doGetDropDownOptions(state).contains("Goa"));
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public static List<String> doGetDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));
		List<String> l = new ArrayList<String>();
		List<WebElement> list = select.getOptions();
		for(WebElement e: list) {
			l.add(e.getText());
		}
		return l;
	}

	public static void doSelectByDropDownValue(By locator, String Value) {
		Select select = new Select(getElement(locator));
		List<WebElement> countryList = select.getOptions();
		for(WebElement e : countryList) {
			String text = e.getText();
			if(text.equals(Value)) {
				e.click();
				break;
			}
		}
	}
}
