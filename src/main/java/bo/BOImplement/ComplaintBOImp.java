package bo.BOImplement;

import bo.ComplaintBO;
import dao.ComplaintDAO;
import obj.Complaint;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ComplaintBOImp extends ComplaintDAO implements ComplaintBO {
    @Override
    public List<Complaint> getAllComplaint() {
        return getAll();
    }

    @Override
    public List<Complaint> selectComplaintByStatus(int stausNo) {
        return new ArrayList<>();
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
    public void deleteComplaint(String id) {

    }
}
