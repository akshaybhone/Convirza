package testCases;

import org.testng.annotations.BeforeClass;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testbase.BaseTest;

public class InsightsTest extends BaseTest {
	
	@BeforeClass
	public void insightssetup() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
		
	}

	
}
