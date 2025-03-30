package data;

import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static Map<String, String> obtenerMapCredential() {

        final var map = new HashMap<String, String>();

        final var listaCredentials = ExcelReader.leerListaCredencialExcel();

        for (var userData : listaCredentials) {

            map.put(userData.getUsername(), userData.getPassword());
        }

        return map;
    }
}
