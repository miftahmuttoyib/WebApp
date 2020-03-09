package obj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import stdc.IdName;

import javax.persistence.Column;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Building extends IdName {
    public static final String TABLE_NAME = "building";

    public static final class ColumnName {
        public final static String CODE = "code";
    }

    public Building() {

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