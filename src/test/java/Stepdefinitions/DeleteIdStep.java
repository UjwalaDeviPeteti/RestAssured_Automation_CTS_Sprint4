package Stepdefinitions;

import java.io.FileNotFoundException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.RestassuredUtilities;
import utilities.ValidationUtilities;

public class DeleteIdStep {
	
	RestassuredUtilities util =new RestassuredUtilities();
	ValidationUtilities valutil= new ValidationUtilities();
	
	 Response deleteResponse;
	
	 // Delete booking by id request
	@Given("Enter the baseuri and DeleteIdrequest")
    public void enter_baseuri_and_deleteidrequest() {
        System.out.println("Base URI set and ready for Delete By ID request");
    }

    @When("Send the DeleteById request with bookingId")
    public void send_the_deletebyid_request_with_bookingId() throws FileNotFoundException {
    	deleteResponse = util.deleteBookingById();
    }

    @Then("Validate the deleteid response")
    public void validate_the_response() throws FileNotFoundException {
        System.out.println("Response validated");
        int actualStatus = deleteResponse.getStatusCode();
        Assert.assertTrue(actualStatus == 200 || actualStatus == 204, "Expected status code 200 or 204 but found " + actualStatus);

        deleteResponse.then()
            .contentType("application/json"); // Or whatever content type you expect

        System.out.println("Response validated");
    }

    @Then("Log the deleteid results")
    public void log_the_deleteid_results() {
    	System.out.println("Delete Booking Response: " + deleteResponse.asString());
        System.out.println("Results logged");
    }

}
