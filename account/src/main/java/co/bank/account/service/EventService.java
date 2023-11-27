package co.bank.account.service;

import co.bank.account.model.Account;
import lombok.AllArgsConstructor;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Async
@Service
public class EventService {

    private final StreamBridge streamBridge;

    public void sendAccountEvent(Account account) {
        streamBridge.send("bank-out-0", account);
    }
}
