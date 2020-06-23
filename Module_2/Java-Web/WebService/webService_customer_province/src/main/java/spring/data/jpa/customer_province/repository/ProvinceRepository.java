package spring.data.jpa.customer_province.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.data.jpa.customer_province.model.Customer;
import spring.data.jpa.customer_province.model.Province;
@Repository
public interface ProvinceRepository extends JpaRepository<Province,Long> {
    Page<Province> findAllByNameContaining (String name, Pageable pageable);
}
