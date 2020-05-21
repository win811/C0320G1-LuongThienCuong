package Service;

import models.House;
import models.Services;
import models.Villa;

public class HouseServiceImpl implements ServiceInterface {
    @Override
    public House add() {
        House house = new House();
        house.setId("1");
        house.setNameService("house Test");
        house.setAreaUse("100");
        house.setRentCost("1000$");
        house.setMaxGuest("5");
        house.setRentType("Month");
        house.setRoomStandard("Vip");
        house.setConvenient("Convenient");
        house.setFloor("5 floors");
        return house;
    }
}
