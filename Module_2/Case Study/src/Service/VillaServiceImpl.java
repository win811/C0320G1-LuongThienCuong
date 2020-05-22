package Service;

import commons.ValidationServices;
import models.Services;
import models.Villa;

public class VillaServiceImpl implements ServiceInterface {

    @Override
    public Services add() {
        Villa villa = new Villa();
        villa.setId(ValidationServices.inputAndCheckId("Villa"));
        villa.setNameService(ValidationServices.inputAndCheckNameService());
        villa.setAreaUse(ValidationServices.inputAndCheckAreaUse());
        villa.setRentCost(ValidationServices.inputAndCheckRentCost());
        villa.setMaxGuest(ValidationServices.inputAndCheckMaxGuest());
        villa.setRentType(ValidationServices.inputAndCheckRentType());
        villa.setAccompaniedService(ValidationServices.inputAndCheckAccompaniedService());
        villa.setRoomStandard(ValidationServices.inputAndCheckRoomStandard());
        villa.setConvenient(ValidationServices.inputAndCheckConvenient());
        villa.setAreaPool(ValidationServices.inputAndCheckAreaPool());
        villa.setFloor(ValidationServices.inputAndCheckFloor());
        return villa;
    }
}
