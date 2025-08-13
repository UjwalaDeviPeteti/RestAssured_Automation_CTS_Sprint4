package Testcase;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import utilities.RestassuredUtilities;

public class GetIdRequest {

	RestassuredUtilities util =new RestassuredUtilities();

	@Test(priority=5)
	@Description("Getting the Id of a book....")
	@Epic("EP001")
	@Feature("Scenario 5:Getting BookId")
	@Story("Story5:Valid BookId")
	@Step("Verify BookId")
	@Severity(SeverityLevel.NORMAL)
	public void getId() throws FileNotFoundException {
		util.viewBookingById();
		
	}
}
