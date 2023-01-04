package co.com.bancolombia.consumer;

import co.com.bancolombia.consumer.entity.Header;
import co.com.bancolombia.consumer.entity.ModuleValue;
import co.com.bancolombia.consumer.entity.Modules;
import co.com.bancolombia.consumer.entity.Response;
import co.com.bancolombia.model.HeaderDTO;
import co.com.bancolombia.model.registration.ModuleValueDTO;
import co.com.bancolombia.model.registration.ModulesDTO;
import co.com.bancolombia.model.registration.ResponseDTO;
import co.com.bancolombia.model.registration.gateways.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestConsumer  implements RegistrationRepository {

    @Value("${adapter.restconsumer.url}")
    private String uri;

    private final WebClient client;

    @Override
    public Mono<ResponseDTO> findRegistration() {
        return client.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Response.class)
                .retry(3)
                .flatMap(this::transformResponse);
    }

    public Mono<ResponseDTO> transformResponse(Response response) {
        return Mono.just(ResponseDTO.builder()
                        .header(transformHeader(response.getHeader()))
                        .modules(transformModules(response.getModules()))
                .build());
    }

    public HeaderDTO transformHeader(Header header) {
        return HeaderDTO.builder()
                .id(header.getId())
                .type(header.getType())
                .build();
    }

    public ModulesDTO transformModules(Modules modules) {
        return ModulesDTO.builder()
                .module(modules.getModule())
                .moduleValue(modules.getModuleValue().stream().map(this::transformModuleValue).collect(Collectors.toList()))
                .build();
    }

    public ModuleValueDTO transformModuleValue(ModuleValue moduleValue) {
        return ModuleValueDTO.builder()
                .description(moduleValue.getDescription())
                .type(moduleValue.getType())
                .code(moduleValue.getCode())
                .code2(moduleValue.getCode2())
                .section(moduleValue.getSection())
                .build();
    }
}