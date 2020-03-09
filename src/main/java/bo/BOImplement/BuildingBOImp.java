package bo.BOImplement;

import bo.BuildingBO;
import dao.BuildingDAO;
import obj.Building;

import java.util.List;

public class BuildingBOImp extends BuildingDAO implements BuildingBO {
    @Override
    public List<Building> getAllBuilding() {
        return getAll();
    }

    @Override
    public Building getBuildingById(String id) {
        return null;
    }

    @Override
    public void saveBuilding(Building building) {
        save(building);
    }

    @Override
    public void deleteBuilding(String id) {
        delete(id);
    }
}
