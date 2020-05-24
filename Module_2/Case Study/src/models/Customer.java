package models;

import java.util.Date;

public class Customer {
    private String id;
    private String nameCustomer;
    private String birthdayCustomer;
    private String genderCustomer;
    private String idCardCustomer;
    private String phoneNumberCustomer;
    private String emailCustomer;
    private String typeCustomer;
    private String addressCustomer;
    private Services serviceCustomer;

    public Customer() {
    }

    public Customer(String id,String nameCustomer, String birthdayCustomer, String genderCustomer, String cmndCustomer,
                    String phoneNumberCustomer, String emailCustomer, String typeCustomer, String addressCustomer,
                    Services serviceCustomer) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.birthdayCustomer = birthdayCustomer;
        this.genderCustomer = genderCustomer;
        this.idCardCustomer = cmndCustomer;
        this.phoneNumberCustomer = phoneNumberCustomer;
        this.emailCustomer = emailCustomer;
        this.typeCustomer = typeCustomer;
        this.addressCustomer = addressCustomer;
        this.serviceCustomer = serviceCustomer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getBirthdayCustomer() {
        return birthdayCustomer;
    }

    public void setBirthdayCustomer(String birthdayCustomer) {
        this.birthdayCustomer = birthdayCustomer;
    }

    public String getAge () {
        Date birthdayDate = new Date(this.getBirthdayCustomer());
        Date today = new Date();
        double age = (today.getTime() - birthdayDate.getTime())/1000/60/60/24/30/12;
        return Double.toString(age);
    }

    public String getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(String genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public String getIdCardCustomer() {
        return idCardCustomer;
    }

    public void setIdCardCustomer(String idCardCustomer) {
        this.idCardCustomer = idCardCustomer;
    }

    public String getPhoneNumberCustomer() {
        return phoneNumberCustomer;
    }

    public void setPhoneNumberCustomer(String phoneNumberCustomer) {
        this.phoneNumberCustomer = phoneNumberCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public Services getServiceCustomer() {
        return serviceCustomer;
    }

    public void setServiceCustomer(Services serviceCustomer) {
        this.serviceCustomer = serviceCustomer;
    }

    public void showInfo () {
        System.out.println( "- Customer: " + this.getNameCustomer() + " With Id : " + this.getId() + " -" + "\n" +
                            "Birthday: " + this.getBirthdayCustomer() + "\n" +
                            "Gender: " + this.getGenderCustomer() + "\n" +
                            "Id Card: " + this.getIdCardCustomer() + "\n" +
                            "Phone Number: " + this.getPhoneNumberCustomer() + "\n" +
                            "Email: " + this.getEmailCustomer() + "\n" +
                            "Type Customer: " + this.getTypeCustomer() + "\n" +
                            "Address: " + this.getAddressCustomer() );
        System.out.println( "----------------------------------------------");
    }

    @Override
    public String toString() {
        return  this.getId() + "," +
                this.getNameCustomer() + "," +
                this.getBirthdayCustomer() + "," +
                this.getGenderCustomer() + "," +
                this.getIdCardCustomer() + "," +
                this.getPhoneNumberCustomer() + "," +
                this.getEmailCustomer() + "," +
                this.getTypeCustomer() + "," +
                this.getAddressCustomer();
    }
}
