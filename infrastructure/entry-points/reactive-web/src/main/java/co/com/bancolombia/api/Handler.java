package co.com.bancolombia.api;

import co.com.bancolombia.model.customer.CustomerDTO;
import co.com.bancolombia.usecase.customer.CustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final CustomerUseCase customerUseCase;

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        Mono<CustomerDTO> customerFoundMono = customerUseCase
                .getOneCustomer(serverRequest.queryParam("clientDocument").toString());

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(customerFoundMono, CustomerDTO.class);
    }
}
