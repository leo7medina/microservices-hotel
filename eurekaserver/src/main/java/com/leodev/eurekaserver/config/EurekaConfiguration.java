package com.leodev.eurekaserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "eurekaserver")
public class EurekaConfiguration {

    private Map<String, String> instance;
    private Map<String, String> client;

    public Map<String, String> getInstance() {
        return instance;
    }

    public void setInstance(Map<String, String> instance) {
        this.instance = instance;
    }

    public Map<String, String> getClient() {
        return client;
    }

    public void setClient(Map<String, String> client) {
        this.client = client;
    }

    public EurekaConfiguration(Map<String, String> instance, Map<String, String> client) {
        this.instance = instance;
        this.client = client;
    }
    public EurekaConfiguration() {}
}
