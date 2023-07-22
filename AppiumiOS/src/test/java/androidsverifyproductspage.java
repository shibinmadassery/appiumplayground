import java.net.MalformedURLException;
import org.testng.annotations.Test;

import AppiumAndroid.utlisE;
import io.appium.java_client.AppiumBy;

public class androidsverifyproductspage extends androidbase {
	@Test
	public void verifyAllElementsProductCatlog() throws MalformedURLException, InterruptedException {
		//setUp();
		verifyHamburgerMenue(); verifyShoppingCartIcon();
		verifyBackPackImage(); verifyBackPackText();
		verifyBackPackRate();

	}

	private static void verifyHamburgerMenue() {
		driver.findElement(AppiumBy.xpath(utlisE.hamburgermenue)).isDisplayed();
	}
	
	private static void verifyShoppingCartIcon() {
		driver.findElement(AppiumBy.xpath(utlisE.shoppingcarticon)).isDisplayed();
	}
	
	private static void verifyBackPackImage () {
		driver.findElement(AppiumBy.xpath(utlisE.sauselabsbackpackimage)).isDisplayed();
	}
	
	private static void verifyBackPackText () {
		driver.findElement(AppiumBy.xpath(utlisE.sauselabsbackpacktext));
	}
	
	private static void verifyBackPackRate () {
		driver.findElement(AppiumBy.accessibilityId(utlisE.sauselabsbackpackrate));
	}
}
