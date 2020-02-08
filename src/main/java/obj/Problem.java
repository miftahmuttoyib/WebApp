package obj;

import stdc.IdName;

public class Problem extends IdName {
    public final static String TABLE_NAME = "problem";
    public static class ColumnName {
        public final static String PRIORITY = "priority";
        public final static String WORKING_TYPE = "working_type";
        public final static String EXECUTION_TIME = "execution_time";
    }

    private int priority;
    private String workingType = "";
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
