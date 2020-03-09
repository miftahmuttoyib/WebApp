package service;

import bo.ApartmentBO;
import bo.BOImplement.ApartmentBOImp;
import obj.Apartment;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("apartment")
public class ApartmentService {
    private ApartmentBO apartmentBO = new ApartmentBOImp();

    @GET
    @Path("get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Apartment> selectAllApartment() {
        return apartmentBO.getAllApartment();
    }

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Apartment getApartment(@QueryParam("id") String id) {
        return apartmentBO.getApartmentById(id);
    }

    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    public void saveApartment(Apartment apartment) {
        apartmentBO.saveApartment(apartment);
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") String id) {
        apartmentBO.deleteApartment(id);
    }
}
