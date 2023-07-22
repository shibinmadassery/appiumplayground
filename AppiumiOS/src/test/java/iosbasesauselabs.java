import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class iosbasesauselabs {

	public static AppiumDriver driver;
	public static DesiredCapabilities cap;

	@BeforeTest
	public void setup() throws MalformedURLException {

		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName", "iOS");
        //caps.setCapability("app", "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/iOS.RealDevice.SauceLabs.Mobile.Sample.app.2.7.1.ipa");
        caps.setCapability("appium:app", "storage:filename=MyRNDemoApp.zip");
		caps.setCapability("deviceName","iPhone 13 Simulator");
		caps.setCapability("appium:deviceOrientation", "portrait");
		caps.setCapability("appium:platformVersion", "16.0");
		caps.setCapability("appium:automationName", "XCUITest");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("username", "oauth-shibin.m-ea101");
		sauceOptions.setCapability("accessKey", "1f1934df-d815-4ae8-a729-ef9e58f50b7e");
		sauceOptions.setCapability("build", "appium-build-VEPQ0");
		sauceOptions.setCapability("name", "appium-ios-sauselabs-tests");
		caps.setCapability("sauce:options", sauceOptions);
		
		URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
		driver = new IOSDriver(url, caps);
	}
	@Test
	public void printBeforeTestBegins() {
		System.out.println("Starting Test on sauselabs");
	}
	
	@AfterTest
	public void printAfterTestEnds() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Test Finished");

	}
}
