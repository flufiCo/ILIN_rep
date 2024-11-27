import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void incorrectLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce1");
        assertTrue("Epic sadface: Username and password do not match any user in this service", productsPage.titleDisplayed());;
        assertEquals(productsPage.getTitle(), "Products");
    }


    @Test
    public void emptyPasswordInputCheck() {
        loginPage.open();
        loginPage.login("standard_user", " ");
        assertEquals(driver.findElement(By.xpath("//h3")).getText(),
                "Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void lockedOutUserInputCheck() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(driver.findElement(By.xpath("//h3")).getText(),
                "Epic sadface: Sorry, this user has been locked out.");
    }
    @Test
    public void problemUserInputCheck() {
        loginPage.open();
        loginPage.login("problem_user", "secret_sauce");
        assertEquals(driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']")).getText(),
                "Test.allTheThings() T-Shirt (Red)");
    }
}


