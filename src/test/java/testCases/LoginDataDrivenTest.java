package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testbase.BaseTest;
import utilities.Dataproviders;

public class LoginDataDrivenTest extends BaseTest {

	public LoginPage loginpage;
	public DashboardPage dashboardpage;

	/*
	 * @Description("To verify LoginText present on UI")
	 * 
	 * @Test(priority = 1) public void logintextpresence() { lp = new
	 * LoginPage(driver); Assert.assertEquals(lp.checkWelcomeTextPresence(), true);
	 * }
	 */
	
	@Description("To verify Login with valid credentials")
	@Test(priority = 1, enabled = false)
	public void validloginTest() {
		loginpage = new LoginPage(driver);
		loginpage.setUsername(p.getProperty("username"));
		loginpage.setPassword(p.getProperty("password"));
		loginpage.clickLogin();
		
		dashboardpage= new DashboardPage(driver);
		boolean targettext =dashboardpage.dashboardHeading_AvailabilityTest();
		Assert.assertEquals(targettext, true);
		
		dashboardpage.clickToLogout();
		
		/*boolean appLogo = driver.findElement(By.xpath("//img[@id='appLogo']")).isDisplayed();
		org.testng.Assert.assertEquals(appLogo, true);*/
	}
	
	@Description("To verify Login with valid credentials")
	@Test(priority = 2, dataProvider = "Logindata" , dataProviderClass = Dataproviders.class)
	public void verify_loginDDTest(String username, String password, String exp) {
		try {
			loginpage = new LoginPage(driver);
			dashboardpage = new DashboardPage(driver);
			
			loginpage.setUsername(username);
			loginpage.setPassword(password);
			loginpage.clickLogin();

			
			boolean targettext = dashboardpage.dashboardHeading_AvailabilityTest();
			
			if (targettext==true && exp.equalsIgnoreCase("valid")) {
				dashboardpage.clickToLogout();
				org.testng.Assert.assertTrue(true);
			}
			else if (exp.equalsIgnoreCase("Invalid") && targettext==true ) {
				dashboardpage.clickToLogout();
				org.testng.Assert.assertTrue(false);
			}
			
			else {
				org.testng.Assert.assertTrue(true);
			}

		} catch (Exception e) {
				org.testng.Assert.fail();
				
		}

	}
	
	/*@Description("To verify Login with valid credentials")
	@Test(priority = 2, dataProvider = "LoginData" , dataProviderClass = Dataproviders.class)
	public void verify_loginDDTest(String username, String password, String exp) {
		try {
			loginpage = new LoginPage(driver);
			dashboardpage = new DashboardPage(driver);
			
			loginpage.setUsername(username);
			loginpage.setPassword(password);
			loginpage.clickLogin();

			
			boolean targettext = dashboardpage.dashboardHeading_AvailabilityTest();
			
			
			
			if (exp.equalsIgnoreCase("Valid")) {
 
				if (targettext == true) {
					dashboardpage.clickToLogout();
					org.testng.Assert.assertTrue(true);
				} else {
					org.testng.Assert.assertTrue(false);
				}

			}
			if (exp.equalsIgnoreCase("Invalid")) {

				if (targettext == true) {
					dashboardpage.clickToLogout();
					org.testng.Assert.assertTrue(false);
				} else {
					org.testng.Assert.assertTrue(true);
				}

			}

		} catch (Exception e) {
				org.testng.Assert.fail();
				
		}

	}*/
}
