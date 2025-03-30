package data;

import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static Map<String, String> obtenerMapCredential() {

        final var map = new HashMap<String, String>();

        final var listaCredentiales = ExcelReader.leerListaCredencialExcel();

        for (var user : listaCredentiales) {

            map.put(user.getUsername(), user.getPassword());
        }

        return map;
    }
}
