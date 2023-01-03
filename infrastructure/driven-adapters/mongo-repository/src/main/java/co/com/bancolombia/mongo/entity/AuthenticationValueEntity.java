package co.com.bancolombia.mongo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class AuthenticationValueEntity {
    private String key;
    private String value;
}
