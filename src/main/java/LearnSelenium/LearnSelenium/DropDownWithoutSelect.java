package LearnSelenium.LearnSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithoutSelect {

	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.manage().window().maximize();
		
//		By country = By.id("Form_submitForm_Country");
//		By state = By.id("Form_submitForm_State");
		
	//	driver.findElement(By.id("Form_submitForm_Country")).sendKeys("India");
		
		List<WebElement> list = driver.findElements(By.xpath("//select[@id='Form_submitForm_Country']/option"));
		for(WebElement e : list) {
			String text = e.getText();
			if(text.equals("India")) {
				e.click();
				break;
			}
		}
	}

}
