package obj;

import stdc.IdName;

import javax.persistence.Column;

public class Problem extends IdName {
    public final static String TABLE_NAME = "problem";
    public static class ColumnName {
        public final static String PRIORITY = "priority";
        public final static String WORKING_TYPE = "working_type";
        public final static String EXECUTION_TIME = "execution_time";
    }

    @Column(name = ColumnName.PRIORITY)
    private int priority;
    @Column(name = ColumnName.WORKING_TYPE)
    private String workingType = "";
    @Column(name = ColumnName.EXECUTION_TIME)
    private int executionTime;

    public Problem() {

    }
    public Problem(String id) {
        setId(id);
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
}
