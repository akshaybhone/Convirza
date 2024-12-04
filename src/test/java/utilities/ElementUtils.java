package utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	public WebDriver driver;
	public JavaScriptUtils javascriptutils;;

	// Constructor
	public ElementUtils(WebDriver driver) {
		// super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
		javascriptutils = new JavaScriptUtils(driver);
	}

	/*
	 * This method use to perform move to element action using actions class
	 * 
	 * 
	 * public void moveToElement(By locator){ WebElement
	 * element=getElement(locator); Actions ac= new Actions(driver);
	 * ac.moveToElement(element).build().perform(); }
	 */

	/**
	 * This method is use to select the dropdown value of Select base dropdown
	 * without any select class method
	 * 
	 * @param parentgroup
	 * @param listOfParentGroup
	 * @param locator
	 * @param value
	 */
	public void selectDropdownValue(List<WebElement> locator, String value) {
		// List<WebElement> drodownlist = locator;
		System.out.println("Size of the dropdown list is:" + locator.size());
		System.out.println("DropDown options are: ");
		// System.out.println(value);
		for (WebElement e : locator) {
			System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase(value)) {
				System.out.println(e.getText());
				javascriptutils.clickOnElement(e);
				// e.click();
				break;
			}
		}
	}

	
	public void  select_DropdownValue_BySendkeys(WebElement dropdown,String value,WebElement dropdownvalue) throws InterruptedException {
		
		
		Thread.sleep(1500);
		dropdown.click();
		Thread.sleep(1500);
		dropdown.sendKeys(value);
		Thread.sleep(1500);
		dropdownvalue.click();
		
	}
	public void getDropdownValue(List<WebElement> locator) {
		// List<WebElement> drodownlist = locator;

		System.out.println("Size of the dropdown list is:" + locator.size());
		System.out.println("DropDown options are: ");
		// System.out.println(value);
		for (WebElement e : locator) {
			System.out.println(e.getText());
		}
	}

	public void waitToDisplayElement(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waitTillElementHide(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}

	public boolean isRadioButtonEnable(WebElement radio_button) {
		boolean radiobtn = radio_button.isEnabled();
		return radiobtn;
	}

	public String[][] getexceldata() throws IOException {
		String path = ".\\testdata\\ListOfTrackingNumbers.xlsx"; // Taking Excel file from testdata.

		ExcelUtility xlutil = new ExcelUtility(path); // creating an object for ExcelUtility.

		int totalrows = xlutil.getRowCount("group_details");
		int totalcols = xlutil.getCellCount("group_details", 1);

		String groupdata[][] = new String[totalrows][totalcols]; // created for two dimension array

		for (int i = 1; i <= totalrows; i++) { // i=rows and i=1 coz data is starting from row 2

			for (int j = 0; j < totalcols; j++) { // j=columns
				groupdata[i - 1][j] = xlutil.getCellData("group_details", i, j);
			}
		}

		return groupdata; // returning two dimensional array
	}

}
