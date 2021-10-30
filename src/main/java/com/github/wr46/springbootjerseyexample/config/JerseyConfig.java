package com.github.wr46.springbootjerseyexample.config;

import com.github.wr46.springbootjerseyexample.resources.TaskResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(TaskResource.class);
    }
}
