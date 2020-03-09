package bo.BOImplement;

import bo.FloorBO;
import dao.FloorDAO;
import obj.Floor;

import java.util.List;

public class FloorBOImp extends FloorDAO implements FloorBO {
    @Override
    public List<Floor> getAllFloor() {
        return getAll();
    }

    @Override
    public Floor getFloorById(String id) {
        return null;
    }

    @Override
    public void saveFloor(Floor floor) {
        save(floor);
    }

    @Override
    public void deleteFloor(String id) {
        delete(id);
    }
}
