package dao;

import obj.Problem;
import schema.tables.records.ProblemRecord;

import java.util.List;

import static schema.Tables.PROBLEM;


public class ProblemDAO extends DAO {
    protected List<Problem> getAll() {
        return db.select().from(PROBLEM).fetch().into(Problem.class);
    }

    protected Problem get(int id) {
        return db.select().from(PROBLEM).where(PROBLEM.ID.eq(id)).fetchAny().into(Problem.class);
    }

    protected void save(Problem problem) {
        ProblemRecord newRecord = db.newRecord(PROBLEM, problem);
        newRecord.store();
    }

    protected void delete(String id) {
        ProblemRecord selectedRecord = db.fetchOne(PROBLEM, PROBLEM.ID.eq(Integer.parseInt(id)));
        selectedRecord.delete();
    }

    public List<Problem> getByListId(List<Integer> listId) {
        return db.fetch(PROBLEM, PROBLEM.ID.in(listId)).into(Problem.class);
    }
}
