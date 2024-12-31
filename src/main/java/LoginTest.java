import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) {
        AndroidDriver driver = null;

        try {
            // Initialize UiAutomator2Options for Android driver
            UiAutomator2Options options = new UiAutomator2Options();
            options.setCapability("platformName", "Android");
            options.setCapability("platformVersion", "11.0");
            options.setCapability("deviceName", "POCO M2 PRO"); // Replace with your device name
            options.setCapability("udid", "525f65af"); // Get UDID using `adb devices`
            options.setCapability("appPackage", "com.modularitylabs.mobile.a3things"); // Replace with your app's package name
            options.setCapability("appActivity", "com.modularitylabs.mobile.a3things.login.LoginActivity"); // Replace with your app's activity
            options.setCapability("automationName", "UiAutomator2");


            // Initialize Appium Driver with the options
            URI serverUri = new URI("http://127.0.0.1:4723");
            URL serverUrl = serverUri.toURL(); // Convert URI to URL
            driver = new AndroidDriver(serverUrl, options); // No generic type for AndroidDriver

            // Use Duration for waiting instead of Thread.sleep
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebElement more = driver.findElement(AppiumBy.id("com.modularitylabs.mobile.a3things:id/tv_more_logins"));
            more.click();

            WebElement signInWithEmail = driver.findElement(
                    AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign in with email\")")
            );
            signInWithEmail.click();

            // Automate Login
            WebElement emailField = driver.findElement(AppiumBy.id("com.modularitylabs.mobile.a3things:id/tv_email"));
            emailField.sendKeys("lineshnagtode29@gmail.com");

            WebElement passwordField = driver.findElement(AppiumBy.id("com.modularitylabs.mobile.a3things:id/et_password"));
            passwordField.sendKeys("password");

            WebElement loginButton = driver.findElement(AppiumBy.id("com.modularitylabs.mobile.a3things:id/btn_login"));
            loginButton.click();

            // Verify Login
            WebElement contentMain = driver.findElement(AppiumBy.id("com.modularitylabs.mobile.a3things:id/content_main"));
            boolean isLoggedIn = contentMain.isDisplayed();
            System.out.println("Login " + (isLoggedIn ? "successful!" : "failed!"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
