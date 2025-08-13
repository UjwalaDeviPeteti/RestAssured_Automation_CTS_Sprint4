package Stepdefinitions;

import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.RestassuredUtilities;
import utilities.ValidationUtilities;

public class BookingClassStep {
	
	RestassuredUtilities util =new RestassuredUtilities();
	ValidationUtilities valutil= new ValidationUtilities();
	  Response classResponse;
	  String trainClass = "SLEEPER"; 
	 // View booking by class request
	@Given("Enter the baseuri and GetClassrequest")
    public void enter_baseuri_and_getclassrequest() {
        System.out.println("Base URI set and ready for Get By Class request");
    }

    @When("Send the GetByClass request with trainClass")
    public void send_the_getbyclass_request_with_trainClass() throws FileNotFoundException {
    	classResponse = util.viewBookingByClass();
    }

    @Then("Validate the bookingclass response")
    public void validate_the_response() throws FileNotFoundException {
        System.out.println("Response validated");
        classResponse.then()
        .statusCode(200)
        .contentType("application/json"); // or "application/json" as per API
    System.out.println("Response validated");
    }

    @Then("Log the bookingclass results")
    public void log_the_bookingclass_results() {
        System.out.println("Results logged");
    }

}
