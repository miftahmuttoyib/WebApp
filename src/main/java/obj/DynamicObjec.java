package obj;

import java.util.HashMap;

public class DynamicObjec {
    private HashMap<String, String> attributes = new HashMap<>();

    public DynamicObjec() {
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }


    public void putToAttribs(String key, String value) {
        this.attributes.put(key, value);
    }
}
