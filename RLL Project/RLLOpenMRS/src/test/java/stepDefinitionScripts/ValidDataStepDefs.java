package stepDefinitionScripts;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidDataStepDefs extends Driver{

	@Given("a user is on the landing page of OpenMRS")
	public void a_user_is_on_the_landing_page_of_OpenMRS() {
		logger.info("*** Test scenario 4: Capture Vitals of a patient ***");

	}

	@When("he enter the username as {string}")
	public void he_enter_the_username_as(String name) {
		landingpage.username("admin");
		
	}

	@When("he enter the password as {string}")
	public void he_enter_the_password_as(String password) {
		landingpage.password("Admin123");
	}

	@When("he clicks on the Login button")
	public void he_clicks_on_the_login_button() {
		landingpage.clickInpatientWard();
	}

	@When("he clicks on the Capture Vitals")
	public void he_clicks_on_the_capture_vitals() {
		landingpage.clickLogin();
		logger.info("Logined Sucessfully");
	}

	@When("he clicks on any one patient from the list")
	public void he_clicks_on_any_one_patient_from_the_list() throws InterruptedException {
		HomePage.clickCaptureVitals();
	    captureVitalsPage.enterPatientName(ID);
	    captureVitalsPage.clickOnPatient();
	    logger.info("Found the Patient");
	}

	@When("he clicks on the Confirm button")
	public void he_clicks_on_the_confirm_button() {
		captureVitalsPage.clickOnConfirmBtn();
	}

	@When("he enters the height as {string}")
	public void he_enters_the_height_as(String string) {
		recordVitalsPage.enterHeight(string);
		recordVitalsPage.clickOnNextBtn();
	}

	@When("he enters the weight as {string}")
	public void he_enters_the_weight_as(String string) {
		recordVitalsPage.enterWeight(string);
		recordVitalsPage.clickOnNextBtn();
		recordVitalsPage.clickOnNextBtn();
	}

	@When("he enters the temperature as {string}")
	public void he_enters_the_temperature_as(String string) {
		recordVitalsPage.enterTemperature(string);
		recordVitalsPage.clickOnNextBtn();
	}

	@When("he enters the pulse as {string}")
	public void he_enters_the_pulse_as(String string) {
		recordVitalsPage.enterPulse(string);
		recordVitalsPage.clickOnNextBtn();
	}

	@When("he enters the Respiratory Rate as {string}")
	public void he_enters_the_respiratory_rate_as(String string) {
		recordVitalsPage.enterRespiratoryRate(string);
		recordVitalsPage.clickOnNextBtn();
	}

	@When("he enters the Blood Pressure \\(systolic) as {string}")
	public void he_enters_the_blood_pressure_systolic_as(String string) {
		recordVitalsPage.enterBloodPressureSystolic(string);
	}

	@When("he enters the Blood Pressure \\(diastolic) as {string}")
	public void he_enters_the_blood_pressure_diastolic_as(String string) {
		recordVitalsPage.enterenterBloodPressureDiastolic(string);
		recordVitalsPage.clickOnNextBtn();
	}

	@When("he enters the Pulse Oximeter reading as {string}")
	public void he_enters_the_pulse_oximeter_reading_as(String string) {
		recordVitalsPage.enterOximeterReading(string);
		recordVitalsPage.clickOnNextBtn();
	}

	@When("he clicks on the Save button")
	public void he_clicks_on_the_save_button() {
		recordVitalsPage.clickOnSaveBtn();
		logger.info("Vitals of the Patient Captured Sucessfully");
	}

	@Then("he must be able to Capture the Vitals of the patient.")
	public void he_must_be_able_to_capture_the_vitals_of_the_patient() throws InterruptedException {
		captureVitalsPage.enterPatientName(ID);
	    captureVitalsPage.clickOnPatient();
	    String ExpectedText = "0 minute(s) ago";
	    String AutualText = captureVitalsPage.getText();
	    Assert.assertEquals(AutualText, ExpectedText);
	    logger.info("Testcase Passed...");
	    logger.info("*** End of Test scenario 4: Capture Vitals of a patient ***");
	}
}
