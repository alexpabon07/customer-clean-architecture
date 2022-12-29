package co.com.bancolombia.jpa.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder(toBuilder = true)
@Entity
@Table(name = "customer")
public class CustomerDTO {
    private HeaderDTO header;
    private String accountType;
    private String accountNumber;
    private String email;
    private DetailCustomerDTO detailCustomer;
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
