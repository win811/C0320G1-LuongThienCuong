package furama.resort.services;

import furama.resort.models.Contract;
import furama.resort.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    Page<Customer> findCustomerByStatusIsTrue (Pageable pageable);
    Page<Customer> findCustomerByNameAndCode (String name,String code,Pageable pageable);
    Customer findCustomerById (long id);
    Customer findCustomerByAccount (String userName);
    Customer findCustomerByEmail (String email);
    void saveCustomer(Customer customer);

}
