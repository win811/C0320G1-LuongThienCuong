package models;

public class House extends Services {
    private String roomStandard;
    private String convenient;
    private String floor;

    public House() {
    }

    public House(String roomStandard, String convenient, String floor) {
        this.roomStandard = roomStandard;
        this.convenient = convenient;
        this.floor = floor;
    }

    public House(String id, String nameService, String areaUse, String rentCost, String maxGuest, String rentType,String accompaniedService,
                 String roomStandard, String convenient, String floor) {
        super(id, nameService, areaUse, rentCost, maxGuest, rentType,accompaniedService);
        this.roomStandard = roomStandard;
        this.convenient = convenient;
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
                this.getFloor();
    }
}
