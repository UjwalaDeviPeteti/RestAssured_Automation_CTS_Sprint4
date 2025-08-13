package Stepdefinitions;

import java.io.FileNotFoundException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.RestassuredUtilities;
import utilities.ValidationUtilities;

public class AuthStep {
	
	private static final Logger logger = LogManager.getLogger(AuthStep.class);
	
	RestassuredUtilities util =new RestassuredUtilities();
	ValidationUtilities valutil= new ValidationUtilities();
	Response authResponse;
	
    // Authpost request
	 @Given("Enter the baseuri and Authpostrequest")
	    public void enter_baseuri_and_authpostrequest() {
	        // setup base URI and prepare for authpost request
		 logger.info("Navigating to login page");
	        System.out.println("Base URI set and ready for Authpost request");
	    }

	    @When("Send the Authpost request")
	    public void send_the_authpost_request() throws Exception {
//	        util.getAuthCode();
	    	authResponse = util.getAuthCode();
	    }

	    @Then("Validate the auth response")
	    public void validate_the_response() throws FileNotFoundException {
	        // Validation is done inside RestassuredUtilities methods with assertions
	        System.out.println("Response validated");
	        authResponse.then()
	        .statusCode(200)
	        .contentType("application/json");
	    }

	    @Then("Log the auth results")
	    public void log_the_results() {
	        System.out.println("Results logged");
	    }

}
