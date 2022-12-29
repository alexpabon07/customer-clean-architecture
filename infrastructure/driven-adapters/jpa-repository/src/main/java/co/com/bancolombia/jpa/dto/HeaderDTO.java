package co.com.bancolombia.jpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class HeaderDTO {
    private String id;
    private String type;
}
