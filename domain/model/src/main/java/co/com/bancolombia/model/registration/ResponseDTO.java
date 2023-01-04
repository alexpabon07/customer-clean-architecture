package co.com.bancolombia.model.registration;

import co.com.bancolombia.model.HeaderDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ResponseDTO {
    private HeaderDTO header;
    private ModulesDTO modules;
}
