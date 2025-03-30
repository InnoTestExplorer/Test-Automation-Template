package automation;

import data.CustomDataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.BaseTest;

public class LoginTests extends BaseTest {

    private final LoginPage loginPage = new LoginPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        commonFlows.goToLoginPage();
    }

    @Test
    public void testValidLogin() {

        loginPage.fillLogin("standard_user", "secret_sauce");
    }

    @Test(
            groups = {regression},
            dataProviderClass = CustomDataProviders.class,
            dataProvider = CustomDataProviders.DP_CREDENTIALS)
    public void testLoginALLUsers(String username, String password) {
        
        loginPage.fillLogin(username, password);
    }
}
