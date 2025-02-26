package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.co.leoaureum.testdriver.pages.AbstractPage;

public class CheckoutOverviewPage extends AbstractPage {

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage clickFinish() {
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }
}
