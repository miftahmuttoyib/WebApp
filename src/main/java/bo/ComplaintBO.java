package bo;

import obj.Complaint;

import java.util.List;

public interface ComplaintBO {
    List<Complaint> getAllComplaint();

    List<Complaint> selectComplaintByStatus(int statusNo);

    Complaint getComplaintById(String id);

    void saveComplaint(Complaint complaint);
    Complaint updateComplaint(String id);
    void updateComplaint(Complaint complaint, int statusNo);
    Complaint updateComplaint(String id, int statusNo);

    void deleteComplaint(String id);

    Complaint finishComplaint(String id);
    Complaint startComplaint(String id);
}
