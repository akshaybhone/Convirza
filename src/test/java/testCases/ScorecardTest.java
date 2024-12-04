package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.ScorecardsPage;
import testbase.BaseTest;
import utilities.Dataproviders;

public class ScorecardTest extends BaseTest {

	@BeforeClass
	public void scorecardsetup() throws InterruptedException {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
		scorecardspage = new ScorecardsPage(driver);
		// loginpage.doLogin(p.getProperty("username"), p.getProperty("password"));
		loginpage.supportAdmin_Login(p.getProperty("sa_username"), p.getProperty("sa_password"), p.getProperty("group"),
				p.getProperty("user"));
	}

	@Description("To verify user is able to navigate to ScorecardPage")
	@Test(priority = 1, enabled = true)
	public void scorecardPageNavigationTest() {
		dashboardpage.navigateToScorecardsPageTest();
		Assert.assertEquals(scorecardspage.scorecrads_Heading_AvailabilityTest(), true);

	}

	@Description("Verify user is able to create scorecard using Manual Outcometype with existing Insights")
	@Test(priority = 2, enabled = false, dataProvider = "ScorecardData", dataProviderClass = Dataproviders.class)
	public void createManualScrorecard(String outcome_label, String default_groupname, String AI_Insight_Name,
			String manual_Insight_Name, String keyword_Insight_Name, String ultimateAI_Insight_Name)
			throws InterruptedException {
		scorecardspage.clickOn_CreateButton();
		scorecardspage.enter_ScorecardName();
		scorecardspage.enter_OutcomeLabel(outcome_label);
		scorecardspage.select_Outcometype("manual");
		scorecardspage.select_DefaultGroup(default_groupname);
		scorecardspage.clickOn_NextButton();
		scorecardspage.Select_SkipSection();
		scorecardspage.select_Existing_AI_Insight(AI_Insight_Name);
		scorecardspage.select_Existing_Manual_Insight(manual_Insight_Name);
		scorecardspage.select_Existing_Keyword_Insight(keyword_Insight_Name);
		scorecardspage.select_Existing_UltimateAI_Insight(ultimateAI_Insight_Name);
		scorecardspage.clickOn_PreviewAllButton();
		scorecardspage.clickOn_DoneButton();
		Assert.assertEquals(scorecardspage.scorecardCreated_toastMessage_AvailabiltyTest(), true);

	}

	@Description("Verify user is able to create scorecard using AI Outcometype with existing Insights")
	@Test(priority = 3, enabled = true, dataProvider = "ScorecardData", dataProviderClass = Dataproviders.class)
	public void createAIScrorecard(String outcome_label, String default_groupname, String AI_Insight_Name,
			String manual_Insight_Name, String keyword_Insight_Name, String ultimateAI_Insight_Name)
			throws InterruptedException {
		scorecardspage.clickOn_CreateButton();
		scorecardspage.enter_ScorecardName();
		scorecardspage.enter_OutcomeLabel(outcome_label);
		scorecardspage.select_Outcometype("AI");
		scorecardspage.select_AIInsight_For_Outcometype(AI_Insight_Name);
		scorecardspage.select_DefaultGroup(default_groupname);
		scorecardspage.clickOn_NextButton();
		scorecardspage.Select_SkipSection();
		scorecardspage.select_Existing_AI_Insight(AI_Insight_Name);
		scorecardspage.select_Existing_Manual_Insight(manual_Insight_Name);
		scorecardspage.select_Existing_Keyword_Insight(keyword_Insight_Name);
		scorecardspage.select_Existing_UltimateAI_Insight(ultimateAI_Insight_Name);
		scorecardspage.clickOn_PreviewAllButton();
		scorecardspage.clickOn_DoneButton();
		Assert.assertEquals(scorecardspage.scorecardCreated_toastMessage_AvailabiltyTest(), true);

	}

