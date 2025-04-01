package automation;

import data.CustomDataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShoppingPage;
import utilities.BaseTest;

public class LoginTests extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        commonFlows.goToLoginPage();
    }

    @Test(groups = {regression})
    public void testValidLogin() {

        loginPage.fillLogin("standard_user", "secret_sauce");
        shoppingPage.verifyPage();
    }

    @Test(
            groups = {regression},
            dataProviderClass = CustomDataProviders.class,
            dataProvider = CustomDataProviders.DP_CREDENTIALS)
    public void testLoginAllUsers(String username, String password) {

        loginPage.fillLogin(username, password);
    }
}
