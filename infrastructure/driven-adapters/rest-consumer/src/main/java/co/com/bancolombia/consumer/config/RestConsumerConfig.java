package co.com.bancolombia.consumer.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.concurrent.TimeUnit;

@Configuration
public class RestConsumerConfig {

    @Value("${adapter.restconsumer.url}")
    private String url;
    @Value("${adapter.restconsumer.timeout}")
    private int timeout;
    @Value("${adapter.restconsumer.readTimeout}")
    private int readTimeout;
    @Value("${adapter.restconsumer.writeTimeout}")
    private int writeTimeout;

    private ClientHttpConnector connector(int timeout, int readTimeout, int writeTimeout) {
        return new ReactorClientHttpConnector(HttpClient.create()
                .resolver(DefaultAddressResolverGroup.INSTANCE)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS
                        , timeout)
                .compress(true)
                .keepAlive(true)
                .doOnConnected(connection -> connection
                        .addHandlerLast(new ReadTimeoutHandler(readTimeout, TimeUnit.MILLISECONDS))
                        .addHandlerLast(new WriteTimeoutHandler(writeTimeout, TimeUnit.MILLISECONDS))));
    }

    @Bean
    public WebClient webClientConfig() {
        return WebClient.builder()
                .clientConnector(connector(
                        timeout,
                        readTimeout,
                        writeTimeout))
                .baseUrl(url)
                .build();
    }
}
