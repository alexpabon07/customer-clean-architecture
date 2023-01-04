package co.com.bancolombia.consumer.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Header {
    private String id;
    private String type;
}
