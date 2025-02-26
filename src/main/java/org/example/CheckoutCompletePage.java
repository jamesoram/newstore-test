package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.co.leoaureum.testdriver.pages.AbstractPage;
import uk.co.leoaureum.testdriver.utils.TestdriverWait;

public class CheckoutCompletePage extends AbstractPage {

    @FindBy(xpath = "//*[@data-test=\"checkout-complete-container\"]")
    private WebElement checkoutCompleteContainer;

    private TestdriverWait wait = new TestdriverWait(driver, 30);

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckoutComplete() {
        wait.forElementVisible(checkoutCompleteContainer);
        return checkoutCompleteContainer.isDisplayed();
    }
}
