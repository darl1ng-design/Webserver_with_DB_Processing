package webserver.app.accounts;
//logic for API methods on account Table

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

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
}
