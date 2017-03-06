package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by chandanjavaregowda on 07/12/16.
 */
public class Testing {
    public static WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "192.168.56.102");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("newCommandTimeout", "600");

        capabilities.setCapability("appPackage", "com.zoomcar");
        capabilities.setCapability("appActivity", "com.zoomcar.activity.MainActivity");

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void example() throws Exception {
        goBack();
        handleScreenTips();
        choosePickup();
        chooseCity();
        boolean b = driver.findElement(By.id("com.zoomcar:id/text_error_msg")).isDisplayed();
        Assert.assertEquals(b, false);
    }

    @Step("Go Back <-")
    private void goBack() {
        System.out.println("Go back...");
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.view.ViewGroup[1]/android.widget.ImageButton[1]")).click();
    }

    @Step("Handle Screen Tips")
    private void handleScreenTips() {
        System.out.println("Handle Screen Tips...");
        driver.findElement(By.id("com.zoomcar:id/button_coach")).click();
        driver.findElement(By.id("com.zoomcar:id/button_coach")).click();
    }

    @Step("Choose Pick-up")
    private void choosePickup() {
        System.out.println("Choose Pick-up...");
        driver.findElement(By.id("com.zoomcar:id/pickupImageView")).click();
        driver.findElement(By.id("com.zoomcar:id/layout_terminal_list")).click();
    }

    @Step("Choose City")
    private void chooseCity() {
        System.out.println("Choose City...");
        driver.findElement(By.id("com.zoomcar:id/text_city_name")).click();
        driver.findElement(By.id("com.zoomcar:id/button_continue")).click();
        driver.findElement(By.id("com.zoomcar:id/button_continue")).click();
    }
}
