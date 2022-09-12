package com.example.converter.services;


import com.example.converter.dto.ConverterDto;
import com.example.converter.entities.Converter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
public interface IConverterService {
    Flux<Converter> getConversion();
    Mono<Converter> createConversion(ConverterDto converterDto) throws IOException;
}
