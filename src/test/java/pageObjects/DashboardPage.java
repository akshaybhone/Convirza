package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class DashboardPage  {

	public WebDriver driver;

	// Constructor
	public DashboardPage(WebDriver driver) {
		//super(driver);

		this.driver=driver; 
		PageFactory.initElements(driver, this);
		 
	}

	@FindBy(xpath = "//p[normalize-space()='Dashboard']")
	WebElement dashboardHeading;
	
	@FindBy(xpath = "//div[contains(text(),'Groups & Users')]")
	WebElement groupanduser;

	@FindBy(xpath = "//img[@src='/assets/icons/avatar.png']")
	WebElement accountLogo;
	
	@FindBy(xpath = "//span[text()='Log out']")
	WebElement logoutbtn;
	//span[text()='Log out']
	
	

	public boolean dashboardHeading_AvailabilityTest() {
		try {
			boolean dashboardheadingtxt = dashboardHeading.isDisplayed();
			return dashboardheadingtxt;
		} catch (Exception e) {
			System.out.println("dashboard heading text is not available");
			return false;
		}
		/*
		 * boolean dashboardheadingtxt = dashboardHeading.isDisplayed(); return
		 * dashboardheadingtxt;
		 */
	}
	
	@Step("clicking on the inventory menu icon  and navigating to the inventory module")
	public void navigateToGroupsAndUserPageTest() {
		
		groupanduser.click();
		
	}
	
	/*@Step("clicking on the inventory menu icon  and navigating to the inventory module")
	public GroupsAndUserPage navigateToGroupsAndUserPageTest() {
		
		groupanduser.click();
		return new GroupsAndUserPage(driver);
	}*/
	public void clickToLogout() {
		
		try {
			accountLogo.click();
			logoutbtn.click();
		} catch (Exception e) {
			System.out.println("Unable to click on Logout Button");
		}

	}

}
