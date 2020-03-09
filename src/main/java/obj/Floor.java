package obj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import stdc.IdName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Floor extends IdName {
    public static final String TABLE_NAME = "floor";
    public static final class ColumnName {

    }
    public Floor() {

    }

    private String code = "";
}
