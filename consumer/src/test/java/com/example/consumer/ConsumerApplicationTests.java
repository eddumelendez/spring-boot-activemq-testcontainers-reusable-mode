package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.GenericContainer;

public class ConsumerApplicationTests {

    public static void main(String[] args) {
        SpringApplication.from(ConsumerApplication::main)
                .with(ContainerConfiguration.class)
                .run(args);
    }

    @TestConfiguration
    static class ContainerConfiguration {

        @Bean
        @ServiceConnection(name = "symptoma/activemq")
        @RestartScope
        GenericContainer<?> activeMQContainer() {
            return new GenericContainer<>("symptoma/activemq:5.18.0")
                    .withExposedPorts(61616)
                    .withReuse(true);
        }

    }

}
