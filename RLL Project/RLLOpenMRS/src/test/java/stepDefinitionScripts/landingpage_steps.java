package stepDefinitionScripts;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ReadExcel;

public class landingpage_steps extends Driver {

	@Given("a user is on the login page of openMRS")
	public void a_user_is_on_the_login_page_of_open_mrs() {
		logger.info("*** Test scenario 1: login to OpenMRS ***");
	}

	@When("a user enter the username")
	public void a_user_enter_the_username() throws IOException {
		String[][] data = ReadExcel.getData("resources/LoginPage.xlsx", "Sheet4");
		logger.info("Read from Excel");
		
		for (int i = 1; i < 4; i++) {
			String username = data[i][0];
			String password = data[i][1];

			landingpage.EnterUsername(username);
			logger.info("Entered Username " + i);
			landingpage.EnterPassword(password);
			logger.info("Entered Password " + i);
			landingpage.clickInPatientWard();
			landingpage.clickLoginBtn();
		}
	}

	@When("a user enter the password")
	public void a_user_enter_the_password() {

	}

	@When("he choose the location")
	public void he_choose_the_location() {

	}

	@When("he click on the login button")
	public void he_click_on_the_login_button() {

	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() // throws InterruptedException
	{
		// Thread.sleep(2000);
		// assertTrue(driver.getTitle().equals("Logged in as Super User (admin) at
		// Inpatient Ward."));

	}

}
