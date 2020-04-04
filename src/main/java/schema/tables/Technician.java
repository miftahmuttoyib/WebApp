/*
 * This file is generated by jOOQ.
 */
package schema.tables;


import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import schema.Indexes;
import schema.Keys;
import schema.Webapp;
import schema.tables.records.TechnicianRecord;


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
public class Technician extends TableImpl<TechnicianRecord> {

    private static final long serialVersionUID = -1134639531;

    /**
     * The reference instance of <code>webapp.technician</code>
     */
    public static final Technician TECHNICIAN = new Technician();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TechnicianRecord> getRecordType() {
        return TechnicianRecord.class;
    }

    /**
     * The column <code>webapp.technician.id</code>.
     */
    public final TableField<TechnicianRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>webapp.technician.name</code>.
     */
    public final TableField<TechnicianRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(150).nullable(false), this, "");

    /**
     * The column <code>webapp.technician.position</code>.
     */
    public final TableField<TechnicianRecord, String> POSITION = createField(DSL.name("position"), org.jooq.impl.SQLDataType.VARCHAR(150).nullable(false), this, "");

    /**
     * The column <code>webapp.technician.availability</code>.
     */
    public final TableField<TechnicianRecord, Byte> AVAILABILITY = createField(DSL.name("availability"), org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("1", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * The column <code>webapp.technician.type</code>.
     */
    public final TableField<TechnicianRecord, String> TYPE = createField(DSL.name("type"), org.jooq.impl.SQLDataType.VARCHAR(1).nullable(false), this, "");

    /**
     * The column <code>webapp.technician.last_working_day</code>.
     */
    public final TableField<TechnicianRecord, Date> LAST_WORKING_DAY = createField(DSL.name("last_working_day"), org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * Create a <code>webapp.technician</code> table reference
     */
    public Technician() {
        this(DSL.name("technician"), null);
    }

    /**
     * Create an aliased <code>webapp.technician</code> table reference
     */
    public Technician(String alias) {
        this(DSL.name(alias), TECHNICIAN);
    }

    /**
     * Create an aliased <code>webapp.technician</code> table reference
     */
    public Technician(Name alias) {
        this(alias, TECHNICIAN);
    }

    private Technician(Name alias, Table<TechnicianRecord> aliased) {
        this(alias, aliased, null);
    }

    private Technician(Name alias, Table<TechnicianRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Technician(Table<O> child, ForeignKey<O, TechnicianRecord> key) {
        super(child, key, TECHNICIAN);
    }

    @Override
    public Schema getSchema() {
        return Webapp.WEBAPP;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TECHNICIAN_PRIMARY);
    }

    @Override
    public Identity<TechnicianRecord, Integer> getIdentity() {
        return Keys.IDENTITY_TECHNICIAN;
    }

    @Override
    public UniqueKey<TechnicianRecord> getPrimaryKey() {
        return Keys.KEY_TECHNICIAN_PRIMARY;
    }

    @Override
    public List<UniqueKey<TechnicianRecord>> getKeys() {
        return Arrays.<UniqueKey<TechnicianRecord>>asList(Keys.KEY_TECHNICIAN_PRIMARY);
    }

    @Override
    public Technician as(String alias) {
        return new Technician(DSL.name(alias), this);
    }

    @Override
    public Technician as(Name alias) {
        return new Technician(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Technician rename(String name) {
        return new Technician(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Technician rename(Name name) {
        return new Technician(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, String, Byte, String, Date> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
