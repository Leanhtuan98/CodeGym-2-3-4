package com.example.case_module_4.service;
import com.example.case_module_4.model.Account;
import com.example.case_module_4.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    IAccountRepo iAccountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepo.findAccountByUsername(username);
        return new User(account.getUsername(),account.getPassword(),account.getRoles());
    }

    public Account findAccountByUsername(String username){
        return iAccountRepo.findAccountByUsername(username);
    }

    public boolean isAccountDuplicated(String username) {
        Account optionalAccount = iAccountRepo.findAccountByUsername(username);
        if (optionalAccount == null){
            return false;
        } else {
            return true;
        }
    }

    public void save(Account account) {
        iAccountRepo.save(account);
    }
}
