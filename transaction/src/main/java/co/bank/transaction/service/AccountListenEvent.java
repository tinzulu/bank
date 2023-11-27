package co.bank.transaction.service;

import co.bank.transaction.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;


@Configuration
@Service
public class AccountListenEvent {
    private static final Logger log = LoggerFactory.getLogger(AccountListenEvent.class);
    @Bean
    public Consumer<Account> accountConsumer() {
        return  accountConsumer -> log.debug("Account received {}", accountConsumer);
    }
}
