package data;

import models.Credential;
import org.testng.annotations.DataProvider;

public class CustomDataProviders {

    public static final String DP_CREDENTIALS = "dp_credentials";

    @DataProvider(name = DP_CREDENTIALS)
    public static Object[][] credentialsDataProvider() {

        final var credential = new Credential();

        return new Object[][]{

                {credential.getUsername(), credential.getPassword()},
        };
    }
}
