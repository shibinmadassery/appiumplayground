import io.appium.java_client.AppiumDriver;
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

		XCUITestOptions options = new XCUITestOptions().setDeviceName("iPhone 14 Pro").setPlatformVersion("16.4")
				.setApp("/Applications/MyRNDemoApp.app");
		driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), options);
	}

	@Test
	public void printBeforeTestBegins() {
		System.out.println("Starting Test");
	}

	@AfterTest
	public void printAfterTestEnds() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Test Finished");

	}
}