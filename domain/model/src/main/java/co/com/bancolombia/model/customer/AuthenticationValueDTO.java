package co.com.bancolombia.model.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class AuthenticationValueDTO {
    private String key;
    private String value;
}
