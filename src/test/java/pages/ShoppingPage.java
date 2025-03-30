package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class ShoppingPage extends BasePage {

    private final By productsTitle = By.xpath("//span[text()='Products']");

    @Override
    @Step("Esperando que la pagina de shopping cargue")
    public void waitPageToLoad() {

        Logs.info("Esperando que la pagina de shopping cargue");
        waitPage(this.productsTitle, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verificando que cargo la pagina de shopping")
    public void verifyPage() {

        Logs.info("Verificando que cargo la pagina de shopping");
        softAssert.assertTrue(find(productsTitle).isDisplayed());
        softAssert.assertAll();
    }
}
