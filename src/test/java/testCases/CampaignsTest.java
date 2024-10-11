package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.CampaignsPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testbase.BaseTest;

public class CampaignsTest extends BaseTest {
	
	@BeforeClass
	public void groupAndUserSetup() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
		campaignsPage = new CampaignsPage(driver);
		loginpage.doLogin(p.getProperty("username"), p.getProperty("password"));

	}
	
	@Description("To verify user is able to navigate to campaigns page and campaignsHeading is present on UI")
	@Test(priority = 1, enabled = true)
	public void cmapaignPageNavigationTest() {
		
		dashboardpage.navigateToCampaignsPageTest();
		Assert.assertEquals(campaignsPage.campaignsHeading_AvailabilityTest(), true);
		System.out.println("Welcome to campaign page");
	}
	
	@Description("To verify user is able to create campaign")
	@Test(priority = 2, enabled = true)
	public void createCampaignTest() {
		campaignsPage.ClickOnCreateButton();
		
		
	}
	
}
