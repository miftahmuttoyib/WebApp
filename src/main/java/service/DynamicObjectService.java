package service;

import obj.DynamicObjec;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Iterator;
import java.util.List;

@Path("object")
public class DynamicObjectService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void saveObjectAttribute(List<String> rawTypeObject) {
        DynamicObjec dynamicObjec = new DynamicObjec();

        Iterator<String> objectIterator = rawTypeObject.iterator();
        while (objectIterator.hasNext()) {
            String key = objectIterator.next();
            String value = objectIterator.next();
            dynamicObjec.putToAttribs(key, value);
        }
    }
}
