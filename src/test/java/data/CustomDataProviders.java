package data;

import org.testng.annotations.DataProvider;

public class CustomDataProviders {

    public static final String DP_CREDENTIALS = "dp_credentials";

    @DataProvider(name = DP_CREDENTIALS)
    public static Object[][] credentialsDataProvider() {

        final var valid = DataGiver.getValidCredentials();

        return new Object[][]{

                {valid.getUsername(), valid.getPassword()}
        };
    }
}
