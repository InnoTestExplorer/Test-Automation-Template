package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

    private final boolean runServer = System.getenv("JOB_NAME") != null;

    public void buildDriver() {

        if (runServer) {

            buildRemoteDriver();
        } else {

            buildLocalDriver();
        }
    }

    public void buildLocalDriver() {

        final var headlessMode = System.getProperty("headless") != null;

        var browserProperty = System.getProperty("browser");

        if (browserProperty == null) {

            Logs.info("Asignando default driver a Chrome");

            browserProperty = "CHROME";
        }

        final var browser = Browser.valueOf(browserProperty.toUpperCase());

        Logs.info("Inicializando driver: %s", browser);
        Logs.debug("Headless mode? %b", headlessMode);

        final var driver = switch (browser) {

            case CHROME -> {

                final var chromeOptions = new ChromeOptions();

                if (headlessMode) {

                    chromeOptions.addArguments("--headless=new");
                }

                yield new ChromeDriver(chromeOptions);
            }

            case EDGE -> {

                final var edgeOptions = new EdgeOptions();

                if (headlessMode) {

                    edgeOptions.addArguments("--headless=new");
                }

                yield new EdgeDriver(edgeOptions);
            }

            case FIREFOX -> {

                final var firefoxOptions = new FirefoxOptions();

                if (headlessMode) {

                    firefoxOptions.addArguments("--headless");
                }

                yield new FirefoxDriver(firefoxOptions);
            }

            case SAFARI -> new SafariDriver();
        };

        Logs.debug("Maximizando ventana");
        driver.manage().window().maximize();

        Logs.debug("Borrando cookies");
        driver.manage().deleteAllCookies();

        Logs.debug("Asignando driver al Webdriver Provier");
        new WebDriverProvider().set(driver);
    }

    public void killDriver() {

        Logs.debug("Matando al padre");
        new WebDriverProvider().get().quit();
    }

    public void buildRemoteDriver() {

    }

    private enum Browser {

        CHROME,
        EDGE,
        FIREFOX,
        SAFARI
    }
}
