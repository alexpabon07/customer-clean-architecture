package co.com.bancolombia.usecase.registration;

import co.com.bancolombia.model.registration.ResponseDTO;
import co.com.bancolombia.model.registration.gateways.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RegistrationUseCase {

    private RegistrationRepository registrationRepository;

    public Mono<ResponseDTO> findRegistration() {
        return registrationRepository.findRegistration();
    }
}
