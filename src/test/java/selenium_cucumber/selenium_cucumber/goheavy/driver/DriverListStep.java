package selenium_cucumber.selenium_cucumber.goheavy.driver;

import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium_cucumber.selenium_cucumber.general.Setup;
import selenium_cucumber.selenium_cucumber.goheavy.driver.pages.DriverListPage;
import selenium_cucumber.selenium_cucumber.goheavy.driver.pages.DriverPage;

public class DriverListStep {
	public DriverListPage driverListPage;
	public DriverListStep() {
		driverListPage = new DriverListPage();
	}
	public void checkPage() {
		Assert.assertTrue(driverListPage.isDriversList());
		/*String path = driverListPage.getPagePath().toLowerCase();
		Assert.assertTrue(" The path privide is not correct in the url. path: " + path,
				driverListPage.getCurrentUrl().toLowerCase().contains(path));*/
	}
	public void openDriverList() {
		HashMap<String, WebElement> li = driverListPage
				.getMenu(By.xpath("//span[@aria-label='idcard']/ancestor::span[@class='ant-menu-title-content']"));
		WebElement veh = li.get("Drivers");
		Setup.getActions().moveToElement(veh).click().perform();
		Setup.getWait().thread(4000);
		driverListPage.waitForSpinningElementDissapear();
	}
	public void clickAddDriverButton() {
		Setup.getActions().moveToElement(driverListPage.getAddDriverButton()).click().perform();
	}
	public void findDriver(String pcriteria) {
		driverListPage.setSearchElement(pcriteria);
		Setup.getActions().moveToElement(driverListPage.getSearchButton()).click().perform();	
	}
	public void clickDriverDocsIcon(String pdriver) {
		Setup.getActions().moveToElement(driverListPage.getDriverDocsIcon(pdriver)).click().perform();	
	}
	public void clickDriverEditIcon(String pdriver) {
		Setup.getActions().moveToElement(driverListPage.getDriverEditIcon(pdriver)).click().perform();	
	}
	public void clickDriverVehicleIcon(String pdriver) {
		Setup.getActions().moveToElement(driverListPage.getDriverVehiclesIcon(pdriver)).click().perform();	
	}
	public void IsDriverClearStatus(String pdriver) {
		Assert.assertTrue(driverListPage.getDriverStatus(pdriver).equals("Clear"));
	}
}
