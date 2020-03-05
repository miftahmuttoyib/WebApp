package obj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jooq.DSLContext;
import schema.tables.records.RoomFacilitiesRecord;
import schema.tables.records.RoomRecord;
import stdc.IdName;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static schema.Tables.ROOM_FACILITIES;
import static stdc.IdName.ColumnName.ID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Room extends IdName {
    public static final String TABLE_NAME = "room";
    public static class ColumnName {

    }

    public Room() {

    }

    private List<Facilities> facilitesList = new ArrayList<>();

    public static class RoomFacilities {
        @Column(name = TABLE_NAME+"_"+ID)
        private int roomId;

        @Column(name = Facilities.TABLE_NAME+"_"+ID)
        private int facilitiesId;

        public RoomFacilities() {

        }

        public int getRoomId() {
            return roomId;
        }
        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public int getFacilitiesId() {
            return facilitiesId;
        }
        public void setFacilitiesId(int facilitiesId) {
            this.facilitiesId = facilitiesId;
        }
    }

    public List<Facilities> getFacilitesList() {
        return facilitesList;
    }
    public void setFacilitesList(List<Facilities> facilitesList) {
        this.facilitesList = facilitesList;
    }
    public void addFacilities(Facilities facilities) {
        this.facilitesList.add(facilities);
    }
    public void addAllFacilities(List<Facilities> facilitiesList) {
        this.facilitesList.addAll(facilitiesList);
    }

    public void mapToRecord(RoomRecord newRecord) {
        newRecord.setId(this.getId());
        newRecord.setName(this.getName());
    }

    public List<RoomFacilitiesRecord> createChildRecord(DSLContext db) {
        List<RoomFacilitiesRecord> resultList = new ArrayList<>();
        for (Facilities facilities : this.getFacilitesList()) {
            RoomFacilitiesRecord childRecord = db.newRecord(ROOM_FACILITIES);
            childRecord.setRoomId(facilities.getId());
            childRecord.setFacilitiesId(this.getId());
            resultList.add(childRecord);
        }
        return resultList;
    }

    public void childMap(List<RoomFacilities> resultChildList, List<Facilities> facilities) {
        List<RoomFacilities> childItems = resultChildList.stream().filter(item -> item.getRoomId() == this.getId()).collect(Collectors.toList());
        for (RoomFacilities item : childItems) {
            List<Facilities> facilitiesItems = facilities.stream().filter(p -> p.getId() == item.getFacilitiesId()).collect(Collectors.toList());
            this.addAllFacilities(facilitiesItems);
        }
    }
}
