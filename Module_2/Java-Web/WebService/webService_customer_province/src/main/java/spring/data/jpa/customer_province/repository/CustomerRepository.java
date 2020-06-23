package spring.data.jpa.customer_province.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.data.jpa.customer_province.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "select * from customer join province on province.id = customer.province_id where province.name like %?1% and (customer.first_name like  %?2% or customer.last_name like  %?3%)",nativeQuery = true)
    Page<Customer> findAllByProvince_NameContainingAndFirstNameContainingOrLastNameContaining (String provinceName,String firstName,String lastName,Pageable pageable);
    Page<Customer> findAllByFirstNameContainingOrLastNameContaining (Pageable pageable,String firstName, String lastName);
}
