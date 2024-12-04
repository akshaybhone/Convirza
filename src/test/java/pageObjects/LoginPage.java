package pageObjects;

import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ElementUtils;
import utilities.JavaScriptUtils;

public class LoginPage  {
	
	public WebDriver driver;
	public JavaScriptUtils javascriptutils;
	public ElementUtils elementutils;
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		//super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
		javascriptutils = new JavaScriptUtils(driver);
	}
	
	//Webelements Locators+identification
	
	@FindBy(xpath = "//p[@id='welcomeText']")
	WebElement txt_welcometext; 
	
	@FindBy(xpath = "//input[@id='login']")
	WebElement txt_username_loc; 
	
	@FindBy(xpath = "(//input[@placeholder='Type your password'])[1]")
	WebElement txt_password_loc; 
	
	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement btn_login_loc; 
	
	
	
	@FindBy(xpath = "//div[@class='AccountdropList']//div")
	List<WebElement> List_Of_group; 
	
	
	
	@FindBy(xpath = "//div[@class='AccountdropList']//div")
	List<WebElement> List_Of_user;
	
	@FindBy(xpath = "//button[normalize-space()='Impersonate']")
	WebElement Impersonate_btn; 
	
	
	
	
	/*fb
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement txt_username_loc; 
	
	@FindBy(xpath = "//div[@id='passContainer']")
	WebElement txt_password_loc; 
	
	@FindBy(xpath = "//button[@id='u_0_5_ZQ']")
	WebElement btn_login_loc; */
	
	/*@FindBy(xpath = "//img[@id='appLogo']")
	WebElement btn_applogo_loc; 
	
	//locators
	//By txt_welcometext_loc=By.xpath("//p[@id='welcomeText']");
	/*By txt_username_loc = By.xpath("//input[@id='login']");
	By txt_password_loc = By.xpath("(//input[@placeholder='Type your password'])[1]");
	By btn_login_loc = By.xpath("//button[normalize-space()='Log in']");
	By btn_applogo_loc = By.xpath("//img[@id='appLogo']"); */

	
	//Actions
	public boolean checkWelcomeTextPresence() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(txt_welcometext));
		wait.until(ExpectedConditions.visibilityOf(txt_welcometext));
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(txt_welcometext_loc));
		//boolean status =driver.findElement(txt_welcometext_loc).isDisplayed();
		boolean status = txt_welcometext.isDisplayed();
		return status;
	}
	
	public void setUsername(String username) {
		
		//driver.findElement(txt_username_loc).sendKeys(username);
		txt_username_loc.clear();
		txt_username_loc.sendKeys(username);
	}
	
	public void setPassword(String password) {
		//driver.findElement(txt_password_loc).sendKeys(password);
		
		txt_password_loc.clear();
		txt_password_loc.sendKeys(password);
	}
	
	public void doLogin(String username,String password) {
		//driver.findElement(txt_password_loc).sendKeys(password);
		txt_username_loc.clear();
		txt_username_loc.sendKeys(username);
		txt_password_loc.clear();
		txt_password_loc.sendKeys(password);
		btn_login_loc.click();
		
		
	}
	
	public void supportAdmin_Login(String username,String password,String group,String user) throws InterruptedException {
		//driver.findElement(txt_password_loc).sendKeys(password);
		txt_username_loc.clear();
		txt_username_loc.sendKeys(username);
		txt_password_loc.clear();
		txt_password_loc.sendKeys(password);
		btn_login_loc.click();
		select_group(group);
		select_user(user);
		Impersonate_btn.click();
	}
	
	@FindBy(xpath = "//input[@placeholder='Search groups']")
	WebElement group_dropdown; 
	@FindBy(xpath = "(//div[@class='AccountdropList'])//div") //div[text()=' Convirza-Live 'and @class='ng-star-inserted']
	WebElement groupname_option;
	
	
	public void select_group(String groupname) throws InterruptedException {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			elementutils.select_DropdownValue_BySendkeys(group_dropdown, groupname, groupname_option);
		} catch (Exception e) {
			fail("user is unable to select group while login");
		}
		
	}
	
	@FindBy(xpath = "//input[@placeholder='Search users']")
	WebElement user_dropdown;
	@FindBy(xpath = "(//div[@class='AccountdropList'])//div")
	WebElement user_option;

	By user_spinner = By.xpath("//span[@class='spinner-border spinner-border-sm mr-1']");
	
	public void select_user(String user) throws InterruptedException {
		
		try {
			//elementutils.waitTillElementHide(user_spinner);
			elementutils.select_DropdownValue_BySendkeys(user_dropdown, user, user_option);
		} catch (Exception e) {
			fail("user is unable to select groupuser while login");
		}

	}
	
	
	
	/*public DashboardPage doLogin(String username,String password) {
		//driver.findElement(txt_password_loc).sendKeys(password);
		txt_username_loc.clear();
		txt_username_loc.sendKeys(username);
		txt_password_loc.clear();
		txt_password_loc.sendKeys(password);
		btn_login_loc.click();
		
		return new DashboardPage(driver);
	} */
	
	public void clickLogin() {
		//driver.findElement(btn_login_loc).click();
		btn_login_loc.click();
	}
	
	//public void clickAccountIcon()
}
