/*
 * This file is generated by jOOQ.
 */
package schema.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
import schema.tables.records.ApartmentRecord;


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
public class Apartment extends TableImpl<ApartmentRecord> {

    private static final long serialVersionUID = 1745210079;

    /**
     * The reference instance of <code>webapp.apartment</code>
     */
    public static final Apartment APARTMENT = new Apartment();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ApartmentRecord> getRecordType() {
        return ApartmentRecord.class;
    }

    /**
     * The column <code>webapp.apartment.id</code>.
     */
    public final TableField<ApartmentRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>webapp.apartment.name</code>.
     */
    public final TableField<ApartmentRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(150).nullable(false), this, "");

    /**
     * Create a <code>webapp.apartment</code> table reference
     */
    public Apartment() {
        this(DSL.name("apartment"), null);
    }

    /**
     * Create an aliased <code>webapp.apartment</code> table reference
     */
    public Apartment(String alias) {
        this(DSL.name(alias), APARTMENT);
    }

    /**
     * Create an aliased <code>webapp.apartment</code> table reference
     */
    public Apartment(Name alias) {
        this(alias, APARTMENT);
    }

    private Apartment(Name alias, Table<ApartmentRecord> aliased) {
        this(alias, aliased, null);
    }

    private Apartment(Name alias, Table<ApartmentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Apartment(Table<O> child, ForeignKey<O, ApartmentRecord> key) {
        super(child, key, APARTMENT);
    }

    @Override
    public Schema getSchema() {
        return Webapp.WEBAPP;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.APARTMENT_PRIMARY);
    }

    @Override
    public UniqueKey<ApartmentRecord> getPrimaryKey() {
        return Keys.KEY_APARTMENT_PRIMARY;
    }

    @Override
    public List<UniqueKey<ApartmentRecord>> getKeys() {
        return Arrays.<UniqueKey<ApartmentRecord>>asList(Keys.KEY_APARTMENT_PRIMARY);
    }

    @Override
    public Apartment as(String alias) {
        return new Apartment(DSL.name(alias), this);
    }

    @Override
    public Apartment as(Name alias) {
        return new Apartment(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Apartment rename(String name) {
        return new Apartment(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Apartment rename(Name name) {
        return new Apartment(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}