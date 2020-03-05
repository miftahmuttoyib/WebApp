package bo.BOImplement;

import bo.ProblemBO;
import dao.ProblemDAO;
import obj.Problem;

import java.util.List;

import static helper.Common.mapWorkingType;

public class ProblemBOImp extends ProblemDAO implements ProblemBO {
    @Override
    public List<Problem> getAllProblem() {
//        List<Problem> resultList = getAll();
//        mapWorkingType(resultList);
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

    @Override
    public void deleteProblem(String id) {
        delete(id);
    }

//    @Override
//    public Problem getProblemById(String id) {
//        return getByid();
//    }
}
