import org.testng.annotations.Test;
import uk.co.leoaureum.testdriver.core.BaseTestdriverTest;
import uk.co.leoaureum.testdriver.utils.TestdriverWait;

public class TestSomething extends BaseTestdriverTest {

    @Test
    public void testSomething() {
        TestdriverWait wait = new TestdriverWait(driver(),  1000);
        driver().get("https://github.com/jamesoram");
        wait.sleep(4300);
    }
}
