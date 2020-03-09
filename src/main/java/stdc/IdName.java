package stdc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IdName {
    public static final class ColumnName {
        public final static String ID = "id";
        public final static String NAME = "name";
    }

    @Column(name = ColumnName.ID)
    private int id;
    @Column(name = ColumnName.NAME)
    private String name = "";

    protected IdName() {
    }

    public int getId() {
        return this.id;
    }
    public String getIdAsString() {
        return Integer.toString(id);
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setStringId(String id) {
        this.id = Integer.parseInt(id);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
