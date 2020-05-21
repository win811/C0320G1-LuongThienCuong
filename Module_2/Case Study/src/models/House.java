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

    public House(String id, String nameService, String areaUse, String rentCost, String maxGuest, String rentType,
                 String roomStandard, String convenient, String floor) {
        super(id, nameService, areaUse, rentCost, maxGuest, rentType);
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

        System.out.println("-" + super.getNameService() + " With ID : " + super.getId() +"-");
        System.out.println("Has Used Area : " + super.getAreaUse());
        System.out.println("Has Rent Cost : " + super.getRentCost());
        System.out.println("Has Max Guest : " + super.getMaxGuest());
        System.out.println("Has Rent Type : " + super.getRentType());
        System.out.println("Has Room Standard : " + this.getRoomStandard());
        System.out.println("Has Convenient : " + this.getConvenient());
        System.out.println("Has floor : " + this.getFloor());
    }
    @Override
    public String toString() {
        return  super.getId() + "," +
                super.getNameService() + "," +
                super.getAreaUse() + "," +
                super.getRentCost() + "," +
                super.getMaxGuest() + "," +
                super.getRentType() + "," +
                this.getRoomStandard() + "," +
                this.getConvenient() + "," +
                this.getFloor();
    }
}
