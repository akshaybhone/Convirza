package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.CampaignsPage;
import pageObjects.DashboardPage;
import pageObjects.GroupsAndUserPage;
import pageObjects.LoginPage;
import pageObjects.TrackingNumbersPage;
import testbase.BaseTest;
import utilities.Dataproviders;
import utilities.ElementUtils;

public class TrackingNumbersTest extends BaseTest {
	
	@BeforeClass
	public void trackingNumberssetup() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
		groupsanduserpage = new GroupsAndUserPage(driver);
		campaignsPage = new CampaignsPage(driver);
		trackingNumbersPage = new TrackingNumbersPage(driver);
		loginpage.doLogin(p.getProperty("username"), p.getProperty("password"));
	}

	@Description("To verify user is able to navigate to TrackingNumbersPage")
	@Test(priority = 1, enabled = true)
	public void trackingNumbersNavigationTest() {
		dashboardpage.navigateToTrackingNumbersPageTest();
		Assert.assertEquals(trackingNumbersPage.trackingNumbersHeading_AvailabilityTest(), true);
	}
	
	@Description("Single Number->Forward Routing type->To verify user is able to create Tracking Number from existing campaign")
	@Test(priority = 2, enabled = true, dataProvider = "TrackingNumberData",dataProviderClass = Dataproviders.class)
	public void createTrackingNumber_ForExistingCampaign(String campaign_name, String area_code, String area_code_toselect, String ad_source, String routing_type, String template,String owner) {
		groupsanduserpage.ClickOnCreateButton();
		trackingNumbersPage.selectExistingCampaign(campaign_name);
		campaignsPage.clickOnNextButton();
		trackingNumbersPage.selectAreaCode(area_code,area_code_toselect);
		trackingNumbersPage.selectAvailableTrackingNumbers();
		trackingNumbersPage.enterTrackingNumbername();
		trackingNumbersPage.selectAdSource(ad_source);
		campaignsPage.clickOnNextButton();
		trackingNumbersPage.selectRoutingType(routing_type);
		trackingNumbersPage.selectTemplate(template);
		trackingNumbersPage.clickOnNextButton2();
 		trackingNumbersPage.clickOnNextButton2();
		trackingNumbersPage.clickOnNextButton3();
		
		Assert.assertEquals(trackingNumbersPage.SetSuccessMessage(), trackingNumbersPage.getSuccessMessage());
		
	}
	
	@Description("To verify user is able to create Tracking Number by creating a new campaign")
	@Test(priority = 3, enabled = false, dataProvider = "TrackingNumberData",dataProviderClass = Dataproviders.class)
	public void createTrackingNumber_ForNewCampaign(String campaign_name, String area_code, String area_code_toselect, String ad_source, String routing_type, String template,String owner) {
		groupsanduserpage.ClickOnCreateButton();
		trackingNumbersPage.clickOnCreateNewCampaignRadioBtn();
		campaignsPage.clickOnNextButton();
		campaignsPage.enterCampaignname();
		campaignsPage.selectOwner(owner);
		campaignsPage.clickOnNextButton();
		trackingNumbersPage.selectAreaCode(area_code,area_code_toselect);
		trackingNumbersPage.selectAvailableTrackingNumbers();
		trackingNumbersPage.enterTrackingNumbername();
		trackingNumbersPage.selectAdSource(ad_source);
		campaignsPage.clickOnNextButton();
		trackingNumbersPage.selectRoutingType(routing_type);
		trackingNumbersPage.selectTemplate(template);
		trackingNumbersPage.clickOnNextButton2();
 		trackingNumbersPage.clickOnNextButton2();
		trackingNumbersPage.clickOnNextButton3();
		
		Assert.assertEquals(trackingNumbersPage.SetSuccessMessage(), trackingNumbersPage.getSuccessMessage());
		dashboardpage.navigateToCampaignsPageTest();
		campaignsPage.clickOnClearAllBtn();
		groupsanduserpage.clickOn_FilterButton(); 
		campaignsPage.clickOnCampaignFilter();
		campaignsPage.selectCampaignFromDropdown();
		groupsanduserpage.ClickOn_RefreshButton();
		String campaignNameFromGrid= campaignsPage.getCampaignNamefromgrid();
		//System.out.println(campaignsPage.campaignName);
		Assert.assertEquals(campaignNameFromGrid, campaignsPage.campaignName);
	}
	
	@Description("To verify created TrackingNumber is present on grid or not.")
	@Test(priority = 4, enabled = true)
	public void trackingNumberGrid() {
		dashboardpage.navigateToTrackingNumbersPageTest();
		campaignsPage.clickOnClearAllBtn();
		groupsanduserpage.clickOn_FilterButton(); 
		trackingNumbersPage.clickTrackingNumberNameFilter();
		trackingNumbersPage.selectTNNamefromfilterDropdown();
		groupsanduserpage.ClickOn_RefreshButton();
		
		//String trackingNumber_FromGrid=trackingNumbersPage.getTrackingNumberfromgrid();
		//Assert.assertEquals(trackingNumber_FromGrid, trackingNumbersPage.setTrackingNumber);
		
		String trackingNumbername_FromGrid=trackingNumbersPage.getTrackingNumberNamefromgrid();
		Assert.assertEquals(trackingNumbername_FromGrid, trackingNumbersPage.settrackingNumberName);
			
	}
	
	@Description("To verify user is able to edit the Tracking Number")
	@Test(priority = 5, enabled = true, dataProvider = "EditTrackingNumberData",dataProviderClass = Dataproviders.class)
	public void editTrackingNumber(String ring_to_number) {
		System.out.println(ring_to_number);
		trackingNumbersPage.clickOnTrackingNumberNamefromgrid();
		trackingNumbersPage.enterRingtoNumber(ring_to_number);
		trackingNumbersPage.clickOnTrackingNumberNameSaveButton();
		
		trackingNumbersPage.clickOnTrackingNumberNameOKButton();
		Assert.assertEquals(trackingNumbersPage.getTNUpdate_ToastMessage(), true);
	}
	
	@Description("To verify edited TrackingNumber is present on grid or not.")
	@Test(priority = 6, enabled = true)
	public void editTrackingNumberGrid() {
		
		dashboardpage.navigateToTrackingNumbersPageTest();
		campaignsPage.clickOnClearAllBtn();
		groupsanduserpage.clickOn_FilterButton(); 
		trackingNumbersPage.clickTrackingNumberNameFilter();
		trackingNumbersPage.selectTNNamefromfilterDropdown();
		groupsanduserpage.ClickOn_RefreshButton();
		
		String trackingNumber_FromGrid=trackingNumbersPage.getTrackingNumberfromgrid();
		Assert.assertEquals(trackingNumber_FromGrid, trackingNumbersPage.toprintTrackingNumber);
		
	//	String ringToNumbername_FromGrid=trackingNumbersPage.getRingtoNumberNamefromgrid();
	//	Assert.assertEquals(ringToNumbername_FromGrid, trackingNumbersPage.setRingToNumber);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Description("To verify user is able to get data from excel file")
	@Test(priority = 6, enabled = false)
	public void getdetailsofTN() throws IOException { 
		trackingNumbersPage.getTrackingNumberDetails();
		
		
	}
}
