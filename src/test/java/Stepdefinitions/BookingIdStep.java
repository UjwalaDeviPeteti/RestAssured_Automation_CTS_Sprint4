package Stepdefinitions;

import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.RestassuredUtilities;
import utilities.ValidationUtilities;

public class BookingIdStep {
	
	RestassuredUtilities util =new RestassuredUtilities();
	ValidationUtilities valutil= new ValidationUtilities();
	Response bookingResponse;  
	
	// View booking by id request
	@Given("Enter the baseuri and GetIdrequest")
    public void enter_baseuri_and_getidrequest() {
        System.out.println("Base URI set and ready for Get By ID request");
    }

    @When("Send the GetById request with bookingId")
    public void send_the_getbyid_request_with_bookingId() throws FileNotFoundException {
    	bookingResponse = util.viewBookingById();
    }

    @Then("Validate the bookingid response")
    public void validate_the_response() throws FileNotFoundException {
        System.out.println("Response validated");
        bookingResponse.then()
        .statusCode(200)
        .contentType("application/json");  // or JSON depending on your API
    System.out.println("Response validated");
    }

    @Then("Log the bookingid results")
    public void log_the_bookingid_results() {
       
        System.out.println("Booking Response: " + bookingResponse.asString());
        System.out.println("Results logged");
    }


}
