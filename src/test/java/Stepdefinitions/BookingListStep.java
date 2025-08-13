package Stepdefinitions;

import java.io.FileNotFoundException;
import static org.hamcrest.Matchers.containsString;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.RestassuredUtilities;
import utilities.ValidationUtilities;

public class BookingListStep {
	
	RestassuredUtilities util =new RestassuredUtilities();
	ValidationUtilities valutil= new ValidationUtilities();
	Response getListResponse;
	
	// View booking list get request
	@Given("Enter the baseuri and GetListrequest")
    public void enter_baseuri_and_getlistrequest() {
        System.out.println("Base URI set and ready for Get List request");
    }

    @When("Send the GetList request")
    public void send_the_getlist_request() throws FileNotFoundException {
    	getListResponse = util.getBookings();
    }

    @Then("Validate the listofbooks response")
    public void validate_the_response() throws FileNotFoundException {
        System.out.println("Response validated");
        getListResponse.then()
        .statusCode(200)
        .header("Content-Type", containsString("application/json"));  // or json if applicable

    System.out.println("Response validated");
    }

    @Then("Log the listofbooks results")
    public void log_the_listofbooks_results() {
        System.out.println("Results logged");
    }
}
