package co.com.bancolombia.api;

import co.com.bancolombia.usecase.customer.CustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private  final CustomerUseCase customerUseCase;

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue(customerUseCase.getOneCustomer(serverRequest.queryParam("clientDocument").toString()));
    }
}
