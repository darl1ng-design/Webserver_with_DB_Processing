package webserver.app.accounts;
//logic for API methods on account Table

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class AccountService {


    private final AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccount(){
        return accountRepository.findAll();
    }

    public void AddAccount(Account a){
        Optional<Account> byLogin = accountRepository.findAccountByLogin(a.getLogin());
        Optional<Account> byEmail = accountRepository.findAccountByEmail(a.getEmail());
            if(byLogin.isPresent() || byEmail.isPresent()){
                throw new IllegalStateException("Account of this instance already exists");
            }
        accountRepository.save(a);
    }

    public void deleteAccount(Long id){
        boolean exists = accountRepository.existsById(id);
            if(!exists) throw new IllegalStateException("Account does not exist");
        accountRepository.deleteById(id);
    }

    @Transactional
    public void updateAccount(Long id, String email){
        Account acc = accountRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Account of id" + id + "has been not found")
        );
        if(email != null && !email.isBlank() && !Objects.equals(acc.getEmail(), email)){
           Optional<Account> acc_email =  accountRepository.findAccountByEmail(email);
            if(acc_email.isPresent()){
                throw new IllegalStateException("user with following email" + acc_email + "exists");
            }
        }
    acc.setEmail(email);
    }
}
