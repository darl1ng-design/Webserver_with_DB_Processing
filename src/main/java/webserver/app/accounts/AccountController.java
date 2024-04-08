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

    @DeleteMapping(path="{acc_id}")
    public void deleteAccount(@PathVariable("acc_id") Long id){
        accountService.deleteAccount(id);
    }

    @PutMapping(path="{acc_id}")
    public void updateAccount(@PathVariable("acc_id") Long acc_id, String email){
        accountService.updateAccount(acc_id, email);
    }

}
