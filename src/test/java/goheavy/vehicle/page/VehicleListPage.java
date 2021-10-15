package goheavy.vehicle.page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class VehicleListPage extends PageObject {

	 public VehicleListPage () {
			super();
			this.urlpath = "/vehicleinsurance"; 

	   }
		public boolean isVehiclesList() {
			WebElement i = getWebElement(By.xpath("//span[@class='styles__SpanFont18Bold-sc-1qjgkf9-1 iaAGQP']"));
			boolean a = i.getText().equals("Vehicles & Insurance List");
			Assert.assertTrue(i.getText().equals("Vehicles & Insurance List"));
			return a;
		}
	   public WebElement getSearchElement() {
		 return this.getWebElement(By.xpath("//input[@placeholder='Search...' and @class='ant-input']"));  
	   } 
	   
	   public void setSearchElement(String searchcriteria) {
		 this.getWebElement(By.xpath("//input[@placeholder='Search...' and @class='ant-input']")).sendKeys(searchcriteria);  
	   }
	   public WebElement getSearchButton() {
		 return this.getWebElement(By.xpath("//button[@class='ant-btn ant-btn-icon-only ant-input-search-button']"));  
	   }
	   public String getVehicleStatus() {
		   WebElement row1 = this.getWebElement(By.xpath("//tr[@data-row-key='1' ]"));
		   List <WebElement> row1columns = row1.findElements(By.className("ant-table-cell"));//Row1 columns
		   WebElement statuscolumn= row1columns.get(11).findElement(By.className("ant-tag ant-tag-blue"));
		   return statuscolumn.getText();
	   }
	   public String getVehicleDriverName() {
		   WebElement row1 = this.getWebElement(By.xpath("//tr[@data-row-key='1' ]"));
		   List <WebElement> row1columns = row1.findElements(By.className("ant-table-cell"));//Row1 columns
		   String drivercolumntext= row1columns.get(10).getText();//(By.className("ant-tag ant-tag-geekblue")).getText();
		   return drivercolumntext;
	   }
	   public String getLicensePlateNo() {
		   WebElement row1 = this.getWebElement(By.xpath("//tr[@data-row-key='1' ]"));
		   List <WebElement> row1columns = row1.findElements(By.className("ant-table-cell"));//Row1 columns
		   String licensecolumntext= row1columns.get(6).getText();//(By.className("ant-tag ant-tag-geekblue")).getText();
		   return licensecolumntext;
	   }
	   public WebElement getVehiclesDocsIcon(String pLicensePlatoNo) {
		  setSearchElement(pLicensePlatoNo);
		  getSearchButton().click();
	      WebElement actioncolumn = null;
		  WebElement row1 = this.getWebElement(By.xpath("//tr[@data-row-key='1' ]"));
		  List <WebElement> row1columns = row1.findElements(By.className("ant-table-cell"));//Row1 columns
		  if(row1columns.size()>0) {
			  actioncolumn= row1columns.get(13).findElement(By.className("//span[@class='LinkIconAction__RiftLinkWrapper-sc-4fk8om-0 jrCsLb' ]/descendant::span[@class='anticon anticon-file-text']"));  	    
		  }
			  return actioncolumn;
	   } 
	   
}
