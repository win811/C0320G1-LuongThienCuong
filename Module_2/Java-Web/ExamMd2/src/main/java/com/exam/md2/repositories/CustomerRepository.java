package com.exam.md2.repositories;

import com.exam.md2.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Page<Customer> findByNameContainingAndCodeContaining (String name, String code, Pageable pageable);
}
