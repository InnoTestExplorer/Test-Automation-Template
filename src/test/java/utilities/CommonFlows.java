package utilities;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class CommonFlows {

    private WebDriver getDriver() {

        return new WebDriverProvider().get();
    }

    public void goToLoginPage() {

        Logs.info("Navegamos a la pagina");
        getDriver().get("https://www.saucedemo.com/");

        new LoginPage().verifyPage();
    }
}
