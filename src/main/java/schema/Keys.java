/*
 * This file is generated by jOOQ.
 */
package schema;


import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;

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
import schema.tables.records.ApartmentRecord;
import schema.tables.records.ApartmentRoomRecord;
import schema.tables.records.BuildingFloorRecord;
import schema.tables.records.BuildingRecord;
import schema.tables.records.FacilitiesProblemRecord;
import schema.tables.records.FacilitiesRecord;
import schema.tables.records.FloorApartmentRecord;
import schema.tables.records.FloorRecord;
import schema.tables.records.ProblemRecord;
import schema.tables.records.RoomFacilitiesRecord;
import schema.tables.records.RoomRecord;
import schema.tables.records.UserRecord;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>webapp</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<BuildingRecord, Integer> IDENTITY_BUILDING = Identities0.IDENTITY_BUILDING;
    public static final Identity<FacilitiesRecord, Integer> IDENTITY_FACILITIES = Identities0.IDENTITY_FACILITIES;
    public static final Identity<FloorRecord, Integer> IDENTITY_FLOOR = Identities0.IDENTITY_FLOOR;
    public static final Identity<ProblemRecord, Integer> IDENTITY_PROBLEM = Identities0.IDENTITY_PROBLEM;
    public static final Identity<RoomRecord, Integer> IDENTITY_ROOM = Identities0.IDENTITY_ROOM;
    public static final Identity<UserRecord, Integer> IDENTITY_USER = Identities0.IDENTITY_USER;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ApartmentRecord> KEY_APARTMENT_PRIMARY = UniqueKeys0.KEY_APARTMENT_PRIMARY;
    public static final UniqueKey<ApartmentRoomRecord> KEY_APARTMENT_ROOM_PRIMARY = UniqueKeys0.KEY_APARTMENT_ROOM_PRIMARY;
    public static final UniqueKey<BuildingRecord> KEY_BUILDING_PRIMARY = UniqueKeys0.KEY_BUILDING_PRIMARY;
    public static final UniqueKey<BuildingFloorRecord> KEY_BUILDING_FLOOR_PRIMARY = UniqueKeys0.KEY_BUILDING_FLOOR_PRIMARY;
    public static final UniqueKey<FacilitiesRecord> KEY_FACILITIES_PRIMARY = UniqueKeys0.KEY_FACILITIES_PRIMARY;
    public static final UniqueKey<FacilitiesProblemRecord> KEY_FACILITIES_PROBLEM_PRIMARY = UniqueKeys0.KEY_FACILITIES_PROBLEM_PRIMARY;
    public static final UniqueKey<FloorRecord> KEY_FLOOR_PRIMARY = UniqueKeys0.KEY_FLOOR_PRIMARY;
    public static final UniqueKey<FloorApartmentRecord> KEY_FLOOR_APARTMENT_PRIMARY = UniqueKeys0.KEY_FLOOR_APARTMENT_PRIMARY;
    public static final UniqueKey<ProblemRecord> KEY_PROBLEM_PRIMARY = UniqueKeys0.KEY_PROBLEM_PRIMARY;
    public static final UniqueKey<RoomRecord> KEY_ROOM_PRIMARY = UniqueKeys0.KEY_ROOM_PRIMARY;
    public static final UniqueKey<RoomFacilitiesRecord> KEY_ROOM_FACILITIES_PRIMARY = UniqueKeys0.KEY_ROOM_FACILITIES_PRIMARY;
    public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = UniqueKeys0.KEY_USER_PRIMARY;
    public static final UniqueKey<UserRecord> KEY_USER_USERNAME = UniqueKeys0.KEY_USER_USERNAME;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ApartmentRoomRecord, ApartmentRecord> APARTMENT_ROOM_IBFK_1 = ForeignKeys0.APARTMENT_ROOM_IBFK_1;
    public static final ForeignKey<ApartmentRoomRecord, RoomRecord> APARTMENT_ROOM_IBFK_2 = ForeignKeys0.APARTMENT_ROOM_IBFK_2;
    public static final ForeignKey<BuildingFloorRecord, BuildingRecord> BUILDING_FLOOR_IBFK_1 = ForeignKeys0.BUILDING_FLOOR_IBFK_1;
    public static final ForeignKey<BuildingFloorRecord, FloorRecord> BUILDING_FLOOR_IBFK_2 = ForeignKeys0.BUILDING_FLOOR_IBFK_2;
    public static final ForeignKey<FacilitiesProblemRecord, FacilitiesRecord> FACILITIES_PROBLEM_IBFK_1 = ForeignKeys0.FACILITIES_PROBLEM_IBFK_1;
    public static final ForeignKey<FacilitiesProblemRecord, ProblemRecord> FACILITIES_PROBLEM_IBFK_2 = ForeignKeys0.FACILITIES_PROBLEM_IBFK_2;
    public static final ForeignKey<FloorApartmentRecord, FloorRecord> FLOOR_APARTMENT_IBFK_1 = ForeignKeys0.FLOOR_APARTMENT_IBFK_1;
    public static final ForeignKey<FloorApartmentRecord, ApartmentRecord> FLOOR_APARTMENT_IBFK_2 = ForeignKeys0.FLOOR_APARTMENT_IBFK_2;
    public static final ForeignKey<RoomFacilitiesRecord, RoomRecord> ROOM_FACILITIES_IBFK_1 = ForeignKeys0.ROOM_FACILITIES_IBFK_1;
    public static final ForeignKey<RoomFacilitiesRecord, FacilitiesRecord> ROOM_FACILITIES_IBFK_2 = ForeignKeys0.ROOM_FACILITIES_IBFK_2;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<BuildingRecord, Integer> IDENTITY_BUILDING = Internal.createIdentity(Building.BUILDING, Building.BUILDING.ID);
        public static Identity<FacilitiesRecord, Integer> IDENTITY_FACILITIES = Internal.createIdentity(Facilities.FACILITIES, Facilities.FACILITIES.ID);
        public static Identity<FloorRecord, Integer> IDENTITY_FLOOR = Internal.createIdentity(Floor.FLOOR, Floor.FLOOR.ID);
        public static Identity<ProblemRecord, Integer> IDENTITY_PROBLEM = Internal.createIdentity(Problem.PROBLEM, Problem.PROBLEM.ID);
        public static Identity<RoomRecord, Integer> IDENTITY_ROOM = Internal.createIdentity(Room.ROOM, Room.ROOM.ID);
        public static Identity<UserRecord, Integer> IDENTITY_USER = Internal.createIdentity(User.USER, User.USER.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<ApartmentRecord> KEY_APARTMENT_PRIMARY = Internal.createUniqueKey(Apartment.APARTMENT, "KEY_apartment_PRIMARY", Apartment.APARTMENT.ID);
        public static final UniqueKey<ApartmentRoomRecord> KEY_APARTMENT_ROOM_PRIMARY = Internal.createUniqueKey(ApartmentRoom.APARTMENT_ROOM, "KEY_apartment_room_PRIMARY", ApartmentRoom.APARTMENT_ROOM.APARTMENT_ID, ApartmentRoom.APARTMENT_ROOM.ROOM_ID);
        public static final UniqueKey<BuildingRecord> KEY_BUILDING_PRIMARY = Internal.createUniqueKey(Building.BUILDING, "KEY_building_PRIMARY", Building.BUILDING.ID);
        public static final UniqueKey<BuildingFloorRecord> KEY_BUILDING_FLOOR_PRIMARY = Internal.createUniqueKey(BuildingFloor.BUILDING_FLOOR, "KEY_building_floor_PRIMARY", BuildingFloor.BUILDING_FLOOR.BUILDING_ID, BuildingFloor.BUILDING_FLOOR.FLOOR_ID);
        public static final UniqueKey<FacilitiesRecord> KEY_FACILITIES_PRIMARY = Internal.createUniqueKey(Facilities.FACILITIES, "KEY_facilities_PRIMARY", Facilities.FACILITIES.ID);
        public static final UniqueKey<FacilitiesProblemRecord> KEY_FACILITIES_PROBLEM_PRIMARY = Internal.createUniqueKey(FacilitiesProblem.FACILITIES_PROBLEM, "KEY_facilities_problem_PRIMARY", FacilitiesProblem.FACILITIES_PROBLEM.FACILITIES_ID, FacilitiesProblem.FACILITIES_PROBLEM.PROBLEM_ID);
        public static final UniqueKey<FloorRecord> KEY_FLOOR_PRIMARY = Internal.createUniqueKey(Floor.FLOOR, "KEY_floor_PRIMARY", Floor.FLOOR.ID);
        public static final UniqueKey<FloorApartmentRecord> KEY_FLOOR_APARTMENT_PRIMARY = Internal.createUniqueKey(FloorApartment.FLOOR_APARTMENT, "KEY_floor_apartment_PRIMARY", FloorApartment.FLOOR_APARTMENT.FLOOR_ID, FloorApartment.FLOOR_APARTMENT.APARTMENT_ID);
        public static final UniqueKey<ProblemRecord> KEY_PROBLEM_PRIMARY = Internal.createUniqueKey(Problem.PROBLEM, "KEY_problem_PRIMARY", Problem.PROBLEM.ID);
        public static final UniqueKey<RoomRecord> KEY_ROOM_PRIMARY = Internal.createUniqueKey(Room.ROOM, "KEY_room_PRIMARY", Room.ROOM.ID);
        public static final UniqueKey<RoomFacilitiesRecord> KEY_ROOM_FACILITIES_PRIMARY = Internal.createUniqueKey(RoomFacilities.ROOM_FACILITIES, "KEY_room_facilities_PRIMARY", RoomFacilities.ROOM_FACILITIES.ROOM_ID, RoomFacilities.ROOM_FACILITIES.FACILITIES_ID);
        public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = Internal.createUniqueKey(User.USER, "KEY_user_PRIMARY", User.USER.ID);
        public static final UniqueKey<UserRecord> KEY_USER_USERNAME = Internal.createUniqueKey(User.USER, "KEY_user_username", User.USER.USERNAME);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<ApartmentRoomRecord, ApartmentRecord> APARTMENT_ROOM_IBFK_1 = Internal.createForeignKey(schema.Keys.KEY_APARTMENT_PRIMARY, ApartmentRoom.APARTMENT_ROOM, "apartment_room_ibfk_1", ApartmentRoom.APARTMENT_ROOM.APARTMENT_ID);
        public static final ForeignKey<ApartmentRoomRecord, RoomRecord> APARTMENT_ROOM_IBFK_2 = Internal.createForeignKey(schema.Keys.KEY_ROOM_PRIMARY, ApartmentRoom.APARTMENT_ROOM, "apartment_room_ibfk_2", ApartmentRoom.APARTMENT_ROOM.ROOM_ID);
        public static final ForeignKey<BuildingFloorRecord, BuildingRecord> BUILDING_FLOOR_IBFK_1 = Internal.createForeignKey(schema.Keys.KEY_BUILDING_PRIMARY, BuildingFloor.BUILDING_FLOOR, "building_floor_ibfk_1", BuildingFloor.BUILDING_FLOOR.BUILDING_ID);
        public static final ForeignKey<BuildingFloorRecord, FloorRecord> BUILDING_FLOOR_IBFK_2 = Internal.createForeignKey(schema.Keys.KEY_FLOOR_PRIMARY, BuildingFloor.BUILDING_FLOOR, "building_floor_ibfk_2", BuildingFloor.BUILDING_FLOOR.FLOOR_ID);
        public static final ForeignKey<FacilitiesProblemRecord, FacilitiesRecord> FACILITIES_PROBLEM_IBFK_1 = Internal.createForeignKey(schema.Keys.KEY_FACILITIES_PRIMARY, FacilitiesProblem.FACILITIES_PROBLEM, "facilities_problem_ibfk_1", FacilitiesProblem.FACILITIES_PROBLEM.FACILITIES_ID);
        public static final ForeignKey<FacilitiesProblemRecord, ProblemRecord> FACILITIES_PROBLEM_IBFK_2 = Internal.createForeignKey(schema.Keys.KEY_PROBLEM_PRIMARY, FacilitiesProblem.FACILITIES_PROBLEM, "facilities_problem_ibfk_2", FacilitiesProblem.FACILITIES_PROBLEM.PROBLEM_ID);
        public static final ForeignKey<FloorApartmentRecord, FloorRecord> FLOOR_APARTMENT_IBFK_1 = Internal.createForeignKey(schema.Keys.KEY_FLOOR_PRIMARY, FloorApartment.FLOOR_APARTMENT, "floor_apartment_ibfk_1", FloorApartment.FLOOR_APARTMENT.FLOOR_ID);
        public static final ForeignKey<FloorApartmentRecord, ApartmentRecord> FLOOR_APARTMENT_IBFK_2 = Internal.createForeignKey(schema.Keys.KEY_APARTMENT_PRIMARY, FloorApartment.FLOOR_APARTMENT, "floor_apartment_ibfk_2", FloorApartment.FLOOR_APARTMENT.APARTMENT_ID);
        public static final ForeignKey<RoomFacilitiesRecord, RoomRecord> ROOM_FACILITIES_IBFK_1 = Internal.createForeignKey(schema.Keys.KEY_ROOM_PRIMARY, RoomFacilities.ROOM_FACILITIES, "room_facilities_ibfk_1", RoomFacilities.ROOM_FACILITIES.ROOM_ID);
        public static final ForeignKey<RoomFacilitiesRecord, FacilitiesRecord> ROOM_FACILITIES_IBFK_2 = Internal.createForeignKey(schema.Keys.KEY_FACILITIES_PRIMARY, RoomFacilities.ROOM_FACILITIES, "room_facilities_ibfk_2", RoomFacilities.ROOM_FACILITIES.FACILITIES_ID);
    }
}