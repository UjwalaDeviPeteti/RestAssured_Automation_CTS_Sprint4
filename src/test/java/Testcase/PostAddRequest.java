package Testcase;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import utilities.RestassuredUtilities;

public class PostAddRequest {

	RestassuredUtilities util =new RestassuredUtilities();

	@Test(priority=3)
	@Description("Adding Booking Details.....")
	@Epic("EP001")
	@Feature("Scenario 3:Add Booking")
	@Story("Story3:Valid Booking")
	@Step("Verify Booking")
	@Severity(SeverityLevel.NORMAL)
	public void add() throws Exception {
		util.createBookingsFromJsonFile("src/test/resources/testData/Bookings.json");
		
	}
}
