package webserver.app.accounts;

import jakarta.persistence.*;
import webserver.app.associative.ClientsAccounts;

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







}
