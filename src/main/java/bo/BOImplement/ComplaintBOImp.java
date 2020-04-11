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
        List<Technician> TechnicianList = complaint.getTechnicianList();
        technicianBO.freeTechnician(TechnicianList);
        updateComplaint(complaint, 3);
        return get(complaint.getId());
    }
}
