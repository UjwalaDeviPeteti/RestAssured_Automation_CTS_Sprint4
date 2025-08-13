package baseclass;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Basetest {
	
	static RequestSpecification reqSpec;
    static ResponseSpecification resSpec;

    public static RequestSpecification setup() throws FileNotFoundException {
        if (reqSpec == null) {
            PrintStream log = new PrintStream("src/test/resources/logger/restassured_log.txt");

            String baseURI = Configmanager.getProperty("baseURI"); 

            reqSpec = new RequestSpecBuilder()
                    .setBaseUri(baseURI)
                    .setContentType(ContentType.JSON)
                    // ✅ File logging
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    
                    // ✅ Console logs
                    .addFilter(new RequestLoggingFilter())
                    .addFilter(new ResponseLoggingFilter())
                    // ✅ Allure logs
                    .addFilter(new AllureRestAssured())
                    .build();
        }
        return reqSpec;
    }

    public static ResponseSpecification responseSpec() {
        if (resSpec == null) {
            resSpec = new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .expectContentType(ContentType.JSON)
                    .build();
        }
        return resSpec;
    }
}
