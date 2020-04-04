package dao;

import obj.Technician;

import java.sql.Date;
import java.util.List;

import static schema.Tables.TECHNICIAN;

public class TechnicianDAO extends DAO {
    protected List<Technician> getAvailableTechnician(String workingType) {
        Date today = new Date(new java.util.Date().getTime());
        return db.select().from(TECHNICIAN).where(TECHNICIAN.TYPE.eq(workingType).and(TECHNICIAN.LAST_WORKING_DAY.notEqual(today))).fetch().into(Technician.class);
    }
}
