package co.bank.transaction.repository;

import co.bank.transaction.model.Account;
import co.bank.transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query(value = "SELECT SUM(amount) from transaction WHERE to_account_id = :account", nativeQuery = true)
    Double findIncomeByAccount(Integer account);

    @Query(value = "SELECT SUM(amount) from transaction WHERE from_account_id = :account", nativeQuery = true)
    Double findPaymentByAccount(Integer account);
}
