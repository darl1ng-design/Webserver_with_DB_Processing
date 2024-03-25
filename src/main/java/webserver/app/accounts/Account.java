package webserver.app.accounts;

import jakarta.persistence.*;
import webserver.app.associative.ClientsAccounts;
import webserver.app.associative.DebtAccounts;

import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
    @Table(
        name="accounts"
    )

    public class Account {
    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "account_sequence"
    )
    @Column(
        name="acc_id",
        updatable = false
    )
    private Long accId;
    @OneToMany(mappedBy = "account")
    Set<ClientsAccounts> data;

    @OneToMany(mappedBy = "account")
    Set<DebtAccounts> data_2;

    @Column(
            name = "account_login",
            nullable = false,
            unique = true
    )
    private String login;

    @Column(
            name = "account_password",
            nullable = false
    )
    private String password;

    @Column(
            name = "account_type",
            nullable = false
    )
    private String account_type;

    @Column(
        name = "opening_date",
        nullable = false
    )
    private String account_opening_date;

    @Column(
            name = "closure_date",
            nullable = false
    )
    private String account_closure_date;


    public Account(
           String login,
           String password,
           String account_type,
           String account_opening_date,
           String account_closure_date){
        this.login = login;
        this.password = password;
        this.account_type = account_type;
        this.account_opening_date = account_opening_date;
        this.account_closure_date = account_closure_date;
    }

    public Long getAccId() {
        return accId;
    }

    public void setAccId(Long accId) {
        this.accId = accId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getAccount_opening_date() {
        return account_opening_date;
    }

    public void setAccount_opening_date(String account_opening_date) {
        this.account_opening_date = account_opening_date;
    }

    public String getAccount_closure_date() {
        return account_closure_date;
    }

    public void setAccount_closure_date(String account_closure_date) {
        this.account_closure_date = account_closure_date;
    }
}
