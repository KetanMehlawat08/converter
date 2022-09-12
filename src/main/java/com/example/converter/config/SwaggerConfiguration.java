package com.example.converter.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public GroupedOpenApi conversionOpenAPI()
    {
        var paths = new String[]{"/converter/"};
        return GroupedOpenApi.builder().group("converter").pathsToMatch(paths).build();
    }
}
