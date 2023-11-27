package co.bank.transaction.service;

import co.bank.transaction.exception.AccountNotFoundException;
import co.bank.transaction.model.Account;
import co.bank.transaction.model.Transaction;
import co.bank.transaction.model.TransactionRequest;
import co.bank.transaction.repository.AccountRepository;
import co.bank.transaction.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService {
    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;

    public Transaction save(TransactionRequest transactionRequest){
        Account sourceAccount = accountRepository
                .findById(transactionRequest.getFromAccount())
                .orElseThrow(()-> new AccountNotFoundException("Source account not found"));
        Account destinationAccount = accountRepository
                .findById(transactionRequest.getFromAccount())
                .orElseThrow(()-> new AccountNotFoundException("destination account not found"));

        Transaction transaction = Transaction.builder()
                .amount(transactionRequest.getAmount())
                .TransactionType(transactionRequest.getTransactionType())
                .currency(transactionRequest.getCurrency())
                .date(transactionRequest.getDate())
                .fromAccount(sourceAccount)
                .toAccount(destinationAccount)
                .build();
        return  transactionRepository.save(transaction);

    }

    public double getBalance(Integer accountNumber){
        return accountRepository.findById(accountNumber)
                .map(account -> (transactionRepository.findPaymentByAccount(account.getId()) - transactionRepository.findPaymentByAccount(account.getId())))
                .orElseThrow(()-> new AccountNotFoundException("Account not found"));
    }
}
