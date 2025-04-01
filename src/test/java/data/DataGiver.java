package data;

import models.Credential;

import java.util.Map;

public class DataGiver {

    private static Map<String, Credential> obtenerMapCredentials() {

        return JsonReader.obtenerMapCredenciales().getMapCredentials();
    }

    public static Credential getValidCredentials() {

        return obtenerMapCredentials().get("valid");
    }

    public static Credential getLockedCredentials() {

        return obtenerMapCredentials().get("locked");
    }

    public static Credential getUnexistentCredentials() {

        return obtenerMapCredentials().get("unexistent");
    }
}
