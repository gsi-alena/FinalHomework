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
public class DriverListPage extends PageObject {

   public DriverListPage() {
		super();
		this.urlpath = "/driver"; 

   }
   public boolean isDriversList() {
		WebElement i = getWebElement(By.xpath("//span[@class='styles__SpanFont18Bold-sc-1qjgkf9-1 iaAGQP']"));
		boolean a = i.getText().equals("Drivers List");
		Assert.assertTrue(i.getText().equals("Drivers List"));
		return a;
	}
   public WebElement getSearchElement() {
	 return this.getWebElement(By.xpath("//input[@placeholder='Search...' and @class='ant-input']"));  
   } 
   
   public void setSearchElement(String searchcriteria) {
	 this.getSearchElement().sendKeys(searchcriteria);  
   }
   public WebElement getSearchButton() {
	 return this.getWebElement(By.xpath("//button[@class='ant-btn ant-btn-icon-only ant-input-search-button']"));  
   }
   public String getDriverStatus(String pdriver) {
	   setSearchElement(pdriver);
	   getSearchButton().click();
	   String statuscolumntext = "";
	   WebElement row1 = this.getWebElement(By.xpath("//tr[@data-row-key='1' ]"));
	   
	   if(row1!=null) {
	   List <WebElement> row1columns = row1.findElements(By.className("ant-table-cell"));//Row1 columns
	   WebElement statuscolumn= row1columns.get(7).findElement(By.className("ant-tag ant-tag-geekblue"));
	   statuscolumntext=statuscolumn.getText();
	   }
	   return statuscolumntext;
   }
   public String getDriverEmail(String pdriver) {
	   setSearchElement(pdriver);
	   getSearchButton().click();
	   String emailcolumntext = "";
	   WebElement row1 = this.getWebElement(By.xpath("//tr[@data-row-key='1' ]"));
	   
	   if(row1!=null) {
	   List <WebElement> row1columns = row1.findElements(By.className("ant-table-cell"));//Row1 columns
	   emailcolumntext= row1columns.get(3).findElement(By.className("ant-tag ant-tag-geekblue")).getText();
	   }
	   return emailcolumntext;
   }
   public WebElement getDriverVehiclesIcon(String pdriver) {
	  setSearchElement(pdriver);
	  getSearchButton().click();
      WebElement actioncolumn = null;
      WebElement row1 = this.getWebElement(By.xpath("//tr[@data-row-key='1' ]"));
      
      if(row1!=null) {
      List <WebElement> row1columns = row1.findElements(By.className("ant-table-cell"));//Row1 columns
	  actioncolumn= row1columns.get(10).findElement(By.className("//span[@class='LinkIconAction__RiftLinkWrapper-sc-4fk8om-0 jrCsLb' ]/descendant::span[@class='anticon anticon-car']"));  	    
      }
    return actioncolumn;
   } 
   public WebElement getDriverDocsIcon(String pdriver) {
		  setSearchElement(pdriver);
		  getSearchButton().click();
	      WebElement actioncolumn = null;
		  WebElement row1 = this.getWebElement(By.xpath("//tr[@data-row-key='1' ]"));
		  
		  if(row1!=null) {
		  List <WebElement> row1columns = row1.findElements(By.className("ant-table-cell"));//Row1 columns
		  actioncolumn= row1columns.get(13).findElement(By.className("//span[@class='LinkIconAction__RiftLinkWrapper-sc-4fk8om-0 jrCsLb' ]/descendant::span[@class='anticon anticon-file-text']"));  	    
		  }
	    return actioncolumn;
	 } 
   public WebElement getDriverEditIcon(String pdriver) {
	  setSearchElement(pdriver);
	  getSearchButton().click();
      WebElement actioncolumn = null;
	  WebElement row1 = this.getWebElement(By.xpath("//tr[@data-row-key='1' ]"));
	  
	  if(row1!=null) {
	  List <WebElement> row1columns = row1.findElements(By.className("ant-table-cell"));//Row1 columns
	  actioncolumn= row1columns.get(10).findElement(By.className("//span[@class='LinkIconAction__RiftLinkWrapper-sc-4fk8om-0 jrCsLb' ]/descendant::span[@class='anticon anticon-edit']"));  	    
	  }
	return actioncolumn;
   } 
   public WebElement getAddDriverButton() {
	  return this.getWebElement(By.xpath("//button[contains(@class,'ant-btn ant-btn-primary')]"));
   }

}
