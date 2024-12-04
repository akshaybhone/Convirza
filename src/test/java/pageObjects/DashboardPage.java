package pageObjects;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class DashboardPage {

	public WebDriver driver;

	// Constructor
	public DashboardPage(WebDriver driver) {
		// super(driver);

		this.driver = driver;
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

	@FindBy(xpath = "//div[text()=' Campaigns ']")
	WebElement Campaigns_page;
	
	@FindBy(xpath = "//div[text()=' Tracking numbers ']")
	WebElement TrackingNumbers_page;
	
	@FindBy(xpath = "//div[text()=' Scorecards ']")
	WebElement Scorecards_page;
	
	public boolean dashboardHeading_AvailabilityTest() {
		try {
			boolean dashboardheadingtxt = dashboardHeading.isDisplayed();
			return dashboardheadingtxt;
		} catch (Exception e) {
			System.out.println("dashboard heading text is not available");
			return false;
		}

	}

	@Step("Navigate to groupsanduser page")
	public void navigateToGroupsAndUserPageTest() {
		try {
			groupanduser.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Groupanduser module");
		}

	}

	@Step("Navigate to campaigns page")
	public void navigateToCampaignsPageTest() {
		try {
			Campaigns_page.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Campaigns module");
		}
	}
	
	@Step("Navigate to TrackingNumber page")
	public void navigateToTrackingNumbersPageTest() {
		try {
			TrackingNumbers_page.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on TrackingNumbers module");
		}
	}
	
	@Step("Navigate to Scorecard page")
	public void navigateToScorecardsPageTest() {
		try {
			
			Scorecards_page.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Scorecards module");
			fail("user is unable to click on Scorecards module");
		}
	}

	/*
	 * @Step("clicking on the inventory menu icon  and navigating to the inventory module"
	 * ) public GroupsAndUserPage navigateToGroupsAndUserPageTest() {
	 * 
	 * groupanduser.click(); return new GroupsAndUserPage(driver); }
	 */
	public void clickToLogout() {

		try {
			accountLogo.click();
			logoutbtn.click();
		} catch (Exception e) {
			System.out.println("Unable to click on Logout Button");
		}

	}

}
