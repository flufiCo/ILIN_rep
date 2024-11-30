package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    static WebDriver driver;

    public ProductsPage(WebDriver driver) {
        super(driver);
        ProductsPage.driver = driver;
    }

    private final String ADD_TO_CART_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    private final By TITLE = By.cssSelector("[class='title']");
    private final By TITLE2 = By.xpath("//*[text()='Products']");

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void addToCart(String product) {
        By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCart).click();
    }
    public void addToCart(int index) {
        driver.findElements(By.xpath("//*[text()='Add to cart']")).get(index).click();
    }

    public boolean isDisp() {
        driver.findElement(TITLE2).isDisplayed();
        return true;
    }

    public void openCart() {
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
    }

    public static ArrayList<String> getProductsNames() {
        List<WebElement> allProductsNames = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsNames) {
            names.add(product.getText());
        }
    return names;
    }

    public void isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add to cart']")));
    }
}

