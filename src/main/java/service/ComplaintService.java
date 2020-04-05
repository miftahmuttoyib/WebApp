package service;

import bo.BOImplement.ComplaintBOImp;
import bo.ComplaintBO;
import obj.Complaint;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("complaint")
public class ComplaintService extends HttpServlet {
    private ComplaintBO complaintBO = new ComplaintBOImp();

    @GET
    @Path("get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Complaint> selectAllComplaint() {
        return complaintBO.getAllComplaint();
    }

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Complaint getComplaint(@QueryParam("id") String id) {
        return complaintBO.getComplaintById(id);
    }

    @GET
    @Path("get/spk/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Complaint getSpk(@QueryParam("id") String id) {
        return complaintBO.getComplaintById(id);
    }

    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    public void saveComplaint(Complaint complaint) {
        complaintBO.saveComplaint(complaint);
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") String id) {
        complaintBO.deleteComplaint(id);
    }
}
