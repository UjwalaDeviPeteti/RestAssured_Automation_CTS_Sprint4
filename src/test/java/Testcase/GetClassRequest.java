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

public class GetClassRequest {

	RestassuredUtilities util =new RestassuredUtilities();
	
	@Test(priority=6)
	@Description("Getting the Book By ClassName....")
	@Epic("EP001")
	@Feature("Scenario 6:Getting BookingClass")
	@Story("Story6:Valid BookingClass")
	@Step("Verify BookingClass")
	@Severity(SeverityLevel.NORMAL)
	public void getclass() throws FileNotFoundException {
		util.viewBookingByClass();
		
	}
}
