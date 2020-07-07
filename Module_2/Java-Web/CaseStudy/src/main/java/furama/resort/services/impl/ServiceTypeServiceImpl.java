package furama.resort.services.impl;

import furama.resort.models.ServiceType;
import furama.resort.repositories.ServiceRepository;
import furama.resort.repositories.ServiceTypeRepository;
import furama.resort.services.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

   @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> getAllServiceType() {
        return serviceTypeRepository.findAll();
    }
}
