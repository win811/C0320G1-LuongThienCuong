package Service.impl;

import Service.ServiceInterface;
import commons.ValidationServices;
import models.House;
import models.Services;
import models.Villa;

public class HouseServiceImpl implements ServiceInterface {
    @Override
    public Services addNewService() {
        House house = new House();
        house.setId(ValidationServices.inputAndCheckId("House"));
        house.setNameService(ValidationServices.inputAndCheckNameService());
        house.setAreaUse(ValidationServices.inputAndCheckAreaUse());
        house.setRentCost(ValidationServices.inputAndCheckRentCost());
        house.setMaxGuest(ValidationServices.inputAndCheckMaxGuest());
        house.setRentType(ValidationServices.inputAndCheckRentType());
        house.setAccompaniedService(ValidationServices.inputAndCheckAccompaniedService());
        house.setRoomStandard(ValidationServices.inputAndCheckRoomStandard());
        house.setConvenient(ValidationServices.inputAndCheckConvenient());
        house.setFloor(ValidationServices.inputAndCheckFloor());
        return house;
    }
}
