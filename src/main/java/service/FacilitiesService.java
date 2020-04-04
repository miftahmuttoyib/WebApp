package service;

import bo.BOImplement.FacilitiesBOImp;
import bo.FacilitiesBO;
import obj.Facilities;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("facilities")
public class FacilitiesService extends HttpServlet {
    private FacilitiesBO facilitiesBO = new FacilitiesBOImp();

    @GET
    @Path("get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Facilities> selectAllFacilities() {
        return facilitiesBO.getAllFacilities();
    }

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Facilities getFacilities(@QueryParam("id") String id) {
        return facilitiesBO.getFacilitiesById(Integer.parseInt(id));
    }

    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    public void saveFacilities(Facilities facilities) {
        facilitiesBO.saveFacilities(facilities);
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") String id) {
        facilitiesBO.deleteFacilities(id);
    }
}
