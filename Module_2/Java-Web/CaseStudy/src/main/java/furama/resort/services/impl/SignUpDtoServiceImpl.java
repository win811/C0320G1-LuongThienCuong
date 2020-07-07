package furama.resort.services.impl;

import furama.resort.models.Account;
import furama.resort.models.AccountRole;
import furama.resort.models.Customer;
import furama.resort.models.Role;
import furama.resort.models.dto.SignUpDto;
import furama.resort.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SignUpDtoServiceImpl implements SignUpDtoService {

    @Autowired
    CustomerService customerService;

    @Autowired
    AccountService accountService;

    @Autowired
    CustomerTypeService customerTypeService;

    @Autowired
    RoleService roleService;

    @Autowired
    AccountRoleService accountRoleService;

    @Override
    public void saveCustomerAndAccount(SignUpDto signUpDto) {

        ///Customer
        Customer customer = new Customer();
        customer.setStatus(true);
        customer.setEmail(signUpDto.getEmail());
        customer.setName(" ");
        long temp = Math.abs(UUID.randomUUID().getMostSignificantBits())/1000000000;
        long randomCode = temp/1000000;
        customer.setCode("KH-" + randomCode);
        customer.setCustomerType(customerTypeService.findByName("Member"));
        customerService.saveCustomer(customer);

        ///Account
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Account account = new Account();
        account.setStatus(true);
        account.setUserName(signUpDto.getUserName());
        String encrytePassword = bCryptPasswordEncoder.encode(signUpDto.getPassword());
        account.setPassword(encrytePassword);
        account.setCustomer(customer);
        accountService.saveAccount(account);

        Role role = roleService.findRoleByName("ROLE_USER");
        AccountRole accountRole = new AccountRole();
        accountRole.setAccount(account);
        accountRole.setRole(role);
        accountRoleService.saveAccountRole(accountRole);
    }
}
