package furama.resort.services.impl;

import furama.resort.models.CustomerType;
import furama.resort.repositories.CustomerTypeRepository;
import furama.resort.services.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {

    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> getAllCustomerType() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findByName(String name) {
        return customerTypeRepository.findByName(name);
    }
}
