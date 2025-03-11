package co.com.app.model.account.gateways;

import co.com.app.model.account.Account;
import reactor.core.publisher.Mono;

public interface AccountRepository {

    Mono<Account> createAccount(Account account);
}
