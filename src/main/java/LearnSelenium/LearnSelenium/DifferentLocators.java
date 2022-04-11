package LearnSelenium.LearnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Assignment.BrowserUtil;

public class DifferentLocators {

	public static void main(String[] args) {
		
		BrowserUtil browserUtil = new BrowserUtil();
		WebDriver driver = browserUtil.launchBrowser("chrome");
		browserUtil.launchUrl("https://demo.opencart.com/index.php?route=account/register");
	
		//name
		ElementUtil elementUtil = new ElementUtil(driver);
		By email = By.name("email");
		elementUtil.doSendKeys(email, "pooja@xyz.com");
		
		//classname
		By ele = By.className("form-control");
		
		//xpath
		//not an attribute
		
		
		//css Selector
		
		
		//link text
		By register = By.linkText("Register");
		
		//patial link text
		By forogottonPassword = By.partialLinkText("Forgotten");
		
		
		
	}

}
