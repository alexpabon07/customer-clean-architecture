package co.com.bancolombia.model.registration;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class ModulesDTO {
    private String module;
    private List<ModuleValueDTO> moduleValue;
}
