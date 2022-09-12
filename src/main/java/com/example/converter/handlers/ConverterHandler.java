package com.example.converter.handlers;

import com.example.converter.dto.ConverterDto;
import com.example.converter.entities.Converter;
import com.example.converter.services.IConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Component
public class ConverterHandler {

    @Autowired
    private IConverterService converterService;

    public Mono<ServerResponse> getConversion(ServerRequest serverRequest){
        String conversionId=serverRequest.pathVariable("conversionId");
        return ServerResponse.ok().body(converterService.getConversion(conversionId), Converter.class);
    }
    public Mono<ServerResponse> createConversion(ServerRequest serverRequest){
        var conversionDTOMono=serverRequest.bodyToMono(ConverterDto.class);

        return conversionDTOMono.flatMap(converterDto -> {
            try {
                return
                        ServerResponse.status(HttpStatus.CREATED)
                                .body(converterService.createConversion(converterDto),Converter.class);
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        });
    }
}
