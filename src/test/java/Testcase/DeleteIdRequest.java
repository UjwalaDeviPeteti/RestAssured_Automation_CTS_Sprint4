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

public class DeleteIdRequest {

	RestassuredUtilities util =new RestassuredUtilities();
	
	@Test(priority=7)
	@Description("Deleting the Id of a book....")
	@Epic("EP001")
	@Feature("Scenario 7:Deleting BookId")
	@Story("Story7:Valid BookId")
	@Step("Verify BookId")
	@Severity(SeverityLevel.NORMAL)
	public void deleteId() throws FileNotFoundException {
		util.deleteBookingById();
		
	}
}
