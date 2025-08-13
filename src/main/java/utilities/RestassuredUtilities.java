package utilities;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import baseclass.Basetest;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.BookingData;

public class RestassuredUtilities {
	  
	

    public static String authCode; // Shared variable
    public static String accessToken;
    PrintStream log;

   
    public Response getAuthCode() throws FileNotFoundException {
//        RestAssured.baseURI = "https://webapps.tekstac.com"; // Replace with your base URL
    	log = new PrintStream(new File("src/test/resources/logger/authcodelog.txt"));

        Response response = given(Basetest.setup())
        		.filter(RequestLoggingFilter.logRequestTo(log))
                .filter(ResponseLoggingFilter.logResponseTo(log))
                .log().all()
        	 .contentType("application/x-www-form-urlencoded")
        	 .accept("application/json")
              .formParam("username", "user1")
              .formParam("password", "pass123")
              .when()
              .post(Resource.AuthpostResource.getResource())
              .then()
              .contentType(ContentType.JSON)
              .statusCode(200)
              .log().all()
              .extract()
              
              .response();// extract the Response object

        
        System.out.println("Status Code (Auth Code): " + response.getStatusCode());
        System.out.println("*************************");
        
     // ✅ Status Code Check
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 but found " + response.getStatusCode());

        authCode = response.jsonPath().getString("auth_code");
        System.out.println("Auth Code: " + authCode);
        
        return response;
        
     
    }
   
    public Response getAccessToken() throws FileNotFoundException {
//        RestAssured.baseURI = "https://webapps.tekstac.com"; // Replace with your base URL
        log = new PrintStream(new File("src/test/resources/logger/Tokenlog.txt"));

        Response response = RestAssured
                .given(Basetest.setup())
                .filter(RequestLoggingFilter.logRequestTo(log))
                .filter(ResponseLoggingFilter.logResponseTo(log))
                .contentType(ContentType.URLENC)
                .accept("application/json")
                .formParam("auth_code", authCode) // Using the code from previous class
                .when()
                .post(Resource.TokenpostResource.getResource())
                .then()
                .contentType(ContentType.JSON)
                  .statusCode(200)
                  .extract()
                  .response();// extract the Response object
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Token Response Body: " + response.asString());
        
     // ✅ Status Code Check
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 but found " + response.getStatusCode());
        
        accessToken = response.jsonPath().getString("access_token");
        System.out.println("Access Token: " + accessToken);
        return response;
    }
    

    public Response createBooking(BookingData booking) throws FileNotFoundException {
    	 log = new PrintStream(new File("src/test/resources/logger/addbookinglog.txt"));
    	Response response = given(Basetest.setup())
    			  .filter(RequestLoggingFilter.logRequestTo(log))
                  .filter(ResponseLoggingFilter.logResponseTo(log))
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.URLENC)
                .accept("application/json")
//                .formParam("bookingId", "15")
//                .formParam("bookingDate", "01/01/2022")
//                .formParam("departCity", "Coimbatore")
//                .formParam("arrivalCity", "Chennai")
//                .formParam("passengerCount", "3")
//                .formParam("trainName", "Chennai Express")
//                .formParam("passengerName", "Sam")
//                .formParam("trainClass", "THIRDAC")
//                .formParam("ticketType", "GENERAL")
                .formParam("bookingId", booking.getBookingId())
                .formParam("bookingDate", booking.getBookingDate())
                .formParam("departCity", booking.getDepartCity())
                .formParam("arrivalCity", booking.getArrivalCity())
                .formParam("passengerCount", booking.getPassengerCount())
                .formParam("trainName", booking.getTrainName())
                .formParam("passengerName", booking.getPassengerName())
                .formParam("trainClass", booking.getTrainClass())
                .formParam("ticketType", booking.getTicketType())
                .when()
                .post(Resource.AddbookingpostResource.getResource())
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();// extract the Response object

       System.out.println("Status Code (Add Booking): " + response.getStatusCode());
       System.out.println("Add Booking Response Body: " + response.asString());
       return response;
       
      

    }
    
