package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.co.leoaureum.testdriver.pages.AbstractPage;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutInformationPage clickCheckout() {
        checkoutButton.click();
        return new CheckoutInformationPage(driver);
    }


    public String getCartItemPriceByIndex(int index) {
        List<WebElement> cartItemPrices = driver.findElements(By.xpath("//*[@data-test='inventory-item-price']"));
        try {
            return cartItemPrices.get(index).getText();
        } catch (Exception e) {
            throw new RuntimeException("Could not find item at index " + index +" " + e.getMessage());
        }
    }
}
