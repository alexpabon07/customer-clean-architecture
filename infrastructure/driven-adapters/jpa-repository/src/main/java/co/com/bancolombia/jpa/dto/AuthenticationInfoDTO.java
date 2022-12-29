package co.com.bancolombia.jpa.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class AuthenticationInfoDTO {
    private String authenticationType;
    private List<String> authenticationValue;
}
