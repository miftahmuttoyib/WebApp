package obj;

import helper.Position;
import stdc.IdName;

import javax.persistence.Column;

import java.sql.Date;

import static stdc.IdName.ColumnName.ID;

public class Technician extends IdName {
    public static final String TABLE_NAME = "facilities";
    public static final String FOREIGN_KEY_NAME = TABLE_NAME + "_" + ID;

    public static final class ColumnName {
        public final static String POSITION = "position";
        public final static String AVAILABILITY = "availability";
        public final static String TYPE = "type";
        public final static String LAST_WORKING_DAY = "last_working_day";
    }

    public Technician() {

    }

    @Column(name = ColumnName.POSITION)
    private Position position;
    @Column(name = ColumnName.AVAILABILITY)
    private boolean availability = true;
    @Column(name = ColumnName.TYPE)
    private String type = "";
    @Column(name = ColumnName.LAST_WORKING_DAY)
    private Date lastWorkingDate;


    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Date getLastWorkingDate() {
        return lastWorkingDate;
    }
    public void setLastWorkingDate(Date lastWorkingDate) {
        this.lastWorkingDate = lastWorkingDate;
    }
}
