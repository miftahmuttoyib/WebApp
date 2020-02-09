package stdc;

import javax.persistence.Column;

public class IdName {
    public static class ColumnName {
        public final static String ID = "id";
        public final static String NAME = "name";
    }

    @Column(name = ColumnName.ID)
    private String id = "";
    @Column(name = ColumnName.NAME)
    private String name = "";

    protected IdName() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
