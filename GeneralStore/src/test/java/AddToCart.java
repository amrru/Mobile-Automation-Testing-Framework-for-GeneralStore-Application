import org.productsCatalogue;
import org.cartPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.dataReaders.JsonReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class AddToCart extends baseTest{

    @Test(dataProvider = "loginData")
    public void AddtoCartTest(HashMap<String, String> testData) throws InterruptedException {
        Thread.sleep(2000);
        loginPage.setNameField(testData.get("name"));
        loginPage.selectCountry(testData.get("country"));
        productsCatalogue cataloguePage = loginPage.clickButton();

        //productsCatalogue cataloguePage = new productsCatalogue(driver);
        cataloguePage.addProductToCartByName("Air Jordan 4 Retro");
        cataloguePage.addProductToCartByName("Converse All Star");
        cartPage CartPage= cataloguePage.goToCartPage();
        Assert.assertEquals( CartPage.totalSelectedPrice(),CartPage.getTotalPrice(),"they're not equal");

        CartPage.clickOnCheckBox();





    /*
    @Test(dataProvider = "getData")
    public void AddtoCartTest(String name, String gender, String country) throws InterruptedException {
        Thread.sleep(2000);
        loginPage.setNameField(name);
        loginPage.selectCountry(country);
        productsCatalogue cataloguePage = loginPage.clickButton();

        //productsCatalogue cataloguePage = new productsCatalogue(driver);
        cataloguePage.addProductToCartByName("Air Jordan 4 Retro");
        cataloguePage.addProductToCartByName("Converse All Star");
        cartPage CartPage= cataloguePage.goToCartPage();
        Assert.assertEquals( CartPage.totalSelectedPrice(),CartPage.getTotalPrice(),"they're not equal");

        CartPage.clickOnCheckBox();
*/

  /*
        Thread.sleep(2000);
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Amr Khaled");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        Actions.scrollToElementByText("Egypt",driver);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Egypt\"]")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);
        Actions.scrollToElementByText("Air Jordan 4 Retro",driver);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']/following::android.widget.LinearLayout[2]/android.widget.TextView[@text='ADD TO CART']")).click();



        Actions.scrollToElementByText("Air Jordan 9 Retro",driver);

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Air Jordan 9 Retro']/following::android.widget.LinearLayout[2]/android.widget.TextView[@text='ADD TO CART']")).click();

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(2000);
        String lastPageProduct = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName")).getText();

        String totalPrice = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        String shoes1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\" and @text=\"$160.97\"]")).getText();
        String shoes2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\" and @text=\"$170.97\"]")).getText();
        double total = Double.parseDouble(totalPrice.replace("$", "").trim());
        double price1 = Double.parseDouble(shoes1.replace("$", "").trim());
        double price2 = Double.parseDouble(shoes2.replace("$", "").trim());

        Assert.assertEquals(total, price1 + price2, 0.01, "not equal");
*/
}

@DataProvider
public Object[][] getData(){
        return new Object[][]{{"Amr khaled","Male","Argentina"},{"Amr youssef","Male","Argentina"}};
}

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        List<HashMap<String, String>> dataList = new JsonReader()
                .getJsonData("//src//main//resources//test-data//data.json");

        Object[][] data = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i);
        }
        return data;
    }

}