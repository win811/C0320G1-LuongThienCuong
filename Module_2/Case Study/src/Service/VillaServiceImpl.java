package Service;

import models.Services;
import models.Villa;

public class VillaServiceImpl implements ServiceInterface {

    @Override
    public Villa add() {
        Villa villa = new Villa();
        villa.setId("1");
        villa.setNameService("Villa Test");
        villa.setAreaUse("100");
        villa.setRentCost("1000$");
        villa.setMaxGuest("5");
        villa.setRentType("Month");
        villa.setRoomStandard("Vip");
        villa.setConvenient("Convenient");
        villa.setAreaPool("100m2");
        villa.setFloor("5 floors");
        return villa;
    }
}
