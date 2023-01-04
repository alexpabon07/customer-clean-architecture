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
        return Mono.just(serverRequest.queryParam("clientDocument").get())
                .flatMap(clientId -> customerUseCase.getOneCustomer(clientId))
                .flatMap(customerDTO -> ServerResponse.ok().bodyValue(customerDTO));
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        return transformCustomerDTO(serverRequest)
                .flatMap(customerDTO -> customerUseCase.saveCustomer(customerDTO))
                .flatMap(customerDTO -> ServerResponse.ok().bodyValue(customerDTO));
    }

    public Mono<CustomerDTO> transformCustomerDTO(ServerRequest request) {
        return Mono.just(CustomerDTO.builder()
                .build());
    }
}
