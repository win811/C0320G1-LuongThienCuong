package models;

public class Villa extends Services {
    private String roomStandard;
    private String convenient;
    private String areaPool;
    private String floor;

    public Villa() {
    }

    public Villa(String id, String nameService, String areaUse, String rentCost, String maxGuest, String rentType,String accompaniedService,
                 String roomStandard, String convenient, String areaPool, String floor) {
        super(id, nameService, areaUse, rentCost, maxGuest, rentType,accompaniedService);
        this.roomStandard = roomStandard;
        this.convenient = convenient;
        this.areaPool = areaPool;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getConvenient() {
        return convenient;
    }

    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }

    public String getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(String areaPool) {
        this.areaPool = areaPool;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public void showInfo() {
        System.out.println("-" + super.getNameService() + " With ID : " + super.getId() +"-");
        System.out.println("Has Used Area : " + super.getAreaUse());
        System.out.println("Has Rent Cost : " + super.getRentCost());
        System.out.println("Has Max Guest : " + super.getMaxGuest());
        System.out.println("Has Rent Type : " + super.getRentType());
        System.out.println("Has Accompanied Service : " + super.getAccompaniedService());
        System.out.println("Has Room Standard : " + this.getRoomStandard());
        System.out.println("Has Convenient : " + this.getConvenient());
        System.out.println("Has Area Of Pool : " + this.getAreaPool());
        System.out.println("Has floor : " + this.getFloor());
        System.out.println("----------------------------------------------");
    }
    @Override
    public String toString() {
        return  super.getId() + "," +
                super.getNameService() + "," +
                super.getAreaUse() + "," +
                super.getRentCost() + "," +
                super.getMaxGuest() + "," +
                super.getRentType() + "," +
                super.getAccompaniedService() + "," +
                this.getRoomStandard() + "," +
                this.getConvenient() + "," +
                this.getAreaPool() + "," +
                this.getFloor();
    }
}
