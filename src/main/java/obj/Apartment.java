package obj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jooq.DSLContext;
import schema.tables.records.ApartmentRoomRecord;
import stdc.IdName;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static schema.Tables.APARTMENT_ROOM;
import static stdc.IdName.ColumnName.ID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Apartment extends IdName {
    public static final String TABLE_NAME = "apartment";

    public static class ColumnName {
        public static final String CODE = "code";
        public static final String FLOOR = Floor.TABLE_NAME + "_" + ID;
        public static final String BUILDING = Building.TABLE_NAME + "_" + ID;
    }

    public Apartment() {

    }

    private String code = "";
    private Floor floor = new Floor();
    private Building building = new Building();
    private List<Room> roomList = new ArrayList<>();

    public static class ApartmentRoom {
        @Column(name = TABLE_NAME+"_"+ ID)
        private int apartmentId;
        @Column(name = Room.TABLE_NAME+"_"+ ID)
        private int roomId;

        public int getApartmentId() {
            return apartmentId;
        }
        public void setApartmentId(int apartmentId) {
            this.apartmentId = apartmentId;
        }

        public int getRoomId() {
            return roomId;
        }
        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public int getFloorId() {
        return this.floor.getId();
    }
    public Floor getFloor() {
        return floor;
    }
    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public int getBuildingId() {
        return this.building.getId();
    }
    public Building getBuilding() {
        return building;
    }
    public void setBuilding(Building building) {
        this.building = building;
    }

    public List<Room> getRoomList() {
        return roomList;
    }
    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
    public void addAllRoom(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<ApartmentRoomRecord> createChildRecord(DSLContext db) {
        List<ApartmentRoomRecord> resultList = new ArrayList<>();
        for (Room room : this.getRoomList()) {
            ApartmentRoomRecord childRecord = db.newRecord(APARTMENT_ROOM);
            childRecord.setApartmentId(this.getId());
            childRecord.setRoomId(room.getId());
            resultList.add(childRecord);
        }
        return resultList;
    }

    public void childMap(List<ApartmentRoom> resultChildList, List<Room> roomList) {
        List<ApartmentRoom> childItems = resultChildList.stream().filter(item -> item.getApartmentId() == this.getId()).collect(Collectors.toList());
        for (ApartmentRoom item : childItems) {
            List<Room> roomItems = roomList.stream().filter(p -> p.getId() == item.getRoomId()).collect(Collectors.toList());
            this.addAllRoom(roomItems);
        }
    }
}
