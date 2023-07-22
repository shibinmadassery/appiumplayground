import java.net.MalformedURLException;
import AppiumiOS.utilisE;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class iosclicktest extends iosbase {
	@Test
	public void click() throws MalformedURLException {
		clickMenuBar();
	}

	private static void clickMenuBar() {
		driver.findElement(AppiumBy.accessibilityId(utilisE.menuesidebar)).click();
	}

}