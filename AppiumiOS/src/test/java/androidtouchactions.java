
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;

import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import AppiumAndroid.utlisE;;

@SuppressWarnings("deprecation")
public class androidtouchactions extends androidbase {
	public static AndroidTouchAction action;
	@SuppressWarnings({ "unused", "rawtypes" })
	private TouchAction touchAction;

	@Test
	public void touchActions() throws InterruptedException {
		// tap an element
		touchMenue();
		touchCatalog();
		scrollDown();
		touchMenue();
		touchDrawing();
		paint();
		Thread.sleep(2000);
		touchMenue();
		touchCatalog();
		dragNdropTest();
		swipeTest();
		Thread.sleep(10000);
	}

	public static void touchActionsaction() {
		action = new AndroidTouchAction((PerformsTouchActions) driver);
	}

	public static void touchMenue() throws InterruptedException {
		WebElement menue = driver.findElement(AppiumBy.xpath(utlisE.hamburgermenue));
		action = new AndroidTouchAction((PerformsTouchActions) driver);
		action.tap(ElementOption.element(menue)).perform();
		Thread.sleep(1000);
	}

	public static void touchCatalog() throws InterruptedException {
		WebElement catalog = driver.findElement(AppiumBy.accessibilityId(utlisE.catalog));
		action = new AndroidTouchAction((PerformsTouchActions) driver);
		action.tap(ElementOption.element(catalog)).perform();
		Thread.sleep(1000);
	}

	public static void touchDrawing() throws InterruptedException {
		WebElement drawing = driver.findElement(AppiumBy.accessibilityId(utlisE.drawing));
		action = new AndroidTouchAction((PerformsTouchActions) driver);
		action.tap(ElementOption.element(drawing)).perform();
		Thread.sleep(1000);
	}

	public static void scrollDown() throws InterruptedException {
		int startX = driver.manage().window().getSize().getWidth() / 2;
		int startY = driver.manage().window().getSize().getHeight() * 4 / 5;
		int endY = driver.manage().window().getSize().getHeight() / 5;
		action.press(PointOption.point(startX, startY)).waitAction().moveTo(PointOption.point(startX, endY)).release()
				.perform();
		Thread.sleep(1000);
	}

	public void paint() throws InterruptedException {

		WebElement element = driver.findElement(AppiumBy.xpath(
				"//android.view.ViewGroup[@content-desc=\"drawing screen\"]/android.view.ViewGroup[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.Image[3]")); // where
																																																											// your
																																																											// canvas
																																																											// element
																																																											// is
		Actions action = new Actions(driver);
		action.moveByOffset(200, 100).perform();
		action.click();
	}

	public void dragNdropTest() throws InterruptedException {
		WebElement drag = driver.findElement(AppiumBy.xpath(utlisE.sauselabsbackpackimage));
		WebElement drop = driver.findElement(AppiumBy.xpath(utlisE.sauselabsbackpackrate));
		action.longPress(ElementOption.element(drag)).waitAction().moveTo(ElementOption.element(drop)).release()
				.perform();
	}

	public void swipeTest() throws InterruptedException {
		WebElement element = driver.findElement(AppiumBy.xpath(utlisE.sauselabsbackpackimage));
		action.press(ElementOption.element(element)).waitAction().moveTo(PointOption.point(-20, 120)).release()
				.perform();
	}
}
