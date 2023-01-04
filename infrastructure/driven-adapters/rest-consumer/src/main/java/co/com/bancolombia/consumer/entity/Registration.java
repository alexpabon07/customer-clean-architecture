package co.com.bancolombia.consumer.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Registration {
    private Header header;
    private String module;
    private String section;
    private String consumerId;
    private String channelId;
    private String transactionDate;
}
