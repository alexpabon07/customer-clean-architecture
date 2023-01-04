package co.com.bancolombia.mongo;

import co.com.bancolombia.mongo.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MongoReactiveRepository extends ReactiveMongoRepository<CustomerEntity, String> {
    @Query("{ 'clientDocument': ?0 }")
    Mono<CustomerEntity> findByClientDocument(String clientDocument);
}
