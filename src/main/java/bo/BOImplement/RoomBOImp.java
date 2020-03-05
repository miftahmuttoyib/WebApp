package bo.BOImplement;

import bo.RoomBO;
import dao.RoomDAO;
import obj.Room;

import java.util.List;

public class RoomBOImp extends RoomDAO implements RoomBO {
    @Override
    public List<Room> getAllRoom() {
        return getAll();
    }

    @Override
    public Room getRoomById(String id) {
        return null;
    }

    @Override
    public void saveRoom(Room room) {
        save(room);
    }

    @Override
    public void deleteRoom(String id) {
        delete(id);
    }
}
