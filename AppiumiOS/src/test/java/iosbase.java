import io.appium.java_client.AppiumDriver;
import AppiumiOS.utilisE;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class iosbase {
	public static AppiumDriver driver;
	public static DesiredCapabilities cap;

	@BeforeTest
	public void setup() throws MalformedURLException {

		XCUITestOptions options = new XCUITestOptions()
				.setDeviceName(utilisE.devicename)
				.setPlatformVersion(utilisE.platformversion)
				.setApp(utilisE.app)
				.setMaxTypingFrequency(10);
		driver = new IOSDriver(new URL(utilisE.url), options);
	}

	@Test
	public void printBeforeTestBegins() {
		System.out.println(utilisE.teststartedtext);
	}

	@AfterTest
	public void printAfterTestEnds() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		System.out.println(utilisE.testcompletedtext);

	}
}