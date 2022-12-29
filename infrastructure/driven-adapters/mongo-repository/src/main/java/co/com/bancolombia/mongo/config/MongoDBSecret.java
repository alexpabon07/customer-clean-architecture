package co.com.bancolombia.mongo.config;

import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Builder
@Getter
public class MongoDBSecret {
    @Value("${spring.data.mongodb.uri}")
    private final String uri;
}
