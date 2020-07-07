package furama.resort.services.impl;

import furama.resort.models.Customer;
import furama.resort.repositories.CustomerRepository;
import furama.resort.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findCustomerByStatusIsTrue(Pageable pageable) {
        return customerRepository.findByStatusIsTrue(pageable);
    }

    @Override
    public Customer findCustomerByAccount(String userName) {
        return customerRepository.findByAccount_UserName(userName);
    }

    @Override
    public Page<Customer> findCustomerByNameAndCode(String name, String code, Pageable pageable) {

        return customerRepository.findByNameContainingAndCodeContaining(name.trim(),code.trim(),pageable);
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Customer findCustomerById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
