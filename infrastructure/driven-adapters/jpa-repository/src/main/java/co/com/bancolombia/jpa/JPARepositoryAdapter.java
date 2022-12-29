package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.dto.CustomerDTO;
import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<Customer, CustomerDTO, String, JPARepository> implements CustomerRepository
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Customer.class));
    }

    @Override
    public Mono<Customer> getOneCustomer(String clientDocument) {
        return repository.findOneCustomer(clientDocument);
    }
}
