package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.co.leoaureum.testdriver.pages.AbstractPage;
import uk.co.leoaureum.testdriver.utils.TestdriverWait;

import java.util.List;

public class ProductsListPage extends AbstractPage {

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addSauceBackpackToCartButton;

    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    private WebElement shoppingCartLink;

    private TestdriverWait wait = new TestdriverWait(driver, 30);

    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    public ProductsListPage addBackpackToCart() {
        wait.forElementVisible(addSauceBackpackToCartButton);
        addSauceBackpackToCartButton.click();
        return this;
    }

    public CartPage clickShoppingCartLink() {
        shoppingCartLink.click();
        return new CartPage(driver);
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
