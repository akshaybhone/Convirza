package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.BaseTest;
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
	
	@FindBy(xpath = "//p[text()='Campaigns']")
	WebElement Campaignpageheading;
	@FindBy(xpath = "//div[text()='Create']")
	WebElement Campaigncreatebtn;
	@FindBy(xpath = "//input[@placeholder='Enter name']")
	WebElement Campaignnametxtfield;
	
	
	
	public String campaignName= "TestCampaign_" + BaseTest.RandomeAlphanumeric();
	
	public boolean campaignsHeading_AvailabilityTest() {
		try {
			boolean campaignsheadingtxt = Campaignpageheading.isDisplayed();
			//String campaignsheadingtxt = Campaignpageheading.getText();
			return campaignsheadingtxt;
		} catch (Exception e) {
			System.out.println("Campaign heading text is not available");
			return false;
		}
	}
	public void ClickOnCreateButton() {
		try {
			Campaigncreatebtn.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on create button");
		}
	}
	
	public void enterCampaignname() {
		try {
			Campaignnametxtfield.sendKeys(campaignName);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
