package co.com.bancolombia.model.registration;

import co.com.bancolombia.model.HeaderDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class RegistrationDTO {
    private HeaderDTO header;
    private String module;
    private String section;
    private String consumerId;
    private String channelId;
    private String transactionDate;
}
