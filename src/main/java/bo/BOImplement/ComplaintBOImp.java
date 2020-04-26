package bo.BOImplement;

import bo.ComplaintBO;
import bo.TechnicianBO;
import dao.ComplaintDAO;
import obj.Complaint;
import obj.Technician;

import java.sql.Date;
import java.util.List;

public class ComplaintBOImp extends ComplaintDAO implements ComplaintBO {
    TechnicianBO technicianBO = new TechnicianBOImp();

    @Override
    public List<Complaint> getAllComplaint() {
        return getAll();
    }

    @Override
    public List<Complaint> selectComplaintByStatus(int statusNo) {
        return getByStatus(statusNo);
    }

    @Override
    public Complaint getComplaintById(String id) {
        return get(Integer.parseInt(id));
    }

    @Override
    public void saveComplaint(Complaint complaint) {
        complaint.setCreateDate(new Date(new java.util.Date().getTime()));
        save(complaint);
    }

    @Override
    public Complaint updateComplaint(String id) {
        int idInInt = Integer.parseInt(id);
        Complaint complaint = get(idInInt);
        updateComplaint(complaint, complaint.getStatusNo() + 1);
        return complaint;
    }

    @Override
    public void updateComplaint(Complaint complaint, int statusNo) {
        complaint.setStatusNo(statusNo);
        update(complaint);
    }

    @Override
    public void deleteComplaint(String id) {

    }

    @Override
    public Complaint finishComplaint(String id) {
        Complaint complaint = getComplaintById(id);
        complaint.setStartWorkingDate(new Date(new java.util.Date().getTime()));
        List<Technician> TechnicianList = complaint.getTechnicianList();
        technicianBO.freeTechnician(TechnicianList);
        updateComplaint(complaint, 3);
        return get(complaint.getId());
    }

    @Override
    public Complaint startComplaint(String id) {
        Complaint complaint = getComplaintById(id);
        complaint.setFinsihDate(new Date(new java.util.Date().getTime()));
        List<Technician> TechnicianList = complaint.getTechnicianList();
        technicianBO.freeTechnician(TechnicianList);
        updateComplaint(complaint, 4);
        return get(complaint.getId());
    }
}
