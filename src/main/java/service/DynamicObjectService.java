package service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("object")
public class DynamicObjectService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void saveObjectAttribute(List<String> rawTypeObject) {
        String test = "";
    }
}
