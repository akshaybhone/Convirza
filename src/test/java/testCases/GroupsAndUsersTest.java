package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.DashboardPage;
import pageObjects.GroupsAndUserPage;
import pageObjects.LoginPage;
import testbase.BaseTest;
import utilities.Dataproviders;

public class GroupsAndUsersTest extends BaseTest {

	// public GroupsAndUserPage groupsanduserpage;
	// public DashboardPage dashboardpage;
	@BeforeClass
	public void groupAndUserSetup() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
		groupsanduserpage = new GroupsAndUserPage(driver);
		loginpage.doLogin(p.getProperty("username"), p.getProperty("password"));

		/*
		 * loginpage = new LoginPage(driver); dashboardpage =
		 * loginpage.doLogin(p.getProperty("username"), p.getProperty("password"));
		 * GroupsAndUserPage groupsanduserpage =
		 * dashboardpage.navigateToGroupsAndUserPageTest(); this.groupsanduserpage =
		 * groupsanduserpage;
		 */

	}

	@Description("To Verify Clicking on GroupsAndUser module user navigates to GroupsAndUser Page >> Product Screen.")
	@Test(priority = 1, enabled = true)
	public void groupsAndUserPageNavigationTest() {
		// loginpage = new LoginPage(driver);
		// dashboardpage= new DashboardPage(driver);
		// loginpage.doLogin(p.getProperty("username"), p.getProperty("password"));
		dashboardpage.navigateToGroupsAndUserPageTest();
		// GroupsAndUserPage
		// groupsanduserpage=dashboardpage.navigateToGroupsAndUserPageTest();
		// this.groupsanduserpage = groupsanduserpage;
		// groupsanduserpage = new GroupsAndUserPage(driver);
		// Assert.assertEquals(groupsanduserpage.GroupsAndUserHeading_AvailabilityTest(),
		// true);
	}

	@Description("To verify GroupsAndUserHeading present on UI")
	@Test(priority = 2, enabled = true)
	public void groupsAndUserHeaderTest() {
		// groupsanduserpage = new GroupsAndUserPage(driver);
		// dashboardpage.navigateToGroupsAndUserPageTest();
		Assert.assertEquals(groupsanduserpage.GroupsAndUserHeading_AvailabilityTest(), true);
	}

	@Description("To verify user is able to add group")
	@Test(priority = 3, enabled = true, dataProvider = "groupAndUserData", dataProviderClass = Dataproviders.class)
	public void createGroupTest(String parentgroup, String industryName) {
		groupsanduserpage.ClickOnCreateButton();
		groupsanduserpage.ClickOnNextButton();
		groupsanduserpage.ClickonParentGroupDropdown();
		groupsanduserpage.selectParentgroup(parentgroup);
		groupsanduserpage.enterGroupName();
		groupsanduserpage.selectIndustry(industryName);
		groupsanduserpage.clickOn_SubGroup_NextButton();
		// toaster message
		Assert.assertEquals(groupsanduserpage.successMessage_AvailabiltyTest(), true);

	}

	@Description("To verify created group is present on grid or not.")
	@Test(priority = 4, enabled = true)
	public void groupgrid() {
		groupsanduserpage.clickOn_DoneButton();
		groupsanduserpage.clickOn_FilterButton();
		groupsanduserpage.clickON_GroupFilter();
		groupsanduserpage.ClickOn_groupNameDropdown();
		groupsanduserpage.selectFilter();
		groupsanduserpage.ClickOn_RefreshButton();
		//groupsanduserpage.getgroupName();
		String groupname = groupsanduserpage.returnGroupName();
		System.out.println(groupname);
		Assert.assertEquals(groupsanduserpage.getgroupName(), groupname);
		//Assert.assertEquals(groupsanduserpage.getgroupName(), groupsanduserpage.returnGroupName());
		// groupsanduserpage.grid();
	}
	
	@Description("To verify useris able to edit the created group")
	@Test(priority=5,enabled=true)
	public void editGroup() {
		
		groupsanduserpage.click_OnGroupName();
		System.out.println("first push");
	}

}
