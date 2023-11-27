package co.bank.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    private Integer id;
    private Date date;
    private String TransactionType;
    private String currency;
    private Double amount;
    private Integer fromAccount;
    private Integer toAccount;
}
