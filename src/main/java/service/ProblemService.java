package service;

import bo.BOImplement.ProblemBOImp;
import bo.ProblemBO;
import obj.Problem;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("problem")
public class ProblemService {
    @GET
    @Path("get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Problem> selectAllGoods() {
        ProblemBO problemBO = new ProblemBOImp();
        return problemBO.getAllProblem();
    }

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Problem getGoods(String id) {
        ProblemBO problemBO = new ProblemBOImp();
        return problemBO.getProblemById(id);
    }

    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    public void saveGoods() {
        ProblemBO problemBO = new ProblemBOImp();
//        return problemBO.getAllProblem();
    }

    @DELETE
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    public void saveGoods(String a) {
        ProblemBO problemBO = new ProblemBOImp();
        problemBO.getAllProblem();
    }
}