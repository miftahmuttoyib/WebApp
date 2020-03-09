package dao;

import obj.Building;
import schema.tables.records.BuildingRecord;

import java.util.List;

import static schema.Tables.BUILDING;

public class BuildingDAO extends DAO {

    protected List<Building> getAll() {
        return db.select().from(BUILDING).fetch().into(Building.class);
    }

    protected void save(Building building) {
        BuildingRecord newRecord = db.newRecord(BUILDING, building);
        newRecord.store();
    }

    protected void delete(String buildingId) {
        BuildingRecord selectedRecord = db.fetchOne(BUILDING, BUILDING.ID.eq(Integer.parseInt(buildingId)));
        selectedRecord.delete();
    }
}
