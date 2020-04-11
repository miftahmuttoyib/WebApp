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
        Date today = new Date(new java.util.Date().getTime());
        return db.select().from(TECHNICIAN).where(TECHNICIAN.TYPE.eq(workingType).and(TECHNICIAN.LAST_WORKING_DAY.notEqual(today))).fetch().into(Technician.class);
    }

    protected List<Technician> getAll() {
        return db.select().from(TECHNICIAN).fetch().into(Technician.class);
    }

    protected void update(List<Technician> technicianList) {
        List<TechnicianRecord> newRecords = new ArrayList<>();
        for (Technician technician : technicianList) {
            newRecords.add(db.newRecord(TECHNICIAN, technician));
        }
        Batch batch = db.batchStore(newRecords);
        batch.execute();
    }
}
