package stepDefinitionScripts;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 


public class SearchPatientTest extends Driver{

	@Given("I am on the OpenMRS login page")
	public void i_am_on_the_open_mrs_login_page() throws InterruptedException {
		logger.info("*** Test scenario 3: Find Patient Record ***");
		String expectedMsg = "Location for this session:";
		String actualMsg = landingpage.VerifyMessage();
		Assert.assertEquals(actualMsg, expectedMsg);
		logger.info("Login page displayed and text is verified successfully");
	}

	@When("I enter my username and password")
	public void i_enter_my_username_and_password() {

		landingpage.enterUsername("admin");
		landingpage.enterPassword("Admin123");
		landingpage.clickInpatientWard();
		logger.info("Given Credentials entered successfully");

	}
	@When("I click the Login button")
	public void i_click_the_login_button() {

		landingpage.clickLoginBtn(); 
		logger.info("Logged in Successfully");
	}

	@When("I click on the Find Patient Record")
	public void i_click_on_the_find_patient_record() {

		HomePage.findPatient();
		logger.info("Find Patient Record was successfully clicked");
	}

	

	@Then("I enters an multiple patient name  {string} in the search text-box")
	public void i_enters_an_multiple_patient_name_in_the_search_text_box(String string) throws InterruptedException {
		
                   searchPatientPage.clickSearch1(string);
		
		try {
		        
               // Check whether the expected message ("Patient ID") is displayed
		        String expectedMsg1 = "Patient ID";
		        String actualMsg1 = searchPatientPage.VerifyMessage1();

		        // Validation for a valid search
		        if (actualMsg1.equals(expectedMsg1)) {
		            logger.info("Verified the Text successfully");
		        } else {
		            Assert.fail("Validation failed: Expected 'Patient ID' message not found.");
		        }
		    } catch (Exception e) {
		        // Handle any exceptions that may occur during the search
		        // In this catch block, we're handling the case when "No matching records found" is displayed
		        String expectedErrMsg = "No matching records found";
		        String actualErrMsg = searchPatientPage.ErrorMsg();

		        // Validation for an invalid search
		        if (actualErrMsg.equals(expectedErrMsg)) {
		            logger.info("Verified the error message for invalid search");
		        } else {
		            // If an exception occurs other than "No matching records found" message
		            e.printStackTrace(); 
		            Assert.fail("Exception occurred during the search: " + e.getMessage());
		        }
		    }
		
        logger.info("Successfully searched the Patient name");

	}
	
} 


