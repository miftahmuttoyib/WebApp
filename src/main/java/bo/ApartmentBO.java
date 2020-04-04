package bo;

import obj.Apartment;

import java.util.List;

public interface ApartmentBO {
    List<Apartment> getAllApartment();
    Apartment getApartmentById(int id);

    void saveApartment(Apartment apartment);

    void deleteApartment(String id);
}
