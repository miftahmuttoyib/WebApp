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
        openConnection();
        List<Complaint> complaintList = db.select().from(COMPLAINT).where(COMPLAINT.STATUS_NO.eq(statusNo)).fetch().into(Complaint.class);
        for(Complaint complaint : complaintList) {
            mapWithOtherData(complaint);
        }
        closeConnection();
        return complaintList;
    }

    protected List<Complaint> getAll() {
        openConnection();
        List<Complaint> resultList = db.select().from(COMPLAINT).fetch().into(Complaint.class);
        for (Complaint resultItem : resultList) {
            mapWithOtherData(resultItem);
        }
        closeConnection();
        return resultList;
    }

    protected Complaint get(int id) {
        openConnection();
        Complaint complaint = db.select().from(COMPLAINT).where(COMPLAINT.ID.eq(id)).fetchAny().into(Complaint.class);
        mapWithOtherData(complaint);
        closeConnection();
        return complaint;
    }

    private void mapWithOtherData(Complaint complaint) {
        openConnection();
        User user = db.select().from(USER).where(USER.ID.eq(complaint.getUserId())).fetchAny().into(User.class);
        complaint.setUser(user);

        Apartment apartment = apartmentBO.getApartmentById(complaint.getApartmentId());
        complaint.setApartment(apartment);

        complaint.setRoom(apartment.getRoom(complaint.getRoomId()));
        complaint.setFacilities(complaint.getRoom().getFacilities(complaint.getFacilitiesId()));
        complaint.setProblem(complaint.getFacilities().getProblem(complaint.getProblemId()));

        if (complaint.getStatusNo() < 2) {
            closeConnection();
            return;
        }
        List<Complaint.ComplaintTeam> resultChildList = db.select().from(COMPLAINT_TEAM).where(COMPLAINT_TEAM.COMPLAINT_ID.eq(complaint.getId())).fetch().into(Complaint.ComplaintTeam.class);
        List<Technician> technicianList = technicianBO.getAllTechnician();
        complaint.childMap(resultChildList, technicianList);
        closeConnection();
    }

    protected void save(Complaint complaint) {
        openConnection();
        ComplaintRecord newRecord = db.newRecord(COMPLAINT, complaint);
        newRecord.store();
        complaint.setId(newRecord.getId());
        List<ComplaintTeamRecord> childRecords = complaint.createChildRecord(db);
        Batch batch = db.batchInsert(childRecords);
        batch.execute();
        closeConnection();
    }

    protected void update(Complaint complaint) {
        openConnection();
        ComplaintRecord newRecord = db.newRecord(COMPLAINT, complaint);
        newRecord.update();
        List<ComplaintTeamRecord> childRecords = complaint.createChildRecord(db);
        Batch batch = db.batchStore(childRecords);
        batch.execute();
        closeConnection();
    }

    protected void updateParentOnly(Complaint complaint) {
        openConnection();
        ComplaintRecord newRecord = db.newRecord(COMPLAINT, complaint);
        newRecord.update();
        closeConnection();
    }
}
