package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import uk.co.leoaureum.testdriver.pages.AbstractPage;

public class LoginPage extends AbstractPage {

    @FindBy(id = "user-name")
    private WebElement usernameTextbox;

    @FindBy(id = "password")
    private WebElement passwordTextbox;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProductsListPage login(String user, String password) {
        usernameTextbox.sendKeys(user);
        passwordTextbox.sendKeys(password + Keys.ENTER);
        return new ProductsListPage(driver);
    }

}
