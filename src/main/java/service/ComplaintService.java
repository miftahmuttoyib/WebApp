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
    @Path("get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Complaint getComplaint(@PathParam("id") String id) {
        return complaintBO.getComplaintById(id);
    }

    @GET
    @Path("get/spk/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Complaint getSpk(@PathParam("id") String id) {
        return complaintBO.getComplaintById(id);
    }

    @GET
    @Path("get/finish/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Complaint finishComplaint(@PathParam("id") String id) {
        return complaintBO.finishComplaint(id);
    }

    @GET
    @Path("get/start/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Complaint startComplaint(@PathParam("id") String id) {
        return complaintBO.startComplaint(id);
    }

    @GET
    @Path("get/update/status/{id}/{statusNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Complaint updateComplaint(@PathParam("id") String id, @PathParam("statusNo") int statusNo) {
        return complaintBO.updateComplaint(id, statusNo);
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
