package Stepdefinitions;

import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.RestassuredUtilities;
import utilities.ValidationUtilities;

public class TokenStep {
	
	RestassuredUtilities util =new RestassuredUtilities();
	ValidationUtilities valutil= new ValidationUtilities();
	Response tokenResponse; 
	
	 // Tokenpost request
	@Given("Enter the baseuri and Tokenrequest")
    public void enter_baseuri_and_tokenrequest() {
        System.out.println("Base URI set and ready for Token request");
    }

    @When("Send the Tokenpost request")
    public void send_the_tokenpost_request() throws Exception {
        tokenResponse=util.getAccessToken();
    }

    @Then("Validate the token response")
    public void validate_the_response() throws FileNotFoundException {
        
        tokenResponse.then()
        .statusCode(200)
        .contentType("application/json");
    System.out.println("Response validated");
    }

    @Then("Log the token results")
    public void log_the_results() {
    	System.out.println("Token Response: " + tokenResponse.asString());
        System.out.println("Access Token: " + util.accessToken);
        System.out.println("Results logged");
        System.out.println("Results logged");
    }
}
