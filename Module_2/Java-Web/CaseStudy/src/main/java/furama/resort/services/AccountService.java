package furama.resort.services;

import furama.resort.models.Account;

public interface AccountService {
    void saveAccount (Account account);
    Account findAccountByUserName (String userName);
}
