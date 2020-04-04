package dao;

import obj.Complaint;
import obj.Facilities;
import obj.Problem;
import obj.Room;
import org.jooq.Batch;
import schema.tables.records.ComplaintRecord;
import schema.tables.records.ComplaintTeamRecord;

import java.util.List;

import static schema.Tables.COMPLAINT;

public class ComplaintDAO extends DAO {

    protected List<Complaint> getByStatus(int statusNo) {
        List<Complaint> complaintList = db.select().from(COMPLAINT).where(COMPLAINT.STATUS_NO.eq(statusNo)).fetch().into(Complaint.class);
        return null;
    }

    protected void save(Complaint complaint) {
        ComplaintRecord newRecord = db.newRecord(COMPLAINT, complaint);
        newRecord.store();
        complaint.setId(newRecord.getId());
        List<ComplaintTeamRecord> childRecords = complaint.createChildRecord(db);
        Batch batch = db.batchInsert(childRecords);
        batch.execute();
    }

    private void mapToRootObject(List<Complaint> complaintList) {
        for (Complaint complaint : complaintList) {
            Room room = complaint.getApartment().getRoom(complaint.getRoomId());
            if (room != null) {
                Facilities facilities = room.getFacilities(complaint.getFacilitiesId());
                Problem problem = facilities.getProblem(complaint.getProblemId());
                if (problem != null) {

                }
            }
        }
    }

    private void mapToRootObject(Complaint complaint) {
        Room room = complaint.getApartment().getRoom(complaint.getRoomId());
        if (room != null) {
            Facilities facilities = room.getFacilities(complaint.getFacilitiesId());
            Problem problem = facilities.getProblem(complaint.getProblemId());
            if (problem != null) {

            }
        }

    }
}
