package models;

public abstract class Customer {
    private String nameCustomer;
    private String birthdayCustomer;
    private String genderCustomer;
    private String cmndCustomer;
    private String phoneNumberCustomer;
    private String emailCustomer;
    private String typeCustomer;
    private String addressCustomer;
    private Services serviceCustomer;

    public Customer() {
    }

    public Customer(String nameCustomer, String birthdayCustomer, String genderCustomer, String cmndCustomer,
                    String phoneNumberCustomer, String emailCustomer, String typeCustomer, String addressCustomer,
                    Services serviceCustomer) {
        this.nameCustomer = nameCustomer;
        this.birthdayCustomer = birthdayCustomer;
        this.genderCustomer = genderCustomer;
        this.cmndCustomer = cmndCustomer;
        this.phoneNumberCustomer = phoneNumberCustomer;
        this.emailCustomer = emailCustomer;
        this.typeCustomer = typeCustomer;
        this.addressCustomer = addressCustomer;
        this.serviceCustomer = serviceCustomer;
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

    public String getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(String genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public String getCmndCustomer() {
        return cmndCustomer;
    }

    public void setCmndCustomer(String cmndCustomer) {
        this.cmndCustomer = cmndCustomer;
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

    public abstract void showInfo ();
}
