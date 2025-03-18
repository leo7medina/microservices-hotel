package com.leodev.eurekaserver.model;

import java.util.Map;


public class EurekaServerProperties {
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
}
