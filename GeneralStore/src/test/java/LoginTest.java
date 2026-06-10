import org.formPage;
import org.testng.annotations.Test;

public class LoginTest extends baseTest{
    @Test
    public void tc1() throws InterruptedException {

        formPage FormPage= new formPage(driver);
        Thread.sleep(2000);

        FormPage.setNameField("Amr Khaled");
        FormPage.setMaleOption();
        //FormPage.selectCountry("Egypt");
        FormPage.clickButton();

        /*
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Amr Khaled");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        Actions.scrollToElementByText("Egypt",driver);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Egypt\"]")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        //String toastMsg= driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        //Assert.assertEquals(toastMsg,"Please enter your name");
*/
    }

@Test
    public void tc2() throws InterruptedException {

        formPage FormPage= new formPage(driver);
        FormPage.setNameField("A000");

        Thread.sleep(2000);
        FormPage.setMaleOption();
     //   FormPage.selectCountry("Egypt");
        FormPage.clickButton();
    }


}
