/*
 * This file is generated by jOOQ.
 */
package schema;


import javax.annotation.Generated;

import schema.tables.Apartment;
import schema.tables.ApartmentRoom;
import schema.tables.Building;
import schema.tables.BuildingFloor;
import schema.tables.Facilities;
import schema.tables.FacilitiesProblem;
import schema.tables.Floor;
import schema.tables.FloorApartment;
import schema.tables.Problem;
import schema.tables.Room;
import schema.tables.RoomFacilities;
import schema.tables.User;


/**
 * Convenience access to all tables in webapp
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>webapp.apartment</code>.
     */
    public static final Apartment APARTMENT = Apartment.APARTMENT;

    /**
     * The table <code>webapp.apartment_room</code>.
     */
    public static final ApartmentRoom APARTMENT_ROOM = ApartmentRoom.APARTMENT_ROOM;

    /**
     * The table <code>webapp.building</code>.
     */
    public static final Building BUILDING = Building.BUILDING;

    /**
     * The table <code>webapp.building_floor</code>.
     */
    public static final BuildingFloor BUILDING_FLOOR = BuildingFloor.BUILDING_FLOOR;

    /**
     * The table <code>webapp.facilities</code>.
     */
    public static final Facilities FACILITIES = Facilities.FACILITIES;

    /**
     * The table <code>webapp.facilities_problem</code>.
     */
    public static final FacilitiesProblem FACILITIES_PROBLEM = FacilitiesProblem.FACILITIES_PROBLEM;

    /**
     * The table <code>webapp.floor</code>.
     */
    public static final Floor FLOOR = Floor.FLOOR;

    /**
     * The table <code>webapp.floor_apartment</code>.
     */
    public static final FloorApartment FLOOR_APARTMENT = FloorApartment.FLOOR_APARTMENT;

    /**
     * The table <code>webapp.problem</code>.
     */
    public static final Problem PROBLEM = Problem.PROBLEM;

    /**
     * The table <code>webapp.room</code>.
     */
    public static final Room ROOM = Room.ROOM;

    /**
     * The table <code>webapp.room_facilities</code>.
     */
    public static final RoomFacilities ROOM_FACILITIES = RoomFacilities.ROOM_FACILITIES;

    /**
     * The table <code>webapp.user</code>.
     */
    public static final User USER = User.USER;
}
