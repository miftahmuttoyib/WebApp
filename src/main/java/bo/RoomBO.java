package bo;

import obj.Room;

import java.util.List;

public interface RoomBO {
    List<Room> getAllRoom();
    Room getRoomById(String id);

    void saveRoom(Room room);

    void deleteRoom(String id);
}
