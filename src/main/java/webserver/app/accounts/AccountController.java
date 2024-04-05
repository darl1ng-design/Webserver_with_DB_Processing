package webserver.app.accounts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path="/api/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccount(){
        return accountService.getAccount();
    }

    @PostMapping
    public void addAccount(@RequestBody Account a){
        accountService.AddAccount(a);
    }

}
