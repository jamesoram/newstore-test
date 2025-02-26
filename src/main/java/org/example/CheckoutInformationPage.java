package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.co.leoaureum.testdriver.pages.AbstractPage;

public class CheckoutInformationPage extends AbstractPage {

    @FindBy(id = "first-name")
    private WebElement firstNameTextbox;

    @FindBy(id = "last-name")
    private WebElement lastNameCheckbox;

    @FindBy(id = "postal-code")
    private WebElement postcodeTextbox;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutOverviewPage submitInformation(String firstName, String lastName, String postcode) {
        firstNameTextbox.sendKeys(firstName);
        lastNameCheckbox.sendKeys(lastName);
        postcodeTextbox.sendKeys(postcode);
        continueButton.click();
        return new CheckoutOverviewPage(driver);
    }

}
