package webserver.app.debt;


import jakarta.persistence.*;
import webserver.app.associative.DebtAccounts;

import java.util.Set;

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
    @OneToMany(mappedBy = "debt")
    Set<DebtAccounts> data_2;

    @Column(
            name = "debt_overall_val_PLN",
            updatable = false,
            nullable = false
    )
    private Long debt_value;
    @Column(
            name = "debt_val_paid_PLN",
            nullable = false
    )
    private Long debt_value_paid;

    @Column(
            name = "debt_val_to_pay_PLN",
            nullable = false
    )
    private Long debt_value_left_to_be_paid;


    @Column(
            name = "contract_start_date",
            nullable = false

    )
    private String contract_start_date;

    @Column(
            name = "contract_end_date",
            nullable = false
    )
    private String contract_end_date;

    public Debt(
            Long debt_value,
            Long debt_value_paid,
            Long debt_value_left_to_be_paid,
            String contract_start_date,
            String contract_end_date){
        this.debt_value = debt_value;
        this.debt_value_paid = debt_value_paid;
        this.debt_value_left_to_be_paid = debt_value_left_to_be_paid;
        this.contract_start_date = contract_start_date;
        this.contract_end_date = contract_end_date;
    }
    public Debt(){};

    public Long getDebt_id() {
        return debt_id;
    }

    public void setDebt_id(Long debt_id) {
        this.debt_id = debt_id;
    }

    public Long getDebt_value() {
        return debt_value;
    }

    public void setDebt_value(Long debt_value) {
        this.debt_value = debt_value;
    }

    public Long getDebt_value_paid() {
        return debt_value_paid;
    }

    public void setDebt_value_paid(Long debt_value_paid) {
        this.debt_value_paid = debt_value_paid;
    }

    public Long getDebt_value_left_to_be_paid() {
        return debt_value_left_to_be_paid;
    }

    public void setDebt_value_left_to_be_paid(Long debt_value_left_to_be_paid) {
        this.debt_value_left_to_be_paid = debt_value_left_to_be_paid;
    }

    public String getContract_start_date() {
        return contract_start_date;
    }

    public void setContract_start_date(String contract_start_date) {
        this.contract_start_date = contract_start_date;
    }

    public String getContract_end_date() {
        return contract_end_date;
    }

    public void setContract_end_date(String contract_end_date) {
        this.contract_end_date = contract_end_date;
    }

    @Override
    public String toString() {
        return "Debt{" +
                "debt_id=" + debt_id +
                ", debt_value=" + debt_value +
                ", debt_value_paid=" + debt_value_paid +
                ", debt_value_left_to_be_paid=" + debt_value_left_to_be_paid +
                ", contract_start_date='" + contract_start_date + '\'' +
                ", contract_end_date='" + contract_end_date + '\'' +
                '}';
    }
}
