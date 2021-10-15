package selenium_cucumber.selenium_cucumber.goheavy.driver;

import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium_cucumber.selenium_cucumber.general.Setup;
import selenium_cucumber.selenium_cucumber.general.Steps;
import selenium_cucumber.selenium_cucumber.goheavy.driver.pages.DriverListPage;
import selenium_cucumber.selenium_cucumber.goheavy.driver.pages.DriverPage;

public class DriverStep extends Steps{
	public DriverPage driverPage;
    
	public DriverStep() {
		driverPage = new DriverPage();
	}

	public void checkPage() {
		Assert.assertTrue(driverPage.isAddDriverView());
		/*String path = driverPage.getPagePath().toLowerCase();
		Assert.assertTrue(" The path privide is not correct in the url. path: " + path,
				driverPage.getCurrentUrl().toLowerCase().contains(path));*/
	}
	public void checkSpinningAppears() {
		driverPage.waitForSpinningElementDissapear();
	}

	public void clickAddButton() {
		Setup.getActions().moveToElement(driverPage.getAddButton()).click().perform();
		Setup.getWait().thread(4000);
		driverPage.waitForSpinningElementDissapear();
	}
	public void setDriverFields() {
		checkPage();
		driverPage.setSaveFormElementDriver();
		
	}
	public void setDriverStatus(String pstatus) {
		driverPage.setStatus(pstatus);
	}
	public void checkSaveMessage(String message) {
		driverPage.checkSaveMessage(message);
	}
	public void checkUpdateMessage(String message) {
		driverPage.checkUpdateMessage(message);
	}
	public void the_user_added_driver(String pdriver) {
		Assert.assertTrue(pdriver.equals(System.getProperty("pSaveDriverEmail")));	
	}
}
