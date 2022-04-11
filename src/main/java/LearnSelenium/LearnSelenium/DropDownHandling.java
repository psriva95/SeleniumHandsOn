package LearnSelenium.LearnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandling {

	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.manage().window().maximize();

//		WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
//		Select select = new Select(country);
//		select.selectByIndex(2);
//		select.selectByVisibleText("India");
//	//	select.selectByValue("Algeria");
//
//		WebElement state = driver.findElement(By.id("Form_submitForm_State"));
//		Select select1 = new Select(state);
//		Thread.sleep(5000);
//		select.selectByVisibleText("Goa");
		
		By country = By.id("Form_submitForm_Country");
		doSelectByVisibleText(country, "India");
		Thread.sleep(5000);
		By state = By.id("Form_submitForm_State");
		doSelectByVisibleText(state, "Goa");
		
		Select s = new Select(driver.findElement(country));
		s.deselectByValue("India");
		
		System.out.println(s.isMultiple());
		System.out.println(s.getAllSelectedOptions());
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectByValue(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByValue(text);
	}
}
