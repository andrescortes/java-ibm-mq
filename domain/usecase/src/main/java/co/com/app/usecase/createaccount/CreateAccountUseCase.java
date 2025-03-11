package co.com.app.usecase.createaccount;

import co.com.app.model.account.Account;
import co.com.app.model.account.gateways.AccountRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateAccountUseCase {

    private final AccountRepository accountRepository;

    public Mono<Account> create(String name) {
        Account account = Account.builder()
                .name(name)
                .balance(0)
                .build();
        return accountRepository.createAccount(account);
    }
}
