package furama.resort.services.impl;

import furama.resort.models.AccountRole;
import furama.resort.repositories.AccountRoleRepository;
import furama.resort.services.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {

    @Autowired
    AccountRoleRepository accountRoleRepository;

    @Override
    public void saveAccountRole(AccountRole accountRole) {
        accountRoleRepository.save(accountRole);
    }
}
