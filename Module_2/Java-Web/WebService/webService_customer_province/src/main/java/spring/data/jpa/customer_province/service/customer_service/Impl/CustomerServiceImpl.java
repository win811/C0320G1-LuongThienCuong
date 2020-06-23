package spring.data.jpa.customer_province.service.customer_service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.data.jpa.customer_province.model.Customer;
import spring.data.jpa.customer_province.repository.CustomerRepository;
import spring.data.jpa.customer_province.service.customer_service.CustomerService;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    public void test() {

    }

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllCustomerByProvinceNameAndByName(String provinceName,String firstName,String lastName,Pageable pageable) {
        return customerRepository.findAllByProvince_NameContainingAndFirstNameContainingOrLastNameContaining(provinceName,firstName,lastName,pageable);
    }

    @Override
    public Page<Customer> findAllCustomerByName(Pageable pageable,String firstName, String lastName ) {
        return customerRepository.findAllByFirstNameContainingOrLastNameContaining(pageable, firstName, lastName);
    }

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
