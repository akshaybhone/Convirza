package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.CampaignsPage;
import pageObjects.DashboardPage;
import pageObjects.GroupsAndUserPage;
import pageObjects.LoginPage;
import testbase.BaseTest;
import utilities.Dataproviders;

public class CampaignsTest extends BaseTest {
	
	@BeforeClass
	public void groupAndUserSetup() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
		campaignsPage = new CampaignsPage(driver);
		groupsanduserpage = new GroupsAndUserPage(driver);
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
		campaignsPage.clickOnCreateButton();
		campaignsPage.enterCampaignname();
		campaignsPage.clickOnNextButton();
		Assert.assertEquals(campaignsPage.setSuccessMessage(), campaignsPage.getSuccessMessage());
	}
	
	@Description("To verify user is able to create campaign from 'Create another Campaign' button")
	@Test(priority = 3, enabled = true, dataProvider = "CampaignsData",dataProviderClass = Dataproviders.class)
	public void createCampaignTest_fromcreateanothercampaignbutton(String owner) {
		campaignsPage.clickOnCreateAnotherCampaignButton();
		campaignsPage.enterNewCampaignname();
		campaignsPage.selectOwner(owner);
		campaignsPage.clickOnNextButton();
		Assert.assertEquals(campaignsPage.newSetSuccessMessage(), campaignsPage.getSuccessMessage());
		//campaignsPage.clickOcrossbutton();
	}
	
	@Description("To verify created campaign is present on grid or not.")
	@Test(priority = 4, enabled = true)
	public void campaignGrid() {
		dashboardpage.navigateToCampaignsPageTest();
		groupsanduserpage.clickOn_FilterButton(); 
		campaignsPage.clickOnCampaignFilter();
		campaignsPage.selectCampaignFromDropdown();
		groupsanduserpage.ClickOn_RefreshButton();
		String campaignNameFromGrid= campaignsPage.getCampaignNamefromgrid();
		//System.out.println(campaignsPage.campaignName);
		Assert.assertEquals(campaignNameFromGrid, campaignsPage.campaignName);
	}
	
	@Description("To verify user is able to edit the created campaign")
	@Test(priority=5,enabled=true)
	public void editCampaign() {
		
		campaignsPage.clickOnCampaignnameFromGrid();
		campaignsPage.updateCampaignname();
		campaignsPage.clickOn_SaveButton();
		Assert.assertEquals(campaignsPage.campaignUpdatetoastMessage_AvailabiltyTest(), true);
		
	}
	
	@Description("To verify edited campaign is present on grid or not.")
	@Test(priority = 6, enabled = true)
	public void editedcampaignongrid() {
		
		//groupsanduserpage.clickOn_FilterButton(); 
		//campaignsPage.clickOnCampaignFilter();
		campaignsPage.selectEditedCampaignFromDropdown();
		groupsanduserpage.ClickOn_RefreshButton();
		String campaignNameFromGrid= campaignsPage.getCampaignNamefromgrid();
		System.out.println(campaignsPage.campaignName);
		Assert.assertEquals(campaignNameFromGrid, campaignsPage.newcampaignName);
		
	}
	
	@Description("To verify user is able to delete the created group")
	@Test(priority = 7, enabled = true)
	public void deletegroupongrid() {
		campaignsPage.clickOnCampaignnameFromGrid();
		campaignsPage.clickOn_ArchiveButton();
		campaignsPage.clickOn_confirmArchiveButton();
		Assert.assertEquals(campaignsPage.campaignArchivetoastMessage_AvailabiltyTest(), true);
		
	}
}
