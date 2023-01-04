package co.com.bancolombia.model.customer.gateways;

import co.com.bancolombia.model.customer.CustomerDTO;
import reactor.core.publisher.Mono;

public interface CustomerRepository {
    public Mono<CustomerDTO> getOneCustomer(String clientDocument);
    public Mono<CustomerDTO> saveCustomer(CustomerDTO customerDTO);
}
