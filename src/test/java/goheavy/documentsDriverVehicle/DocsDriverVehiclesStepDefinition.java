package goheavy.documentsDriverVehicle;
import goheavy.vehicle.VehicleStep;
import io.cucumber.java.en.*;
public class DocsDriverVehiclesStepDefinition {

	private DocsDriverVehiclesSteps docsdrivervehSteps;
	
	public DocsDriverVehiclesStepDefinition() {
		docsdrivervehSteps = new DocsDriverVehiclesSteps();
	}
	 @Given("Approved Driver {string} and Vehicle documents {string}")
	 public void approved_driver_and_vehicle_documents(String pdriver, String pvehicle) {
		 docsdrivervehSteps.approveAllDocs(pdriver, pvehicle);
	 }
}
