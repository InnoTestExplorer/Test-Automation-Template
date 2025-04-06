package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class SignupPage extends BasePage {

    private final By firstnameInput = By.id("input-firstname");
    private final By lastnameInput = By.id("input-lastname");
    private final By emailInput = By.id("input-email");
    private final By telephoneInput = By.id("input-telephone");
    private final By passwordInput = By.id("input-password");
    private final By confirmPasswordInput = By.id("input-confirm");
    private final By noSuscribeRadio = By.xpath("//label[@class='radio-inline']/input[@name='newsletter' and @value='0']");
    private final By agreePolicyButton = By.name("agree");
    private final By continueButton = By.className("btn-primary");
    private final By title = By.xpath("//h1[text()='Register Account']");

    @Step("Registrando un usuario")
    public void userRegister(String firstname,
                             String lastname,
                             String email,
                             String telephone,
                             String password) {

        Logs.info("Escribiendo el nombre");
        find(firstnameInput).sendKeys(firstname);

        Logs.info("Escribiendo el apellido");
        find(lastnameInput).sendKeys(lastname);

        Logs.info("Escribiendo el email");
        find(emailInput).sendKeys(email);

        Logs.info("Escribiendo el telefono");
        find(telephoneInput).sendKeys(telephone);

        Logs.info("Escribiendo la contraseña");
        find(passwordInput).sendKeys(password);

        Logs.info("Confirmando contraseña");
        find(confirmPasswordInput).sendKeys(password);

        Logs.info("Haciendo click en no suscribirse al newsletter");
        find(noSuscribeRadio).click();

        Logs.info("Aceptando politica de privacidad");
        find(agreePolicyButton).click();

        Logs.info("Click eb continue");
        find(continueButton).click();
    }

    @Override
    @Step("Esperando que cargue la pagina de registro")
    public void waitPageToLoad() {

        Logs.info("Esperando que cargue la pagina de registro");
        waitPage(this.title, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verificando que cargo la pagina de registro")
    public void verifyPage() {

        Logs.info("Esperando que cargue la pagina de registro");
        softAssert.assertTrue(find(title).isDisplayed());
        softAssert.assertTrue(find(firstnameInput).isDisplayed());
        softAssert.assertTrue(find(lastnameInput).isDisplayed());
        softAssert.assertTrue(find(emailInput).isDisplayed());
        softAssert.assertTrue(find(telephoneInput).isDisplayed());
        softAssert.assertTrue(find(passwordInput).isDisplayed());
        softAssert.assertTrue(find(confirmPasswordInput).isDisplayed());
        softAssert.assertTrue(find(noSuscribeRadio).isDisplayed());
        softAssert.assertTrue(find(agreePolicyButton).isDisplayed());
        softAssert.assertTrue(find(continueButton).isDisplayed());
        softAssert.assertAll();
    }
}
