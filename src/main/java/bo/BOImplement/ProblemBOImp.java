package bo.BOImplement;

import bo.ProblemBO;
import dao.ProblemDAO;
import obj.Problem;

import java.util.List;

public class ProblemBOImp extends ProblemDAO implements ProblemBO {
    @Override
    public List<Problem> getAllProblem() {
//        List<Problem> resultList = getAll();
//        mapWorkingType(resultList);
        return getAll();
    }

    @Override
    public Problem getProblemById(String id) {
        int idInt = Integer.parseInt(id);
        return get(idInt);
    }

    @Override
    public void saveProblem(Problem problem) {
        save(problem);
    }

    @Override
    public void deleteProblem(String id) {
        delete(id);
    }

//    @Override
//    public Problem getProblemById(String id) {
//        return getByid();
//    }
}
