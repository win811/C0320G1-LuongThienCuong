package Service.impl;

import Service.ServiceInterface;
import commons.ValidationServices;
import models.Room;
import models.Services;
import models.Villa;

public class RoomServiceImpl implements ServiceInterface {
    @Override
    public Services addNewService() {
        Room room = new Room();
        room.setId(ValidationServices.inputAndCheckId("Room"));
        room.setNameService(ValidationServices.inputAndCheckNameService());
        room.setAreaUse(ValidationServices.inputAndCheckAreaUse());
        room.setRentCost(ValidationServices.inputAndCheckRentCost());
        room.setMaxGuest(ValidationServices.inputAndCheckMaxGuest());
        room.setRentType(ValidationServices.inputAndCheckRentType());
        room.setAccompaniedService(ValidationServices.inputAndCheckAccompaniedService());
        room.setFreeService(ValidationServices.inputAndCheckFreeService());
        return room;
    }
}
