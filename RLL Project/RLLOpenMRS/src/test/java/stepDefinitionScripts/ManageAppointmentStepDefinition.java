package stepDefinitionScripts;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.ReadExcel;

public class ManageAppointmentStepDefinition extends Driver {

	@Given("a user is on the landing page of openmrs website")
	public void a_user_is_on_the_landing_page_of_openmrs_website() {
		logger.info("*** Test scenario 6: Manage Appointment ***");
	}

	@Given("he entered valid credentials and click log in button")
	public void he_entered_valid_credentials_and_click_log_in_button() throws IOException {
		String[][] data = ReadExcel.getData("resources/TestData.xlsx", "Sheet1");

		for (int i = 1; i < 2; i++) {
			String username = data[i][0];
			String password = data[i][1];

			landingpage.enterUsername(username);
			landingpage.enterPassword(password);
			landingpage.clickInpatientWard();
			landingpage.clickLogin();
		}

	}

	@Given("he clicks Appointment Scheduling card")
	public void he_clicks_appointment_scheduling_card() {
		// Page navigation checking
		String expectedText = "Logged in as Super User (admin) at Inpatient Ward.";
		String actualText = landingpage.getHomePageText();
		Assert.assertEquals(actualText, expectedText);
		logger.info(actualText + ": Test Passed");
		HomePage.clickAppoinmentScheduling();
	}

	@Given("he clicks Manage Appointments card")
	public void he_clicks_manage_appointments_card() throws InterruptedException {
		appointmentSchedulingPage.clickManageScheduling();
	}

	@Given("he entered value and select patient")
	public void he_entered_value_and_select_patient() throws InterruptedException, IOException {
		// manageAppoinmentsPage.enterSearchPatientTextBox();
		// Page navigation checking
		String expectedText = "Manage Appointments";
		String actualText = appointmentSchedulingPage.getManageAppointmentPageText();
		Assert.assertEquals(actualText, expectedText);
		logger.info(actualText + ": Test Passed");
		String[][] data = ReadExcel.getData("resources/TestData.xlsx", "Sheet2");
		driver.navigate().refresh();
		for (int i = 1; i < 2; i++) {
			String patientName = data[i][1];
			manageAppoinmentsPage.enterSearchPatientTextBox(patientName);
			Thread.sleep(4000);
			// No matching record found in the list
			String expectedEmptyText = "No matching records found";
			String actualEmptyText = manageAppoinmentsPage.getEmptyValue();
			Assert.assertEquals(actualEmptyText, expectedEmptyText);
			logger.info(actualEmptyText + ": Assert Passed");
		}
		driver.navigate().refresh();
		for (int i = 2; i < 3; i++) {
			String patientName = data[i][1];
			manageAppoinmentsPage.enterSearchPatientTextBox(patientName);
			Thread.sleep(2000);
		}
		manageAppoinmentsPage.clickSelectPatient();
	}

	@Given("he select service type")
	public void he_select_service_type() throws InterruptedException {
		String expectedText = "Patient Appointments";
		String actualText = manageAppoinmentsPage.getPatientAppointmentPageText();
		Assert.assertEquals(actualText, expectedText);
		logger.info(actualText + ": Test Passed");

		// Cancelled Booking or Scheduled
//		String expectedBookedText1 = "Cancelled";
//		String actualBookedText1 = patientAppointmentPage.getAppointmentBookedText();
//		Assert.assertEquals(actualBookedText1, expectedBookedText1);
//		logger.info(actualBookedText1 + ": Test Passed");

		// No Appointment booked 
		String expectedListText = "No appointments";
		String actualListText = patientAppointmentPage.getAvailableAppointment();
		Assert.assertEquals(actualListText, expectedListText);
		System.out.println(actualListText + ": Test Passed");

		// No Available Time slots
		patientAppointmentPage.clickViewAllTypes();
		patientAppointmentPage.selectMentalServiceType();
		patientAppointmentPage.clickCheckBox();
		patientAppointmentPage.clickSearchBtn();
		String expectedSlotText = "No available time slots";
		String actualSlotText = patientAppointmentPage.getAvailableSlotText();
		Assert.assertEquals(actualSlotText, expectedSlotText);
		logger.info(actualSlotText + ": Test Passed");

		patientAppointmentPage.clickViewAllTypes();
		patientAppointmentPage.selectServiceType();
		patientAppointmentPage.clickCheckBox();
	}

	@Given("select timeframe")
	public void select_timeframe() {
		patientAppointmentPage.clickSearchBtn();
	}

	@Given("select time block")
	public void select_time_block() {
		patientAppointmentPage.clicktimeBlock();
	}

	@Given("click next")
	public void click_next() {
		patientAppointmentPage.ClickNextBtn();
	}

	@Then("click Save")
	public void click_save() throws InterruptedException, IOException {
		// Appointment booked successfully
		String expectedText = "Appointment Requests";
		String actualText = patientAppointmentPage.getAppointmentRequestPageText();
		Assert.assertEquals(actualText, expectedText);
		logger.info(actualText + ": Test Passed");
		appointmentRequestsPage.ClickSaveBtn();
		logger.info("Appointment Booked Successfully");

		String[][] data = ReadExcel.getData("resources/TestData.xlsx", "Sheet2");
		driver.navigate().refresh();
		for (int i = 2; i < 3; i++) {
			String patientName = data[i][1];
			manageAppoinmentsPage.enterSearchPatientTextBox(patientName);
			Thread.sleep(4000);
		}
		// Appointment Scheduled or not
		manageAppoinmentsPage.clickSelectPatient();
		String expectedBookedText = "Scheduled";
//		String expectedBookedText = "Cancelled";
		String actualBookedText = patientAppointmentPage.getAppointmentBookedText();
		Assert.assertEquals(actualBookedText, expectedBookedText);
		logger.info(actualBookedText + ": Test Passed");
		logger.info("*** Test scenario 6: Manage Appointment End***");
	}
}
