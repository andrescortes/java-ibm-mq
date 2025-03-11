package co.com.app.api;

import lombok.RequiredArgsConstructor;

import java.net.URI;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.app.usecase.createaccount.CreateAccountUseCase;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    // private final UseCase useCase;
    // private final UseCase2 useCase2;
    private final CreateAccountUseCase createAccountUseCase;

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return createAccountUseCase.create("John Doe")
                .flatMap(account -> ServerResponse
                        .created(URI.create("/create"))
                        .bodyValue(account));
    }
}
