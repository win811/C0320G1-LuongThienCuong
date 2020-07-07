package furama.resort.services.impl;

import furama.resort.models.AttachService;
import furama.resort.models.Contract;
import furama.resort.models.Customer;
import furama.resort.models.dto.ContractDto;
import furama.resort.repositories.ContractRepository;
import furama.resort.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    AttachServiceService attachServiceService;

    @Override
    public Page<Contract> findContractByStatusIsTrue(Pageable pageable) {
        return contractRepository.findByStatusIsTrue(pageable);
    }

    @Override
    public Page<Contract> findAllContract(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findAllContractHasEndDateAfterToday(LocalDate localDate, Pageable pageable) {
        return contractRepository.findByEndDateAfter(localDate,pageable);
    }

    @Override
    public Page<Contract> findContractByCustomerId(long id,Pageable pageable) {
        return contractRepository.findByCustomer_Id(id,pageable);
    }

    @Override
    public Contract findContractById(long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void saveContract(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void saveContract(ContractDto contractDto, furama.resort.models.Service service, Customer customer) {

//        ModelMapper modelMapper = new ModelMapper();
//        Contract contract = modelMapper.map(contractDto,Contract.class);
        Contract contract = new Contract();
        long randomCode = Math.abs(UUID.randomUUID().getMostSignificantBits())/1000000000;
        contract.setCode(randomCode);
        contract.setStartDate(contractDto.getStartDate());
        contract.setEndDate(contractDto.getEndDate());
        contract.setDeposit(contractDto.getDeposit());
        contract.setStatus(true);
        contract.setCustomer(customer);
        contract.setService(service);
        long nights = ChronoUnit.DAYS.between(contractDto.getStartDate(), contractDto.getEndDate());
        double totalAttachServicePay = 0;
        for (String id : contractDto.getIdAttachServiceArr()) {
            AttachService attachService = attachServiceService.findAttachServiceById(Long.parseLong(id));
            totalAttachServicePay += attachService.getPrice();
            contract.getAttachServices().add(attachService);
        }
        double totalPay = service.getPrice()*nights + totalAttachServicePay;
        contract.setTotalPay(totalPay);
        contractRepository.save(contract);

    }
}

