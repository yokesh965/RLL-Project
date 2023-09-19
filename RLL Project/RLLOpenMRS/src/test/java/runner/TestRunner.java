package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "Features",
				 glue = "stepDefinitionScripts",
				 //tags = "@Login_tag",
				 plugin = { "pretty", "html:target/cucumber-reports.html" },
				 monochrome = true
				)


public class TestRunner extends AbstractTestNGCucumberTests {

}
