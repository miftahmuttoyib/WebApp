package service;

import bo.BOImplement.FloorBOImp;
import bo.FloorBO;
import obj.Floor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("floor")
public class FloorService {
    private FloorBO floorBO = new FloorBOImp();

    @GET
    @Path("get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Floor> selectAllFloor() {
        return floorBO.getAllFloor();
    }

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Floor getFloor(@QueryParam("id") String id) {
        return floorBO.getFloorById(id);
    }

    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    public void saveFloor(Floor floor) {
        floorBO.saveFloor(floor);
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") String id) {
        floorBO.deleteFloor(id);
    }
}
