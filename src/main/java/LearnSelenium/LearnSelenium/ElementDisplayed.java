package LearnSelenium.LearnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Assignment.BrowserUtil;

public class ElementDisplayed {

public static void main(String[] args) {
		
		BrowserUtil browserUtil = new BrowserUtil();
		WebDriver driver = browserUtil.launchBrowser("chrome");
		browserUtil.launchUrl("https://demo.opencart.com/index.php?route=account/register");
		ElementUtil elementUtil = new ElementUtil(driver);
		
		By emailId = By.id("input-email");
		boolean flag = driver.findElement(emailId).isDisplayed();
		
	
	}
}
