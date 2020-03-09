package dao;

import obj.Apartment;
import obj.Room;
import org.jooq.Batch;
import schema.tables.records.ApartmentRecord;
import schema.tables.records.ApartmentRoomRecord;

import java.util.List;

import static schema.Tables.APARTMENT_ROOM;
import static schema.tables.Apartment.APARTMENT;

public class ApartmentDAO extends DAO {
    private RoomDAO roomDAO = new RoomDAO();

    protected List<Apartment> getAll() {
        List<Apartment> resultList = db.select().from(APARTMENT).fetch().into(Apartment.class);
        List<Apartment.ApartmentRoom> resultChildList = db.select().from(APARTMENT_ROOM).fetch().into(Apartment.ApartmentRoom.class);
        List<Room> roomList = roomDAO.getAll();
        for (Apartment resultItem : resultList) {
            resultItem.childMap(resultChildList, roomList);
        }
        return resultList;
    }

    protected void save(Apartment apartment) {
        ApartmentRecord newRecord = db.newRecord(APARTMENT, apartment);
        newRecord.store();
        apartment.setId(newRecord.getId());
        List<ApartmentRoomRecord> childRecords = apartment.createChildRecord(db);
        Batch batch = db.batchInsert(childRecords);
        batch.execute();
    }

    protected void delete(String apartmentId) {
        ApartmentRecord selectedRecord = db.fetchOne(APARTMENT, APARTMENT.ID.eq(Integer.parseInt(apartmentId)));
        deleteChild(apartmentId);
        selectedRecord.delete();
    }

    private void deleteChild(String apartmentId) {
        db.delete(APARTMENT_ROOM).where(APARTMENT_ROOM.APARTMENT_ID.eq(Integer.valueOf(apartmentId)));
    }
}
