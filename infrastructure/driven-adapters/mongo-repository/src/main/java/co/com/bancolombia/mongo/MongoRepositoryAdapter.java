package co.com.bancolombia.mongo;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import co.com.bancolombia.mongo.dto.CustomerDTO;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Customer, CustomerDTO, String, MongoReactiveRepository> implements CustomerRepository {

    public MongoRepositoryAdapter(MongoReactiveRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Customer.class));
    }

    @Override
    public Mono<Customer> getOneCustomer(String clientDocument) {
        return super.repository.findByClientDocument(clientDocument)
                .doOnNext(e -> {
                    System.out.println(e);
                })
                .flatMap(customerDTO -> {
                    final Customer customer = Customer.builder().accountNumber(customerDTO.getAccountNumber()).build();
                    System.out.println(customer);
                    return Mono.just(customer);
                });
    }
}
