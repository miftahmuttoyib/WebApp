package bo;

import obj.Complaint;

import java.util.List;

public interface ComplaintBO {
    List<Complaint> getAllComplaint();

    List<Complaint> selectComplaintByStatus(int stausNo);

    Complaint getComplaintById(String id);

    void saveComplaint(Complaint complaint);

    void deleteComplaint(String id);
}
