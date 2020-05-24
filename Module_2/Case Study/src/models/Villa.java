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
        System.out.println( "- " + super.getNameService() + " With ID : " + super.getId() + " -" + "\n" +
                            "Used Area : " + super.getAreaUse() + "\n" +
                            "Rent Cost : " + super.getRentCost() + "\n" +
                            "Max Guest : " + super.getMaxGuest() + "\n" +
                            "Rent Type : " + super.getRentType() + "\n" +
                            "Accompanied Service : " + super.getAccompaniedService() + "\n" +
                            "Room Standard : " + this.getRoomStandard() + "\n" +
                            "Convenient : " + this.getConvenient() + "\n" +
                            "Area Of Pool : " + this.getAreaPool() + "\n" +
                            "floor : " + this.getFloor());
        System.out.println( "----------------------------------------------");
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
