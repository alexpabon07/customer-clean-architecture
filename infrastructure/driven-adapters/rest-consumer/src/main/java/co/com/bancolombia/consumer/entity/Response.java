package co.com.bancolombia.consumer.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Response {
    private Header header;
    private Modules modules;
}
