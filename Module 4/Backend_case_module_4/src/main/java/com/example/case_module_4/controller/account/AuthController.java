package com.example.case_module_4.controller.account;

import com.example.case_module_4.dto.AccountToken;
import com.example.case_module_4.model.Account;
import com.example.case_module_4.service.AccountService;
import com.example.case_module_4.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    AccountService accountService;

    @PostMapping ("/login")
    public AccountToken login(@RequestBody Account account){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtService.createToken(authentication);
        Account account1 = accountService.findAccountByUsername(account.getUsername());
        AccountToken accountToken = new AccountToken(account1.getUsername(),account1.getImg(),token,account1.getFullName(), account1.getRoles());
        return accountToken;
    }

    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody Account account) {
        accountService.save(account);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    @GetMapping("/checkUsername/{username}")
    public ResponseEntity<Account> check(@PathVariable String username) {
        if (accountService.isAccountDuplicated(username)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accountService.findAccountByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/findAccountByUsername")
    public ResponseEntity<Account> findAccountByUsername(@RequestParam String username) {
        return new ResponseEntity<>(accountService.findAccountByUsername(username), HttpStatus.OK);
    }
}
