package obj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jooq.DSLContext;
import schema.tables.records.ComplaintTeamRecord;
import stdc.IdName;

import javax.persistence.Column;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static schema.Tables.COMPLAINT_TEAM;
import static stdc.IdName.ColumnName.ID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Complaint extends IdName {
    public static final String TABLE_NAME = "complaint";
    public static final String FOREIGN_KEY_NAME = TABLE_NAME + "_" + ID;

    public static final class ColumnName {
        public static final String STATUS_NO = "status_no";
        public static final String CREATE_DATE = "create_date";
        public static final String START_WORKING_DATE = "start_working_date";
        public static final String FINISH_DATE = "finish_date";
        public static final String NOTE = "note";
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
    @Column(name = ColumnName.START_WORKING_DATE)
    private Date startWorkingDate;
    @Column(name = ColumnName.FINISH_DATE)
    private Date finishDate;
    @Column(name = ColumnName.NOTE)
    private String note = "";


    private User user = new User();
    private Apartment apartment = new Apartment();
    private Room room = new Room();
    private Facilities facilities = new Facilities();
    private Problem problem = new Problem();
    private List<Technician> technicianList= new ArrayList<>();

    public static class ComplaintTeam {
        @Column(name = FOREIGN_KEY_NAME)
        private int complaintId;
        @Column(name = Technician.FOREIGN_KEY_NAME)
        private int technicianId;

        public int getComplaintId() {
            return complaintId;
        }
        public void setComplaintId(int complaintId) {
            this.complaintId = complaintId;
        }

        public int getTechnicianId() {
            return technicianId;
        }
        public void setTechnicianId(int technicianId) {
            this.technicianId = technicianId;
        }
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

    public Date getStartWorkingDate() {
        return startWorkingDate;
    }
    public void setStartWorkingDate(Date startWorkingDate) {
        this.startWorkingDate = startWorkingDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Apartment getApartment() {
//        ApartmentBO apartmentBO = new ApartmentBOImp();
//        this.apartment = apartmentBO.getApartmentById(this.apartmentId);
        return this.apartment;
    }
    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Problem getProblem() {
        return problem;
    }
    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Facilities getFacilities() {
        return facilities;
    }
    public void setFacilities(Facilities facilities) {
        this.facilities = facilities;
    }

    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Technician> getTechnicianList() {
        return technicianList;
    }
    public void setTechnicianList(List<Technician> technicianList) {
        this.technicianList = technicianList;
    }
    public void addTechnician(Technician technician) {
        this.technicianList.add(technician);
    }
    public void addAllTechnician(List<Technician> technicianList) {
        this.technicianList.addAll(technicianList);
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

    public void childMap(List<ComplaintTeam> resultChildList, List<Technician> technicianList) {
        List<ComplaintTeam> childItems = resultChildList.stream().filter(item -> item.getComplaintId() == this.getId()).collect(Collectors.toList());
        for (ComplaintTeam item : childItems) {
            List<Technician> technicians = technicianList.stream().filter(p -> p.getId() == item.getTechnicianId()).collect(Collectors.toList());
            this.addAllTechnician(technicians);
        }
    }
}
