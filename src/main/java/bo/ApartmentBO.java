package bo;

import obj.Apartment;

import java.util.List;

public interface ApartmentBO {
    List<Apartment> getAllApartment();
    Apartment getApartmentById(String id);

    void saveApartment(Apartment apartment);

    void deleteApartment(String id);
}
