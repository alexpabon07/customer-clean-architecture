package co.com.bancolombia.model.customer;
import lombok.*;

@Data
@Builder(toBuilder = true)
public class CustomerDTO {
    private HeaderDTO header;
    private String accountType;
    private String accountNumber;
    private String email;
    private DetailCustomerDTO detailCustomerDTOInformation;
    private String clientDocumentType;
    private String clientDocument;
    private String businessDocumentType;
    private String businessDocument;
    private String clientIp;
    private String channelId;
    private String consumerId;
    private String userAgent;
    private String device;
    private AuthenticationInfoDTO authenticationInfo;
}
