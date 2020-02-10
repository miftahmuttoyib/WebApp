package bo.BOImplement;

import bo.ProblemBO;
import dao.ProblemDAO;
import obj.Problem;

import java.util.List;

public class ProblemBOImp extends ProblemDAO implements ProblemBO {
    @Override
    public List<Problem> getAllProblem() {
        return getAll();
    }

    @Override
    public Problem getProblemById(String id) {
        return null;
    }

    @Override
    public void saveProblem(Problem problem) {
        save(problem);
    }

//    @Override
//    public Problem getProblemById(String id) {
//        return getByid();
//    }
}
