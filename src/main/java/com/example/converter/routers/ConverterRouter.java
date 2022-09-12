package com.example.converter.routers;

import com.example.converter.handlers.ConverterHandler;
import com.example.converter.services.ConverterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;

@Configuration
@EnableWebFlux
public class ConverterRouter implements WebFluxConfigurer {
    @Bean
    public RouterFunction<ServerResponse> converterAPI(ConverterHandler converterHandler){
        return route()
                .POST("/converter/",converterHandler::createConversion,ops->ops.beanClass(ConverterService.class).beanMethod("createConversion"))
                .GET("/converter/",converterHandler::getConversion, ops-> ops.beanClass(ConverterService.class).beanMethod("getConversion"))
                .build();
    }
}
