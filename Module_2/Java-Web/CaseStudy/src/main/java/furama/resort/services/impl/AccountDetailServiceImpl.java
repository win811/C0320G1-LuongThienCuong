package furama.resort.services.impl;

import furama.resort.models.Account;
import furama.resort.models.AccountRole;
import furama.resort.repositories.AccountRepository;
import furama.resort.repositories.AccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountDetailServiceImpl implements UserDetailsService {

    @Autowired
    AccountRoleRepository accountRoleRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByUserName(userName);
        if(account == null)
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");

        List<AccountRole> accountRoleList = accountRoleRepository.findByAccount_Id(account.getId());
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (accountRoleList != null) {
            for (AccountRole accountRole : accountRoleList) {
                System.out.println(accountRole.getRole().getName());
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(accountRole.getRole().getName());
                grantList.add(grantedAuthority);
            }
        }
        return (UserDetails) new User(account.getUserName(),account.getPassword(),grantList);
    }

}
