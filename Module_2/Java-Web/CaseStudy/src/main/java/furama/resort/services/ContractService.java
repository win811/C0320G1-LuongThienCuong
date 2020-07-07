package furama.resort.services;

import furama.resort.models.Contract;
import furama.resort.models.Customer;
import furama.resort.models.Service;
import furama.resort.models.dto.ContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface ContractService {

    Page<Contract> findContractByStatusIsTrue (Pageable pageable);
    Page<Contract> findAllContract(Pageable pageable);
    Page<Contract> findAllContractHasEndDateAfterToday(LocalDate localDate,Pageable pageable);
    Page<Contract> findContractByCustomerId (long id, Pageable pageable);
    Contract findContractById (long id);
    void saveContract(Contract contract);
    void saveContract(ContractDto contractDto, Service service, Customer customer);

 }
