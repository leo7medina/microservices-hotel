package com.leodev.hotels.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "hotels")
@Data
public class HotelsPropertiesConfiguration {
    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
}
