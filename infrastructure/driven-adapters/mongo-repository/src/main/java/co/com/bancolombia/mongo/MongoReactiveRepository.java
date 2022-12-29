package co.com.bancolombia.mongo;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.mongo.dto.CustomerDTO;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MongoReactiveRepository extends ReactiveMongoRepository<CustomerDTO, String> {
    @Query("{ 'clientDocument': ?0 }")
    Mono<Customer> findByClientDocument(String clientDocument);
}
