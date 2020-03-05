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
import schema.tables.records.FloorApartmentRecord;


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
public class FloorApartment extends TableImpl<FloorApartmentRecord> {

    private static final long serialVersionUID = -1983542797;

    /**
     * The reference instance of <code>webapp.floor_apartment</code>
     */
    public static final FloorApartment FLOOR_APARTMENT = new FloorApartment();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FloorApartmentRecord> getRecordType() {
        return FloorApartmentRecord.class;
    }

    /**
     * The column <code>webapp.floor_apartment.floor_id</code>.
     */
    public final TableField<FloorApartmentRecord, Integer> FLOOR_ID = createField(DSL.name("floor_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>webapp.floor_apartment.apartment_id</code>.
     */
    public final TableField<FloorApartmentRecord, Integer> APARTMENT_ID = createField(DSL.name("apartment_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>webapp.floor_apartment</code> table reference
     */
    public FloorApartment() {
        this(DSL.name("floor_apartment"), null);
    }

    /**
     * Create an aliased <code>webapp.floor_apartment</code> table reference
     */
    public FloorApartment(String alias) {
        this(DSL.name(alias), FLOOR_APARTMENT);
    }

    /**
     * Create an aliased <code>webapp.floor_apartment</code> table reference
     */
    public FloorApartment(Name alias) {
        this(alias, FLOOR_APARTMENT);
    }

    private FloorApartment(Name alias, Table<FloorApartmentRecord> aliased) {
        this(alias, aliased, null);
    }

    private FloorApartment(Name alias, Table<FloorApartmentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> FloorApartment(Table<O> child, ForeignKey<O, FloorApartmentRecord> key) {
        super(child, key, FLOOR_APARTMENT);
    }

    @Override
    public Schema getSchema() {
        return Webapp.WEBAPP;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.FLOOR_APARTMENT_APARTMENT_ID, Indexes.FLOOR_APARTMENT_PRIMARY);
    }

    @Override
    public UniqueKey<FloorApartmentRecord> getPrimaryKey() {
        return Keys.KEY_FLOOR_APARTMENT_PRIMARY;
    }

    @Override
    public List<UniqueKey<FloorApartmentRecord>> getKeys() {
        return Arrays.<UniqueKey<FloorApartmentRecord>>asList(Keys.KEY_FLOOR_APARTMENT_PRIMARY);
    }

    @Override
    public List<ForeignKey<FloorApartmentRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<FloorApartmentRecord, ?>>asList(Keys.FLOOR_APARTMENT_IBFK_1, Keys.FLOOR_APARTMENT_IBFK_2);
    }

    public Floor floor() {
        return new Floor(this, Keys.FLOOR_APARTMENT_IBFK_1);
    }

    public Apartment apartment() {
        return new Apartment(this, Keys.FLOOR_APARTMENT_IBFK_2);
    }

    @Override
    public FloorApartment as(String alias) {
        return new FloorApartment(DSL.name(alias), this);
    }

    @Override
    public FloorApartment as(Name alias) {
        return new FloorApartment(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FloorApartment rename(String name) {
        return new FloorApartment(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FloorApartment rename(Name name) {
        return new FloorApartment(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
