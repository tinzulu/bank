package co.bank.transaction.model;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    private String TransactionType;
    private String currency;
    private Double amount;
    @ManyToOne
    private Account fromAccount;
    @ManyToOne
    private Account toAccount;
}
