package dao;

import bo.ApartmentBO;
import bo.BOImplement.ApartmentBOImp;
import bo.BOImplement.TechnicianBOImp;
import bo.TechnicianBO;
import obj.*;
import org.jooq.Batch;
import schema.tables.records.ComplaintRecord;
import schema.tables.records.ComplaintTeamRecord;

import java.util.List;

import static schema.Tables.COMPLAINT;
import static schema.Tables.COMPLAINT_TEAM;
import static schema.tables.User.USER;

public class ComplaintDAO extends DAO {

    private TechnicianBO technicianBO = new TechnicianBOImp();
    private ApartmentBO apartmentBO = new ApartmentBOImp();

    protected List<Complaint> getByStatus(int statusNo) {
        List<Complaint> complaintList = db.select().from(COMPLAINT).where(COMPLAINT.STATUS_NO.eq(statusNo)).fetch().into(Complaint.class);
        for(Complaint complaint : complaintList) {
            mapWithOtherData(complaint);
        }
        return complaintList;
    }

    protected List<Complaint> getAll() {
        List<Complaint> resultList = db.select().from(COMPLAINT).fetch().into(Complaint.class);
        List<Complaint.ComplaintTeam> resultChildList = db.select().from(COMPLAINT_TEAM).fetch().into(Complaint.ComplaintTeam.class);
        List<Technician> technicianList = technicianBO.getAllTechnician();
        for (Complaint resultItem : resultList) {
            resultItem.childMap(resultChildList, technicianList);
        }
        return resultList;
    }

    protected Complaint get(int id) {
        Complaint complaint = db.select().from(COMPLAINT).where(COMPLAINT.ID.eq(id)).fetchAny().into(Complaint.class);
        return mapWithOtherData(complaint);
    }

    private Complaint mapWithOtherData(Complaint complaint) {
        User user = db.select().from(USER).where(USER.ID.eq(complaint.getUserId())).fetchAny().into(User.class);
        complaint.setUser(user);

        Apartment apartment = apartmentBO.getApartmentById(complaint.getApartmentId());
        complaint.setApartment(apartment);

        complaint.setRoom(apartment.getRoom(complaint.getRoomId()));
        complaint.setFacilities(complaint.getRoom().getFacilities(complaint.getFacilitiesId()));
        complaint.setProblem(complaint.getFacilities().getProblem(complaint.getProblemId()));

        if (complaint.getStatusNo() < 2) {
            return complaint;
        }
        List<Complaint.ComplaintTeam> resultChildList = db.select().from(COMPLAINT_TEAM).where(COMPLAINT_TEAM.COMPLAINT_ID.eq(complaint.getId())).fetch().into(Complaint.ComplaintTeam.class);
        List<Technician> technicianList = technicianBO.getAllTechnician();
        complaint.childMap(resultChildList, technicianList);
        return complaint;
    }

    protected void save(Complaint complaint) {
        ComplaintRecord newRecord = db.newRecord(COMPLAINT, complaint);
        newRecord.store();
        complaint.setId(newRecord.getId());
        List<ComplaintTeamRecord> childRecords = complaint.createChildRecord(db);
        Batch batch = db.batchInsert(childRecords);
        batch.execute();
    }
}
