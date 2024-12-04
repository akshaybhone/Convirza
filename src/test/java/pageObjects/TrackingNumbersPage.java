package pageObjects;

import java.io.IOException;
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

public class TrackingNumbersPage {

	WebDriver driver;
	//public JavascriptExecutor jsExecutor;
	public ElementUtils elementutils;
	public JavaScriptUtils javascriptutils;
		
	public TrackingNumbersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this); //@Findby
		elementutils= new ElementUtils(driver);
		javascriptutils = new JavaScriptUtils(driver);
		
	}
	
	public String settrackingNumberName= "TestTN_" + BaseTest.RandomeAlphanumeric();
	public String getTrackingNumberName;
	
	public String setTrackingNumberSuccessMessage;
	public String getTrackingNymberSuccessMessage;
	
	public String setTrackingNumber;
	public String gettrackingNumber;
	public String toprintTrackingNumber;
	
	
	public Boolean getTNUpdateToastMessage;
	
	public String getRingToNumberName;
	public String setRingToNumber;


	@FindBy(xpath = "//span[text()='Tracking numbers']")
	WebElement TrackingNumbersHeading;
	@FindBy(xpath = "//input[@data-placeholder='Select']")
	WebElement ExistingCampaignDropdown;
	@FindBy(xpath = "//span[@class='ng-star-inserted']")
	List<WebElement> ListOfCampaign;
	@FindBy(xpath = "//input[@data-placeholder='Type in an area code or city']")
	WebElement AreaCodeDrpdwn;
	@FindBy(xpath = "//span[@class='mat-option-text']")
	List<WebElement> ListOfAreaCode;
	@FindBy(xpath = "(//input[@data-placeholder='Select'])[1]")
	WebElement AvailableNumberdrpdwn;
	@FindBy(xpath = "//span[@class='mat-option-text']")
	List<WebElement> ListOfAvailableNumbers;
	@FindBy(xpath = "(//span[@class='mat-option-text'])[1]")
	WebElement TrackingNumber;
	@FindBy(xpath = "//input[@formcontrolname='tracking_name']")
	WebElement TrackingNameTxtfield;
	@FindBy(xpath = "(//input[@data-placeholder='Select'])[2]")
	WebElement AdSourceDropdown;
	@FindBy(xpath = "//span[@class='mat-option-text']")
	List<WebElement> ListOfAdSource;
	@FindBy(xpath = "//div[text()='Next']")
	WebElement NextBtn;
	@FindBy(xpath = "//span[text()='Use template']")
	WebElement UseTemplateRadioBtn;
	@FindBy(xpath = "(//input[@type='text'])[5]")
	WebElement Routingtypedropdwn;
	@FindBy(xpath = "//span[@class='mat-option-text']")
	List<WebElement> ListOfRoutingType;
	@FindBy(xpath = "(//input[@type='text'])[6]")
	WebElement Templatedropdwn;
	@FindBy(xpath = "//span[@class='mat-option-text']")
	List<WebElement> ListOfTemplates;
	@FindBy(xpath = "(//div[text()='Next'])[2]")
	WebElement Nextbutton2;
	@FindBy(xpath = "(//div[text()='Next'])[3]")
	WebElement Nextbutton3;
	@FindBy(xpath = "//div[@class='successtext']")
	WebElement TNSuccessMessageloc;
	@FindBy(xpath = "//span[text()='Create a new campaign ']")
	WebElement CreateNewCampaignRadioBtn;
	@FindBy(xpath = "//div[text()=' Tracking Number Name ']")
	WebElement TrackingNumberNameFilter;
	@FindBy(xpath = "//app-filter-item[2]//form[1]//div[1]//div[1]//input[1]")
	WebElement TrackingNumberNameFiltertextfield;
	@FindBy(xpath = "//td[@class='cdk-cell cdk-column-tn_name ng-star-inserted']")
	WebElement TrackingNumberNameGrid;
	@FindBy(xpath = "//td[@class='cdk-cell cdk-column-tracking_number ng-star-inserted']")
	WebElement TrackingNumberGrid;
	@FindBy(xpath = "(//div[@class='flex']//input)[6]")
	WebElement RingToNumberTxtfield;
	@FindBy(xpath = "//div[text()='Save']")
	WebElement Savebtn;
	@FindBy(xpath = "//span[text()=' OK ']")
	WebElement Okbtn;
	@FindBy(xpath = "(//p[text()='Tracking number updated successfully.'])[3]")
	WebElement TNUpdateToastMessage;
	@FindBy(xpath = "//td[@class='cdk-cell cdk-column-ring_to ng-star-inserted']")
	WebElement RingToNumberGrid;
	
	
	By Next_button = By.xpath("//div[text()='Next']");
	By loader = By.xpath("//span[@class='spinner-border spinner-border-sm ml-5 ng-star-inserted']");
	By TN_SuccessMessageloc = By.xpath("//div[@class='successtext']");
	By TrackingNumberNameFilter_textfield = By.xpath("//app-filter-item[2]//form[1]//div[1]//div[1]//input[1]");
	By TrackingNumberName_Grid = By.xpath("//td[@class='cdk-cell cdk-column-tn_name ng-star-inserted']");
	By TrackingNumber_Grid = By.xpath("//td[@class='cdk-cell cdk-column-tracking_number ng-star-inserted']");
	By Ok_btn = By.xpath("//span[text()=' OK ']");
	By TN_UpdateToastMessage = By.xpath("(//p[text()='Tracking number updated successfully.'])[3]");
	By RingToNumber_Txtfield = By.xpath("(//div[@class='flex']//input)[6]");
	
	
	
	public boolean trackingNumbersHeading_AvailabilityTest() {
		try {
			boolean trackingNumbersHeadingtxt = TrackingNumbersHeading.isDisplayed();
			return trackingNumbersHeadingtxt;
		} catch (Exception e) {
			System.out.println("Tracking Numbers Page heading text is not available");
			return false;
		}
	}
	public void selectExistingCampaign(String campaign_name) {
		try {
			javascriptutils.clickOnElement(ExistingCampaignDropdown);
		} catch (Exception e) {
			System.out.println("user is unable to click on Existing Campaign dropdown");
		}
		try {
			elementutils.selectDropdownValue(ListOfCampaign,campaign_name);
		} catch (Exception e) {
			System.out.println("user is unable to select Existing Campaign from dropdown");
		}
	}
	
	public void selectAreaCode(String area_code, String area_code_toselect) {
		try {
			//AreaCodeDrpdwn.click();
			//javascriptutils.clickOnElement(AreaCodeDrpdwn);
			AreaCodeDrpdwn.sendKeys(area_code);
		} catch (Exception e) {
			System.out.println("user is unable to click on Area code dropdown");
		}
		try {
			elementutils.selectDropdownValue(ListOfAreaCode,area_code_toselect);
			
		} catch (Exception e) {
			
			System.out.println("user is unable to select Area code from dropdown");
		}
	}
	
	public void selectAvailableTrackingNumbers() {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			Thread.sleep(2000);
			javascriptutils.clickOnElement(AvailableNumberdrpdwn);
		} catch (Exception e) {
			System.out.println("user is unable to click on Available Numbers dropdown");
		}
		elementutils.getDropdownValue(ListOfAvailableNumbers);
		try {
			
			setTrackingNumber=TrackingNumber.getText();
			toprintTrackingNumber=setTrackingNumber.replaceAll("[^0-9]", "");
			System.out.println(toprintTrackingNumber);
			javascriptutils.clickOnElement(TrackingNumber);
			
		//	setTrackingNumber=AvailableNumberdrpdwn.getText();
		//	System.out.println(setTrackingNumber);
			
			//elementutils.selectDropdownValue(ListOfAvailableNumbers,available_numbers);
		} catch (Exception e) {
			System.out.println("user is unable to select Available Numbers from dropdown");
		}
	}
	
	public void enterTrackingNumbername() {
		try {
			TrackingNameTxtfield.sendKeys(settrackingNumberName);
		} catch (Exception e) {
			System.out.println("user is unable to enter the Tracking Number name");
		}
	}
	public void selectAdSource(String ad_source) {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			javascriptutils.clickOnElement(AdSourceDropdown);
		} catch (Exception e) {
			System.out.println("user is unable to click on Available Numbers dropdown");
		}
		try {
			elementutils.selectDropdownValue(ListOfAdSource,ad_source);
		} catch (Exception e) {
			System.out.println("user is unable to select Available Numbers from dropdown");
		}
	}
	
	public void selectRoutingType(String routing_type) {

		if (elementutils.isRadioButtonEnable(UseTemplateRadioBtn)) {
			System.out.println("Use Template radio button is enabled");
			try { 
				javascriptutils.clickOnElement(Routingtypedropdwn);
			} catch (Exception e) {
				System.out.println("user is unable to click on Routing type dropdown");
			}
			try {
				elementutils.selectDropdownValue(ListOfRoutingType,routing_type);
			} catch (Exception e) {
				System.out.println("user is unable to select Routing Types from dropdown");
			}
			
		} else {
			System.out.println("Use Template radio button is not enabled");
		}
		
	}
	public void selectTemplate(String template) {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			javascriptutils.clickOnElement(Templatedropdwn);
		} catch (Exception e) {
			System.out.println("user is unable to click on Available Numbers dropdown");
		}
		try {
			elementutils.selectDropdownValue(ListOfTemplates,template);
		} catch (Exception e) {
			System.out.println("user is unable to select Available Numbers from dropdown");
		}
	}
	public void clickOnNextButton2() {
		try {
			//elementutils.waitToDisplayElement(Next_button);
			javascriptutils.scrollIntoView(Nextbutton2);
			Thread.sleep(2000);
			Nextbutton2.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on next button");
		}
	}
	public void clickOnNextButton3() {
		try {
			//elementutils.waitToDisplayElement(Next_button);
			javascriptutils.scrollIntoView(Nextbutton3);
			Thread.sleep(2000);
			Nextbutton3.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on next button");
		}
	}
	
	public String SetSuccessMessage() {
		try {
			setTrackingNumberSuccessMessage ="The tracking number "+ settrackingNumberName + " is set!" ;
			System.out.println(setTrackingNumberSuccessMessage);
			//The tracking number TestTN_og@33 is set!
		} catch (Exception e) {
			System.out.println("user is unable to click on next button");
		}
		return setTrackingNumberSuccessMessage;
	}
	
	public String getSuccessMessage() {
		try {
			elementutils.waitToDisplayElement(TN_SuccessMessageloc);
			getTrackingNymberSuccessMessage=TNSuccessMessageloc.getText();
			System.out.println(getTrackingNymberSuccessMessage);
		} catch (Exception e) {
			System.out.println("user is unable to click on next button");
		}
		return getTrackingNymberSuccessMessage;
	}
	
	public void getTrackingNumberDetails() throws IOException {
		
		String [][] tn = elementutils.getexceldata();
		
		
		
	}
	
	public void clickOnCreateNewCampaignRadioBtn() {
		try {
			javascriptutils.clickOnElement(CreateNewCampaignRadioBtn);
			//CreateNewCampaignRadioBtn.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Create New Campaign radio button");
		}
	}
	
	public void clickTrackingNumberNameFilter() {
		try {
			javascriptutils.clickOnElement(TrackingNumberNameFilter);
		} catch (Exception e) {
			System.out.println("user is unable to click on TrackingNumberName Filter");
		}
	}
	public void selectTNNamefromfilterDropdown() {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			elementutils.waitToDisplayElement(TrackingNumberNameFilter_textfield);
			TrackingNumberNameFiltertextfield.sendKeys(settrackingNumberName);
			//javascriptutils.clickOnElement(TrackingNumberNameFiltertextfield);
		} catch (Exception e) {
			System.out.println("user is unable to click on campaign dropdown");
		}
	}
	
	public String getTrackingNumberNamefromgrid() {
		try {
			
			elementutils.waitToDisplayElement(TrackingNumberName_Grid);
			
			getTrackingNumberName=TrackingNumberNameGrid.getText();
			System.out.println(getTrackingNumberName);
			
		} catch (Exception e) {
			System.out.println("user is unable to get the campaign name from grid");
		}
		return getTrackingNumberName;
	}
	
	public String getTrackingNumberfromgrid() {
		try {
			
			elementutils.waitToDisplayElement(TrackingNumber_Grid);
			
			gettrackingNumber=TrackingNumberGrid.getText();
			
			System.out.println(gettrackingNumber);
		} catch (Exception e) {
			System.out.println("user is unable to get the campaign name from grid");
		}
		return gettrackingNumber;
	}
	
	public void clickOnTrackingNumberNamefromgrid() {
		try {
			TrackingNumberNameGrid.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Campaigns name from grid");
		}
	}
	public void enterRingtoNumber(String ring_to_number) {
		// javascriptutils.scrollIntoView(ParentGroupdropdown);
		try {
			this.setRingToNumber=ring_to_number;
			System.out.println(setRingToNumber);
			//elementutils.waitToDisplayElement(Next_button);
			javascriptutils.scrollIntoView(RingToNumberTxtfield);
			elementutils.waitToDisplayElement(RingToNumber_Txtfield);
			RingToNumberTxtfield.clear();
			RingToNumberTxtfield.sendKeys(ring_to_number);
			//System.out.println();
			//javascriptutils.clickOnElement(TrackingNumberNameFiltertextfield);
		} catch (Exception e) {
			System.out.println("user is unable to click on RingToNumber Textfield");
		}
	}
	
	public void clickOnTrackingNumberNameSaveButton() {
		try {
			javascriptutils.scrollIntoView(Savebtn);
			Savebtn.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Save button");
		}
	}
	public void clickOnTrackingNumberNameOKButton() {
		try {
			elementutils.waitToDisplayElement(Ok_btn);
			Okbtn.click();
		} catch (Exception e) {
			System.out.println("user is unable to click on Save button");
		}
	}
	public Boolean getTNUpdate_ToastMessage() {
		try {
			
			elementutils.waitToDisplayElement(TN_UpdateToastMessage);
			getTNUpdateToastMessage=TNUpdateToastMessage.isDisplayed();
			//getTNUpdateToastMessage=TNUpdateToastMessage.getText();
			System.out.println(getTrackingNumberName);
			
		} catch (Exception e) {
			System.out.println("user is unable to get the campaign name from grid");
		}
		return getTNUpdateToastMessage;
	}
	
	public String getRingtoNumberNamefromgrid() {
		try {
			
			elementutils.waitToDisplayElement(TrackingNumberName_Grid);
			
			getRingToNumberName=RingToNumberGrid.getText();
			System.out.println(getRingToNumberName);
			
		} catch (Exception e) {
			System.out.println("user is unable to get the campaign name from grid");
		}
		return getRingToNumberName;
	}
	
}
