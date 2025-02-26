import org.testng.annotations.Test;
import uk.co.leoaureum.testdriver.core.BaseTestdriverTest;
import uk.co.leoaureum.testdriver.utils.TestdriverConfigLoader;
import uk.co.leoaureum.testdriver.utils.TestdriverWait;

public class TestSomething extends BaseTestdriverTest {

    @Test
    public void testSomething() {
        TestdriverWait wait = new TestdriverWait(driver(),  1000);
        String url = new TestdriverConfigLoader("ecom.conf").get("url");

        driver().get(url);
        System.out.println(url);
    }
}
