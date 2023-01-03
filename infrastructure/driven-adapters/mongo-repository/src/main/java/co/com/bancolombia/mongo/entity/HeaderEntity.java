package co.com.bancolombia.mongo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class HeaderEntity {
    private String id;
    private String type;
}
