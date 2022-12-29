package co.com.bancolombia.usecase.customer;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class CustomerUseCase {

    CustomerRepository customerRepository;

    public Mono<Customer> getOneCustomer(String clientDocument) {
        return customerRepository.getOneCustomer(clientDocument);
    }
}
