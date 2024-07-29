package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.DashboardPage;
import pageObjects.GroupsAndUserPage;
import pageObjects.LoginPage;
import testbase.BaseTest;

public class CampaignsTest extends BaseTest {
	
	@BeforeClass
	public void groupAndUserSetup() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
		groupsanduserpage = new GroupsAndUserPage(driver);
		loginpage.doLogin(p.getProperty("username"), p.getProperty("password"));


	}
	
	@Description("To Verify Clicking on GroupsAndUser module user navigates to GroupsAndUser Page >> Product Screen.")
	@Test(priority = 1, enabled = true)
	public void groupsAndUserPageNavigationTest() {
		
		System.out.println("Welcome to campaign page");
		
	}
}
