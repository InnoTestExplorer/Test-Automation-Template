package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.BaseTest;

public class LoginTests extends BaseTest {

    private final LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp() {

        commonFlows.goToLoginPage();
        loginPage.waitPageToLoad();
    }

    @Test(groups = {execution})
    public void testUserLogin() {

        loginPage.fillLogin("standard_user", "secret_sauce");
    }
}
