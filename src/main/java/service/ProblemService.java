package service;

import bo.BOImplement.ProblemBOImp;
import bo.ProblemBO;
import obj.Problem;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("problem")
public class ProblemService {
    private ProblemBO problemBO = new ProblemBOImp();

    @GET
    @Path("get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Problem> selectAllGoods() {
        return problemBO.getAllProblem();
    }

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Problem getGoods(String id) {
        return problemBO.getProblemById(id);
    }

    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    public void saveProblem(Problem problem) {
        problemBO.saveProblem(problem);
    }

    @DELETE
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    public void saveGoods(String a) {
        problemBO.getAllProblem();
    }
}