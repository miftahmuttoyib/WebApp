package bo;

import obj.Problem;

import java.util.List;

public interface ProblemBO {
    List<Problem> getAllProblem();
    Problem getProblemById(String id);

    void saveProblem(Problem problem);

    void deleteProblem(String id);
}
