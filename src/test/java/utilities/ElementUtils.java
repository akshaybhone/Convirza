package utilities;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ElementUtils {
	
	public WebDriver driver;

	// Constructor
	public ElementUtils(WebDriver driver) {
		//super(driver);

		this.driver=driver; 
		PageFactory.initElements(driver, this);
		 
	}
	
	/*
	This method use to perform move to element action using actions class
	 

	public void moveToElement(By locator){
		WebElement element=getElement(locator);
		Actions ac= new Actions(driver);
		ac.moveToElement(element).build().perform(); 
	}
	*/
	
	/**
	 * This method is use to select the dropdown value of Select base dropdown without any select class method
	 * @param parentgroup 
	 * @param listOfParentGroup 
	 * @param locator
	 * @param value
	 */
	public void selectDropdownValue(List<WebElement> locator, String value ) {
		//List<WebElement> drodownlist = locator;
		System.out.println("Size of the dropdown list is:"+ locator.size());
		System.out.println("DropDown options are: ");
		for(WebElement e : locator) {
			//System.out.println(e.getText());
			if(e.getText().equals(value)) {
				System.out.println(e.getText());
				e.click();
				break;
			}
		}
	}
	
	
	public String RandomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String RandomeNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String RandomeAlphanumeric() {
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);
		return (str + "@" + num);
	}

}
