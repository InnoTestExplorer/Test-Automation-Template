package data;

import com.poiji.bind.Poiji;
import models.Credential;

import java.io.File;
import java.util.List;

public class ExcelReader {

    private static final String excelPath = "src/test/resources/data/userData.xlsx";

    public static List<Credential> leerListaCredencialExcel() {

        return Poiji.fromExcel(new File(excelPath), Credential.class);
    }
}
