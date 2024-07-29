package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.BaseTest;
import utilities.ElementUtils;
import utilities.JavaScriptUtils;

public class GroupsAndUserPage {

	public WebDriver driver;
	public JavascriptExecutor jsExecutor;
	public ElementUtils elementutils;
	public JavaScriptUtils javascriptutils;;

	// Constructor
	public GroupsAndUserPage(WebDriver driver) {
		// super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
		jsExecutor = (JavascriptExecutor) driver;
		javascriptutils = new JavaScriptUtils(driver);
		
	}

	// Locators

	@FindBy(xpath = "//span[@class='title-bar-text']")
	WebElement GroupsAndUserHeading;
	@FindBy(xpath = "//div[@class='textStyle']")
	WebElement Createbutton;
	@FindBy(xpath = "//div[@class='smText']")
	WebElement Nextbutton;
	@FindBy(xpath = "//input[@id='mat-input-1']")
	WebElement ParentGroupdropdown;
	@FindBy(xpath = "//span[@class='mat-option-text']")
	List<WebElement> ListOfParentGroup;
	@FindBy(xpath = "//input[@placeholder='Enter Group name']")
	WebElement GroupName;
	@FindBy(xpath = "//input[@id='mat-input-2']")
	WebElement IndustryDropdown;
	@FindBy(xpath = "//mat-option[@class='mat-option mat-focus-indicator mat-tooltip-trigger ng-star-inserted']")
	List<WebElement> ListOfIndustry;
	@FindBy(xpath = "//div[@id='cdk-step-content-0-1']//div[@class='flex-end']//button[@type='button']")
	WebElement SubGroup_Nextbutton;
	@FindBy(xpath="(//p[text()='Group Created Successfully'])[1]")
	WebElement Success_Toast_Message;
	@FindBy(xpath = "//button[text()='Done']")
	WebElement SubGroup_Donebutton;
	@FindBy(xpath = "(//div[normalize-space()='Group Name'])[1]")
	WebElement group_Filter;
	@FindBy(xpath = "//button[normalize-space()='Filters']")
	WebElement SubGroup_FilterButton;
	@FindBy(xpath = "//input[@name='filterValue']")
	WebElement groupnamedropdwn;
	@FindBy(xpath = "//span[@class='mat-option-text']")
	List<WebElement> ListOfGroupname;
	@FindBy(xpath = "//button[normalize-space()='Refresh']")
	WebElement refreshbutton;
	@FindBy(xpath = "//td[@class='cdk-cell cdk-column-org_unit_name ng-star-inserted']")
	WebElement getGroupname;
	
	
	
	
	public String genaerateGroupname = "AutoGroup_" + BaseTest.RandomeNumber();
	
	public String editedGroupName = "Update"+genaerateGroupname;
	
	public String returnGroupName() {
		
		String returngroupName = genaerateGroupname;
		
		//System.out.println("from return groupname"+returngroupName);
		
		return returngroupName;
	}
	
	// Actions

	public boolean GroupsAndUserHeading_AvailabilityTest() {
		try {
			boolean GroupsAndUserheadingtxt = GroupsAndUserHeading.isDisplayed();
			return GroupsAndUserheadingtxt;
		} catch (Exception e) {
			System.out.println("dashboard heading text is not available");
			return false;
		}
	}

	public void ClickOnCreateButton() {
		try {
			Createbutton.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on create button");
		}
		// javascriptutils.scrollIntoView(Nextbutton);
	}

	public void ClickOnNextButton() {
		javascriptutils.scrollIntoView(Nextbutton);
		try {
			Nextbutton.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Next button");
		}

	}

	public void ClickonParentGroupDropdown() {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			ParentGroupdropdown.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Parentgroup dropdown");
		}

	}

	public void selectParentgroup(String parentgroup) {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			elementutils.selectDropdownValue(ListOfParentGroup, parentgroup);
		} catch (Exception e) {
			System.out.println("user is unable to click on Parentgroup dropdown");
		}

	}

	public void enterGroupName() {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			
			//String genaerateGroupname = "AutoGroup_" + elementutils.RandomeNumber();
			GroupName.sendKeys(genaerateGroupname);
		} catch (Exception e) {
			System.out.println("user is unable to click on grouupname");
		}

	}

	public void selectIndustry(String industryName) {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			javascriptutils.scrollIntoView(IndustryDropdown);
			javascriptutils.clickOnElement(IndustryDropdown);
		//	IndustryDropdown.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Industry dropdown");
		}
		try {
			elementutils.selectDropdownValue(ListOfIndustry, industryName);
		} catch (Exception e) {
			System.out.println("user is unable to fetch list of Industry");
		}

	}
	
	public void clickOn_SubGroup_NextButton() {
		javascriptutils.scrollIntoView(SubGroup_Nextbutton);
		try {
			SubGroup_Nextbutton.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Next button");
		}

	}
	
	public boolean successMessage_AvailabiltyTest() {
		try {
			boolean Success_Message = Success_Toast_Message.isDisplayed();
			return Success_Message;
		} catch (Exception e) {
			System.out.println("dashboard heading text is not available");
			return false;
		}

	}
	
	
	
	public void clickOn_DoneButton() {
		try {
			SubGroup_Donebutton.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Done button");
		}
	}

	
	public void clickOn_FilterButton() {
		try {
			SubGroup_FilterButton.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Filter button");
		}
		
	}
	
	public void clickON_GroupFilter() {
		try {
			group_Filter.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Group filter option");
		}
		
	}
	
	public void ClickOn_groupNameDropdown() {
		try {
			groupnamedropdwn.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on groupname drodown");
		}
		
	}
	
	public void selectFilter() {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			elementutils.selectDropdownValue(ListOfGroupname, genaerateGroupname);
		} catch (Exception e) {
			System.out.println("user is unable to click on Parentgroup dropdown");
		}

	}
	
	public void ClickOn_RefreshButton() {
		try {
			refreshbutton.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Refresh button");
		}
		
	}
	
	public String getgroupName() {
		String groupnametext = null;
		try {
			Thread.sleep(3000);
			
			groupnametext=getGroupname.getText();
			System.out.println("The groupname is : " + groupnametext );
		} catch (Exception e) {
			System.out.println("user is unable to get Group name");
		}
		
		return groupnametext;
		
	}
	
	public void click_OnGroupName() {
		try {
			getGroupname.click();
		} catch (Exception e) {
			System.out.println("user is unable to get Group name");
		}

	}
}
