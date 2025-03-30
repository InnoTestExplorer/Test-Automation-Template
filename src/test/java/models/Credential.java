package models;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("credentials")
public class Credential {

    @ExcelCellName("USERNAME")
    private String username;
    @ExcelCellName("PASSWORD")
    private String password;
    @ExcelCellName("MESSAGE")
    private String message;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMessage() {
        return message;
    }
}
