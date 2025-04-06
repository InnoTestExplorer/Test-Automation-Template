package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignupPage;
import utilities.BaseTest;

public class SignupTests extends BaseTest {

    private final SignupPage signupPage = new SignupPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        commonFlows.goToSignupPage();
    }

    @Test(groups = {execution})
    public void testUserRegister() {

        signupPage.userRegister(

                "John",
                "Smith",
                "johmsmith@automation.com",
                "5597267891",
                "njoc)/)hl9=)/&"
        );
    }
}
