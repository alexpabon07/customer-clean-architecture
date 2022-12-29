package co.com.bancolombia.model.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Customer {
    private Header header;
    private String accountType;
    private String accountNumber;
    private String email;
    private DetailCustomer detailCustomer;
    private String clientDocumentType;
    private String clientDocument;
    private String businessDocuemntType;
    private String businessDocuemnt;
    private String clientIp;
    private String channelId;
    private String consumerId;
    private String userAgent;
    private String device;
    private AuthenticationInfo authenticationInfo;
}
