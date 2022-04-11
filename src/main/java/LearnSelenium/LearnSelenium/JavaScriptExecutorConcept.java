package LearnSelenium.LearnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) {
		
		//xecute js
		//javascript executor helps in executing js
		//interface 
		/*
		 * create border, highlight etc...
		 * .executeScript
		 * 
		 */
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://aqi.in/dashboard/canada");
		driver.manage().window().maximize();
		
		
		JavaScriptUtil jsJavaScriptUtil = new JavaScriptUtil(driver);
//		System.out.println(jsJavaScriptUtil.getTitleByJs());
//		
//		jsJavaScriptUtil.refreshBrowserByJs();
		
		WebElement ele = driver.findElement(By.linkText("St.-Albert, Canada"));
		jsJavaScriptUtil.drawBorder(ele);
		
		jsJavaScriptUtil.flash(ele);
		
		                                                                      

	}

}
