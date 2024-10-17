package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
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
	@FindBy(xpath = "(//p[text()='Group Created Successfully'])[1]")
	WebElement Success_Toast_Message;
	@FindBy(xpath = "(//p[text()='Group Updated Successfully'])[1]")
	WebElement GrpUpdate_Toast_Message;
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
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement SaveButton;
	@FindBy(xpath = "//button[normalize-space()='Delete']")
	WebElement DeleteGroupbtn;
	@FindBy(xpath = "//button[@class='deletePopUser confirmation-btn']")
	WebElement ConfirmDeletebtn;
	@FindBy(xpath = "(//p[text()='Group Deleted Successfully'])[3]")
	WebElement GroupDeletetoastmessage;
	@FindBy(xpath = "//div[@class='mat-tab-label-content'][normalize-space()='Users']")
	WebElement Usertab;
	@FindBy(xpath = "//div[normalize-space()='User']")
	WebElement Userbutton;
	@FindBy(xpath = "//input[@placeholder='Enter First Name']")
	WebElement Firstname;
	@FindBy(xpath = "//input[@placeholder='Enter Last Name']")
	WebElement Lastname;
	@FindBy(xpath = "//input[@placeholder='Enter Email']")
	WebElement Emailtxtfield;
	@FindBy(xpath = "(//mat-icon[@svgicon='down-arrow'])[1]")
	WebElement Usergroupdropdown;
	@FindBy(xpath = "//span[@class='mat-option-text']")
	List<WebElement> ListOfusergroup;
	@FindBy(xpath = "(//mat-icon[@svgicon='down-arrow'])[2]")
	WebElement userroledropdwn;
	@FindBy(xpath = "//span[@class='mat-option-text']")
	List<WebElement> ListOfuserrole;
	@FindBy(xpath = "//div[@id='cdk-step-content-1-1']//div[@class='smText'][normalize-space()='Next']")
	WebElement User_NextButton;
	@FindBy(xpath = "(//p[text()= 'User Created Successfully'])[1]")
	WebElement User_createdtoastmessage;
	@FindBy(xpath = "//div[@class='successtext']")
	WebElement User_createdsuccessmessage;
	@FindBy(xpath = "//button[text()='Done']")
	WebElement User_DoneButton;
	@FindBy(xpath = "//div[text()=' Email ']")
	WebElement User_email;
	@FindBy(xpath = "//input[(@name='filterValue') and (@size='0')]")
	WebElement email_dropdwn;
	@FindBy(xpath = "//span[@class='mat-option-text']")
	List<WebElement> Useremail_List;
	@FindBy(xpath = "//td[@class='cdk-cell cdk-column-username ng-star-inserted']")
	WebElement useremailele;
	@FindBy(xpath = "(//p[text()='User Updated Successfully'])[1]")
	WebElement UserUpdate_ToastMessage;
	@FindBy(xpath = "(//p[text()='User Deleted Successfully'])[1]")
	WebElement UserDeletetoastmessage;
	
	

	By eamildropdown = By.xpath("//input[(@name='filterValue') and (@size='0')]");

	public String genaerateGroupname = "AutoGrp" + BaseTest.RandomeNumber();
	public String editedGroupName = "edit" + genaerateGroupname;

	public String firstname = "Test" + BaseTest.RandomeAlphanumeric();
	public String email = BaseTest.RandomeString().toLowerCase() + "@gmail.com";
	public String editedemail = "v1" + BaseTest.RandomeString().toLowerCase() + "@gmail.com";

	// Actions

	public String returnGroupName() {

		String returngroupName = genaerateGroupname;

		// System.out.println("from return groupname"+returngroupName);

		return returngroupName;
	}

	public String returneditedGroupName() {

		String returneditedgroupName = editedGroupName;

		System.out.println("from return groupname" + editedGroupName);

		return returneditedgroupName;
	}

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
			System.out.println("user is unable to select Parentgroup from dropdown");
		}

	}

	public void enterGroupName() {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			// String genaerateGroupname = "AutoGroup_" + elementutils.RandomeNumber();
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
			// IndustryDropdown.click();
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
			String SuccessToastMessage = Success_Toast_Message.getText();
			System.out.println(SuccessToastMessage);
			boolean Success_Message = Success_Toast_Message.isDisplayed();
			return Success_Message;
		} catch (Exception e) {
			System.out.println("Success toast message is not available");
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

	public void clickOn_GroupFilter() {
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

	public void selectGroupName() {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			elementutils.selectDropdownValue(ListOfGroupname, genaerateGroupname);
		} catch (Exception e) {
			System.out.println("user is unable to click on Parentgroup dropdown");
		}

	}

	public void ClickOn_RefreshButton() {
		try {
			// driver.wait(3000);
			refreshbutton.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Refresh button");
		}

	}

	public String getgroupName() {
		String groupnametext = null;
		try {
			Thread.sleep(3000);
			groupnametext = getGroupname.getText();
			System.out.println("The groupname is : " + groupnametext);
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

	public void updateGroupName() {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			Thread.sleep(3000);
			GroupName.clear();
			// String genaerateGroupname = "AutoGroup_" + elementutils.RandomeNumber();

			GroupName.sendKeys(editedGroupName);
		} catch (Exception e) {
			System.out.println("user is unable to enter in grouupname text");
		}

	}

	public void clickOn_SaveButton() {
		javascriptutils.scrollIntoView(SaveButton);
		try {
			SaveButton.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Save button");
		}

	}

	public boolean GroupUpdatetoastMessage_AvailabiltyTest() {
		try {

			String Update_ToastMessage = GrpUpdate_Toast_Message.getText();
			System.out.println(Update_ToastMessage);
			boolean Update_Message = GrpUpdate_Toast_Message.isDisplayed();
			return Update_Message;
		} catch (Exception e) {
			System.out.println("update toast message is not available");
			return false;
		}

	}

	public void selecteditgroupFilter() {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			elementutils.selectDropdownValue(ListOfGroupname, editedGroupName);
		} catch (Exception e) {
			System.out.println("user is unable to click on Parentgroup dropdown");
		}

	}

	public void clickOn_Deletebutton() {
		try {
			DeleteGroupbtn.click();
		} catch (Exception e) {
			System.out.println("delete button is not present");
		}

	}

	public void clickOn_ConfirmDeletebutton() {
		try {
			ConfirmDeletebtn.click();
		} catch (Exception e) {
			System.out.println("delete button on confirmation popup is not present");
		}

	}

	public boolean groupdeletetoastMessage_AvailabiltyTest() {
		try {
			String delete_Message = GroupDeletetoastmessage.getText();
			System.out.println(delete_Message);
			boolean delete_ToastMessage = GroupDeletetoastmessage.isDisplayed();
			return delete_ToastMessage;
		} catch (Exception e) {
			System.out.println("update toast message is not available");
			return false;
		}

	}
	
	public boolean userdeletetoastMessage_AvailabiltyTest() {
		try {
			String delete_Message = UserDeletetoastmessage.getText();
			System.out.println(delete_Message);
			boolean delete_ToastMessage = UserDeletetoastmessage.isDisplayed();
			return delete_ToastMessage;
		} catch (Exception e) {
			System.out.println("user delete toast message is not available");
			return false;
		}

	}

	public void clickOnuserTab() {
		try {
			Usertab.click();
		} catch (Exception e) {
			System.out.println("usertab is not available");
		}
	}

	public void clickOnuserbutton() {
		try {
			Userbutton.click();
		} catch (Exception e) {
			System.out.println("user button is not available");
		}
	}

	public void enterFirstName() {
		try {
			Firstname.sendKeys(firstname);
		} catch (Exception e) {
			System.out.println("First Name textfield is not available");
		}
	}

	public void enterlastName(String lastname) {
		try {
			Lastname.sendKeys(lastname);
		} catch (Exception e) {
			System.out.println("Last Name textfield is not available");
		}
		// javascriptutils.scrollIntoView(Nextbutton);
	}

	public void clickOnemailtextfield() {
		try {
			Emailtxtfield.click();
		} catch (Exception e) {
			System.out.println("email textfield is not available");
		}
	}

	public void enteremail() {
		try {
			Emailtxtfield.sendKeys(email);
		} catch (Exception e) {
			System.out.println("First Name textfield is not available");
		}
	}

	public void selectusergroup(String usergroup) {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			javascriptutils.clickOnElement(Usergroupdropdown);
		} catch (Exception e) {
			System.out.println("user is unable to click on usergroup dropdown");
		}
		try {
			elementutils.selectDropdownValue(ListOfusergroup, usergroup);
		} catch (Exception e) {
			System.out.println("user is unable to select usergroup from dropdown");
		}
	}

	public void selectuserrole(String userrole) {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			javascriptutils.clickOnElement(userroledropdwn);
		} catch (Exception e) {
			System.out.println("user is unable to click on userrole dropdown");
		}
		try {
			elementutils.selectDropdownValue(ListOfuserrole, userrole);
		} catch (Exception e) {
			System.out.println("user is unable to select userrole from dropdown");
		}
	}

	public void clickOn_user_NextButton() {
		javascriptutils.scrollIntoView(User_NextButton);
		try {
			User_NextButton.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Next button");
		}
	}

	public boolean usercreatedMessage_AvailabiltyTest() {
		try {
			String usercreated_Message = User_createdtoastmessage.getText();
			System.out.println(usercreated_Message);
			boolean usercreated_SuccessMessage = User_createdtoastmessage.isDisplayed();
			String userSuccessMessage = User_createdsuccessmessage.getText();
			System.out.println(userSuccessMessage);
			return usercreated_SuccessMessage;
		} catch (Exception e) {
			System.out.println("usercreated success toast message is not available");
			return false;
		}

	}

	public void clickOn_emailFilter() {
		try {
			User_email.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on email filter option");
		}

	}

	public void clickOn_emailDropdown() {
		try {
			elementutils.waitToDisplayElement(eamildropdown);
			email_dropdwn.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on email drodown");
		}

	}

	public void selectUseremail() {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			elementutils.selectDropdownValue(Useremail_List, email);
		} catch (Exception e) {
			System.out.println("user is unable to select user email from dropdown");
		}

	}

	public String return_emailID() {

		String emailID = email.toLowerCase();

		// System.out.println("from return groupname"+returngroupName);

		return emailID;
	}

	public String getuseremail() {
		String useremail = null;
		try {
			Thread.sleep(3000);
			useremail = useremailele.getText();
			System.out.println("The email is : " + useremail);
		} catch (Exception e) {
			System.out.println("user is unable to get Group name");
		}
		return useremail;
	}

	public void clickOn_email() {
		try {
			elementutils.waitToDisplayElement(eamildropdown);
			useremailele.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on email ");
		}

	}

	public void updateuseremail() {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			Thread.sleep(3000);
			Emailtxtfield.clear();
			// String genaerateGroupname = "AutoGroup_" + elementutils.RandomeNumber();

			Emailtxtfield.sendKeys(editedemail);
		} catch (Exception e) {
			System.out.println("user is unable to click on email textfield");
		}

	}

	public boolean UserUpdatetoastMessage_AvailabiltyTest() {
		try {

			String Update_ToastMessage = UserUpdate_ToastMessage.getText();
			System.out.println(Update_ToastMessage);
			boolean Update_Message = UserUpdate_ToastMessage.isDisplayed();
			return Update_Message;
		} catch (Exception e) {
			System.out.println("User update toast message is not available");
			return false;
		}

	}

	public void select_editedUseremail() {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			elementutils.selectDropdownValue(Useremail_List, editedemail);
		} catch (Exception e) {
			System.out.println("user is unable to select edited user email from dropdown");
		}

	}

	public String return_editemailID() {

		String editedemailID = editedemail.toLowerCase();

		// System.out.println("from return groupname"+returngroupName);

		return editedemailID;
	}
}
