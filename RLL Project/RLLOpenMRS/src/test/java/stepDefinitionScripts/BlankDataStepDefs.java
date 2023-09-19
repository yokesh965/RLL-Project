package stepDefinitionScripts;

import org.testng.Assert;

import io.cucumber.java.en.Then;

public class BlankDataStepDefs extends Driver{

	@Then("he must not be able to Capture the Vitals of the patient.")
	public void he_must_not_be_able_to_capture_the_vitals_of_the_patient() throws InterruptedException {
		captureVitalsPage.enterPatientName(ID);
	    captureVitalsPage.clickOnPatient();
	    String ExpectedText = "0 minute(s) ago";
	    String AutualText = captureVitalsPage.getText();
	    Assert.assertNotEquals(AutualText, ExpectedText);
	    logger.info("*** End of Test scenario 4: Capture Vitals of a patient ***");
	}
}
