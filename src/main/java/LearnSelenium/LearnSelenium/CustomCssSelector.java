package LearnSelenium.LearnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomCssSelector {


	
	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		driver.get("https://demo.opencart.com/index.php?route=account/register");
	
		//css selector
		//id --> #id  i.e., #input-email 
		//class = .class  .form-control
		
		//Combine
		/*
		 * #input-email.form-control
		 * .class1.class2.class3 ....n
		 * amazon -- search field -- .nav-input.nav-progressive-attribute
		 * 
		 * input#input-email
		 * input.form-control
		 * input.form-control#input-email
		 * a.btn-orange.contact-ohrm
		 */
		By ele = By.cssSelector("a.btn-orange.contact-ohrm");
		By.className("btn-orange contact-ohrm"); ///incorrect -- class name doesnt take multiple classes
		/*
		 * hubspot
		 * uiButton private-button private-button--primary private-button--default m-bottom-4 login-submit disabled private-button--disabled private-button--non-link
		 * 
		 * button.login-submit
		 * //button[contains(@class,'login-submit')]
		 * 
		 * <input type="submit" value="Login" class="btn btn-primary">
		 * 
		 * input[type='submit']
		 * 
		 * htmltag[attr1='value'][attr2='value'][attr3='value']
		 * input[type='submit'][value='Login']
		 * input[@type='submit' and @value='Login'] --xpath
		 * 
		 * contains ----- input[id*='email'] -- id contains email
		 * starts-with --- input[id^='input'] --id starts with input
		 * button[class*='login-submit']
		 * button[data-test-id^='password']
		 * ends-with --- button[data-test-id$='login-button'] -- test id ends with login button
		 * 
		 * ***** ---------------- parent to child in CSS ------------*****
		 * div.private-form__input-wrapper > input#username ------------ (> direct association)
		 * 
		 * div.private-form__input-wrapper  input#username  ----------(remove > direct+indirect association)
		 * 
		 * 
		 * ul.footer-nav > li > a  
		 * form#hs-login > div  ---- 8
		 * form#hs-login  div ----20
		 * 
		 * 
		 * ***** ----------------  child to parent in CSS ------------*****
		 * with CSS we cannot backtrack..
		 * 
		 * ***** ---------------- sibling CSS ------------*****
		 * following sibling--
		 * label.control-label + input#input-email
		 * 
		 * preceeding subling--not supported
		 * 
		 * ***** ----------------  NOT in CSS ------------*****
		 * form-control private-form__control login-email
		 * form-control private-form__control login-password m-bottom-3  --input.form-control.private-form__control.login-password.m-bottom-3
		 * 
		 * after not -- #username == #class
		 * input.form-control.private-form__control:not(#username) -- exclude username
		 * after not --.id
		 * input.form-control:not(.input-lg)
		 * 
		 * 
		 *  ***** ----------------  COMMA in CSS ------------*****
		 *  input#username,input#password
		 *  input#username,input#password,button#loginBtn,button#ssoBtn
		 *  input#username,input#password,button#loginBtn,button#ssoBtn,input#remember,a[class='google-sign-in']
		 *  
		 *  dom is loaded first --then page
		 *  CSS doesnt work with Text
		 * 
		 * **** ----------------  Indexes in CSS ------------*****
		 * 
		 * ul.footer-nav li:nth-of-type(5)
		 * ul.footer-nav li:nth-of-type(5) > a
		 * ul.footer-nav li:nth-of-type(n) > a  - works with n -- returns all
		 * 
		 *       XPATH                      |                           CSS
		 * syntax:		Harder sometimes	|					simpler syntax sometimes
		 * backward:	possible			|					not possible
		 * performance: depends on XPAth 	|					same
		 * 				engine--same
		 * 				absolute xpath is 
		 * 				slower
		 * comma,not :  NA					|				Available
		 * text:		Supported			|				NA
		 * sibling:		Better 				| 			only forward sibling
		 * Index:		Better Support
		 * 				& Functions			|				Available but not simple
		 * 
		 * contains:	Available			|			Available
		 * 												not compatible with svg
		 * 
		 * 
		 */
		int count = driver.findElements(By.cssSelector
				("input#username,input#password,button#loginBtn,button#ssoBtn")).size();
	}

}
