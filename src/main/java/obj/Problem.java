package obj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import schema.tables.records.ProblemRecord;
import stdc.IdName;

import javax.persistence.Column;

import static stdc.IdName.ColumnName.ID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Problem extends IdName {
    public static final String TABLE_NAME = "problem";
    public static final String FOREIGN_KEY_NAME = TABLE_NAME + "_" + ID;

    public static final class ColumnName {
        public final static String PRIORITY = "priority";
        public final static String WORKING_TYPE = "working_type";
        public final static String EXECUTION_TIME = "execution_time";
        public final static String MANPOWER = "manpower";
    }

    @Column(name = ColumnName.PRIORITY)
    private int priority;
    @Column(name = ColumnName.WORKING_TYPE)
    private String workingType = "";
    @Column(name = ColumnName.EXECUTION_TIME)
    private int executionTime;
    @Column(name = ColumnName.MANPOWER)
    private int manpower;

    public Problem() {

    }
    public Problem(String id) {
        setStringId(id);
    }

    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getWorkingType() {
        return workingType;
    }
    public void setWorkingType(String workingType) {
        this.workingType = workingType;
    }

    public int getExecutionTime() {
        return executionTime;
    }
    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public int getManpower() {
        return manpower;
    }
    public void setManpower(int manpower) {
        this.manpower = manpower;
    }

    /**
     * @param emptyRecord modified here.
     *                    pass by reference
     */
    public void mapToRecord(ProblemRecord emptyRecord) {
        emptyRecord.setId(this.getId());
        emptyRecord.setName(this.getName());
        emptyRecord.setPriority(this.getPriority());
        emptyRecord.setWorkingType(this.getWorkingType());
        emptyRecord.setExecutionTime(this.getExecutionTime());
    }
}