//    public void createBookingsFromJsonFile(String filepath) throws Exception {
//        List<BookingData> bookings = BookingDataReader.getBookingsFromFile(filepath);
//
//        for (BookingData booking : bookings) {
//            createBooking(booking);
//        }
//    }

    public List<Response> createBookingsFromJsonFile(String filepath) throws Exception {
        List<BookingData> bookings = BookingDataReader.getBookingsFromFile(filepath);
        List<Response> responses = new ArrayList<>();

        for (BookingData booking : bookings) {
            Response res = createBooking(booking);
            responses.add(res);
        }
        return responses;
    }
   
    public Response getBookings() throws FileNotFoundException { 
    	
    	log = new PrintStream(new File("src/test/resources/logger/getbookinglog.txt"));
    	Response response=given(Basetest.setup())
    			.filter(RequestLoggingFilter.logRequestTo(log))
                .filter(ResponseLoggingFilter.logResponseTo(log))
                
                .header("Authorization", "Bearer " + accessToken)
                .accept("application/json")
                .when()
                .get(Resource.getListResource.getResource())
                .then()
                .log().all()
                .extract()
                .response();// extract the Response object

        System.out.println("Status Code (Get Bookings): " + response.getStatusCode());
        System.out.println("Get Bookings Response:\n" + response.asString());
        return response;
        
//        String xml = response.asString();
//        System.out.println("Get Bookings Response:\n" + xml);
//
//        XmlPath xmlPath = new XmlPath(xml);
//        int bookingCount = xmlPath.getList("bookings.booking").size();
//
//        System.out.println("Number of bookings: " + bookingCount);
//
//        // Example assertion: check booking count
//        Assert.assertEquals(bookingCount, 3, "Booking count should be 3 after adding a booking");
//
//        // Optional: Check that bookingId "15" exists
//        List<String> bookingIds = xmlPath.getList("bookings.booking.bookingId");
//        Assert.assertTrue(bookingIds.contains("15"), "Booking with ID 15 should be present");
//    }
}
    
    public Response viewBookingById() throws FileNotFoundException {
    	
    	log = new PrintStream(new File("src/test/resources/logger/getbyidlog.txt"));
        String bookingId = "1001";  // or 1003 as they said

        Response response = given(Basetest.setup())
        		.filter(RequestLoggingFilter.logRequestTo(log))
                .filter(ResponseLoggingFilter.logResponseTo(log))
            .accept("application/json")
            .header("Authorization", "Bearer " + accessToken)
            .pathParam("id", bookingId)
            .when()
            .get(Resource.getIdResource.getResource())
            .then()
            .statusCode(200)
            .extract()
            .response();
        System.out.println("Status Code (Get Bookings By Id): " + response.getStatusCode());
        System.out.println("View Booking by ID Response:\n" + response.asString());
        // Optional: Assert bookingId is in the response
        Assert.assertTrue(response.asString().contains(bookingId), "Response should contain bookingId " + bookingId);
        
        return response;
    }
    
    
   
    public Response viewBookingByClass() throws FileNotFoundException {

    	log = new PrintStream(new File("src/test/resources/logger/getbyclasslog.txt"));
        String trainClass = "SLEEPER";  // example train class

        Response response = given(Basetest.setup())
        		.filter(RequestLoggingFilter.logRequestTo(log))
                .filter(ResponseLoggingFilter.logResponseTo(log))
                
            .header("Authorization", "Bearer " + accessToken)
            .accept("application/json")
            .queryParam("trainClass", trainClass)     // use query param here
            .when()
            .get(Resource.getClassResource.getResource())
            .then()
            .statusCode(200)
            .extract()
            .response();
        System.out.println("Status Code (Get Bookings By Class): " + response.getStatusCode());
        System.out.println("View Booking by Class Response:\n" + response.asString());

        // Optional: Assert that response contains bookings with the trainClass
        Assert.assertTrue(response.asString().contains(trainClass), "Response should contain trainClass " + trainClass);
        return response;
    }

    
    public Response deleteBookingById() throws FileNotFoundException {
    	log = new PrintStream(new File("src/test/resources/logger/deletelog.txt"));
        String bookingId = "1001";  // or 1003 as they said

        Response response = given(Basetest.setup())
        		.filter(RequestLoggingFilter.logRequestTo(log))
                .filter(ResponseLoggingFilter.logResponseTo(log))
               
            .header("Authorization", "Bearer " + accessToken)
            .accept("application/json")
            .pathParam("id", bookingId)
            .when()
            .delete(Resource.deleteResource.getResource())
            .then()
            .statusCode(200)  // or 204 if API returns no content
            .extract()
            .response();
        System.out.println("Status Code (Delete Bookings By Id): " + response.getStatusCode());
        System.out.println("Delete Booking by ID Response:\n" + response.asString());

     // Assertion: Status code must be 200 or 204
        Assert.assertTrue(
            response.getStatusCode() == 200 || response.getStatusCode() == 204,
            "Expected status code 200 or 204 but found " + response.getStatusCode()
        );
        
        return response;
        

//        // Optional: Verify deletion by trying to get the deleted booking (expect 404)
//        Response getResponse = given()
//            .header("Authorization", "Bearer " +  TokenTest.accessToken)
//            .pathParam("id", bookingId)
//            .when()
//            .get("/TrainAPI/BookingService/viewBookingById/{id}");
//
//        Assert.assertEquals(getResponse.getStatusCode(), 404, "Deleted booking should not be found");
    }
}
