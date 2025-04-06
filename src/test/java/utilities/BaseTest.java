package utilities;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListeners.class, SuiteListeners.class})
public class BaseTest {

    protected final String reggression = "reggression";
    protected final DriverManager driverManager = new DriverManager();
    protected final CommonFlows commonFlows = new CommonFlows();

    @BeforeMethod(alwaysRun = true)
    public void masterSetUp() {

        driverManager.buildLocalDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        driverManager.killDriver();
    }
}
