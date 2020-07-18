package dao;

import obj.Facilities;
import obj.Room;
import org.jooq.Batch;
import schema.tables.records.RoomFacilitiesRecord;
import schema.tables.records.RoomRecord;

import java.util.ArrayList;
import java.util.List;

import static schema.Tables.ROOM;
import static schema.Tables.ROOM_FACILITIES;

public class RoomDAO extends DAO {
    private FacilitiesDAO facilitiesDAO = new FacilitiesDAO();

    protected List<Room> getAll() {
        openConnection();
        List<Room> resultList = db.select().from(ROOM).fetch().into(Room.class);
        List<Room.RoomFacilities> resultChildList = db.select().from(ROOM_FACILITIES).fetch().into(Room.RoomFacilities.class);
        List<Facilities> facilitiesList = facilitiesDAO.getAll();
        for (Room resultItem : resultList) {
            resultItem.childMap(resultChildList, facilitiesList);
        }
        closeConnection();
        return resultList;
    }

    protected void save(Room room) {
        openConnection();
        RoomRecord newRecord = db.newRecord(ROOM, room);
        newRecord.store();
        room.setId(newRecord.getId());
        List<RoomFacilitiesRecord> childRecords = room.createChildRecord(db);
        Batch batch = db.batchInsert(childRecords);
        batch.execute();
        closeConnection();
    }

    protected void delete(String roomId) {
        openConnection();
        RoomRecord selectedRecord = db.fetchOne(ROOM, ROOM.ID.eq(Integer.parseInt(roomId)));
        deleteChild(roomId);
        selectedRecord.delete();
        closeConnection();
    }

    private void deleteChild(String roomId) {
        openConnection();
        db.delete(ROOM_FACILITIES).where(ROOM_FACILITIES.ROOM_ID.eq(Integer.valueOf(roomId)));
        closeConnection();
    }

    protected Room get(String id) {
        openConnection();
        Room facilities = db.fetchOne(ROOM, ROOM.ID.eq(Integer.parseInt(id))).into(Room.class);
        List<Room.RoomFacilities> childRecords = db.fetch(ROOM_FACILITIES, ROOM_FACILITIES.ROOM_ID.eq(Integer.parseInt(id))).into(Room.RoomFacilities.class);
        List<Integer> listId = new ArrayList<>();
        for (Room.RoomFacilities item : childRecords) {
            listId.add(item.getFacilitiesId());
        }
        List<Facilities> problemList = facilitiesDAO.getByListId(listId);
        facilities.childMap(childRecords, problemList);
        closeConnection();
        return facilities;
    }
}