	@Description("Verify user is able to create scorecard using Total Score Outcometype with existing Insights")
	@Test(priority = 4, enabled = true, dataProvider = "ScorecardData", dataProviderClass = Dataproviders.class)
	public void createTotalScore_Scrorecard(String outcome_label, String default_groupname, String AI_Insight_Name,
			String manual_Insight_Name, String keyword_Insight_Name, String ultimateAI_Insight_Name)
			throws InterruptedException {
		scorecardspage.clickOn_CreateButton();
		scorecardspage.enter_ScorecardName();
		scorecardspage.enter_OutcomeLabel(outcome_label);
		scorecardspage.select_Outcometype("Total Score");
		scorecardspage.select_DefaultGroup(default_groupname);
		scorecardspage.clickOn_NextButton();
		scorecardspage.Select_SkipSection();
		scorecardspage.select_Existing_AI_Insight(AI_Insight_Name);
		scorecardspage.select_Existing_Manual_Insight(manual_Insight_Name);
		scorecardspage.select_Existing_Keyword_Insight(keyword_Insight_Name);
		scorecardspage.select_Existing_UltimateAI_Insight(ultimateAI_Insight_Name);
		scorecardspage.clickOn_PreviewAllButton();
		scorecardspage.clickOn_DoneButton();
		Assert.assertEquals(scorecardspage.scorecardCreated_toastMessage_AvailabiltyTest(), true);

	}

	@Description("Verify user is able to create scorecard using Total Score Outcometype with New Manual and Keyword Insight")
	@Test(priority = 5, enabled = true, dataProvider = "InsightsData", dataProviderClass = Dataproviders.class)
	public void create_Scrorecard_WithNewInsights(String outcome_label, String default_groupname, String keyword1,
			String keyword2, String keyword3) throws InterruptedException {
		scorecardspage.clickOn_CreateButton();
		scorecardspage.enter_ScorecardName();
		scorecardspage.enter_OutcomeLabel(outcome_label);
		scorecardspage.select_Outcometype("Total Score");
		scorecardspage.select_DefaultGroup(default_groupname);
		scorecardspage.clickOn_NextButton();
		scorecardspage.Select_SkipSection();
		scorecardspage.clickOn_Manual_Insight_Tab();
		scorecardspage.clickOn_New_Insight_RadioBtn();
		scorecardspage.Enter_InsightName("manual");
		scorecardspage.Select_RequiredRadioBtn();
		scorecardspage.Click_SaveBtn();
		scorecardspage.select_Keyword_Insight_Tab();
		scorecardspage.clickOn_New_Insight_RadioBtn();
		scorecardspage.Enter_InsightName("keyword");
		scorecardspage.Select_RequiredRadioBtn();
		scorecardspage.enter_Keywords(keyword1, keyword2, keyword3);
		scorecardspage.Click_SaveBtn();
		scorecardspage.clickOn_PreviewAllButton();
		scorecardspage.clickOn_DoneButton();
		Assert.assertEquals(scorecardspage.scorecardCreated_toastMessage_AvailabiltyTest(), true);

	}

	@Description("Verify when user clicks on 'Create a new Ultimate AI insight' link it is navigating to Create Insights under Insights module")
	@Test(priority = 6, enabled = true, dataProvider = "LLM_InsightsData", dataProviderClass = Dataproviders.class)
	public void create_NewLLM_Scrorecard(String outcome_label, String default_groupname) throws InterruptedException {
		scorecardspage.clickOn_CreateButton();
		scorecardspage.enter_ScorecardName();
		scorecardspage.enter_OutcomeLabel(outcome_label);
		scorecardspage.select_Outcometype("Total Score");
		scorecardspage.select_DefaultGroup(default_groupname);
		scorecardspage.clickOn_NextButton();
		scorecardspage.Select_SkipSection();
		scorecardspage.select_UltimateAI_Insight_Tab();
		scorecardspage.clickon_CreateNewUAI_link();
		scorecardspage.clickon_Proceed_Button();
		Assert.assertEquals(scorecardspage.insights_Heading_AvailabilityTest(), true);

	}
}
