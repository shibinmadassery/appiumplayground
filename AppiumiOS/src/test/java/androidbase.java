import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class androidbase {

	public static AppiumDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("platformVersion", "12.0");
		caps.setCapability("AVD", "Pixel 5 API 31");
		caps.setCapability("app", "/Applications/appdemo.apk");
		// caps.setCapability("deviceName", "Android Emulator");
		// caps.setCapability("app", System.getProperty("/Applications/appdemo.apk"));
		driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
	}

	@Test
	public void productHeadingisDisplayed() throws InterruptedException {
		// code
		// driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"store
		// item text\"])[1])")).isDisplayed();
		// driver.findElement(AppiumBy.accessibilityId("App")).click();
 	}

	@AfterTest
	public void tearDown() {
		if (null != driver) {
			driver.quit();
			System.out.println("Completed");

		}
	}
}