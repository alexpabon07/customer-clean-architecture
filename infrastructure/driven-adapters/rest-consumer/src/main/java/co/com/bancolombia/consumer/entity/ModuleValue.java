package co.com.bancolombia.consumer.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ModuleValue {
    private String description;
    private String type;
    private String code;
    private String code2;
    private String section;
}
