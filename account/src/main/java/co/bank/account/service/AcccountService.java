package co.bank.account.service;

import co.bank.account.model.Account;
import co.bank.account.model.AccountStatus;
import co.bank.account.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class AcccountService {
    private AccountRepository accountRepository;
    private EventService eventService;

    public Account save(Account account){
        Account savedAccount = accountRepository.save(account);
        eventService.sendAccountEvent(savedAccount);
        return savedAccount;
    }

    public Account viewAccount(String accountNumber) throws AccountNotFoundException {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(()-> new AccountNotFoundException("Account not found"));
    }

    public List<Account> viewAll(){
        return accountRepository.findAll();
    }

    public Account updateAccount(Integer id, Account account){
       return  accountRepository.findById(id).map(acc->{
            acc.setEmail(account.getEmail());
            acc.setContactNumber(account.getContactNumber());
            acc.setAccountStatus(account.getAccountStatus());
            return accountRepository.save(acc);
        }).orElseThrow(()-> new co.bank.account.exception.AccountNotFoundException("Account not found exception"));
    }

    public Account updateAccountStatus(Integer id, AccountStatus status){
        return  accountRepository.findById(id).map(account->{
            account.setAccountStatus(status);
            return accountRepository.save(account);
        }).orElseThrow(()-> new co.bank.account.exception.AccountNotFoundException("Account not found exception"));
    }
}
