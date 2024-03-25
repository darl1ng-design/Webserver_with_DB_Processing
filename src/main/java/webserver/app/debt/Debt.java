package webserver.app.debt;


import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
    @Table(
            name="debt"
    )
public class Debt {
    @Id
    @SequenceGenerator(
            name = "debt_sequence",
            sequenceName = "debt_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "debt_sequence"
    )
    @Column(
            name = "debt_id",
            updatable = false
    )
    private Long debt_id;
}
