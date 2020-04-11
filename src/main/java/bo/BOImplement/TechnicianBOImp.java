package bo.BOImplement;

import bo.TechnicianBO;
import dao.TechnicianDAO;
import helper.Position;
import obj.Technician;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TechnicianBOImp extends TechnicianDAO implements TechnicianBO {
    @Override
    public List<Technician> getAllTechnician() {
        return getAll();
    }

    @Override
    public Technician getTechnicianById(String id) {
        return null;
    }

    @Override
    public List<Technician> getTeam(int manpower, String workingType) {
        List<Technician> team = new ArrayList<>();

        List<Technician> availableManList = getAvailableTechnician(workingType);
        List<Technician> leadList = availableManList.stream().filter(item -> item.getPosition().equals(Position.LEAD)).sorted(Comparator.comparing(Technician::getLastWorkingDate)).collect(Collectors.toList());
        List<Technician> techList = availableManList.stream().filter(item -> item.getPosition().equals(Position.TECHNICIAN)).sorted(Comparator.comparing(Technician::getLastWorkingDate)).collect(Collectors.toList());

        if (leadList.size() == 0 || techList.size() == 0) return new ArrayList<>();
        if (manpower == 1) {
            team.add(leadList.get(0));
            team.add(techList.get(0));
            return team;
        }

        // Manpower - 1, dikarenakan 1 sudah diisi lead
        if (techList.size() < manpower - 1) return new ArrayList<>();
        team.add(leadList.get(0));

        // minus 2 dikarenakan index dari 0.
        // Misal 5 manpower maka 4 teknisi 1 lead,
        // techList disubstring dari 0 sampai index ke 3 (0, 1, 2, 3) maka akan dapat 4 teknisi
        List<Technician> freshTech = techList.subList(0, manpower - 1);
        team.addAll(freshTech);
        return team;
    }

    @Override
    public void saveTechnician(Technician problem) {

    }

    @Override
    public void deleteTechnician(String id) {

    }

    @Override
    public void updateStatus(List<Technician> technicianList) {
        for (Technician technician : technicianList) {
            technician.setAvailability(!technician.isAvailability());
        }
        update(technicianList);
    }

    @Override
    public void freeTechnician(List<Technician> technicianList) {
        updateStatus(technicianList);
    }
}
