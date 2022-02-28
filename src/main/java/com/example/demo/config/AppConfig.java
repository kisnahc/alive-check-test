package com.example.demo.config;

import org.atto.alivecheck.AliveCheckManager;
import org.atto.alivecheck.impl.AliveCheckManagerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public AliveCheckManager aliveCheckManager() {
        return new AliveCheckManagerImpl();
    }
}
