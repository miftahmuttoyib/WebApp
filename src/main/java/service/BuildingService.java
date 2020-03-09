package service;

import bo.BOImplement.BuildingBOImp;
import bo.BuildingBO;
import obj.Building;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("building")
public class BuildingService {
    private BuildingBO buildingBO = new BuildingBOImp();

    @GET
    @Path("get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Building> selectAllBuilding() {
        return buildingBO.getAllBuilding();
    }

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Building getBuilding(@QueryParam("id") String id) {
        return buildingBO.getBuildingById(id);
    }

    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    public void saveBuilding(Building building) {
        buildingBO.saveBuilding(building);
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") String id) {
        buildingBO.deleteBuilding(id);
    }
}
