package models;

public abstract class Services {
    private String id;
    private String nameService;
    private String areaUse;
    private String rentCost;
    private String maxGuest;
    private String rentType;

    public Services () {
    }

    public Services(String id, String nameService, String areaUse, String rentCost, String maxGuest, String rentType) {
        this.id = id;
        this.nameService = nameService;
        this.areaUse = areaUse;
        this.rentCost = rentCost;
        this.maxGuest = maxGuest;
        this.rentType = rentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(String areaUse) {
        this.areaUse = areaUse;
    }

    public String getRentCost() {
        return rentCost;
    }

    public void setRentCost(String rentCost) {
        this.rentCost = rentCost;
    }

    public String getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(String maxGuest) {
        this.maxGuest = maxGuest;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }
    public abstract void showInfo();

}
