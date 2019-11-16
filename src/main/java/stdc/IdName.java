package stdc;

public class IdName {
    public static class ColumnName {
        public final static String ID = "id";
        public final static String NAME = "name";
    }

    private String id = "";
    private String name = "";

    public IdName() {
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
