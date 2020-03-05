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
    public List<Problem> selectAllProblem() {
        return problemBO.getAllProblem();
    }

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Problem getGoods(@QueryParam("id") String id) {
        return problemBO.getProblemById(id);
    }

    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    public void saveProblem(Problem problem) {
        problemBO.saveProblem(problem);
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") String id) {
        problemBO.deleteProblem(id);
    }
}