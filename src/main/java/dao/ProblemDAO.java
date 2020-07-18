package dao;

import obj.Problem;
import schema.tables.records.ProblemRecord;

import java.util.List;

import static schema.Tables.PROBLEM;


public class ProblemDAO extends DAO {
    protected List<Problem> getAll() {
        openConnection();
        List<Problem> result = db.select().from(PROBLEM).fetch().into(Problem.class);
        closeConnection();
        return result;
    }

    protected Problem get(int id) {
        openConnection();
        Problem result = db.select().from(PROBLEM).where(PROBLEM.ID.eq(id)).fetchAny().into(Problem.class);
        closeConnection();
        return result;
    }

    protected void save(Problem problem) {
        openConnection();
        ProblemRecord newRecord = db.newRecord(PROBLEM, problem);
        newRecord.store();
        closeConnection();
    }

    protected void delete(String id) {
        openConnection();
        ProblemRecord selectedRecord = db.fetchOne(PROBLEM, PROBLEM.ID.eq(Integer.parseInt(id)));
        selectedRecord.delete();
        closeConnection();
    }

    public List<Problem> getByListId(List<Integer> listId) {
        openConnection();
        List<Problem> result = db.fetch(PROBLEM, PROBLEM.ID.in(listId)).into(Problem.class);
        closeConnection();
        return result;
    }
}
