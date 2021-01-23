import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {



    public static AppiumDriver initializeDriver(String platformName) throws Exception{
        DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability("newCommandTimeout", "300");
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";

        switch (platformName) {
            case "Android":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");

                // caps.setCapability("avd", "Pixel_3");// open Emulator automaticly
                //caps.setCapability("avdLaunchTimeout", 180000);
                caps.setCapability("appPackage", "io.appium.android.apis");
                caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

                caps.setCapability(MobileCapabilityType.APP, appUrl);
                return new AndroidDriver(url, caps);

            case "iOS":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

                caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");

                caps.setCapability("avd", "Pixel_3");// open Emulator automaticly
                caps.setCapability("avdLaunchTimeout", 180000);
                caps.setCapability(MobileCapabilityType.APP, appUrl);
                return new IOSDriver(url, caps);
            default:
                throw new Exception("invalid platform");

        }
    }
}
