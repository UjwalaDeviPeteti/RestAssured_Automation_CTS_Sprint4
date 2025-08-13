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

public class AuthRequest {

	RestassuredUtilities util =new RestassuredUtilities();
	
	@Test(priority=1)
	@Description("Getting the Auth Code.....")
	@Epic("EP001")
	@Feature("Scenario 1:AuthCode Generation")
	@Story("Story1:Valid AuthCode")
	@Step("Verify AuthCode")
	@Severity(SeverityLevel.CRITICAL)
	public void post() throws FileNotFoundException {
		util.getAuthCode();
	}
	
}