package co.com.bancolombia.usecase.customer;

import co.com.bancolombia.model.customer.CustomerDTO;
import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class CustomerUseCase {

    final CustomerRepository customerRepository;

    public Mono<CustomerDTO> getOneCustomer(String clientDocument) {
        return customerRepository.getOneCustomer(clientDocument);
    }

    public Mono<CustomerDTO> saveCustomer(CustomerDTO customerDTO) {
        return customerRepository.saveCustomer(customerDTO);
    }
}
