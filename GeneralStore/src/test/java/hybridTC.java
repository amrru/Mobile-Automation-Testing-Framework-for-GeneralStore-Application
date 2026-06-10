import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

public class hybridTC extends baseTest {

    @Test
    public void HybridTc() throws InterruptedException {
      /*  Thread.sleep(2000);
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Amr Khaled");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        Actions.scrollToElementByText("Afghanistan", driver);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Afghanistan\"]")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);
        Actions.scrollToElementByText("Air Jordan 4 Retro", driver);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']/following::android.widget.LinearLayout[2]/android.widget.TextView[@text='ADD TO CART']")).click();


        Actions.scrollToElementByText("Air Jordan 9 Retro", driver);

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Air Jordan 9 Retro']/following::android.widget.LinearLayout[2]/android.widget.TextView[@text='ADD TO CART']")).click();

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(2000);


        driver.findElement(AppiumBy.xpath("//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(6000);

        Set<String> contexts = driver.getContextHandles();

        for (String context : contexts) {
            System.out.println(context);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");
        //  driverWeb.findElement(By.id(""));
        driver.findElement(By.name("q")).sendKeys("hello");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        driver.context("NATIVE_APP");

    */
    }
}