package dao;

import obj.Technician;
import org.jooq.Batch;
import schema.tables.records.TechnicianRecord;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static schema.Tables.TECHNICIAN;

public class TechnicianDAO extends DAO {
    protected List<Technician> getAvailableTechnician(String workingType) {
        openConnection();
        Date today = new Date(new java.util.Date().getTime());
        List<Technician> result = db.select().from(TECHNICIAN).where(TECHNICIAN.TYPE.eq(workingType).and(TECHNICIAN.LAST_WORKING_DAY.notEqual(today)).and(TECHNICIAN.AVAILABILITY.eq((byte) 1))).fetch().into(Technician.class);
        closeConnection();
        return result;
    }

    protected List<Technician> getAll() {
        openConnection();
        List<Technician> result = db.select().from(TECHNICIAN).fetch().into(Technician.class);
        closeConnection();
        return result;
    }

    protected void update(List<Technician> technicianList) {
        openConnection();
        List<TechnicianRecord> newRecords = new ArrayList<>();
        for (Technician technician : technicianList) {
            newRecords.add(db.newRecord(TECHNICIAN, technician));
        }
        Batch batch = db.batchUpdate(newRecords);
        batch.execute();
        closeConnection();
    }
}
