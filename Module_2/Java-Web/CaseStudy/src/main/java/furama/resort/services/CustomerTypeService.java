package furama.resort.services;

import furama.resort.models.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> getAllCustomerType();
    CustomerType findByName (String name);
}
