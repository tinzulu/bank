package co.bank.account.api;


import co.bank.account.model.Account;
import co.bank.account.model.AccountStatus;
import co.bank.account.model.ResponseHandler;
import co.bank.account.service.AcccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/account")
@AllArgsConstructor
public class AccountController {

    private AcccountService acccountService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Account request){
        Account account = acccountService.save(request);
        return ResponseHandler
                .response("Created successfully", true, HttpStatus.CREATED, account);
    }

    @GetMapping("/byaccountNumber")
    public ResponseEntity<?> getByAccountNumber(@RequestParam("accountNumber")  String accountNumber) throws AccountNotFoundException {
       Account account = acccountService.viewAccount(accountNumber);
       return ResponseHandler.response("Account ", true, HttpStatus.OK, account);
    }

    @GetMapping
    public  ResponseEntity<?> getAll(){
        List<Account> accountList = acccountService.viewAll();
        return ResponseHandler.response("Accounts ", true, HttpStatus.OK,accountList);
    }

    @PutMapping
    public ResponseEntity<?> updateAccount(@RequestParam Integer id, @RequestBody Account request){
        Account account = acccountService.updateAccount(id, request);
        return ResponseHandler.response("Account ", true, HttpStatus.OK, account);
    }

    @PutMapping("/updateStatus")
    public ResponseEntity<?> updateStatus(@RequestParam Integer id, @RequestBody AccountStatus status){
        Account account = acccountService.updateAccountStatus(id, status);
        return ResponseHandler.response("Account ", true, HttpStatus.OK, account);
    }
}
