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

	@Description("To Verify Clicking on GroupsAndUser module user navigates to GroupsAndUser Page.")
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
		groupsanduserpage.clickOn_GroupFilter();
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
	
	@Description("To verify user is able to edit the created group")
	@Test(priority=5,enabled=true)
	public void editGroup() {
		
		groupsanduserpage.click_OnGroupName();
		groupsanduserpage.updateGroupName();
		groupsanduserpage.clickOn_SubGroup_SaveButton();
	//	(//p[text()='Group Updated Successfully'])[1]
		System.out.println("first push");
		System.out.println("second push");
		Assert.assertEquals(groupsanduserpage.UpdatetoastMessage_AvailabiltyTest(), true);
	}
	
	@Description("To verify edited group is present on grid or not.")
	@Test(priority = 6, enabled = true)
	public void editedgroupongrid() {
		groupsanduserpage.clickOn_FilterButton();
		groupsanduserpage.clickOn_GroupFilter();
		groupsanduserpage.ClickOn_groupNameDropdown();
		groupsanduserpage.selecteditgroupFilter();
		groupsanduserpage.ClickOn_RefreshButton();
		//groupsanduserpage.getgroupName();
		String groupname = groupsanduserpage.returneditedGroupName();
		System.out.println(groupname);
		Assert.assertEquals(groupsanduserpage.getgroupName(), groupname);
		//Assert.assertEquals(groupsanduserpage.getgroupName(), groupsanduserpage.returnGroupName());
		// groupsanduserpage.grid();
	}
	
	@Description("To verify user is able to delete the created group")
	@Test(priority = 7, enabled = true)
	public void deletegroupongrid() {
		groupsanduserpage.click_OnGroupName();
		groupsanduserpage.clickOn_Deletebutton();
		groupsanduserpage.clickOn_ConfirmDeletebutton();
		Assert.assertEquals(groupsanduserpage.deletetoastMessage_AvailabiltyTest(), true);
		
	}
	
	@Description("To verify user is able to add user")
	@Test(priority = 8, enabled = true, dataProvider = "UserData", dataProviderClass = Dataproviders.class)
	public void createUserTest(String lastname, String usergroup, String userrole ) {
		groupsanduserpage.clickOnuserTab();
		groupsanduserpage.ClickOnCreateButton();
		groupsanduserpage.clickOnuserbutton();
		groupsanduserpage.ClickOnNextButton();
		groupsanduserpage.enterFirstName();
		groupsanduserpage.enterlastName(lastname);
		groupsanduserpage.clickOnemailtextfield();
		groupsanduserpage.enteremail();
		groupsanduserpage.selectusergroup(usergroup);
		groupsanduserpage.selectuserrole(userrole);
		groupsanduserpage.clickOn_user_NextButton();
		Assert.assertEquals(groupsanduserpage.usercreatedMessage_AvailabiltyTest(), true);

	}
	
	

}
