import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@SuppressWarnings("deprecation")
public class iosdraganddrop {
	public static AppiumDriver driver;
	public static DesiredCapabilities cap;

	@BeforeTest
	public void setup() throws MalformedURLException {

		XCUITestOptions options = new XCUITestOptions().setDeviceName("iPhone 14 Pro").setPlatformVersion("16.4")
				.setApp("/Applications/wdioNativeDemoApp.app");
		driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), options);
	}

//	@Test
//	public void printBeforeTestBegins() {
//		System.out.println("Starting Test");
//	}
	
	@SuppressWarnings({ "rawtypes" })
	@Test
	public void dragAndDrop () throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Drag")).click();
		// Find the element to drag
        By sourceLocator = MobileBy.AccessibilityId("drag-c1"); // Replace with the accessibility ID or other locator of the source element

        // Find the element to drop on
        By destinationLocator = MobileBy.AccessibilityId("drop-c1");

        // Locate the elements
        WebElement sourceElement = driver.findElement(sourceLocator);
        WebElement destinationElement = driver.findElement(destinationLocator);

        // Perform the drag and drop action
        @SuppressWarnings({ })
		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(sourceElement))
                .withDuration(Duration.ofMillis(1000)))
                .moveTo(ElementOption.element(destinationElement))
                .release()
                .perform();        
        Thread.sleep(2000);

	}

	@AfterTest
	public void printAfterTestEnds() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Test Finished");

	}
}