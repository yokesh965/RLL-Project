package stepDefinitionScripts;

import org.testng.Assert;

import io.cucumber.java.en.Then;

public class InvaildDataStepsDefs extends Driver {
	
	@Then("he must get a error message {string}")
	public void he_must_get_a_error_message(String string) {
	    String ExpectedErrorMsg = string;
	    String ActualErrorMsg = recordVitalsPage.getErrorMsg();
	    Assert.assertEquals(ActualErrorMsg, ExpectedErrorMsg);
	    logger.info("Got the Error Message");
	    logger.info("Testcase Passed...");
	    logger.info("*** End of Test scenario 4: Capture Vitals of a patient ***");
	}

}
