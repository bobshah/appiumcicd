import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;

public class AndroidFindElements {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        MobileElement myEle = (MobileElement) ((FindsByAndroidUIAutomator) driver)
                .findElementByAndroidUIAutomator("new UiSelector().text(\"Accessibility\")");
        System.out.println(myEle.getText());

        MobileElement myEle1 = (MobileElement) ((FindsByAndroidUIAutomator) driver)
                .findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")").get(2);
        System.out.println(myEle1.getText());

        MobileElement myEle2 = (MobileElement) ((FindsByAndroidUIAutomator) driver)
                .findElementByAndroidUIAutomator("new UiSelector().description(\"Accessibility\")");
        System.out.println(myEle2.getText());
        /*MobileElement myElement1 = (MobileElement) driver.findElementByAccessibilityId("Accessibility");
        System.out.println(myElement1.getText());

        MobileElement myElement2 = (MobileElement) driver.findElementsById("android:id/text1").get(1);
        System.out.println(myElement2.getText());

        MobileElement myElement3 = (MobileElement) driver.findElementsByClassName("android.widget.TextView").get(2);
        System.out.println(myElement3.getText());

        MobileElement myElement4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Accessibility\"]");
        System.out.println(myElement4.getText());

        MobileElement myElement5 = (MobileElement) driver.findElementByXPath("//*[@text=\"Accessibility\"]");
        System.out.println(myElement5.getText());*/


    }
}
