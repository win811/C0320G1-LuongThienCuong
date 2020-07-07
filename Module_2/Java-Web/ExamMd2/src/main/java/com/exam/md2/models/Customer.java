package com.exam.md2.models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "customers")
public class Customer implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^KH-\\d{4}$", message = "Customer code must be KH-XXXX")
    @Column(name = "customer_code")
    private String code;

    @Size(min = 2, max = 30, message = "Length of name must be between 2 and 30")
    @Column(name = "customer_name")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "customer_birthday")
    private LocalDate birthday;

    @NotBlank
    @Column(name = "customer_gender")
    private String gender;

    @Pattern(regexp = "^\\d{4}\\.\\d{3}\\.\\d{3}$", message = "Phone number is wrong format")
    @Column(name = "customer_phonenumber")
    private String phoneNumber;

    @Pattern(regexp = "^\\d{9}$", message = "ID Card format must be 9 number!")
    @Column(name = "customer_idcard")
    private String idCard;

    @Pattern(regexp = "^([-\\w.])+[a-zA-Z\\d]@(\\w+\\.)+(\\w+)$", message = "Email is wrong format")
    @Column(name = "customer_email")
    private String email;

    @NotBlank
    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_status")
    private boolean status;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Customer customer = (Customer) target;

        if (customer.getBirthday() == null) {
            errors.rejectValue("birthday", "birthday.empty");
        } else {
            long age = ChronoUnit.YEARS.between(customer.getBirthday(), LocalDate.now());
            if (age < 18) {
                errors.rejectValue("birthday", "birthday.age");
            }
        }

    }
}
