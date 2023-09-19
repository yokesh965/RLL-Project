package stepDefinitionScripts;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingSteps extends Driver {
	
	@Given("a user is on the landing page of Openmrs")
	public void a_user_is_on_the_landing_page_of_openmrs() {
	   Assert.assertTrue(driver.getTitle().equals("Login"));
	   logger.info("Login page displayed");
	}
	@When("a user enters the username and password details")
	public void a_user_enters_the_username_and_password_details() {
		landingpage.username("admin");
		landingpage.password("Admin123");
	    logger.info("Entered Login Details");
	}
	@When("user selects the Inpatient Ward Location")
	public void user_selects_the_inpatient_ward_location() {
		landingpage.clickInpatientWard();
	    logger.info("User Selects Inpatient ward");
	}
	@When("user clicks on the log in button")
	public void user_clicks_on_the_log_in_button() {
		landingpage.clickLogin();
	    logger.info("Logged in sucessfully");
	}
	@Then("he must see the message - {string}")
	public void he_must_see_the_message(String string) {
	    String expectedMsg = string;
	    String actualMsg = HomePage.getpageText();
	    Assert.assertEquals(actualMsg, expectedMsg);
	    logger.info("Verified Home Page");
	}
	@Then("user clicks on the Appointment Scheduling")
	public void user_clicks_on_the_appointment_scheduling() {
		HomePage.clickAppointment();
	    logger.info("Selects Appointment Scheduling");
	}
	@Then("user clicks on the Manage Provider Schedules")
	public void user_clicks_on_the_manage_provider_schedules() {
		appointmentSchedulingPage.clickProvider();
	    logger.info("Selected Manage Provider Schedules");
	}
	@Then("user must see the message - {string}")
	public void user_must_see_the_message(String string) throws InterruptedException {
	    String expectedText = string;
	    String actualText = manageBlock.getblockText();
	    Assert.assertEquals(actualText, expectedText);
	    logger.info("Verifed Manage Block");
	}
	@Then("user selects the date for the calendar")
	public void user_selects_the_date_for_the_calendar() {
	    manageBlock.clickDate();
	    logger.info("Selected required date");
	}
	@Then("user selects user from the Provider list")
	public void user_selects_user_from_the_provider_list() throws InterruptedException {
	    createBlock.enterUser();
	    logger.info("Provided provider name");
	}
	@Then("user enters service type from the services box")
	public void user_enters_service_type_from_the_services_box() {
	    createBlock.enterServiceType();
	    logger.info("Selected service type");
	}
	
	@Then("user clicks on save")
	public void user_clicks_on_save() throws InterruptedException {
	    createBlock.clickSave();
	    logger.info("Confirmed Service Type");
	}
	
	
	@Then("he must see the error message - {string}")
	public void he_must_see_the_error_message(String string) throws InterruptedException {
	   String expectedmsg = string;
	   String actualmsg = createBlock.getcancelMsg();
	   Assert.assertEquals(actualmsg, expectedmsg);
	   logger.info("Verified message");
	}
	@Then("user clicks on cancel")
	public void user_clicks_on_cancel() {
	   createBlock.clickCancel();
	   logger.info("Selected Cancel");
	}
	@Then("user clicks on created block and clicks on edit")
	public void user_clicks_on_created_block_and_clicks_on_edit() throws InterruptedException {
	    createBlock.clickEditBlock();
	    logger.info("Clicked on Edit");
	}
	@Then("he must verify the message - {string}")
	public void he_must_verify_the_message(String string) throws InterruptedException {
	    String expectedEditMsg = string;
	    String actualEditmsg = createBlock.verifyeditMsg();
	    Assert.assertEquals(actualEditmsg, expectedEditMsg);
	    logger.info("Verified Edit Block page");
	}
	@Then("user selects required service")
	public void user_selects_required_service() throws InterruptedException {
	    createBlock.viewSelect();
	    logger.info("Selected required Service type");
	}
	@Then("user clicks on save button")
	public void user_clicks_on_save_button() throws InterruptedException {
	    createBlock.clickCloseSave();
	    logger.info("Confirmed Service and Appointment Blocked");
	}
	@Then("he must see the final message - {string}.")
	public void he_must_see_the_final_message(String string) throws InterruptedException {
	    String expectedText = string;
	    String actualText = createBlock.getconfirmMsg();
	    Assert.assertEquals(actualText, expectedText);
	    logger.info("Verified Message of Confirmed Page");
	}
}
