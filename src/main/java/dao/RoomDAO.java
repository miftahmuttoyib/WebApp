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
        List<Room> resultList = db.select().from(ROOM).fetch().into(Room.class);
        List<Room.RoomFacilities> resultChildList = db.select().from(ROOM_FACILITIES).fetch().into(Room.RoomFacilities.class);
        List<Facilities> facilitiesList = facilitiesDAO.getAll();
        for (Room resultItem : resultList) {
            resultItem.childMap(resultChildList, facilitiesList);
        }
        return resultList;
    }

    protected void save(Room room) {
        RoomRecord newRecord = db.newRecord(ROOM, room);
        newRecord.store();
        room.setId(newRecord.getId());
        List<RoomFacilitiesRecord> childRecords = room.createChildRecord(db);
        Batch batch = db.batchInsert(childRecords);
        batch.execute();
    }

    protected void delete(String roomId) {
        RoomRecord selectedRecord = db.fetchOne(ROOM, ROOM.ID.eq(Integer.parseInt(roomId)));
        deleteChild(roomId);
        selectedRecord.delete();
    }

    private void deleteChild(String roomId) {
        db.delete(ROOM_FACILITIES).where(ROOM_FACILITIES.ROOM_ID.eq(Integer.valueOf(roomId)));
    }

    protected Room get(String id) {
        Room facilities = db.fetchOne(ROOM, ROOM.ID.eq(Integer.parseInt(id))).into(Room.class);
        List<Room.RoomFacilities> childRecords = db.fetch(ROOM_FACILITIES, ROOM_FACILITIES.ROOM_ID.eq(Integer.parseInt(id))).into(Room.RoomFacilities.class);
        List<Integer> listId = new ArrayList<>();
        for (Room.RoomFacilities item : childRecords) {
            listId.add(item.getFacilitiesId());
        }
        List<Facilities> problemList = facilitiesDAO.getByListId(listId);
        facilities.childMap(childRecords, problemList);
        return facilities;
    }
}
