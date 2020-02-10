package dao;

import obj.Problem;

import java.util.List;

public class ProblemDAO extends DAO {
    protected List<Problem> getAll() {
        return db.select().from(Problem.TABLE_NAME).fetch().into(Problem.class);
    }

    protected void save(Problem problem) {
    }
}
