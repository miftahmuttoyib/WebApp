/*
 * This file is generated by jOOQ.
 */
package schema.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;

import schema.tables.FacilitiesProblem;


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
public class FacilitiesProblemRecord extends UpdatableRecordImpl<FacilitiesProblemRecord> implements Record2<Integer, Integer> {

    private static final long serialVersionUID = 1863629716;

    /**
     * Setter for <code>webapp.facilities_problem.facilities_id</code>.
     */
    public void setFacilitiesId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>webapp.facilities_problem.facilities_id</code>.
     */
    public Integer getFacilitiesId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>webapp.facilities_problem.problem_id</code>.
     */
    public void setProblemId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>webapp.facilities_problem.problem_id</code>.
     */
    public Integer getProblemId() {
        return (Integer) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Integer, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return FacilitiesProblem.FACILITIES_PROBLEM.FACILITIES_ID;
    }

    @Override
    public Field<Integer> field2() {
        return FacilitiesProblem.FACILITIES_PROBLEM.PROBLEM_ID;
    }

    @Override
    public Integer component1() {
        return getFacilitiesId();
    }

    @Override
    public Integer component2() {
        return getProblemId();
    }

    @Override
    public Integer value1() {
        return getFacilitiesId();
    }

    @Override
    public Integer value2() {
        return getProblemId();
    }

    @Override
    public FacilitiesProblemRecord value1(Integer value) {
        setFacilitiesId(value);
        return this;
    }

    @Override
    public FacilitiesProblemRecord value2(Integer value) {
        setProblemId(value);
        return this;
    }

    @Override
    public FacilitiesProblemRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FacilitiesProblemRecord
     */
    public FacilitiesProblemRecord() {
        super(FacilitiesProblem.FACILITIES_PROBLEM);
    }

    /**
     * Create a detached, initialised FacilitiesProblemRecord
     */
    public FacilitiesProblemRecord(Integer facilitiesId, Integer problemId) {
        super(FacilitiesProblem.FACILITIES_PROBLEM);

        set(0, facilitiesId);
        set(1, problemId);
    }
}
