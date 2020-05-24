package Service.impl;

import Service.CustomerInterface;
import commons.ValidationServices;
import exception.*;
import models.Customer;

public class CustomerImpl implements CustomerInterface {
    @Override
    public Customer addNewCustomer() {
        Customer customer = new Customer();
        customer.setId(ValidationServices.inputAndCheckId("Customer")); //Validate
        customer.setNameCustomer(NameException.inputAndCheckName()); //Exception
        customer.setBirthdayCustomer(BirthdayException.inputAndCheckBirthday18()); //Exception
        customer.setGenderCustomer(GenderException.inputAndCheckGender()); //Exception
        customer.setIdCardCustomer(IdCardException.inputAndCheckIdCard()); //Exception
        customer.setPhoneNumberCustomer(ValidationServices.inputAndCheckPhoneNumber()); //Validate
        customer.setEmailCustomer(EmailException.inputAndCheckEmail()); //Exception
        customer.setTypeCustomer(ValidationServices.inputAndCheckTypeCustomer()); //Validate
        customer.setAddressCustomer(ValidationServices.inputAndCheckAddress()); //Validate
        return customer;
    }
}
