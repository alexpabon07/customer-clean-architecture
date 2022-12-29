package co.com.bancolombia.config;

import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import co.com.bancolombia.usecase.customer.CustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "co.com.bancolombia")
public class UseCasesConfig {

    @Bean
    public CustomerUseCase customerUseCase(CustomerRepository customerRepository) {
        return new CustomerUseCase(customerRepository);
    }
}
