package bo;

import obj.Building;

import java.util.List;

public interface BuildingBO {
    List<Building> getAllBuilding();
    Building getBuildingById(String id);

    void saveBuilding(Building building);

    void deleteBuilding(String id);
}