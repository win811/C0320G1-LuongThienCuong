package furama.resort.services;

import furama.resort.models.Contract;
import furama.resort.models.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {

    Page<Service> findServiceByStatusIsTrue (Pageable pageable);
    Page<Service> findAllService (Pageable pageable);
    Page<Service> findServiceByNameAndType (String nameService,String typeService, Pageable pageable);
    Page<Service> findServiceByNameAndTypeAndStatusIsTrue (String nameService,String typeService, Pageable pageable);
    Service findServiceById (long id);
    void saveService(Service service);

}
