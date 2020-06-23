package spring.data.jpa.customer_province.service.customer_service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring.data.jpa.customer_province.model.Customer;


public interface CustomerService {
    Page<Customer> findAllCustomer(Pageable pageable);
    Page<Customer> findAllCustomerByProvinceNameAndByName (String provinceName,String firstName,String lastName,Pageable pageable);
    Page<Customer> findAllCustomerByName(Pageable pageable,String firstName,String lastName);
    Customer findCustomerById(Long id);
    void saveCustomer(Customer customer);
}
