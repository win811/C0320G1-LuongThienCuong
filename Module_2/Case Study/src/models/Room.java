package models;

public class Room extends Services {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String id, String nameService, String areaUse, String rentCost, String maxGuest,
                String rentType,String accompaniedService, String freeService) {
        super(id, nameService, areaUse, rentCost, maxGuest, rentType,accompaniedService);
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
        System.out.println( "- " + super.getNameService() + " With ID : " + super.getId() + " -" + "\n" +
                            "Used Area : " + super.getAreaUse() + "\n" +
                            "Rent Cost : " + super.getRentCost() + "\n" +
                            "Max Guest : " + super.getMaxGuest() + "\n" +
                            "Rent Type : " + super.getRentType() + "\n" +
                            "Accompanied Service : " + super.getAccompaniedService() + "\n" +
                            "free Services : " + this.getFreeService());
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
                this.getFreeService();
    }
}
