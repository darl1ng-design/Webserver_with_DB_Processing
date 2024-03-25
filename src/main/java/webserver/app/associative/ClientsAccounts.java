package webserver.app.associative;

import jakarta.persistence.*;
import webserver.app.accounts.Account;
import webserver.app.clients.Client;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = "clients_accounts"
)
public class ClientsAccounts {
    @Id
    @SequenceGenerator(
            name = "ca_sequence",
            sequenceName = "ca_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "ca_sequence"
    )
    @Column(
            name="ca_id",
            updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name="client_id")
    Client client;

    @ManyToOne
    @JoinColumn(name="acc_id")
    Account account;
}
