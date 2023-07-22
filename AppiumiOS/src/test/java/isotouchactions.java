import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import AppiumiOS.utilisE;

@SuppressWarnings("deprecation")
public class isotouchactions extends iosbase {
	@SuppressWarnings({ "rawtypes" })
	public static TouchAction touchAction;

	@Test
	public void touchActions() throws MalformedURLException, InterruptedException {
		touchMenue();
		touchCloseButton();
		scrollToLastProduct();
		scrollToFirstProduct();
	}

	public static void touchMenue() throws InterruptedException {
		// Perform the touch action on an element
		WebElement element = driver.findElement(AppiumBy.accessibilityId(utilisE.menuesidebar));
		@SuppressWarnings("rawtypes")
		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
		touchAction.tap(ElementOption.element(element)).perform();
	}

	public static void touchCloseButton() throws InterruptedException {
		// Perform the touch action on an element
		WebElement element = driver.findElement(AppiumBy.accessibilityId(utilisE.closemenue));
		@SuppressWarnings("rawtypes")
		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
		touchAction.tap(ElementOption.element(element)).perform();
	}

	public static void scrollToLastProduct() throws InterruptedException {

		HashMap<String, Object> scrollObject = new HashMap<String, Object>();
		scrollObject.put("direction", "down");
		scrollObject.put("name", utilisE.lastproductredtshirt);
		driver.executeScript("mobile:scroll", scrollObject);
		Thread.sleep(1000);
	}

	public static void scrollToFirstProduct() throws InterruptedException {

		HashMap<String, Object> scrollObjectUp = new HashMap<String, Object>();
		scrollObjectUp.put("direction", "up");
		scrollObjectUp.put("accessibility id", "Sauce Labs Backpack");
		driver.executeScript("mobile:scroll", scrollObjectUp);
		Thread.sleep(1000);
	}

}
