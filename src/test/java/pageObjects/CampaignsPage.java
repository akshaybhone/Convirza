package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtils;
import utilities.JavaScriptUtils;

public class CampaignsPage {
	
	public WebDriver driver;
	public JavascriptExecutor jsExecutor;
	public ElementUtils elementutils;
	public JavaScriptUtils javascriptutils;;

	public  CampaignsPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
		jsExecutor = (JavascriptExecutor) driver;
		javascriptutils = new JavaScriptUtils(driver);
		
		
		
	}
}
