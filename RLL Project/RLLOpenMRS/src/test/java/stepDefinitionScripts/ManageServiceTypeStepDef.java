package stepDefinitionScripts;

import java.text.SimpleDateFormat;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageServiceTypeStepDef extends Driver {

	String timeStamp = new SimpleDateFormat("ss.mm.HH").format(new java.util.Date());

	@When("I enter valid login credentials")
	public void i_enter_valid_login_credentials() {
		logger.info("*** Test scenario 5: Manage Service Type ***");
		landingpage.username("admin");
		landingpage.password("Admin123");
		landingpage.clickInpatientWard();
    }

	@When("I click the login button")
	public void i_click_the_login_button() {
		landingpage.clickLogin();
		logger.info("Logined Sucessfully");
	}

	@When("I click on Appointment Scheduling")
	public void i_click_on_appointment_scheduling() {
		HomePage.clickAppoinmentScheduling();
	}

	@When("I click on Manage Service Types")
	public void i_click_on_manage_service_types() {
		appointmentSchedulingPage.clickOnManageServiceType();
	}

	@When("I click on New Service Type")
	public void i_click_on_new_service_type() {
		manageServiceTypePage.clickOnNewServiceTypeBtn();
	}

	@When("I fill in the necessary information for a new service type")
	public void i_fill_in_the_necessary_information_for_a_new_service_type() {
		manageServiceTypePage.enterServiceName("Abc " + timeStamp);
		manageServiceTypePage.enterServiceDuration("20");
		manageServiceTypePage.enterServiceDescription("Description Demo");
		logger.info("New Service Details Entered");
	}

	@When("I click the Save button")
	public void i_click_the_save_button() {
		manageServiceTypePage.clickOnSaveBtn();
		logger.info("New Service Details Saved");
	}

	@Then("I should see a success message for adding the new service type")
	public void i_should_see_a_success_message_for_adding_the_new_service_type() {
		String ExpectedText = "Abc " + timeStamp;
	    String AutualText = manageServiceTypePage.getServiceName();
	    Assert.assertEquals(AutualText, ExpectedText);
	    logger.info("Testcase Passed...");
	}
}
