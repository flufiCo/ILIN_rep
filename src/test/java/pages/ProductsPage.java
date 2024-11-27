package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By TITLE = By.cssSelector("[class='title']");
    private final String ADD_TO_CART_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }
    public void addToCart(String product) {
    By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
    driver.findElement(addToCart).click();
    }
}

123op[]