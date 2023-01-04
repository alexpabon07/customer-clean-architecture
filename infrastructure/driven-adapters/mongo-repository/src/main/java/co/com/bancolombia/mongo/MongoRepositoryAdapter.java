package co.com.bancolombia.mongo;

import co.com.bancolombia.model.customer.*;
import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import co.com.bancolombia.mongo.entity.*;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<CustomerDTO, CustomerEntity, String, MongoReactiveRepository>
        implements CustomerRepository {

    public MongoRepositoryAdapter(MongoReactiveRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, CustomerDTO.class));
    }

    @Override
    public Mono<CustomerDTO> getOneCustomer(String clientDocument) {
        Predicate<CustomerDTO> isTab = customer -> customer.getDetailCustomerDTOInformation().getPaymentFormat().equals("PAB");
        return repository.findByClientDocument(clientDocument)
                .flatMap(this::transformCustomer)
                .filter(isTab);
    }

    @Override
    public Mono<CustomerDTO> saveCustomer(CustomerEntity customerEntity) {
        return repository.save(customerEntity);
    }

    public Mono<CustomerDTO> transformCustomer(CustomerEntity customerEntity) {
        return Mono.just(CustomerDTO.builder()
                .header(transformHeader(customerEntity.getHeader()))
                .accountType(customerEntity.getAccountType())
                .accountNumber(customerEntity.getAccountNumber())
                .email(customerEntity.getEmail())
                .detailCustomerDTOInformation(transformDetailCustomerInformation(customerEntity.getDetailCustomerInformation()))
                .clientDocumentType(customerEntity.getClientDocumentType())
                .clientDocument(customerEntity.getClientDocument())
                .businessDocumentType(customerEntity.getBusinessDocumentType())
                .businessDocument(customerEntity.getBusinessDocument())
                .clientIp(customerEntity.getClientIp())
                .channelId(customerEntity.getChannelId())
                .consumerId(customerEntity.getConsumerId())
                .userAgent(customerEntity.getUserAgent())
                .device(customerEntity.getDevice())
                .authenticationInfo(setValueAuthentication(customerEntity.getAuthenticationInfo())).build()
        );
    }

    public HeaderDTO transformHeader(HeaderEntity headerEntity) {
        return HeaderDTO.builder()
                .id(headerEntity.getId())
                .type(headerEntity.getType())
                .build();
    }

    public DetailCustomerDTO transformDetailCustomerInformation(DetailCustomerEntity detailCustomerEntity) {
        return DetailCustomerDTO.builder()
                .paymentFormat(detailCustomerEntity.getPaymentFormat())
                .paymentApplication(detailCustomerEntity.getPaymentApplication())
                .affectsLotCrediPago(detailCustomerEntity.getAffectsLotCrediPago())
                .noBankOperator(detailCustomerEntity.getNoBankOperator())
                .commissionChargeScheme(detailCustomerEntity.getCommissionChargeScheme())
                .commissionDebitForm(detailCustomerEntity.getCommissionDebitForm())
                .comissionTime(detailCustomerEntity.getComissionTime())
                .pensionsPayingEntity(detailCustomerEntity.getPensionsPayingEntity())
                .noveltyPayrollAccount(detailCustomerEntity.getNoveltyPayrollAccount())
                .schemePaymentReport(detailCustomerEntity.getSchemePaymentReport())
                .generateCheque(detailCustomerEntity.getGenerateCheque())
                .cashPayments(detailCustomerEntity.getCashPayments())
                .formatModality(detailCustomerEntity.getFormatModality())
                .versionTyC(detailCustomerEntity.getVersionTyC())
                .build();
    }

    public AuthenticationInfoDTO setValueAuthentication(AuthenticationInfoEntity authenticationInfoEntity) {

        return AuthenticationInfoDTO.builder()
                .authenticationtType(authenticationInfoEntity.getAuthenticationtType())
                .authenticationValue(authenticationInfoEntity.getAuthenticationValue().stream().map(this::transformAuthenticationValue).collect(Collectors.toList()))
                .build();
    }

    public AuthenticationValueDTO transformAuthenticationValue(AuthenticationValueEntity authenticationValue) {
        return AuthenticationValueDTO.builder()
                .key(authenticationValue.getKey())
                .value(authenticationValue.getValue())
                .build();
    }
}
