package co.bank.transaction.api;

import co.bank.transaction.model.ResponseHandler;
import co.bank.transaction.model.Transaction;
import co.bank.transaction.model.TransactionRequest;
import co.bank.transaction.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/transaction")
@AllArgsConstructor
public class TransactionController {
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TransactionRequest request){
        Transaction transaction = transactionService.save(request);
        return ResponseHandler
                .response("Created successfully", true, HttpStatus.CREATED, transaction);
    }

    @GetMapping("balance")
    public ResponseEntity<?> getBalance(@RequestParam("id") Integer accountId){
        Double balance = transactionService.getBalance(accountId);
        return  ResponseHandler.response("Account Balance", true, HttpStatus.OK, balance);
    }
}
