package co.com.bancolombia.mongo.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class AuthenticationInfoEntity {
    private String authenticationtType;
    private List<AuthenticationValueEntity> authenticationValue;
}
