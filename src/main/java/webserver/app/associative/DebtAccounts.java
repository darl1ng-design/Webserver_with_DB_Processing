package webserver.app.associative;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
    @Table(
            name="debt_accounts"
    )
public class DebtAccounts {
    @Id
    @SequenceGenerator(
            name = "da_sequence",
            sequenceName = "da_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "da_sequence"
    )
    @Column(
            name = "da_id",
            updatable = false
    )
    private Long id;
}
