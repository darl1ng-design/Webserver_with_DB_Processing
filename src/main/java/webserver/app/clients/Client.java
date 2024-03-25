package webserver.app.clients;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import webserver.app.associative.ClientsAccounts;

import java.util.Date;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
    @Table(
        name="client"
    )
public class Client {
    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "client_sequence"
    )

    @Column(
            name="client_id",
            updatable = false
    )
    private Long client_id;
    @OneToMany(mappedBy = "client")
    Set<ClientsAccounts> data;

    @Column(
            name="client_fname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String client_fname;

    @Column(
            name="client_lname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String client_lname;

    @Column(
            name="client_pesel",
            nullable = false,
            unique = true
    )
    private Long PESEL;

    @Column(
            name="client_address",
            nullable = false
    )
    private String address;

    @Column(
            name="client_email",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String email;

    @Column(
            name="date_of_birth",
            nullable = false
    )
    private String dob;

    public Client(
            String client_fname,
            String client_lname,
            Long PESEL,
            String address,
            String email,
            String dob){
        this.client_fname = client_fname;
        this.client_lname = client_lname;
        this.PESEL = PESEL;
        this.address = address;
        this.email = email;
        this.dob = dob;
    }

    public Client(){}

    public Long getId() {
        return client_id;
    }

    public void setId(Long client_id) {
        this.client_id = client_id;
    }

    public String getClient_fname() {
        return client_fname;
    }

    public void setClient_fname(String client_fname) {
        this.client_fname = client_fname;
    }

    public String getClient_lname() {
        return client_lname;
    }

    public void setClient_lname(String client_lname) {
        this.client_lname = client_lname;
    }

    public Long getPESEL() {
        return PESEL;
    }

    public void setPESEL(Long PESEL) {
        this.PESEL = PESEL;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + client_id +
                ", client_fname='" + client_fname + '\'' +
                ", client_lname='" + client_lname + '\'' +
                ", PESEL=" + PESEL +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
