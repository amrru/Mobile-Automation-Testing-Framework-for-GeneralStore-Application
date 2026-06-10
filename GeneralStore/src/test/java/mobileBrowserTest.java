import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class mobileBrowserTest extends MobileBaseTest {
    @Test
    public void browserTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("AmrKhaled");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }
}
