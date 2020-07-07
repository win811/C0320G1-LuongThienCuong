package com.exam.md2.services;

import com.exam.md2.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomerService {
    Page<Customer> findAllByNameAndCode(String name,String code,Pageable pageable);
    Customer findCustomerById(long id);
    void saveCustomer (Customer customer);
}
