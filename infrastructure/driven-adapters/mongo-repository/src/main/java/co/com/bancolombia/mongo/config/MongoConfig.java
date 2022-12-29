package co.com.bancolombia.mongo.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories
public class MongoConfig {
    @Value("${spring.data.mongodb.database}")
    public String nameDatabase;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create();
    }

    @Bean
    public String getNameDatabase() {
        return nameDatabase;
    }
}
