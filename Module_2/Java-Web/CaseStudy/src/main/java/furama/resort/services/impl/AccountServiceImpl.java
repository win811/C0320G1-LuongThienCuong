package furama.resort.services.impl;

import furama.resort.models.Account;
import furama.resort.repositories.AccountRepository;
import furama.resort.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account findAccountByUserName(String userName) {
        return accountRepository.findAccountByUserName(userName);
    }

}
