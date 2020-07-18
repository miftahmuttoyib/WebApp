package dao;

import obj.Building;
import schema.tables.records.BuildingRecord;

import java.util.List;

import static schema.Tables.BUILDING;

public class BuildingDAO extends DAO {

    protected List<Building> getAll() {
        openConnection();
        List<Building> result = db.select().from(BUILDING).fetch().into(Building.class);
        closeConnection();
        return result;
    }

    protected void save(Building building) {
        openConnection();
        BuildingRecord newRecord = db.newRecord(BUILDING, building);
        newRecord.store();
        closeConnection();
    }

    protected void delete(String buildingId) {
        openConnection();
        BuildingRecord selectedRecord = db.fetchOne(BUILDING, BUILDING.ID.eq(Integer.parseInt(buildingId)));
        selectedRecord.delete();
        closeConnection();
    }
}
