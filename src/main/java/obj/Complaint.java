package obj;

import bo.ApartmentBO;
import bo.BOImplement.ApartmentBOImp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jooq.DSLContext;
import schema.tables.records.ComplaintTeamRecord;
import stdc.IdName;

import javax.persistence.Column;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static schema.Tables.COMPLAINT_TEAM;
import static stdc.IdName.ColumnName.ID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Complaint extends IdName {
    public static final String TABLE_NAME = "complaint";
    public static final String FOREIGN_KEY_NAME = TABLE_NAME + "_" + ID;

    public static final class ColumnName {
        public static final String STATUS_NO = "status_no";
        public static final String CREATE_DATE = "create_date";
    }

    @Column(name = User.FOREIGN_KEY_NAME)
    private int userId;
    @Column(name = Apartment.FOREIGN_KEY_NAME)
    private int apartmentId;
    @Column(name = Problem.FOREIGN_KEY_NAME)
    private int problemId;
    @Column(name = Facilities.FOREIGN_KEY_NAME)
    private int facilitiesId;
    @Column(name = Room.FOREIGN_KEY_NAME)
    private int roomId;
    @Column(name = ColumnName.STATUS_NO)
    private int statusNo = 1;
    @Column(name = ColumnName.CREATE_DATE)
    private Date createDate;

    private User user = new User();
    private Apartment apartment = new Apartment();
    private List<Technician> technicianList= new ArrayList<>();

    public static class ComplaintTeam {
        @Column(name = FOREIGN_KEY_NAME)
        private int compaintId;
        @Column(name = Technician.FOREIGN_KEY_NAME)
        private int technicianId;
    }


    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getApartmentId() {
        return apartmentId;
    }
    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public int getProblemId() {
        return problemId;
    }
    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public int getFacilitiesId() {
        return facilitiesId;
    }
    public void setFacilitiesId(int facilitiesId) {
        this.facilitiesId = facilitiesId;
    }

    public int getRoomId() {
        return roomId;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getStatusNo() {
        return statusNo;
    }
    public void setStatusNo(int statusNo) {
        this.statusNo = statusNo;
    }

    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Apartment getApartment() {
        ApartmentBO apartmentBO = new ApartmentBOImp();
        this.apartment = apartmentBO.getApartmentById(this.apartmentId);
        return this.apartment;
    }
    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public List<Technician> getTechnicianList() {
        return technicianList;
    }
    public void setTechnicianList(List<Technician> technicianList) {
        this.technicianList = technicianList;
    }

    public List<ComplaintTeamRecord> createChildRecord(DSLContext db) {
        List<ComplaintTeamRecord> resultList = new ArrayList<>();
        for (Technician technician : this.getTechnicianList()) {
            ComplaintTeamRecord childRecord = db.newRecord(COMPLAINT_TEAM);
            childRecord.setComplaintId(this.getId());
            childRecord.setTechnicianId(technician.getId());
            resultList.add(childRecord);
        }
        return resultList;
    }
}
