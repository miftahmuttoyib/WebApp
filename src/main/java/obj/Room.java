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

    private List<Facilities> facilitiesList = new ArrayList<>();

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

    public List<Facilities> getFacilitiesList() {
        return facilitiesList;
    }
    public void setFacilitiesList(List<Facilities> facilitiesList) {
        this.facilitiesList = facilitiesList;
    }
    public void addFacilities(Facilities facilities) {
        this.facilitiesList.add(facilities);
    }
    public void addAllFacilities(List<Facilities> facilitiesList) {
        this.facilitiesList.addAll(facilitiesList);
    }

    public void mapToRecord(RoomRecord newRecord) {
        newRecord.setId(this.getId());
        newRecord.setName(this.getName());
    }

    public List<RoomFacilitiesRecord> createChildRecord(DSLContext db) {
        List<RoomFacilitiesRecord> resultList = new ArrayList<>();
        for (Facilities facilities : this.getFacilitiesList()) {
            RoomFacilitiesRecord childRecord = db.newRecord(ROOM_FACILITIES);
            childRecord.setRoomId(this.getId());
            childRecord.setFacilitiesId(facilities.getId());
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
