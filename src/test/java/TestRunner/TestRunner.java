package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		"C:\\Users\\1003413\\eclipse-workspace\\MoneyMartProject_Cucumber\\FeatureFiles\\TC01_SignUp.feature"

}, glue = "StepDefination", monochrome = true, dryRun = false, plugin = { "pretty",
		"html:target\\HTMLReports\\SignUp.html" }, tags = "@SignUp")

public class TestRunner {

}