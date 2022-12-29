package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.dto.CustomerDTO;
import co.com.bancolombia.model.customer.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface JPARepository extends CrudRepository<CustomerDTO, String>, QueryByExampleExecutor<CustomerDTO> {
    @Query("SELECT c FROM Customer c WHERE c.clientDocument = ?")
    Mono<Customer> findOneCustomer(String clientDocument);
}
