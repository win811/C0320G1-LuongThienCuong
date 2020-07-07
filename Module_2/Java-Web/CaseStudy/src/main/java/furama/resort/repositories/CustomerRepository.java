package furama.resort.repositories;

import furama.resort.models.Contract;
import furama.resort.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Page<Customer> findByStatusIsTrue(Pageable pageable);
    Customer findByAccount_UserName(String userName);
    Page<Customer> findByNameContainingAndCodeContaining(String name,String code,Pageable pageable);
    Customer findByEmail(String email);
}
