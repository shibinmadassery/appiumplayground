import org.testng.annotations.Test;
import AppiumAndroid.*;
import io.appium.java_client.AppiumBy;

public class androidboblogin extends androidbase {
	@Test
	public void loginTobob() throws InterruptedException {

		String username = utlisE.usernamebob;
		String password = utlisE.passwordbob;

		navigateToLoginPage();
		enterCredentials(username, password);
		clickLoginButton();		
		verifyCatlogPage();
	}

	public static void navigateToLoginPage() {
		driver.findElement(AppiumBy.xpath(utlisE.hamburgermenue)).click();
		driver.findElement(AppiumBy.accessibilityId(utlisE.login)).click();
	}

	public static void enterCredentials(String username, String password) {

		driver.findElement(AppiumBy.accessibilityId(utlisE.userinputfield)).sendKeys(username);
		driver.findElement(AppiumBy.accessibilityId(utlisE.passwordinputfield)).sendKeys(password);
	}
	
	public static void clickLoginButton () throws InterruptedException {
		driver.findElement(AppiumBy.xpath(utlisE.loginbutton)).click();
		Thread.sleep(2000);
	}
	
	public static void verifyCatlogPage () {
        driver.findElement(AppiumBy.xpath(utlisE.sauselabsbackpackimage)).isDisplayed();
        System.out.print("bob logged");

	}

}
