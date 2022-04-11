package LearnSelenium.LearnSelenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PsuedoElementHandle {

	static WebDriver driver ;
	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://demo.opencart.com/index.php?route=account/login");
			
			
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			String mandatoryText = js.executeScript("return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\") , \r\n" + 
					"	'::before').getPropertyValue('content')").toString();
			System.out.println(mandatoryText);
			

		

/*
  	document.querySelector("label[for='input-firstname']")
	<label class=​"col-sm-2 control-label" for=​"input-firstname">​…​</label>​
	window.getComputedStyle(document.querySelector("label[for='input-firstname']") , 
	'::before').getPropertyValue('content')
	'"* "'
 */

	}

}
