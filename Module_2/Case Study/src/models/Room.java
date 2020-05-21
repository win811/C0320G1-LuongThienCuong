package models;

public class Room extends Services {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String id, String nameService, String areaUse, String rentCost, String maxGuest,
                String rentType, String freeService) {
        super(id, nameService, areaUse, rentCost, maxGuest, rentType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public void showInfo() {
        System.out.println("-" + super.getNameService() + " With ID : " + super.getId() +"-");
        System.out.println("Has Used Area : " + super.getAreaUse());
        System.out.println("Has Rent Cost : " + super.getRentCost());
        System.out.println("Has Max Guest : " + super.getMaxGuest());
        System.out.println("Has Rent Type : " + super.getRentType());
        System.out.println("Has free Services : " + this.getFreeService());
    }
    @Override
    public String toString() {
        return  super.getId() + "," +
                super.getNameService() + "," +
                super.getAreaUse() + "," +
                super.getRentCost() + "," +
                super.getMaxGuest() + "," +
                super.getRentType() + "," +
                this.getFreeService();
    }
}
