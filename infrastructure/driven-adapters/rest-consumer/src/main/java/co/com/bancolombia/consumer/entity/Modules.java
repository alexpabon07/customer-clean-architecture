package co.com.bancolombia.consumer.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Modules {

    private String module;
    private List<ModuleValue> moduleValue;
}
