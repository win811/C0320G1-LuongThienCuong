package furama.resort.services.impl;

import furama.resort.repositories.ServiceRepository;
import furama.resort.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Page<furama.resort.models.Service> findServiceByStatusIsTrue(Pageable pageable) {
        return serviceRepository.findByStatusIsTrue(pageable);
    }

    @Override
    public Page<furama.resort.models.Service> findAllService(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Page<furama.resort.models.Service> findServiceByNameAndType(String nameService,String typeService, Pageable pageable) {
        return serviceRepository.findByNameContainingAndServiceType_NameContaining(nameService,typeService,pageable);
    }

    @Override
    public Page<furama.resort.models.Service> findServiceByNameAndTypeAndStatusIsTrue(String nameService, String typeService, Pageable pageable) {
        return serviceRepository.findByNameContainingAndServiceType_NameContainingAndStatusIsTrue(nameService.trim(),typeService,pageable);
    }

    @Override
    public furama.resort.models.Service findServiceById(long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void saveService(furama.resort.models.Service service) {
        serviceRepository.save(service);
    }
}
