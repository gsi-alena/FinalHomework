package goheavy.documentsDriverVehiclePage;
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

public class DocsDriverVehiclesPage extends PageObject {
	public DocsDriverVehiclesPage() {
		super();
		this.urlpath = "/document/driver"; 
	}
	public boolean isDocsDriverVehicleList() {
		WebElement i = getWebElement(By.xpath("//span[contains(.,'Documents for')]"));
		boolean driverdoc = i.getText().contains("Documents for");
		//Assert.assertTrue(i.getText().contains("Documents for"));
		WebElement j = getWebElement(By.xpath("//span[contains(.,'Vehicle')]"));
		boolean vehicledoc = j.getText().contains("Vehicle");
		if(driverdoc ||vehicledoc)
		 return true;
		else
			return false;
	}
	public void isDriver(String pdriver) {
		WebElement i = getWebElement(By.xpath("//span[contains(.,'Documents for"+pdriver+"')]"));
		boolean driverdoc = i.getText().contains("Documents for"+pdriver);
		Assert.assertTrue(driverdoc);
	}
	public void isVehicle(String pvehiclevin) {
		WebElement i = getWebElement(By.xpath("//span[contains(.,'Vehicle"+pvehiclevin+"')]"));
		boolean vehicledoc = i.getText().contains("Vehicle"+pvehiclevin);
		Assert.assertTrue(vehicledoc);
	}

	public boolean checkIsDocViewForm() {
		WebElement docformview = this.getWebElement(By.xpath("//form[@class='ant-form ant-form-horizontal']/descendant::span[contains(.,'Approve')]"));
		boolean a = docformview.getText().equals("Approve");
		Assert.assertTrue(docformview.getText().contains("Approve"));
		return a;
	}
	public WebElement getDocApproveButton() {
		return this.getWebElement(By.xpath("//form[@class='ant-form ant-form-horizontal']/descendant::button[@class='ant-btn ant-btn-primary']"));
	}
	public WebElement getBackButton() {
		return this.getWebElement(By.xpath("//button[@class='ant-btn ant-btn-primary styles__ButtonBack-sc-1ru8l1t-1 eQyIeM']"));
	}
	
	public WebElement getDocViewIcon(int tablenumber,int pos) {
		  
		WebElement body = this.getWebElement(By.className("ant-card-body"));
		List<WebElement> tables = body.findElements(By.className("styles__DocumentListContainer-sc-1ru8l1t-0 gkyste"));//Obtain the two tables
		WebElement resultdoc = null;
		//DriverDocs
		WebElement driverdocstable = tables.get(tablenumber).findElement(By.xpath("//table[@style='table-layout: auto;']/descendant::tbody[@class='ant-table-tbody']"));
		List<WebElement>driverdocstablerows = driverdocstable.findElements(By.className("ant-table-row ant-table-row-level-0"));
		if(driverdocstablerows.size()>0) {
		  List<WebElement> driverdocstablerowcolumns = driverdocstablerows.get(pos).findElements(By.xpath("ant-table-cell"));
		  resultdoc = driverdocstablerowcolumns.get(3).findElement(By.className("anticon anticon-check-circle"));
		  }
	    return resultdoc;
	 } 
	
	public void approveDriverDocumentsList(String pdriver){
		isDriver(pdriver);
		WebElement body = this.getWebElement(By.className("ant-card-body"));
		List<WebElement> tables = body.findElements(By.className("styles__DocumentListContainer-sc-1ru8l1t-0 gkyste"));//Obtain the two tables
		boolean resultdriver;
		//DriverDocs
		WebElement driverdocstable = tables.get(0).findElement(By.xpath("//table[@style='table-layout: auto;']/descendant::tbody[@class='ant-table-tbody']"));
		List<WebElement>driverdocstablerows = driverdocstable.findElements(By.className("ant-table-row ant-table-row-level-0"));
		if(driverdocstablerows.size()>0) {
		  for(int i=0; i<driverdocstablerows.size();i++) {
			List<WebElement> driverdocstablerowcolumns = driverdocstablerows.get(i).findElements(By.xpath("ant-table-cell"));
			driverdocstablerowcolumns.get(4).findElement(By.className("anticon anticon-check-circle")).click();
			if(checkIsDocViewForm()) {
				getDocApproveButton().click();//Approve doc
			}
			driverdocstablerowcolumns.get(3).getText().equals("Clear");//Verify doc was set to Clear status
		  }
		  resultdriver = true;
		} else resultdriver = false;
		Assert.assertTrue(resultdriver);
	}
	
	public void approveVehiclesDocumentsList(String pvehiclevin){
		isVehicle(pvehiclevin);
		WebElement body = this.getWebElement(By.className("ant-card-body"));
		List<WebElement> tables = body.findElements(By.className("styles__DocumentListContainer-sc-1ru8l1t-0 gkyste"));//Obtain the two tables
		boolean resultvehicle;
		//DriverVehicleDocs
			WebElement vehicledocstable = tables.get(1).findElement(By.xpath("//table[@style='table-layout: auto;']/descendant::tbody[@class='ant-table-tbody']"));
			List<WebElement>vehicledocstablerows = vehicledocstable.findElements(By.className("ant-table-row ant-table-row-level-0"));
			if(vehicledocstablerows.size()>0) {
			  for(int i=0; i<vehicledocstablerows.size();i++) {
				List<WebElement> vehicledocstablerowscolumns = vehicledocstablerows.get(i).findElements(By.xpath("ant-table-cell"));
				vehicledocstablerowscolumns.get(4).findElement(By.className("anticon anticon-check-circle")).click();
				if(checkIsDocViewForm()) {
					getDocApproveButton().click();//Approve doc
				}
				vehicledocstablerowscolumns.get(3).getText().equals("Clear");//Verify doc was set to Clear status
			  }	
			  resultvehicle = true;
			}else resultvehicle = false;
		Assert.assertTrue(resultvehicle);	
	}
}
