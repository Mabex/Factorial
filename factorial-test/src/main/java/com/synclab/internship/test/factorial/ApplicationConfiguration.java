package com.synclab.internship.test.factorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.concurrent.Executor;

@Configuration
public class ApplicationConfiguration {

    private Environment env;

    @Autowired
    ApplicationConfiguration(Environment env) {
        this.env = env;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Executor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // By setting corePoolSize and maximumPoolSize the same, you create a fixed-size thread pool.
        executor.setCorePoolSize( Integer.parseInt(Objects.requireNonNull(env.getProperty("app.maxThreads"))) );
        executor.setMaxPoolSize( Integer.parseInt(Objects.requireNonNull(env.getProperty("app.maxThreads"))) );
        executor.setQueueCapacity(500);
        executor.initialize();
        return executor;
    }
}
