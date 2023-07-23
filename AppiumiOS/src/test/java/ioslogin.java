import org.testng.annotations.Test;

import AppiumiOS.loginPage;
import io.appium.java_client.AppiumBy;

public class ioslogin extends iosbase {
	@Test
	public void loginTobob() throws InterruptedException {

		String username = loginPage.usernamebob;
		String password = loginPage.passwordbob;

		navigateToLoginPage();
		enterCredentials(username, password);
		clickLoginButton();
		verifyCatlogPage();
	}

	public static void navigateToLoginPage() {
		driver.findElement(AppiumBy.accessibilityId(loginPage.menu)).click();
		driver.findElement(AppiumBy.accessibilityId(loginPage.menuitemlogin)).click();
	}

	public static void enterCredentials(String username, String password) {

		driver.findElement(AppiumBy.accessibilityId(loginPage.usernameinputtextbox)).sendKeys(username);
		driver.findElement(AppiumBy.accessibilityId(loginPage.passwordinputtextbox)).sendKeys(password);
	}

	public static void clickLoginButton() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId(loginPage.loginbutton)).click();
		Thread.sleep(2000);
	}

	public static void verifyCatlogPage() {
		driver.findElement(AppiumBy.accessibilityId(loginPage.firstproduct)).isDisplayed();
		System.out.print("bob logged");
	}
}