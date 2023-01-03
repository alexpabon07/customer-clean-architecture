package co.com.bancolombia.model.customer;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class AuthenticationInfoDTO {
    private String authenticationtType;
    private List<AuthenticationValueDTO> authenticationValue;
}
