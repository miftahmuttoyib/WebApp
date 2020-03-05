/*
 * This file is generated by jOOQ.
 */
package schema.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import schema.Indexes;
import schema.Keys;
import schema.Webapp;
import schema.tables.records.BuildingRecord;


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
public class Building extends TableImpl<BuildingRecord> {

    private static final long serialVersionUID = 194589004;

    /**
     * The reference instance of <code>webapp.building</code>
     */
    public static final Building BUILDING = new Building();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BuildingRecord> getRecordType() {
        return BuildingRecord.class;
    }

    /**
     * The column <code>webapp.building.id</code>.
     */
    public final TableField<BuildingRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>webapp.building.name</code>.
     */
    public final TableField<BuildingRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(150).nullable(false), this, "");

    /**
     * Create a <code>webapp.building</code> table reference
     */
    public Building() {
        this(DSL.name("building"), null);
    }

    /**
     * Create an aliased <code>webapp.building</code> table reference
     */
    public Building(String alias) {
        this(DSL.name(alias), BUILDING);
    }

    /**
     * Create an aliased <code>webapp.building</code> table reference
     */
    public Building(Name alias) {
        this(alias, BUILDING);
    }

    private Building(Name alias, Table<BuildingRecord> aliased) {
        this(alias, aliased, null);
    }

    private Building(Name alias, Table<BuildingRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Building(Table<O> child, ForeignKey<O, BuildingRecord> key) {
        super(child, key, BUILDING);
    }

    @Override
    public Schema getSchema() {
        return Webapp.WEBAPP;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.BUILDING_PRIMARY);
    }

    @Override
    public Identity<BuildingRecord, Integer> getIdentity() {
        return Keys.IDENTITY_BUILDING;
    }

    @Override
    public UniqueKey<BuildingRecord> getPrimaryKey() {
        return Keys.KEY_BUILDING_PRIMARY;
    }

    @Override
    public List<UniqueKey<BuildingRecord>> getKeys() {
        return Arrays.<UniqueKey<BuildingRecord>>asList(Keys.KEY_BUILDING_PRIMARY);
    }

    @Override
    public Building as(String alias) {
        return new Building(DSL.name(alias), this);
    }

    @Override
    public Building as(Name alias) {
        return new Building(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Building rename(String name) {
        return new Building(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Building rename(Name name) {
        return new Building(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}