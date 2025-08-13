//package utilities;
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.*;
//
//import java.io.FileNotFoundException;
//
//import baseclass.Basetest;
//
//public class ValidationUtilities {
//
//    public void statuscodeValidation() throws FileNotFoundException {
//        given()
//            .spec(Basetest.setup())  // your setup spec with base URL etc.
//        .when()
//            .get(Resource.getListResource.getResource())  // your endpoint
//        .then()
//            .statusCode(200)
//            .spec(Basetest.responseSpec());  // your response spec if any
//    }
//
//    public void headerValidation() throws FileNotFoundException {
//        given()
//            .spec(Basetest.setup())
//        .when()
//            .get(Resource.getListResource.getResource())
//        .then()
//            .statusCode(200)
//            // Validate XML content-type for your response
//            .header("Content-Type", containsString("application/json"));
//    }
//
//    public void responseBodyValidation() throws FileNotFoundException {
//        given()
//            .spec(Basetest.setup())
//        .when()
//            .get(Resource.getListResource.getResource())
//        .then()
//            .statusCode(200)
//            // Check specific XML elements using XML path (XPath-like)
//            .body("bookings.booking[0].arrivalCity", equalTo("Coimbatore"))
//            .body("bookings.booking[1].trainClass", equalTo("THIRDAC"))
//            .body("bookings.booking[0].passengerName", equalTo("Rakesh"));
//    }
//}


package utilities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileNotFoundException;

import baseclass.Basetest;


public class ValidationUtilities {
	

	    public void statuscodeValidation() throws FileNotFoundException {
	        given()
	            .spec(Basetest.setup())
	        .when()
	        .post(Resource.AuthpostResource.getResource())
	             .then()
	        .statusCode(200)
	            .spec(Basetest.responseSpec());
	        System.out.println("statuscode");
	    }

	    public void headerValidation() throws FileNotFoundException {
	        given()
	            .spec(Basetest.setup()) 
	        .when()
	            .post(Resource.AuthpostResource.getResource())
	        .then()
	            .statusCode(200)
	            .header("content-type", equalTo("application/json; charset=UTF-8"));
	        System.out.println("header");
	    }

	    public void ResponseBodyValidation() throws FileNotFoundException {
	        given()
	            .spec(Basetest.setup()) 
	        .when()
	            .get(Resource.AuthpostResource.getResource())
	        .then()
	            .statusCode(200)
	            .header("Content-Type", equalTo("application/json; charset=utf-8"))
	            .body("title", equalTo("Testing"))
	            .body("body", equalTo("Rest assured"));
	    }
	}



