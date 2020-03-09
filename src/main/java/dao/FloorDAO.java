package dao;

import obj.Floor;
import schema.tables.records.FloorRecord;

import java.util.List;

import static schema.Tables.FLOOR;

public class FloorDAO extends DAO {
    protected List<Floor> getAll() {
        return db.select().from(FLOOR).fetch().into(Floor.class);
    }

    protected void save(Floor floor) {
        FloorRecord newRecord = db.newRecord(FLOOR, floor);
        newRecord.store();
    }

    protected void delete(String id) {
        FloorRecord selectedRecord = db.fetchOne(FLOOR, FLOOR.ID.eq(Integer.parseInt(id)));
        selectedRecord.delete();
    }
}
