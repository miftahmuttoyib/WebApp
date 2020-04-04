package bo.BOImplement;

import bo.FacilitiesBO;
import dao.FacilitiesDAO;
import obj.Facilities;

import java.util.List;

public class FacilitiesBOImp extends FacilitiesDAO implements FacilitiesBO {
    @Override
    public List<Facilities> getAllFacilities() {
        return getAll();
    }

    @Override
    public Facilities getFacilitiesById(int id) {
        return get(id);
    }

    @Override
    public void saveFacilities(Facilities facilities) {
        save(facilities);
    }

    @Override
    public void deleteFacilities(String id) {
        delete(id);
    }
}
