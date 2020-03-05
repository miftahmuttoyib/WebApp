package service;

import bo.BOImplement.RoomBOImp;
import bo.RoomBO;
import obj.Room;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("room")
public class RoomService {
    private RoomBO roomBO = new RoomBOImp();

    @GET
    @Path("get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> selectAllRoom() {
        return roomBO.getAllRoom();
    }

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Room getRoom(@QueryParam("id") String id) {
        return roomBO.getRoomById(id);
    }

    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    public void saveRoom(Room room) {
        roomBO.saveRoom(room);
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") String id) {
        roomBO.deleteRoom(id);
    }
}
