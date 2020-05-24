package models;

public class Booking {

    private Customer customer;

    public Booking() {
    }

    public Booking(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return  this.customer.toString() + "," +
                this.customer.getServiceCustomer().getId() + "," +
                this.customer.getServiceCustomer().getNameService() + "," +
                this.customer.getServiceCustomer().getAreaUse() + "," +
                this.customer.getServiceCustomer().getRentCost() + "," +
                this.customer.getServiceCustomer().getMaxGuest() + "," +
                this.customer.getServiceCustomer().getRentType() + "," +
                this.customer.getServiceCustomer().getAccompaniedService();
    }
}
