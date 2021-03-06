package obj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import stdc.IdName;

import javax.persistence.Column;

import static stdc.IdName.ColumnName.ID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Floor extends IdName {
    public static final String TABLE_NAME = "floor";
    public static final String FOREIGN_KEY_NAME = TABLE_NAME + "_" + ID;

    public static final class ColumnName {
        public final static String CODE = "code";
    }
    public Floor() {

    }

    @Column(name = ColumnName.CODE)
    private String code = "";

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}
