package models;

public class Employee {
    private String id;
    private String nameEmployee;
    private String birthdayEmployee;
    private String addressEmployee;

    public Employee() {
    }

    public Employee(String id, String nameEmployee, String birthdayEmployee, String addressEmployee) {
        this.id = id;
        this.nameEmployee = nameEmployee;
        this.birthdayEmployee = birthdayEmployee;
        this.addressEmployee = addressEmployee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getBirthdayEmployee() {
        return birthdayEmployee;
    }

    public void setBirthdayEmployee(String birthdayEmployee) {
        this.birthdayEmployee = birthdayEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    public void showInfo () {
        System.out.println( "- Employee: " + this.getNameEmployee() + " With Id : " + this.getId() + " -" + "\n" +
                            "Birthday: " + this.getBirthdayEmployee() + "\n" +
                            "Address: " + this.getAddressEmployee() );
        System.out.println( "----------------------------------------------");
    }

    @Override
    public String toString () {
        return  this.getId() + "," +
                this.getNameEmployee() + "," +
                this.getBirthdayEmployee() + "," +
                this.getAddressEmployee();
    }

}
