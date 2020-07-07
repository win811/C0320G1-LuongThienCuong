package furama.resort.repositories;

import furama.resort.models.Contract;
import furama.resort.models.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {
    Page<Service> findByStatusIsTrue(Pageable pageable);
    Page<Service> findByNameContainingAndServiceType_NameContaining(String nameService,String typeService,Pageable pageable);
    Page<Service> findByNameContainingAndServiceType_NameContainingAndStatusIsTrue(String nameService,String typeService,Pageable pageable);
}
