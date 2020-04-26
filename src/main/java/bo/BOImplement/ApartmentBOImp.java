package bo.BOImplement;

import bo.ApartmentBO;
import dao.ApartmentDAO;
import obj.Apartment;

import java.util.List;

import static helper.Common.zeroFill;

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
        String buildingCode  = String.valueOf(apartment.getBuildingId());
        String floorCode = String.valueOf(apartment.getFloorId());
        apartment.setCode(zeroFill(buildingCode) + zeroFill(floorCode) + zeroFill(apartment.getNo()));
    }

    @Override
    public void deleteApartment(String id) {
        delete(id);
    }
}