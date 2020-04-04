package bo.BOImplement;

import bo.ApartmentBO;
import dao.ApartmentDAO;
import obj.Apartment;

import java.util.List;

public class ApartmentBOImp extends ApartmentDAO implements ApartmentBO {

    @Override
    public List<Apartment> getAllApartment() {
        return getAll();
    }

    @Override
    public Apartment getApartmentById(int id) {
        return get(id);
    }

    @Override
    public void saveApartment(Apartment apartment) {
        generateApartmentCode(apartment);
        save(apartment);
    }

    private void generateApartmentCode(Apartment apartment) {
        String buildingCode  = apartment.getBuilding().getCode();
        String floorCode = apartment.getFloor().getName();
    }

    @Override
    public void deleteApartment(String id) {
        delete(id);
    }
}
