package stepDefinitionScripts;

import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.VerifyPage;


public class EditDetailsStepDef extends Driver {

	@Given("a user is on the landing page")
	public void a_user_is_on_the_landing_page() throws InterruptedException {
		logger.info("*** Test scenario 8: Edit Details ***");
		assertTrue(driver.getTitle().equals("Login"));
	    logger.info("Login page displayed");
	}

	@When("he enters the login credentials and click on login")
	public void he_enters_the_login_credentials_and_click_on_login() {
		
		landingpage.username("admin");
		landingpage.password("Admin123");
		landingpage.clickInpatientWard();
		landingpage.clickLogin();
		logger.info("Logined Sucessfully");
	}

	@When("he click on find patient record")
	public void he_click_on_find_patient_record() {
		
	
	HomePage.findPatient();
	logger.info("Patient found sucessfully");
	    
	}

	@When("he enters the search id or name of patient")
	public void he_enters_the_search_id_or_name() throws InterruptedException {
		
	   searchPatientPage.clickSearch("1000");
	   logger.info("Searched the patient sucessfully");
	   
	 
	}

	@When("he click on which patient data want to edit")
	public void he_click_on_which_patient_data_you_want_to_edit() throws InterruptedException {
		
		searchPatientPage.hoverPatient();
		logger.info("clicked the patient sucessfully");
	    
	}
	@When("he click on edit Registration details")
	public void he_click_on_edit_registration_details() throws InterruptedException {
		editDetailsPage.clickEdit();
		logger.info("clicked the edit registration details sucessfully");
		
	}
	@When("he click on name to edit the name in  registration")
	public void he_click_on_name_to_edit_the_name_in_registration() {
		editDetailsPage.clickDemographics();
		editDetailsPage.enterName("PQR");
		editDetailsPage.clickSave();
		editDetailsPage.clickConform();
		logger.info("Edited the patient Details sucessfully");
	}


	

	@Then("verify the test whether the data is edited or not")
	public void verify_the_test_whether_the_data_is_edited_or_not() throws InterruptedException {
	String exceptedErrmsg="General Actions";
    String actualErrmsg=VerifyPage.getVerifyMsg();
      Assert.assertEquals(exceptedErrmsg,actualErrmsg);
      logger.info("Verified the Edited patient Details sucessfully");
		
	}
}
