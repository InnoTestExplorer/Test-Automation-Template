package data;

import org.testng.annotations.DataProvider;

import java.util.Map;

public class CustomDataProviders {

    public static final String DP_CREDENTIALS = "dp_credentials";

    @DataProvider(name = DP_CREDENTIALS)
    public static Object[][] credentialsDataProvider() {

        Map<String, String> mapCredentials = Parser.obtenerMapCredential();

        Object[][] data = new Object[mapCredentials.size()][2];

        int index = 0;

        for (Map.Entry<String, String> entry : mapCredentials.entrySet()) {

            data[index][0] = entry.getKey();
            data[index][1] = entry.getValue();
            index++;
        }

        return data;
    }
}
