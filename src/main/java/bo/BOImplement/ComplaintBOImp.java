package bo.BOImplement;

import bo.ComplaintBO;
import bo.ProblemBO;
import bo.TechnicianBO;
import dao.ComplaintDAO;
import obj.Complaint;
import obj.Problem;
import obj.Technician;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ComplaintBOImp extends ComplaintDAO implements ComplaintBO {
    private ProblemBO problemBO = new ProblemBOImp();
    private TechnicianBO technicianBO = new TechnicianBOImp();
    @Override
    public List<Complaint> getAllComplaint() {
        return null;
    }

    @Override
    public List<Complaint> selectComplaintByStatus(int stausNo) {
        return new ArrayList<>();
    }

    @Override
    public Complaint getComplaintById(String id) {
        return null;
    }

    @Override
    public void saveComplaint(Complaint complaint) {
        complaint.setCreateDate(new Date(new java.util.Date().getTime()));
        save(complaint);
    }



    @Override
    public void deleteComplaint(String id) {

    }
}
