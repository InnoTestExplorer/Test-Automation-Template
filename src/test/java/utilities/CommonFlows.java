package utilities;

import org.openqa.selenium.WebDriver;

public class CommonFlows {

    private WebDriver getDriver() {

        return new WebDriverProvider().get();
    }

    public void goToSignupPage() {

        Logs.info("Navegamos a la pagina de Signup");

        getDriver().get("https://tutorialsninja.com/demo/index.php?route=account/register");
    }

    public void goToLoginPage() {

        Logs.info("Navegamos a la pagina de login");

        getDriver().get("https://www.saucedemo.com/");
    }
}
