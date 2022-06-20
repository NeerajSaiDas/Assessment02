package Runner;

import CustomizedTestNGCucumber.CustomizedTestNG_Cucumber;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features={"./src/main/resources/FeatureFiles/HomePage.feature"},glue= {"StepDefinitios"})
public class DellRunner extends CustomizedTestNG_Cucumber{
	

}
