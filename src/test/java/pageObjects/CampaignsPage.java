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

public class CampaignsPage  {
	
	public WebDriver driver;
	//public JavascriptExecutor jsExecutor;
	public ElementUtils elementutils;
	public JavaScriptUtils javascriptutils;

	public  CampaignsPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
		//jsExecutor = (JavascriptExecutor) driver;
		javascriptutils = new JavaScriptUtils(driver);
	}
	
	@FindBy(xpath = "//p[text()='Campaigns']")
	WebElement Campaignpageheading;
	@FindBy(xpath = "//div[text()='Create']")
	WebElement Campaigncreatebtn;
	@FindBy(xpath = "//input[@placeholder='Enter name']")
	WebElement Campaignnametxtfield;
	@FindBy(xpath = "//div[text()='Next']")
	WebElement Nextbutton;
	@FindBy(xpath = "//div[@class='successtext']")
	WebElement SuccessText;
	@FindBy(xpath = "//div[text()='Create another campaign']")
	WebElement CreateAnotherCampaignBtn;
	@FindBy(xpath = "(//input[@placeholder='Select'])[1]")
	WebElement Ownerdropdown;
	@FindBy(xpath = "//span[@class='mat-option-text']")
	List<WebElement> ListOfowner;
	@FindBy(xpath = "//div[text()=' Campaign ']")
	WebElement Campaignfilter;
	@FindBy(xpath = "//span[@class='mat-option-text']")
	List<WebElement> ListofCampaigns;
	@FindBy(xpath = "//input[@name='filterValue']")
	WebElement Campaignnamedropdown;
	@FindBy(xpath = "//td[@class='cdk-cell cdk-column-campaign_name ng-star-inserted']")
	WebElement CampaignNameGrid;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement SaveButton;
	@FindBy(xpath = "//mat-icon[@class='mat-icon notranslate title-close-icon mat-icon-no-color']//*[name()='svg']")
	WebElement crossbtn;
	@FindBy(xpath = "(//p[text()=\"Campaigns details updated.\"])[1]")
	WebElement campaignUpdate_Toast_Message;
	@FindBy(xpath = "//span[text()='Archive']")
	WebElement ArchiveButton;
	@FindBy(xpath = "//button[@class='mat-focus-indicator confirmation-btn bold mat-flat-button mat-button-base']//span[@class='mat-button-wrapper'][normalize-space()='Archive']")
	WebElement ConfirmArchiveButton;
	@FindBy(xpath = "(//p[text()='Campaign is Archived.'])[1]")
	WebElement campaignArchive_Toast_Message;
	@FindBy(xpath = "//button[text()='Clear all']")
	WebElement ClearAllBtn;
	
	
	
	By Next_button = By.xpath("//div[text()='Next']");
	By Campaignname_dropdown = By.xpath("//input[@name='filterValue']");
	By CampaignName_Grid = By.xpath("//td[@class='cdk-cell cdk-column-campaign_name ng-star-inserted']");
	By ClearAll_Btn = By.xpath("//button[text()='Clear all']");
	
	
	public String campaignName= "TestCampaign_" + BaseTest.RandomeAlphanumeric();
	public String newcampaignName= "NewTestCampaign_" + BaseTest.RandomeAlphanumeric();
	public String successmessage; 
	public String successText;
	public String campaignnameText;
	
	public boolean campaignsHeading_AvailabilityTest() {
		try {
			boolean campaignsheadingtxt = Campaignpageheading.isDisplayed();
			//String campaignsheadingtxt = Campaignpageheading.getText();
			return campaignsheadingtxt;
		} catch (Exception e) {
			System.out.println("Campaign heading text is not available");
			return false;
		}
	}
	public void clickOnCreateButton() {
		try {
			Campaigncreatebtn.click();
		} catch (Exception e) {
		
			System.out.println("user is unable to click on create button");
		}
	}
	
	public void enterCampaignname() {
		try {
			Campaignnametxtfield.sendKeys(campaignName);
		} catch (Exception e) {
			System.out.println("user is unable to enter the campaign name");
		}
	}
	public void enterNewCampaignname() {
		try {
			Campaignnametxtfield.sendKeys(newcampaignName);
		} catch (Exception e) {
			System.out.println("user is unable to enter the new campaign name");
		}
	}
	public void selectOwner(String owner) {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			javascriptutils.clickOnElement(Ownerdropdown);
		} catch (Exception e) {
			System.out.println("user is unable to click on owner dropdown");
		}
		try {
			elementutils.selectDropdownValue(ListOfowner,owner);
		} catch (Exception e) {
			System.out.println("user is unable to select owner from dropdown");
		}
	}
	public void clickOnNextButton() {
		try {
			elementutils.waitToDisplayElement(Next_button);
			javascriptutils.scrollIntoView(Nextbutton);
			Thread.sleep(2000);
			Nextbutton.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on next button");
		}
	}
	
	public String setSuccessMessage() {
		try {
			successmessage = campaignName + " has been created";
		} catch (Exception e) {
			System.out.println("user is unable to click on next button");
		}
		return successmessage;
	}
	public String newSetSuccessMessage() {
		try {
			successmessage = newcampaignName + " has been created";
		} catch (Exception e) {
			System.out.println("user is unable to click on next button");
		}
		return successmessage;
	}
	
	public String getSuccessMessage() {
		try {
			successText=SuccessText.getText();
		} catch (Exception e) {
			System.out.println("user is unable to enter the campaign name");
		}
		return successText;
	}
	public void clickOnCreateAnotherCampaignButton() {
		try {
			CreateAnotherCampaignBtn.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on CreateAnotherCampaignBtn button");
		}
	}
	public void clickOcrossbutton() {
		try {
			crossbtn.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on cross button");
		}
	}
	public void clickOnClearAllBtn() {
		try {
			elementutils.waitToDisplayElement(ClearAll_Btn);
			javascriptutils.scrollIntoView(ClearAllBtn);
			Thread.sleep(2000);
			ClearAllBtn.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on next button");
		}
	}
	
	public void clickOnCampaignFilter() {
		try {
			Campaignfilter.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Campaigns filter");
		}
	}
	public void selectCampaignFromDropdown() {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			elementutils.waitToDisplayElement(Campaignname_dropdown);
			Campaignnamedropdown.click();
			//javascriptutils.clickOnElement(Campaignnamedropdown);
		} catch (Exception e) {
			System.out.println("user is unable to click on campaign dropdown");
		}
		try {
			elementutils.selectDropdownValue(ListofCampaigns,campaignName);
		} catch (Exception e) {
			System.out.println("user is unable to select Campaign from dropdown");
		}
	}
	public String getCampaignNamefromgrid() {
		try {
			
			elementutils.waitToDisplayElement(CampaignName_Grid);
			
			campaignnameText=CampaignNameGrid.getText();
		} catch (Exception e) {
			System.out.println("user is unable to get the campaign name from grid");
		}
		return campaignnameText;
	}
	public void clickOnCampaignnameFromGrid() {
		try {
			CampaignNameGrid.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Campaigns name from grid");
		}
	}
	public void updateCampaignname() {
		try {
			Campaignnametxtfield.clear();
			Campaignnametxtfield.sendKeys(newcampaignName);
		} catch (Exception e) {
			System.out.println("user is unable to enter in Campaigns name textfield");
		}
	}
	public void clickOn_SaveButton() {
		//javascriptutils.scrollIntoView(SaveButton);
		try {
			SaveButton.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Save button");
		}

	}
	public boolean campaignUpdatetoastMessage_AvailabiltyTest() {
		try {

			String Update_ToastMessage = campaignUpdate_Toast_Message.getText();
			System.out.println(Update_ToastMessage);
			boolean Update_Message = campaignUpdate_Toast_Message.isDisplayed();
			return Update_Message;
		} catch (Exception e) {
			System.out.println("update toast message is not available");
			return false;
		}

	}
	public void selectEditedCampaignFromDropdown() {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			elementutils.waitToDisplayElement(Campaignname_dropdown);
			Campaignnamedropdown.click();
			//javascriptutils.clickOnElement(Campaignnamedropdown);
		} catch (Exception e) {
			System.out.println("user is unable to click on campaign dropdown");
		}
		try {
			elementutils.selectDropdownValue(ListofCampaigns,newcampaignName);
		} catch (Exception e) {
			System.out.println("user is unable to select Campaign from dropdown");
		}
	}
	public void clickOn_ArchiveButton() {
		//javascriptutils.scrollIntoView(SaveButton);
		try {
			ArchiveButton.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Save button");
		}

	}
	
	public void clickOn_confirmArchiveButton() {
		//javascriptutils.scrollIntoView(SaveButton);
		try {
			ConfirmArchiveButton.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Save button");
		}

	}
	public boolean campaignArchivetoastMessage_AvailabiltyTest() {
		try {
			String Update_ToastMessage = campaignArchive_Toast_Message.getText();
			System.out.println(Update_ToastMessage);
			boolean Update_Message = campaignArchive_Toast_Message.isDisplayed();
			return Update_Message;
		} catch (Exception e) {
			System.out.println("Archive toast message is not available");
			return false;
		}

	}
	
}