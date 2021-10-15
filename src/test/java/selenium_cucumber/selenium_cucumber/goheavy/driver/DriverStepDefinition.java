package selenium_cucumber.selenium_cucumber.goheavy.driver;

import goheavy.documentsDriverVehicle.DocsDriverVehiclesSteps;
import goheavy.vehicle.VehicleStep;
import selenium_cucumber.selenium_cucumber.goheavy.account.page.AccountPage;
import selenium_cucumber.selenium_cucumber.goheavy.driver.pages.DriverListPage;
import io.cucumber.java.en.*;
import selenium_cucumber.selenium_cucumber.goheavy.account.AccountStep;

public class DriverStepDefinition {
    public DriverStep driverStep;
    public DriverListStep driverlistStep;
    public DocsDriverVehiclesSteps drivervehdocsStep;
       
    public DriverStepDefinition() {
		driverStep = new DriverStep();
		driverlistStep = new DriverListStep();
		drivervehdocsStep = new DocsDriverVehiclesSteps();
	}
	@Given("The user is in Drivers List view")
	public void the_user_is_in_drivers_list_view() {
	    driverlistStep.checkPage();
	}

	@Given("Clicks on the AddDriver button")
	public void clicks_on_the_add_driver_button() {
		driverlistStep.clickAddDriverButton();
	}
	@When("User insert driver valid data")
	public void user_insert_driver_valid_data() {
	    driverStep.setDriverFields();
	}

    @When("Clicks on the Add button")
	public void clicks_on_the_add_button() {
	     driverStep.clickAddButton();
	}
    
    @Then("The system saves the new driver information")
    public void the_system_saves_the_new_driver_information() {
       driverStep.checkSpinningAppears();
    }

	@Then("The system displays popup with driver creation success message {string}")
	public void the_system_displays_popup_with_driver_creation_success_message(String message) {
	    driverStep.checkSaveMessage(message);;
	}

    @When("Select Driver {string}")
    public void select_driver(String pdriver) {
         driverlistStep.findDriver(pdriver);
    }

    @When("Clicks on the Documents icon that belong to a driver")
    public void clicks_on_the_documents_icon_that_belong_to_a_driver() {
  	    driverlistStep.clickDriverDocsIcon(System.getProperty("pSaveDriverEmail"));
    }

	@Given("The user Added driver {string}")
    public void the_user_added_driver(String pdriver) {
		driverStep.the_user_added_driver(pdriver);
    }

    @When("Clicks on the Edit icon")
    public void clicks_on_the_edit_icon() {
    	driverlistStep.clickDriverEditIcon(System.getProperty("pSaveDriverEmail"));
    }

    @When("Update Driver Status to {string}")
    public void update_driver_status_to(String status) {
    	 driverlistStep.findDriver(System.getProperty("pSaveDriverEmail"));
    	 driverlistStep.clickDriverEditIcon(System.getProperty("pSaveDriverEmail"));
    	 driverStep.setDriverStatus(status);
    }
    @Then("The system displays popup with success update message {string}")
    public void the_system_displays_popup_with_success_update_message(String message) {
        driverStep.checkUpdateMessage(message);
    }
    @Then("Check the Driver is activated on Drivers List view")
    public void check_the_driver_is_activated_on_drivers_list_view() {
        driverlistStep.IsDriverClearStatus(System.getProperty("pSaveDriverEmail"));
}


}
