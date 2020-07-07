package furama.resort.repositories;

import furama.resort.models.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Long> {
    Page<Contract> findByStatusIsTrue(Pageable pageable);
    Page<Contract> findByCustomer_Id(long id,Pageable pageable);
    Page<Contract> findByEndDateAfter(LocalDate localDate,Pageable pageable);
}
