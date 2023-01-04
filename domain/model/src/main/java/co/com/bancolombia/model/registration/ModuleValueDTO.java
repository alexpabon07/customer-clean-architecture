package co.com.bancolombia.model.registration;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ModuleValueDTO {
    private String description;
    private String type;
    private String code;
    private String code2;
    private String section;
}
