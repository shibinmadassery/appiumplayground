//package AppiumAndroid;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.PerformsTouchActions;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.touch.WaitOptions;
//import io.appium.java_client.touch.offset.PointOption;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//@SuppressWarnings("deprecation")
//public class allmobiletouchactions {
//    private AppiumDriver driver;
//    @SuppressWarnings("rawtypes")
//	private static TouchAction touchAction;
//
//    @SuppressWarnings("rawtypes")
//	public allmobiletouchactions() {
//        initDriver();
//        touchAction = new TouchAction((PerformsTouchActions) driver);
//    }
//
//    private void initDriver() {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("deviceName", "Your_Device_Name");
//        // Set other desired capabilities for your device
//
//        try {
//            // Replace the URL with your Appium server URL
//            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void tap(int x, int y) {
//        touchAction.tap(PointOption.point(x, y)).perform();
//    }
//
//    public void longPress(int x, int y) {
//        touchAction.longPress(PointOption.point(x, y)).perform();
//    }
//
//    public static void swipe(int startX, int startY, int endX, int endY, int i) {
//        touchAction.press(PointOption.point(startX, startY)).waitAction().moveTo(PointOption.point(endX, endY)).release().perform();
//    }
//
//    public void scroll(int startX, int startY, int endX, int endY, WaitOptions duration) {
//        touchAction.press(PointOption.point(startX, startY)).waitAction(duration).moveTo(PointOption.point(endX, endY)).release().perform();
//    }
//
//    public void dragAndDrop(int startX, int startY, int endX, int endY) {
//        touchAction.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
//    }
//
//    public void quit() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
////    public static void main(String[] args) {
////        allmobiletouchactions appiumTouchActions = new allmobiletouchactions();
////        // Example usage:
////        appiumTouchActions.tap(100, 200);
////        appiumTouchActions.swipe(200, 300, 400, 500, 1000);
////        appiumTouchActions.dragAndDrop(300, 400, 500, 600);
////        appiumTouchActions.quit();
////    }
//}
