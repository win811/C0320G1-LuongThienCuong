package Service;

import models.Room;
import models.Services;
import models.Villa;

public class RoomServiceImpl implements ServiceInterface {
    @Override
    public Room add() {
        Room room = new Room();
        room.setId("1");
        room.setNameService("Room Test");
        room.setAreaUse("100");
        room.setRentCost("1000$");
        room.setMaxGuest("5");
        room.setRentType("Month");
        room.setFreeService("Massage");
        return room;
    }
}
