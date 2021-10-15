package goheavy.documentsDriverVehicle;

import goheavy.documentsDriverVehiclePage.DocsDriverVehiclesPage;
import goheavy.vehicle.page.VehiclePage;
import selenium_cucumber.selenium_cucumber.general.Setup;

public class DocsDriverVehiclesSteps {

	public DocsDriverVehiclesPage docsdrivervehiclespage;
	
	public DocsDriverVehiclesSteps() {
		docsdrivervehiclespage = new DocsDriverVehiclesPage();
	}
	public boolean checkIsDriverVehicleDocsView() {
		return docsdrivervehiclespage.isDocsDriverVehicleList();
	}
	public void checkSpinningAppears() {
		docsdrivervehiclespage.waitForSpinningElementDissapear();

	}
	public void approveAllDocs(String pdriver, String pvehiclevin) {
		docsdrivervehiclespage.approveDriverDocumentsList(pdriver);
		docsdrivervehiclespage.approveVehiclesDocumentsList(pvehiclevin);
		Setup.getActions().moveToElement(docsdrivervehiclespage.getBackButton()).click().perform();
	}
	public void approveDriverDocs(String pdriver) {
		docsdrivervehiclespage.approveDriverDocumentsList(pdriver);
		Setup.getActions().moveToElement(docsdrivervehiclespage.getBackButton()).click().perform();
	}
	public void approveVehicleDocs(String pvehiclevin) {
		docsdrivervehiclespage.approveVehiclesDocumentsList(pvehiclevin);
		Setup.getActions().moveToElement(docsdrivervehiclespage.getBackButton()).click().perform();
	}

}
