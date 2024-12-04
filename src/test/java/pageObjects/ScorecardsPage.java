package pageObjects;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.BaseTest;
import utilities.ElementUtils;
import utilities.JavaScriptUtils;

public class ScorecardsPage {
	
	WebDriver driver;
	public ElementUtils elementutils;
	public JavaScriptUtils javascriptutils;

	public ScorecardsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
		javascriptutils = new JavaScriptUtils(driver);
		
	}
	//public String ScorecardName = "Auto_SCName"+ BaseTest.RandomeAlphanumeric();
	

	@FindBy(xpath = "//p[text()='Manage Scorecards']")
	WebElement ScorecardsHeading;
	@FindBy(xpath = "//div[text()='Create']")
	WebElement CreateButton;
	@FindBy(xpath = "//input[@placeholder='Scorecard name']")
	WebElement ScoreCardNameTxtfield;
	@FindBy(xpath = "//input[@placeholder='Scorecard outcome label']")
	WebElement OutcomeLabelTxtfield;
	@FindBy(xpath = "//span[text()='Manual']")
	WebElement Manual_Outcometype;
	@FindBy(xpath = "//span[text()='AI']")
	WebElement AI_Outcometype;
	@FindBy(xpath = "//span[text()='Total Score']")
	WebElement TotalScore_Outcometype;
	@FindBy(xpath = "//body//app-root//div[@class='column-input-container']//div//div[1]//span[1]")
	WebElement SelectDefaultGroup_loc;
	@FindBy(xpath = "//input[@placeholder='Search groups']")
	WebElement SearchGroups;
	@FindBy(xpath = "//span[text()=' akshay test sub group ']")//label[@for='mat-checkbox-3-input']//span[@class='mat-checkbox-label']
	WebElement Click_DefaultGroups;
	@FindBy(xpath = "//span[text()=' Apply ']")
	WebElement ApplyButton;
	@FindBy(xpath = "//div[text()='Next']")
	WebElement NextButton;
	@FindBy(xpath = "//strong[text()='Add sections']")
	WebElement AddSection;
	@FindBy(xpath = "//strong[text()='Skip sections']")
	WebElement SkipSection;
	
	@FindBy(xpath = "(//div[text()='Next'])[2]")
	WebElement NextButton2;
	
	By SearchGroups_loc = By.xpath("//input[@placeholder='Search groups']");
	By Click_DefaultGroups_loc = By.xpath("//span[text()=' akshay test sub group ']");
	
	
	public boolean scorecrads_Heading_AvailabilityTest() {
		try {
			boolean scorecrads_Headingtxt = ScorecardsHeading.isDisplayed();
			return scorecrads_Headingtxt;
		} catch (Exception e) { 
			System.out.println("scorecrads Page heading text is not available");
			return false;
		}
	}
	
	public void clickOn_CreateButton() {
		try {
			CreateButton.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on create button");
		}
	}
	
	public void enter_ScorecardName() {
		String ScorecardName = "Auto_SCName"+ BaseTest.RandomeAlphanumeric();
		System.out.println(ScorecardName);
		try {
			ScoreCardNameTxtfield.sendKeys(ScorecardName);
		} catch (Exception e) {
			System.out.println("user is unable to enter scorecard name");
		}
	}
	
	public void enter_OutcomeLabel(String outcomelabel) {
		try {
			OutcomeLabelTxtfield.sendKeys(outcomelabel);
		} catch (Exception e) {
			System.out.println("user is unable to enter Outcome Label");
		}
	}
	
	
	@FindBy(xpath = "//input[@placeholder='total score threshold']")
	WebElement Threshold_textfield;
	//input[@placeholder='total score threshold']
	
	public void select_Outcometype(String outcometype) {
		try {
			if (outcometype.equalsIgnoreCase("manual")) {
				Manual_Outcometype.click();
			}
			if (outcometype.equalsIgnoreCase("AI")) {
				AI_Outcometype.click();
			}
			if (outcometype.equalsIgnoreCase("Total Score")) {
				TotalScore_Outcometype.click();
				Threshold_textfield.sendKeys("51");
				
			}
		} catch (Exception e) {
			System.out.println("user is unable to select outcometype radio button");
		}
		
	}
	
	
	By AI_Insights_For_AIOutcome_loc = By.xpath("//input[@placeholder='Search indicator']");//input[@placeholder='Search indicator']
	
	@FindBy(xpath = "//input[@placeholder='Search indicator']")
	WebElement AI_Insights_For_AIOutcome;
	
	public void select_AIInsight_For_Outcometype(String AI_Insight_Name ) {
		try {
			elementutils.waitToDisplayElement(AI_Insights_For_AIOutcome_loc);
			javascriptutils.scrollIntoView(AI_Insights_For_AIOutcome);
			elementutils.select_DropdownValue_BySendkeys(AI_Insights_For_AIOutcome, AI_Insight_Name, Insight_Name_Loc);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void select_DefaultGroup(String groupname) {
		try {
			SelectDefaultGroup_loc.click();
		} catch (Exception e) {
			System.out.println("user is unable to select default group");
		}
		try {
			elementutils.waitToDisplayElement(SearchGroups_loc);
			SearchGroups.sendKeys(groupname);
		} catch (Exception e) {
			System.out.println("user is unable to select default group");
		}
		try {
			elementutils.waitToDisplayElement(Click_DefaultGroups_loc);
			Click_DefaultGroups.click();
		} catch (Exception e) {
			System.out.println("user is unable to select default group");
		}
		try {
			ApplyButton.click();
		} catch (Exception e) {
			System.out.println("user is unable to select default group");
		}
		
	}
	
	@FindBy(xpath = "//button[text()='Confirm']")
	WebElement Confirm_Button;
	
	public void clickOn_NextButton() throws InterruptedException {
		Thread.sleep(1500);
		try {
			if (Confirm_Button.isDisplayed()) {
				try {
					Confirm_Button.click();
				} catch (Exception e) {
					fail("Unable to click on confirm button on popup of scorecard details page");
				}
				
				try {
					NextButton.click();
				} catch (Exception e) {
					System.out.println("user is unable to click on Next button");
				}
			}
		}catch (Exception e) {
			NextButton.click();
			//System.out.println("user is unable to click on Next button");
		}
		
	} 

	public void Select_AddSection() {
		try {
			AddSection.click();
		} catch (Exception e) {
			System.out.println("user is unable to Select Add Section");
		}
	}
	
	
	
	public void Select_SkipSection() {
		try {
			javascriptutils.clickOnElement(SkipSection);
			//SkipSection.click();
		} catch (Exception e) {
			System.out.println("user is unable to Select Skip Section");
		}
		try {
			javascriptutils.scrollIntoView(NextButton2);
			NextButton2.click();
		} catch (Exception e) {
			System.out.println("user is unable to Select Skip button");
		}
	}
	
	@FindBy(xpath = "//span[text()='AI' and @class='mat-button-toggle-label-content']")
	WebElement AI_Tab;
	By AI_Tab_loc= By.xpath("//span[text()='AI' and @class='mat-button-toggle-label-content']");
	
	@FindBy(xpath = "//input[@placeholder='Search insight']")
	WebElement Search_Imsight_Dropdwn;
	@FindBy(xpath = "(//span[@class='mat-option-text'])[1]")
	WebElement Insight_Name_Loc;
	@FindBy(xpath = "//button[text()=' Save ']")
	WebElement Save_Button;
	
	public void select_Existing_AI_Insight(String AI_Insight_Name ) {
		try {
			elementutils.waitToDisplayElement(AI_Tab_loc);
			Thread.sleep(1500);
			AI_Tab.click();
		} catch (Exception e) {
			fail("user is unable to click on AI Tab under create Insights page");
		}
		try {
			elementutils.select_DropdownValue_BySendkeys(Search_Imsight_Dropdwn, AI_Insight_Name, Insight_Name_Loc);
		} catch (Exception e) {
			fail("user is unable to select value from AI Insight dropdown");
		}
		try {
			javascriptutils.scrollIntoView(Save_Button);
			Save_Button.click();
		} catch (Exception e) {
			fail("user is unable to click on save button under create Insights page");
		}
		
	}
	
	public void clickOn_Manual_Insight_Tab() {
		try {
			javascriptutils.scrollIntoView(AddInsight_Plusbtn);
			AddInsight_Plusbtn.click();
		} catch (Exception e) {
			fail("user is unable to click on plus button of Add Insights under create Insights page");
		}
		try {
			Manual_Tab.click();
		} catch (Exception e) {
			fail("user is unable to click on Manual Tab under create Insights page");
		}
	}
	
	@FindBy(xpath = "//span[text()='New insights']")
	WebElement New_Insights_RadioBtn;
	//span[text()='New insights']
	public void clickOn_New_Insight_RadioBtn() {
		try {
			New_Insights_RadioBtn.click();
		} catch (Exception e) {
			fail("user is unable to click on New insight Radio Button under create Insights page");
		}
	}
	
	@FindBy(xpath = "(//button[@type='button']//mat-icon[@data-mat-icon-name='plus' and @aria-hidden='true' and @role='img'])[2]")
	WebElement AddInsight_Plusbtn;
	@FindBy(xpath = "//span[text()='Manual' and @class='mat-button-toggle-label-content']")
	WebElement Manual_Tab;
	
	public void select_Existing_Manual_Insight(String manual_Insight_Name ) {
		try {
			javascriptutils.scrollIntoView(AddInsight_Plusbtn);
			AddInsight_Plusbtn.click();
		} catch (Exception e) {
			fail("user is unable to click on plus button of Add Insights under create Insights page");
		}
		try {
			Manual_Tab.click();
		} catch (Exception e) {
			fail("user is unable to click on Manual Tab under create Insights page");
		}
		
		try {
			elementutils.select_DropdownValue_BySendkeys(Search_Imsight_Dropdwn, manual_Insight_Name, Insight_Name_Loc);
		} catch (Exception e) {
			fail("user is unable to select value from Mamual Insight dropdown");
		}
		try {
			javascriptutils.scrollIntoView(Save_Button);
			Save_Button.click();
		} catch (Exception e) {
			fail("user is unable to click on save button under create Insights page");
		}
		
	}
	
	@FindBy(xpath = "//span[text()='Keyword' and @class='mat-button-toggle-label-content']")
	WebElement Keyword_Tab;
	
	
	public void select_Existing_Keyword_Insight(String keyword_Insight_Name ) {
		try {
			javascriptutils.scrollIntoView(AddInsight_Plusbtn);
			AddInsight_Plusbtn.click();
		} catch (Exception e) {
			fail("user is unable to click on plus button of Add Insights under create Insights page");
		}
		try {
			Keyword_Tab.click();
		} catch (Exception e) {
			fail("user is unable to click on Keyword Tab under create Insights page");
		}
		
		try {
			elementutils.select_DropdownValue_BySendkeys(Search_Imsight_Dropdwn, keyword_Insight_Name, Insight_Name_Loc);
		} catch (Exception e) {
			fail("user is unable to select value from keyword Insight dropdown");
		}
		try {
			javascriptutils.scrollIntoView(Save_Button);
			Save_Button.click();
		} catch (Exception e) {
			fail("user is unable to click on save button under create Insights page");
		}
		
	}
	
	@FindBy(xpath = "//span[text()='Ultimate AI' and @class='mat-button-toggle-label-content']")
	WebElement UltimateAI_Tab;
	
	public void select_Existing_UltimateAI_Insight(String UltimateAI_Insight_Name ) {
		try {
			javascriptutils.scrollIntoView(AddInsight_Plusbtn);
			AddInsight_Plusbtn.click();
		} catch (Exception e) {
			fail("user is unable to click on plus button of Add Insights under create Insights page");
		}
		try {
			UltimateAI_Tab.click();
		} catch (Exception e) {
			fail("user is unable to click on UltimateAI Tab under create Insights page");
		}
		
		try {
			elementutils.select_DropdownValue_BySendkeys(Search_Imsight_Dropdwn, UltimateAI_Insight_Name, Insight_Name_Loc);
		} catch (Exception e) {
			fail("user is unable to select value from UltimateAI Insight dropdown");
		}
		try {
			javascriptutils.scrollIntoView(Save_Button);
			Save_Button.click();
		} catch (Exception e) {
			fail("user is unable to click on save button under create Insights page");
		}
	}
	
	@FindBy(xpath = "//div[text()='Preview all']")
	WebElement PreviewAll_Button;
	
	public void clickOn_PreviewAllButton() {
		try {
			PreviewAll_Button.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Preview All button");
		}
	}
	
	@FindBy(xpath = "//button[@class='next-btn ng-star-inserted']")
	WebElement Done_Button;
	
	public void clickOn_DoneButton() {
		try {
			Done_Button.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Done button on Preview Page");
		}
	}
	
	@FindBy(xpath = "(//p[text()='Scorecard created successfully'])[1]")
	WebElement ScorecardCreated_ToastSucessMessage;
	
	public boolean scorecardCreated_toastMessage_AvailabiltyTest() {
		try {
			String Scorecard_ToastMessage=ScorecardCreated_ToastSucessMessage.getText();
			System.out.println(Scorecard_ToastMessage);
			boolean ScorecardCreated_SucessToastMessage = ScorecardCreated_ToastSucessMessage.isDisplayed();
			return ScorecardCreated_SucessToastMessage;
		} catch (Exception e) {
			fail("Scorecard Toast Message is not displayed");
			return false;
		}
		
	}
	
	@FindBy(xpath = "//input[@placeholder='Insight name']")
	WebElement Insight_Name_txtfield;
	//input[@placeholder='Insight name']
	
	public String Manual_InsightName = "Test_M_Insight"+ BaseTest.RandomeAlphanumeric();
	public String Keyword_InsightName = "Test_K_Insight"+ BaseTest.RandomeAlphanumeric();
	
	public void Enter_InsightName(String Insight_type) {
		
			try {
				if (Insight_type.equalsIgnoreCase("manual")) {
					Insight_Name_txtfield.sendKeys(Manual_InsightName);
				}
				if (Insight_type.equalsIgnoreCase("keyword")) {
					Insight_Name_txtfield.sendKeys(Keyword_InsightName);
				}

			} catch (Exception e) {
				System.out.println("user is unable to Enter Insight name in textfield");
			}
	}
	
	@FindBy(xpath = "//span[@class='slider round']")
	WebElement Required_RadioBtn;
	//span[@class='slider round']
	public void Select_RequiredRadioBtn() {
		try {
			Required_RadioBtn.click();
		} catch (Exception e) {
			System.out.println("user is unable to click required radio button in Create Insights Page");
		}
	}
	
	public void Click_SaveBtn() {
		try {
			javascriptutils.scrollIntoView(Save_Button);
			Save_Button.click();
		} catch (Exception e) {
			fail("user is unable to click on save button under create Insights page");
		}
	}
	
	public void select_Keyword_Insight_Tab() {
		try {
			javascriptutils.scrollIntoView(AddInsight_Plusbtn);
			AddInsight_Plusbtn.click();
		} catch (Exception e) {
			fail("user is unable to click on plus button of Add Insights under create Insights page");
		}
		try {
			Keyword_Tab.click();
		} catch (Exception e) {
			fail("user is unable to click on Keyword Tab under create Insights page");
		}
	}
	
	By UltimateAI_Tab_loc = By.xpath("//span[text()='Ultimate AI' and @class='mat-button-toggle-label-content']");
	public void select_UltimateAI_Insight_Tab() {
		try {
			elementutils.waitToDisplayElement(UltimateAI_Tab_loc);
			javascriptutils.clickOnElement(UltimateAI_Tab);
			//UltimateAI_Tab.click();
		} catch (Exception e) {
			fail("user is unable to click on Ultimate AI Tab under create Insights page");
		}
	}
	
	@FindBy(xpath = "//div[@class='mat-chip-list-wrapper']//input")
	WebElement Insights_textfield;
	//div[@class='mat-chip-list-wrapper']//input
	
	public void enter_Keywords(String keyword1,String keyword2,String keyword3) {
		try {
			javascriptutils.scrollIntoView(Insights_textfield);
			Insights_textfield.click();
		} catch (Exception e) {
			fail("user is unable to click on plus button of Add Insights under create Insights page");
		}
		try {
			Insights_textfield.sendKeys(keyword1);
			Insights_textfield.sendKeys(Keys.ENTER);
			Insights_textfield.sendKeys(keyword2);
			Insights_textfield.sendKeys(Keys.ENTER);
			Insights_textfield.sendKeys(keyword3);
			Insights_textfield.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			fail("user is unable to enter keywords in textfield under create Insights page");
		}
	}
	
	@FindBy(xpath = "//a[text()='Create a new Ultimate AI insight']")
	WebElement CreateNewUAI_Link;
	//a[text()='Create a new Ultimate AI insight']
	public void clickon_CreateNewUAI_link() {
		try {
			CreateNewUAI_Link.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on 'Create a new Ultimate AI insight' link");
		}
	}
	
	
	@FindBy(xpath = "//button[text()='Proceed']")
	WebElement Proceed_button;
	//button[text()='Proceed']
	public void clickon_Proceed_Button() {
		try {
			Proceed_button.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Proceed button");
		}
	}

	@FindBy(xpath = "//span[text()='Insight builder']")
	WebElement InsightsPage_Heading;
	By InsightsPage_Heading_loc = By.xpath("//span[text()='Insight builder']");//span[text()='Insight builder']
	public boolean insights_Heading_AvailabilityTest() {
		try {
			elementutils.waitToDisplayElement(InsightsPage_Heading_loc);
			String getInsightsPage_HeadingText= InsightsPage_Heading.getText();
			System.out.println(getInsightsPage_HeadingText);
			boolean InsightsPage_Headingtxt = InsightsPage_Heading.isDisplayed();
			return InsightsPage_Headingtxt;
		} catch (Exception e) { 
			System.out.println("Insights Page heading text is not available");
			return false;
		}
	}
}
