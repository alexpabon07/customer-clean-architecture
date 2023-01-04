package co.com.bancolombia.model.registration.gateways;

import co.com.bancolombia.model.registration.ResponseDTO;
import reactor.core.publisher.Mono;

public interface RegistrationRepository {
    Mono<ResponseDTO> findRegistration();
}
