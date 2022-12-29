package co.com.bancolombia.model.customer;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class AuthenticationInfo {
    private String authenticationType;
    private List<String> authenticationValue;
}
