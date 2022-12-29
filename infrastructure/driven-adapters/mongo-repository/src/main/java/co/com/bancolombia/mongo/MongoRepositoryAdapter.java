package co.com.bancolombia.mongo;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import co.com.bancolombia.mongo.dto.CustomerDTO;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class MongoRepositoryAdapter extends AdapterOperations<Customer, CustomerDTO, String, MongoDBRepository> implements CustomerRepository {

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper, Function<CustomerDTO, Customer> toEntityFn) {
        super(repository, mapper, toEntityFn);
    }

    @Override
    public Mono<Customer> getOneCustomer(String clientDocument) {
        return repository.findByClientDocument(clientDocument);
    }
}
