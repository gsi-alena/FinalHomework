package selenium_cucumber.selenium_cucumber.goheavy.driver.pages;
import selenium_cucumber.selenium_cucumber.general.PageObject;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;

import net.bytebuddy.implementation.FieldAccessor.FieldNameExtractor;
import selenium_cucumber.selenium_cucumber.general.PageObject;
import selenium_cucumber.selenium_cucumber.general.Setup;

public class DriverPage extends PageObject{
	String url = "C:\\Users\\windows10\\eclipse-workspace\\Homework04\\src\\main\\resources\\avatar.png"; 
	String emailparameter;
	public DriverPage() {
		super();
		this.urlpath = "/driver"; 

	}
	public boolean isAddDriverView() {
		WebElement i = getWebElement(By.xpath("//span[@class='styles__SpanFont18Bold-sc-1qjgkf9-1 iaAGQP']"));
		boolean a = i.getText().equals("Add Driver");
		Assert.assertTrue(i.getText().equals("Add Driver"));
		return a;
	}
	public WebElement getAddButton() {
		return this.getWebElement(By.xpath("//button[@class='ant-btn ant-btn-primary styles__ButtonSubmit-sc-1548o7b-1 khxaWf']"));
	}
	public void setBithdate() {
		waitForSpinningElementDissapear();
		Setup.getWait().thread(500);
		this.getWebElement(By.xpath("//input[@id='birthAt']")).click();
		int i = 0;
		while (i<22) {//1998
			this.getWebElement(By.xpath("//button[@class='ant-picker-header-super-prev-btn']")).click();
			i++;
		}
		this.getWebElement(By.xpath("//td[@title='1998-10-15']/descendant::div[@class='ant-picker-cell-inner']")).click();
		Setup.getWait().thread(500);
	}
	public void setTshirt() {
	// Scrolling the page to get the element activated
	   this.scroll("//form", By.id("tShirtSize"));
	   waitForSpinningElementDissapear();
	   Setup.getWait().thread(500);
	   this.getWebElement(By.xpath("//input[@id='tShirtSize'and @role='combobox']")).click();
	   this.getWebElement(By.xpath("//span[@class='ant-select-selection-item']and [@title='M']")).click();
	   Setup.getWait().thread(500);
	}
	public void setState() {
		// Scrolling the page to get the element activated
		   this.scroll("//form", By.id("addressStateId"));
		   waitForSpinningElementDissapear();
		   Setup.getWait().thread(500);
		   this.getWebElement(By.xpath("//input[@id='addressStateId'and @role='combobox']")).click();
		   this.getWebElement(By.xpath("//span[@class='ant-select-selection-item']and [@title='Alabama']")).click();
		   Setup.getWait().thread(500);
	}
	public void setDLDate() {
		waitForSpinningElementDissapear();
		Setup.getWait().thread(500);
		this.getWebElement(By.xpath("//input[@id='dlIssuedDate']")).click();
		this.getWebElement(By.xpath("//td[@title='2021-10-13']/descendant::div[@class='ant-picker-cell-inner']")).click();
		Setup.getWait().thread(500);	
	}
	public void setDLExpirationDate() {
		waitForSpinningElementDissapear();
		Setup.getWait().thread(500);
		this.getWebElement(By.xpath("//input[@id='dlExpirationDate']")).click();
		this.getWebElement(By.xpath("//td[@title='2021-10-31']/descendant::div[@class='ant-picker-cell-inner']")).click();
		Setup.getWait().thread(500);	
	}
	public void setClassType() {
		// Scrolling the page to get the element activated
		   this.scroll("//form", By.id("dlClassType"));
		   waitForSpinningElementDissapear();
		   Setup.getWait().thread(500);
		   this.getWebElement(By.xpath("//input[@id='dlClassType'and @role='combobox']")).click();
		   this.getWebElement(By.xpath("//span[@class='ant-select-selection-item']and [@title='A']")).click();
		   Setup.getWait().thread(500);
	}
	public void SaveDriverEmail(String pemail) {
		System.setProperty("pSaveDriverEmail", pemail);
	}
	public void setStatus(String pstatus) {
		// Scrolling the page to get the element activated
		this.scroll("//form", By.id("status"));
		waitForSpinningElementDissapear();
		Setup.getWait().thread(500);
		this.getWebElement(By.xpath("//input[@id='status'and @role='combobox']")).click();
		this.getWebElement(By.xpath("//span[@class='ant-select-selection-item']and [@title='"+pstatus+"']")).click();
		Setup.getWait().thread(500);
				
	}
	public void setSaveFormElementDriver() {
		
		//Driver Photo
		WebElement photo = this.getWebElement(By.xpath("//label[@title='Driver Photo (including shoulders)']/ancestor::div[contains(@class,'ant-row ant-form-item')]/descendant::input[@type='file']"));
		photo.sendKeys(url);
		// Scrolling the page to get the element activated
		 this.scroll("//form", By.id("firstName"));
		// Setting FirstName
		WebElement firstname= this.getWebElement(By.id("firstName"));
		firstname.clear();
		firstname.sendKeys("Ale");
		// Setting LastName
		WebElement lastname= this.getWebElement(By.id("lastname"));
		lastname.clear();
		lastname.sendKeys("Glez");
		//Birthdate
		setBithdate();
		// Setting Experience
		WebElement experience= this.getWebElement(By.id("experienceYear"));
		experience.clear();
		experience.sendKeys("5");
		//Mobile
		WebElement mobile= this.getWebElement(By.id("mobilePhone"));
		mobile.clear();
		mobile.sendKeys("(353) 456 - 3466");
		//Email
		WebElement email= this.getWebElement(By.id("mobilePhone"));
		email.clear();
		email.sendKeys("aletest@gamil.com");
		emailparameter = "aletest@gamil.com";
		//Tshirt
		setTshirt();
		// Scrolling the page to get the element activated
		this.scroll("//form", By.id("address"));
        //Address
		WebElement address= this.getWebElement(By.id("address"));
		address.clear();
		address.sendKeys("Ave45");
		//City
		WebElement city= this.getWebElement(By.id("addressCity"));
		city.clear();
		city.sendKeys("Ocean");
		//State
		setState();
		//ZipCode
		WebElement zipcode= this.getWebElement(By.id("addressZipCode"));
		zipcode.clear();
		zipcode.sendKeys("55567-5756");
		//Driver License Photo Front
		WebElement photo1 = this.getWebElement(By.xpath("//label[@title='Driver's License Photo (Front)']/ancestor::div[contains(@class,'ant-row ant-form-item')]/descendant::input[@type='file']"));
		photo1.sendKeys(url);
		//Driver License Photo Back
		WebElement photo2 = this.getWebElement(By.xpath("//label[@title='Driver's License Photo (Back)']/ancestor::div[contains(@class,'ant-row ant-form-item')]/descendant::input[@type='file']"));
		photo2.sendKeys(url);
		// Scrolling the page to get the element activated
		this.scroll("//form", By.id("dlNumber"));
		//DL Number
		WebElement dlnumber= this.getWebElement(By.id("dlNumber"));
		dlnumber.clear();
		dlnumber.sendKeys("7894561");
		//DL Issue Date
		setDLDate();
		//DL Expiration Date
		setDLExpirationDate();
		//DL Class Type
		setClassType();
		//saveEmail
		SaveDriverEmail(emailparameter);		
	}
	public WebElement getPopupMessage() {
		Setup.getWait().visibilityOfElement(By.xpath("//div[@class='ant-notification-notice-message']"),
				"Not element message");
		return this.getWebElement(By.xpath("//div[@class='ant-notification-notice-message']"));

	}
	public void checkSaveMessage(String message) {

		WebElement notifEle = getPopupMessage();
		Setup.getWait().thread(2);
		WebElement parent = notifEle
				.findElement(By.xpath("ancestor::div[contains(@class,'ant-notification-topRight')]"));

		// Checking messages match
		Assert.assertEquals("Save notification message was not found.", message.toLowerCase(),
				notifEle.getText().toLowerCase());
		
		// Checking that popup is in the right
		String style = parent.getAttribute("style");
		Assert.assertTrue("Popup is not in the right corner.", style.contains("right: 0px"));	

	}
	public void checkUpdateMessage(String message) {

		WebElement notifEle = getPopupMessage();
		Setup.getWait().thread(2);
		WebElement parent = notifEle
				.findElement(By.xpath("ancestor::div[contains(@class,'ant-notification-topRight')]"));

		// Checking messages match
		Assert.assertEquals("Save notification message was not found.", message.toLowerCase(),
				notifEle.getText().toLowerCase());
		
		// Checking that popup is in the right
		String style = parent.getAttribute("style");
		Assert.assertTrue("Popup is not in the right corner.", style.contains("right: 0px"));	

	}

}
