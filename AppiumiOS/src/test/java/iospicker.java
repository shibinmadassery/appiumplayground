import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;

@SuppressWarnings("deprecation")
public class iospicker extends iosuikitapp {
	@Test
	public void iosPickers() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
		driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("120");
		driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("220");
		driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("20");
		Thread.sleep(1000);
		driver.findElement(AppiumBy.className("XCUIElementTypeButton")).click();
		Thread.sleep(1000);

		driver.findElement(AppiumBy.accessibilityId("Date Picker")).click();
		// Find and interact with the date picker
		driver.findElement(AppiumBy.className("XCUIElementTypeDatePicker")).click();
		driver.findElement(AppiumBy.accessibilityId("Sunday, July 23")).click();
		Thread.sleep(1000);
		clickOut();
		selectTime();
		setTime();
	}

	public static void selectTime() throws InterruptedException {
		// Find the date picker element
		By datePickerLocator = MobileBy.className("XCUIElementTypeDatePicker");
		WebElement datePicker = driver.findElement(datePickerLocator);

		// Find all the buttons under the date picker
		List<WebElement> buttons = datePicker.findElements(By.className("XCUIElementTypeButton"));

		// Check if there are at least two buttons (index starts at 0)
		if (buttons.size() >= 2) {
			// Click the second button (index 1)
			buttons.get(2).click();
		} else {
			System.out.println("The date picker does not have at least two buttons.");
		}

	}

	public static void clickOut() throws InterruptedException {
		driver.findElement(AppiumBy.className("XCUIElementTypeApplication")).click();
	}

	public static void setTime() throws InterruptedException {
		// Find the picker element
		By pickerLocator = MobileBy.className("XCUIElementTypePicker");
		WebElement picker = driver.findElement(pickerLocator);

		// Find all the picker wheels inside the picker element
		// Assuming that the first wheel is for the hour and the second one is for the
		// minute
		List<WebElement> pickerWheels = picker.findElements(By.className("XCUIElementTypePickerWheel"));

		// Set the desired time components (hour and minute)
		String desiredHour = "12"; // Replace with the desired hour (two-digit format)
		String desiredMinute = "12"; // Replace with the desired minute (two-digit format)
		String desiredAM = "AM";

		// Set the hour component
		pickerWheels.get(0).sendKeys(desiredHour);

		// Set the minute component
		pickerWheels.get(1).sendKeys(desiredMinute);

		// Set the AM component
		pickerWheels.get(2).sendKeys(desiredAM);
		driver.findElement(AppiumBy.accessibilityId("PopoverDismissRegion")).click();
		Thread.sleep(2000);

	}

}