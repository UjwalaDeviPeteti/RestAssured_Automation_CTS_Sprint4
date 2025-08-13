package Stepdefinitions;

import java.io.FileNotFoundException;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.RestassuredUtilities;
import utilities.ValidationUtilities;

public class AddBookingStep {
	RestassuredUtilities util =new RestassuredUtilities();
	ValidationUtilities valutil= new ValidationUtilities();
	
	List<Response> bookingResponses;
	
	
	// Addbookingpost request
	@Given("Enter the baseuri and Addrequest")
    public void enter_baseuri_and_addrequest() {
        System.out.println("Base URI set and ready for Add Booking request");
    }

    @When("Send the Addbookingpost request with booking details")
    public void send_the_addbookingpost_request_with_booking_details() throws Exception {
    	String filePath = "src/test/resources/testData/Bookings.json";
    	bookingResponses =util.createBookingsFromJsonFile(filePath);
    }

    @Then("Validate the booking response")
    public void validate_the_response() throws FileNotFoundException {
        System.out.println("Response validated");
        for (Response response : bookingResponses) {
            // Validate status code for each create booking response
            response.then().statusCode(200);
            System.out.println("Booking created with response: " + response.asString());
        }
        System.out.println("All bookings validated");
    }

    @Then("Log the booking results")
    public void log_the_results() {
        System.out.println("Results logged");
        for (Response response : bookingResponses) {
            System.out.println("Add Booking Response: " + response.asString());
        }
        System.out.println("Results logged");
    }
}
