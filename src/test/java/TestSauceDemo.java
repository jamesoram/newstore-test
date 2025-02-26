import org.example.CartPage;
import org.example.LoginPage;
import org.example.ProductsListPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import uk.co.leoaureum.testdriver.core.BaseTestdriverTest;
import uk.co.leoaureum.testdriver.pages.AbstractPage;
import uk.co.leoaureum.testdriver.utils.TestdriverConfigLoader;
import uk.co.leoaureum.testdriver.utils.TestdriverWait;

public class TestSauceDemo extends BaseTestdriverTest {

    @Test
    public void testStandardUserOneItemCheckout() {
        TestdriverConfigLoader loader = new TestdriverConfigLoader("ecom.conf");
        String url = loader.get("url");
        String username = loader.get("username");
        String password = loader.get("password");
        driver().get(url);

        String listPageItemPrice = new LoginPage(driver()).login(username, password).getCartItemPriceByIndex(0);

        String cartItemPrice = new ProductsListPage(driver()).addBackpackToCart().clickShoppingCartLink()
                .getCartItemPriceByIndex(0);

        assertEquals(listPageItemPrice, cartItemPrice);

        boolean successful = new ProductsListPage(driver())
                .clickShoppingCartLink()
                .clickCheckout()
                .submitInformation("james", "test", "19293")
                .clickFinish()
                .isCheckoutComplete();

        Assert.assertEquals(successful, true, "Could not complete checkout");
    }
}
