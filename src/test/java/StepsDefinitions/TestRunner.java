package StepsDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/features"
		,glue={"StepsDefinitions"},
		monochrome=true,
		//plugin= {"pretty","html:target/CucumberReports.html","json:target/JSONReports/report.json"}
		plugin= {"pretty","json:target/cucumber.json"},
		
		tags ="@Google01"

		)

public class TestRunner {

}
