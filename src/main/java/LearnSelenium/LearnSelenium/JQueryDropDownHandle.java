package LearnSelenium.LearnSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropDownHandle {

	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();

		driver.findElement(By.id("justAnInputBox")).click();;

		By dropdown = By.xpath("//span[@class='comboTreeItemTitle']");
		doSelectChoice(dropdown, "choice 1" ,"choice 2", "choice 6 2 2");

	}
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}


	public static void doSelectChoice(By locator, String... choose) {

		if(!choose[0].equalsIgnoreCase("all")) {
			List<WebElement> list = getElements(locator);
			for(WebElement e : list) {
				String text = e.getText();
				for(int i = 0; i < choose.length; i++) {
					if(text.equals(choose[i])) {
						e.click();
						break;
					}
				}

			}
		}
		else
		{	try {
			List<WebElement> list = getElements(locator);
			for(WebElement e : list) {
				e.click();
			}
		}
		catch(ElementNotInteractableException e )
		{
			System.out.println("choices are over...");
		}
		}
	}
}
