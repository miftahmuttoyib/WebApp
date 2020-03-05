package bo;

import obj.Facilities;
import service.FacilitiesService;

import java.util.List;

public interface FacilitiesBO {
    List<Facilities> getAllFacilities();
    Facilities getFacilitiesById(String id);

    void saveFacilities(Facilities facilities);

    void deleteFacilities(String id);
}
