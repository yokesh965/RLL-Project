package stepDefinitionScripts;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ReadExcel;

public class RegisterPage extends Driver {
	
	
	@Given("I am on the application login page")
	public void i_am_on_the_application_login_page() {
		logger.info("*** Test scenario 2: Register a patient ***");
	}

	@When("I log in with valid credentials")
	public void i_log_in_with_valid_credentials() {
		landingpage.username("admin");
		landingpage.password("Admin123");
		landingpage.clickInpatientWard();
		landingpage.clickLogin();
		logger.info("Logined Sucessfully");
	}

	@When("I click on Register a Patient")
	public void i_click_on_register_a_patient() {
		HomePage.clickRegisterPatient();
	}

	@When("I Enter the Patient Details {int}")
	public void i_enter_the_patient_details(Integer int1) throws IOException {
		String[][] data = ReadExcel.getData("resources//Data.xlsx", "Sheet1");
		
		String name = data[int1][0];
		String familyName = data[int1][1];
		String Gender = data[int1][2];
		String Day = data[int1][3];
		String Month = data[int1][4];
		String Year = data[int1][5];
		String Address = data[int1][6];
		String CityVillage = data[int1][7];
		String StateProvince = data[int1][8];
		String Country = data[int1][9];
		String PostalCode = data[int1][10];
		String PhoneNumber = data[int1][11];
		enterDetails.enterDetails(name, familyName, Gender, Day, Month, Year, Address, CityVillage, StateProvince, Country, PostalCode, PhoneNumber);
		logger.info("Patient Details Entered");
	}

	@When("I click the Confirm button")
	public void i_click_the_confirm_button() {
		enterDetails.clickRegisterPatient();
		logger.info("New Patient register successfully");
	}

	@When("I click the Search button")
	public void i_click_the_search_button() {
	    
	}
	

	@Then("I should see the Find patient record details")
	public void i_should_see_the_find_patient_record_details() throws InterruptedException {
		ID = enterDetails.getPatientID();
		enterDetails.clickOnStartVisitBtn();
		enterDetails.clickOnConfirmBtn();
		logger.info("Start Visit...");
		Thread.sleep(3000);
	    String ExpectedName = "Shalini";
	    String ActualName = enterDetails.getPatientName();
	    Assert.assertEquals(ActualName, ExpectedName);
	   
	}
	
}
	

