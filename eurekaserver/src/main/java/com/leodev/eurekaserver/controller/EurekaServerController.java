package com.leodev.eurekaserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.leodev.eurekaserver.config.EurekaConfiguration;
import com.leodev.eurekaserver.model.EurekaServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaServerController {

    @Autowired
    private EurekaConfiguration eurekaConfiguration;

    @GetMapping("/eureka/read/properties")
    public String getProperties() throws JsonProcessingException {
        ObjectWriter owj = new ObjectMapper().writer().withDefaultPrettyPrinter();
        EurekaServerProperties eurekaServerProperties = new EurekaServerProperties();
        eurekaServerProperties.setInstance(eurekaConfiguration.getInstance());
        eurekaServerProperties.setClient(eurekaConfiguration.getClient());
        return owj.writeValueAsString(eurekaServerProperties);
    }
}
