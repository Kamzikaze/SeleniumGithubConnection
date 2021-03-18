package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
																// tags= "@ENTERTAGHERE" samt i featurefilen för att köra specifika testfall
@CucumberOptions(features="src/test/resources/features", glue="stepDefinitions") 
public class TestRunner {
}
