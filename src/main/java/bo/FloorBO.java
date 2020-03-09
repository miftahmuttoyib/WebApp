package bo;

import obj.Floor;

import java.util.List;

public interface FloorBO {
    List<Floor> getAllFloor();
    Floor getFloorById(String id);

    void saveFloor(Floor floor);

    void deleteFloor(String id);
}
