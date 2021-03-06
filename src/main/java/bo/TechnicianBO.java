package bo;

import obj.Technician;

import java.util.List;

public interface TechnicianBO {
    List<Technician> getAllTechnician();
    Technician getTechnicianById(String id);
    List<Technician> getTeam(int manpower, String workingType);
    void saveTechnician(Technician problem);

    void deleteTechnician(String id);

    void updateStatus(List<Technician> technicianList);

    void freeTechnician(List<Technician> technicianList);

    void serveTechnician(List<Technician> technicianList);
}
