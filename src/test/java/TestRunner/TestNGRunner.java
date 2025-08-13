package TestRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/Features",  // Path to feature files
	    glue = "Stepdefinitions",                 // Path to step definitions
	    plugin = {"pretty", "html:target/cucumber-reports.html",
	    		"rerun:target/rerun.txt",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	            dryRun=false,    
				monochrome=true,    
				publish=false  
	)

//	    		plugin = {
//	    			    "pretty",
//	    			    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
//	    			})
	public class TestNGRunner extends AbstractTestNGCucumberTests {
         
	}
