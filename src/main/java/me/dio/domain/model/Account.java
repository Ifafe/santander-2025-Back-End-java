package me.dio.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents a bank account entity.
 */
@Entity(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull
    private String number;

    @Column(nullable = false)
    @NotNull
    private String agency;

    @Column(precision = 13, scale = 2, nullable = false)
    @NotNull
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name = "additional_limit", precision = 13, scale = 2)
    private BigDecimal limit = BigDecimal.ZERO;

    /** Default constructor */
    public Account() {}

    /**
     * Parameterized constructor.
     */
    public Account(String number, String agency, BigDecimal balance, BigDecimal limit) {
        this.number = number;
        this.agency = agency;
        this.balance = balance != null ? balance : BigDecimal.ZERO;
        this.limit = limit != null ? limit : BigDecimal.ZERO;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public String getAgency() { return agency; }
    public void setAgency(String agency) { this.agency = agency; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
    public BigDecimal getLimit() { return limit; }
    public void setLimit(BigDecimal limit) { this.limit = limit; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(number, account.number) &&
                Objects.equals(agency, account.agency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, agency);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", agency='" + agency + '\'' +
                ", balance=" + balance +
                ", limit=" + limit +
                '}';
    }
}