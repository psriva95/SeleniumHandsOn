package LearnSelenium.LearnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {

	static WebDriver driver ;
	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://automationpractice.com/");
			waitForPageLoad(1000);
		//	By email = By.id("input-email");
		//	retryingElement(email, 5).sendKeys("pooja123@gmail.com");;
		

	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement retryingElement(By locator, int timeOut , int intervalTime) {
		WebElement element = null;
		int attempts = 0;
		while(attempts<timeOut) {
			try {
				element = getElement(locator);
				break;
			}catch(NoSuchElementException e){
				System.out.println("Element is not found in attempt " + attempts );
				try {
					Thread.sleep(intervalTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		if(element==null) {
			try {
				throw new Exception("ElementNotFoundException");
			} catch (Exception e) {
				System.out.println("Element is not found exception..tried for : " + timeOut
						+ " with the interval of " +intervalTime+" ms" );
			}
		}
		return element;
	}
	public static WebElement retryingElement(By locator, int timeOut) {
		WebElement element = null;
		int attempts = 0;
		while(attempts<timeOut) {
			try {
				element = getElement(locator);
				break;
			}catch(NoSuchElementException e){
				System.out.println("Element is not found in attempt " + attempts );
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		if(element==null) {
			try {
				throw new Exception("ElementNotFoundException");
			} catch (Exception e) {
				System.out.println("Element is not found exception..tried for : " + timeOut
						+ " with the interval of 500 ms" );
			}
		}
		return element;
	}
	
	public static void waitForPageLoad(int timeout) {
		long endTime = System.currentTimeMillis()+timeout;
		while(System.currentTimeMillis()<endTime) {
			System.out.println(String.valueOf(((JavascriptExecutor)driver).executeScript("return document.readyState")));
			if(String.valueOf(((JavascriptExecutor)driver).
					executeScript("return document.readyState")).equals("complete")) {
				break;
			}
		}
	}

}
