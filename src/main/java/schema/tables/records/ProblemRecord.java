/*
 * This file is generated by jOOQ.
 */
package schema.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;

import schema.tables.Problem;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProblemRecord extends UpdatableRecordImpl<ProblemRecord> implements Record5<Integer, String, Integer, String, Integer> {

    private static final long serialVersionUID = -1376232707;

    /**
     * Setter for <code>webapp.problem.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>webapp.problem.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>webapp.problem.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>webapp.problem.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>webapp.problem.priority</code>.
     */
    public void setPriority(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>webapp.problem.priority</code>.
     */
    public Integer getPriority() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>webapp.problem.working_type</code>.
     */
    public void setWorkingType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>webapp.problem.working_type</code>.
     */
    public String getWorkingType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>webapp.problem.execution_time</code>.
     */
    public void setExecutionTime(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>webapp.problem.execution_time</code>.
     */
    public Integer getExecutionTime() {
        return (Integer) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, Integer, String, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, String, Integer, String, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Problem.PROBLEM.ID;
    }

    @Override
    public Field<String> field2() {
        return Problem.PROBLEM.NAME;
    }

    @Override
    public Field<Integer> field3() {
        return Problem.PROBLEM.PRIORITY;
    }

    @Override
    public Field<String> field4() {
        return Problem.PROBLEM.WORKING_TYPE;
    }

    @Override
    public Field<Integer> field5() {
        return Problem.PROBLEM.EXECUTION_TIME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Integer component3() {
        return getPriority();
    }

    @Override
    public String component4() {
        return getWorkingType();
    }

    @Override
    public Integer component5() {
        return getExecutionTime();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public Integer value3() {
        return getPriority();
    }

    @Override
    public String value4() {
        return getWorkingType();
    }

    @Override
    public Integer value5() {
        return getExecutionTime();
    }

    @Override
    public ProblemRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public ProblemRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public ProblemRecord value3(Integer value) {
        setPriority(value);
        return this;
    }

    @Override
    public ProblemRecord value4(String value) {
        setWorkingType(value);
        return this;
    }

    @Override
    public ProblemRecord value5(Integer value) {
        setExecutionTime(value);
        return this;
    }

    @Override
    public ProblemRecord values(Integer value1, String value2, Integer value3, String value4, Integer value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProblemRecord
     */
    public ProblemRecord() {
        super(Problem.PROBLEM);
    }

    /**
     * Create a detached, initialised ProblemRecord
     */
    public ProblemRecord(Integer id, String name, Integer priority, String workingType, Integer executionTime) {
        super(Problem.PROBLEM);

        set(0, id);
        set(1, name);
        set(2, priority);
        set(3, workingType);
        set(4, executionTime);
    }
}