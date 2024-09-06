package testbase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.DashboardPage;
import pageObjects.GroupsAndUserPage;
import pageObjects.LoginPage;

public class BaseTest {

	public WebDriver driver;
	public Properties p;
	public LoginPage loginpage;
	public GroupsAndUserPage groupsanduserpage;
	public DashboardPage dashboardpage;

	// Use below code when XML file is to Run
/*
	@BeforeClass

	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {

		// loading properties file 
		
		FileReader file = new
		FileReader(".\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);

		// launching browser as per condition
		switch (br.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("No matching browser");
			return;
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //
		driver.get("https://stag-5-cai.convirza.com/login");
		driver.get(p.getProperty("appProdURL")); //
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
*/
	// Use below code when individual class is to be Run

	@BeforeClass
	// @Parameters({ "os", "browser" })
	public void setup() throws IOException {

		// loading properties file
		FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		// driver.get("https://stag-5-cai.convirza.com/login");
		
		driver.get(p.getProperty("appBetaURL"));
		// driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}

	// @AfterClass public void teardown() { driver.close(); }

	public static String RandomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		return generatedString;
	}

	public static String RandomeNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(5);
		return generatedNumber;
	}

	public static String RandomeAlphanumeric() {
		String str = RandomStringUtils.randomAlphabetic(2);
		String num = RandomStringUtils.randomNumeric(2);
		return (str + "@" + num);
	}

}
