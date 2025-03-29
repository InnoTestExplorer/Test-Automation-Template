package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");

    @Override
    @Step("Esperando que la pagina cargue")
    public void waitPageToLoad() {

        Logs.info("Esperando que la pagina cargue");

        waitPage(this.usernameInput, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verificando que cargo la pagina")
    public void verifyPage() {

        Logs.info("Verificando que cargo la pagina");
        softAssert.assertTrue(find(usernameInput).isDisplayed());
        softAssert.assertTrue(find(passwordInput).isDisplayed());
        softAssert.assertTrue(find(loginButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Logueandose en la pagina")
    public void fillLogin(String username, String password) {

        Logs.info("Escribiendo el usuario");
        find(usernameInput).sendKeys(username);

        Logs.info("Escribiendo la contrasena");
        find(passwordInput).sendKeys(password);

        Logs.info("Haciendo click en login");
        find(loginButton).click();
    }
}
