package stepDefinitionScripts;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Tools;

public class BeforeAfter extends Tools {
	@Before
	public void setUp(Scenario scenario) {

		Driver.init();
	}

}