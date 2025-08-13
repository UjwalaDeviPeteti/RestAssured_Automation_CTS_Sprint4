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

public class TokenRequest {

	
	RestassuredUtilities util =new RestassuredUtilities();
    
	@Test(priority=2)
	@Description("Getting the Token.....")
	@Epic("EP001")
	@Feature("Scenario 2:Token Generation")
	@Story("Story2:Valid Token")
	@Step("Verify Token")
	@Severity(SeverityLevel.CRITICAL)
	public void post1() throws FileNotFoundException {
		util.getAccessToken();
		
	}
}
