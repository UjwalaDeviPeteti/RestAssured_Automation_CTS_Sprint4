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

public class GetListRequest {

	RestassuredUtilities util =new RestassuredUtilities();
	

	@Test(priority=4)
	@Description("Getting the List of Books.....")
	@Epic("EP001")
	@Feature("Scenario 4:List of Books")
	@Story("Story4:Valid BookingList")
	@Step("Verify List of books")
	@Severity(SeverityLevel.NORMAL)
	public void getList() throws FileNotFoundException {
		util.getBookings();
		
	}
}
