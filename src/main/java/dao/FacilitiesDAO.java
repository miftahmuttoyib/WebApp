package dao;

import obj.Facilities;
import obj.Problem;
import org.jooq.Batch;
import schema.tables.records.FacilitiesProblemRecord;
import schema.tables.records.FacilitiesRecord;

import java.util.ArrayList;
import java.util.List;

import static schema.Tables.FACILITIES;
import static schema.Tables.FACILITIES_PROBLEM;

public class FacilitiesDAO extends DAO {
    private ProblemDAO problemDAO = new ProblemDAO();

    protected List<Facilities> getAll() {
        openConnection();
        List<Facilities> resultList = db.select().from(FACILITIES).fetch().into(Facilities.class);
        List<Facilities.FacilitiesProblem> resultChildList = db.select().from(FACILITIES_PROBLEM).fetch().into(Facilities.FacilitiesProblem.class);
        List<Problem> problems = problemDAO.getAll();
        for (Facilities resultItem : resultList) {
            resultItem.childMap(resultChildList, problems);
        }
        closeConnection();
        return resultList;
    }

    protected Facilities get(int id) {
        openConnection();
        Facilities facilities = db.select().from(FACILITIES).where(FACILITIES.ID.eq(id)).fetchAny().into(Facilities.class);
        List<Facilities.FacilitiesProblem> resultChildList = db.select().from(FACILITIES_PROBLEM).where(FACILITIES_PROBLEM.FACILITIES_ID.eq(facilities.getId())).fetch().into(Facilities.FacilitiesProblem.class);
        List<Problem> problems = problemDAO.getAll();
        facilities.childMap(resultChildList, problems);
        closeConnection();
        return facilities;
    }

    protected void save(Facilities facilities) {
        openConnection();
        FacilitiesRecord newRecord = db.newRecord(FACILITIES, facilities);
        newRecord.store();
        facilities.setId(newRecord.getId());
        List<FacilitiesProblemRecord> childRecords = facilities.createChildRecord(db);
        Batch batch = db.batchInsert(childRecords);
        batch.execute();
        closeConnection();
    }

    protected void delete(String facilitiesId) {
        openConnection();
        FacilitiesRecord selectedRecord = db.fetchOne(FACILITIES, FACILITIES.ID.eq(Integer.parseInt(facilitiesId)));
        deleteChild(facilitiesId);
        selectedRecord.delete();
        closeConnection();
    }

    private void deleteChild(String facilitiesId) {
        openConnection();
        db.delete(FACILITIES_PROBLEM).where(FACILITIES_PROBLEM.FACILITIES_ID.eq(Integer.valueOf(facilitiesId)));
        closeConnection();
    }

    protected Facilities get(String id) {
        openConnection();
        Facilities facilities = db.fetchOne(FACILITIES, FACILITIES.ID.eq(Integer.parseInt(id))).into(Facilities.class);
        List<Facilities.FacilitiesProblem> childRecords = db.fetch(FACILITIES_PROBLEM, FACILITIES_PROBLEM.FACILITIES_ID.eq(Integer.parseInt(id))).into(Facilities.FacilitiesProblem.class);
        List<Integer> listId = new ArrayList<>();
        for (Facilities.FacilitiesProblem item : childRecords) {
            listId.add(item.getProblemId());
        }
        List<Problem> problemList = problemDAO.getByListId(listId);
        facilities.childMap(childRecords, problemList);
        closeConnection();
        return facilities;
    }

    public List<Facilities> getByListId(List<Integer> listId) {
        openConnection();
        List<Facilities> result = db.fetch(FACILITIES, FACILITIES.ID.in(listId)).into(Facilities.class);
        closeConnection();
        return result;
    }
}