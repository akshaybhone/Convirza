package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testbase.BaseTest;

public class loginPageTest extends BaseTest {

	// public WebDriver driver;
	//public LoginPage loginpage;
	//public DashboardPage dashboardpage; // Already declared in BaseTest class so commenting it

	/*
	 * @BeforeClass public void setup() { WebDriverManager.chromedriver().setup();
	 * driver = new ChromeDriver();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 * //driver.get("https://stag-5-cai.convirza.com/login");
	 * driver.get("https://cai.convirza.com/login");
	 * //driver.get("https://www.facebook.com/");
	 * driver.manage().window().maximize(); }
	 */

	@Description("To verify LoginText present on UI")
	@Test(priority = 1, enabled = true)
	public void logintextpresence() {
		loginpage = new LoginPage(driver);
		Assert.assertEquals(loginpage.checkWelcomeTextPresence(), true);
	}

	@Description("To verify Login with valid credentials")
	@Test(priority = 2, enabled = true)
	public void validloginTest() {
		loginpage = new LoginPage(driver);
		dashboardpage= new DashboardPage(driver);
		loginpage.doLogin(p.getProperty("username"), p.getProperty("password"));
		/*loginpage.setUsername(p.getProperty("username"));
		loginpage.setPassword(p.getProperty("password"));
		loginpage.clickLogin();*/
		
		//dashboardpage= new DashboardPage(driver);
		boolean targettext =dashboardpage.dashboardHeading_AvailabilityTest();
		Assert.assertEquals(targettext, true);
		
		/*boolean appLogo = driver.findElement(By.xpath("//img[@id='appLogo']")).isDisplayed();
		org.testng.Assert.assertEquals(appLogo, true);*/
	}
	
	

	/*
	 * @AfterClass public void teardown() { driver.close(); }
	 * 
	 * 
	 * /*public String RandomeString() { String generatedString =
	 * RandomStringUtils.randomAlphabetic(5); return generatedString; }
	 * 
	 * public String RandomeNumber() { String generatedNumber =
	 * RandomStringUtils.randomNumeric(10); return generatedNumber; }
	 * 
	 * public String RandomeAlphanumeric() { String str =
	 * RandomStringUtils.randomAlphabetic(3); String num =
	 * RandomStringUtils.randomNumeric(3); return (str+"@"+num); }
	 */

}
