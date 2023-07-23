import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AppiumiOS.loginPage;
import AppiumiOS.utilisE;
import io.appium.java_client.AppiumBy;

public class ioslogininvalid extends iosbase {
	@Test
	public void invalidLogin() throws InterruptedException {

		String usernameinvalid = loginPage.invalidemail;
		String passwordinvalid = loginPage.invalidpassword;
		String expectedtext = "Provided credentials do not match any user in this service.";

		ioslogin.navigateToLoginPage();
		enterCredentials(usernameinvalid, passwordinvalid);
		ioslogin.clickLoginButton();
		assertElementTextCredentialError(expectedtext);

	}

	public static void enterCredentials(String usernameinvalid, String passwordinvalid) {

		driver.findElement(AppiumBy.accessibilityId(loginPage.usernameinputtextbox)).sendKeys(usernameinvalid);
		driver.findElement(AppiumBy.accessibilityId(loginPage.passwordinputtextbox)).sendKeys(passwordinvalid);
	}

	public static void assertElementTextCredentialError(String expectedText) throws InterruptedException {
		Thread.sleep(2000);
		WebElement element = driver
				.findElement(AppiumBy.accessibilityId("Provided credentials do not match any user in this service."));
		// Get the actual text from the element
		String actualText = element.getText();
		// Perform the assertion
		Assert.assertEquals(actualText, expectedText, "Text dosent matches the value");
		System.out.println(utilisE.verifiedtext);
	}
}
