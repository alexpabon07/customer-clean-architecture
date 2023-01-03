package co.com.bancolombia.mongo.entity;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
@Getter
@ToString
public class CustomerEntity {
    @Id
    private String id;
    private HeaderEntity header;
    private String accountType;
    private String accountNumber;
    private String email;
    private DetailCustomerEntity detailCustomerInformation;
    private String clientDocumentType;
    private String clientDocument;
    private String businessDocumentType;
    private String businessDocument;
    private String clientIp;
    private String channelId;
    private String consumerId;
    private String userAgent;
    private String device;
    private AuthenticationInfoEntity authenticationInfo;
}
