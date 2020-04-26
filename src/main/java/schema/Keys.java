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
import schema.tables.Complaint;
import schema.tables.ComplaintTeam;
import schema.tables.Facilities;
import schema.tables.FacilitiesProblem;
import schema.tables.Floor;
import schema.tables.Problem;
import schema.tables.Room;
import schema.tables.RoomFacilities;
import schema.tables.Technician;
import schema.tables.User;
import schema.tables.records.ApartmentRecord;
import schema.tables.records.ApartmentRoomRecord;
import schema.tables.records.BuildingRecord;
import schema.tables.records.ComplaintRecord;
import schema.tables.records.ComplaintTeamRecord;
import schema.tables.records.FacilitiesProblemRecord;
import schema.tables.records.FacilitiesRecord;
import schema.tables.records.FloorRecord;
import schema.tables.records.ProblemRecord;
import schema.tables.records.RoomFacilitiesRecord;
import schema.tables.records.RoomRecord;
import schema.tables.records.TechnicianRecord;
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

    public static final Identity<ApartmentRecord, Integer> IDENTITY_APARTMENT = Identities0.IDENTITY_APARTMENT;
    public static final Identity<BuildingRecord, Integer> IDENTITY_BUILDING = Identities0.IDENTITY_BUILDING;
    public static final Identity<ComplaintRecord, Integer> IDENTITY_COMPLAINT = Identities0.IDENTITY_COMPLAINT;
    public static final Identity<FacilitiesRecord, Integer> IDENTITY_FACILITIES = Identities0.IDENTITY_FACILITIES;
    public static final Identity<FloorRecord, Integer> IDENTITY_FLOOR = Identities0.IDENTITY_FLOOR;
    public static final Identity<ProblemRecord, Integer> IDENTITY_PROBLEM = Identities0.IDENTITY_PROBLEM;
    public static final Identity<RoomRecord, Integer> IDENTITY_ROOM = Identities0.IDENTITY_ROOM;
    public static final Identity<TechnicianRecord, Integer> IDENTITY_TECHNICIAN = Identities0.IDENTITY_TECHNICIAN;
    public static final Identity<UserRecord, Integer> IDENTITY_USER = Identities0.IDENTITY_USER;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ApartmentRecord> KEY_APARTMENT_PRIMARY = UniqueKeys0.KEY_APARTMENT_PRIMARY;
    public static final UniqueKey<ApartmentRecord> KEY_APARTMENT_CODE_UNIQUE = UniqueKeys0.KEY_APARTMENT_CODE_UNIQUE;
    public static final UniqueKey<ApartmentRoomRecord> KEY_APARTMENT_ROOM_PRIMARY = UniqueKeys0.KEY_APARTMENT_ROOM_PRIMARY;
    public static final UniqueKey<BuildingRecord> KEY_BUILDING_PRIMARY = UniqueKeys0.KEY_BUILDING_PRIMARY;
    public static final UniqueKey<BuildingRecord> KEY_BUILDING_CODE_UNIQUE = UniqueKeys0.KEY_BUILDING_CODE_UNIQUE;
    public static final UniqueKey<ComplaintRecord> KEY_COMPLAINT_PRIMARY = UniqueKeys0.KEY_COMPLAINT_PRIMARY;
    public static final UniqueKey<ComplaintTeamRecord> KEY_COMPLAINT_TEAM_PRIMARY = UniqueKeys0.KEY_COMPLAINT_TEAM_PRIMARY;
    public static final UniqueKey<FacilitiesRecord> KEY_FACILITIES_PRIMARY = UniqueKeys0.KEY_FACILITIES_PRIMARY;
    public static final UniqueKey<FacilitiesProblemRecord> KEY_FACILITIES_PROBLEM_PRIMARY = UniqueKeys0.KEY_FACILITIES_PROBLEM_PRIMARY;
    public static final UniqueKey<FloorRecord> KEY_FLOOR_PRIMARY = UniqueKeys0.KEY_FLOOR_PRIMARY;
    public static final UniqueKey<FloorRecord> KEY_FLOOR_CODE_UNIQUE = UniqueKeys0.KEY_FLOOR_CODE_UNIQUE;
    public static final UniqueKey<ProblemRecord> KEY_PROBLEM_PRIMARY = UniqueKeys0.KEY_PROBLEM_PRIMARY;
    public static final UniqueKey<RoomRecord> KEY_ROOM_PRIMARY = UniqueKeys0.KEY_ROOM_PRIMARY;
    public static final UniqueKey<RoomFacilitiesRecord> KEY_ROOM_FACILITIES_PRIMARY = UniqueKeys0.KEY_ROOM_FACILITIES_PRIMARY;
    public static final UniqueKey<TechnicianRecord> KEY_TECHNICIAN_PRIMARY = UniqueKeys0.KEY_TECHNICIAN_PRIMARY;
    public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = UniqueKeys0.KEY_USER_PRIMARY;
    public static final UniqueKey<UserRecord> KEY_USER_USERNAME = UniqueKeys0.KEY_USER_USERNAME;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ApartmentRecord, BuildingRecord> APARTMENT_IBFK_1 = ForeignKeys0.APARTMENT_IBFK_1;
    public static final ForeignKey<ApartmentRecord, FloorRecord> APARTMENT_IBFK_2 = ForeignKeys0.APARTMENT_IBFK_2;
    public static final ForeignKey<ApartmentRoomRecord, ApartmentRecord> APARTMENT_ROOM_IBFK_1 = ForeignKeys0.APARTMENT_ROOM_IBFK_1;
    public static final ForeignKey<ApartmentRoomRecord, RoomRecord> APARTMENT_ROOM_IBFK_2 = ForeignKeys0.APARTMENT_ROOM_IBFK_2;
    public static final ForeignKey<ComplaintRecord, UserRecord> COMPLAINT_IBFK_1 = ForeignKeys0.COMPLAINT_IBFK_1;
    public static final ForeignKey<ComplaintRecord, ApartmentRecord> COMPLAINT_IBFK_2 = ForeignKeys0.COMPLAINT_IBFK_2;
    public static final ForeignKey<ComplaintRecord, ProblemRecord> COMPLAINT_IBFK_3 = ForeignKeys0.COMPLAINT_IBFK_3;
    public static final ForeignKey<ComplaintRecord, FacilitiesRecord> COMPLAINT_IBFK_4 = ForeignKeys0.COMPLAINT_IBFK_4;
    public static final ForeignKey<ComplaintRecord, RoomRecord> COMPLAINT_IBFK_5 = ForeignKeys0.COMPLAINT_IBFK_5;
    public static final ForeignKey<ComplaintTeamRecord, ComplaintRecord> COMPLAINT_TEAM_IBFK_1 = ForeignKeys0.COMPLAINT_TEAM_IBFK_1;
    public static final ForeignKey<ComplaintTeamRecord, TechnicianRecord> COMPLAINT_TEAM_IBFK_2 = ForeignKeys0.COMPLAINT_TEAM_IBFK_2;
    public static final ForeignKey<FacilitiesProblemRecord, FacilitiesRecord> FACILITIES_PROBLEM_IBFK_1 = ForeignKeys0.FACILITIES_PROBLEM_IBFK_1;
    public static final ForeignKey<FacilitiesProblemRecord, ProblemRecord> FACILITIES_PROBLEM_IBFK_2 = ForeignKeys0.FACILITIES_PROBLEM_IBFK_2;
    public static final ForeignKey<RoomFacilitiesRecord, RoomRecord> ROOM_FACILITIES_IBFK_1 = ForeignKeys0.ROOM_FACILITIES_IBFK_1;
    public static final ForeignKey<RoomFacilitiesRecord, FacilitiesRecord> ROOM_FACILITIES_IBFK_2 = ForeignKeys0.ROOM_FACILITIES_IBFK_2;
    public static final ForeignKey<UserRecord, ApartmentRecord> USER_IBFK_1 = ForeignKeys0.USER_IBFK_1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<ApartmentRecord, Integer> IDENTITY_APARTMENT = Internal.createIdentity(Apartment.APARTMENT, Apartment.APARTMENT.ID);
        public static Identity<BuildingRecord, Integer> IDENTITY_BUILDING = Internal.createIdentity(Building.BUILDING, Building.BUILDING.ID);
        public static Identity<ComplaintRecord, Integer> IDENTITY_COMPLAINT = Internal.createIdentity(Complaint.COMPLAINT, Complaint.COMPLAINT.ID);
        public static Identity<FacilitiesRecord, Integer> IDENTITY_FACILITIES = Internal.createIdentity(Facilities.FACILITIES, Facilities.FACILITIES.ID);
        public static Identity<FloorRecord, Integer> IDENTITY_FLOOR = Internal.createIdentity(Floor.FLOOR, Floor.FLOOR.ID);
        public static Identity<ProblemRecord, Integer> IDENTITY_PROBLEM = Internal.createIdentity(Problem.PROBLEM, Problem.PROBLEM.ID);
        public static Identity<RoomRecord, Integer> IDENTITY_ROOM = Internal.createIdentity(Room.ROOM, Room.ROOM.ID);
        public static Identity<TechnicianRecord, Integer> IDENTITY_TECHNICIAN = Internal.createIdentity(Technician.TECHNICIAN, Technician.TECHNICIAN.ID);
        public static Identity<UserRecord, Integer> IDENTITY_USER = Internal.createIdentity(User.USER, User.USER.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<ApartmentRecord> KEY_APARTMENT_PRIMARY = Internal.createUniqueKey(Apartment.APARTMENT, "KEY_apartment_PRIMARY", Apartment.APARTMENT.ID);
        public static final UniqueKey<ApartmentRecord> KEY_APARTMENT_CODE_UNIQUE = Internal.createUniqueKey(Apartment.APARTMENT, "KEY_apartment_code_UNIQUE", Apartment.APARTMENT.CODE);
        public static final UniqueKey<ApartmentRoomRecord> KEY_APARTMENT_ROOM_PRIMARY = Internal.createUniqueKey(ApartmentRoom.APARTMENT_ROOM, "KEY_apartment_room_PRIMARY", ApartmentRoom.APARTMENT_ROOM.APARTMENT_ID, ApartmentRoom.APARTMENT_ROOM.ROOM_ID);
        public static final UniqueKey<BuildingRecord> KEY_BUILDING_PRIMARY = Internal.createUniqueKey(Building.BUILDING, "KEY_building_PRIMARY", Building.BUILDING.ID);
        public static final UniqueKey<BuildingRecord> KEY_BUILDING_CODE_UNIQUE = Internal.createUniqueKey(Building.BUILDING, "KEY_building_code_UNIQUE", Building.BUILDING.CODE);
        public static final UniqueKey<ComplaintRecord> KEY_COMPLAINT_PRIMARY = Internal.createUniqueKey(Complaint.COMPLAINT, "KEY_complaint_PRIMARY", Complaint.COMPLAINT.ID);
        public static final UniqueKey<ComplaintTeamRecord> KEY_COMPLAINT_TEAM_PRIMARY = Internal.createUniqueKey(ComplaintTeam.COMPLAINT_TEAM, "KEY_complaint_team_PRIMARY", ComplaintTeam.COMPLAINT_TEAM.COMPLAINT_ID, ComplaintTeam.COMPLAINT_TEAM.TECHNICIAN_ID);
        public static final UniqueKey<FacilitiesRecord> KEY_FACILITIES_PRIMARY = Internal.createUniqueKey(Facilities.FACILITIES, "KEY_facilities_PRIMARY", Facilities.FACILITIES.ID);
        public static final UniqueKey<FacilitiesProblemRecord> KEY_FACILITIES_PROBLEM_PRIMARY = Internal.createUniqueKey(FacilitiesProblem.FACILITIES_PROBLEM, "KEY_facilities_problem_PRIMARY", FacilitiesProblem.FACILITIES_PROBLEM.FACILITIES_ID, FacilitiesProblem.FACILITIES_PROBLEM.PROBLEM_ID);
        public static final UniqueKey<FloorRecord> KEY_FLOOR_PRIMARY = Internal.createUniqueKey(Floor.FLOOR, "KEY_floor_PRIMARY", Floor.FLOOR.ID);
        public static final UniqueKey<FloorRecord> KEY_FLOOR_CODE_UNIQUE = Internal.createUniqueKey(Floor.FLOOR, "KEY_floor_code_UNIQUE", Floor.FLOOR.CODE);
        public static final UniqueKey<ProblemRecord> KEY_PROBLEM_PRIMARY = Internal.createUniqueKey(Problem.PROBLEM, "KEY_problem_PRIMARY", Problem.PROBLEM.ID);
        public static final UniqueKey<RoomRecord> KEY_ROOM_PRIMARY = Internal.createUniqueKey(Room.ROOM, "KEY_room_PRIMARY", Room.ROOM.ID);
        public static final UniqueKey<RoomFacilitiesRecord> KEY_ROOM_FACILITIES_PRIMARY = Internal.createUniqueKey(RoomFacilities.ROOM_FACILITIES, "KEY_room_facilities_PRIMARY", RoomFacilities.ROOM_FACILITIES.ROOM_ID, RoomFacilities.ROOM_FACILITIES.FACILITIES_ID);
        public static final UniqueKey<TechnicianRecord> KEY_TECHNICIAN_PRIMARY = Internal.createUniqueKey(Technician.TECHNICIAN, "KEY_technician_PRIMARY", Technician.TECHNICIAN.ID);
        public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = Internal.createUniqueKey(User.USER, "KEY_user_PRIMARY", User.USER.ID);
        public static final UniqueKey<UserRecord> KEY_USER_USERNAME = Internal.createUniqueKey(User.USER, "KEY_user_username", User.USER.USERNAME);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<ApartmentRecord, BuildingRecord> APARTMENT_IBFK_1 = Internal.createForeignKey(schema.Keys.KEY_BUILDING_PRIMARY, Apartment.APARTMENT, "apartment_ibfk_1", Apartment.APARTMENT.BUILDING_ID);
        public static final ForeignKey<ApartmentRecord, FloorRecord> APARTMENT_IBFK_2 = Internal.createForeignKey(schema.Keys.KEY_FLOOR_PRIMARY, Apartment.APARTMENT, "apartment_ibfk_2", Apartment.APARTMENT.FLOOR_ID);
        public static final ForeignKey<ApartmentRoomRecord, ApartmentRecord> APARTMENT_ROOM_IBFK_1 = Internal.createForeignKey(schema.Keys.KEY_APARTMENT_PRIMARY, ApartmentRoom.APARTMENT_ROOM, "apartment_room_ibfk_1", ApartmentRoom.APARTMENT_ROOM.APARTMENT_ID);
        public static final ForeignKey<ApartmentRoomRecord, RoomRecord> APARTMENT_ROOM_IBFK_2 = Internal.createForeignKey(schema.Keys.KEY_ROOM_PRIMARY, ApartmentRoom.APARTMENT_ROOM, "apartment_room_ibfk_2", ApartmentRoom.APARTMENT_ROOM.ROOM_ID);
        public static final ForeignKey<ComplaintRecord, UserRecord> COMPLAINT_IBFK_1 = Internal.createForeignKey(schema.Keys.KEY_USER_PRIMARY, Complaint.COMPLAINT, "complaint_ibfk_1", Complaint.COMPLAINT.USER_ID);
        public static final ForeignKey<ComplaintRecord, ApartmentRecord> COMPLAINT_IBFK_2 = Internal.createForeignKey(schema.Keys.KEY_APARTMENT_PRIMARY, Complaint.COMPLAINT, "complaint_ibfk_2", Complaint.COMPLAINT.APARTMENT_ID);
        public static final ForeignKey<ComplaintRecord, ProblemRecord> COMPLAINT_IBFK_3 = Internal.createForeignKey(schema.Keys.KEY_PROBLEM_PRIMARY, Complaint.COMPLAINT, "complaint_ibfk_3", Complaint.COMPLAINT.PROBLEM_ID);
        public static final ForeignKey<ComplaintRecord, FacilitiesRecord> COMPLAINT_IBFK_4 = Internal.createForeignKey(schema.Keys.KEY_FACILITIES_PRIMARY, Complaint.COMPLAINT, "complaint_ibfk_4", Complaint.COMPLAINT.FACILITIES_ID);
        public static final ForeignKey<ComplaintRecord, RoomRecord> COMPLAINT_IBFK_5 = Internal.createForeignKey(schema.Keys.KEY_ROOM_PRIMARY, Complaint.COMPLAINT, "complaint_ibfk_5", Complaint.COMPLAINT.ROOM_ID);
        public static final ForeignKey<ComplaintTeamRecord, ComplaintRecord> COMPLAINT_TEAM_IBFK_1 = Internal.createForeignKey(schema.Keys.KEY_COMPLAINT_PRIMARY, ComplaintTeam.COMPLAINT_TEAM, "complaint_team_ibfk_1", ComplaintTeam.COMPLAINT_TEAM.COMPLAINT_ID);
        public static final ForeignKey<ComplaintTeamRecord, TechnicianRecord> COMPLAINT_TEAM_IBFK_2 = Internal.createForeignKey(schema.Keys.KEY_TECHNICIAN_PRIMARY, ComplaintTeam.COMPLAINT_TEAM, "complaint_team_ibfk_2", ComplaintTeam.COMPLAINT_TEAM.TECHNICIAN_ID);
        public static final ForeignKey<FacilitiesProblemRecord, FacilitiesRecord> FACILITIES_PROBLEM_IBFK_1 = Internal.createForeignKey(schema.Keys.KEY_FACILITIES_PRIMARY, FacilitiesProblem.FACILITIES_PROBLEM, "facilities_problem_ibfk_1", FacilitiesProblem.FACILITIES_PROBLEM.FACILITIES_ID);
        public static final ForeignKey<FacilitiesProblemRecord, ProblemRecord> FACILITIES_PROBLEM_IBFK_2 = Internal.createForeignKey(schema.Keys.KEY_PROBLEM_PRIMARY, FacilitiesProblem.FACILITIES_PROBLEM, "facilities_problem_ibfk_2", FacilitiesProblem.FACILITIES_PROBLEM.PROBLEM_ID);
        public static final ForeignKey<RoomFacilitiesRecord, RoomRecord> ROOM_FACILITIES_IBFK_1 = Internal.createForeignKey(schema.Keys.KEY_ROOM_PRIMARY, RoomFacilities.ROOM_FACILITIES, "room_facilities_ibfk_1", RoomFacilities.ROOM_FACILITIES.ROOM_ID);
        public static final ForeignKey<RoomFacilitiesRecord, FacilitiesRecord> ROOM_FACILITIES_IBFK_2 = Internal.createForeignKey(schema.Keys.KEY_FACILITIES_PRIMARY, RoomFacilities.ROOM_FACILITIES, "room_facilities_ibfk_2", RoomFacilities.ROOM_FACILITIES.FACILITIES_ID);
        public static final ForeignKey<UserRecord, ApartmentRecord> USER_IBFK_1 = Internal.createForeignKey(schema.Keys.KEY_APARTMENT_PRIMARY, User.USER, "user_ibfk_1", User.USER.APARTMENT_ID);
    }
}
